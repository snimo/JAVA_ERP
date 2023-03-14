package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBFechaPlanifCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FechaPlanifCacheo extends ObjetoLogico {

	public FechaPlanifCacheo() {
	}

	public static String NICKNAME = "cip.FechaPlanifCacheo";

	private ProcPlanifCacheo proceso;
	private java.util.Date fecha;
	private Boolean activo;

	public ProcPlanifCacheo getProceso() throws BaseException {
		supportRefresh();
		return proceso;
	}

	public void setProceso(ProcPlanifCacheo aProceso) {
		this.proceso = aProceso;
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

	public static FechaPlanifCacheo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (FechaPlanifCacheo) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static FechaPlanifCacheo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (FechaPlanifCacheo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static FechaPlanifCacheo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (FechaPlanifCacheo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(proceso, "Debe ingresar el proceso");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static FechaPlanifCacheo getFechaPlanifCacheo(
			java.util.Date fecha, 
			ISesion aSesion) throws BaseException {
		return DBFechaPlanifCacheo.getFechaPlanifCacheo(fecha, aSesion);
	}

}
