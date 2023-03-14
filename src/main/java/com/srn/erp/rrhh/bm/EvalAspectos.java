package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBEvalAspectos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EvalAspectos extends ObjetoLogico {

	public EvalAspectos() {
	}

	public static String NICKNAME = "rh.EvalAspectos";
	
	public static final String ASP_DES = "DES";
	public static final String ASP_MEJ = "MEJ";

	private EvaluacionLegajoCab evaluacion;
	private String tipo_aspecto;
	private Boolean activo;
	private java.util.Date fec_alta;
	private String aspecto;
	private Usuario usuario_alta;
	private java.util.Date fec_modif;
	private Usuario usuario_modif;

	public EvaluacionLegajoCab getEvaluacion() throws BaseException {
		supportRefresh();
		return evaluacion;
	}

	public void setEvaluacion(EvaluacionLegajoCab aEvaluacion) {
		this.evaluacion = aEvaluacion;
	}

	public String getTipo_aspecto() throws BaseException {
		supportRefresh();
		return tipo_aspecto;
	}

	public void setTipo_aspecto(String aTipo_aspecto) {
		this.tipo_aspecto = aTipo_aspecto;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public java.util.Date getFec_alta() throws BaseException {
		supportRefresh();
		return fec_alta;
	}

	public void setFec_alta(java.util.Date aFec_alta) {
		this.fec_alta = aFec_alta;
	}

	public String getAspecto() throws BaseException {
		supportRefresh();
		return aspecto;
	}

	public void setAspecto(String aAspecto) {
		this.aspecto = aAspecto;
	}

	public Usuario getUsuario_alta() throws BaseException {
		supportRefresh();
		return usuario_alta;
	}

	public void setUsuario_alta(Usuario aUsuario_alta) {
		this.usuario_alta = aUsuario_alta;
	}

	public java.util.Date getFec_modif() throws BaseException {
		supportRefresh();
		return fec_modif;
	}

	public void setFec_modif(java.util.Date aFec_modif) {
		this.fec_modif = aFec_modif;
	}

	public Usuario getUsuario_modif() throws BaseException {
		supportRefresh();
		return usuario_modif;
	}

	public void setUsuario_modif(Usuario aUsuario_modif) {
		this.usuario_modif = aUsuario_modif;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EvalAspectos findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EvalAspectos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EvalAspectos findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EvalAspectos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(evaluacion, "Debe ingresar la Evaluación");
		Validar.noNulo(tipo_aspecto, "Debe ingresar el Tipo de Aspecto");
		Validar.noNulo(fec_alta, "Debe ingresar la Fecha de Alta");
		Validar.noNulo(aspecto, "Debe ingresar el Aspecto");
		Validar.noNulo(usuario_alta, "Debe ingresar el usuario de Alta");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getEvalAspectos(EvaluacionLegajoCab aEvaluacionLegajoCab, ISesion aSesion) throws BaseException {
		return DBEvalAspectos.getEvalAspectos(aEvaluacionLegajoCab, aSesion);
	}

}
