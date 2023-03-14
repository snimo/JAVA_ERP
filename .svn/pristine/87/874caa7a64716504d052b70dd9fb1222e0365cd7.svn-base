package com.srn.erp.cashflow.bm;

import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class CashFlow {

	public static TipoCambio getTipoCambio(ISesion aSesion) throws BaseException {
		Integer oidTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_CASH_FLOW", aSesion).getOidObjNeg();
		TipoCambio tipoCambio = TipoCambio.findByOid(oidTipoCambio, aSesion);
		return tipoCambio;
	}

}
