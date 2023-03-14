package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.tesoreria.da.DBBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Banco extends ObjetoLogico {

	public Banco() {
	}

	public static String	NICKNAME	= "te.Banco";

	private String				codigo;

	private String				descripcion;

	private Boolean				activo;

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

	public static Banco findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Banco) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Banco findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Banco) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Banco findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Banco) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
	}

	public static List getHelpBancos(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBBanco.getHelpBancos(condiciones, aSesion);
	}
	
	public static List getAllBancosActivos(
            ISesion aSesion) throws BaseException {
		  return DBBanco.getAllBancosActivos(aSesion);
	}


}
