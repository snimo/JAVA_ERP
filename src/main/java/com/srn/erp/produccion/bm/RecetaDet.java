package com.srn.erp.produccion.bm;

import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.produccion.da.DBRecetaDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecetaDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RecetaDet() {
	}

	public static String NICKNAME = "pr.RecetaDet";

	private RecetaCab receta_cab;
	private Producto producto;
	private UnidadMedida oid_um;
	private Double cantidad;
	private Double descarte;
	private Boolean activo;
	private Integer orden;

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public RecetaCab getReceta_cab() throws BaseException {
		supportRefresh();
		return receta_cab;
	}

	public void setReceta_cab(RecetaCab aReceta_cab) {
		this.receta_cab = aReceta_cab;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public UnidadMedida getOid_um() throws BaseException {
		supportRefresh();
		return oid_um;
	}

	public void setOid_um(UnidadMedida aOid_um) {
		this.oid_um = aOid_um;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public Double getDescarte() throws BaseException {
		supportRefresh();
		return descarte;
	}

	public void setDescarte(Double aDescarte) {
		this.descarte = aDescarte;
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

	public static RecetaDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecetaDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecetaDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RecetaDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RecetaDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecetaDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(receta_cab, "Debe ingresar la Receta");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(oid_um, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
		Validar.noNulo(orden, "Debe ingresar el Orden");
	}

	public static List getRecetasDet(RecetaCab recetaCab, ISesion aSesion) throws BaseException {
		return DBRecetaDet.getRecetasDet(recetaCab, aSesion);
	}

}
