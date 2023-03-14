package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBSolicitudCotizProvDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SolicitudCotizProvDet extends ObjetoLogico {

	public SolicitudCotizProvDet() {
	}

	public static String NICKNAME = "cp.SolicitudCotizProvDet";

	private SolicitudCotizProvCab solicitud_cotiz_proveedor;

	private Integer nro_item;

	private Producto producto;

	private String desc_adic_sku;

	private java.util.Date fec_entrega;

	private Double cant_requerida;

	private UnidadMedida unidad_medida;

	private String obs_sol_cotiz;

	private Boolean anulado;

	public SolicitudCotizProvCab getSolicitud_cotiz_proveedor() throws BaseException {
		supportRefresh();
		return solicitud_cotiz_proveedor;
	}

	public void setSolicitud_cotiz_proveedor(SolicitudCotizProvCab aSolicitud_cotiz_proveedor) {
		this.solicitud_cotiz_proveedor = aSolicitud_cotiz_proveedor;
	}

	public Integer getNro_item() throws BaseException {
		supportRefresh();
		return nro_item;
	}

	public void setNro_item(Integer aNro_item) {
		this.nro_item = aNro_item;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public String getDesc_adic_sku() throws BaseException {
		supportRefresh();
		return desc_adic_sku;
	}

	public void setDesc_adic_sku(String aDesc_adic_sku) {
		this.desc_adic_sku = aDesc_adic_sku;
	}

	public java.util.Date getFec_entrega() throws BaseException {
		supportRefresh();
		return fec_entrega;
	}

	public void setFec_entrega(java.util.Date aFec_entrega) {
		this.fec_entrega = aFec_entrega;
	}

	public Double getCant_requerida() throws BaseException {
		supportRefresh();
		return cant_requerida;
	}

	public void setCant_requerida(Double aCant_requerida) {
		this.cant_requerida = aCant_requerida;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public String getObs_sol_cotiz() throws BaseException {
		supportRefresh();
		return obs_sol_cotiz;
	}

	public void setObs_sol_cotiz(String aObs_sol_cotiz) {
		this.obs_sol_cotiz = aObs_sol_cotiz;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean aAnulado) {
		this.anulado = aAnulado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static SolicitudCotizProvDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SolicitudCotizProvDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SolicitudCotizProvDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (SolicitudCotizProvDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static SolicitudCotizProvDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SolicitudCotizProvDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(solicitud_cotiz_proveedor, "Debe ingresar la solicitud de cotización");
		Validar.noNulo(nro_item, "Debe ingresar el Nro. de Item");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(fec_entrega, "Debe ingresar la Fecha de Entrega");
		Validar.noNulo(cant_requerida, "Debe ingresar la cantidad Requerida");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(anulado, "Debe ingresar si esta o no anulado");
	}

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

	public static List getSolicitudesCotizProvDet(SolicitudCotizProvCab solicitudCotizProvCab, ISesion aSesion) throws BaseException {
		return DBSolicitudCotizProvDet.getSolicitudesCotizProvDet(solicitudCotizProvCab, aSesion);
	}

	public static int getUltimoNroItem(ISesion aSesion, SolicitudCotizProvCab solCotizProvCab) throws BaseException {

		return DBSolicitudCotizProvDet.getUltimoNroItem(aSesion, solCotizProvCab);

	}

}
