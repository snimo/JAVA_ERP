package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBSancionRankear;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class SancionRankear extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public SancionRankear() {
	}

	public static String NICKNAME = "rh.SancionRankear";

	private SancionesRRHH motivo_sancion;
	private Boolean activo;
	private Boolean aplicar;
	private String suma_o_resta;
	private Money calif_en_puntos;
	private RankearCab oid_rankear;
	private Integer analizar_ult_meses;
	private Money ponderacion;

	public SancionesRRHH getMotivo_sancion() throws BaseException {
		supportRefresh();
		return motivo_sancion;
	}

	public void setMotivo_sancion(SancionesRRHH aMotivo_sancion) {
		this.motivo_sancion = aMotivo_sancion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Boolean isAplicar() throws BaseException {
		supportRefresh();
		return aplicar;
	}

	public void setAplicar(Boolean aAplicar) {
		this.aplicar = aAplicar;
	}

	public String getSuma_o_resta() throws BaseException {
		supportRefresh();
		return suma_o_resta;
	}

	public void setSuma_o_resta(String aSuma_o_resta) {
		this.suma_o_resta = aSuma_o_resta;
	}

	public Money getCalif_en_puntos() throws BaseException {
		supportRefresh();
		return calif_en_puntos;
	}

	public void setCalif_en_puntos(Money aCalif_en_puntos) {
		this.calif_en_puntos = aCalif_en_puntos;
	}

	public RankearCab getOid_rankear() throws BaseException {
		supportRefresh();
		return oid_rankear;
	}

	public void setOid_rankear(RankearCab aOid_rankear) {
		this.oid_rankear = aOid_rankear;
	}

	public Integer getAnalizar_ult_meses() throws BaseException {
		supportRefresh();
		return analizar_ult_meses;
	}

	public void setAnalizar_ult_meses(Integer aAnalizar_ult_meses) {
		this.analizar_ult_meses = aAnalizar_ult_meses;
	}

	public Money getPonderacion() throws BaseException {
		supportRefresh();
		if (ponderacion==null)
			return new Money(0);
		else
			return ponderacion;
	}

	public void setPonderacion(Money aPonderacion) {
		this.ponderacion = aPonderacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static SancionRankear findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SancionRankear) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SancionRankear findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SancionRankear) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static SancionRankear getSancionRankear(RankearCab rankear, SancionesRRHH sancion, ISesion aSesion) throws BaseException {
		return DBSancionRankear.getSancionRankear(rankear, sancion, aSesion);
	}

	public static List getSancionesRankear(RankearCab rankear, ISesion aSesion) throws BaseException {
		return DBSancionRankear.getSancionesRankear(rankear, aSesion);
	}

}
