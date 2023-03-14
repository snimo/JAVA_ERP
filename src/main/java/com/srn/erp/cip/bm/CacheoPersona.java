package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCacheoPersona;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CacheoPersona extends ObjetoLogico {

	@Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		// Actualizar al contado de cacheos
		ContadorCacheoLeg contadorCacheoLeg = 
			ContadorCacheoLeg.getContadorCacheoLeg(this.getLegajo(), this.getSesion());
		if (contadorCacheoLeg == null) {
			contadorCacheoLeg = 
				(ContadorCacheoLeg) ContadorCacheoLeg.getNew(ContadorCacheoLeg.NICKNAME, this.getSesion());
			contadorCacheoLeg.setLegajo(this.getLegajo());
		}
		contadorCacheoLeg.acumular();
		contadorCacheoLeg.save();
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheoPersona() {
	}

	public static String NICKNAME = "cip.CacheoPersona";

	private Legajo legajo;
	private java.util.Date fecha;
	private String hora;
	private String observacion;
	private Boolean activo;
	private PersonalSeguridad personalSeguridad;
	private ResultadoCacheo resultadoCacheo;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}
	
	public ResultadoCacheo getResultadoCacheo() throws BaseException {
		supportRefresh();
		return resultadoCacheo;
	}

	public void setResultadoCacheo(ResultadoCacheo aResultadoCacheo) {
		this.resultadoCacheo = aResultadoCacheo;
	}	

	public PersonalSeguridad getPersonalSeguridad() throws BaseException {
		supportRefresh();
		return this.personalSeguridad;
	}

	public void setPersonalSeguridad(PersonalSeguridad aPersonalSeguridad) {
		this.personalSeguridad = aPersonalSeguridad;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getHora() throws BaseException {
		supportRefresh();
		return hora;
	}

	public void setHora(String aHora) {
		this.hora = aHora;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
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

	public static CacheoPersona findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CacheoPersona) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CacheoPersona findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CacheoPersona) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CacheoPersona findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CacheoPersona) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(fecha, "Debe ingresar la fecha");
		Validar.noNulo(hora, "Debe ingresar la hora");
		Validar.noNulo(this.personalSeguridad, "Debe ingresar el Personal de Seguridad");
	}

	public static List getCacheosPersonas(java.util.Date fechaDesde, java.util.Date fechaHasta, Legajo legajo,
			PersonalSeguridad personalSeguridad, ISesion aSesion) throws BaseException {
		return DBCacheoPersona.getCacheosPersonas(fechaDesde, fechaHasta, legajo, personalSeguridad, aSesion);
	}

}
