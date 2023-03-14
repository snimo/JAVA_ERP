package com.srn.erp.impuestos.bm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.bm.TablaPercIBBsAs;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class  GrabarTablaPercIBBsAs {
	
	private List lsCuitsPendReg = new ArrayList();
	private List tablas = new ArrayList();
	private boolean importarSoloClientes = false;
	private int commitCadaXReg = 200;
	private int cantRegLot = 0;
	
	public boolean isImportarSoloClientes() {
		return importarSoloClientes;
	}

	public void setImportarSoloClientes(boolean importarSoloClientes) {
		this.importarSoloClientes = importarSoloClientes;
	}

	public ISesion getSesion() {
		return sesion;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}
	
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	ISesion sesion;
	String archivo;
	
	public void comenzarImportacion() throws BaseException {
		
		if (ValorParametro.findByCodigoParametro("IMP_SOLO_CLI_ARCH_PIB_BSAS", this.getSesion()).getBoolean())
			this.importarSoloClientes = true;
		
		
		String path = 
			ValorParametro.findByCodigoParametro("FILE_NAME_IIBBBSAS",this.getSesion()).getValorCadena();
		
	    File inputFile = new File(path,this.getArchivo().trim());
			  	
		if (inputFile == null) throw new ExceptionValidation(null,"No se pudo encontrar el archivo "+this.getArchivo().trim());
			  	
	    FileInputStream arch = null;
		try {
				arch = new FileInputStream(inputFile);
		}
		catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"No se pudo encontrar el archivo "+this.getArchivo().trim());
		}
					
		String linea = null;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(arch));
		try {
				linea = entrada.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"Error al leer el archivo "+this.getArchivo().trim());
		}
					
		int cantReg = 0;
		int cantInsert = 0;
		while (linea != null) {
			// no mover este incremento.

			java.util.Date fecPublicacion = this.getFechaFromString(linea.substring(0, 8));
			if (cantReg == 0)
				this.cargarCuitsPendReg(fecPublicacion);
			// this.borrarGrabacionesAnteriores(fecPublicacion);
			cantReg++;
			//System.out.println(cantReg);
						
			String cuit = linea.substring(27, 29)   + linea.substring(29, 37) +  linea.substring(37, 38);
			if ((this.importarSoloClientes) && (!lsCuitsPendReg.contains(cuit))) {
				try {
					linea = entrada.readLine();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					throw new ExceptionValidation(null,"Se produjo un error al leer una linea del archivo");
				}
				continue;
			}
							
			Date fecVigDesde = this.getFechaFromString(linea.substring(9, 17));
			Date fecVigHasta = this.getFechaFromString(linea.substring(18, 26));

			String tipo = linea.substring(39, 40);
			String marcaABSujeto = linea.substring(41, 42);
			String marcaCambioAlicuota = linea.substring(43, 44);
			double aliPercepcion = new Double(linea.substring(45, 48).replaceAll(",", ".")).doubleValue();
			double aliRetencion = new Double(linea.substring(50, 54).replaceAll(",", ".")).doubleValue();
			int nroGrupoPercepcion = new Integer(linea.substring(55, 57)).intValue();
			int nroGrupoRetencion = new Integer(linea.substring(58, 60)).intValue();

							
			TablaPercIBBsAs tabla = null;
			
			tabla = TablaPercIBBsAs.getRegistroPorCUITyFecPub(cuit,fecPublicacion,this.getSesion());
			if (tabla == null)
				tabla = (TablaPercIBBsAs) TablaPercIBBsAs.getNew(TablaPercIBBsAs.NICKNAME,this.getSesion());
			
			tabla.setFec_public(fecPublicacion);
			tabla.setFec_vig_desde(fecVigDesde);
			tabla.setFec_vig_hasta(fecVigHasta);
			tabla.setCuit(cuit);
			tabla.setTipo(tipo);
			tabla.setMarca_ab_sujeto(marcaABSujeto);
			tabla.setMarca_cambio_ali(marcaCambioAlicuota);
			tabla.setAli_percepcion(new Porcentaje(aliPercepcion));
			tabla.setAli_retencion(new Porcentaje(aliRetencion));
			tabla.setNro_gr_per(new Integer(nroGrupoPercepcion));
			tabla.setNro_gr_ret(new Integer(nroGrupoRetencion));
			tabla.save();
			
			++cantRegLot;
						
			tabla = null;
			
			try {
				
				if (cantRegLot>commitCadaXReg) {
					this.getSesion().getConexionBD().commit();
					cantRegLot = 0;
				}
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Se produjo un error al comitear el registro de Perc. I.B. Bs. As.");
			}
			
			//tablas.add(tabla);
						
			cantInsert++;
			
			try {
				linea = entrada.readLine();
			}
				catch (IOException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Se produjo un error al leer una linea del archivo");
			}
		}
		try {
			arch.close();
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"Se produjo un error al cerrar el archivo");
		}
					
	}
	
	public Date getFechaFromString(String aFechaString) {
		int anio = new Integer(aFechaString.substring(4, 8)).intValue();
		int mes = new Integer(aFechaString.substring(2, 4)).intValue();
		int dia = new Integer(aFechaString.substring(0, 2)).intValue(); 
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, anio);
		cal.set(Calendar.MONTH, mes-1);
		cal.set(Calendar.DATE, dia);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND,0);
		return cal.getTime();

	}
	
	private void cargarCuitsPendReg(Date aFechaPublicacion) throws BaseException {
			
		Iterator iterSujetos = 
			SujetoImpositivo.getAllSujetos(this.getSesion()).iterator();
		while (iterSujetos.hasNext()) {
			SujetoImpositivo sujetoImpositivo = (SujetoImpositivo) iterSujetos.next();
			if (sujetoImpositivo.getCuit()!=null)
				lsCuitsPendReg.add(sujetoImpositivo.getCuit());
		}
			
	}
	
	public List getTablas() throws BaseException {
		return this.tablas;
	}
	
		
		
	
}