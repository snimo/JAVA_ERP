package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBCondModEvalCab;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CondModEvalCab extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List competenciasCond = new ArrayList();
	private boolean readCompetenciasCond = true;
	
	private List valoresClasif = new ArrayList();
	private boolean readValoresClasif = true;

	private List legajos = new ArrayList();
	private boolean readLegajos = true;
	
	private List firmas = new ArrayList();
	private boolean readFirmas = true;

	private List rangoPuntos = new ArrayList();
	private boolean readRangoPuntos = true;
	
	
	public CondModEvalCab() {
	}

	public static String NICKNAME = "rh.CondModEvalCab";

	private ModeloEvalCab modelo_eval_cab;
	private Integer orden;
	private String condicion;
	private Boolean activo;

	public ModeloEvalCab getModelo_eval_cab() throws BaseException {
		supportRefresh();
		return modelo_eval_cab;
	}

	public void setModelo_eval_cab(ModeloEvalCab aModelo_eval_cab) {
		this.modelo_eval_cab = aModelo_eval_cab;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getCondicion() throws BaseException {
		supportRefresh();
		return condicion;
	}

	public void setCondicion(String aCondicion) {
		this.condicion = aCondicion;
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

	public static CondModEvalCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CondModEvalCab) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static CondModEvalCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CondModEvalCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static CondModEvalCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CondModEvalCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(modelo_eval_cab, "Debe ingresar el Modelo de Evaluación");
		Validar.noNulo(orden, "Debe ingresar la Orden");
	}
	
	public static List getCondiciones(ModeloEvalCab modelo,ISesion aSesion) throws BaseException {
		return DBCondModEvalCab.getCondiciones(modelo,aSesion);
	}

	public List getCompetenciasCondicion() throws BaseException {
		if (this.readCompetenciasCond) {
		      List listaCompetenciasCond = ModeloEvalCompe.getModeloEvalCompeByCondicion(this,getSesion());
		      competenciasCond.addAll(listaCompetenciasCond);
		      this.readCompetenciasCond = false;
		}
		return competenciasCond;
	}
	
	public List getFirmas() throws BaseException {
		if (this.readFirmas) {
		      List listaFirmas = FirmaModeloEvaluacion.getFirmasModeloEval(this,getSesion());
		      firmas.addAll(listaFirmas);
		      this.readFirmas = false;
		}
		return firmas;
	}
	
	public List getRangoPuntos() throws BaseException {
		if (this.readRangoPuntos) {
		      List listaRangoPuntos = RangoPtajeObsCodif.getRangosPtajesObsCodig(this,getSesion());
		      rangoPuntos.addAll(listaRangoPuntos);
		      this.readRangoPuntos = false;
		}
		return rangoPuntos;
	}
	
	public List getValoresClasif() throws BaseException {
		if (this.readValoresClasif) {
		      List listaCompetenciasCond = ValClasifCondModEval.getValoresClasifByCondicion(this,getSesion());
		      valoresClasif.addAll(listaCompetenciasCond);
		      this.readValoresClasif = false;
		}
		return valoresClasif;
	}
	
	public List getLegajos() throws BaseException {
		if (this.readLegajos) {
		      List listaLegajos = LegjoCondModEval.getLegCondModEval(this,getSesion());
		      legajos.addAll(listaLegajos);
		      this.readLegajos = false;
		}
		return legajos;
	}
	
	public void addCondModEvalCab(ModeloEvalCompe aModeloEvalCompe) throws BaseException {
		aModeloEvalCompe.setCondicion_modelo(this);
		competenciasCond.add(aModeloEvalCompe);
	}
	
	public void addFirma(FirmaModeloEvaluacion aFirmaModeloEvaluacion) throws BaseException {
		aFirmaModeloEvaluacion.setCondicion_modelo(this);
		firmas.add(aFirmaModeloEvaluacion);
	}
	
	
	public void addValorClasificador(ValClasifCondModEval aValClasifCondModEval) throws BaseException {
		aValClasifCondModEval.setCondicion_modelo(this);
		valoresClasif.add(aValClasifCondModEval);
	}
	
	public void addLegajo(LegjoCondModEval aLegjoCondModEval) throws BaseException {
		aLegjoCondModEval.setCondicion_modelo(this);
		legajos.add(aLegjoCondModEval);
	}
	
	public void addRangoPunto(RangoPtajeObsCodif aRangoPtajeObsCodif) throws BaseException {
		aRangoPtajeObsCodif.setCond_modelo(this);
		rangoPuntos.add(aRangoPtajeObsCodif);
	}
	

	public void afterSave() throws BaseException {
		Iterator iterCompetencias = competenciasCond.iterator();
		while (iterCompetencias.hasNext()) {
		      ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) iterCompetencias.next();
		      modeloEvalCompe.save();
		      modeloEvalCompe = null;
		}
		iterCompetencias = null;
		
		Iterator iterValorClasif = valoresClasif.iterator();
		while (iterValorClasif.hasNext()) {
		      ValClasifCondModEval valClasifCondModEval = (ValClasifCondModEval) iterValorClasif.next();
		      valClasifCondModEval.save();
		      valClasifCondModEval = null;
		}
		iterValorClasif = null;
		
		Iterator iterLegajos = legajos.iterator();
		while (iterLegajos.hasNext()) {
		      LegjoCondModEval legjoCondModEval = (LegjoCondModEval) iterLegajos.next();
		      legjoCondModEval.save();
		      legjoCondModEval = null;
		}
		iterLegajos = null;
		
		Iterator iterFirmas = firmas.iterator();
		while (iterFirmas.hasNext()) {
		      FirmaModeloEvaluacion firmaModeloEvaluacion = (FirmaModeloEvaluacion) iterFirmas.next();
		      firmaModeloEvaluacion.save();
		      firmaModeloEvaluacion = null;
		}
		iterFirmas = null;
		
		Iterator iterRangosPuntos = rangoPuntos.iterator();
		while (iterRangosPuntos.hasNext()) {
		      RangoPtajeObsCodif rangoPtajeObsCodif = (RangoPtajeObsCodif) iterRangosPuntos.next();
		      rangoPtajeObsCodif.save();
		      rangoPtajeObsCodif = null;
		}
		iterRangosPuntos = null;
	
	}
	
	public boolean isLegajoCumpleCond(Legajo aLegajo) throws BaseException {
		
		LegjoCondModEval legjoCondModEval = LegjoCondModEval.getLegajoCondModEval(this, aLegajo, this.getSesion());
		if (legjoCondModEval!=null) 
			return true;
		
		// Obtener los Clasificadores a configurar Definicion
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector  = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto  = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ClasificadorEntidad clasifEstado  = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		
		ValorClasificadorEntidad valorClasifEmp = aLegajo.getValorClasifEnt(clasifEmpresa);
		ValorClasificadorEntidad valorClasifSec = aLegajo.getValorClasifEnt(clasifSector);
		ValorClasificadorEntidad valorClasifPue = aLegajo.getValorClasifEnt(clasifPuesto);
		ValorClasificadorEntidad valorClasifEst = aLegajo.getValorClasifEnt(clasifEstado);
		
		boolean cumplioCondEmp = false;
		boolean cumplioCondSec = false;
		boolean cumplioCondPue = false;
		boolean cumplioCondEst = false;

		// Verificar la condicion de la empresa
		HashTableDatos condCantValEmp = new HashTableDatos();
		condCantValEmp.put(CondModEvalCab.NICKNAME, this);
		condCantValEmp.put(ClasificadorEntidad.NICKNAME, clasifEmpresa);
		int cantValEmp = ValClasifCondModEval.getCantValoresClasif(condCantValEmp, this.getSesion());
		if (cantValEmp == 0)
			cumplioCondEmp = true;
		else {
			ValClasifCondModEval encontrolValClasifEmp = 
				ValClasifCondModEval.getValorClasificador(this, clasifEmpresa, valorClasifEmp, this.getSesion());
			if (encontrolValClasifEmp!=null)
				cumplioCondEmp = true;
		}
		
		// Verificar la condicion del Sector
		HashTableDatos condCantValSec = new HashTableDatos();
		condCantValSec.put(CondModEvalCab.NICKNAME, this);
		condCantValSec.put(ClasificadorEntidad.NICKNAME, clasifSector);
		int cantValSec = ValClasifCondModEval.getCantValoresClasif(condCantValSec, this.getSesion());
		if (cantValSec == 0)
			cumplioCondSec = true;
		else {
			ValClasifCondModEval encontrolValClasifSec = 
				ValClasifCondModEval.getValorClasificador(this, clasifSector, valorClasifSec, this.getSesion());
			if (encontrolValClasifSec!=null)
				cumplioCondSec = true;
		}
		
		// Verificar la condicion del Puesto
		HashTableDatos condCantValPue = new HashTableDatos();
		condCantValPue.put(CondModEvalCab.NICKNAME, this);
		condCantValPue.put(ClasificadorEntidad.NICKNAME, clasifPuesto);
		int cantValPue = ValClasifCondModEval.getCantValoresClasif(condCantValPue, this.getSesion());
		if (cantValPue == 0)
			cumplioCondPue = true;
		else {
			ValClasifCondModEval encontrolValClasifPue = 
				ValClasifCondModEval.getValorClasificador(this, clasifPuesto, valorClasifPue, this.getSesion());
			if (encontrolValClasifPue!=null)
				cumplioCondPue = true;
		}
		
		// Verificar la condicion del Estado
		HashTableDatos condCantValEst = new HashTableDatos();
		condCantValEst.put(CondModEvalCab.NICKNAME, this);
		condCantValEst.put(ClasificadorEntidad.NICKNAME, clasifEstado);
		int cantValEst = ValClasifCondModEval.getCantValoresClasif(condCantValEst, this.getSesion());
		if (cantValEst == 0)
			cumplioCondEst = true;
		else {
			ValClasifCondModEval encontrolValClasifEst = 
				ValClasifCondModEval.getValorClasificador(this, clasifEstado, valorClasifEst, this.getSesion());
			if (encontrolValClasifEst!=null)
				cumplioCondEst = true;
		}
		
		if ((cumplioCondEmp) && (cumplioCondEst) && (cumplioCondPue) && (cumplioCondSec))
			return true;
		else
			return false;
	}
	
	private int getCantValoresPorClasif(ClasificadorEntidad clasifEnt) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CondModEvalCab.NICKNAME, this);
		condiciones.put(ClasificadorEntidad.NICKNAME, clasifEnt);
		return ValClasifCondModEval.getCantValoresClasif(condiciones, this.getSesion());
	}
	
	private boolean existeValorClasif(ValorClasificadorEntidad aValorClasificadorEntidad) throws BaseException {
		ValClasifCondModEval valClasifCondModEval = 
			ValClasifCondModEval.getValorClasificador(
					this, aValorClasificadorEntidad.getClasificador_entidad() , 
					aValorClasificadorEntidad , 
					this.getSesion());
		if (valClasifCondModEval!=null)
			return true;
		else
			return false;
	}
	
	public ModeloEvalGrados getModeloEvalGrados(Competencia competencia,Integer nroGrado) throws BaseException {
		return ModeloEvalGrados.getModeloEvalGrados(this, competencia, nroGrado, this.getSesion());
	}

}
