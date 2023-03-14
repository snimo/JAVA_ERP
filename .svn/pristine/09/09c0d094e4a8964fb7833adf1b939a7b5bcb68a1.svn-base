package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBAlgoCacheoEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AlgoCacheoEstado extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AlgoCacheoEstado() {
	}

	public static String NICKNAME = "cip.AlgoCacheoEstado";

	private AlgoritmoCacheo algoritmo_cacheo;
	private EstadoCIP estado;
	private Boolean activo;

	public AlgoritmoCacheo getAlgoritmo_cacheo() throws BaseException {
		supportRefresh();
		return algoritmo_cacheo;
	}

	public void setAlgoritmo_cacheo(AlgoritmoCacheo aAlgoritmo_cacheo) {
		this.algoritmo_cacheo = aAlgoritmo_cacheo;
	}

	public EstadoCIP getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoCIP aEstado) {
		this.estado = aEstado;
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

	public static AlgoCacheoEstado findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AlgoCacheoEstado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AlgoCacheoEstado findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AlgoCacheoEstado) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(algoritmo_cacheo, "Debe ingresar el Algoritmo Cacheo");
		Validar.noNulo(estado, "Debe ingresar el Estado");
	}

	public static List getAlgoCacheoEstados(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return DBAlgoCacheoEstado.getAlgoCacheoEstados(algoritmo, aSesion);
	}

}
