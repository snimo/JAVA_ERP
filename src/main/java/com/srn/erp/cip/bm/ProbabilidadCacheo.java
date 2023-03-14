package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBProbabilidadCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ProbabilidadCacheo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ProbabilidadCacheo() {
	}

	public static String NICKNAME = "cip.ProbabilidadCacheo";

	private AlgoritmoCacheo algoritmo_cacheo;
	private Rota rota;
	private Double porc_ent;
	private Double prob_cacheo_ent;
	private Double porc_sal;
	private Double prob_cacheo_sal;
	private Boolean activo;

	public AlgoritmoCacheo getAlgoritmo_cacheo() throws BaseException {
		supportRefresh();
		return algoritmo_cacheo;
	}

	public void setAlgoritmo_cacheo(AlgoritmoCacheo aAlgoritmo_cacheo) {
		this.algoritmo_cacheo = aAlgoritmo_cacheo;
	}

	public Rota getRota() throws BaseException {
		supportRefresh();
		return rota;
	}

	public void setRota(Rota aRota) {
		this.rota = aRota;
	}

	public Double getPorc_ent() throws BaseException {
		supportRefresh();
		if (porc_ent == null)
			return 0.0;
		else
			return porc_ent;
	}

	public void setPorc_ent(Double aPorc_ent) {
		this.porc_ent = aPorc_ent;
	}

	public Double getProb_cacheo_ent() throws BaseException {
		supportRefresh();
		if (prob_cacheo_ent==null)
			return 0.0;
		else
			return prob_cacheo_ent;
	}

	public void setProb_cacheo_ent(Double aProb_cacheo_ent) {
		this.prob_cacheo_ent = aProb_cacheo_ent;
	}

	public Double getPorc_sal() throws BaseException {
		supportRefresh();
		if (porc_sal == null)
			return 0.0;
		else
			return porc_sal;
	}

	public void setPorc_sal(Double aPorc_sal) {
		this.porc_sal = aPorc_sal;
	}

	public Double getProb_cacheo_sal() throws BaseException {
		supportRefresh();
		if (prob_cacheo_sal == null)
			return 0.0;
		else
			return prob_cacheo_sal;
	}

	public static List getProbabilidadesCacheos(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return DBProbabilidadCacheo.getProbabilidadesCacheos(algoritmo, aSesion);
	}

	public void setProb_cacheo_sal(Double aProb_cacheo_sal) {
		this.prob_cacheo_sal = aProb_cacheo_sal;
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

	public static ProbabilidadCacheo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ProbabilidadCacheo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ProbabilidadCacheo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ProbabilidadCacheo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(algoritmo_cacheo, "Debe ingresar el Algoritmo Cacheo");
		Validar.noNulo(rota, "Debe ingresar la rota");
	}

	public static ProbabilidadCacheo getProbabilidadCacheo(
			AlgoritmoCacheo algoritmo, 
			Rota rota, 
			ISesion aSesion) throws BaseException {
		return DBProbabilidadCacheo.getProbabilidadCacheo(algoritmo, rota, aSesion);
	}

}
