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

public class ImpArchAMECobTar extends ImpArchCobTar {
	
	
	boolean procesoAlgunReg = false;
	
	public void setSession(ISesion session) {
		this.session = session;
	}
	
	public void importar() throws BaseException {
		// Esta es porque segun como se peque el archivo puede haber dos formatos posibles
		procConArchFormato1();
		if (procesoAlgunReg==false)
			procConArchFormato2();
	}
	
	private void procConArchFormato1() throws BaseException {
		try {
			BufferedReader in = new BufferedReader(new FileReader(this.archivo));
			int nroLinea = 1;
			// Abrir el archivo de texto
			 String str;
			 while ((str = in.readLine()) != null) {
				 		procesarDetalle(str);
				 		++nroLinea;
			 }
			 in.close();
		} catch (FileNotFoundException e) {
			throw new ExceptionValidation(null,"Problemas al procesar el archivo:"+this.archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"Problemas al procesar el archivo:"+this.archivo);
		}		
	}
	
	private void procConArchFormato2() throws BaseException {
		try {
			boolean procEncabezado = false;
			BufferedReader in = new BufferedReader(new FileReader(this.archivo));
			int nroLinea = 1;
			// Abrir el archivo de texto
			 String str;
			 while ((str = in.readLine()) != null) {
				 
				 		if ((procEncabezado==false) && 
				 			(str.contains("Transacción") && 
				 			 str.contains("Número de Socio") && 
				 			 str.contains("Monto de la Presentación"))) {
				 			procEncabezado = true;
				 			continue;
				 		}
				 		
				 		if (procEncabezado)
				 			procesarDetalle2(str);
				 		++nroLinea;
			 }
			 in.close();
		} catch (FileNotFoundException e) {
			throw new ExceptionValidation(null,"Problemas al procesar el archivo:"+this.archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"Problemas al procesar el archivo:"+this.archivo);
		}		
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
		Integer nroCupon = 0;
		String nroCliente = "";
		String tarjeta = "";
		
		
		String[] campos = str.split("\\t");
		
		// Si la longitud no es 6, entonces asumo que el formato del registro es desconocido
		if (!((campos.length==6) || (campos.length==7))) return;
		
		if ((campos.length==6)) {
			for (int i=0;i<=campos.length-1;++i) {							
				
				if (i==0) {
					String fecPresen = campos[i];
					if (!fecPresen.contains("/")) return;
					Integer diaPresen = new Integer(fecPresen.substring(0,2));
					Integer mesPresen = new Integer(fecPresen.substring(3,5));
					Integer anioPresen = new Integer(fecPresen.substring(6,10));
					fecPresentacion = Fecha.getFecha(diaPresen, mesPresen, anioPresen);
					fecOrigen = fecPresentacion; 
				} else
					if (i==1) {
						nroCupon = new Integer(campos[i].trim());
						comprobante = new Integer(campos[i].trim());
					} else 			
						if (i==2) {
							String nroTarjeta1 = campos[i];
							nroTarjeta = new Integer(nroTarjeta1.substring(nroTarjeta1.length()-5, nroTarjeta1.length()-1).trim()); 
						} else
							if (i==3) {
								CalculadorMoney calc = new CalculadorMoney(new Money(campos[i].replace(".","").replace(",","").trim()));
								calc.dividirPor(new Money(100));
								importe = calc.getResult();				
							} else
								if (i==4) {
									tipoTarjeta = TarjetaConciTar.TIPO_TARJ_CRE;
									tarjeta = ConciliarAutomaticaTarj.CA_AMERICAN;				
								} else 
									if (i==5) {
										cuota = new Integer(campos[i].trim());
									} 
			}
		} else 	if ((campos.length==7)) {
			for (int i=0;i<=campos.length-1;++i) {							
				
				if (i==0) {
					String fecPresen = campos[i];
					if (!fecPresen.contains("/")) return;
					Integer diaPresen = new Integer(fecPresen.substring(0,2));
					Integer mesPresen = new Integer(fecPresen.substring(3,5));
					Integer anioPresen = new Integer(fecPresen.substring(6,10));
					fecPresentacion = Fecha.getFecha(diaPresen, mesPresen, anioPresen);
					fecOrigen = fecPresentacion; 
				} else
					if (i==1) {
						nroCupon = new Integer(campos[i].trim());
						comprobante = new Integer(campos[i].trim());
					} else 		
						if (i==2) {
							nroCliente = campos[i];
						} else
							if (i==3) {
								String nroTarjeta1 = campos[i];
								nroTarjeta = new Integer(nroTarjeta1.substring(nroTarjeta1.length()-5, nroTarjeta1.length()-1).trim()); 
							} else
								if (i==4) {
									CalculadorMoney calc = new CalculadorMoney(new Money(campos[i].replace(".","").replace(",","").trim()));
									calc.dividirPor(new Money(100));
									importe = calc.getResult();				
								} else 
									if (i==5) {
										tipoTarjeta = TarjetaConciTar.TIPO_TARJ_CRE;
										tarjeta = ConciliarAutomaticaTarj.CA_AMERICAN;				
									} else if (i==6) {
										cuota = new Integer(campos[i].trim());
									}
			}
		}
		
		tipoOperacion = "COMPRA";
				
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
		
		procesoAlgunReg = true;
		
		
	}
	
	private void procesarDetalle2(String str) throws BaseException {
		
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
		Integer nroCupon = 0;
		String tarjeta = "";
		
		if (str.trim().length()==0) return;
		
		if (!str.contains("****")) return;
		
		// Obtener la Fecha de Presentacion 
		String fecPresen = str.substring(0,10);
		Integer diaPresen = new Integer(fecPresen.substring(0,2));
		Integer mesPresen = new Integer(fecPresen.substring(3,5));
		Integer anioPresen = new Integer(fecPresen.substring(6,10));
		fecPresentacion = Fecha.getFecha(diaPresen, mesPresen, anioPresen);
		fecOrigen = fecPresentacion;
		
		//Obtener el Nro de cupon y comprobante
	    StringBuffer nroCompro = new StringBuffer("");
	    int i = 0;
	    for (i=10;i<str.length();++i) {
	    	if (str.charAt(i)=='*')
	    		break;
	    	nroCompro.append(str.charAt(i));
	    }
	    nroCupon = new Integer(nroCompro.toString().trim());
		comprobante = new Integer(nroCompro.toString().trim());	   
		
		// Obtener el nro. de Tarjeta
	    String tarjetaSinCodif = str.substring(i,i+21).trim();
	    nroTarjeta = new Integer(tarjetaSinCodif.substring(tarjetaSinCodif.length()-4,tarjetaSinCodif.length()));
	    
	    // Obtener el Monto
	    String cadenaRestante = str.substring(i+21,str.length()).trim(); 
	    int lugComa = cadenaRestante.indexOf(",");
	    String nroSinPtoDeci = cadenaRestante.substring(0,lugComa+4).trim().replace(",", "").replace(".", "");
		CalculadorMoney calcMonto = new CalculadorMoney(new Money(nroSinPtoDeci));
		calcMonto.dividirPor(new Money(100));
		importe = calcMonto.getResult();	    
		tipoTarjeta = TarjetaConciTar.TIPO_TARJ_CRE;
		tarjeta = ConciliarAutomaticaTarj.CA_AMERICAN;
		cuota = 0;
		
		tipoOperacion = "COMPRA";
				
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
		detTarConciEnt.save();
		incrementarCantRegImp();
		
		procesoAlgunReg = true;
		
		
	}	
	
	
}
