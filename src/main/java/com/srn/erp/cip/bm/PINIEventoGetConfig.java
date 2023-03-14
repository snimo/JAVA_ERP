package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;

public class PINIEventoGetConfig extends PINIEventoBase {

	private static final String ID = "ID";
	
	private static final String CONFIG = "CONFIG";
	
	private static final String STATUSTIME = "STATUSTIME";
	private static final String CONFIGTIME = "CONFIGTIME";
	private static final String SYNCROTIME = "SYNCROTIME";
	private static final String POINT1_E = "POINT1_E";
	private static final String POINT2_E = "POINT2_E";
	
	private int valor_ID 	= -1;
	
	public void inicializar() {

		valor_ID = -1;
		
	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
	}

	public void internalRun(PINIAccess response) throws BaseException {
		
		// Pasa al modo ONINE
		
		Puerta puerta = Puerta.getPuertaByIdentif(valor_ID, this.getSession());
		
		Integer intStatusTime = 30;
		if (puerta.getIntervaloStatusTime()!=null)
			intStatusTime = puerta.getIntervaloStatusTime();
		
		Integer intConfigTime = 3600;
		if (puerta.getIntervaloConfigTime()!=null)
			intConfigTime = puerta.getIntervaloConfigTime(); 
		
		Integer intSyncroTime = 3600*12;
		if (puerta.getIntervaloSyncroTime()!=null)
			intSyncroTime = puerta.getIntervaloSyncroTime();		
		
		response.setSeccion(PINIEventoGetConfig.CONFIG);
		response.addClave(PINIEventoGetConfig.STATUSTIME, intStatusTime.toString());
		response.addClave(PINIEventoGetConfig.CONFIGTIME, intConfigTime.toString());
		response.addClave(PINIEventoGetConfig.SYNCROTIME, intSyncroTime.toString());
		
		if ((puerta.getHabilitarPuntoAcceso1()!=null) && (puerta.getHabilitarPuntoAcceso1().intValue()==1))
			response.addClave(PINIEventoGetConfig.POINT1_E, "1");
		else
			response.addClave(PINIEventoGetConfig.POINT1_E, "0");
		
		if ((puerta.getHabilitarPuntoAcceso2()!=null) && (puerta.getHabilitarPuntoAcceso2().intValue()==1))
			response.addClave(PINIEventoGetConfig.POINT2_E, "1");
		else
			response.addClave(PINIEventoGetConfig.POINT2_E, "0");		
		
		puerta = null;
		
	}

}
