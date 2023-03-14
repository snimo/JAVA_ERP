package com.srn.erp.payroll.bm;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.payroll.da.DBPayConsultaAusentismo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PayConsultaAusentismo extends ObjetoLogico {

	public PayConsultaAusentismo() {
	}

	public static String NICKNAME = "admRRHH.payConsultaAusentismo";

	private String lejago;
	private String nombre;
	private String sector;
	private String puesto;
	private Date fechaIniLicencia;
	private Date fechaAusensia;
	private String tAusencia;
	private String observacion;
	private String tramo;

	public String getLejago() throws BaseException {
		supportRefresh();
		return lejago;
	}

	public void setLejago(String aLejago) {
		this.lejago = aLejago;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getSector() throws BaseException {
		supportRefresh();
		return sector;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Date getFechaIniLicencia() {
		return fechaIniLicencia;
	}

	public void setFechaIniLicencia(Date fechaIniLicencia) {
		this.fechaIniLicencia = fechaIniLicencia;
	}

	public Date getFechaAusensia() {
		return fechaAusensia;
	}

	public void setFechaAusensia(Date fechaAusensia) {
		this.fechaAusensia = fechaAusensia;
	}

	public String getTramo() {
		return tramo;
	}

	public void setTramo(String tramo) {
		this.tramo = tramo;
	}

	public String gettAusencia() {
		return tAusencia;
	}

	public void settAusencia(String tAusencia) {
		this.tAusencia = tAusencia;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public void setSector(String aSector) {
		this.sector = aSector;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PayConsultaAusentismo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PayConsultaAusentismo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PayConsultaAusentismo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PayConsultaAusentismo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public static List<PayConsultaAusentismo> findByFiltros(Hashtable<String, Object> hashTable, ISesion aSesion) throws BaseException {
		return (List<PayConsultaAusentismo>) DBPayConsultaAusentismo.findByFiltros(hashTable, aSesion);
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}