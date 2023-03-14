package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotivosEquivCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivosEquivCIP extends ObjetoLogico {
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public MotivosEquivCIP() {
	}

	public static String NICKNAME = "cip.MotivosEquivCIP";

	private MotivosNovCIP motivo;
	private String codigo_externo;
	private Boolean activo;

	public MotivosNovCIP getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivosNovCIP aMotivo) {
		this.motivo = aMotivo;
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

	public static MotivosEquivCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivosEquivCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivosEquivCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivosEquivCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(motivo, "Debe ingresar el Motivo");
		Validar.noNulo(codigo_externo, "Debe ingresar el Código");
	}

	public static List getEquivMotivos(MotivosNovCIP motivo, ISesion aSesion) throws BaseException {
		return DBMotivosEquivCIP.getEquivMotivos(motivo, aSesion);
	}
	
	

}
