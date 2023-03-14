package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBEvalFirma;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EvalFirma extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EvalFirma() {
	}

	public static String NICKNAME = "rh.EvalFirma";

	private EvaluacionLegajoCab evaluacion;
	private Integer nro_firma;
	private Legajo legajo_firma;
	private Boolean firmo;
	private java.util.Date fec_firma;
	private Boolean activo;
	private String titulo;

	public EvaluacionLegajoCab getEvaluacion() throws BaseException {
		supportRefresh();
		return evaluacion;
	}

	public void setEvaluacion(EvaluacionLegajoCab aEvaluacion) {
		this.evaluacion = aEvaluacion;
	}
	
	public String getTitulo() throws BaseException {
		supportRefresh();
		return titulo;
	}

	public void setTitulo(String aTitulo) {
		this.titulo = aTitulo;
	}
	

	public Integer getNro_firma() throws BaseException {
		supportRefresh();
		return nro_firma;
	}

	public void setNro_firma(Integer aNro_firma) {
		this.nro_firma = aNro_firma;
	}

	public Legajo getLegajo_firma() throws BaseException {
		supportRefresh();
		return legajo_firma;
	}

	public void setLegajo_firma(Legajo aLegajo_firma) {
		this.legajo_firma = aLegajo_firma;
	}

	public Boolean isFirmo() throws BaseException {
		supportRefresh();
		return firmo;
	}

	public void setFirmo(Boolean aFirmo) {
		this.firmo = aFirmo;
	}

	public java.util.Date getFec_firma() throws BaseException {
		supportRefresh();
		return fec_firma;
	}

	public void setFec_firma(java.util.Date aFec_firma) {
		this.fec_firma = aFec_firma;
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

	public static EvalFirma findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EvalFirma) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EvalFirma findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EvalFirma) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(evaluacion, "Debe ingresar la Evaluación");
	}
	
	public static List getEvalFirmas(EvaluacionLegajoCab aEvaluacionLegajoCab,
	          ISesion aSesion) throws BaseException {
		  return DBEvalFirma.getEvalFirmas(aEvaluacionLegajoCab,aSesion);
	}

}
