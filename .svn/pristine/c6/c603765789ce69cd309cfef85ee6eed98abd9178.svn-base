package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBAplicRequiDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicRequiDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AplicRequiDet() {
	}

	public static String NICKNAME = "cp.AplicRequiDet";

	private RequisicionDet requisicion_det;

	private OrdenDeCompraDet detalle_oc;

	private Double cant_comprada;

	private Boolean activo;

	public RequisicionDet getRequisicion_det() throws BaseException {
		supportRefresh();
		return requisicion_det;
	}

	public void setRequisicion_det(RequisicionDet aRequisicion_det) {
		this.requisicion_det = aRequisicion_det;
	}

	public OrdenDeCompraDet getDetalle_oc() throws BaseException {
		supportRefresh();
		return detalle_oc;
	}

	public void setDetalle_oc(OrdenDeCompraDet aDetalle_oc) {
		this.detalle_oc = aDetalle_oc;
	}

	public Double getCant_comprada() throws BaseException {
		supportRefresh();
		return cant_comprada;
	}

	public void setCant_comprada(Double aCant_comprada) {
		this.cant_comprada = aCant_comprada;
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

	public static AplicRequiDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AplicRequiDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicRequiDet findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AplicRequiDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(requisicion_det,
				"Debe ingresar el Detalle de la requisición");
		Validar.noNulo(detalle_oc, "Debe ingresar el Detalle de la OC");
	}

	public static List getAplicOCDet(RequisicionDet requisicionDet,
			ISesion aSesion) throws BaseException {
		return DBAplicRequiDet.getAplicOCDet(requisicionDet, aSesion);
	}
	
	public static List getAplicRequiDet(OrdenDeCompraDet ocDet,
			ISesion aSesion) throws BaseException {
		return DBAplicRequiDet.getAplicOCDet(ocDet, aSesion);
	}
	
	public void afterSaveNew() throws BaseException {

		// Marcar la Orden de Compra de Entrega
		getRequisicion_det().aplicarCantComprada(this);
		getRequisicion_det().marcarSiNoEstaPendDeCompra();
		getRequisicion_det().save();
		
	}
	
	public void anular() throws BaseException {
		// Marcar la Orden de Compra de Entrega
		getRequisicion_det().desaplicarCantComprada(this);
		getRequisicion_det().marcarSiNoEstaPendDeCompra();
		getRequisicion_det().save();
		
	}	

}
