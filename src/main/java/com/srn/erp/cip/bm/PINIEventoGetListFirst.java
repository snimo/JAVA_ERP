package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;

public class PINIEventoGetListFirst extends PINIEventoBase {

	private static final String ID = "ID";
	private static final String REG = "REG";
	private static final String LIST = "LIST";
	
	private static final String TID = "TID";
	private static final String RCOUNT = "RCOUNT";
	private static final String R1 = "R1";
	private static final String R2 = "R2";
	private static final String R3 = "R3";
	private static final String R4 = "R4";
	private static final String R5 = "R5";
	
	private int valor_ID 	= -1;
	private int valor_REG   = -1;
	
	public void inicializar() {
		valor_ID  = -1;
		valor_REG = -1;
	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
		else
		if (clave.equals(REG))
			valor_REG = new Integer(valor);		
	}

	public void internalRun(PINIAccess response) throws BaseException {
		
		
		Puerta puerta = Puerta.getPuertaByIdentif(valor_ID, this.getSession());
		if (puerta!=null) {
			java.util.Date fecha = UtilCIP.getFechaHoraActual(this.getSession());
			String hora = UtilCIP.getHHMM(fecha);
			puerta.setFecUltCargaLB(UtilCIP.getTruncDate(fecha));
			puerta.setHoraUltCargaLP(hora);
			puerta.save();
		}
		puerta = null;
		
		// Pasa al modo ONINE
		response.setSeccion(PINIEventoGetListFirst.LIST);
		response.addClave(PINIEventoGetListFirst.TID, "1");
		response.addClave(PINIEventoGetListFirst.RCOUNT, "5");
		response.addClave(PINIEventoGetListFirst.R1, "1");
		response.addClave(PINIEventoGetListFirst.R2, "1");
		response.addClave(PINIEventoGetListFirst.R3, "1");
		response.addClave(PINIEventoGetListFirst.R4, "1");
		response.addClave(PINIEventoGetListFirst.R5, "1");
	}

}
