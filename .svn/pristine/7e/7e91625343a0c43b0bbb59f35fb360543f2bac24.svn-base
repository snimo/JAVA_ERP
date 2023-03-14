package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.rrhh.da.DBModeloEvalCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ModeloEvalCab extends ObjetoLogico {

	private List condiciones = new ArrayList();
	private boolean readCondiciones = true;

	public static final String TIPO_DESEN = "DESEN";
	public static final String TIPO_POTEN = "POTEN";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getDesc_abreviada();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getTitulo();
	}

	public ModeloEvalCab() {
	}

	public static String NICKNAME = "rh.ModeloEvalCab";

	private String titulo;
	private String desc_abreviada;
	private java.util.Date fec_desde;
	private java.util.Date fec_hasta;
	private Boolean vigente;
	private Boolean activo;
	private String tipo;

	public String getTitulo() throws BaseException {
		supportRefresh();
		return titulo;
	}

	public void setTitulo(String aTitulo) {
		this.titulo = aTitulo;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public String getDesc_abreviada() throws BaseException {
		supportRefresh();
		return desc_abreviada;
	}

	public void setDesc_abreviada(String aDesc_abreviada) {
		this.desc_abreviada = aDesc_abreviada;
	}

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public java.util.Date getFec_hasta() throws BaseException {
		supportRefresh();
		return fec_hasta;
	}

	public void setFec_hasta(java.util.Date aFec_hasta) {
		this.fec_hasta = aFec_hasta;
	}

	public Boolean isVigente() throws BaseException {
		supportRefresh();
		return vigente;
	}

	public void setVigente(Boolean aVigente) {
		this.vigente = aVigente;
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

	public static ModeloEvalCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ModeloEvalCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ModeloEvalCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ModeloEvalCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ModeloEvalCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ModeloEvalCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(titulo, "Debe ingresar el Título");
		Validar.noNulo(desc_abreviada, "Debe ingresar la Descripción Abreviada");
		Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
		Validar.noNulo(vigente, "Debe indicar si se encuentra o no vigente");
		Validar.noNulo(tipo, "Debe ingresar el Tipo de Evaluación");
	}

	public List getCondiciones() throws BaseException {
		if (this.readCondiciones) {
			List listaCondiciones = CondModEvalCab.getCondiciones(this, getSesion());
			condiciones.addAll(listaCondiciones);
			this.readCondiciones = false;
		}
		return condiciones;
	}

	public void addCondicion(CondModEvalCab aCondModEvalCab) throws BaseException {
		aCondModEvalCab.setModelo_eval_cab(this);
		condiciones.add(aCondModEvalCab);
	}

	public void afterSave() throws BaseException {

		// Grabar primero las condiciones
		Iterator iterCondiciones = this.condiciones.iterator();
		while (iterCondiciones.hasNext()) {
			CondModEvalCab condModEvalCab = (CondModEvalCab) iterCondiciones.next();
			condModEvalCab.save();
			condModEvalCab = null;
		}
		iterCondiciones = null;

	}

	public static List getModelosVigentes(ISesion aSesion) throws BaseException {
		return DBModeloEvalCab.getModelosVigentes(aSesion);
	}

	public CondModEvalCab getCondModeloSegunLeg(Legajo aLegajo) throws BaseException {

		Iterator iterCondiciones = this.getCondiciones().iterator();
		while (iterCondiciones.hasNext()) {
			CondModEvalCab condModEvalCab = (CondModEvalCab) iterCondiciones.next();
			if (condModEvalCab.isLegajoCumpleCond(aLegajo))
				return condModEvalCab;
		}

		return null;
	}

	public static List getModelosActivosOrderByFecDesde(ISesion aSesion) throws BaseException {
		return DBModeloEvalCab.getModelosActivosOrderByFecDesde(aSesion);
	}

	public List getCompetencias() throws BaseException {
		return Competencia.getCompetencias(this, this.getSesion());
	}

	public List getEvaluacionesByModelo(ISesion aSesion) throws BaseException {

		return EvaluacionLegajoCab.getEvaluacionesByModelo(this, aSesion);
	}

	public static final HashTableDatos getTipoMoedelosEval() throws BaseException {
		HashTableDatos valores = new HashTableDatos();
		valores.put(TIPO_DESEN, "Desempeño");
		valores.put(TIPO_POTEN, "Potencial");
		return valores;
	}
	
	public static List getModelosVigentesDesempenio(ISesion aSesion) throws BaseException {
		return DBModeloEvalCab.getModelosVigentesDesempenio(aSesion);
	}	
	
	public static List getModelosVigentesPotencial(ISesion aSesion) throws BaseException {
		return DBModeloEvalCab.getModelosVigentesPotencial(aSesion);
	}
	
	public static List getModelosActivosOrderByFecDesdeTipo(String tipo,ISesion aSesion) throws BaseException {
		return DBModeloEvalCab.getModelosActivosOrderByFecDesdeTipo(tipo,aSesion);
	}	

}
