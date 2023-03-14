package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CronogramaDesa extends ObjetoLogico {

	public CronogramaDesa() {
	}

	public static String NICKNAME = "rh.CronogramaDesa";

	private String codigo;
	private String descripcion;
	private String observaciones;
	private Boolean activo;
	
	private List acciones = new ArrayList();
	private boolean readAcciones = true;
	
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

	public String getObservaciones() throws BaseException {
		supportRefresh();
		return observaciones;
	}

	public void setObservaciones(String aObservaciones) {
		this.observaciones = aObservaciones;
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

	public static CronogramaDesa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CronogramaDesa) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static CronogramaDesa findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CronogramaDesa) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static CronogramaDesa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CronogramaDesa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public List getAcciones() throws BaseException {
		if (this.readAcciones) {
			List listaAcciones = AccCronoDesa.getAccionesCrono(this, getSesion());
			acciones.addAll(listaAcciones);
			this.readAcciones = false;
		}
		return acciones;
	}
	
	
	public void afterSave() throws BaseException {

		Iterator iterAcciones = acciones.iterator();
		while (iterAcciones.hasNext()) {
			AccCronoDesa accCronoDesa = (AccCronoDesa) iterAcciones.next();
			accCronoDesa.save();
			accCronoDesa = null;
		}
		iterAcciones = null;
	}
	
	public void addAccion(AccCronoDesa aAccCronoDesa) throws BaseException {
		aAccCronoDesa.setCronograma(this);
		acciones.add(aAccCronoDesa);
	}
	

}
