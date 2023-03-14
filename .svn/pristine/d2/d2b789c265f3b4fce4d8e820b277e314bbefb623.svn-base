package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class PINIEventoStatus extends PINIEventoBase {

	public static int CM_NORMAL = 0;
	public static int CM_LIBERADO = 1;
	public static int CM_PANICO = 2;
	public static int CM_BLOQUEADO = 3;
	
	public static int NO_PEDIR_CONFIG = 0;
	public static int PEDIR_CONFIG = 1;
	
	private static final String ID = "ID";
	private static final String ENABLE = "ENABLE";
	private static final String GC1 = "GC1";
	private static final String GC2 = "GC2";
	private static final String DC1 = "DC1";
	private static final String DC2 = "DC2";
	private static final String BUZON = "BUZON";
	private static final String MODE = "MODE";
	
	public static String CM = "CM";
	public static String PC = "PC";
	public static String STMOD = "STMOD";

	private int maxEventoStatus = 2;
	private int contEvStatus = 121;
	
	
	private int valor_ID = -1;
	private int valor_ENABLE = -1;
	private int valor_GC1 = -1;
	private int valor_GC2 = -1;
	private int valor_DC1 = -1;
	private int valor_DC2 = -1;
	private int valor_BUZON = -1;
	private int valor_MODE = -1;
	
	public void inicializar() {

		valor_ID = -1;
		valor_ENABLE = -1;
		valor_GC1 = -1;
		valor_GC2 = -1;
		valor_DC1 = -1;
		valor_DC2 = -1;
		valor_BUZON = -1;
		valor_MODE = -1;

	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
		else if (clave.equals(ENABLE))
			valor_ENABLE = new Integer(valor);
		else if (clave.equals(GC1))
			valor_GC1 = new Integer(valor);
		else if (clave.equals(GC2))
			valor_GC2 = new Integer(valor);		
		else if (clave.equals(DC1))
			valor_DC1 = new Integer(valor);		
		else if (clave.equals(DC2))
			valor_DC2 = new Integer(valor);		
		else if (clave.equals(BUZON))
			valor_BUZON = new Integer(valor);		
		else if (clave.equals(MODE))
			valor_MODE = new Integer(valor);		
	}

	public void internalRun(PINIAccess response) throws BaseException {
		
		
		Puerta puerta = Puerta.getPuertaByIdentif(valor_ID, this.getSession());
		
		if (contEvStatus>=maxEventoStatus) {
			response.setSeccion(PINIEventoStatus.STMOD);
			response.addClave(PINIEventoStatus.CM, puerta.getMode().toString());
			if (puerta.isPideConfiguracion().booleanValue())
				response.addClave(PINIEventoStatus.PC, "1");
			else
				response.addClave(PINIEventoStatus.PC, "0");
			contEvStatus = 0;
		} else {
			response.setSeccion(PINIAccess.ACK);
			++contEvStatus;
		}
		

		java.util.Date fecha = UtilCIP.getFechaHoraActual(this.getSession());
		String hora = Fecha.getHoraActualConSeg();
		
		// Actualizar Status
		/*puerta = Puerta.getPuertaByIdentif(valor_ID, this.getSession());
		puerta.setFecUltStatus(UtilCIP.getTruncDate(fecha));
		puerta.setHoraUltStatus(hora);
		puerta.save();
		puerta = null;*/
		
		PrepararStatus prepararStatus = PrepararStatus.getPuertaByIdentif(new Integer(valor_ID).toString(), this.getSession());
		prepararStatus.setFecha_ultstatus(UtilCIP.getTruncDate(fecha));
		prepararStatus.setHora_ultStatus(hora);
		prepararStatus.save();
		prepararStatus = null;
		
		// Si se devuelve esta respuesta no pasa al modo online
		// y despues para que retome tuve que reiniciar la placa
		//response.setSeccion(PINIAccess.NACK);
		
		// Pasa al modo LIBERA
		//*response.clear();
		// * 
		//<[STMOD]CM=1;PC=0;CRC=91;>
		
		 
		
		
		
		
	}

}
