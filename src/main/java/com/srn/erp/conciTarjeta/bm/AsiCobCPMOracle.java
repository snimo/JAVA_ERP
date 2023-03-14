package com.srn.erp.conciTarjeta.bm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;

import oracle.jdbc.pool.OracleDataSource;

import com.srn.erp.cip.bm.UtilCIP;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class AsiCobCPMOracle {

	private static OracleDataSource ods = null;

	private ISesion sesion;
	private String cadenaConexionBD;
	private String usuario;
	private String clave;
	private CabAsiTarjACobrar cabAsiTarjACobrar;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCadenaConexionBD() {
		return cadenaConexionBD;
	}

	public void setCadenaConexionBD(String cadenaConexionBD) {
		this.cadenaConexionBD = cadenaConexionBD;
	}

	public CabAsiTarjACobrar getCabAsiTarjACobrar() {
		return cabAsiTarjACobrar;
	}

	public void setCabAsiTarjACobrar(CabAsiTarjACobrar cabAsiTarjACobrar) {
		this.cabAsiTarjACobrar = cabAsiTarjACobrar;
	}

	

	public ISesion getSesion() {
		return sesion;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}
	
	private String armarAsiento(Connection conexion) throws BaseException {
		// Insertar los Movimientos
		return insMovimientos(conexion);
	}
	
	private String insMovimientos(Connection conexion) throws BaseException {
		// Insertar Movimientos
		String refExt = "";
		
		try {
			
			StringBuffer sql = new StringBuffer("");
			sql.append("insert into ATLANTIS.movimientos ");
			sql.append("(empresa,");
			sql.append("codigo_documento,");
			sql.append("unidad_contable,");
			sql.append("fecha_documento,");
			sql.append("numero_documento,");
			sql.append("numero_linea,");
			sql.append("cuenta,");
			sql.append("estructura,");
			sql.append("personalizacion,");
			sql.append("importe,");
			sql.append("signo,");
			sql.append("aviso,");
			sql.append("punteo,");
			sql.append("fecha_traspaso) ");
			sql.append(" values ");
			sql.append(" (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			
			String codEmpresa = getCodEmpresa();
			if (codEmpresa.equals("")) throw new ExceptionValidation(null,"No se pudo contabilizar en ATLANTIS. Verificar código de Interfaz de empresa.");
			
			String codDocumento = getCodDocumento(); 
			if (codDocumento.equals("")) throw new ExceptionValidation(null,"No se pudo contabilizar en ATLANTIS. Verificar que este cargado el Tipo de Documento de la empresa del Asiento de Cobranza.");
			
			String unidadContable = getUnidadContable(); 
			if (codDocumento.equals("")) throw new ExceptionValidation(null,"No se pudo contabilizar en ATLANTIS. Verificar que este cargada la unidad contable de la empresa del Asiento de Cobranza.");			
			
			// Obtener el Proximo Numero de Documento
			int nroDocumento = getNewNroDocu(
									conexion, 
									this.getCabAsiTarjACobrar().getFec_asiento(), 
									codEmpresa,
									codDocumento,
									unidadContable);
			
			refExt = codEmpresa+"-"+codDocumento+"-"+unidadContable+"-"+Fecha.getddmmyyyy(this.getCabAsiTarjACobrar().getFec_asiento())+"-"+nroDocumento;
			
			int nroLinea = 0;
			
			Iterator iterDetAsientos = 
				this.getCabAsiTarjACobrar().getDetallesAsiento().iterator();
			while (iterDetAsientos.hasNext()) {
				DetAsiTarjACobrar detAsiTarjACobrar = (DetAsiTarjACobrar) iterDetAsientos.next();
				
				PreparedStatement sta = conexion.prepareStatement(sql.toString());
				sta.setString(1, codEmpresa);
				sta.setString(2, codDocumento);
				sta.setString(3, unidadContable);
				sta.setDate(4, new java.sql.Date(this.getCabAsiTarjACobrar().getFec_asiento().getTime()));
				sta.setString(5, new Integer(nroDocumento).toString());
				sta.setInt(6, nroLinea);
				sta.setString(7, detAsiTarjACobrar.getCuenta());
				sta.setString(8, detAsiTarjACobrar.getCompo1());
				sta.setString(9, detAsiTarjACobrar.getCompo2());
				sta.setDouble(10, detAsiTarjACobrar.getImporte());
				sta.setString(11, detAsiTarjACobrar.getD_H());
				sta.setString(12, "E"); // Para que ingrese con estado ERROR
				sta.setNull(13, Types.VARCHAR);
				sta.setDate(14,new java.sql.Date(UtilCIP.getFechaHoraActual(this.getSesion()).getTime()));
				
				sta.executeUpdate();
				sta.close();
				
				insComenPorLinea(
						conexion,
						codEmpresa,
						codDocumento,
						unidadContable,
						this.getCabAsiTarjACobrar().getFec_asiento(),
						nroDocumento,
						nroLinea,
						getCabAsiTarjACobrar().getComentario());
				
				++nroLinea;
			}
			

			// Volver a actualizar los detalles del archivo
			Iterator iterArchDet = 
				ArchLoteConciDet.getArchLoteDetContaConSegunNroAsi(this.getCabAsiTarjACobrar().getOIDInteger(),this.getSesion()).iterator();
			while (iterArchDet.hasNext()) {
				ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchDet.next();
				archLoteConciDet.supportRefresh();
				archLoteConciDet.setRefSistExt(refExt);
				archLoteConciDet.save();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new ExceptionValidation(null,"Se produjo un error al grabar el asiento de Cobranza."); 
		}
		
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return refExt;
	}
	
	private int getNewNroDocu(
			Connection conexion,
			java.util.Date fecAsiento,
			String codEmpresa,
			String codDocumento,
			String unidadContable) throws BaseException {
		
		// Obtener la Fecha Desde correspondiente a dia 1 del mes
		int ultDiaDelMes = Fecha.getUltimoDiaMesFechaDada(fecAsiento);
		int mes 		 = Fecha.getMes(fecAsiento);
		int anio 		 = Fecha.getAnio(fecAsiento);
		
		java.util.Date fecUltDiaMes = Fecha.getFecha(ultDiaDelMes, mes, anio);
		java.util.Date fecPrimerDiaMes = Fecha.getFecha(1, mes, anio);
				
		StringBuffer sql = new StringBuffer("");
		sql.append("select nvl(max(to_number(numero_documento)),0) nro_docu from atlantis.movimientos ");
		sql.append(" where ");
		sql.append(" empresa = ? and codigo_documento = ? and unidad_contable = ? and fecha_documento>=? and fecha_documento<=?  ");
		
		try {
			PreparedStatement sta = conexion.prepareStatement(sql.toString());
			sta.setString(1, codEmpresa);
			sta.setString(2, codDocumento);
			sta.setString(3, unidadContable);
			sta.setDate(4, new java.sql.Date(fecPrimerDiaMes.getTime()));
			sta.setDate(5, new java.sql.Date(fecUltDiaMes.getTime()));
			
			
			ResultSet rs = sta.executeQuery();
			int ultNro = 0;
			if (rs.next())
				ultNro = rs.getInt("nro_docu");
			++ultNro;
			return ultNro; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Obtener la Fecha Hasta correspondiente al ultimo dia del mes
		
		return 0;
	}

	public String generarAsiento() throws BaseException {
		inicializarORACLE();
		try {
			Connection conexion = getConnection();
			conexion.setAutoCommit(false);
			try {
				return armarAsiento(conexion);
				
			} finally {
				freeConnection(conexion);
				//ods.close();
				//ods = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
		
	}

	private void inicializarORACLE() {

		if (ods != null)
			return;
		
		
		java.util.Properties prop = new java.util.Properties();
		prop.setProperty("MinLimit", "1"); // the cache size is 5 at least
		prop.setProperty("MaxLimit", "2");
		prop.setProperty("InitialLimit", "2"); // create 5 connections at
		prop.setProperty("ConnectionWaitTimeout", "10");
		try {
			ods = new OracleDataSource();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ods.setURL(cadenaConexionBD);
		ods.setUser(usuario);
		ods.setPassword(clave);
		try {
			ods.setConnectionCachingEnabled(true);
			ods.setConnectionCacheProperties(prop); // set properties
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	  public Connection getConnection() throws SQLException {
		    return ods.getConnection();
	  }

	  public void freeConnection(Connection conexion) throws SQLException {
		    conexion.close();
	  }	
	  
	  
	  public String getCodEmpresa() throws BaseException {
		  Iterator iterArchLoteDet = 
			  ArchLoteConciDet.getArchLoteDetContaConSegunNroAsi(this.getCabAsiTarjACobrar().getOIDInteger(),this.getSesion()).iterator();
		  while (iterArchLoteDet.hasNext()) {
			  ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteDet.next();
			  return archLoteConciDet.getEmpresa().getCodEmpInterfaz();
		  }
		  return "";
	  }
	  
	  public String getCodDocumento() throws BaseException {
		  Iterator iterArchLoteDet = 
			  ArchLoteConciDet.getArchLoteDetContaConSegunNroAsi(this.getCabAsiTarjACobrar().getOIDInteger(),this.getSesion()).iterator();
		  while (iterArchLoteDet.hasNext()) {
			  ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteDet.next();
			  return archLoteConciDet.getEmpresa().getTipoDocuAsiCobranza();
		  }
		  return "";
	  }	  
	  
	  public String getUnidadContable() throws BaseException {
		  Iterator iterArchLoteDet = 
			  ArchLoteConciDet.getArchLoteDetContaConSegunNroAsi(this.getCabAsiTarjACobrar().getOIDInteger(),this.getSesion()).iterator();
		  while (iterArchLoteDet.hasNext()) {
			  ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteDet.next();
			  return archLoteConciDet.getEmpresa().getUniContaAsiCobranza();
		  }
		  return "";
	  }
	  
		private void insComenPorLinea(
				Connection conexion,
				String empresa,
				String codigoDocu,
				String unidadContable,
				java.util.Date fecDocu,
				Integer nroDocu,
				Integer nroLinea,
				String comentario) throws BaseException {
			
			// Grabar comentario
			
			StringBuffer sqlInsComentario = new StringBuffer("");
			sqlInsComentario.append("insert into ATLANTIS.ref_texto ");
			sqlInsComentario.append(" ( ");
			sqlInsComentario.append(" empresa, ");
			sqlInsComentario.append(" codigo_documento, ");
			sqlInsComentario.append(" unidad_contable, ");
			sqlInsComentario.append(" fecha_documento, ");
			sqlInsComentario.append(" numero_documento, ");
			sqlInsComentario.append(" numero_linea, ");
			sqlInsComentario.append(" texto ");
			sqlInsComentario.append(" ) ");
			sqlInsComentario.append(" values ");
			sqlInsComentario.append(" (?, ");
			sqlInsComentario.append(" ?, ");
			sqlInsComentario.append(" ?, ");
			sqlInsComentario.append(" ?, ");
			sqlInsComentario.append(" ?, ");
			sqlInsComentario.append(" ?, ");
			sqlInsComentario.append(" ?) ");
			
			PreparedStatement sta;
			try {
				sta = conexion.prepareStatement(sqlInsComentario.toString());
				sta.setString(1, empresa);
				sta.setString(2, codigoDocu);
				sta.setString(3, unidadContable);
				sta.setDate(4, new java.sql.Date(fecDocu.getTime()));
				sta.setString(5, new Integer(nroDocu).toString());
				sta.setInt(6, nroLinea);
				if (comentario!=null)
					sta.setString(7, comentario);
				else
					sta.setString(7, "");
				sta.executeUpdate();
				sta.close();
				sta = null;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"No se pudo generar Asiento en ATLANTIS");
			}
			
		}	  
	  

}
