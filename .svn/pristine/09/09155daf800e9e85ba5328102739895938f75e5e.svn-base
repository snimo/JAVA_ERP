package com.srn.erp.cip.bm;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import framework.request.bl.Utils.BaseException;

public class PINIEventoTransaction extends PINIEventoBase {

	private static final String ID = "ID";
	private static final String POINT = "POINT";
	private static final String DIR = "DIR";
	private static final String MEDIATYPE = "MEDIATYPE";
	private static final String MEDIA = "MEDIA";
	private static final String IDTR = "IDTR";
	private static final String DATETIME = "DATETIME";

	private int valor_ID = -1;
	private int valor_POINT = -1;
	private int valor_DIR = -1;
	private int valor_MEDIATYPE = -1;
	private String valor_MEDIA = "-1";
	private long valor_IDTR = -1;
	private String valor_DATETIME = "";

	public void inicializar() {

		valor_ID = -1;
		valor_POINT = -1;
		valor_DIR = -1;
		valor_MEDIATYPE = -1;
		valor_MEDIA = "-1";
		valor_IDTR = -1;
		valor_DATETIME = "";

	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
		else if (clave.equals(POINT))
			valor_POINT = new Integer(valor);
		else if (clave.equals(DIR))
			valor_DIR = new Integer(valor);
		else if (clave.equals(MEDIATYPE))
			valor_MEDIATYPE = new Integer(valor);
		else if (clave.equals(MEDIA))
			valor_MEDIA = valor;
		else if (clave.equals(IDTR))
			valor_IDTR = new Long(valor);
		else if (clave.equals(DATETIME))
			valor_DATETIME = valor;
	}

	public void internalRun(PINIAccess response) throws BaseException {

		// Si valor_MEDIO es igual a cero significa que la transaccion es del giro del aspa
		// correspondiente a la entrada del Buzon, por eso se descarta dado que la transaccion
		// se registro al momento de la validacion
		
		if (valor_MEDIA.equals("0")) {
			response.setSeccion(PINIAccess.ACK);
			return;
		}
			
		TransaccionPermisoCIP transacCIP =
			new TransaccionPermisoCIP();
		transacCIP.setSesion(this.getSession());
		transacCIP.setIdentifEquipo(valor_ID);
		transacCIP.setIdentifPtoAcceso(valor_POINT);
		transacCIP.setIdentifDir(valor_DIR);
		transacCIP.setIdentifLegajo(valor_MEDIA);
		transacCIP.validar();
		
		if (transacCIP.isTransaccionOK()) {
			if (transacCIP.legajo!=null)
				grabarMovimientoLegajo(transacCIP);
			else if (transacCIP.visita!=null)
				grabarMovimientoVisita(transacCIP);
			response.setSeccion(PINIAccess.ACK);
			
		} else {
			response.setSeccion(PINIAccess.ACK);
		}
		
		

	}
	
