package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBCtaBancoLiqTarj;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class CtaBancoLiqTarj extends ObjetoLogico {

	public CtaBancoLiqTarj() {
	}

	public static String NICKNAME = "ctar.CtaBancoLiqTarj";

	private String codigo;
	private String descripcion;
	private String cod_interfaz;
	private Boolean activo;
	private EmpresaConciTar empresa;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}
	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setEmpresa(EmpresaConciTar aEmpresaConciTar) {
		this.empresa = aEmpresaConciTar;
	}
	

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getCod_interfaz() throws BaseException {
		supportRefresh();
		return cod_interfaz;
	}

	public void setCod_interfaz(String aCod_interfaz) {
		this.cod_interfaz = aCod_interfaz;
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

	public static CtaBancoLiqTarj findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CtaBancoLiqTarj) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static CtaBancoLiqTarj findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CtaBancoLiqTarj) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static CtaBancoLiqTarj findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CtaBancoLiqTarj) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static List getCtasByEmpresa(EmpresaConciTar empresa,ISesion aSesion) throws BaseException {
		  return DBCtaBancoLiqTarj.getCtasByEmpresa(empresa,aSesion);
	}

}
