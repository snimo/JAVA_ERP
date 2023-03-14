package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBMotDifPagoExc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotDifPagoExc extends ObjetoLogico {

	public MotDifPagoExc() {
	}

	public static String NICKNAME = "exc.MotDifPagoExc";

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

	public static MotDifPagoExc findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotDifPagoExc) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotDifPagoExc findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotDifPagoExc) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MotDifPagoExc findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotDifPagoExc) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBMotDifPagoExc.getAllActivos(aSesion);
	}

}
