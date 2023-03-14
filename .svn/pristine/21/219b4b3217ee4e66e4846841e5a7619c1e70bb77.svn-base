package com.srn.erp.impuestos.bm;

import java.util.List;

import com.srn.erp.impuestos.da.DBListadoIVAConcImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ListadoIVAConcImpu extends ObjetoLogico {

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ListadoIVAConcImpu() {
	}

	public static String NICKNAME = "im.ListadoIVAConcImpu";

	private ListadoIVACab listado_iva;

	private ConceptoImpuesto concepto_impuesto;

	private Money importe;

	public ListadoIVACab getListado_iva() throws BaseException {
		supportRefresh();
		return listado_iva;
	}

	public void setListado_iva(ListadoIVACab aListado_iva) {
		this.listado_iva = aListado_iva;
	}

	public ConceptoImpuesto getConcepto_impuesto() throws BaseException {
		supportRefresh();
		return concepto_impuesto;
	}

	public void setConcepto_impuesto(ConceptoImpuesto aConcepto_impuesto) {
		this.concepto_impuesto = aConcepto_impuesto;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ListadoIVAConcImpu findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ListadoIVAConcImpu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ListadoIVAConcImpu findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ListadoIVAConcImpu) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static List getConcImpuestos(ListadoIVACab listadoIVACab,
			ISesion aSesion) throws BaseException {
		return DBListadoIVAConcImpu.getConcImpuestos(listadoIVACab, aSesion);
	}

}
