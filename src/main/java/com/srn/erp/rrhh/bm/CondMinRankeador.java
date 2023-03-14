package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBCondMinRankeador;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondMinRankeador extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CondMinRankeador() {
	}

	public static String NICKNAME = "rh.CondMinRankeador";

	private Integer nro_novedad;
	private RankearCab rankear;
	private TipoNovedad tipo_novedad;
	private MotivoTipoNov motivo;
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

	public TipoNovedad getTipo_novedad() throws BaseException {
		supportRefresh();
		return tipo_novedad;
	}

	public void setTipo_novedad(TipoNovedad aTipo_novedad) {
		this.tipo_novedad = aTipo_novedad;
	}

	public MotivoTipoNov getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoTipoNov aMotivo) {
		this.motivo = aMotivo;
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

	public static CondMinRankeador findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CondMinRankeador) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CondMinRankeador findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CondMinRankeador) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nro_novedad, "Debe ingresar Nro. Novedad");
		Validar.noNulo(rankear, "Debe ingresar el Rankeador");
		Validar.noNulo(tipo_novedad, "Debe ingresar el Tipo de Novedad");
		Validar.noNulo(motivo, "Debe ingresar el Motivo");
	}

	public static List getCondMinRankeador(RankearCab rankear, Integer nroNovedad, ISesion aSesion) throws BaseException {
		return DBCondMinRankeador.getCondMinRankeador(rankear, nroNovedad, aSesion);
	}

	public static CondMinRankeador getCondMinRankeador(Integer nroNovedad, RankearCab rankearCab, TipoNovedad tipoNovedad, MotivoTipoNov motivo, ISesion aSesion) throws BaseException {

		return DBCondMinRankeador.getCondMinRankeador(nroNovedad, rankearCab, tipoNovedad, motivo, aSesion);
	}

}