	private void grabarMovimientoVisita(TransaccionPermisoCIP transacCIP) throws BaseException {

		// Determinar si corresponde hacer el movimiento de un Legajo o de la Visita
		MovVisitaCIP movVisitaCIP = (MovVisitaCIP) MovVisitaCIP.getNew(MovVisitaCIP.NICKNAME, this.getSession());
		movVisitaCIP.setVisita(transacCIP.visita);
		movVisitaCIP.setPuerta(transacCIP.getPuerta());
		java.util.Date fecha = null;
		SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			fecha = formateador.parse(valor_DATETIME);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		movVisitaCIP.setFecha(fecha);
		movVisitaCIP.setFec_hor(fecha);
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
		movVisitaCIP.setHora(sdfHora.format(fecha));
		movVisitaCIP.setHora_en_min(UtilCIP.getHoraEnMin(sdfHora.format(fecha)));
		movVisitaCIP.setTarjeta(transacCIP.tarjetaCIP);
		
		String sentido = "";
		boolean regMovEnSaVis = false;
		
		ZonaCIP zonaActual = null;
		
		if (transacCIP.esEntrada()) {
			
			movVisitaCIP.setZona_origen(transacCIP.getPuerta().getEntradaSaleDe());
			movVisitaCIP.setZona_destino(transacCIP.getPuerta().getEntradaEntraA());
			
			zonaActual = transacCIP.getPuerta().getEntradaEntraA();			
			movVisitaCIP.setSentido(MovimientoCIP.MOV_ENT_CIP);
			
			if (transacCIP.getPuerta().isIngresoAlPredio()) {
				movVisitaCIP.setAutorizo(transacCIP.visita.getAutoriza());
				movVisitaCIP.setVisita_a(transacCIP.visita.getVisitaA());
				regMovEnSaVis = true;
				sentido = MovimientoCIP.MOV_ENT_CIP;
			}
			
		}
		else if (transacCIP.esSalida()) {
			
				movVisitaCIP.setZona_origen(transacCIP.getPuerta().getSalidaSaleDe());
				movVisitaCIP.setZona_destino(transacCIP.getPuerta().getSalidaEntraA());
				
				zonaActual = transacCIP.getPuerta().getSalidaEntraA();
				movVisitaCIP.setSentido(MovimientoCIP.MOV_SAL_CIP);
				
				if (transacCIP.getPuerta().isEgresoDelPredio()) {
					regMovEnSaVis= true;
					sentido = MovimientoCIP.MOV_SAL_CIP;
				}
		}
		
		movVisitaCIP.setActivo(true);
		movVisitaCIP.save();
		
		boolean graboZonaActual = false;
		// Si es un ingreso y egreso del predio grabar ultimo pase en la Visita
		// Registrar solo si el Movimiento es mayor al registrado en la ultima hora / fecha del legajo
		
		if (regMovEnSaVis==true) {
			
			if ((transacCIP.visita.getFecHorUltMov()==null) ||
			   (transacCIP.visita.getFecHorUltMov().before(fecha)))
			   {
				try {
					
			
					if (((transacCIP.esEntrada() && (transacCIP.getPuerta().isRegMovUltEnt()))) 
						||
						((transacCIP.esSalida() && (transacCIP.getPuerta().isRegMovUltSal())))) {
						
						transacCIP.visita.setFecHorUltMov(movVisitaCIP.getFecha());
						transacCIP.visita.setSentido(sentido);
						transacCIP.visita.setIgnorarProxAntiPassBack(false);
						
					}
					
					graboZonaActual = true;
					transacCIP.visita.setZonaActual(zonaActual);
					transacCIP.visita.save();
				}
				catch(Exception e) {}
			}
							
		}
		
		if (graboZonaActual == false) {
			transacCIP.visita.setZonaActual(zonaActual);
			transacCIP.visita.save();
		}
		
		
		
	}
	
	
	private void grabarMovimientoLegajo(TransaccionPermisoCIP transacCIP) throws BaseException {

		// Determinar si corresponde hacer el movimiento de un Legajo o de la Visita
		
		MovimientoCIP movCIP = (MovimientoCIP) MovimientoCIP.getNew(MovimientoCIP.NICKNAME, this.getSession());
		java.util.Date fecha = null;
		movCIP.setLegajo(transacCIP.getLegajo());
		movCIP.setPuerta(transacCIP.getPuerta());
		
		SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			fecha = formateador.parse(valor_DATETIME);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movCIP.setFecha(fecha);
		movCIP.setFecHora(fecha);
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
		movCIP.setHora(sdfHora.format(fecha));
		movCIP.setHora_en_min(UtilCIP.getHoraEnMin(sdfHora.format(fecha)));
		
		String sentido = "";
		boolean regMovEnLeg = false;
		
		ZonaCIP zonaActual = null;
		
		if (transacCIP.esEntrada()) {
			
			movCIP.setZonaOrigen(transacCIP.getPuerta().getEntradaSaleDe());
			movCIP.setZonaDestino(transacCIP.getPuerta().getEntradaEntraA());
			
			zonaActual = transacCIP.getPuerta().getEntradaEntraA();
			
			movCIP.setSentido(MovimientoCIP.MOV_ENT_CIP);
			if (transacCIP.getPuerta().isIngresoAlPredio()) {
				regMovEnLeg = true;
				sentido = MovimientoCIP.MOV_ENT_CIP;
			}
		}
		else if (transacCIP.esSalida()) {
			
				movCIP.setZonaOrigen(transacCIP.getPuerta().getSalidaSaleDe());
				movCIP.setZonaDestino(transacCIP.getPuerta().getSalidaEntraA());
				
				zonaActual = transacCIP.getPuerta().getSalidaEntraA();
			
				movCIP.setSentido(MovimientoCIP.MOV_SAL_CIP);
				if (transacCIP.getPuerta().isEgresoDelPredio()) {
					regMovEnLeg = true;
					sentido = MovimientoCIP.MOV_SAL_CIP;
				}
		}
		
		movCIP.setActivo(true);
		movCIP.save();
		
		
		// Si es un ingreso y egreso del predio grabar ultimo pase en el legajo
		// Registrar solo si el Movimiento es mayor al registrado en la ultima hora / fecha del legajo
		
		boolean graboZonaActual = false;
		
		if (regMovEnLeg==true) {
			if ((transacCIP.getLegajo().getFecUltPaso()==null) ||
				(transacCIP.getLegajo().getHoraUltPaso()==null) ||	
			   (UtilCIP.getTruncDate(transacCIP.getLegajo().getFecUltPaso()).before(UtilCIP.getTruncDate(fecha))) ||
			   (((UtilCIP.getTruncDate(transacCIP.getLegajo().getFecUltPaso()).equals(UtilCIP.getTruncDate(fecha))) && 
					   (movCIP.getHora_en_min().intValue()>=UtilCIP.getHoraEnMin(transacCIP.getLegajo().getHoraUltPaso())))))
			   {
				try {
					
			
					if (((transacCIP.esEntrada() && (transacCIP.getPuerta().isRegMovUltEnt()))) 
						||
						((transacCIP.esSalida() && (transacCIP.getPuerta().isRegMovUltSal())))) {
						
						transacCIP.getLegajo().setFecUltPaso(movCIP.getFecha());
						transacCIP.getLegajo().setHoraUltPaso(sdfHora.format(fecha));
						transacCIP.getLegajo().setSentidoPaso(sentido);
						transacCIP.getLegajo().setIgnorarProxAntiPassBack(false);
						
					}
					
					graboZonaActual = true;
					transacCIP.getLegajo().setZonaActual(zonaActual);
					transacCIP.getLegajo().save();
				}
				catch(Exception e) {}
			}
							
		}
		
		if (graboZonaActual == false) {
			transacCIP.getLegajo().setZonaActual(zonaActual);
			transacCIP.getLegajo().save();
		}
		
	}

}
