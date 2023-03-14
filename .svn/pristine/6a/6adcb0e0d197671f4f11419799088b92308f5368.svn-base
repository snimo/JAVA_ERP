package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBModeloEvalGrados;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ModeloEvalGrados extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNro_grado().toString();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getDesc_grados();
	}

	public ModeloEvalGrados() {
	}

	public static String NICKNAME = "rh.ModeloEvalGrados";

	private ModeloEvalCompe modelo_evaluacion;
	private Integer nro_grado;
	private String desc_grados;
	private Money peso;
	private Boolean activo;

	public ModeloEvalCompe getModelo_evaluacion() throws BaseException {
		supportRefresh();
		return modelo_evaluacion;
	}

	public void setModelo_evaluacion(ModeloEvalCompe aModelo_evaluacion) {
		this.modelo_evaluacion = aModelo_evaluacion;
	}

	public Integer getNro_grado() throws BaseException {
		supportRefresh();
		return nro_grado;
	}

	public void setNro_grado(Integer aNro_grado) {
		this.nro_grado = aNro_grado;
	}

	public String getDesc_grados() throws BaseException {
		supportRefresh();
		return desc_grados;
	}

	public void setDesc_grados(String aDesc_grados) {
		this.desc_grados = aDesc_grados;
	}

	public Money getPeso() throws BaseException {
		supportRefresh();
		return peso;
	}

	public void setPeso(Money aPeso) {
		this.peso = aPeso;
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

	public static ModeloEvalGrados findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ModeloEvalGrados) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ModeloEvalGrados findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ModeloEvalGrados) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(modelo_evaluacion, "Debe ingresar la competencia");
		Validar.noNulo(nro_grado, "Debe ingresar el Nro. de Grado");
		Validar.noNulo(desc_grados, "Debe ingresar la Descripción del Grado");
		Validar.noNulo(peso, "Debe ingresar el peso");
	}
	
	public static List getGradosByCompetencia(ModeloEvalCompe modeloEvalCompe,
	          ISesion aSesion) throws BaseException {
		  return DBModeloEvalGrados.getGradosByCompetencia(modeloEvalCompe,aSesion);
	}
	
	public static ModeloEvalGrados getModeloEvalGrados(
			  ModeloEvalCompe modeloEvalCompe,
			  Integer nroGrado,
	          ISesion aSesion)
	          throws BaseException {
		  return DBModeloEvalGrados.getModeloEvalGrados(modeloEvalCompe,nroGrado,aSesion);
	}
	
		
	public static ModeloEvalGrados getModeloEvalGrados(
				  CondModEvalCab condModEvalCab,
				  Competencia competencia,
				  Integer nroGrado,
		          ISesion aSesion)
		          throws BaseException {
			  return DBModeloEvalGrados.getModeloEvalGrados(condModEvalCab,competencia,nroGrado,aSesion);
	}
		
		
	
	
	

}
