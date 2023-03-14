package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBEmpresaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EmpresaCIP extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EmpresaCIP() {
	}

	public static String NICKNAME = "cip.EmpresaCIP";

	private String razon_social;
	private Boolean activo;

	public String getRazon_social() throws BaseException {
		supportRefresh();
		return razon_social;
	}

	public void setRazon_social(String aRazon_social) {
		this.razon_social = aRazon_social;
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

	public static EmpresaCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EmpresaCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EmpresaCIP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EmpresaCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EmpresaCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EmpresaCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(razon_social, "Debe ingresar la Razón Social");
	}

	public static EmpresaCIP getEmpresaCIP(String razonSocial, ISesion aSesion) throws BaseException {
		return DBEmpresaCIP.getEmpresaCIP(razonSocial, aSesion);
	}

	public static List getEmpresasCIP(String empresa, ISesion aSesion) throws BaseException {
		return DBEmpresaCIP.getEmpresasCIP(empresa, aSesion);
	}

}
