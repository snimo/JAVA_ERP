package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBLegjoCondModEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LegjoCondModEval extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public LegjoCondModEval() {
	}

	public static String NICKNAME = "rh.LegjoCondModEval";

	private CondModEvalCab condicion_modelo;
	private Legajo legajo;
	private Boolean activo;

	public CondModEvalCab getCondicion_modelo() throws BaseException {
		supportRefresh();
		return condicion_modelo;
	}

	public void setCondicion_modelo(CondModEvalCab aCondicion_modelo) {
		this.condicion_modelo = aCondicion_modelo;
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

	public static LegjoCondModEval findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LegjoCondModEval) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LegjoCondModEval findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LegjoCondModEval) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(condicion_modelo, "Debe ingresar la condición del Modelo");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
	}

	public static List getLegCondModEval(CondModEvalCab condModEvalCab, ISesion aSesion) throws BaseException {
		return DBLegjoCondModEval.getLegCondModEval(condModEvalCab, aSesion);
	}

	public static LegjoCondModEval getLegajoCondModEval(CondModEvalCab condModEvalCab, Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBLegjoCondModEval.getLegajoCondModEval(condModEvalCab, aLegajo, aSesion);
	}

}
