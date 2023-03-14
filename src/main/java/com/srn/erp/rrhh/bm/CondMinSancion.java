package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBCondMinSancion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class CondMinSancion extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CondMinSancion() {
	}

	public static String NICKNAME = "rh.CondMinSancion";

	private Integer nro_novedad;
	private RankearCab rankear;
	private SancionesRRHH oid_mot_sancion;
	private Boolean activo;

	public Integer getNro_novedad() throws BaseException {
		supportRefresh();
		return nro_novedad;
	}

	public void setNro_novedad(Integer aNro_novedad) {
		this.nro_novedad = aNro_novedad;
	}

	public RankearCab getRankear() throws BaseException {
		supportRefresh();
		return rankear;
	}

	public void setRankear(RankearCab aRankear) {
		this.rankear = aRankear;
	}

	public SancionesRRHH getOid_mot_sancion() throws BaseException {
		supportRefresh();
		return oid_mot_sancion;
	}

	public void setOid_mot_sancion(SancionesRRHH aOid_mot_sancion) {
		this.oid_mot_sancion = aOid_mot_sancion;
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

	public static CondMinSancion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CondMinSancion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CondMinSancion findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CondMinSancion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nro_novedad, "Debe ingresar el Nro. de Novedad");
		Validar.noNulo(rankear, "Debe ingresar el Rankeador");
		Validar.noNulo(oid_mot_sancion, "Debe ingresar el Motivo");
	}
	
	public static List getCondMinSanciones(
			  RankearCab rankear,
	          ISesion aSesion) throws BaseException {
		  return DBCondMinSancion.getCondMinSanciones(rankear,aSesion);
	}
	
	public static CondMinSancion getCondMinSancion(
			  Integer nroNovedad, 
			  RankearCab rankear,
			  SancionesRRHH sancion,
	          ISesion aSesion)
	          throws BaseException {
		  return DBCondMinSancion.getCondMinSancion(nroNovedad,rankear,sancion,aSesion);
	}
	

}
