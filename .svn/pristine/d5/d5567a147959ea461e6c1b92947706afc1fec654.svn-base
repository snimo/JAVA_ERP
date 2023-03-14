package com.srn.erp.cip.bm;

public class PINIEventoSincronizacion extends PINIEventoBase {

	private static final String ID = "ID";
	private static final String DATETIME = "DATETIME";
	private static final String DAYOFWEEK = "DAYOFWEEK";
	private static final String SETTIME = "SETTIME";
	
	private int valor_ID = -1;
	
	public void inicializar() {

		valor_ID = -1;

	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
	}

	public void internalRun(PINIAccess response) {
		
		// Pasa al modo ONINE
		response.setSeccion(PINIEventoSincronizacion.SETTIME);
		response.addClave(PINIEventoSincronizacion.DATETIME, PINIUtil.getFechaFomatoPINI(this.getSession()).toString());
	}

}
