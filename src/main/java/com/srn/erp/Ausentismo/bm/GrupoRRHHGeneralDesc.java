package com.srn.erp.Ausentismo.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.Ausentismo.da.DBGrupoRRHHGeneralDesc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class GrupoRRHHGeneralDesc extends ObjetoLogico {

	public GrupoRRHHGeneralDesc() {
	}

	public static String NICKNAME = "admRRHH.GrupoRRHHGeneralDesc";

	private GrupoRRHHGeneral grupoGral;
	private String descripcion;
	private Boolean activo;

	private List<GrupoRRHHGeneralCodigo> gruposGeneralCodigo = new ArrayList<GrupoRRHHGeneralCodigo>();
	private boolean readDescripciones = true;

	public GrupoRRHHGeneral getGrupogral() throws BaseException {
		supportRefresh();
		return grupoGral;
	}

	public void setGrupogral(GrupoRRHHGeneral aGrupogral) {
		this.grupoGral = aGrupogral;
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

	public static GrupoRRHHGeneralDesc findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoRRHHGeneralDesc) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoRRHHGeneralDesc findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoRRHHGeneralDesc) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static List<GrupoRRHHGeneralDesc> findByOidGrupoGral(GrupoRRHHGeneral grupo, ISesion aSesion) throws BaseException {
		return (List<GrupoRRHHGeneralDesc>) DBGrupoRRHHGeneralDesc.getSelectByOidGrupoGral(aSesion, grupo);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GrupoRRHHGeneralCodigo> getGruposGeneralCodigo() throws BaseException {
		if (this.readDescripciones) {
			List<GrupoRRHHGeneralCodigo> listaDescripciones = GrupoRRHHGeneralCodigo.findByOidGrupoGral(this, getSesion());
			gruposGeneralCodigo.addAll(listaDescripciones);
			this.readDescripciones = false;
		}
		return gruposGeneralCodigo;
	}

	public void setGruposGeneralCodigo(List<GrupoRRHHGeneralCodigo> descripciones) {
		this.gruposGeneralCodigo = descripciones;
	}

	public void addGruposGeneralCodigo(GrupoRRHHGeneralCodigo descripcion) throws BaseException {
		this.getGruposGeneralCodigo().add(descripcion);
	}

	public void afterSave() throws BaseException {

		Iterator<GrupoRRHHGeneralCodigo> itDescripciones = this.gruposGeneralCodigo.iterator();
		while (itDescripciones.hasNext()) {
			GrupoRRHHGeneralCodigo descripcion = itDescripciones.next();
			descripcion.save();
			descripcion = null;
		}
		itDescripciones = null;

	}

}
