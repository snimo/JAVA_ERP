package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class DBFRemote {

	public static String getDBFLocalArchConcClubes(ISesion aSesion) throws BaseException {
		
		ValorParametro paramNomArch = ValorParametro.findByCodigoParametro(
				"ARCH_CONC_SIST_CLUBES", aSesion);		
		
		String archFuente = "F:\\CLUB\\CONCEPTO.DBF";
		
		try {
			Process p = Runtime.getRuntime().exec("C:\\EJECUTAR.BAT");
			p.waitFor(); // si quieres esperar a que la ejecuciOn finalize
			}
			catch (Exception err) {
			// El tratamiento de error que te salga de los huevos
			}
		return paramNomArch.getValorCadena(); 
	}
	
}
