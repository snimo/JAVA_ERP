package com.srn.erp.mensajero.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Ring extends ObjetoLogico {

	public Ring() {
	}

	public static String NICKNAME = "me.Ring";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static Ring findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Ring) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static Ring findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Ring) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static Ring findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Ring) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public static String getPathArchivos(ISesion aSesion) throws BaseException {
		ValorParametro valorPathImagenesProd = ValorParametro.findByCodigoParametro("PATH_RING", aSesion);
		return valorPathImagenesProd.getValorCadena();				
	}
	
	public static int getIDRingCacheo(ISesion aSesion)
	throws BaseException {
	 try {
		return ValorParametro.findByCodigoParametro(
		"RING_CACHEO", aSesion).getOidObjNeg();
	 } catch (Exception e) {
		 return -1;
	 }
	}
	
	public static int getIDRingAccesoDenegado(ISesion aSesion)
	throws BaseException {
	 try {
		return ValorParametro.findByCodigoParametro(
		"RING_ACCESO_DENEGADO", aSesion).getOidObjNeg();
	 } catch (Exception e) {
		 return -1;
	 }
	}
	
	

}
