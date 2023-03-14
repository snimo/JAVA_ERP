package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBEvalValClasifLeg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EvalValClasifLeg extends ObjetoLogico {

	public EvalValClasifLeg() {
	}

	public static String NICKNAME = "rh.EvalValClasifLeg";

	private EvaluacionLegajoCab evaluacion;
	private ClasificadorEntidad clasificador;
	private ValorClasificadorEntidad valor_clasificador;
	private Boolean activo;

	public EvaluacionLegajoCab getEvaluacion() throws BaseException {
		supportRefresh();
		return evaluacion;
	}

	public void setEvaluacion(EvaluacionLegajoCab aEvaluacion) {
		this.evaluacion = aEvaluacion;
	}

	public ClasificadorEntidad getClasificador() throws BaseException {
		supportRefresh();
		return clasificador;
	}

	public void setClasificador(ClasificadorEntidad aClasificador) {
		this.clasificador = aClasificador;
	}

	public ValorClasificadorEntidad getValor_clasificador() throws BaseException {
		supportRefresh();
		return valor_clasificador;
	}

	public void setValor_clasificador(ValorClasificadorEntidad aValor_clasificador) {
		this.valor_clasificador = aValor_clasificador;
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

	public static EvalValClasifLeg findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EvalValClasifLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EvalValClasifLeg findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EvalValClasifLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(evaluacion, "Debe ingresar la Evaluación");
		Validar.noNulo(clasificador, "Debe ingresar el Clasificador");
		Validar.noNulo(valor_clasificador, "Debe ingresar el valor del clasificador");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getEvalValoresClasif(EvaluacionLegajoCab evaluacion, ISesion aSesion) throws BaseException {
		return DBEvalValClasifLeg.getEvalValoresClasif(evaluacion, aSesion);
	}

	public static EvalValClasifLeg getEvalValClasifLeg(EvaluacionLegajoCab evaluacion, ClasificadorEntidad clasificador, ISesion aSesion) throws BaseException {
		return DBEvalValClasifLeg.getEvalValClasifLeg(evaluacion, clasificador, aSesion);
	}

}
