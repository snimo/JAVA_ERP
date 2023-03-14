package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.pagos.da.DBRendicionFFUniOrg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RendicionFFUniOrg extends ObjetoLogico {

	private List		ctasRendFondoFijo			= new ArrayList();

	private boolean	readCtasRendFondoFijo	= true;

	public RendicionFFUniOrg() {
	}

	public static String				NICKNAME	= "pag.RendicionFFUniOrg";

	private UnidadOrganizativa	unidad_organizativa;

	private Boolean							activo;

	public UnidadOrganizativa getUnidad_organizativa() throws BaseException {
		supportRefresh();
		return unidad_organizativa;
	}

	public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) {
		this.unidad_organizativa = aUnidad_organizativa;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
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

	public static RendicionFFUniOrg findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFFUniOrg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RendicionFFUniOrg findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFFUniOrg) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RendicionFFUniOrg findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RendicionFFUniOrg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(unidad_organizativa, "Debe ingresar la Unidad Organizativa");
	}

	public List getCtasRendFondoFijo() throws BaseException {
		if (this.readCtasRendFondoFijo) {
			List listaCtasRendFondoFijo = RendicionFFUniOrgCta.getRendicionFFUniOrgCta(this, getSesion());
			this.ctasRendFondoFijo.addAll(listaCtasRendFondoFijo);
			this.readCtasRendFondoFijo = false;
		}
		return this.ctasRendFondoFijo;
	}

	public void addCtaRendFondoFijo(RendicionFFUniOrgCta rendFondoFijoUniOrgCta) throws BaseException {
		rendFondoFijoUniOrgCta.setUnidad_organizativa_ff(this);
		this.ctasRendFondoFijo.add(rendFondoFijoUniOrgCta);
	}

	public void afterSave() throws BaseException {
		Iterator iterCtasRendFF = this.ctasRendFondoFijo.iterator();
		while (iterCtasRendFF.hasNext()) {
			RendicionFFUniOrgCta rendFFUniOrgCta = (RendicionFFUniOrgCta) iterCtasRendFF.next();
			rendFFUniOrgCta.save();
			rendFFUniOrgCta = null;
		}
		iterCtasRendFF = null;
	}

	public static List getAllUniOrgRendFF(ISesion aSesion) throws BaseException {
		return DBRendicionFFUniOrg.getAllUniOrgRendFF(aSesion);
	}

}
