package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBNegociacionLegales;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class NegociacionLegales extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public NegociacionLegales() {
	}

	public static String NICKNAME = "leg.NegociacionLegales";

	private Legajo legajo;
	private java.util.Date fecha;
	private String observacion;
	private Money monto;
	private Boolean activo;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		if (observacion!=null)
			return observacion;
		else
			return "";
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public Money getMonto() throws BaseException {
		supportRefresh();
		return monto;
	}

	public void setMonto(Money aMonto) {
		this.monto = aMonto;
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

	public static NegociacionLegales findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NegociacionLegales) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NegociacionLegales findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (NegociacionLegales) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
	}

	public static List getNegociaciones(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBNegociacionLegales.getNegociaciones(aLegajo, aSesion);
	}
	
	public static List getNegociacionesEnSeguimiento(ISesion aSesion) throws BaseException {
		return DBNegociacionLegales.getNegociacionesEnSeguimiento(aSesion);
	}	

}
