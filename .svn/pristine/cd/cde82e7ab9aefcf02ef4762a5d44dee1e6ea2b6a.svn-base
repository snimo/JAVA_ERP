package com.srn.erp.mensajero.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Imagen extends ObjetoLogico {

	public Imagen() {
	}

	public static String NICKNAME = "ge.Imagen";

	private String codigo;
	private String descripcion;
	private Boolean activo;

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

	public static Imagen findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Imagen) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Imagen findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Imagen) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public static String getPathArchivos(ISesion aSesion) throws BaseException {
		ValorParametro valorPathImagenesProd = ValorParametro.findByCodigoParametro("PATH_IMAGENES_GRAL", aSesion);
		return valorPathImagenesProd.getValorCadena();				
	}	

}
