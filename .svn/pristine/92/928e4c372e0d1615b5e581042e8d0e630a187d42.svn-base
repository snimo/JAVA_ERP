package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;


public class PINIEventoValidate extends PINIEventoBase {

	private static String VALIDATION = "VALIDATION";
	private static String VALID = "VALID";
	private static String REASON = "REASON";

	private static String ID = "ID";
	private static String POINT = "POINT";
	private static String DIR = "DIR";
	private static String MEDIATYPE = "MEDIATYPE";
	private static String MEDIA = "MEDIA";

	private int valor_ID = -1;
	private int valor_POINT = -1;
	private int valor_DIR = -1;
	private int valor_MEDIATYPE = -1;
	private String valor_MEDIA = "-1";

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
	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		valor_ID = -1;
		valor_POINT = -1;
		valor_DIR = -1;
		valor_MEDIATYPE = -1;
		valor_MEDIA = "-1";
	}

	public void internalRun(PINIAccess response) throws BaseException {

		TienePermisoCIP tienePermisoCIP =
			new TienePermisoCIP(this.getSession());
		tienePermisoCIP.setIdentifEquipo(valor_ID);
		tienePermisoCIP.setIdentifPtoAcceso(valor_POINT);
		tienePermisoCIP.setIdentifDir(valor_DIR);
		tienePermisoCIP.setIdentifLegajo(valor_MEDIA);
		tienePermisoCIP.setFecha(UtilCIP.getFechaHoraActual(this.getSession()));
		tienePermisoCIP.validar();
		
		
		if (tienePermisoCIP.isPuedePasar()) {
			response.setSeccion(PINIEventoValidate.VALIDATION);
			response.addClave(VALID, "1");
			response.addClave(REASON, tienePermisoCIP.getMotivoPermiso());		
		} else {
			response.setSeccion(PINIEventoValidate.VALIDATION);
			response.addClave(VALID, "0");
			response.addClave(REASON, tienePermisoCIP.getMotivoPermiso());		
			
			// Grabar rechazado del Pase
			try {
				Puerta puerta = Puerta.getPuertaByIdentif(valor_ID, this.getSession());
				PaseRechazado paseRechazado = (PaseRechazado)PaseRechazado.getNew(PaseRechazado.NICKNAME, this.getSession());
				paseRechazado.setLegajo(tienePermisoCIP.getLegajo());
				paseRechazado.setVisita(tienePermisoCIP.getVisita());
				paseRechazado.setFecha(tienePermisoCIP.getFecha());
				paseRechazado.setHora(tienePermisoCIP.getHora());
				paseRechazado.setPuerta(puerta);
				paseRechazado.setMedia(new Integer(tienePermisoCIP.getIdentifLegajo()));
				paseRechazado.setMotivo(tienePermisoCIP.getMotivoPermiso());
				if (tienePermisoCIP.esEntrada())
					paseRechazado.setEntradaSalida(PaseRechazado.E);
				else if (tienePermisoCIP.esSalida())
					paseRechazado.setEntradaSalida(PaseRechazado.S);
				paseRechazado.setActivo(true);
				paseRechazado.save();
				paseRechazado = null;
			}
			catch(Exception e) {
				
			}
			
		}
		
		tienePermisoCIP = null;
				
		
	}

}
