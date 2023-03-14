package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBColorExcluido;
import com.srn.erp.excluidos.da.DBGerenteExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GerenteExcluido extends ObjetoLogico {

	public GerenteExcluido() {
	}

	public static String NICKNAME = "exc.GerenteExcluido";

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

	public static GerenteExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GerenteExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GerenteExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GerenteExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GerenteExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GerenteExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBGerenteExcluido.getAllActivos(aSesion);
	}


}
