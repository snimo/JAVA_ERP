package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class DecodificarNroSocioTarjeta {
	
	public static String getDecodificarNroSocioTarjeta(ISesion sesion,String nroTarjeta) throws BaseException {
		
		ValorParametro valorPosIni = 
			ValorParametro.findByCodigoParametro("POS_INI_NRO_SOCIO_TURNOS",sesion);
		
		ValorParametro valorPosFin = 
			ValorParametro.findByCodigoParametro("POS_FIN_NRO_SOCIO_TURNOS",sesion);
		
		String nroSocioCadena = "";
		try {
			
			int nroHasta = nroTarjeta.length();
			if (valorPosFin.getValorEntero()<nroHasta)
				nroHasta=valorPosFin.getValorEntero();
			
			nroSocioCadena = nroTarjeta.substring(valorPosIni.getValorEntero(), nroHasta).trim();
			Integer nroEnteroSocio = new Integer(nroSocioCadena);
			return nroEnteroSocio.toString();
		} catch (Exception e) {
			return nroSocioCadena;
		}
	}
	

}
