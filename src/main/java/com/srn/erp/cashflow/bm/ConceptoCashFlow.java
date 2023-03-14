package com.srn.erp.cashflow.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConceptoCashFlow extends ObjetoLogico {

	public ConceptoCashFlow() {
	}

	public static String NICKNAME = "cf.ConceptoCashFlow";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private GrupoConceptoCF grupo_concepto;

	private List confProgConc = new ArrayList();
	private boolean readConfProgConc = true;

	private List escenariosHab = new ArrayList();
	private boolean readEscenariosHab = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public GrupoConceptoCF getGrupo_concepto() throws BaseException {
		supportRefresh();
		return grupo_concepto;
	}

	public void setGrupo_concepto(GrupoConceptoCF aGrupo_concepto) {
		this.grupo_concepto = aGrupo_concepto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConceptoCashFlow findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConceptoCashFlow) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConceptoCashFlow findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ConceptoCashFlow) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConceptoCashFlow findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConceptoCashFlow) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(grupo_concepto, "Debe ingresar el Grupo");
	}

	public List getConfProgConc() throws BaseException {
		if (this.readConfProgConc) {
			List listaConfProgConc = ConfProgConcCF.getConfProgConcCF(this, getSesion());
			this.confProgConc.addAll(listaConfProgConc);
			readConfProgConc = false;
		}
		return this.confProgConc;
	}
	

	public void addConfProgConc(ConfProgConcCF aConfProgConcCF) throws BaseException {
		aConfProgConcCF.setConcepto(this);
		this.confProgConc.add(aConfProgConcCF);
	}
	
	public void addEscenarioHabilitado(EsceConceptoCFHab aEscenarioConcCF) throws BaseException {
		aEscenarioConcCF.setConcepto_cf(this);
		this.escenariosHab.add(aEscenarioConcCF);
	}
	

	public void afterSave() throws BaseException {
		Iterator iterConfProgConc = this.confProgConc.iterator();
		while (iterConfProgConc.hasNext()) {
			ConfProgConcCF confProgConc = (ConfProgConcCF) iterConfProgConc.next();
			confProgConc.save();
			confProgConc = null;
		}
		iterConfProgConc = null;
		
		Iterator iterEsceHab = this.escenariosHab.iterator();
		while (iterEsceHab.hasNext()) {
			EsceConceptoCFHab esceHab = (EsceConceptoCFHab) iterEsceHab.next();
			esceHab.save();
			esceHab = null;
		}
		iterEsceHab = null;
		
		
	}

}
