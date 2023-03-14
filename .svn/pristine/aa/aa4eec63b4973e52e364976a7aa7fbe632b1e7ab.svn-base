package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMovVisitaCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MovVisitaCIP extends ObjetoLogico {

	public MovVisitaCIP() {
	}

	public static String NICKNAME = "cip.MovVisitaCIP";

	private Visita visita;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private Puerta puerta;
	private java.util.Date fecha;
	private String hora;
	private Integer hora_en_min;
	private String sentido;
	private java.util.Date fec_hor;
	private ZonaCIP zona_origen;
	private ZonaCIP zona_destino;
	private Legajo visita_a;
	private Legajo autorizo;
	private Boolean activo;
	private TarjetaCIP tarjeta;

	public Visita getVisita() throws BaseException {
		supportRefresh();
		return visita;
	}

	public TarjetaCIP getTarjeta() throws BaseException {
		supportRefresh();
		return this.tarjeta;
	}

	public void setTarjeta(TarjetaCIP aTarjeta) {
		this.tarjeta = aTarjeta;
	}

	public void setVisita(Visita aVisita) {
		this.visita = aVisita;
	}

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
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

	public Integer getHora_en_min() throws BaseException {
		supportRefresh();
		return hora_en_min;
	}

	public void setHora_en_min(Integer aHora_en_min) {
		this.hora_en_min = aHora_en_min;
	}

	public String getSentido() throws BaseException {
		supportRefresh();
		return sentido;
	}

	public void setSentido(String aSentido) {
		this.sentido = aSentido;
	}

	public java.util.Date getFec_hor() throws BaseException {
		supportRefresh();
		return fec_hor;
	}

	public void setFec_hor(java.util.Date aFec_hor) {
		this.fec_hor = aFec_hor;
	}

	public ZonaCIP getZona_origen() throws BaseException {
		supportRefresh();
		return zona_origen;
	}

	public void setZona_origen(ZonaCIP aZona_origen) {
		this.zona_origen = aZona_origen;
	}

	public ZonaCIP getZona_destino() throws BaseException {
		supportRefresh();
		return zona_destino;
	}

	public void setZona_destino(ZonaCIP aZona_destino) {
		this.zona_destino = aZona_destino;
	}

	public Legajo getVisita_a() throws BaseException {
		supportRefresh();
		return visita_a;
	}

	public void setVisita_a(Legajo aVisita_a) {
		this.visita_a = aVisita_a;
	}

	public Legajo getAutorizo() throws BaseException {
		supportRefresh();
		return autorizo;
	}

	public void setAutorizo(Legajo aAutorizo) {
		this.autorizo = aAutorizo;
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

	public static MovVisitaCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MovVisitaCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MovVisitaCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MovVisitaCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(visita, "Debe ingresar la Visita");
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
		Validar.noNulo(fecha, "Debe ingresar la fecha");
		Validar.noNulo(hora, "Debe ingresar la Hora");
		Validar.noNulo(hora_en_min, "Debe ingresar la Hora");
		Validar.noNulo(sentido, "Debe ingresar el sentido");
		Validar.noNulo(fec_hor, "Debe ingresar la Fecha/Hora");
	}

	public static List getMovimientosCIP(java.util.Date fecDesde, java.util.Date fecHasta, ClasificadorEntidad titulo, List listaVisitas, List listaValoresClasif, ISesion aSesion)
			throws BaseException {
		return DBMovVisitaCIP.getMovimientosCIP(fecDesde, fecHasta, titulo, listaVisitas, listaValoresClasif, aSesion);
	}

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		// Si la Puerta traga la tarjet entonces devolvela
		if ((this.getPuerta()!=null) && (this.getSentido()!=null) && this.getSentido().equals(PermisoVisita.SENTIDO_S) && (this.getPuerta().isTragaTarjAlSalir()) && (this.getTarjeta()!=null)) {
			this.getTarjeta().devolverla(false);
		}
	}

}
