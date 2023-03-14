package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBAplicNCFact;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicNCFact extends ObjetoLogico {

	public AplicNCFact() {
	}

	public static String NICKNAME = "ve.AplicNCFact";

	private FacturaDet detalle_nc;
	private Money cant_nc;
	private FacturaCab factura;
	private FacturaDet factura_det;
	private Boolean activo;

	public FacturaDet getDetalle_nc() throws BaseException {
		supportRefresh();
		return detalle_nc;
	}

	public void setDetalle_nc(FacturaDet aDetalle_nc) {
		this.detalle_nc = aDetalle_nc;
	}

	public Money getCant_nc() throws BaseException {
		supportRefresh();
		return cant_nc;
	}

	public void setCant_nc(Money aCant_nc) {
		this.cant_nc = aCant_nc;
	}

	public FacturaCab getFactura() throws BaseException {
		supportRefresh();
		return factura;
	}

	public void setFactura(FacturaCab aFactura) {
		this.factura = aFactura;
	}

	public FacturaDet getFactura_det() throws BaseException {
		supportRefresh();
		return factura_det;
	}

	public void setFactura_det(FacturaDet aFactura_det) {
		this.factura_det = aFactura_det;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AplicNCFact findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AplicNCFact) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicNCFact findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AplicNCFact) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(detalle_nc, "Debe ingresar la NC");
		Validar.noNulo(cant_nc, "Debe ingresar la cantidad");
		Validar.noNulo(factura, "Debe ingresar la Factura");
		Validar.noNulo(factura_det, "Debe ingresar el Detalle de la Factura");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getAplicacionesNC_Fact(FacturaDet facturaDet, ISesion aSesion) throws BaseException {
		return DBAplicNCFact.getAplicacionesNC_Fact(facturaDet, aSesion);
	}

}
