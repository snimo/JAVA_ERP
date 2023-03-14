package com.srn.erp.conciTarjeta.bm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ImpArchVISACobTar extends ImpArchCobTar {
	

	public void setSession(ISesion session) {
		this.session = session;
	}
	
	public void importar() throws BaseException {
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.archivo));
			int nroLinea = 1;
			// Abrir el archivo de texto
			 String str;
			 boolean procDet = false;
			 while ((str = in.readLine()) != null) {
				 
				    if (str.startsWith("Fecha Presentacion,")) {
				    	procDet = true;
				    	continue;
				    }
				 
				 	if (procDet) {
				 		procesarDetalle(str);
				 		++nroLinea;
				 	}
			 }
			 in.close();
		} catch (FileNotFoundException e) {
			throw new ExceptionValidation(null,"Problemas al procesar el archivo:"+this.archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"Problemas al procesar el archivo:"+this.archivo);
		}
	}
	
	public static String getOnlyNumerics(String str) {        
		if (str == null) {        
			return "0";    
		}    
		if (str.trim().equals(""))
			return "0";
		StringBuffer strBuff = new StringBuffer();    
		char c;        
		for (int i = 0; i < str.length() ; i++) {        
			c = str.charAt(i);                
			if (Character.isDigit(c)) {            
				strBuff.append(c);        
				}    
		}    
		return strBuff.toString();
	}	
	
	private void procesarDetalle(String str) throws BaseException {
		
		java.util.Date fecPresentacion = null;
		Integer nroLote = null;
		java.util.Date fecPago = null;
		java.util.Date fecOrigen = null;
		String descripcion = null;
		Integer comprobante = null;
		Integer nroTarjeta = null;
		Integer plan = 0;
		Integer cuota = 0;
		String moneda = "";
		double importe = 0;
		String tipoTarjeta = "";
		String tipoOperacion = "";
		
		
		String[] campos = str.split("\\,");
		for (int i=0;i<=campos.length-1;++i) {							
			
			if (i==0) {
				String fecPresen = campos[i];
				Integer diaPresen = new Integer(fecPresen.substring(0,2));
				Integer mesPresen = getMes(fecPresen.substring(3,6).toUpperCase());
				Integer anioPresen = new Integer(fecPresen.substring(7,11));
				fecPresentacion = Fecha.getFecha(diaPresen, mesPresen, anioPresen);
			} else
			if (i==1) {
				nroLote = new Integer(campos[i]);
			} else 			
			if (i==2) {
				String fecPago1 = campos[i];
				Integer diaPago = new Integer(fecPago1.substring(0,2));
				Integer mesPago = getMes(fecPago1.substring(3,6).toUpperCase());
				Integer anioPago = new Integer(fecPago1.substring(7,11));
				fecPago = Fecha.getFecha(diaPago,mesPago,anioPago);
			} else
			if (i==3) {
				descripcion = campos[i];
				tipoOperacion = "";
				if (descripcion.trim().equals("CONS. $")) 
					tipoOperacion="COMPRA";
				else
					tipoOperacion=descripcion.trim();
			} else
			if (i==4) {
				String fecOrigen1 = campos[i];
				Integer diaOrigen = new Integer(fecOrigen1.substring(0,2));
				Integer mesOrigen = getMes(fecOrigen1.substring(3,6).toUpperCase());
				Integer anioOrigen = new Integer(fecOrigen1.substring(7,11));
				fecOrigen = Fecha.getFecha(diaOrigen,mesOrigen,anioOrigen);				
			} else 
			if (i==5) {
				try {
					comprobante = new Integer(getOnlyNumerics(campos[i].trim()));
				} catch (Exception e) {comprobante = new Integer(0);}
			} else
			if (i==6) {
				nroTarjeta = new Integer(campos[i].substring(14, 18));
			} else
			if (i==7) {
				plan = new Integer(campos[i]);
			} else
			if (i==8) {
				cuota = new Integer(campos[i]);
			} else 		
			if (i==9) {
				moneda = campos[i];
			} else
			if (i==10) {
				CalculadorMoney calc = new CalculadorMoney(new Money(campos[i].replace(".","")));
				calc.dividirPor(new Money(100));
				importe = calc.getResult();
			}
		}
		
		String tarjeta = "";
		int dias = Fecha.fechasDiferenciaEnDias(fecPresentacion, fecPago);
		if (dias>10) {
			tipoTarjeta = TarjetaConciTar.TIPO_TARJ_CRE;
			tarjeta = ConciliarAutomaticaTarj.CA_VISA;
		}
		else {
			tipoTarjeta = TarjetaConciTar.TIPO_TARJ_DEB;
			tarjeta = ConciliarAutomaticaTarj.CA_VISA_DEBITO;
		}
		
		// Grabar el Registros
		DetTarConciEnt detTarConciEnt = (DetTarConciEnt)
			DetTarConciEnt.getNew(DetTarConciEnt.NICKNAME, this.session);
		detTarConciEnt.setTar_info_cab(cabTarConciEnt);
		detTarConciEnt.setEmpresa(cabTarConciEnt.getEmpresa());
		detTarConciEnt.setTipo_operacion(tipoOperacion);
		detTarConciEnt.setFec_present(fecPresentacion);
		detTarConciEnt.setLote(nroLote);
		detTarConciEnt.setFec_pago(fecPago);
		detTarConciEnt.setDescripcion(descripcion);
		detTarConciEnt.setFec_origen(fecOrigen);
		detTarConciEnt.setNro_comprobante(comprobante);
		detTarConciEnt.setNro_tarjeta(nroTarjeta);
		detTarConciEnt.setPlan(plan.toString());
		detTarConciEnt.setCuota(cuota.toString());
		detTarConciEnt.setMoneda(moneda);
		detTarConciEnt.setImporte(new Money(importe));
		detTarConciEnt.setComercio("");
		detTarConciEnt.setNro_cupon(comprobante);
		detTarConciEnt.setActivo(true);
		detTarConciEnt.setTipoTarjeta(tipoTarjeta);
		detTarConciEnt.setConciliado(false);
		detTarConciEnt.setTarjeta(tarjeta);
		if (detTarConciEnt.getTar_info_cab()!=null)
			detTarConciEnt.setNomArchivo(detTarConciEnt.getTar_info_cab().getNom_archivo());		
		detTarConciEnt.save();
		incrementarCantRegImp();
		
	}
	
	private int getMes(String mes) throws BaseException {
		if ((mes.equals("JAN") || mes.equals("ENE")))
			return 1;
		else
		if (mes.equals("FEB"))			
			return 2;
		else
		if (mes.equals("MAR"))			
			return 3;
		else
		if (mes.equals("APR"))			
			return 4;
		else
		if (mes.equals("MAY"))			
			return 5;		
		else
		if (mes.equals("JUN"))			
			return 6;		
		else
		if (mes.equals("JUL"))			
			return 7;
		else
		if ((mes.equals("AUG") || mes.equals("AGO")))
			return 8;
		else		
		if (mes.equals("SEP"))			
			return 9;
		else		
		if (mes.equals("OCT"))			
			return 10;
		else		
		if (mes.equals("NOV"))			
			return 11;		
		else		
		if ((mes.equals("DEC") || mes.equals("DIC")))			
			return 12;
		else
			throw new ExceptionValidation(null,"Mes desconocido "+mes);
		
	}
	
}
