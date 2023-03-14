package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBObsCodifEvalRango;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ObsCodifEvalRango extends ObjetoLogico {

	public ObsCodifEvalRango() {
	}

	public static String NICKNAME = "rh.ObsCodifEvalRango";

	private Integer orden;
	private ObsCodifEvalRH oid_obs_codif;
	private RangoPtajeObsCodif mod_obs_codif;
	private String descripcion;
	private Boolean activo;

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public ObsCodifEvalRH getOid_obs_codif() throws BaseException {
		supportRefresh();
		return oid_obs_codif;
	}

	public void setOid_obs_codif(ObsCodifEvalRH aOid_obs_codif) {
		this.oid_obs_codif = aOid_obs_codif;
	}

	public RangoPtajeObsCodif getMod_obs_codif() throws BaseException {
		supportRefresh();
		return mod_obs_codif;
	}

	public void setMod_obs_codif(RangoPtajeObsCodif aMod_obs_codif) {
		this.mod_obs_codif = aMod_obs_codif;
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

	public static ObsCodifEvalRango findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsCodifEvalRango) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ObsCodifEvalRango findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ObsCodifEvalRango) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		//Validar.noNulo(orden, "Debe ingresar la Condicion");
		Validar.noNulo(oid_obs_codif, "Debe ingresar la Observación Codificada");
		Validar.noNulo(mod_obs_codif, "Debe ingresar el Rango");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static List getObsCodif(RangoPtajeObsCodif aRangoPtajeObsCodif,
	          ISesion aSesion) throws BaseException {
		  return DBObsCodifEvalRango.getObsCodif(aRangoPtajeObsCodif,aSesion);
	}
	

}
