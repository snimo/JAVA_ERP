package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBTipoDocumentacionCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoDocumentacionCIP extends ObjetoLogico {

	public TipoDocumentacionCIP() {
	}

	public static String NICKNAME = "cip.TipoDocumentacionCIP";

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

	public static TipoDocumentacionCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoDocumentacionCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoDocumentacionCIP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoDocumentacionCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TipoDocumentacionCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoDocumentacionCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {
		  return DBTipoDocumentacionCIP.getAllActivos(aSesion);
	}

}
