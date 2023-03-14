package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBLugarHechoExcluido;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LugarHechoExcluido extends ObjetoLogico {

	public LugarHechoExcluido() {
	}

	public static String NICKNAME = "exc.LugarHechoExcluido";

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

	public static LugarHechoExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LugarHechoExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LugarHechoExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (LugarHechoExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static LugarHechoExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LugarHechoExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public static List getLugaresHecho(ISesion aSesion) throws BaseException {
		return DBLugarHechoExcluido.getLugaresHecho(aSesion);
	}

}
