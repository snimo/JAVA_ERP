package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBEvalEvaluador;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EvalEvaluador extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EvalEvaluador() {
	}

	public static String NICKNAME = "rh.EvalEvaluador";

	private EvaluacionLegajoCab evaluacion;
	private Boolean activo;
	private Boolean firmado;
	private Legajo legajo;
	private java.util.Date fec_firmado;

	public EvaluacionLegajoCab getEvaluacion() throws BaseException {
		supportRefresh();
		return evaluacion;
	}

	public void setEvaluacion(EvaluacionLegajoCab aEvaluacion) {
		this.evaluacion = aEvaluacion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Boolean isFirmado() throws BaseException {
		supportRefresh();
		return firmado;
	}

	public void setFirmado(Boolean aFirmado) {
		this.firmado = aFirmado;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public java.util.Date getFec_firmado() throws BaseException {
		supportRefresh();
		return fec_firmado;
	}

	public void setFec_firmado(java.util.Date aFec_firmado) {
		this.fec_firmado = aFec_firmado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EvalEvaluador findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EvalEvaluador) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EvalEvaluador findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EvalEvaluador) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(evaluacion, "Debe ingresar la Evaluación");
	}
	
	public static List getEvalEvaluadores(EvaluacionLegajoCab aEvaluacionLegajoCab,
	          ISesion aSesion) throws BaseException {
		  return DBEvalEvaluador.getEvalEvaluadores(aEvaluacionLegajoCab,aSesion);
	}
	

}
