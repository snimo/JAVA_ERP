package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBImpresoraComun;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ImpresoraComun extends ObjetoLogico {

	public ImpresoraComun() {
	}

	public static String				NICKNAME	= "ge.ImpresoraComun";

	private String							codigo;

	private String							descripcion;

	private String							impresora_sistema;

	private Boolean							activo;

	private UnidadOrganizativa	uniOrg;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public UnidadOrganizativa getUnidadOrganizativa() throws BaseException {
		supportRefresh();
		return uniOrg;
	}

	public void setUnidadOrganizativa(UnidadOrganizativa aUniOrg) {
		this.uniOrg = aUniOrg;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getImpresora_sistema() throws BaseException {
		supportRefresh();
		return impresora_sistema;
	}

	public void setImpresora_sistema(String aImpresora_sistema) {
		this.impresora_sistema = aImpresora_sistema;
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

	public static ImpresoraComun findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ImpresoraComun) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ImpresoraComun findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ImpresoraComun) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ImpresoraComun findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ImpresoraComun) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(impresora_sistema, "Debe ingresar el Tipo de Impresora");
		Validar.noNulo(uniOrg, "Debe ingresar la Unidad Organizativa");
	}

	public static List getImpresoras(Sucursal sucursal, ISesion aSesion) throws BaseException {
		return DBImpresoraComun.getImpresoras(sucursal, aSesion);
	}
	
	public static List getAllImpresoras(ISesion aSesion) throws BaseException {
		return DBImpresoraComun.getAllImpresoras(aSesion);
	}
	

}
