package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBSancionesLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class SancionesLegajo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer("");
		if (this.getMotivo_falta() != null)
			result.append(this.getMotivo_falta().getDescripcion() + " ");
		if (this.getMotivo_sancion() != null)
			result.append(this.getMotivo_sancion().getDescripcion() + " ");
		if (this.getNro_sancion() != null)
			result.append("Nro. " + this.getNro_sancion() + " ");
		return result.toString();
	}

	public SancionesLegajo() {
	}

	public static String NICKNAME = "rh.SancionesLegajo";

	private Legajo legajo;
	private MotivoFaltaRRHH motivo_falta;
	private SancionesRRHH motivo_sancion;
	private Integer nro_sancion;
	private java.util.Date fecha;
	private java.util.Date fec_susp_desde;
	private java.util.Date fec_reintegro;
	private Boolean activo;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public MotivoFaltaRRHH getMotivo_falta() throws BaseException {
		supportRefresh();
		return motivo_falta;
	}

	public void setMotivo_falta(MotivoFaltaRRHH aMotivo_falta) {
		this.motivo_falta = aMotivo_falta;
	}

	public SancionesRRHH getMotivo_sancion() throws BaseException {
		supportRefresh();
		return motivo_sancion;
	}

	public void setMotivo_sancion(SancionesRRHH aMotivo_sancion) {
		this.motivo_sancion = aMotivo_sancion;
	}

	public Integer getNro_sancion() throws BaseException {
		supportRefresh();
		return nro_sancion;
	}

	public void setNro_sancion(Integer aNro_sancion) {
		this.nro_sancion = aNro_sancion;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public java.util.Date getFec_susp_desde() throws BaseException {
		supportRefresh();
		return fec_susp_desde;
	}

	public void setFec_susp_desde(java.util.Date aFec_susp_desde) {
		this.fec_susp_desde = aFec_susp_desde;
	}

	public java.util.Date getFec_reintegro() throws BaseException {
		supportRefresh();
		return fec_reintegro;
	}

	public void setFec_reintegro(java.util.Date aFec_reintegro) {
		this.fec_reintegro = aFec_reintegro;
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

	public static SancionesLegajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SancionesLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SancionesLegajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SancionesLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
	}

	public static List getSancionesLegajos(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBSancionesLegajo.getSancionesLegajos(aLegajo, aSesion);
	}

	public static List getSancionesLegajos(Legajo aLegajo, java.util.Date fechaDesde, java.util.Date fechaHasta, ISesion aSesion) throws BaseException {
		return DBSancionesLegajo.getSancionesLegajos(aLegajo, fechaDesde, fechaHasta, aSesion);
	}

	public static List getSancionesLegajos(Integer nroNovedad, RankearCab ranquear, Legajo aLegajo, java.util.Date fechaDesde, java.util.Date fechaHasta, ISesion aSesion) throws BaseException {
		return DBSancionesLegajo.getSancionesLegajos(nroNovedad, ranquear, aLegajo, fechaDesde, fechaHasta, aSesion);
	}
	
	public static List getSancionesLegajosFecSuspDesdeYReintegro(
			Legajo aLegajo,
			java.util.Date fecha,
			ISesion aSesion) throws BaseException {
		return DBSancionesLegajo.getSancionesLegajosFecSuspDesdeYReintegro(aLegajo,fecha,aSesion);
	}	

}
