package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPaseRechazado;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class PaseRechazado extends ObjetoLogico {

	public PaseRechazado() {
	}

	public static final String E = "E";
	public static final String S = "S";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "cip.PaseRechazado";

	private Legajo legajo;
	private java.util.Date fecha;
	private String hora;
	private Puerta puerta;
	private Integer media;
	private String motivo;
	private Boolean activo;
	private String entradaSalida;
	private Visita visita;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}
	
	public Visita getVisita() throws BaseException {
		supportRefresh();
		return visita;
	}

	public void setVisita(Visita aVisita) {
		this.visita = aVisita;
	}
	

	public String getEntradaSalida() throws BaseException {
		supportRefresh();
		return this.entradaSalida;
	}

	public void setEntradaSalida(String aEntradaSalida) {
		this.entradaSalida = aEntradaSalida;
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

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public Integer getMedia() throws BaseException {
		supportRefresh();
		return media;
	}

	public void setMedia(Integer aMedia) {
		this.media = aMedia;
	}

	public String getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(String aMotivo) {
		this.motivo = aMotivo;
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

	public static PaseRechazado findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PaseRechazado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PaseRechazado findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PaseRechazado) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(hora, "Debe ingresar la Hora");
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
		Validar.noNulo(media, "Debe ingresar el Valor de Medio de Ingreso");
	}

	public static List getPasesRechazados(
					java.util.Date fecDesde, 
					java.util.Date fecHasta, 
					List listaLegajos, 
					ISesion aSesion)
			throws BaseException {

		return DBPaseRechazado.getPasesRechazados(fecDesde, fecHasta, listaLegajos, aSesion);

	}

}
