package com.srn.erp.ventas.bm;

import com.srn.erp.contabilidad.bm.RenglonesAsiento;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class NotaCreditoClieCab extends FacturaCab {

	public static String NICKNAME = "ve.NotaCreditoClieCab";

	public static FacturaCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (NotaCreditoClieCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FacturaCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (NotaCreditoClieCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public FacturaDet addDetalle() throws BaseException {
		NotaCreditoClieDet notaCreditoClieDet = (NotaCreditoClieDet) NotaCreditoClieDet.getNew(NotaCreditoClieDet.NICKNAME, getSesion());
		addDetalleFactura(notaCreditoClieDet);
		return notaCreditoClieDet;
	}
	
	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
	  RenglonesAsiento renglones = new RenglonesAsiento();
	  getRenglonDeudoresPorVentas(renglones);
	  getRenglonesVentas(renglones);
	  getRenglonIVA(renglones);
	  getRenglonPercIVA(renglones);
	  getRenglonImpInternos(renglones);
	  getRenglonPercIB(renglones);
	  getRenglonesBonificacionRecargo(renglones);
	  return renglones;
	}
	
	public int getSignoLibroIVA() throws BaseException {
		return -1;		
	}	

}
