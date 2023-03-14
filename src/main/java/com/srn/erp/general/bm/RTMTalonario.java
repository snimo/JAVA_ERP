package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBRTMTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RTMTalonario extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RTMTalonario() {
	}

	public static String	NICKNAME	= "ge.RTMTalonario";

	private Talonario			talonario;

	private String				condicion;

	private String				archivo_rtm;

	private Boolean				activo;

	public Talonario getTalonario() throws BaseException {
		supportRefresh();
		return talonario;
	}

	public void setTalonario(Talonario aTalonario) {
		this.talonario = aTalonario;
	}

	public String getCondicion() throws BaseException {
		supportRefresh();
		return condicion;
	}

	public void setCondicion(String aCondicion) {
		this.condicion = aCondicion;
	}

	public String getArchivo_rtm() throws BaseException {
		supportRefresh();
		return archivo_rtm;
	}

	public void setArchivo_rtm(String aArchivo_rtm) {
		this.archivo_rtm = aArchivo_rtm;
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

	public static RTMTalonario findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RTMTalonario) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RTMTalonario findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RTMTalonario) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(talonario, "Debe ingresar un Talonario");
		Validar.noNulo(condicion, "Debe ingresar la condición");
		Validar.noNulo(archivo_rtm, "Debe seleccionar un archivo RTM");
	}

	public static List getRTMTalonarios(Talonario talonario, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Talonario.NICKNAME, talonario);
		return (List) ObjetoLogico.getObjects(RTMTalonario.NICKNAME, DBRTMTalonario.SELECT_BY_TALONARIO, condiciones,
				new ListObserver(), aSesion);
	}

}
