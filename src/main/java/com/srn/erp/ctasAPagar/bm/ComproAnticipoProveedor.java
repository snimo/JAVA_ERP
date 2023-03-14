package com.srn.erp.ctasAPagar.bm;

import com.srn.erp.compras.bm.OrdenDeCompraCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;


public class ComproAnticipoProveedor extends ComproProveedorBase  {

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		grabarAutorizacionAnticipo();
	}

	public ComproAnticipoProveedor() {
	}

	public static String			NICKNAME										= "cap.ComproAnticipoProveedor";
	
	private void grabarAutorizacionAnticipo() throws BaseException {
		
		AutorizacionFactProv autorizFactProv = (AutorizacionFactProv) AutorizacionFactProv.getNew(
				AutorizacionFactProv.NICKNAME, getSesion());
		autorizFactProv.setTranprovVto(null);
		autorizFactProv.setComproCab(this);
		if (!isAutorizAntProvAutomaticamente(this.getSesion())) {
			autorizFactProv.setPorcautoriz(new Money(0));
			autorizFactProv.setMontoautoriz(new Money(0));
			autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
		}
		else {
			autorizFactProv.setPorcautoriz(new Money(100));
			autorizFactProv.setMontoautoriz(this.getTotMonedaOri());
			autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.AUTORIZADA));
		}
		autorizFactProv.setUsuario(getSesion().getLogin().getUsuario());
		autorizFactProv.setFecautoriz(Fecha.getFechaActual());
		autorizFactProv.setActivo(new Boolean(true));
		autorizFactProv.save();
	}
	
	public static boolean isAutorizAntProvAutomaticamente(ISesion aSesion) throws BaseException {
		ValorParametro valorParamAutorizAntProv = ValorParametro.findByCodigoParametro(
				"AUTORIZ_AUT_ANT_PROV", aSesion);
		return valorParamAutorizAntProv.getBoolean();
	}	
	
	public static ComproProveedorBase findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproProveedorBase) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproProveedorBase findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproProveedorBase) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	
	
	

	
}
