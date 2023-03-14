package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBFechaExclusionCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class FechaExclusionCacheo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public FechaExclusionCacheo() {
	}

	public static String NICKNAME = "cip.FechaExclusionCacheo";

	private AlgoritmoCacheo algoritmo;
	private java.util.Date fecha;
	private Boolean activo;

	public AlgoritmoCacheo getAlgoritmo() throws BaseException {
		supportRefresh();
		return algoritmo;
	}

	public void setAlgoritmo(AlgoritmoCacheo aAlgoritmo) {
		this.algoritmo = aAlgoritmo;
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

	public static FechaExclusionCacheo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (FechaExclusionCacheo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FechaExclusionCacheo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (FechaExclusionCacheo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(algoritmo, "Debe ingresar el algoritmo");
		Validar.noNulo(fecha, "Debe ingresar la fecha");
	}

	public static List getFechasExclusionCacheo(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return DBFechaExclusionCacheo.getFechasExclusionCacheo(algoritmo, aSesion);
	}

	public static FechaExclusionCacheo getFechaExclusionCacheo(
			AlgoritmoCacheo algoritmo, 
			java.util.Date fecha, 
			ISesion aSesion)
			throws BaseException {
		return DBFechaExclusionCacheo.getFechaExclusionCacheo(algoritmo, fecha, aSesion);
	}

}
