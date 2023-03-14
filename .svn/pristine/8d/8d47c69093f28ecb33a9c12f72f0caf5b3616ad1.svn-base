package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBPlanoCIP;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PlanoCIP extends ObjetoLogico {

	public PlanoCIP() {
	}

	public static String NICKNAME = "cip.PlanoCIP";

	private String codigo;
	private String descripcion;
	private AgrupadorPlano grupo_plano;
	private Integer orden;
	private Boolean activo;

	private List puertasPlano = new ArrayList();
	private boolean readPuertasPlano = true;

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

	public AgrupadorPlano getGrupo_plano() throws BaseException {
		supportRefresh();
		return grupo_plano;
	}

	public void setGrupo_plano(AgrupadorPlano aGrupo_plano) {
		this.grupo_plano = aGrupo_plano;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
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

	public static PlanoCIP findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (PlanoCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PlanoCIP findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (PlanoCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static PlanoCIP findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (PlanoCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(grupo_plano, "Debe ingresar el Agrupador");
	}

	public List getPuertasPlano() throws BaseException {
		if (this.readPuertasPlano) {
			List listaPuertasPlano = PuertaPlanoCIP.getPuertasPlano(this,
					getSesion());
			puertasPlano.addAll(listaPuertasPlano);
			this.readPuertasPlano = false;
		}
		return puertasPlano;
	}

	public void addPuertaPlano(PuertaPlanoCIP aPuertaPlano)
			throws BaseException {
		aPuertaPlano.setPlano(this);
		puertasPlano.add(aPuertaPlano);
	}

	public void afterSave() throws BaseException {
		Iterator iterPuertasPlano = puertasPlano.iterator();
		while (iterPuertasPlano.hasNext()) {
			PuertaPlanoCIP puertaPlano = (PuertaPlanoCIP) iterPuertasPlano
					.next();
			puertaPlano.save();
			puertaPlano = null;
		}
		iterPuertasPlano = null;
	}

	public static List getAllPlanos(ISesion aSesion) throws BaseException {
		return DBPlanoCIP.getAllPlanos(aSesion);
	}

}
