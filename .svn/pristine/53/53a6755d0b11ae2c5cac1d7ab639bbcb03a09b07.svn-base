package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBEquivalenciaRotasCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EquivalenciaRotasCIP extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EquivalenciaRotasCIP() {
	}

	public static String NICKNAME = "cip.EquivalenciaRotasCIP";

	private Rota rota;
	private String codigo_externo;
	private Boolean activo;

	public Rota getRota() throws BaseException {
		supportRefresh();
		return rota;
	}

	public void setRota(Rota aRota) {
		this.rota = aRota;
	}

	public String getCodigo_externo() throws BaseException {
		supportRefresh();
		return codigo_externo;
	}

	public void setCodigo_externo(String aCodigo_externo) {
		this.codigo_externo = aCodigo_externo;
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

	public static EquivalenciaRotasCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EquivalenciaRotasCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static EquivalenciaRotasCIP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EquivalenciaRotasCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static EquivalenciaRotasCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EquivalenciaRotasCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rota, "Debe ingresar la rota");
		Validar.noNulo(codigo_externo, "Debe ingresar el Código Externo");
	}

	public static List getRotasEquivalentes(Rota rota, ISesion aSesion) throws BaseException {
		return DBEquivalenciaRotasCIP.getRotasEquivalentes(rota, aSesion);
	}

}
