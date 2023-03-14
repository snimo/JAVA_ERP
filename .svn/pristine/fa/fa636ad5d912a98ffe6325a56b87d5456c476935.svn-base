package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.pagos.da.DBConceptoOPVariasHab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConceptoOPVariasHab extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ConceptoOPVariasHab() {
	}

	public static String				NICKNAME	= "pag.ConceptoOPVariasHab";

	private ConceptoOPVarias		concepto_pv;

	private UnidadOrganizativa	unidad_organizativa;

	private Boolean							activo;

	public ConceptoOPVarias getConcepto_pv() throws BaseException {
		supportRefresh();
		return concepto_pv;
	}

	public void setConcepto_pv(ConceptoOPVarias aConcepto_pv) {
		this.concepto_pv = aConcepto_pv;
	}

	public UnidadOrganizativa getUnidad_organizativa() throws BaseException {
		supportRefresh();
		return unidad_organizativa;
	}

	public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) {
		this.unidad_organizativa = aUnidad_organizativa;
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

	public static ConceptoOPVariasHab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConceptoOPVariasHab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConceptoOPVariasHab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConceptoOPVariasHab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(concepto_pv, "Debe ingresar el Concepto");
		Validar.noNulo(unidad_organizativa, "Debe ingresar la Unidad Organizativa");
	}
	
	public static List getUnidadesOrganizativas(ConceptoOPVarias concepto, ISesion aSesion) throws BaseException {
		return DBConceptoOPVariasHab.getUnidadesOrganizativas(concepto,aSesion);
	}
 	

}
