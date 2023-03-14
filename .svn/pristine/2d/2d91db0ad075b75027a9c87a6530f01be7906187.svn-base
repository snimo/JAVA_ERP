package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBLegajoRotaFecha;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class LegajoRotaFecha extends ObjetoLogico {

	public LegajoRotaFecha() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "cip.LegajoRotaFecha";

	private Legajo legajo;
	private Rota rota;
	private java.util.Date fecha;
	private Boolean activo;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public Rota getRota() throws BaseException {
		supportRefresh();
		return rota;
	}

	public void setRota(Rota aRota) {
		this.rota = aRota;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
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

	public static LegajoRotaFecha findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LegajoRotaFecha) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LegajoRotaFecha findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LegajoRotaFecha) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(rota, "Debe ingresar la Rota");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(activo, "Debe ingresar si esta o no activo");
	}

	public static LegajoRotaFecha getLegajoFechaRota(Legajo legajo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBLegajoRotaFecha.getLegajoFechaRota(legajo, fecha, aSesion);
	}

	public static List getLegajosFechaRotas(java.util.Date fechaDesde, java.util.Date fechaHasta, ISesion aSesion) throws BaseException {
		return DBLegajoRotaFecha.getLegajosFechaRotas(fechaDesde, fechaHasta, aSesion);
	}

	public static LegajoRotaFecha getLegajoRotaFecha(Legajo legajo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBLegajoRotaFecha.getLegajoRotaFecha(legajo, fecha, aSesion);
	}

	public static List getLegajosFechaRotas(java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBLegajoRotaFecha.getLegajosFechaRotas(fecha, aSesion);
	}

	public static int getCantLegPorFecha(Rota rota, java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Rota.NICKNAME, rota);
		condiciones.put("FECHA", fecha);
		return DBLegajoRotaFecha.getCantLegPorFecha(condiciones, aSesion);
	}

	public static LegajoRotaFecha getLegajoFechaRota(java.util.Date fecha, Legajo legajo, Rota rota, ISesion aSesion) throws BaseException {

		return DBLegajoRotaFecha.getLegajoFechaRota(fecha, legajo, rota, aSesion);
	}

	public static List getLegajoMayIgualFecha(java.util.Date fecha, Legajo legajo, ISesion aSesion) throws BaseException {
		return DBLegajoRotaFecha.getLegajoMayIgualFecha(fecha, legajo, aSesion);
	}
	
	public static List getConsPlanifDistMesas(
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			Rota rota,
			FiltroLegCab filtro,
			String juegos,
			ISesion aSesion) throws BaseException {
		return DBLegajoRotaFecha.getConsPlanifDistMesas(fechaDesde,fechaHasta,rota,filtro,juegos,aSesion); 
	}	
	

}
