package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBNovedadLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class NovedadLegajo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer("");
		if (this.getOid_tipo_novedad()!=null)
			result.append(this.getOid_tipo_novedad().getDescripcion()+" ");
		if (this.getMotivo_tipo_nov()!=null)
			result.append(this.getMotivo_tipo_nov().getDescripcion());
		if (this.getNro_ext()!=null)
			result.append("("+this.getNro_ext()+")");
		return result.toString();
	}

	public NovedadLegajo() {
	}

	public static String NICKNAME = "rh.NovedadLegajo";

	private Integer nro_ext;
	private TipoNovedad oid_tipo_novedad;
	private MotivoTipoNov motivo_tipo_nov;
	private java.util.Date fecha;
	private String hora_desde;
	private String hora_hasta;
	private Boolean activo;
	private String observacion;
	private Legajo oid_legajo;
	private Integer nro_orden;

	public Integer getNro_ext() throws BaseException {
		supportRefresh();
		return nro_ext;
	}

	public void setNro_ext(Integer aNro_ext) {
		this.nro_ext = aNro_ext;
	}

	public Integer getNroOrden() throws BaseException {
		supportRefresh();
		return this.nro_orden;
	}

	public void setNroOrden(Integer aNroOrden) {
		this.nro_orden = aNroOrden;
	}

	public TipoNovedad getOid_tipo_novedad() throws BaseException {
		supportRefresh();
		return oid_tipo_novedad;
	}

	public void setOid_tipo_novedad(TipoNovedad aOid_tipo_novedad) {
		this.oid_tipo_novedad = aOid_tipo_novedad;
	}

	public MotivoTipoNov getMotivo_tipo_nov() throws BaseException {
		supportRefresh();
		return motivo_tipo_nov;
	}

	public void setMotivo_tipo_nov(MotivoTipoNov aMotivo_tipo_nov) {
		this.motivo_tipo_nov = aMotivo_tipo_nov;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getHora_desde() throws BaseException {
		supportRefresh();
		if (hora_desde == null)
			return "";
		else
			return hora_desde;
	}

	public void setHora_desde(String aHora_desde) {
		this.hora_desde = aHora_desde;
	}

	public String getHora_hasta() throws BaseException {
		supportRefresh();
		if (hora_hasta == null)
			return "";
		else
			return hora_hasta;
	}

	public void setHora_hasta(String aHora_hasta) {
		this.hora_hasta = aHora_hasta;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		if (observacion == null)
			return "";
		else
			return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public Legajo getOid_legajo() throws BaseException {
		supportRefresh();
		return oid_legajo;
	}

	public void setOid_legajo(Legajo aOid_legajo) {
		this.oid_legajo = aOid_legajo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static NovedadLegajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NovedadLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NovedadLegajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (NovedadLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(oid_tipo_novedad, "Debe ingresar el Tipo de Novedad");
		Validar.noNulo(motivo_tipo_nov, "Debe ingresar el Motivo");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(oid_legajo, "Debe ingresar el Legajo");
	}

	public static List getNovedadesLegajo(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBNovedadLegajo.getNovedadesLegajo(aLegajo, aSesion);
	}

	public static List getNovedadesLegajo(Legajo aLegajo, TipoNovedad tipoNovedad, MotivoTipoNov motivo, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBNovedadLegajo.getNovedadesLegajo(aLegajo, tipoNovedad, motivo, fecDesde, fecHasta, aSesion);
	}

	public static List getNovedadesLegajo(Legajo aLegajo, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBNovedadLegajo.getNovedadesLegajo(aLegajo, fecDesde, fecHasta, aSesion);
	}

	public static List getNovedadesLegajo(Legajo aLegajo, RankearCab rankearCab, java.util.Date fecDesde, java.util.Date fecHasta, Integer nroNovedad, ISesion aSesion) throws BaseException {
		return DBNovedadLegajo.getNovedadesLegajo(aLegajo, rankearCab, fecDesde, fecHasta, nroNovedad, aSesion);
	}
	
	
	public static List getNovedadesLegajoFecha(Legajo aLegajo, 
			  java.util.Date fecha,
			  ISesion aSesion) throws BaseException {
		return DBNovedadLegajo.getNovedadesLegajoFecha(aLegajo,fecha,aSesion);
	}	

}
