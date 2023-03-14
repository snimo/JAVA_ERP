package com.srn.erp.rrhh.op;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import oracle.jdbc.pool.OracleDataSource;

import com.srn.erp.cip.bm.EmpresaPayroll;
import com.srn.erp.cip.bm.RTablasPayroll;
import com.srn.erp.cip.bm.RemplesPayroll;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.ClaseSindicato;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;
import com.srn.erp.rrhh.bm.EstrucNivPuesto;
import com.srn.erp.rrhh.bm.EstrucNivSector;
import com.srn.erp.rrhh.bm.GradoLegajo;
import com.srn.erp.rrhh.bm.HistoricoPuesto;
import com.srn.erp.rrhh.bm.MotivoEgresoEmp;
import com.srn.erp.rrhh.bm.MotivoFaltaRRHH;
import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.bm.TareaDesempeneada;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.ventas.bm.EstadoCivil;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ImpLegPAYROLL extends Operation {

	Connection conn = null;
	java.util.Date fec1_1_3000 = null;

	public ImpLegPAYROLL() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String fdt = "dd/MM/yyyy"; // mascara que utiliza
		SimpleDateFormat sdf = new SimpleDateFormat(fdt);
		fec1_1_3000 = null;
		try {
			fec1_1_3000 = sdf.parse("01/01/3000");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// Conectarse al sistema PAYROLL
		tomarConexion();
		try {

			
			importarDatosEstructura(conn);
			importarDatosTBCASTNN(conn);
			actualizarTipoNovedad();
			importarDatosPAYMotNov(conn);
			
			actualizarMotivosNovedades();
			importarDatosNovedades(conn);

			importarRemples();
			
			actualizarEstadosCiviles(conn);
			actualizarSindicatos(conn);
			importarDatosEmpresa(conn);
			importarDatosRTablas(conn);
			actualizarValClasif();
			importarDatosSanciones(conn);
			importarDatosTablaPayTbglmnov(conn);
			actualizarGradosLegajo();
			
			actualizarMotivosEgreso();
			actualizarMotivosFalta();
			actualizarMotivosSancion();
			actualizarTiposdeDocumentos();
			actualizarLegajos();
			
			actualizarTareasDesempeneadas();
			
			importarDatosHistPuestos(conn);
			actualizarSancionesLegajos();
			actualizarServicioMedico();
			actualizarNovedades();
			
			importarEstructura();

			

		} finally {
			liberarConexion();
		}
	}

	private void limpiarRemples() throws BaseException {

		try {
			Statement staTruncateRemples = this.getSesion().getConexionBD().createStatement();
			staTruncateRemples.executeUpdate("truncate table payRemples");
			staTruncateRemples.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void importarEstructura() throws BaseException {

		try {

			ClasificadorEntidad clasifEmpresa = this.getClasifEmpresa(this.getSesion());
			ClasificadorEntidad clasifSector = this.getClasifSector(this.getSesion());
			ClasificadorEntidad clasifPuesto = this.getClasifPuesto(this.getSesion());
			
			
			PreparedStatement psEmpresas = getSesion().getConexionBD().prepareStatement("select distinct empresa from PAYESTRUCTURA");
			ResultSet rsEmpresas = psEmpresas.executeQuery();
			while (rsEmpresas.next()) {
				
				String codEmpresa = rsEmpresas.getString("empresa");
				
				ValorClasificadorEntidad valClasifEmp = ValorClasificadorEntidad.getValorClasifEnt(clasifEmpresa, codEmpresa, this.getSesion());
				
				if (valClasifEmp == null) continue;
				
				// Verificar si existe la estructura si no darla de alta
				EstrucNivEmpresa estrucNivEmpresa = EstrucNivEmpresa.getEstrucNivEmpresa(valClasifEmp, this.getSesion());
				if (estrucNivEmpresa == null) {
					estrucNivEmpresa = (EstrucNivEmpresa) EstrucNivEmpresa.getNew(EstrucNivEmpresa.NICKNAME, this.getSesion());
					estrucNivEmpresa.setValor_clasif_empresa(valClasifEmp);
				}
				estrucNivEmpresa.setActivo(true);
				estrucNivEmpresa.save();
				
				// Para esa empresa obtener todos los sectores correspondientes
				//select distinct cencos from payremples where empresa = '12'
				PreparedStatement psSectores = getSesion().getConexionBD().prepareStatement("select distinct cencos from PAYESTRUCTURA where empresa = ?");
				psSectores.setString(1, codEmpresa);
				ResultSet rsSectores = psSectores.executeQuery();
				while (rsSectores.next()) {
					int cencos = rsSectores.getInt("cencos");
					
					ValorClasificadorEntidad valClasifSec = ValorClasificadorEntidad.getValorClasifEnt(clasifSector, cencos+"", this.getSesion());
					
					if (valClasifSec == null) continue;
					
					EstrucNivSector estrucNivSector = 
						EstrucNivSector.getEstrucNivSector(estrucNivEmpresa, valClasifSec, this.getSesion());
					if (estrucNivSector ==  null) {
						estrucNivSector = (EstrucNivSector) EstrucNivSector.getNew(EstrucNivSector.NICKNAME, this.getSesion());
						estrucNivSector.setOid_estruc_emp(estrucNivEmpresa);
						estrucNivSector.setValor_clasif_sector(valClasifSec);
					}
					estrucNivSector.setActivo(true);
					estrucNivSector.save();
					
					// Obtener los Puestos
					PreparedStatement psPuestos = getSesion().getConexionBD().prepareStatement("select distinct cargo from PAYESTRUCTURA where empresa = ? and cencos = ?");
					psPuestos.setString(1, codEmpresa);
					psPuestos.setInt(2, cencos);
					ResultSet rsPuestos = psPuestos.executeQuery();
					while (rsPuestos.next()) {
						
						int cargo = rsPuestos.getInt("cargo");
						
						ValorClasificadorEntidad valClasifPue = ValorClasificadorEntidad.getValorClasifEnt(clasifPuesto, cargo+"", this.getSesion());
						
						if (valClasifPue == null) continue;
						
						
						EstrucNivPuesto estrucNivPuesto = EstrucNivPuesto.getEstrucNivPuesto(estrucNivSector, valClasifPue, this.getSesion());
						if (estrucNivPuesto == null) {
							estrucNivPuesto = (EstrucNivPuesto) EstrucNivPuesto.getNew(EstrucNivPuesto.NICKNAME, this.getSesion());
							estrucNivPuesto.setOid_estruc_sector(estrucNivSector);
							estrucNivPuesto.setValor_clasif_puesto(valClasifPue);
						}
						estrucNivPuesto.setActivo(true);
						estrucNivPuesto.save();
						
					}
					
					psPuestos.close();
					rsPuestos.close();
					
					
					
				}
				
				rsSectores.close();
				psSectores.close();
			
			}
			
			rsEmpresas.close();
			psEmpresas.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void importarRemples() throws BaseException {
		try {

			limpiarRemples();

			Statement staQueryRemples = conn.createStatement();
			ResultSet rsRemples = staQueryRemples
					.executeQuery("select RUT, SEXO , DIRECCION , EST_CIVIL ,FECHA_NAC, TIPO_DOC , NUMDOC , FONO , CELULAR , CLASE , FECHA_GRA , MOTI_RET , FECHA_ISA , FECHA_XTR , CODIGO, ESTADO , EMPRESA , NOMBRE , FECHA_ING , FECHA_RET , CENCOS , CREDENC , CARGO , GRADO , SECCION from payroll.remples");
			while (rsRemples.next()) {

				String codigo = rsRemples.getString("codigo");
				String estado = rsRemples.getString("estado");
				String empresa = rsRemples.getString("empresa");
				String nombre = rsRemples.getString("nombre");
				String cuit = rsRemples.getString("RUT");
				String sexo = rsRemples.getString("SEXO");
				String direccion = rsRemples.getString("DIRECCION");
				String estCivil = rsRemples.getString("EST_CIVIL");
				
				if (estCivil!=null)
					estCivil = estCivil.trim();

				java.util.Date fecNaci = null;
				if ((rsRemples.getDate("FECHA_NAC") != null) && (!rsRemples.getDate("FECHA_NAC").equals(fec1_1_3000)))
					fecNaci = rsRemples.getDate("FECHA_NAC");

				Integer tipoDoc = rsRemples.getInt("TIPO_DOC");
				String nroDocu = rsRemples.getString("NUMDOC");
				String telefono = rsRemples.getString("FONO");
				String celular = rsRemples.getString("CELULAR");
				Integer clase = rsRemples.getInt("CLASE");

				java.util.Date fecIngReal = null;
				if ((rsRemples.getDate("FECHA_GRA") != null) && (!rsRemples.getDate("FECHA_GRA").equals(fec1_1_3000)))
					fecIngReal = rsRemples.getDate("FECHA_GRA");

				Integer codMotivoRet = rsRemples.getInt("MOTI_RET");

				java.util.Date fecProteccion = null;
				if ((rsRemples.getDate("FECHA_ISA") != null) && (!rsRemples.getDate("FECHA_ISA").equals(fec1_1_3000)))
					fecProteccion = rsRemples.getDate("FECHA_ISA");

				java.util.Date fecIngUTE = null;
				if ((rsRemples.getDate("FECHA_XTR") != null) && (!rsRemples.getDate("FECHA_XTR").equals(fec1_1_3000)))
					fecIngUTE = rsRemples.getDate("FECHA_XTR");

				java.util.Date fecAntReconocida = null;
				if ((rsRemples.getDate("fecha_ing") != null) && (!rsRemples.getDate("fecha_ing").equals(fec1_1_3000)))
					fecAntReconocida = rsRemples.getDate("fecha_ing");

				java.util.Date fecEgreso = null;
				if ((rsRemples.getDate("fecha_ret") != null) && (!rsRemples.getDate("fecha_ret").equals(fec1_1_3000)))
					fecEgreso = rsRemples.getDate("fecha_ret");

				int cencos = rsRemples.getInt("cencos");
				String credenc = rsRemples.getString("credenc");
				int cargo = rsRemples.getInt("cargo");
				int grado = rsRemples.getInt("GRADO");
				int seccion = rsRemples.getInt("SECCION"); 

				RemplesPayroll remplesPayroll = (RemplesPayroll) RemplesPayroll.getNew(RemplesPayroll.NICKNAME, this.getSesion());
				remplesPayroll.setDesHabEventoWFAfterNew(true);
				if (codigo != null)
					remplesPayroll.setCodigo(codigo.trim());
				remplesPayroll.setEstado(estado);
				if (empresa != null)
					remplesPayroll.setEmpresa(empresa.trim());
				if (nombre != null)
					remplesPayroll.setNombre(nombre.trim());
				remplesPayroll.setFecha_ing(fecIngReal);
				remplesPayroll.setFecha_ret(fecEgreso);
				remplesPayroll.setCencos(cencos);
				if (credenc != null)
					remplesPayroll.setCredenc(credenc.trim());
				remplesPayroll.setCargo(cargo);

				remplesPayroll.setRUT(cuit);
				remplesPayroll.setSexo(sexo);
				remplesPayroll.setDireccion(direccion);
				remplesPayroll.setEstadoCivil(estCivil);
				remplesPayroll.setFecNacimiento(fecNaci);
				remplesPayroll.setTipoDocumento(tipoDoc);
				remplesPayroll.setNroDocumento(nroDocu);
				remplesPayroll.setTelParticular(telefono);
				remplesPayroll.setTelCelular(celular);
				remplesPayroll.setClaseSindicato(clase);
				remplesPayroll.setMotivoEgresoEmp(codMotivoRet);
				remplesPayroll.setFecVencProt(fecProteccion);
				remplesPayroll.setFecIngUTE(fecIngUTE);
				remplesPayroll.setFecAntReconocida(fecAntReconocida);
				remplesPayroll.setGrado(grado);
				remplesPayroll.setSeccion(seccion);
				

				remplesPayroll.setActivo(true);
				remplesPayroll.save();

			}

			rsRemples.close();
			staQueryRemples.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void liberarConexion() throws BaseException {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void tomarConexion() throws BaseException {
		OracleDataSource ods = null;
		try {
			ods = new OracleDataSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ods.setURL(getURLConexionPAYROLL(this.getSesion()));
		ods.setUser(getUsuarioPAYROLL(this.getSesion()));
		ods.setPassword(getClavePAYROLL(this.getSesion()));

		try {
			conn = ods.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getURLConexionPAYROLL(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("URL_PAYROLL_PROD_ORACLE", aSesion).getValorCadena();
	}

	public static String getUsuarioPAYROLL(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("USU_PAYROLL_PROD", aSesion).getValorCadena();
	}

	public static String getClavePAYROLL(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("CLAVE_PAYROLL_PROD", aSesion).getValorCadena();
	}

	public void importarDatosTablaPayTbglmnov(Connection conexion) throws BaseException {

		String delpayTbglmnov = " truncate table payTbglmnov";
		PreparedStatement psDelpayTbglmnov = null;
		try {
			psDelpayTbglmnov = getSesion().getConexionBD().prepareStatement(delpayTbglmnov);
			psDelpayTbglmnov.executeUpdate();
			psDelpayTbglmnov.close();
		} catch (SQLException e1) {
			throw new ExceptionValidation(null, "No se pudo borrar el contenido de la tabla payTbglmnov");
		}

		StringBuffer sqlCons = new StringBuffer();
		sqlCons.append("select ");

		sqlCons.append("IDLICENCIA, ");
		sqlCons.append("CODIGO, ");
		sqlCons.append("FECHACRE, ");
		sqlCons.append("FECHAINI, ");
		sqlCons.append("FECHAFIN, ");
		sqlCons.append("HORAINI, ");
		sqlCons.append("DIAS, ");
		sqlCons.append("SINTOMA, ");
		sqlCons.append("OTRDOMI, ");
		sqlCons.append("IDPRESMED, ");
		sqlCons.append("IDMEDICO, ");
		sqlCons.append("IDAPARATO, ");
		sqlCons.append("IDENFERM, ");
		sqlCons.append("IDLICREAN, ");
		sqlCons.append("IDMOVIFA, ");
		sqlCons.append("PROCONPE, ");
		sqlCons.append("C40, ");
		sqlCons.append("RESCONCLI, ");
		sqlCons.append("PEDMED, ");
		sqlCons.append("ATEMED, ");
		sqlCons.append("ENFFAM, ");
		sqlCons.append("FECATENMED, ");
		sqlCons.append("TARESP, ");
		sqlCons.append("INDESP, ");
		sqlCons.append("ACCIDENTE, ");
		sqlCons.append("FECACC, ");
		sqlCons.append("FECBAMELA, ");
		sqlCons.append("FECALTAMED, ");
		sqlCons.append("DESCACC, ");
		sqlCons.append("IDSIACC, ");
		sqlCons.append("ENVART, ");
		sqlCons.append("FECENVART, ");
		sqlCons.append("DENUNART, ");
		sqlCons.append("NDENUNART, ");
		sqlCons.append("DENUNPOL, ");
		sqlCons.append("FEDENUNPOL, ");
		sqlCons.append("NDENUNPOL, ");
		sqlCons.append("ITINERE, ");
		sqlCons.append("JUSTIFICA, ");
		sqlCons.append("PUDOVISIT, ");
		sqlCons.append("IDMOTNJ, ");
		sqlCons.append("IDNCASH, ");
		sqlCons.append("IDNCASD, ");
		sqlCons.append("IDNCASDA, ");
		sqlCons.append("IDNCASDIA, ");
		sqlCons.append("IDMEDRETAN, ");
		sqlCons.append("IDDESRETAN, ");
		sqlCons.append("IDNOVPR, ");
		sqlCons.append("IDNPREFCAI, ");
		sqlCons.append("ENFPROF, ");
		sqlCons.append("DISPOR, ");
		sqlCons.append("IDDISTIPO, ");
		sqlCons.append("IDDISPCA, ");
		sqlCons.append("IDMOLTJ, ");
		sqlCons.append("IDMEDENT, ");
		sqlCons.append("CANMEDENT, ");
		sqlCons.append("IDFAMILIAR, ");
		sqlCons.append("TOPEEF, ");
		sqlCons.append("ACUMEF, ");
		sqlCons.append("LARTRA, ");
		sqlCons.append("LARTRAINI, ");
		sqlCons.append("IDCASLT100, ");
		sqlCons.append("IDCASLT50, ");
		sqlCons.append("IDCASLT0, ");
		sqlCons.append("OBSERVA, ");
		sqlCons.append("MODCONT, ");
		sqlCons.append("NROHTRA, ");
		sqlCons.append("FECHA_ADEF, ");
		sqlCons.append("DIASCD, ");
		sqlCons.append("DIASCL, ");
		sqlCons.append("IDSECTOR, ");
		sqlCons.append("IDSUBSECTO, ");
		sqlCons.append("IDAREA, ");
		sqlCons.append("IDEQUIPO, ");
		sqlCons.append("TURNO, ");
		sqlCons.append("IDSUPERIOR, ");
		sqlCons.append("IDGRAVEDAD, ");
		sqlCons.append("IDTIPTAREA, ");
		sqlCons.append("IDTIPO, ");
		sqlCons.append("IDGENESIS, ");
		sqlCons.append("IDFORMA, ");
		sqlCons.append("IDNATURALE, ");
		sqlCons.append("IDAGENTE, ");
		sqlCons.append("ACCIONES, ");
		sqlCons.append("IDRESPACC, ");
		sqlCons.append("FECHA_ACC, ");
		sqlCons.append("ESTADO, ");
		sqlCons.append("DIASAD, ");
		sqlCons.append("COSTO  ");
		sqlCons.append(" from payroll.tbglmnov ");

		try {

			String queryInsPayTbglmnov = "insert /*+ Append*/ into paytbglmnov(" + " IDLICENCIA," + " OID_TBGL_NOV," + " CODIGO," + " FECHACRE," + " FECHAINI," + " FECHAFIN," + " HORAINI," + " DIAS,"
					+ " SINTOMA," + " OTRDOMI," + " IDPRESMED," + " IDMEDICO," + " IDAPARATO," + " IDENFERM," + " IDLICREAN," + " IDMOVIFA," + " PROCONPE," + " C40," + " RESCONCLI," + " PEDMED, "
					+ " ATEMED, " + " ENFFAM," + " FECATENMED," + " TARESP," + " INDESP, " + " ACCIDENTE , " + " FECACC , " + " FECBAMELA , " + " FECALTAMED , " + " DESCACC , " + " IDSIACC , "
					+ " ENVART , " + " FECENVART , " + " DENUNART , " + " NDENUNART , " + " DENUNPOL , " + " FEDENUNPOL , " + " NDENUNPOL , " + " ITINERE , " + " JUSTIFICA , " + " PUDOVISIT , "
					+ " IDMOTNJ , " + " IDNCASH , " + " IDNCASD , " + " IDNCASDA  , " + " IDNCASDIA , " + " IDMEDRETAN , " + " IDDESRETAN , " + " IDNOVPR  , " + " IDNPREFCAI , " + " ENFPROF , "
					+ " DISPOR  , " + " IDDISTIPO , " + " IDDISPCA , " + " IDMOLTJ , " + " IDMEDENT , " + " CANMEDENT , " + " IDFAMILIAR , " + " TOPEEF , " + " ACUMEF , " + " LARTRA , "
					+ " LARTRAINI , " + " IDCASLT100 , " + " IDCASLT50 , " + " IDCASLT0 , " + " OBSERVA  , " + " MODCONT , " + " NROHTRA , " + " FECHA_ADEF , " + " DIASCD , " + " DIASCL , "
					+ " IDSECTOR , " + " IDSUBSECTO , " + " IDAREA  , " + " IDEQUIPO , " + " TURNO , " + " IDSUPERIOR , " + " IDGRAVEDAD , " + " IDTIPTAREA  , " + " IDTIPO  , " + " IDGENESIS , "
					+ " IDFORMA  , " + " IDNATURALE , " + " IDAGENTE  , " + " ACCIONES  , " + " IDRESPACC  , " + " FECHA_ACC  , " + " ESTADO  , " + " DIASAD , " + " COSTO  , " + " ACTIVO) VALUES ( "
					+ "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," + "?)";

			PreparedStatement qInsertNovMed;
			qInsertNovMed = getSesion().getConexionBD().prepareStatement(queryInsPayTbglmnov);

			int secu = 0;
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlCons.toString());
			while (rs.next()) {

				int idLicencia = rs.getInt("IDLICENCIA");
				String codigo = rs.getString("CODIGO");

				java.util.Date FECHACRE = null;
				java.util.Date FECHAINI = null;
				java.util.Date FECHAFIN = null;

				if ((rs.getDate("FECHACRE") != null) && (!rs.getDate("FECHACRE").equals(fec1_1_3000)))
					FECHACRE = rs.getDate("FECHACRE");

				if ((rs.getDate("FECHAINI") != null) && (!rs.getDate("FECHAINI").equals(fec1_1_3000)))
					FECHAINI = rs.getDate("FECHAINI");

				if ((rs.getDate("FECHAFIN") != null) && (!rs.getDate("FECHAFIN").equals(fec1_1_3000)))
					FECHAFIN = rs.getDate("FECHAFIN");

				String HORAINI = rs.getString("HORAINI");
				Integer DIAS = rs.getInt("DIAS");
				String SINTOMA = "";
				if (rs.getString("SINTOMA") != null)
					SINTOMA = rs.getString("SINTOMA").trim().replaceAll("\n", "¬c¬n").replaceAll("\r", "");

				String OTRDOMI = "";
				if (rs.getString("OTRDOMI") != null)
					OTRDOMI = rs.getString("OTRDOMI").trim().replaceAll("\n", "¬c¬n").replaceAll("\r", "");

				Integer IDPRESMED = rs.getInt("IDPRESMED");
				Integer IDMEDICO = rs.getInt("IDMEDICO");
				Integer IDAPARATO = rs.getInt("IDAPARATO");
				Integer IDENFERM = rs.getInt("IDENFERM");
				Integer IDLICREAN = rs.getInt("IDLICREAN");
				Integer IDMOVIFA = rs.getInt("IDMOVIFA");

				java.util.Date PROCONPE = null;

				if ((rs.getDate("PROCONPE") != null) && (!rs.getDate("PROCONPE").equals(fec1_1_3000)))
					PROCONPE = rs.getDate("PROCONPE");

				Integer C40 = rs.getInt("C40");
				String RESCONCLI = "";
				if (rs.getString("RESCONCLI") != null)
					RESCONCLI = rs.getString("RESCONCLI").trim().replaceAll("\n", "¬c¬n").replaceAll("\r", "");

				Integer PEDMED = rs.getInt("PEDMED");
				Integer ATEMED = rs.getInt("ATEMED");
				Integer ENFFAM = rs.getInt("ENFFAM");

				java.util.Date FECATENMED = null;
				if ((rs.getDate("FECATENMED") != null) && (!rs.getDate("FECATENMED").equals(fec1_1_3000)))
					FECATENMED = rs.getDate("FECATENMED");

				String TARESP = rs.getString("TARESP");
				String INDESP = rs.getString("INDESP");
				Integer ACCIDENTE = rs.getInt("ACCIDENTE");

				java.util.Date FECACC = null;
				if ((rs.getDate("FECACC") != null) && (!rs.getDate("FECACC").equals(fec1_1_3000)))
					FECACC = rs.getDate("FECACC");

				java.util.Date FECBAMELA = null;
				if ((rs.getDate("FECBAMELA") != null) && (!rs.getDate("FECBAMELA").equals(fec1_1_3000)))
					FECBAMELA = rs.getDate("FECBAMELA");

				java.util.Date FECALTAMED = null;
				if ((rs.getDate("FECALTAMED") != null) && (!rs.getDate("FECALTAMED").equals(fec1_1_3000)))
					FECALTAMED = rs.getDate("FECALTAMED");

				String DESCACC = "";
				if (rs.getString("DESCACC") != null)
					DESCACC = rs.getString("DESCACC").trim().replaceAll("\n", "¬c¬n").replaceAll("\r", "");

				Integer IDSIACC = rs.getInt("IDSIACC");
				Integer ENVART = rs.getInt("ENVART");

				java.util.Date FECENVART = null;
				if ((rs.getDate("FECENVART") != null) && (!rs.getDate("FECENVART").equals(fec1_1_3000)))
					FECENVART = rs.getDate("FECENVART");

				Integer DENUNART = rs.getInt("DENUNART");
				String NDENUNART = rs.getString("NDENUNART");
				Integer DENUNPOL = rs.getInt("DENUNPOL");

				java.util.Date FEDENUNPOL = null;
				if ((rs.getDate("FEDENUNPOL") != null) && (!rs.getDate("FEDENUNPOL").equals(fec1_1_3000)))
					FEDENUNPOL = rs.getDate("FEDENUNPOL");

				String NDENUNPOL = rs.getString("NDENUNPOL");
				Integer ITINERE = rs.getInt("ITINERE");
				Integer JUSTIFICA = rs.getInt("JUSTIFICA");
				Integer PUDOVISIT = rs.getInt("PUDOVISIT");
				Integer IDMOTNJ = rs.getInt("IDMOTNJ");
				Integer IDNCASH = rs.getInt("IDNCASH");
				Integer IDNCASD = rs.getInt("IDNCASD");
				Integer IDNCASDA = rs.getInt("IDNCASDA");
				Integer IDNCASDIA = rs.getInt("IDNCASDIA");
				Integer IDMEDRETAN = rs.getInt("IDMEDRETAN");
				Integer IDDESRETAN = rs.getInt("IDDESRETAN");
				Integer IDNOVPR = rs.getInt("IDNOVPR");
				Integer IDNPREFCAI = rs.getInt("IDNPREFCAI");
				Integer ENFPROF = rs.getInt("ENFPROF");
				Integer DISPOR = rs.getInt("DISPOR");
				Integer IDDISTIPO = rs.getInt("IDDISTIPO");
				Integer IDDISPCA = rs.getInt("IDDISPCA");
				Integer IDMOLTJ = rs.getInt("IDMOLTJ");
				Integer IDMEDENT = rs.getInt("IDMEDENT");
				Integer CANMEDENT = rs.getInt("CANMEDENT");
				Integer IDFAMILIAR = rs.getInt("IDFAMILIAR");
				Integer TOPEEF = rs.getInt("TOPEEF");
				Integer ACUMEF = rs.getInt("ACUMEF");
				Integer LARTRA = rs.getInt("LARTRA");
				Integer LARTRAINI = rs.getInt("LARTRAINI");
				Integer IDCASLT100 = rs.getInt("IDCASLT100");
				Integer IDCASLT50 = rs.getInt("IDCASLT50");
				Integer IDCASLT0 = rs.getInt("IDCASLT0");

				String OBSERVA = "";
				if (rs.getString("OBSERVA") != null)
					OBSERVA = rs.getString("OBSERVA").trim().replaceAll("\n", "¬c¬n").replaceAll("\r", "");

				String MODCONT = rs.getString("MODCONT");
				Integer NROHTRA = rs.getInt("NROHTRA");

				java.util.Date FECHA_ADEF = null;
				if ((rs.getDate("FECHA_ADEF") != null) && (!rs.getDate("FECHA_ADEF").equals(fec1_1_3000)))
					FECHA_ADEF = rs.getDate("FECHA_ADEF");

				Integer DIASCD = rs.getInt("DIASCD");
				Integer DIASCL = rs.getInt("DIASCL");
				Integer IDSECTOR = rs.getInt("IDSECTOR");
				Integer IDSUBSECTO = rs.getInt("IDSUBSECTO");
				Integer IDAREA = rs.getInt("IDAREA");
				Integer IDEQUIPO = rs.getInt("IDEQUIPO");
				String turno = rs.getString("TURNO");
				String IDSUPERIOR = rs.getString("IDSUPERIOR");
				Integer IDGRAVEDAD = rs.getInt("IDGRAVEDAD");
				Integer IDTIPTAREA = rs.getInt("IDTIPTAREA");
				Integer IDTIPO = rs.getInt("IDTIPO");
				Integer IDGENESIS = rs.getInt("IDGENESIS");
				Integer IDFORMA = rs.getInt("IDFORMA");
				Integer IDNATURALE = rs.getInt("IDNATURALE");
				Integer IDAGENTE = rs.getInt("IDAGENTE");

				String ACCIONES = "";
				if (rs.getString("ACCIONES") != null)
					ACCIONES = rs.getString("ACCIONES").trim().replaceAll("\n", "¬c¬n").replaceAll("\r", "");

				String IDRESPACC = rs.getString("IDRESPACC");

				java.util.Date FECHA_ACC = null;
				if ((rs.getDate("FECHA_ACC") != null) && (!rs.getDate("FECHA_ACC").equals(fec1_1_3000)))
					FECHA_ACC = rs.getDate("FECHA_ACC");

				String ESTADO = rs.getString("ESTADO");
				Integer DIASAD = rs.getInt("DIASAD");
				double COSTO = rs.getDouble("COSTO");

				++secu;
				qInsertNovMed.setInt(1, idLicencia);
				qInsertNovMed.setInt(2, secu);
				if (codigo != null)
					qInsertNovMed.setString(3, codigo);
				else
					qInsertNovMed.setNull(3, Types.VARCHAR);
				if (FECHACRE != null)
					qInsertNovMed.setDate(4, new java.sql.Date(FECHACRE.getTime()));
				else
					qInsertNovMed.setNull(4, Types.DATE);
				if (FECHAINI != null)
					qInsertNovMed.setDate(5, new java.sql.Date(FECHAINI.getTime()));
				else
					qInsertNovMed.setNull(5, Types.DATE);
				if (FECHAFIN != null)
					qInsertNovMed.setDate(6, new java.sql.Date(FECHAFIN.getTime()));
				else
					qInsertNovMed.setNull(6, Types.DATE);
				if (HORAINI != null)
					qInsertNovMed.setString(7, HORAINI);
				else
					qInsertNovMed.setNull(7, Types.VARCHAR);
				if (DIAS != null)
					qInsertNovMed.setInt(8, DIAS);
				else
					qInsertNovMed.setNull(8, Types.INTEGER);
				if (SINTOMA != null)
					qInsertNovMed.setString(9, SINTOMA);
				else
					qInsertNovMed.setNull(9, Types.VARCHAR);
				if (OTRDOMI != null)
					qInsertNovMed.setString(10, OTRDOMI);
				else
					qInsertNovMed.setNull(10, Types.VARCHAR);
				if (IDPRESMED != null)
					qInsertNovMed.setInt(11, IDPRESMED);
				else
					qInsertNovMed.setNull(11, Types.INTEGER);
				if (IDMEDICO != null)
					qInsertNovMed.setInt(12, IDMEDICO);
				else
					qInsertNovMed.setNull(12, Types.INTEGER);
				if (IDAPARATO != null)
					qInsertNovMed.setInt(13, IDAPARATO);
				else
					qInsertNovMed.setNull(13, Types.INTEGER);
				if (IDENFERM != null)
					qInsertNovMed.setInt(14, IDENFERM);
				else
					qInsertNovMed.setNull(14, Types.INTEGER);
				if (IDLICREAN != null)
					qInsertNovMed.setInt(15, IDLICREAN);
				else
					qInsertNovMed.setNull(15, Types.INTEGER);
				if (IDMOVIFA != null)
					qInsertNovMed.setInt(16, IDMOVIFA);
				else
					qInsertNovMed.setNull(16, Types.INTEGER);
				if (PROCONPE != null)
					qInsertNovMed.setDate(17, new java.sql.Date(PROCONPE.getTime()));
				else
					qInsertNovMed.setNull(17, Types.DATE);
				if (C40 != null)
					qInsertNovMed.setInt(18, C40);
				else
					qInsertNovMed.setNull(18, Types.INTEGER);
				if (RESCONCLI != null)
					qInsertNovMed.setString(19, RESCONCLI);
				else
					qInsertNovMed.setInt(19, Types.VARCHAR);
				if (PEDMED != null)
					qInsertNovMed.setInt(20, PEDMED);
				else
					qInsertNovMed.setNull(20, Types.VARCHAR);
				if (ATEMED != null)
					qInsertNovMed.setInt(21, ATEMED);
				else
					qInsertNovMed.setNull(21, Types.INTEGER);
				if (ENFFAM != null)
					qInsertNovMed.setInt(22, ENFFAM);
				else
					qInsertNovMed.setNull(22, Types.INTEGER);
				if (FECATENMED != null)
					qInsertNovMed.setDate(23, new java.sql.Date(FECATENMED.getTime()));
				else
					qInsertNovMed.setNull(23, Types.DATE);
				if (TARESP != null)
					qInsertNovMed.setString(24, TARESP);
				else
					qInsertNovMed.setNull(24, Types.VARCHAR);
				if (INDESP != null)
					qInsertNovMed.setString(25, INDESP);
				else
					qInsertNovMed.setNull(25, Types.VARCHAR);
				if (ACCIDENTE != null)
					qInsertNovMed.setInt(26, ACCIDENTE);
				else
					qInsertNovMed.setNull(26, Types.INTEGER);
				if (FECACC != null)
					qInsertNovMed.setDate(27, new java.sql.Date(FECACC.getTime()));
				else
					qInsertNovMed.setNull(27, Types.DATE);
				if (FECBAMELA != null)
					qInsertNovMed.setDate(28, new java.sql.Date(FECBAMELA.getTime()));
				else
					qInsertNovMed.setNull(28, Types.DATE);
				if (FECALTAMED != null)
					qInsertNovMed.setDate(29, new java.sql.Date(FECALTAMED.getTime()));
				else
					qInsertNovMed.setNull(29, Types.DATE);
				if (DESCACC != null)
					qInsertNovMed.setString(30, DESCACC);
				else
					qInsertNovMed.setNull(30, Types.VARCHAR);
				if (IDSIACC != null)
					qInsertNovMed.setInt(31, IDSIACC);
				else
					qInsertNovMed.setNull(31, Types.INTEGER);
				if (ENVART != null)
					qInsertNovMed.setInt(32, ENVART);
				else
					qInsertNovMed.setNull(32, Types.INTEGER);
				if (FECENVART != null)
					qInsertNovMed.setDate(33, new java.sql.Date(FECENVART.getTime()));
				else
					qInsertNovMed.setNull(33, Types.DATE);
				if (DENUNART != null)
					qInsertNovMed.setInt(34, DENUNART);
				else
					qInsertNovMed.setNull(34, Types.INTEGER);
				if (NDENUNART != null)
					qInsertNovMed.setString(35, NDENUNART);
				else
					qInsertNovMed.setNull(35, Types.VARCHAR);
				if (DENUNPOL != null)
					qInsertNovMed.setInt(36, DENUNPOL);
				else
					qInsertNovMed.setNull(36, Types.INTEGER);
				if (FEDENUNPOL != null)
					qInsertNovMed.setDate(37, new java.sql.Date(FEDENUNPOL.getTime()));
				else
					qInsertNovMed.setNull(37, Types.DATE);
				if (NDENUNPOL != null)
					qInsertNovMed.setString(38, NDENUNPOL);
				else
					qInsertNovMed.setNull(38, Types.VARCHAR);
				if (ITINERE != null)
					qInsertNovMed.setInt(39, ITINERE);
				else
					qInsertNovMed.setNull(39, Types.INTEGER);
				if (JUSTIFICA != null)
					qInsertNovMed.setInt(40, JUSTIFICA);
				else
					qInsertNovMed.setNull(40, Types.INTEGER);
				if (PUDOVISIT != null)
					qInsertNovMed.setInt(41, PUDOVISIT);
				else
					qInsertNovMed.setNull(41, Types.INTEGER);
				if (IDMOTNJ != null)
					qInsertNovMed.setInt(42, IDMOTNJ);
				else
					qInsertNovMed.setNull(42, Types.INTEGER);
				if (IDNCASH != null)
					qInsertNovMed.setInt(43, IDNCASH);
				else
					qInsertNovMed.setNull(43, Types.INTEGER);
				if (IDNCASD != null)
					qInsertNovMed.setInt(44, IDNCASD);
				else
					qInsertNovMed.setNull(44, Types.INTEGER);
				if (IDNCASDA != null)
					qInsertNovMed.setInt(45, IDNCASDA);
				else
					qInsertNovMed.setNull(45, Types.INTEGER);
				if (IDNCASDIA != null)
					qInsertNovMed.setInt(46, IDNCASDIA);
				else
					qInsertNovMed.setNull(46, Types.INTEGER);
				if (IDMEDRETAN != null)
					qInsertNovMed.setInt(47, IDMEDRETAN);
				else
					qInsertNovMed.setNull(47, Types.INTEGER);
				if (IDDESRETAN != null)
					qInsertNovMed.setInt(48, IDDESRETAN);
				else
					qInsertNovMed.setNull(48, Types.INTEGER);
				if (IDNOVPR != null)
					qInsertNovMed.setInt(49, IDNOVPR);
				else
					qInsertNovMed.setNull(49, Types.INTEGER);
				if (IDNPREFCAI != null)
					qInsertNovMed.setInt(50, IDNPREFCAI);
				else
					qInsertNovMed.setNull(50, Types.INTEGER);
				if (ENFPROF != null)
					qInsertNovMed.setInt(51, ENFPROF);
				else
					qInsertNovMed.setNull(51, Types.INTEGER);
				if (DISPOR != null)
					qInsertNovMed.setInt(52, DISPOR);
				else
					qInsertNovMed.setNull(52, Types.INTEGER);
				if (IDDISTIPO != null)
					qInsertNovMed.setInt(53, IDDISTIPO);
				else
					qInsertNovMed.setNull(53, Types.INTEGER);
				if (IDDISPCA != null)
					qInsertNovMed.setInt(54, IDDISPCA);
				else
					qInsertNovMed.setInt(54, Types.INTEGER);
				if (IDMOLTJ != null)
					qInsertNovMed.setInt(55, IDMOLTJ);
				else
					qInsertNovMed.setNull(55, Types.INTEGER);
				if (IDMEDENT != null)
					qInsertNovMed.setInt(56, IDMEDENT);
				else
					qInsertNovMed.setNull(56, Types.INTEGER);
				if (CANMEDENT != null)
					qInsertNovMed.setInt(57, CANMEDENT);
				else
					qInsertNovMed.setNull(57, Types.INTEGER);
				if (IDFAMILIAR != null)
					qInsertNovMed.setInt(58, IDFAMILIAR);
				else
					qInsertNovMed.setNull(58, Types.INTEGER);
				if (TOPEEF != null)
					qInsertNovMed.setInt(59, TOPEEF);
				else
					qInsertNovMed.setInt(59, Types.INTEGER);
				if (ACUMEF != null)
					qInsertNovMed.setInt(60, ACUMEF);
				else
					qInsertNovMed.setNull(60, Types.INTEGER);
				if (LARTRA != null)
					qInsertNovMed.setInt(61, LARTRA);
				else
					qInsertNovMed.setNull(61, Types.INTEGER);
				if (LARTRAINI != null)
					qInsertNovMed.setInt(62, LARTRAINI);
				else
					qInsertNovMed.setNull(62, Types.INTEGER);
				if (IDCASLT100 != null)
					qInsertNovMed.setInt(63, IDCASLT100);
				else
					qInsertNovMed.setNull(63, Types.INTEGER);
				if (IDCASLT50 != null)
					qInsertNovMed.setInt(64, IDCASLT50);
				else
					qInsertNovMed.setNull(64, Types.INTEGER);
				if (IDCASLT0 != null)
					qInsertNovMed.setInt(65, IDCASLT0);
				else
					qInsertNovMed.setNull(65, Types.INTEGER);
				if (OBSERVA != null)
					qInsertNovMed.setString(66, OBSERVA);
				else
					qInsertNovMed.setNull(66, Types.VARCHAR);
				if (MODCONT != null)
					qInsertNovMed.setString(67, MODCONT);
				else
					qInsertNovMed.setNull(67, Types.VARCHAR);
				if (NROHTRA != null)
					qInsertNovMed.setInt(68, NROHTRA);
				else
					qInsertNovMed.setNull(68, Types.INTEGER);
				if (FECHA_ADEF != null)
					qInsertNovMed.setDate(69, new java.sql.Date(FECHA_ADEF.getTime()));
				else
					qInsertNovMed.setNull(69, Types.DATE);
				if (DIASCD != null)
					qInsertNovMed.setInt(70, DIASCD);
				else
					qInsertNovMed.setNull(70, Types.INTEGER);
				if (DIASCL != null)
					qInsertNovMed.setInt(71, DIASCL);
				else
					qInsertNovMed.setNull(71, Types.INTEGER);
				if (IDSECTOR != null)
					qInsertNovMed.setInt(72, IDSECTOR);
				else
					qInsertNovMed.setNull(72, Types.INTEGER);
				if (IDSUBSECTO != null)
					qInsertNovMed.setInt(73, IDSUBSECTO);
				else
					qInsertNovMed.setNull(73, Types.INTEGER);
				if (IDAREA != null)
					qInsertNovMed.setInt(74, IDAREA);
				else
					qInsertNovMed.setNull(74, Types.INTEGER);
				if (IDEQUIPO != null)
					qInsertNovMed.setInt(75, IDEQUIPO);
				else
					qInsertNovMed.setNull(75, Types.INTEGER);
				if (turno != null)
					qInsertNovMed.setString(76, turno);
				else
					qInsertNovMed.setNull(76, Types.VARCHAR);
				if (IDSUPERIOR != null)
					qInsertNovMed.setString(77, IDSUPERIOR);
				else
					qInsertNovMed.setNull(78, Types.VARCHAR);
				if (IDGRAVEDAD != null)
					qInsertNovMed.setInt(78, IDGRAVEDAD);
				else
					qInsertNovMed.setNull(78, Types.INTEGER);
				if (IDTIPTAREA != null)
					qInsertNovMed.setInt(79, IDTIPTAREA);
				else
					qInsertNovMed.setNull(79, Types.INTEGER);
				if (IDTIPO != null)
					qInsertNovMed.setInt(80, IDTIPO);
				else
					qInsertNovMed.setNull(80, Types.INTEGER);
				if (IDGENESIS != null)
					qInsertNovMed.setInt(81, IDGENESIS);
				else
					qInsertNovMed.setNull(81, Types.INTEGER);
				if (IDFORMA != null)
					qInsertNovMed.setInt(82, IDFORMA);
				else
					qInsertNovMed.setNull(82, Types.INTEGER);
				if (IDNATURALE != null)
					qInsertNovMed.setInt(83, IDNATURALE);
				else
					qInsertNovMed.setNull(83, Types.INTEGER);
				if (IDAGENTE != null)
					qInsertNovMed.setInt(84, IDAGENTE);
				else
					qInsertNovMed.setNull(84, Types.INTEGER);
				if (ACCIONES != null)
					qInsertNovMed.setString(85, ACCIONES);
				else
					qInsertNovMed.setNull(85, Types.VARCHAR);
				if (IDRESPACC != null)
					qInsertNovMed.setString(86, IDRESPACC);
				else
					qInsertNovMed.setNull(86, Types.VARCHAR);
				if (FECHA_ACC != null)
					qInsertNovMed.setDate(87, new java.sql.Date(FECHA_ACC.getTime()));
				else
					qInsertNovMed.setNull(87, Types.DATE);
				if (ESTADO != null)
					qInsertNovMed.setString(88, ESTADO);
				else
					qInsertNovMed.setNull(88, Types.VARCHAR);
				if (DIASAD != null)
					qInsertNovMed.setInt(89, DIASAD);
				else
					qInsertNovMed.setNull(89, Types.INTEGER);
				qInsertNovMed.setDouble(90, COSTO);
				qInsertNovMed.setInt(91, 1);

				qInsertNovMed.executeUpdate();

			}

			qInsertNovMed.close();
			stmt.close();
			rs.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importarDatosSanciones(Connection conexion) throws BaseException {

		String delPaySanciones = "truncate table paySanciones";
		PreparedStatement psDelSanciones = null;
		try {
			psDelSanciones = getSesion().getConexionBD().prepareStatement(delPaySanciones);
			psDelSanciones.executeUpdate();
			psDelSanciones.close();
		} catch (SQLException e1) {
			throw new ExceptionValidation(null, "No se pudo borrar el contenido de la tabla PAYSANCIONES");
		}

		StringBuffer sqlConsSanciones = new StringBuffer();
		sqlConsSanciones.append("select ID,FKLEGAJO,FECNOV,IDMOTIVO,IDSANCION,FECDESSUSP,FECREINTEG from payroll.tbsannov ");

		try {

			String queryInsSanciones = "insert /*+ Append*/ into paySanciones(ID_SANCION,FECNOV,IDMOTIVO,IDSANCION,FECDESSUSP,FECREINTEG,FKLEGAJO) values (?,?,?,?,?,?,?) ";
			PreparedStatement qInsertSanciones;
			qInsertSanciones = getSesion().getConexionBD().prepareStatement(queryInsSanciones);

			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsSanciones.toString());
			while (rs.next()) {

				Integer id = rs.getInt("ID");
				String legajo = "";
				if (rs.getString("FKLEGAJO") != null)
					legajo = rs.getString("FKLEGAJO").trim();

				java.util.Date fecNov = rs.getDate("FECNOV");
				Integer oidMotFalta = rs.getInt("IDMOTIVO");
				Integer oidSancion = rs.getInt("IDSANCION");
				java.util.Date fecDesSusp = rs.getDate("FECDESSUSP");
				java.util.Date fecReintegro = rs.getDate("FECREINTEG");

				qInsertSanciones.setInt(1, id);
				if (fecNov != null) {
					if (fec1_1_3000.equals(fecNov))
						qInsertSanciones.setNull(2, Types.DATE);
					else
						qInsertSanciones.setDate(2, new java.sql.Date(fecNov.getTime()));
				} else
					qInsertSanciones.setNull(2, Types.DATE);

				if (oidMotFalta != null)
					qInsertSanciones.setInt(3, oidMotFalta);
				else
					qInsertSanciones.setNull(3, Types.INTEGER);

				if (oidSancion != null)
					qInsertSanciones.setInt(4, oidSancion);
				else
					qInsertSanciones.setNull(4, Types.INTEGER);

				if (fecDesSusp != null) {
					if (fecDesSusp.equals(fec1_1_3000))
						qInsertSanciones.setNull(5, Types.DATE);
					else
						qInsertSanciones.setDate(5, new java.sql.Date(fecDesSusp.getTime()));
				} else
					qInsertSanciones.setNull(5, Types.DATE);

				if (fecReintegro != null) {

					if (fecReintegro.equals(fec1_1_3000))
						qInsertSanciones.setNull(6, Types.DATE);
					else
						qInsertSanciones.setDate(6, new java.sql.Date(fecReintegro.getTime()));

				} else
					qInsertSanciones.setNull(6, Types.DATE);

				if (legajo != null)
					qInsertSanciones.setString(7, legajo);
				else
					qInsertSanciones.setNull(7, Types.VARCHAR);

				qInsertSanciones.executeUpdate();

			}

			qInsertSanciones.close();
			stmt.close();
			rs.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importarDatosTBCASTNN(Connection conexion) throws BaseException {

		try {
			Statement staTruncateTBCASTNN = this.getSesion().getConexionBD().createStatement();
			staTruncateTBCASTNN.executeUpdate("truncate table payTBCASTNN");
			staTruncateTBCASTNN.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer sqlConsTBCASTNN = new StringBuffer();
		sqlConsTBCASTNN.append(" select TNNCODIGO, TNNDESCRIP, TNN_COTAB from PAYROLL.tbcastnn  ");

		try {

			String queryIns = "insert /*+ Append*/ into payTBCASTNN(OID_TNN,TNNCODIGO,TNNDESCRIP,ACTIVO,TNN_COTAB) values (?,?,?,?,?) ";
			PreparedStatement qInsertTBCASTNN;
			qInsertTBCASTNN = getSesion().getConexionBD().prepareStatement(queryIns);

			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsTBCASTNN.toString());
			while (rs.next()) {

				Integer codigo = rs.getInt("TNNCODIGO");
				String desc = rs.getString("TNNDESCRIP");
				Integer cotab = rs.getInt("TNN_COTAB");

				qInsertTBCASTNN.setInt(1, codigo);
				qInsertTBCASTNN.setInt(2, codigo);
				qInsertTBCASTNN.setString(3, desc);
				qInsertTBCASTNN.setBoolean(4, true);
				qInsertTBCASTNN.setInt(5, cotab);
				qInsertTBCASTNN.executeUpdate();

			}

			qInsertTBCASTNN.close();
			stmt.close();
			rs.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importarDatosPAYMotNov(Connection conexion) throws BaseException {

		try {
			Statement staTruncatePAYMotNov = this.getSesion().getConexionBD().createStatement();
			staTruncatePAYMotNov.executeUpdate("truncate table payMotivosNov");
			staTruncatePAYMotNov.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer sqlConsPAYMotNov = new StringBuffer();
		sqlConsPAYMotNov.append(" SELECT " + "   A.TNNCODIGO , " + "   A.TNN_COTAB , " + "   A.TNNDESCRIP, " + "   B.CODIGO , " + "   B.DESCRIP " + " FROM " + "   payroll.TBCASTNN A , payroll.RTABLAS B " + " WHERE "
				+ " A.TNN_COTAB = B.COTAB AND B.CODIGO<>0 ");

		try {

			String queryIns = "insert /*+ Append*/ into payMotivosNov(secu,tnncodigo,tnn_cotab,tnndescrip,codigo,descrip) values (?,?,?,?,?,?) ";
			PreparedStatement qInsertPAYMotNov;
			qInsertPAYMotNov = getSesion().getConexionBD().prepareStatement(queryIns);

			int secu = 0;
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsPAYMotNov.toString());
			while (rs.next()) {

				Integer tnnCodigo = rs.getInt("TNNCODIGO");
				Integer tnnCotab = rs.getInt("TNN_COTAB");
				String tnnDescrip = rs.getString("TNNDESCRIP");
				Integer codigo = rs.getInt("CODIGO");
				String descrip = rs.getString("DESCRIP");

				++secu;
				qInsertPAYMotNov.setInt(1, secu);
				qInsertPAYMotNov.setInt(2, tnnCodigo);
				qInsertPAYMotNov.setInt(3, tnnCotab);
				qInsertPAYMotNov.setString(4, tnnDescrip);
				qInsertPAYMotNov.setInt(5, codigo);
				qInsertPAYMotNov.setString(6, descrip);
				qInsertPAYMotNov.executeUpdate();

			}

			qInsertPAYMotNov.close();
			stmt.close();
			rs.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void importarDatosEstructura(Connection conexion) throws BaseException {

		try {
			Statement staTruncatePAYEstructura = this.getSesion().getConexionBD().createStatement();
			staTruncatePAYEstructura.executeUpdate("truncate table PAYESTRUCTURA");
			staTruncatePAYEstructura.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer sqlConsPAYEstruc = new StringBuffer();
		sqlConsPAYEstruc.append(" SELECT CENCOS,EMPRESA,CARGO FROM payroll.REMPLESH GROUP BY CENCOS,EMPRESA,CARGO ");
		sqlConsPAYEstruc.append(" UNION ");
		sqlConsPAYEstruc.append(" SELECT CENCOS,EMPRESA,CARGO FROM payroll.REMPLES GROUP BY CENCOS,EMPRESA,CARGO ");
		
		try {

			String queryIns = "insert /*+ Append*/ into PAYESTRUCTURA(EMPRESA,CENCOS,CARGO) values (?,?,?) ";
			PreparedStatement qInsertPAYEstruc;
			qInsertPAYEstruc = getSesion().getConexionBD().prepareStatement(queryIns);

			int secu = 0;
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsPAYEstruc.toString());
			while (rs.next()) {

				String empresa = rs.getString("EMPRESA");
				Integer cencos = rs.getInt("CENCOS");
				Integer cargo = rs.getInt("CARGO");

				++secu;
				qInsertPAYEstruc.setString(1, empresa);
				qInsertPAYEstruc.setInt(2, cencos);
				qInsertPAYEstruc.setInt(3, cargo);
				qInsertPAYEstruc.executeUpdate();
				

			}

			qInsertPAYEstruc.close();
			stmt.close();
			rs.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

	public void importarDatosNovedades(Connection conexion) throws BaseException {

		try {
			Statement staTruncatePAYNovedades = this.getSesion().getConexionBD().createStatement();
			staTruncatePAYNovedades.executeUpdate("truncate table payNovedades");
			staTruncatePAYNovedades.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer sqlConsPAYNovedades = new StringBuffer();
		sqlConsPAYNovedades.append(" SELECT " + "   a.novcodigo, " + "   a.novtipo, " + "   a.novmotivo, " + "   b.nmoordenpr, " + "   b.nmofecha, " + "   b.nmolegajo, " + "   c.tnn_cotab, "
				+ "   a.novobs, " + "   b.nmohoraini ," + "   b.nmohorafin " + " from " + "   payroll.tbcasnov a, " + "   payroll.tbcasnmo b, " + "   payroll.tbcastnn c " + " where "
				+ " a.novcodigo = b.nmonovedad and a.novtipo = c.tnncodigo ");

		try {

			String queryIns = "insert /*+ Append*/ into payNovedades(novcodigo,novtipo,novmotivo,nmoordenpr,nmofecha,nmolegajo,tnn_cotab,novobs,nmohoraini,nmohorafin) values (?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement qInsertNovedades;
			qInsertNovedades = getSesion().getConexionBD().prepareStatement(queryIns);

			int secu = 0;
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsPAYNovedades.toString());
			while (rs.next()) {

				Integer novcodigo = rs.getInt("novcodigo");
				Integer novtipo = rs.getInt("novtipo");
				Integer novmotivo = rs.getInt("novmotivo");
				Integer nmoordenpr = rs.getInt("nmoordenpr");
				java.util.Date fecha = rs.getDate("nmofecha");
				String legajo = rs.getString("nmolegajo");
				Integer tnnCotab = rs.getInt("tnn_cotab");
				String novobs = "";
				if (rs.getString("novobs") != null)
					novobs = rs.getString("novobs").trim().replaceAll("\n", "¬c¬n").replaceAll("\r", "");
				String nmoHoraIni = rs.getString("nmohoraini");
				String nmoHoraFin = rs.getString("nmohorafin");

				qInsertNovedades.setInt(1, novcodigo);
				qInsertNovedades.setInt(2, novtipo);
				qInsertNovedades.setInt(3, novmotivo);
				qInsertNovedades.setInt(4, nmoordenpr);
				qInsertNovedades.setDate(5, new java.sql.Date(fecha.getTime()));
				qInsertNovedades.setString(6, legajo);
				qInsertNovedades.setInt(7, tnnCotab);
				qInsertNovedades.setString(8, novobs);
				if (nmoHoraIni != null)
					qInsertNovedades.setString(9, nmoHoraIni);
				else
					qInsertNovedades.setNull(9, Types.VARCHAR);
				if (nmoHoraFin != null)
					qInsertNovedades.setString(10, nmoHoraFin);
				else
					qInsertNovedades.setNull(10, Types.VARCHAR);
				qInsertNovedades.executeUpdate();

			}

			qInsertNovedades.close();
			stmt.close();
			rs.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importarDatosHistPuestos(Connection conexion) throws BaseException {
		HistoricoPuesto.truncarTablaPayHistPuesto(this.getSesion());

		StringBuffer sqlConsHistPuestos = new StringBuffer();
		sqlConsHistPuestos.append(" 	SELECT A.CODIGO , A.EMPRESA, A.CENCOS , A.CARGO,MIN(A.FECHA_MOD) FECHA FROM (  ");
		sqlConsHistPuestos.append(" 	select DISTINCT CARGO , FECHA_MOD , EMPRESA , CENCOS ,  CODIGO FROM PAYROLL.REMPLESH) A group by A.CODIGO, A.EMPRESA, A.CENCOS, A.CARGO  ");

		try {

			String queryIns = "insert /*+ Append*/ into payHistPuestos(legajo,cargo,fecha,empresa,cencos) values (?,?,?,?,?) ";
			PreparedStatement qInsertHistPuestos;
			qInsertHistPuestos = getSesion().getConexionBD().prepareStatement(queryIns);

			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsHistPuestos.toString());
			while (rs.next()) {
				String legajo = rs.getString("codigo").trim();
				Integer cargo = rs.getInt("cargo");
				java.util.Date fecha = rs.getDate("fecha");

				qInsertHistPuestos.setString(1, legajo);
				qInsertHistPuestos.setInt(2, cargo.intValue());
				if (fec1_1_3000.equals(fecha))
					qInsertHistPuestos.setNull(3, Types.DATE);
				else
					qInsertHistPuestos.setDate(3, new java.sql.Date(fecha.getTime()));
				qInsertHistPuestos.setString(4, rs.getString("empresa"));
				qInsertHistPuestos.setInt(5, rs.getInt("cencos"));
				qInsertHistPuestos.executeUpdate();

			}

			qInsertHistPuestos.close();
			stmt.close();
			rs.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importarDatosEmpresa(Connection conexion) throws BaseException {
		EmpresaPayroll.truncarTablaEmpresaPayroll(this.getSesion());

		final int OID_EMPRESA = 1;
		final int EMPRESA = 2;
		final int NOMBRE = 3;
		final int ACTIVO = 4;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert /*+ Append*/ into payEmpresa " + " ( " + "OID_EMPRESA," + "EMPRESA," + "NOMBRE," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		Statement stmt = null;
		String query = "select empresa,nombre from payroll.rempresa ";
		try {

			PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int secu = 1;
			while (rs.next()) {
				EmpresaPayroll empresa = (EmpresaPayroll) EmpresaPayroll.getNew(EmpresaPayroll.NICKNAME, this.getSesion());
				empresa.setDesHabEventoWFAfterNew(true);
				String empresa1 = rs.getString("empresa");
				if (empresa1 != null)
					empresa.setEmpresa(empresa1.trim().toUpperCase());
				else
					empresa.setEmpresa("");
				String rsocial = rs.getString("nombre");
				if (rsocial != null)
					empresa.setNombre(rsocial.trim());
				else
					empresa.setNombre("");
				empresa.setActivo(true);

				qInsert.setInt(OID_EMPRESA, secu);
				qInsert.setString(EMPRESA, empresa.getEmpresa());
				qInsert.setString(NOMBRE, empresa.getNombre());
				qInsert.setBoolean(ACTIVO, empresa.isActivo().booleanValue());
				qInsert.executeUpdate();
				++secu;
			}

			qInsert.close();
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al importar EMPRESA de Payroll. " + e.getMessage());
		}

		try {
			this.getSesion().getConexionBD().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public void actualizarGradosLegajo() throws BaseException {
		//
		Statement staQueryRTablas;
		try {
			staQueryRTablas = getSesion().getConexionBD().createStatement();
			ResultSet rsRTablas = staQueryRTablas.executeQuery("select codigo,descrip from payrtablas where cotab=" + this.getCotabGradoLegajo(this.getSesion()).toString());
			while (rsRTablas.next()) {
				String codigo = rsRTablas.getString("codigo");
				String desc = rsRTablas.getString("descrip");
				GradoLegajo gradoLegajo = GradoLegajo.findByCodigo(codigo, this.getSesion());
				if (gradoLegajo != null)
					gradoLegajo.setDescripcion(desc);
				else {
					gradoLegajo = (GradoLegajo) GradoLegajo.getNew(GradoLegajo.NICKNAME, this.getSesion());
					gradoLegajo.setCodigo(codigo);
					gradoLegajo.setDescripcion(desc);
					gradoLegajo.setActivo(true);
				}
				gradoLegajo.save();
			}
			staQueryRTablas.close();
			rsRTablas.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actualizarMotivosEgreso() throws BaseException {
		//
		Statement staQueryRTablas;
		try {
			staQueryRTablas = getSesion().getConexionBD().createStatement();
			ResultSet rsRTablas = staQueryRTablas.executeQuery("select codigo,descrip from payrtablas where cotab=" + this.getCotabMotivoSector(this.getSesion()).toString());
			while (rsRTablas.next()) {
				String codigo = rsRTablas.getString("codigo");
				String desc = rsRTablas.getString("descrip");
				MotivoEgresoEmp motivoEgresoEmp = MotivoEgresoEmp.findByCodigo(codigo, this.getSesion());
				if (motivoEgresoEmp != null)
					motivoEgresoEmp.setDescripcion(desc);
				else {
					motivoEgresoEmp = (MotivoEgresoEmp) MotivoEgresoEmp.getNew(MotivoEgresoEmp.NICKNAME, this.getSesion());
					motivoEgresoEmp.setCodigo(codigo);
					motivoEgresoEmp.setDescripcion(desc);
					motivoEgresoEmp.setActivo(true);
				}
				motivoEgresoEmp.save();
			}
			staQueryRTablas.close();
			rsRTablas.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actualizarMotivosNovedades() throws BaseException {
		//
		Statement staQueryMotTipoNov;
		try {
			staQueryMotTipoNov = getSesion().getConexionBD().createStatement();
			ResultSet rsMotTipoNov = staQueryMotTipoNov.executeQuery("select SECU,TNNCODIGO,TNN_COTAB,TNNDESCRIP,CODIGO,DESCRIP from payMotivosNov ");
			while (rsMotTipoNov.next()) {
				String codigoTipoNov = rsMotTipoNov.getInt("TNNCODIGO") + "";
				String codigo = rsMotTipoNov.getInt("CODIGO") + "";
				TipoNovedad tipoNovedad = TipoNovedad.findByCodigo(codigoTipoNov, this.getSesion());
				if (tipoNovedad == null)
					continue;
				MotivoTipoNov motivoTipoNov = MotivoTipoNov.getMotivoTipoNov(tipoNovedad, codigo, this.getSesion());
				if (motivoTipoNov != null)
					motivoTipoNov.setDescripcion(rsMotTipoNov.getString("DESCRIP"));
				else {
					motivoTipoNov = (MotivoTipoNov) MotivoTipoNov.getNew(MotivoTipoNov.NICKNAME, this.getSesion());
					motivoTipoNov.setTipo_novedad(tipoNovedad);
					motivoTipoNov.setCodigo(codigo);
					motivoTipoNov.setDescripcion(rsMotTipoNov.getString("DESCRIP"));
					motivoTipoNov.setActivo(true);
				}
				motivoTipoNov.save();
			}
			staQueryMotTipoNov.close();
			rsMotTipoNov.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actualizarTipoNovedad() throws BaseException {
		//
		Statement staQueryTipoNov;
		try {
			staQueryTipoNov = getSesion().getConexionBD().createStatement();
			ResultSet rsTipoNov = staQueryTipoNov.executeQuery("select TNNCODIGO codigo,TNNDESCRIP descrip from payTBCASTNN ");
			while (rsTipoNov.next()) {
				String codigo = rsTipoNov.getInt("codigo") + "";
				String desc = rsTipoNov.getString("descrip");
				TipoNovedad tipoNovedad = TipoNovedad.findByCodigo(codigo, this.getSesion());
				if (tipoNovedad != null)
					tipoNovedad.setDescripcion(desc);
				else {
					tipoNovedad = (TipoNovedad) TipoNovedad.getNew(TipoNovedad.NICKNAME, this.getSesion());
					tipoNovedad.setCodigo(codigo);
					tipoNovedad.setDescripcion(desc);
					tipoNovedad.setActivo(true);
				}
				tipoNovedad.save();
			}
			staQueryTipoNov.close();
			rsTipoNov.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actualizarMotivosFalta() throws BaseException {
		//
		Statement staQueryRTablas;
		try {
			staQueryRTablas = getSesion().getConexionBD().createStatement();
			ResultSet rsRTablas = staQueryRTablas.executeQuery("select codigo,descrip from payrtablas where cotab=" + this.getCotabMotivoFalta(this.getSesion()).toString());
			while (rsRTablas.next()) {
				String codigo = rsRTablas.getString("codigo");
				String desc = rsRTablas.getString("descrip");
				MotivoFaltaRRHH motivoFalta = MotivoFaltaRRHH.findByCodigo(codigo, this.getSesion());
				if (motivoFalta != null)
					motivoFalta.setDescripcion(desc);
				else {
					motivoFalta = (MotivoFaltaRRHH) MotivoFaltaRRHH.getNew(MotivoFaltaRRHH.NICKNAME, this.getSesion());
					motivoFalta.setCodigo(codigo);
					motivoFalta.setDescripcion(desc);
					motivoFalta.setActivo(true);
				}
				motivoFalta.save();
			}
			staQueryRTablas.close();
			rsRTablas.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actualizarMotivosSancion() throws BaseException {
		//
		Statement staQueryRTablas;
		try {
			staQueryRTablas = getSesion().getConexionBD().createStatement();
			ResultSet rsRTablas = staQueryRTablas.executeQuery("select codigo,descrip from payrtablas where cotab=" + this.getCotabMotivoSancion(this.getSesion()).toString());
			while (rsRTablas.next()) {
				String codigo = rsRTablas.getString("codigo");
				String desc = rsRTablas.getString("descrip");
				SancionesRRHH sanciones = SancionesRRHH.findByCodigo(codigo, this.getSesion());
				if (sanciones != null)
					sanciones.setDescripcion(desc);
				else {
					sanciones = (SancionesRRHH) SancionesRRHH.getNew(SancionesRRHH.NICKNAME, this.getSesion());
					sanciones.setCodigo(codigo);
					sanciones.setDescripcion(desc);
					sanciones.setActivo(true);
				}
				sanciones.save();
			}
			staQueryRTablas.close();
			rsRTablas.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void actualizarTiposdeDocumentos() throws BaseException {
		//
		Statement staQueryRTablas;
		try {
			staQueryRTablas = this.getSesion().getConexionBD().createStatement();
			ResultSet rsRTablas = staQueryRTablas.executeQuery("select codigo,descrip from payrtablas where cotab=" + this.getCotabTipoDocu(this.getSesion()).toString());
			while (rsRTablas.next()) {
				String codigo = rsRTablas.getString("codigo");
				String desc = rsRTablas.getString("descrip");
				TipoDocumento tipoDocumento = TipoDocumento.findByCodigo(codigo, this.getSesion());
				if (tipoDocumento != null)
					tipoDocumento.setDescripcion(desc);
				else {
					tipoDocumento = (TipoDocumento) tipoDocumento.getNew(tipoDocumento.NICKNAME, this.getSesion());
					tipoDocumento.setCodigo(codigo);
					tipoDocumento.setDescripcion(desc);
					tipoDocumento.setComportamiento(TipoDocumento.TIPO_DOCU_SIN_CALIFICAR);
					tipoDocumento.setActivo(true);
				}
				tipoDocumento.save();
			}
			staQueryRTablas.close();
			rsRTablas.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importarDatosRTablas(Connection conexion) throws BaseException {

		final int OID_TABLA = 1;
		final int COTAB = 2;
		final int CODIGO = 3;
		final int DESCRIP = 4;
		final int ACTIVO = 5;

		RTablasPayroll.truncarTablaRTablaPayroll(this.getSesion());

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert /*+ Append*/ into payRTablas " + " ( " + "OID_TABLA," + "COTAB," + "CODIGO," + "DESCRIP," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		Statement stmt = null;
		String query = "SELECT COTAB,CODIGO,DESCRIP FROM payroll.rtablas where codigo<>0 ";// and
																							// cotab
																							// in
																							// (" + this.getINCotabTablasPAYROLL() + ")
																							// ";
																							// //
																							// +
		// "or cotab in (select tnn_cotab from "+getPrefijoTablaPAYROLL()+"tbcastnn NOLOCK) ";
		try {
			PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());

			stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int x = 0;
			int secu = 1;
			while (rs.next()) {
				RTablasPayroll rtablas = (RTablasPayroll) RTablasPayroll.getNew(RTablasPayroll.NICKNAME, this.getSesion());
				rtablas.setDesHabEventoWFAfterNew(true);
				rtablas.setCotab(rs.getInt("cotab"));
				rtablas.setCodigortabla(rs.getInt("CODIGO"));
				String descripcion = rs.getString("DESCRIP");
				if (descripcion != null)
					rtablas.setDescrip(descripcion.trim());
				else
					rtablas.setDescrip("");
				rtablas.setActivo(true);

				qInsert.setInt(OID_TABLA, secu);
				qInsert.setInt(COTAB, rtablas.getCotab().intValue());
				qInsert.setInt(CODIGO, rtablas.getCodigortabla().intValue());
				qInsert.setString(DESCRIP, rtablas.getDescrip());
				qInsert.setBoolean(ACTIVO, rtablas.isActivo().booleanValue());
				qInsert.executeUpdate();
				++secu;

			}

			qInsert.close();
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al importar las RTABLAS de Payroll. " + e.getMessage());
		}

		try {
			this.getSesion().getConexionBD().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

	}

	private String getINCotabTablasPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("IN_COTAB_RTABLAS_PAYROLL", this.getSesion()).getValorCadena();
	}

	private void actualizarSindicatos(Connection conexion) throws BaseException {

		String query = " SELECT CODIGO,DESCRIP FROM PAYROLL.RCLAENC ";

		try {

			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				String codigo = rs.getString("CODIGO").trim();
				String descripcion = rs.getString("DESCRIP").trim();

				ClaseSindicato claseSindicato = ClaseSindicato.findByCodigo(codigo, this.getSesion());
				if (claseSindicato != null) {
					claseSindicato.setDescripcion(descripcion);
				} else {
					claseSindicato = (ClaseSindicato) ClaseSindicato.getNew(ClaseSindicato.NICKNAME, this.getSesion());
					claseSindicato.setCodigo(codigo);
					claseSindicato.setDescripcion(descripcion);
					claseSindicato.setActivo(true);
				}
				claseSindicato.save();
			}

			rs.close();
			stmt.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
		}

	}

	private void actualizarEstadosCiviles(Connection conexion) throws BaseException {

		String query = " select " + "   distinct EST_CIVIL " + " from " + "  payroll.REMPLES WHERE EST_CIVIL<>' ' ";

		try {

			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String estCivil = rs.getString("EST_CIVIL").trim();
				EstadoCivil estadoCivil = EstadoCivil.findByCodigo(estCivil, this.getSesion());
				if (estadoCivil == null) {
					estadoCivil = (EstadoCivil) EstadoCivil.getNew(EstadoCivil.NICKNAME, this.getSesion());
					estadoCivil.setCodigo(estCivil);
					estadoCivil.setDescripcion(estCivil);
					estadoCivil.setActivo(true);
					estadoCivil.save();
				}
			}

			rs.close();
			stmt.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
		}

	}

	private void actualizarNovedades() throws BaseException {

		String queryInsNovedades =

		" INSERT INTO LEGNOVEDADES " + "  (oid_novedad, " + "   oid_legajo, " + "   nro_ext, " + "   nro_orden, " + "   oid_tipo_novedad, " + "   oid_mot_tipo_nov, " + "   fecha, "
				+ "   hora_desde, " + "   hora_hasta, " + "   observacion, " + "   activo) " + " SELECT " + "  SEQ_DBNOVEDADLEGAJO.NEXTVAL+3000, " + "  B.OID_LEGAJO oid_legajo, "
				+ "  A.NOVCODIGO nro_ext, " + "  A.NMOORDENPR nro_orden, " + "  C.OID_TIPO_NOVEDAD oid_tipo_novedad, " + "  D.OID_MOT_TIPO_NOV oid_mot_tipo_nov, " + "  A.NMOFECHA fecha, "
				+ "  A.NMOHORAINI hora_desde, " + "  A.NMOHORAFIN hora_hasta, " + "  A.NOVOBS observacion, " + "  1 activo " + " FROM " + "  PAYNOVEDADES A, " + "  SULEGAJO B, "
				+ "  LEGTIPONOVEDAD C, " + "  LEGMOTTIPONOV D " + " WHERE " + "  TRIM(A.NMOLEGAJO) = B.NRO_LEGAJO AND " + "  C.CODIGO = A.NOVTIPO||'' AND A.NMOFECHA>=TRUNC(SYSDATE-90) AND "
				+ "  D.oid_tipo_nov = C.OID_TIPO_NOVEDAD AND " + "  D.codigo = A.NOVMOTIVO||''  AND "
				+ "  NOT EXISTS (SELECT 1 FROM LEGNOVEDADES WHERE NRO_EXT=A.NOVCODIGO AND NRO_ORDEN=A.NMOORDENPR AND ACTIVO=1) ";

		PreparedStatement psInsNovedad = null;

		try {

			psInsNovedad = this.getSesion().getConexionBD().prepareStatement(queryInsNovedades);
			psInsNovedad.executeUpdate();
			psInsNovedad.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de Novedades " + e.getMessage());
		}

		String queryUpdNovedad = "  UPDATE  /*+BYPASS_UJVC*/ "
				+ "  (SELECT "
				+ "    a.oid_legajo as old_oid_legajo, "
				+ "    (select oid_legajo from suLegajo where nro_legajo = trim(b.nmolegajo)) as new_oid_legajo, "
				+ "     a.oid_tipo_novedad as old_oid_tipo_nov, "
				+ "    (select oid_tipo_novedad from legTipoNovedad where codigo = b.novtipo||'') as new_oid_tipo_nov, "
				+ "    a.oid_mot_tipo_nov as old_oid_mot_tipo_nov, "
				+ "    (select oid_mot_tipo_nov from legMotTipoNov a1 , legtiponovedad a2 where a1.oid_tipo_nov = a2.oid_tipo_novedad and a2.codigo=b.novtipo||'' and a1.codigo=b.novmotivo||'') as new_oid_mot_tipo_nov, "
				+ "    a.fecha as old_fecha, " + "    b.nmofecha as new_fecha, " + "    a.hora_desde as old_hora_desde, " + "    b.nmohoraini as new_hora_desde, "
				+ "    a.hora_hasta as old_hora_hasta, " + "    b.nmohorafin as new_hora_hasta, " + "    a.observacion as old_observacion, " + "    b.novobs as new_observacion " + " FROM "
				+ "    legNovedades a INNER JOIN payNovedades b ON a.nro_ext = b.novcodigo and a.nro_orden = b.nmoordenpr WHERE b.nmofecha>=(trunc(sysdate-90))) " + " SET " + "    old_oid_legajo = new_oid_legajo, "
				+ "    old_oid_tipo_nov =  new_oid_tipo_nov, " + "    old_oid_mot_tipo_nov = new_oid_mot_tipo_nov, " + "    old_fecha = new_fecha, " + "    old_hora_desde = new_hora_desde, "
				+ "    old_hora_hasta = new_hora_hasta, " + "    old_observacion = new_observacion ";

		PreparedStatement psUpdNovedad = null;

		try {

			psUpdNovedad = this.getSesion().getConexionBD().prepareStatement(queryUpdNovedad);
			psUpdNovedad.executeUpdate();
			psUpdNovedad.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de Novedades " + e.getMessage());
		}

		String updDesactivarLosBorrados = "update legNovedades a set activo = 0 where fecha>=(trunc(sysdate-90)) and oid_legajo in (SELECT b100.oid_legajo FROM payRemples a100 ,  sulegajo b100 where a100.codigo = b100.nro_legajo) and not exists (select 1 from payNovedades where novcodigo=a.nro_ext and nmoordenpr=a.nro_orden) ";
		PreparedStatement psDesactivarSancionesLeg = null;

		try {

			psDesactivarSancionesLeg = this.getSesion().getConexionBD().prepareStatement(updDesactivarLosBorrados);
			psDesactivarSancionesLeg.executeUpdate();
			psDesactivarSancionesLeg.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de Novedades " + e.getMessage());
		}

	}

	private void actualizarServicioMedico() throws BaseException {

		String queryInsServMed = "INSERT INTO rhservmedico " + "	(" + " 	oid_serv_medico,oid_legajo,tipo_serv_med,nro_nov_sist_ext, " + " 	fec_inicio,fec_final,dias,oid_mot_vis_fall,oid_aparato,"
				+ " 	oid_enfermedad,oid_prest_med,sintoma,observacion," + " 	justifica,fec_ate_med,oid_medico,oid_familiar,fec_accidente,desc_accidente,activo,fec_control) " + "  select "
				+ "   SEQ_DBSERVICIOMEDICORRHH.NEXTVAL+3000, " + "   (select max(oid_legajo) from sulegajo where nro_legajo = trim(a.codigo)) oid_legajo, "
				+ "   DECODE(ACCIDENTE,1,'ACC_LAB',DECODE(ATEMED,1,'ATE_MED',DECODE(PEDMED,1,'PED_MED',DECODE(ENFFAM,1,'ENF_FAM','')))), " + "   IDLICENCIA,FECHAINI,FECHAFIN,DIAS,"
				+ "   (select max(OID_MOT_VIS_FALL) from rhMotVisFallida where codigo = a.IDMOVIFA||'') oid_mot_vis_fall, "
				+ "   (select max(OID_APARATO) from rhAparato where codigo = a.IDAPARATO||'') oid_aparato, "
				+ "   (select max(OID_ENFERMEDAD) from rhEnfermedad where codigo = a.IDENFERM||'') oid_enfermedad, "
				+ "   (select max(OID_PREST_MED) from RHPRESTMEDICO where codigo = a.IDPRESMED||'') oid_prest_med, " + "   SINTOMA,OBSERVA,JUSTIFICA,FECATENMED,"
				+ "   (select max(oid_medico) from rhMedico where codigo = a.IDMEDICO||'') oid_medico, "
				+ "   (select max(oid_familiar) from rhFamiliar where codigo = a.IDFAMILIAR||'') oid_familiar, " + "   FECHA_ACC,DESCACC,1,PROCONPE " + "  from " + "   PAYTBGLMNOV a " + "  where "
				+ "   a.idlicencia not in (select nvl(nro_nov_sist_ext,-1) from rhservmedico) ";

		PreparedStatement psInsServMed = null;

		try {

			psInsServMed = this.getSesion().getConexionBD().prepareStatement(queryInsServMed);
			psInsServMed.executeUpdate();
			psInsServMed.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de Servicion Médico " + e.getMessage());
		}

		String queryUpdServMed = " UPDATE  /*+BYPASS_UJVC*/ " + " (SELECT " + "	a.oid_legajo AS old_oid_legajo, "
				+ " (select max(oid_legajo) from sulegajo where nro_legajo = trim(b.codigo)) AS new_oid_legajo , " + " a.tipo_serv_med AS old_tipo_serv_med,"
				+ " DECODE(b.ACCIDENTE,1,'ACC_LAB',DECODE(b.ATEMED,1,'ATE_MED',DECODE(b.PEDMED,1,'PED_MED',DECODE(b.ENFFAM,1,'ENF_FAM','')))) AS new_tipo_serv_med,"
				+ " a.fec_inicio AS old_fec_inicio, " + " b.FECHAINI AS new_fec_inicio, " + " a.fec_final AS old_fec_final," + " b.FECHAFIN AS new_fec_final," + " a.dias AS old_dias,"
				+ " b.DIAS AS new_dias," + " a.oid_mot_vis_fall AS old_oid_mot_vis_fall,"
				+ " (select max(OID_MOT_VIS_FALL) from rhMotVisFallida where codigo = b.IDMOVIFA||'') AS new_oid_mot_vis_fall , " + " a.oid_aparato AS old_oid_aparato,"
				+ " (select max(OID_APARATO) from rhAparato where codigo = b.IDAPARATO||'') AS new_oid_aparato, " + " a.oid_enfermedad as old_oid_enfermedad,"
				+ " (select max(OID_ENFERMEDAD) from rhEnfermedad where codigo = b.IDENFERM||'') AS new_oid_enfermedad, " + " a.oid_prest_med as old_oid_prest_med,"
				+ " (select max(OID_PREST_MED) from RHPRESTMEDICO where codigo = b.IDPRESMED||'') AS new_oid_prest_med, " + " a.sintoma AS old_sintoma," + " b.SINTOMA AS new_sintoma,"
				+ " a.observacion AS old_observacion," + " b.OBSERVA AS new_observacion," + " a.justifica AS old_justifica," + " b.JUSTIFICA AS new_justifica," + " a.fec_ate_med AS old_fec_ate_med,"
				+ " b.FECATENMED AS  new_fec_ate_med," + " a.oid_medico as old_oid_medico," + " (select max(oid_medico) from rhMedico where codigo = b.IDMEDICO||'') AS new_oid_medico, "
				+ " a.oid_familiar as old_oid_familiar," + " (select max(oid_familiar) from rhFamiliar where codigo = b.IDFAMILIAR||'') AS new_oid_familiar, "
				+ " a.fec_accidente as old_fec_accidente," + " b.FECHA_ACC as new_fec_accidente," + " a.desc_accidente as old_desc_accidente," + " b.DESCACC as new_desc_accidente,"
				+ " a.activo as old_activo," + " 1 as new_activo," + " a.fec_control as old_fec_control," + " b.PROCONPE as new_fec_control " + " FROM rhservmedico a "
				+ " INNER JOIN PAYTBGLMNOV b ON a.nro_nov_sist_ext = b.idlicencia  ) " + " SET " + " old_oid_legajo = new_oid_legajo, " + " old_tipo_serv_med = new_tipo_serv_med, "
				+ " old_fec_inicio = new_fec_inicio," + " old_fec_final = new_fec_final," + " old_dias = new_dias," + " old_oid_mot_vis_fall = new_oid_mot_vis_fall,"
				+ " old_oid_aparato = new_oid_aparato," + " old_oid_enfermedad = new_oid_enfermedad," + " old_oid_prest_med = new_oid_prest_med," + " old_sintoma = new_sintoma,"
				+ " old_observacion = new_observacion," + " old_justifica = new_justifica," + " old_fec_ate_med = new_fec_ate_med," + " old_oid_medico = new_oid_medico,"
				+ " old_oid_familiar = new_oid_familiar," + " old_fec_accidente = new_fec_accidente," + " old_desc_accidente = new_desc_accidente," + " old_activo = new_activo,"
				+ " old_fec_control = new_fec_control ";

		PreparedStatement psUpdServMed = null;

		try {

			psUpdServMed = this.getSesion().getConexionBD().prepareStatement(queryUpdServMed);
			psUpdServMed.executeUpdate();
			psUpdServMed.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de Servicio Medico " + e.getMessage());
		}

		String updDesactivarLosBorrados = "update rhservmedico set activo = 0 where oid_legajo in (SELECT b100.oid_legajo FROM payRemples a100 ,  sulegajo b100 where a100.codigo = b100.nro_legajo) and nro_nov_sist_ext not in (select idlicencia from PAYTBGLMNOV)";
		PreparedStatement psDesactivarSancionesLeg = null;

		try {

			psDesactivarSancionesLeg = this.getSesion().getConexionBD().prepareStatement(updDesactivarLosBorrados);
			psDesactivarSancionesLeg.executeUpdate();
			psDesactivarSancionesLeg.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de Servicio Medico " + e.getMessage());
		}

	}

	private void actualizarSancionesLegajos() throws BaseException {

		String queryInsSanciones = "INSERT INTO rhSancionesLeg (oid_sanc_leg,oid_legajo,oid_mot_falta,oid_mot_sancion,nro_sancion,fecha,fec_susp_desde,fec_reintegro,activo) " + "  select "
				+ "   SEQ_DBSANCIONESLEGAJO.NEXTVAL+3000, " + "   (select max(oid_legajo) from sulegajo where nro_legajo = a.fklegajo) oid_legajo, "
				+ "   (select max(oid_mot_falta) from rhMotivoFalta where codigo = a.idmotivo||'') oid_motivo_falta, "
				+ "   (select max(oid_mot_sancion) from rhMotivoSancion where codigo = a.idsancion||'') oid_motivo_sancion, a.id_sancion," + "   a.fecnov, " + "   A.FECDESSUSP, "
				+ "   a.fecreinteg, " + "   1 " + "  from " + "   paysanciones a " + "  where " + "   a.id_sancion not in (select nro_sancion from rhSancionesLeg) ";

		PreparedStatement psInsSancionesLeg = null;

		try {

			psInsSancionesLeg = this.getSesion().getConexionBD().prepareStatement(queryInsSanciones);
			psInsSancionesLeg.executeUpdate();
			psInsSancionesLeg.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de sanciones " + e.getMessage());
		}

		// Actualizar las sanciones

		String queryUpdSanciones = " UPDATE  /*+BYPASS_UJVC*/ " + " (SELECT " + "	a.oid_legajo AS old_oid_legajo, "
				+ " (select max(oid_legajo) from sulegajo where nro_legajo = b.fklegajo) AS new_oid_legajo , " + " a.oid_mot_falta AS old_oid_mot_falta, "
				+ " (select max(oid_mot_falta) from rhMotivoFalta where codigo = b.idmotivo||'') AS new_oid_mot_falta, " + " a.oid_mot_sancion AS old_oid_mot_sancion, "
				+ " (select max(oid_mot_sancion) from rhMotivoSancion where codigo = b.idsancion||'') AS new_oid_mot_sancion, " + " a.fecha as old_fecha, " + " b.fecnov as new_fecha, "
				+ " a.fec_susp_desde as old_fec_susp, " + " b.fecdessusp as new_fec_susp, " + " a.fec_reintegro as old_fec_rei, " + " b.fecreinteg as new_fec_rei " + " FROM rhSancionesLeg a "
				+ " INNER JOIN paysanciones b ON a.nro_sancion = b.id_sancion  ) " + " SET " + " old_oid_legajo = new_oid_legajo, " + " old_oid_mot_falta = new_oid_mot_falta, old_oid_mot_sancion = new_oid_mot_sancion , "
				+ " old_fecha = new_fecha, " + " old_fec_susp = new_fec_susp, " + " old_fec_rei = new_fec_rei ";

		PreparedStatement psUpdSancionesLeg = null;

		try {

			psUpdSancionesLeg = this.getSesion().getConexionBD().prepareStatement(queryUpdSanciones);
			psUpdSancionesLeg.executeUpdate();
			psUpdSancionesLeg.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de sanciones " + e.getMessage());
		}

		String updDesactivarLosBorrados = "update rhSancionesLeg set activo = 0 where oid_legajo in (SELECT b100.oid_legajo FROM payRemples a100 ,  sulegajo b100 where a100.codigo = b100.nro_legajo) and nro_sancion not in (select id_sancion from paysanciones)";
		PreparedStatement psDesactivarSancionesLeg = null;

		try {

			psDesactivarSancionesLeg = this.getSesion().getConexionBD().prepareStatement(updDesactivarLosBorrados);
			psDesactivarSancionesLeg.executeUpdate();
			psDesactivarSancionesLeg.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar la tabla de sanciones " + e.getMessage());
		}

	}

	public void actualizarValClasif() throws BaseException {

		// Actualizar los Datos de la Empresa
		PreparedStatement querySelect = null;
		ClasificadorEntidad clasifEmpresa = this.getClasifEmpresa(this.getSesion());

		// INSERTAR LAS EMPRESAS NUEVAS
		String query = "INSERT INTO GEVALCLASIFENT(" + "OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) " + " SELECT "
				+ " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000," + clasifEmpresa.getOIDInteger().toString() + ",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000,-1,1,1,"
				+ "'TITULO','0','0',UPPER(TRIM(EMPRESA.EMPRESA)),TRIM(EMPRESA.NOMBRE) " + " FROM "
				+ " (SELECT EMPRESA,NOMBRE FROM PAYEMPRESA) EMPRESA WHERE TRIM(EMPRESA) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT=" + clasifEmpresa.getOIDInteger().toString()
				+ " ) ";
		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. EMPRESAS: " + e.getMessage());
		}

		// MODIFICAR LAS EMPRESAS EXISTENTES

		query = " UPDATE  /*+BYPASS_UJVC*/ ( " + " SELECT " + "  a.descripcion AS old_descripcion, " + "  b.nombre AS new_descripcion " + " FROM GEVALCLASIFENT a "
				+ " INNER JOIN PAYEMPRESA b ON a.codigo = b.empresa WHERE a.oid_clasif_ent = " + clasifEmpresa.getOIDInteger().toString() + " " + " ) "
				+ " SET old_descripcion = new_descripcion WHERE old_descripcion <> new_descripcion ";

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. EMPRESAS: " + e.getMessage());
		}

		// ******************************//
		// Insertar los centos de costos //
		// ******************************//
		ClasificadorEntidad clasifCECO = this.getClasifSector(this.getSesion());

		query = " INSERT INTO GEVALCLASIFENT( " + " OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) " + " SELECT "
				+ " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000," + clasifCECO.getOIDInteger().toString() + ",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000,-1,1,1, "
				+ " 'TITULO','0','0',UPPER(TRIM(RTABLAS.CODIGO)),TRIM(RTABLAS.DESCRIP) " + " FROM " + " (SELECT CODIGO,DESCRIP FROM PAYRTABLAS WHERE COTAB=" + getCotabSectorUTE(this.getSesion())
				+ " ) RTABLAS WHERE TRIM(CODIGO) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT=" + clasifCECO.getOIDInteger().toString() + ") ";

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. CECOS: " + e.getMessage());
		}
		
		
		query = " update GEVALCLASIFENT a "+ 
		 		" set a.descripcion=(select descripcion from PAYRTABLAS b where a.codigo = b.codigo and b.cotab="+getCotabSectorUTE(this.getSesion())+") "+ 
		 		" where a.oid_clasif_ent = "+clasifCECO.getOIDInteger().toString()+" ";
		

		// Actualizar los Datos del Centro de Costos
		/* esto se dejo de unsar porque no pude hacer que funcione en produccion */
		/*query = " UPDATE  +BYPASS_UJVC ( " + " SELECT " + "  a.descripcion AS old_descripcion, " + "  b.descrip AS new_descripcion " + " FROM GEVALCLASIFENT a "
				+ " INNER JOIN PAYRTABLAS b ON a.codigo = b.codigo WHERE a.oid_clasif_ent = " + clasifCECO.getOIDInteger().toString() + "  and b.cotab = " + getCotabSectorUTE(this.getSesion()) + " "
				+ " ) " + " SET old_descripcion = new_descripcion WHERE old_descripcion <> new_descripcion ";*/

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. CECOS: " + e.getMessage());
		}

		// ******************************//
		// Actualizar los puestos //
		// ******************************//
		ClasificadorEntidad clasifPuesto = this.getClasifPuesto(this.getSesion());
		

		query = " INSERT INTO GEVALCLASIFENT( " + " OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) " + " SELECT "
				+ " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000," + clasifPuesto.getOIDInteger().toString() + ",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000,-1,1,1, "
				+ " 'TITULO','0','0',UPPER(TRIM(RTABLAS.CODIGO)),TRIM(RTABLAS.DESCRIP) " + " FROM " + " (SELECT CODIGO,DESCRIP FROM PAYRTABLAS WHERE COTAB=" + getCotabPuestoUTE(this.getSesion())
				+ " ) RTABLAS WHERE TRIM(CODIGO) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT=" + clasifPuesto.getOIDInteger().toString() + ") ";

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. PUESTOS: " + e.getMessage());
		}

		
		query = " update GEVALCLASIFENT a "+ 
 		" set a.descripcion=(select descripcion from PAYRTABLAS b where a.codigo = b.codigo and b.cotab="+getCotabPuestoUTE(this.getSesion())+") "+ 
 		" where a.oid_clasif_ent = "+clasifPuesto.getOIDInteger().toString()+" ";

		
		// Actualizar los Datos del Centro de Costos
		/*query = " UPDATE   ( " + " SELECT " + "  a.descripcion AS old_descripcion, " + "  b.descrip AS new_descripcion " + " FROM GEVALCLASIFENT a "
				+ " INNER JOIN PAYRTABLAS b ON a.codigo = b.codigo WHERE a.oid_clasif_ent = " + clasifPuesto.getOIDInteger().toString() + "  and b.cotab = " + getCotabPuestoUTE(this.getSesion())
				+ " " + " ) " + " SET old_descripcion = new_descripcion WHERE old_descripcion <> new_descripcion ";*/

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. PUESTO: " + e.getMessage());
		}

		/****************************/
		/** ACTUALIZAR LOS ESTADOS **/
		/****************************/

		ClasificadorEntidad clasifEstado = this.getClasifEstado(this.getSesion());
		query = "INSERT INTO GEVALCLASIFENT(" + "OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) " + " SELECT "
				+ " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000," + clasifEstado.getOIDInteger().toString() + ",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+3000,-1,1,1,"
				+ "'TITULO','0','0',UPPER(TRIM(ESTADO.ESTADO)),TRIM(ESTADO.ESTADO) " + " FROM "
				+ " (SELECT DISTINCT ESTADO FROM PAYREMPLES) ESTADO WHERE TRIM(ESTADO) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT=" + clasifEstado.getOIDInteger().toString()
				+ " ) ";
		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. ESTADOS: " + e.getMessage());
		}

		// Actualizar los historicos de Puestos
// 
		query = "INSERT INTO rhHistPuestos (oid_hist_puesto,oid_legajo,fec_desde,oid_val_clasif_emp,oid_val_clasif_sec, oid_val_clasif_pue,activo) " + " select "
				+ "   SEQ_DBHISTORICOPUESTO.nextval+3000,(select max(oid_legajo) from suLegajo where nro_legajo = a.legajo) oid_legajo, " + "   a.fecha, "
				+ "   (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifEmpresa.getOIDInteger() + " and codigo=trim(a.empresa)||'') empresa, "
				+ "   (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifCECO.getOIDInteger() + " and codigo=a.cencos||'') cencos, " 
				+ "   (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifPuesto.getOIDInteger() + " and codigo=a.cargo||'') cargo, " + 
				"   1 "
				+ "  from payHistPuestos a " + " where " + "  (select max(oid_legajo) from suLegajo where nro_legajo = a.legajo) is not null and "
				+ "  (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifPuesto.getOIDInteger() + " and codigo=a.cargo||'') is not null and " 
				+ "  (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifEmpresa.getOIDInteger() + " and codigo=trim(a.empresa)||'') is not null and " 
				+ "  (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifCECO.getOIDInteger() + " and codigo=a.cencos||'') is not null and " +
				" not exists ( "
				+ "  select * from rhHistPuestos where " + "      oid_legajo = (select max(oid_legajo) from suLegajo where nro_legajo = a.legajo) " + "      and fec_desde = a.fecha "
				+ "      and oid_val_clasif_pue = (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifPuesto.getOIDInteger() + " and codigo=a.cargo||'')"
				+ "      and oid_VAL_CLASIF_EMP = (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifEmpresa.getOIDInteger() + " and codigo=trim(a.empresa)||'')"
				+ "      and OID_VAL_CLASIF_SEC = (SELECT oid_val_clasif_ent FROM GEVALCLASIFENT WHERE oid_clasif_ent = " + clasifCECO.getOIDInteger() + " and codigo=a.cencos||'')"+
				
				" ) ";

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Error al actualizar el Historico de Puestos " + e.getMessage());
		}

		query = " update rhHistPuestos set activo = 1 where oid_legajo in (SELECT b100.oid_legajo FROM payRemples a100 ,  sulegajo b100 where a100.codigo = b100.nro_legajo) ";

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar el Historico de Puestos " + e.getMessage());
		}
		
		
		query = " UPDATE RHHISTPUESTOS SET ACTIVO = 0 WHERE OID_HIST_PUESTO IN ( "+
		        "  SELECT OID_HIST_PUESTO FROM ( "+               
		        "      SELECT OID_LEGAJO,FEC_DESDE,OID_VAL_CLASIF_PUE,OID_VAL_CLASIF_SEC,OID_VAL_CLASIF_EMP FROM ( "+      
		        "      SELECT "+ 
		        "                DISTINCT "+
		        "                OID_LEGAJO, "+
		        "                FEC_DESDE, "+
		        "                OID_VAL_CLASIF_PUE, "+
		        "                OID_VAL_CLASIF_SEC, "+
		        "                OID_VAL_CLASIF_EMP "+
		        "            FROM "+
		        "              rhhistpuestos "+                
		        "          MINUS "+
		        "        SELECT DISTINCT "+
		        "              (select b.oid_legajo from sulegajo b where b.nro_legajo = a.legajo  ) oid_legajo, "+
		        "              a.fecha, "+
		        "              (select oid_val_clasif_ent from gevalclasifent c where c.oid_clasif_ent = "+clasifPuesto.getOIDInteger()+" and c.codigo = a.cargo||'' ) oid_cargo, "+
		        "              (select oid_val_clasif_ent from gevalclasifent d where d.oid_clasif_ent = "+clasifCECO.getOIDInteger()+" and d.codigo = a.cencos||'' ) oid_cenco, "+
		        "              (select oid_val_clasif_ent from gevalclasifent d where d.oid_clasif_ent = "+clasifEmpresa.getOIDInteger()+" and d.codigo = trim(a.empresa)||'' ) oid_empresa "+  
		        " 		FROM "+ 
		        "              payhistpuestos a) TRABLA1 "+              
		        "    ) C1 , RHHISTPUESTOS C2 "+ 
		        "    WHERE "+
		        "      C1.OID_LEGAJO=C2.OID_LEGAJO AND "+
		        "      C1.FEC_DESDE=C2.FEC_DESDE AND "+
		        "      C1.OID_VAL_CLASIF_PUE=C2.OID_VAL_CLASIF_PUE AND "+
		        "      C1.OID_VAL_CLASIF_SEC=C2.OID_VAL_CLASIF_SEC AND "+
		        "      C1.OID_VAL_CLASIF_EMP=C2.OID_VAL_CLASIF_EMP "+
		        "    ) ";		
		

		/*
		query = " update rhHistPuestos a set activo = 0 "
				+ " where oid_legajo in (SELECT b100.oid_legajo FROM payRemples a100 ,  sulegajo b100 where a100.codigo = b100.nro_legajo) and not exists "
				+ " (select * from payHistPuestos b where b.legajo = (select nro_legajo from sulegajo where oid_legajo= a.oid_legajo) "+
				" and b.fecha = a.fec_desde and "+
				" b.cargo = (select max(to_number(codigo)) from gevalclasifent where oid_clasif_ent = "+ clasifPuesto.getOIDInteger() +" and a.oid_val_clasif_pue = OID_VAL_CLASIF_ENT ) and "+
				" b.cencos = (select max(to_number(codigo)) from gevalclasifent where oid_clasif_ent = "+ clasifCECO.getOIDInteger() +" and a.oid_val_clasif_sec = OID_VAL_CLASIF_ENT )  and "+
				" trim(b.empresa) = (select max((codigo)) from gevalclasifent where oid_clasif_ent = "+ clasifEmpresa.getOIDInteger() +" and a.oid_val_clasif_emp = OID_VAL_CLASIF_ENT )"+
				") ";
				*/

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar el Historico de Puestos " + e.getMessage());
		}

	}

	public static ClasificadorEntidad getClasifEmpresa(ISesion aSesion) throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro("CLASIF_EMPRESA_UTE", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(oidClasifProd, aSesion);
		return clasifEnt;
	}

	public static ClasificadorEntidad getClasifSector(ISesion aSesion) throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro("CLASIF_SECTOR_UTE", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(oidClasifProd, aSesion);
		return clasifEnt;
	}

	public static ClasificadorEntidad getClasifPuesto(ISesion aSesion) throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro("CLASIF_PUESTO_UTE", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(oidClasifProd, aSesion);
		return clasifEnt;
	}

	public static ClasificadorEntidad getClasifEstado(ISesion aSesion) throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro("CLASIF_ESTADO_UTE", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(oidClasifProd, aSesion);
		return clasifEnt;
	}

	public static Integer getCotabSectorUTE(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTAB_SECTOR_UTE", aSesion).getValorEntero();
	}

	public static Integer getCotabMotivoSector(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTAB_MOT_EGRESO", aSesion).getValorEntero();
	}

	public static Integer getCotabMotivoFalta(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTAB_MOT_FALTA", aSesion).getValorEntero();
	}

	public static Integer getCotabMotivoSancion(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTAB_MOT_SANCION", aSesion).getValorEntero();
	}

	public static Integer getCotabGradoLegajo(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTABGRADOUTE", aSesion).getValorEntero();
	}
	
	public static Integer getCotabTareaDesemp(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTABTAREADESEMP", aSesion).getValorEntero();
	}	

	public static Integer getCotabTipoDocu(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTAB_TIPO_DOCU", aSesion).getValorEntero();
	}

	public static Integer getCotabPuestoUTE(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTAB_PUESTO_UTE", aSesion).getValorEntero();
	}

	public void actualizarLegajos() throws BaseException {

		ClasificadorEntidad clasifCECO = this.getClasifSector(this.getSesion());
		ClasificadorEntidad clasifEmpresa = this.getClasifEmpresa(this.getSesion());
		ClasificadorEntidad clasifPuesto = this.getClasifPuesto(this.getSesion());
		ClasificadorEntidad clasifEstado = this.getClasifEstado(this.getSesion());

		PreparedStatement querySelect = null;
		String query = " INSERT INTO SULEGAJO "
				+ " (OID_LEGAJO,NRO_LEGAJO,NOMBRE,APELLIDO,ACTIVO,OID_CLASIF_01,OID_CLASIF_02, OID_CLASIF_03 , OID_CLASIF_04 , "
				+ " FEC_INGRESO,FEC_RETIRO,ACT_ANTI_PASS_BACK, "
				+ " IGNORAR_PROX_APB,CIRCUITO_CACHEO,LIB_ING_AL_PREDIO "
				+ " , CUIL , SEXO , DIRECCION , OID_ESTADO_CIVIL , FEC_NAC , OID_TIPO_DOCUMENTO , NRO_DOCUMENTO ,TEL_PARTICULAR"
				+ " ,TEL_CELULAR,OID_CLASE_SIND,FEC_ANT_RECO,OID_MOT_EGRESO,FEC_VENC_PROT,FEC_ING_UTE , OID_GRADO_LEG , OID_TAREA_DESEMP "
				+ ")"
				+ " SELECT SEQ_DBLEGAJO.NEXTVAL+3000, UPPER(TRIM(payRemples.codigo)),trim(NVL(SUBSTR(payRemples.nombre,INSTR(payRemples.nombre,',')+1,100),'')), "
				+ " trim(NVL(SUBSTR(payRemples.nombre,1,INSTR(payRemples.nombre,',')-1),'')),1, "
				+ " (SELECT MAX(GEVALCLASIFENT.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  GEVALCLASIFENT.OID_CLASIF_ENT = "
				+ clasifEmpresa.getOIDInteger().toString()
				+ " AND GEVALCLASIFENT.CODIGO = payRemples.empresa||'') , "
				+ " (SELECT MAX(GEVALCLASIFENT.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  GEVALCLASIFENT.OID_CLASIF_ENT = "
				+ clasifCECO.getOIDInteger().toString()
				+ " AND GEVALCLASIFENT.CODIGO = payRemples.cencos||''), "
				+ " (SELECT MAX(GEVALCLASIFENT.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  GEVALCLASIFENT.OID_CLASIF_ENT = "
				+ clasifPuesto.getOIDInteger().toString()
				+ " AND GEVALCLASIFENT.CODIGO = payRemples.cargo||''), "
				+ " (SELECT MAX(GEVALCLASIFENT.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  GEVALCLASIFENT.OID_CLASIF_ENT = "
				+ clasifEstado.getOIDInteger().toString()
				+ " AND GEVALCLASIFENT.CODIGO = payRemples.estado||''), "
				+ " payRemples.fecha_ing,payRemples.fecha_ret,"
				+ " 0,0,0,0,rut,sexo,direccion,OID_ESTADO_CIVIL,FECHA_NAC, OID_TIPO_DOCUMENTO,NUMDOC,FONO,CELULAR,OID_CLASE_SIND,FECHA_ARE,oid_mot_egreso,FECHA_ISA,FECHA_XTR , (SELECT MAX(OID_GRADO_LEG) FROM rhGradosLeg WHERE CODIGO=payRemples.GRADO||'') , (SELECT MAX(OID_TAREA_DESEMP) FROM RHTAREA_DESEMP WHERE CODIGO=payRemples.SECCION||'') "
				+ " FROM "
				+ " (SELECT j1.empresa,j1.codigo,j1.nombre,j1.estado,j1.fecha_ing,j1.fecha_ret,j1.cencos,j1.cargo "
				+ " ,j1.rut , j1.sexo , j1.direccion , (select OID_ESTADO_CIVIL from veEstadoCivil where codigo = j1.EST_CIVIL) OID_ESTADO_CIVIL , j1.FECHA_NAC , (select OID_TIPO_DOCUMENTO from veTipoDocumento where codigo=j1.TIPO_DOC||'') OID_TIPO_DOCUMENTO , j1.NUMDOC , j1.FONO , j1.CELULAR , "
				+ " (select OID_CLASE_SIND from rhClaseSindicato where codigo=j1.CLASE||'') OID_CLASE_SIND, j1.FECHA_ARE ,(select oid_mot_egreso from rhMotivoEgreso where codigo=j1.MOTI_RET||'') oid_mot_egreso , j1.FECHA_ISA , j1.FECHA_XTR , j1.grado , j1.seccion "
				+ " from payRemples j1 , suLegajo j2   WHERE j2.nro_legajo(+)=j1.codigo  and j2.nro_legajo is null and j1.empresa in (" + getINEmpresasLegajoPAYROLL() + ") ) payRemples ";
		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar LEGAJOS: " + e.getMessage());
		}

		/** Updetaer los Nuevos Legajos **/

		query = " UPDATE  /*+BYPASS_UJVC*/ ";
		query = query + " (  ";
		query = query + " SELECT ";

		query = query + "    a.fec_nac AS old_fec_nac, ";
		query = query + "    b.fecha_nac AS new_fec_nac, ";

		query = query + "    a.oid_grado_leg AS old_oid_grado_leg, ";
		query = query + "    (SELECT OID_GRADO_LEG FROM rhGradosLeg hh WHERE  hh.codigo = b.grado||'') AS new_oid_grado_leg, ";

		query = query + "    a.fec_venc_prot AS old_fec_venc_prot, ";
		query = query + "    b.FECHA_ISA AS new_fec_venc_prot, ";

		query = query + "    a.fec_ing_ute AS old_fec_ing_ute, ";
		query = query + "    b.FECHA_XTR AS new_fec_ing_ute, ";

		query = query + "    a.tel_particular AS old_tel_particular, ";
		query = query + "    b.fono AS new_tel_particular, ";

		query = query + "    a.tel_celular AS old_tel_celular, ";
		query = query + "    b.CELULAR AS new_tel_celular, ";

		query = query + "    a.nro_documento AS old_nro_doc, ";
		query = query + "    b.NUMDOC AS new_nro_doc, ";

		query = query + "    a.fec_ant_reco AS old_fec_ant_reco, ";
		query = query + "    b.FECHA_ARE AS new_fec_ant_reco, ";

		query = query + "    a.oid_tipo_documento AS old_oid_tipo_documento, ";
		query = query + "    (SELECT OID_TIPO_DOCUMENTO FROM veTipoDocumento hh WHERE  hh.codigo = b.TIPO_DOC||'') AS new_oid_tipo_documento, ";

		query = query + "    a.oid_clase_sind AS old_oid_clase_sind, ";
		query = query + "    (SELECT oid_clase_sind FROM rhClaseSindicato hh WHERE  hh.codigo = b.clase||'') AS new_oid_clase_sind, ";

		query = query + "    a.oid_mot_egreso AS old_oid_mot_egreso, ";
		query = query + "    (SELECT oid_mot_egreso FROM rhMotivoEgreso hh WHERE  hh.codigo = b.MOTI_RET||'') AS new_oid_mot_egreso, ";

		query = query + "    a.cuil AS old_cuil, ";
		query = query + "    b.rut AS new_cuil, ";
		query = query + "    a.sexo AS old_sexo, ";
		query = query + "    b.sexo AS new_sexo, ";
		query = query + "    a.direccion AS old_direccion, ";
		query = query + "    b.direccion AS new_direccion, ";
		query = query + "    a.activo AS old_activo, ";
		query = query + "    1 AS new_activo,   ";
		query = query + "    a.nombre AS old_nombre, ";
		query = query + "    substr(trim(NVL(SUBSTR(b.nombre,INSTR(b.nombre,',')+1,100),'')),1,50) AS new_nombre, ";
		query = query + "    a.apellido AS old_apellido,  ";
		query = query + "    substr(trim(NVL(SUBSTR(b.nombre,1,INSTR(b.nombre,',')-1),'')),1,50) AS new_apellido, ";
		query = query + "    a.fec_ingreso as old_fec_ingreso,  ";
		query = query + "    b.fecha_ing as new_fec_ingreso,   ";
		query = query + "    a.fec_retiro as old_fec_egreso,   ";
		query = query + "    b.fecha_ret as new_fec_egreso,  ";

		query = query + "    a.oid_estado_civil AS old_oid_estado_civil, ";
		query = query + "    (SELECT OID_ESTADO_CIVIL FROM veEstadoCivil hh WHERE  hh.codigo =  b.EST_CIVIL||'') AS new_oid_estado_civil, ";
		
		query = query + "    a.oid_tarea_desemp AS old_oid_tarea_desemp, ";
		query = query + "    (SELECT OID_TAREA_DESEMP FROM rhtarea_desemp hh WHERE  hh.codigo =  b.SECCION||'') AS new_oid_tarea_desemp, ";		

		query = query + "    a.oid_clasif_01 AS old_oid_clasif_01, ";
		query = query + "    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = " + clasifEmpresa.getOIDInteger().toString()
				+ " AND hh.CODIGO = b.empresa||'') AS new_oid_clasif_01, ";
		query = query + "    a.oid_clasif_02 AS old_oid_clasif_02, ";
		query = query + "    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = " + clasifCECO.getOIDInteger().toString()
				+ " AND hh.CODIGO = b.cencos||'') AS new_oid_clasif_02, ";
		query = query + "    a.oid_clasif_03 AS old_oid_clasif_03, ";
		query = query + "    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = " + clasifPuesto.getOIDInteger().toString()
				+ " AND hh.CODIGO = b.cargo||'') AS new_oid_clasif_03, ";
		query = query + "    a.oid_clasif_04 AS old_oid_clasif_04, ";
		query = query + "    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = " + clasifEstado.getOIDInteger().toString()
				+ " AND hh.CODIGO = b.estado||'') AS new_oid_clasif_04 ";
		query = query + " FROM   ";
		query = query + "    SULEGAJO a INNER JOIN PAYREMPLES b ON a.nro_legajo = b.codigo  ";
		query = query + "     WHERE  1 = 1";

		query = query + "      )   ";
		query = query + "  SET  ";
		query = query + "       old_fec_nac = new_fec_nac ,  ";
		query = query + "       old_oid_grado_leg = new_oid_grado_leg ,  ";
		query = query + "       old_fec_venc_prot = new_fec_venc_prot , ";
		query = query + "       old_fec_ing_ute = new_fec_ing_ute , ";
		query = query + "       old_tel_particular = new_tel_particular , ";
		query = query + "       old_tel_celular = new_tel_celular , ";
		query = query + "       old_nro_doc = new_nro_doc ,  ";
		query = query + "       old_fec_ant_reco = new_fec_ant_reco ,  ";
		query = query + "       old_oid_tipo_documento = new_oid_tipo_documento, ";
		query = query + "       old_oid_clase_sind = new_oid_clase_sind, ";
		query = query + "       old_oid_mot_egreso = new_oid_mot_egreso, ";
		query = query + "       old_cuil = new_cuil ,  ";
		query = query + "       old_sexo = new_sexo ,  ";
		query = query + "       old_direccion = new_direccion ,  ";
		query = query + "       old_activo = new_activo ,  ";
		query = query + "       old_nombre = new_nombre ,   ";
		query = query + "       old_apellido = new_apellido ,   ";
		query = query + "       old_fec_ingreso = new_fec_ingreso,  ";
		query = query + "       old_fec_egreso = new_fec_egreso,   ";
		query = query + "       old_oid_estado_civil = new_oid_estado_civil,   ";
		query = query + "       old_oid_tarea_desemp = new_oid_tarea_desemp,   ";
		query = query + "       old_oid_clasif_01 = new_oid_clasif_01, ";
		query = query + "       old_oid_clasif_02 = new_oid_clasif_02, ";
		query = query + "       old_oid_clasif_03 = new_oid_clasif_03, ";
		query = query + "       old_oid_clasif_04 = new_oid_clasif_04 ";

		// System.out.println(query);

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar LEGAJOS: " + e.getMessage());
		}

		// DESACTIVAR LEGAJOS NO INFORMADOS

		query = " UPDATE SULEGAJO SET ACTIVO = 0 WHERE oid_legajo in (SELECT b100.oid_legajo FROM payRemples a100 ,  sulegajo b100 where a100.codigo = b100.nro_legajo) and NRO_LEGAJO IN ( "
				+ "  (SELECT NRO_LEGAJO FROM SULEGAJO MINUS " + "  SELECT CODIGO FROM PAYREMPLES)) ";

		try {

			querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			querySelect.executeUpdate();
			querySelect.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Erro al actualizar LEGAJOS: " + e.getMessage());
		}

	}

	private String getINEmpresasLegajoPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("IN_EMPRESAS_LEG_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private void actualizarTareasDesempeneadas() throws BaseException {

		Statement staQueryRTablas;
		try {
			staQueryRTablas = getSesion().getConexionBD().createStatement();
			ResultSet rsRTablas = staQueryRTablas.executeQuery("select codigo,descrip from payrtablas where cotab=" + this.getCotabTareaDesemp(this.getSesion()).toString());
			while (rsRTablas.next()) {
				String codigo = rsRTablas.getString("codigo");
				String desc = rsRTablas.getString("descrip");
				TareaDesempeneada tareaDesemp = TareaDesempeneada.findByCodigo(codigo, this.getSesion());
				if (tareaDesemp != null)
					tareaDesemp.setDescripcion(desc);
				else {
					tareaDesemp = (TareaDesempeneada) TareaDesempeneada.getNew(TareaDesempeneada.NICKNAME, this.getSesion());
					tareaDesemp.setCodigo(codigo);
					tareaDesemp.setDescripcion(desc);
					tareaDesemp.setActivo(true);
				}
				tareaDesemp.save();
			}
			staQueryRTablas.close();
			rsRTablas.close();

			this.getSesion().getConexionBD().commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
