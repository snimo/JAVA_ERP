package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBMotivoNovedadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoNovedadExcluido extends ObjetoLogico {

	public MotivoNovedadExcluido() {
	}

	public static String NICKNAME = "exc.MotivoNovedadExcluido";

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

	public static MotivoNovedadExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoNovedadExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static MotivoNovedadExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoNovedadExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static MotivoNovedadExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivoNovedadExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBMotivoNovedadExcluido.getAllActivos(aSesion);
	}
	

}
