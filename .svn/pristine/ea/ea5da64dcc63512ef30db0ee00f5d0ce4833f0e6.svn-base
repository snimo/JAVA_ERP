package com.srn.erp.Ausentismo.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class GrupoRRHHGeneral extends ObjetoLogico {

	public GrupoRRHHGeneral() {
	}

	public static String NICKNAME = "admRRHH.GrupoRRHHGeneral";

	private String tipo;
	private String nombre;
	private Boolean activo;

	private List<GrupoRRHHGeneralDesc> gruposGeneralDesc = new ArrayList<GrupoRRHHGeneralDesc>();
	private boolean readDescripciones = true;

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
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

	public static GrupoRRHHGeneral findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoRRHHGeneral) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoRRHHGeneral findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoRRHHGeneral) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GrupoRRHHGeneralDesc> getGruposGeneralDesc() throws BaseException {
		if (this.readDescripciones) {
			List<GrupoRRHHGeneralDesc> listaDescripciones = GrupoRRHHGeneralDesc.findByOidGrupoGral(this, getSesion());
			gruposGeneralDesc.addAll(listaDescripciones);
			this.readDescripciones = false;
		}
		return gruposGeneralDesc;
	}

	public void setGruposGeneralDesc(List<GrupoRRHHGeneralDesc> descripciones) {
		this.gruposGeneralDesc = descripciones;
	}

	public void addGruposGeneralDesc(GrupoRRHHGeneralDesc descripcion) throws BaseException {
		this.getGruposGeneralDesc().add(descripcion);
	}

	public void afterSave() throws BaseException {

		Iterator<GrupoRRHHGeneralDesc> itDescripciones = this.gruposGeneralDesc.iterator();
		while (itDescripciones.hasNext()) {
			GrupoRRHHGeneralDesc descripcion = itDescripciones.next();
			descripcion.save();
			descripcion = null;
		}
		itDescripciones = null;

	}

}
