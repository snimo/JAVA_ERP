package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoNovedad extends ObjetoLogico {

	public TipoNovedad() {
	}

	public static String NICKNAME = "rh.TipoNovedad";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	private List motivos = new ArrayList();
	private boolean readMotivos = true;

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

	public static TipoNovedad findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoNovedad) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoNovedad findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoNovedad) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TipoNovedad findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoNovedad) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getMotivos() throws BaseException {
		if (this.readMotivos) {
			List listaMotivos = MotivoTipoNov.getMotivosTipoMov(this, getSesion());
			this.motivos.addAll(listaMotivos);
			this.readMotivos = false;
		}
		return this.motivos;
	}

	public void addMotivo(MotivoTipoNov aMotivoTipoNov) throws BaseException {
		aMotivoTipoNov.setTipo_novedad(this);
		this.motivos.add(aMotivoTipoNov);
	}

	public void afterSave() throws BaseException {

		Iterator iterMotivos = this.motivos.iterator();
		while (iterMotivos.hasNext()) {
			MotivoTipoNov motivo = (MotivoTipoNov) iterMotivos.next();
			motivo.save();
			motivo = null;
		}
		iterMotivos = null;
	}

}
