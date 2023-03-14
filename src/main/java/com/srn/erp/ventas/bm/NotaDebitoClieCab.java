package com.srn.erp.ventas.bm;

import com.srn.erp.contabilidad.bm.RenglonesAsiento;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class NotaDebitoClieCab extends FacturaCab {

	public static String NICKNAME = "ve.NotaDebitoClieCab";

	public static FacturaCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (NotaDebitoClieCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FacturaCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (NotaDebitoClieCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public FacturaDet addDetalle() throws BaseException {
		NotaDebitoClieDet notaDebitoClieDet = (NotaDebitoClieDet) NotaDebitoClieDet.getNew(NotaDebitoClieDet.NICKNAME, getSesion());
		addDetalleFactura(notaDebitoClieDet);
		return notaDebitoClieDet;
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
		return 1;		
	}	


}
