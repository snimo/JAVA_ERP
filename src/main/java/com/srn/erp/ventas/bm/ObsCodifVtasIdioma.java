package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.Idioma;
import com.srn.erp.ventas.da.DBObsCodifVtasIdioma;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ObsCodifVtasIdioma extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ObsCodifVtasIdioma() {
	}

	public static String NICKNAME = "ve.ObsCodifVtasIdioma";

	private ObsCodifVtas codigo_observacion;
	private String descripcion;
	private Idioma idioma;
	private Boolean activo;

	public ObsCodifVtas getCodigo_observacion() throws BaseException {
		supportRefresh();
		return codigo_observacion;
	}

	public void setCodigo_observacion(ObsCodifVtas aCodigo_observacion) {
		this.codigo_observacion = aCodigo_observacion;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Idioma getIdioma() throws BaseException {
		supportRefresh();
		return idioma;
	}

	public void setIdioma(Idioma aIdioma) {
		this.idioma = aIdioma;
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

	public static ObsCodifVtasIdioma findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsCodifVtasIdioma) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ObsCodifVtasIdioma findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsCodifVtasIdioma) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ObsCodifVtasIdioma findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ObsCodifVtasIdioma) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo_observacion, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(idioma, "Debe ingresar el Idioma");
	}

	public static List getObsCodIdioma(ObsCodifVtas obsCodifVtas, ISesion aSesion) throws BaseException {
		return DBObsCodifVtasIdioma.getObsCodIdioma(obsCodifVtas, aSesion);
	}

	public static ObsCodifVtasIdioma getObsCodifVtasIdioma(ObsCodifVtas obsCodif, Idioma idioma, ISesion aSesion) throws BaseException {
		return DBObsCodifVtasIdioma.getObsCodifVtasIdioma(obsCodif, idioma, aSesion);
	}

}
