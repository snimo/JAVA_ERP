package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBRankearNovedad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RankearNovedad extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RankearNovedad() {
	}

	public static String NICKNAME = "rh.RankearNovedad";

	private RankearCab rankear;
	private TipoNovedad tipo_novedad;
	private Boolean activo;
	private MotivoTipoNov motivo;
	private Boolean aplicar;
	private String suma_o_resta;
	private Money calif_en_puntos;
	private Integer analizar_ult_meses;
	private Money ponderacion;

	public RankearCab getRankear() throws BaseException {
		supportRefresh();
		return rankear;
	}

	public void setRankear(RankearCab aRankear) {
		this.rankear = aRankear;
	}

	public TipoNovedad getTipo_novedad() throws BaseException {
		supportRefresh();
		return tipo_novedad;
	}

	public void setTipo_novedad(TipoNovedad aTipo_novedad) {
		this.tipo_novedad = aTipo_novedad;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public MotivoTipoNov getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoTipoNov aMotivo) {
		this.motivo = aMotivo;
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

	public Integer getAnalizar_ult_meses() throws BaseException {
		supportRefresh();
		return analizar_ult_meses;
	}

	public void setAnalizar_ult_meses(Integer aAnalizar_ult_meses) {
		this.analizar_ult_meses = aAnalizar_ult_meses;
	}

	public Money getPonderacion() throws BaseException {
		supportRefresh();
		if (ponderacion == null)
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

	public static RankearNovedad findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RankearNovedad) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RankearNovedad findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RankearNovedad) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rankear, "Ingresar el Rankeador");
		Validar.noNulo(tipo_novedad, "Debe Ingresar el Tipo de Novedad");
	}

	public static List getRankearNovedades(RankearCab rankearCab, ISesion aSesion) throws BaseException {
		return DBRankearNovedad.getRankearNovedades(rankearCab, aSesion);
	}

	public static RankearNovedad getRankearNovedad(RankearCab rankearCab, TipoNovedad tipoNovedad, MotivoTipoNov motivo, ISesion aSesion) throws BaseException {
		return DBRankearNovedad.getRankearNovedad(rankearCab, tipoNovedad, motivo, aSesion);
	}

	public static List getRankearNovedadesAplic(RankearCab rankearCab, ISesion aSesion) throws BaseException {
		return DBRankearNovedad.getRankearNovedadesAplic(rankearCab, aSesion);
	}
	
	public static List getRankearNovedadesAplic(RankearCab rankearCab, Legajo legajo,ISesion aSesion) throws BaseException {
		return DBRankearNovedad.getRankearNovedadesAplic(rankearCab,legajo,aSesion); 
	}
	

}
