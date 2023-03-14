package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBGrupoPuertaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class GrupoPuertaDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GrupoPuertaDet() {
	}

	public static String NICKNAME = "cip.GrupoPuertaDet";

	private GrupoPuerta grupo_puertas;
	private Puerta puerta;
	private Boolean activo;

	public GrupoPuerta getGrupo_puertas() throws BaseException {
		supportRefresh();
		return grupo_puertas;
	}

	public void setGrupo_puertas(GrupoPuerta aGrupo_puertas) {
		this.grupo_puertas = aGrupo_puertas;
	}

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
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

	public static GrupoPuertaDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoPuertaDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoPuertaDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoPuertaDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_puertas, "Debe ingresar el Grupo de Puertas");
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
	}

	public static List getGrupoPuertasDet(GrupoPuerta grupoPuerta, ISesion aSesion) throws BaseException {
		return DBGrupoPuertaDet.getGrupoPuertasDet(grupoPuerta, aSesion);
	}

	public static GrupoPuertaDet getGrupoPuertaDet(GrupoPuerta grupoPuerta, Puerta puerta, ISesion aSesion) throws BaseException {
		return DBGrupoPuertaDet.getGrupoPuertaDet(grupoPuerta, puerta, aSesion);
	}

}
