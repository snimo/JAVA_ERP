package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotEntInterLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotEntInterLeg extends ObjetoLogico {

	public MotEntInterLeg() {
	}

	public static String NICKNAME = "cip.MotEntInterLeg";

	private MotivoEntIntermedias motivo;
	private Legajo legajo;
	private Boolean activo;

	public MotivoEntIntermedias getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoEntIntermedias aMotivo) {
		this.motivo = aMotivo;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
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

	public static MotEntInterLeg findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (MotEntInterLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotEntInterLeg findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (MotEntInterLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(motivo, "Debe ingresar los Motivos Intermedios");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getMotivosLegajo(Legajo aLegajo, ISesion aSesion)
			throws BaseException {
		return DBMotEntInterLeg.getMotivosLegajo(aLegajo, aSesion);
	}

	public static MotEntInterLeg getMotEntInterLeg(
			Legajo legajo,
			MotivoEntIntermedias motivoEntIntermedias, 
			ISesion aSesion)
			throws BaseException {
		return DBMotEntInterLeg.getMotEntInterLeg(legajo,motivoEntIntermedias, aSesion);
	}

}
