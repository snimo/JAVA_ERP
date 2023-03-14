package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBCartasDocRemLega;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CartasDocRemLega extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CartasDocRemLega() {
	}

	public static String NICKNAME = "leg.CartasDocRemLega";

	private Integer nro_orden;
	private Legajo legajo;
	private String nro_carta_doc;
	private java.util.Date fecha;
	private TipoCausaLegales tipoCausa;
	private String causa;
	private java.util.Date recibido;
	private String observaciones;
	private Boolean activo;

	public Integer getNro_orden() throws BaseException {
		supportRefresh();
		return nro_orden;
	}

	public void setNro_orden(Integer aNro_orden) {
		this.nro_orden = aNro_orden;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public String getNro_carta_doc() throws BaseException {
		supportRefresh();
		return nro_carta_doc;
	}

	public void setNro_carta_doc(String aNro_carta_doc) {
		this.nro_carta_doc = aNro_carta_doc;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public TipoCausaLegales getTipocausa() throws BaseException {
		supportRefresh();
		return tipoCausa;
	}

	public void setTipocausa(TipoCausaLegales aTipocausa) {
		this.tipoCausa = aTipocausa;
	}

	public String getCausa() throws BaseException {
		supportRefresh();
		return causa;
	}

	public void setCausa(String aCausa) {
		this.causa = aCausa;
	}

	public java.util.Date getRecibido() throws BaseException {
		supportRefresh();
		return recibido;
	}

	public void setRecibido(java.util.Date aRecibido) {
		this.recibido = aRecibido;
	}

	public String getObservaciones() throws BaseException {
		supportRefresh();
		return observaciones;
	}

	public void setObservaciones(String aObservaciones) {
		this.observaciones = aObservaciones;
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

	public static CartasDocRemLega findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CartasDocRemLega) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CartasDocRemLega findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CartasDocRemLega) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
	}

	
	public static List getCartasDocRemLega(Legajo aLegajo,
	          ISesion aSesion) throws BaseException {
		  return DBCartasDocRemLega.getCartasDocRemLega(aLegajo,aSesion);
	}
	
	public static List getCartasDocRem(HashTableDatos condiciones,
	          ISesion aSesion) throws BaseException {
	      return DBCartasDocRemLega.getCartasDocRem(condiciones,aSesion);
	}  
	
	
}
