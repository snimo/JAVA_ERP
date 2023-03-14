package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class ActLAntiPassBack {

	private static Boolean activado =  null;
	
	public static boolean isActivado(ISesion aSesion) throws BaseException {
		if (activado!=null)
			return activado;
		else {
			activado =
				ValorParametro.findByCodigoParametro(
					"ANTI_PASS_BACK", aSesion).getBoolean();
			return activado;
		}
	}
	
	public static void setActivado(Boolean aActivado) {
		activado = aActivado;
	}
	
}
