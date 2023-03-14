package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBEvalObsGen;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EvalObsGen extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EvalObsGen() {
	}

	public static String NICKNAME = "rh.EvalObsGen";

	private EvaluacionLegajoCab evaluacion;
	private String observacion;
	private java.util.Date fec_alta;
	private Usuario usuario_alta;
	private java.util.Date fec_utl_modif;
	private Usuario usuario_modif;
	private Boolean activo;

	public EvaluacionLegajoCab getEvaluacion() throws BaseException {
		supportRefresh();
		return evaluacion;
	}

	public void setEvaluacion(EvaluacionLegajoCab aEvaluacion) {
		this.evaluacion = aEvaluacion;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public java.util.Date getFec_alta() throws BaseException {
		supportRefresh();
		return fec_alta;
	}

	public void setFec_alta(java.util.Date aFec_alta) {
		this.fec_alta = aFec_alta;
	}

	public Usuario getUsuario_alta() throws BaseException {
		supportRefresh();
		return usuario_alta;
	}

	public void setUsuario_alta(Usuario aUsuario_alta) {
		this.usuario_alta = aUsuario_alta;
	}

	public java.util.Date getFec_utl_modif() throws BaseException {
		supportRefresh();
		return fec_utl_modif;
	}

	public void setFec_utl_modif(java.util.Date aFec_utl_modif) {
		this.fec_utl_modif = aFec_utl_modif;
	}

	public Usuario getUsuario_modif() throws BaseException {
		supportRefresh();
		return usuario_modif;
	}

	public void setUsuario_modif(Usuario aUsuario_modif) {
		this.usuario_modif = aUsuario_modif;
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

	public static EvalObsGen findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EvalObsGen) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EvalObsGen findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EvalObsGen) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(evaluacion, "Debe ingresar la Evaluación");
		Validar.noNulo(observacion, "Debe ingresar la Observación");
		Validar.noNulo(fec_alta, "Debe ingresar la fecha de Alta");
		Validar.noNulo(usuario_alta, "Debe ingresar el usuario de Alta");
	}
	
	public static List getEvalObsGen(EvaluacionLegajoCab aEvaluacion,
            ISesion aSesion) throws BaseException {
		  return DBEvalObsGen.getEvalObsGen(aEvaluacion,aSesion);
	}
	

}
