package com.srn.erp.conciTarjeta.bm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ImpArchMASTCobTar extends ImpArchCobTar {

	public void setSession(ISesion session) {
		this.session = session;
	}

	public void importar() throws BaseException {
		
		try {
		
			String genArchTxt = "";
			BufferedOutputStream dest = null;
			final int BUFFER = 2048;
			
			FileInputStream fis = new FileInputStream(this.archivo);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				int count;
				byte data[] = new byte[BUFFER];

				genArchTxt = 
					CabTarConciEnt.getCarpetaArchImpCobranzas(
							this.session)+
							getTarConciEnt().getOIDInteger()+".txt";
				FileOutputStream fos = new FileOutputStream(genArchTxt);
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
			
			// Borra archivo Zipiado
			 File deleteFile = new File(archivo);
			 boolean success = deleteFile.delete();
			
			BufferedReader in = new BufferedReader(new FileReader(genArchTxt));
			int nroLinea = 1;
			// Abrir el archivo de texto
			String str;
			boolean procDet = false;
			while ((str = in.readLine()) != null) {
				if (str.startsWith("Comercio;")) {
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
			throw new ExceptionValidation(null, "Problemas al procesar el archivo:" + this.archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, "Problemas al procesar el archivo:" + this.archivo);
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
		double dtoArancel = 0;
		String tipoTarjeta = "";
		String codComercio = "";
		Integer nroCupon = 0;
		String tarjeta = "";
		Integer nroLiquidacion = 0;
		String tipoOperacion = "";

		String[] campos = str.split("\\;");
		for (int i = 0; i <= campos.length - 1; ++i) {

			if (i == 0) {
				codComercio = campos[i];
			} else if (i == 1) {
				String fecPresentacion1 = campos[i];
				Integer diaPago = new Integer(fecPresentacion1.substring(0, 2));
				Integer mesPago = new Integer(fecPresentacion1.substring(3, 5).toUpperCase());
				Integer anioPago = new Integer(fecPresentacion1.substring(6,8));
				fecPresentacion = Fecha.getFecha(diaPago, mesPago, anioPago+2000);
				fecOrigen = fecPresentacion; 
			} else if (i == 2) {
				if (campos[i].equals("Venta ctdo")) {
					tipoOperacion = "COMPRA";
					descripcion = campos[i]; 
				}
				else {
					tipoOperacion = "";
					descripcion = campos[i];
				}
			} else if (i == 3) {
				nroTarjeta = new Integer(campos[i]);
			} else if (i == 4) {
				nroCupon = new Integer(campos[i]);
			} else if (i == 5) {
				tipoTarjeta = "";
				tarjeta = "";				
				if (campos[i].trim().equals("MASTERCARD")) {
					tipoTarjeta = TarjetaConciTar.TIPO_TARJ_CRE;
					tarjeta = ConciliarAutomaticaTarj.CA_MASTERCARD;					
				} else if (campos[i].trim().equals("MAESTRO")) {
							tipoTarjeta = TarjetaConciTar.TIPO_TARJ_DEB;
							tarjeta = ConciliarAutomaticaTarj.CA_MAESTRO;					
						} else if (campos[i].trim().equals("ARGENCARD")) {
							tipoTarjeta = TarjetaConciTar.TIPO_TARJ_CRE;
							tarjeta = ConciliarAutomaticaTarj.CA_ARGENCARD;							
						}
			} else if (i == 6) {
				moneda = campos[i];
			} else if (i == 7) {
				String decimales = campos[i].substring(campos[i].lastIndexOf(".")+1,campos[i].length());
				String analizarImporte = campos[i];
				if (decimales.length()==1)
					analizarImporte = analizarImporte + "0";
				CalculadorMoney calc = new CalculadorMoney(new Money(analizarImporte.replace(".", "")));
				calc.dividirPor(new Money(100));
				importe = calc.getResult();				
			} else if (i == 8) {
				String decimales = campos[i].substring(campos[i].lastIndexOf(".")+1,campos[i].length());
				String analizarImporte = campos[i];
				if (decimales.length()==1)
					analizarImporte = analizarImporte + "0";
				CalculadorMoney calc = new CalculadorMoney(new Money(analizarImporte.replace(".", "")));
				calc.dividirPor(new Money(100));
				dtoArancel = calc.getResult();				
			} else if (i == 9) {
				String fecPago1 = campos[i];
				Integer diaPago = new Integer(fecPago1.substring(0, 2));
				Integer mesPago = new Integer(fecPago1.substring(3, 5).toUpperCase());
				Integer anioPago = new Integer(fecPago1.substring(6,8));
				fecPago = Fecha.getFecha(diaPago, mesPago, anioPago+2000);
			} else if (i == 10) {
				nroLiquidacion = new Integer(campos[i].replace(".", ""));
			}
		}


		// Grabar el Registros
		DetTarConciEnt detTarConciEnt = (DetTarConciEnt) DetTarConciEnt.getNew(DetTarConciEnt.NICKNAME, this.session);
		detTarConciEnt.setTar_info_cab(cabTarConciEnt);
		detTarConciEnt.setEmpresa(cabTarConciEnt.getEmpresa());
		detTarConciEnt.setTipo_operacion(tipoOperacion);
		detTarConciEnt.setFec_present(fecPresentacion);
		detTarConciEnt.setLote(nroLote);
		detTarConciEnt.setFec_pago(fecPago);
		detTarConciEnt.setDescripcion(descripcion);
		detTarConciEnt.setFec_origen(fecOrigen);
		detTarConciEnt.setNro_comprobante(nroCupon);
		detTarConciEnt.setNro_tarjeta(nroTarjeta);
		detTarConciEnt.setPlan(null);
		detTarConciEnt.setCuota(null);
		detTarConciEnt.setMoneda(moneda);
		detTarConciEnt.setImporte(new Money(importe));
		detTarConciEnt.setComercio(codComercio);
		detTarConciEnt.setNro_cupon(nroCupon);
		detTarConciEnt.setActivo(true);
		detTarConciEnt.setTipoTarjeta(tipoTarjeta);
		detTarConciEnt.setConciliado(false);
		detTarConciEnt.setTarjeta(tarjeta);
		if (detTarConciEnt.getTar_info_cab()!=null)
			detTarConciEnt.setNomArchivo(detTarConciEnt.getTar_info_cab().getNom_archivo());		
		detTarConciEnt.save();
		incrementarCantRegImp();

	}


}
