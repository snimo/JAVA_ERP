package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBMotivoEntIntermedias;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class MotivoEntIntermedias extends ObjetoLogico {

	public MotivoEntIntermedias() {
	}

	public static String NICKNAME = "cip.MotivoEntIntermedias";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	private List equivalencias = new ArrayList();
	private boolean readEquivalencias = true;

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

	public static MotivoEntIntermedias findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (MotivoEntIntermedias) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivoEntIntermedias findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (MotivoEntIntermedias) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static MotivoEntIntermedias findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (MotivoEntIntermedias) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getEquivalencias() throws BaseException {
		if (this.readEquivalencias) {
			List listaEquivalencias = EquivMotEntIntermedias
					.getEquivMotEntIntermedias(this, getSesion());
			equivalencias.addAll(listaEquivalencias);
			this.readEquivalencias = false;
		}
		return equivalencias;
	}

	public void addEquivalencia(EquivMotEntIntermedias aEquivMotEntIntermedias)
			throws BaseException {
		aEquivMotEntIntermedias.setMotivo(this);
		this.equivalencias.add(aEquivMotEntIntermedias);
	}

	public void afterSave() throws BaseException {
		Iterator iterEquiv = equivalencias.iterator();
		while (iterEquiv.hasNext()) {
			EquivMotEntIntermedias equivMotEntIntermedias = (EquivMotEntIntermedias) iterEquiv
					.next();
			equivMotEntIntermedias.save();
			equivMotEntIntermedias = null;
		}
		iterEquiv = null;
	}

	public static List getMotivoEntIntermedias(ISesion aSesion)
			throws BaseException {
		return DBMotivoEntIntermedias.getMotivoEntIntermedias(aSesion);
	}

	  public static MotivoEntIntermedias getMotivoEntIntermedia(
			  Legajo legajo,
			  MotivoEntIntermedias motivo,
	          ISesion aSesion)
	          throws BaseException {
		  return DBMotivoEntIntermedias.getMotivoEntIntermedia(legajo,motivo,aSesion);
	  }
	
	
}
