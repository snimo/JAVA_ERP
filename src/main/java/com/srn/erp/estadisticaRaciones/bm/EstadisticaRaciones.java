package com.srn.erp.estadisticaRaciones.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.estadisticaRaciones.da.DBEstadisticaRaciones;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class EstadisticaRaciones extends ObjetoLogico {

	public EstadisticaRaciones() {
	}

	public static String NICKNAME = "est.estadisticaRaciones";

	private String empresa;
	private java.util.Date fecha;
	private String tipoRacion;
	private String tipo;
	private Integer cantidad;
	private Integer anio;
	private Integer mes;
	private String dia;

	public String getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(String aEmpresa) {
		this.empresa = aEmpresa;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getTiporacion() throws BaseException {
		supportRefresh();
		return tipoRacion;
	}

	public void setTiporacion(String aTiporacion) {
		this.tipoRacion = aTiporacion;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public Integer getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Integer aCantidad) {
		this.cantidad = aCantidad;
	}

	public Integer getAnio() throws BaseException {
		supportRefresh();
		return anio;
	}

	public void setAnio(Integer aAnio) {
		this.anio = aAnio;
	}

	public Integer getMes() throws BaseException {
		supportRefresh();
		return mes;
	}

	public void setMes(Integer aMes) {
		this.mes = aMes;
	}

	public String getDia() throws BaseException {
		supportRefresh();
		return dia;
	}

	public void setDia(String aDia) {
		this.dia = aDia;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EstadisticaRaciones findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadisticaRaciones) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadisticaRaciones findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadisticaRaciones) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public void beforeSave() throws BaseException {
	}

	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static List getEstadisticaRaciones(Date fechaDesde, Date fechaHasta, ISesion aSesion) throws BaseException {

		return DBEstadisticaRaciones.getEstadisticaRaciones(fechaDesde,fechaHasta,aSesion);
		
	}
	

}
