package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBGrupoDeAtributos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoDeAtributos extends ObjetoLogico {

	public GrupoDeAtributos() {
	}

	public static String	NICKNAME							= "cg.GrupoDeAtributos";

	private String				codigo;

	private String				descripcion;

	private Boolean				activo;

	private List					atributosEnGrupo			= new ArrayList();

	private boolean				readAtributosEnGrupo	= true;

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

	public static GrupoDeAtributos findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoDeAtributos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoDeAtributos findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoDeAtributos) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoDeAtributos findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoDeAtributos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getAtributosEnGrupo() throws BaseException {
		if (this.readAtributosEnGrupo) {
			List listaAtributosEnGrupo = AtributoEnGrupo.getAtributosEnGrupo(this, getSesion());
			atributosEnGrupo.addAll(listaAtributosEnGrupo);
			readAtributosEnGrupo = false;
		}
		return atributosEnGrupo;
	}

	public void addAributoEnGrupo(AtributoEnGrupo aAtributoEnGrupo) throws BaseException {
		aAtributoEnGrupo.setGrupoatri(this);
		atributosEnGrupo.add(aAtributoEnGrupo);
	}

	public void afterSave() throws BaseException {
		Iterator iterAtributosEnGrupo = atributosEnGrupo.iterator();
		while (iterAtributosEnGrupo.hasNext()) {
			AtributoEnGrupo atributoEnGupo = (AtributoEnGrupo) iterAtributosEnGrupo.next();
			atributoEnGupo.save();
			atributoEnGupo = null;
		}
		iterAtributosEnGrupo = null;
	}

	public static GrupoDeAtributos getGrupoDeAtributos(String codigo, GrupoAtributoEntidadVar grupoAtriEntVar,
			ISesion aSesion) throws BaseException {
		return DBGrupoDeAtributos.getGrupoDeAtributos(codigo, grupoAtriEntVar, aSesion);
	}

}
