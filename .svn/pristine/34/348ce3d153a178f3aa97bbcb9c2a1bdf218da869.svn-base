package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPuertaPlanoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class PuertaPlanoCIP extends ObjetoLogico {

	public PuertaPlanoCIP() {
	}

	public static String NICKNAME = "cip.PuertaPlanoCIP";

	private Integer orden;
	private PlanoCIP plano;
	private Puerta puerta;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private Boolean hab_entrada;
	private Boolean hab_salida;
	private Boolean activo;

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public PlanoCIP getPlano() throws BaseException {
		supportRefresh();
		return plano;
	}

	public void setPlano(PlanoCIP aPlano) {
		this.plano = aPlano;
	}

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public Boolean isHab_entrada() throws BaseException {
		supportRefresh();
		return hab_entrada;
	}

	public void setHab_entrada(Boolean aHab_entrada) {
		this.hab_entrada = aHab_entrada;
	}

	public Boolean isHab_salida() throws BaseException {
		supportRefresh();
		return hab_salida;
	}

	public void setHab_salida(Boolean aHab_salida) {
		this.hab_salida = aHab_salida;
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

	public static PuertaPlanoCIP findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (PuertaPlanoCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PuertaPlanoCIP findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (PuertaPlanoCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(plano, "Debe ingresar el Plano");
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
	}

	public static List getPuertasPlano(PlanoCIP planoCIP, ISesion aSesion)
			throws BaseException {
		return DBPuertaPlanoCIP.getPuertasPlano(planoCIP, aSesion);
	}

	public static PuertaPlanoCIP getPuertaPlanoCIP(Puerta puerta,
			PlanoCIP plano, ISesion aSesion) throws BaseException {
		return DBPuertaPlanoCIP.getPuertaPlanoCIP(puerta, plano, aSesion);
	}

}
