package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.rrhh.da.DBModeloEvalCompe;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ModeloEvalCompe extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ModeloEvalCompe() {
	}

	public static String NICKNAME = "rh.ModeloEvalCompe";
	
	private List grados = new ArrayList();
	private boolean readGrados = true;
	

	private CondModEvalCab condicion_modelo;
	private Competencia competencia;
	private Integer orden;
	private String codigo_compe;
	private String titulo_compe;
	private String definicion_compe;
	private Money peso_competencia;
	private Boolean activo;

	public CondModEvalCab getCondicion_modelo() throws BaseException {
		supportRefresh();
		return condicion_modelo;
	}

	public void setCondicion_modelo(CondModEvalCab aCondicion_modelo) {
		this.condicion_modelo = aCondicion_modelo;
	}

	public Competencia getCompetencia() throws BaseException {
		supportRefresh();
		return competencia;
	}

	public void setCompetencia(Competencia aCompetencia) {
		this.competencia = aCompetencia;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getCodigo_compe() throws BaseException {
		supportRefresh();
		return codigo_compe;
	}

	public void setCodigo_compe(String aCodigo_compe) {
		this.codigo_compe = aCodigo_compe;
	}

	public String getTitulo_compe() throws BaseException {
		supportRefresh();
		return titulo_compe;
	}

	public void setTitulo_compe(String aTitulo_compe) {
		this.titulo_compe = aTitulo_compe;
	}

	public String getDefinicion_compe() throws BaseException {
		supportRefresh();
		return definicion_compe;
	}

	public void setDefinicion_compe(String aDefinicion_compe) {
		this.definicion_compe = aDefinicion_compe;
	}

	public Money getPeso_competencia() throws BaseException {
		supportRefresh();
		return peso_competencia;
	}

	public void setPeso_competencia(Money aPeso_competencia) {
		this.peso_competencia = aPeso_competencia;
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

	public static ModeloEvalCompe findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ModeloEvalCompe) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ModeloEvalCompe findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ModeloEvalCompe) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static ModeloEvalCompe findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ModeloEvalCompe) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(condicion_modelo, "Debe ingresar el Modelo de Condición");
		Validar.noNulo(competencia, "Debe ingresar la Competencia");
		Validar.noNulo(orden, "Debe ingresar el Orden");
		Validar.noNulo(codigo_compe, "Debe ingresar el Código de Competencia");
		Validar.noNulo(titulo_compe, "Debe ingresar el Título de la Competencia");
		Validar.noNulo(peso_competencia, "Debe ingresar el Peso de la competencia");
	}

	public static List getModeloEvalCompeByCondicion(CondModEvalCab condicion,
	          ISesion aSesion) throws BaseException {
		  return DBModeloEvalCompe.getModeloEvalCompeByCondicion(condicion,aSesion);
	}
	
	public List getGrados() throws BaseException {
		if (this.readGrados) {
		      List listaGrados = ModeloEvalGrados.getGradosByCompetencia(this,getSesion());
		      grados.addAll(listaGrados);
		      this.readGrados = false;
		}
		return grados;
	}

	public void addGrado(ModeloEvalGrados aModeloEvalGrado) throws BaseException {
		aModeloEvalGrado.setModelo_evaluacion(this);
		grados.add(aModeloEvalGrado);
	}

	public void afterSave() throws BaseException {
		    Iterator iterGrados = grados.iterator();
		    while (iterGrados.hasNext()) {
		      ModeloEvalGrados modeloEvalGrado = (ModeloEvalGrados) iterGrados.next();
		      modeloEvalGrado.save();
		      modeloEvalGrado = null;
		    }
		    iterGrados = null;
	}
	
	public ModeloEvalGrados getModeloEvalGrados(
			  Integer nroGrado,
	          ISesion aSesion)
	          throws BaseException {
		  return ModeloEvalGrados.getModeloEvalGrados(this,nroGrado,this.getSesion());
	}

	public static ModeloEvalCompe getModeloEvalCompe(
			  CondModEvalCab condModEvalCab,
			  Competencia competencia,
	          ISesion aSesion)
	          throws BaseException {
		  return DBModeloEvalCompe.getModeloEvalCompe(condModEvalCab,competencia,aSesion);
	}
	
	
	
	
}
