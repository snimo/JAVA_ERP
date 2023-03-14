package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBAudienciaSeclo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AudienciaSeclo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AudienciaSeclo() {
	}

	public static String NICKNAME = "leg.AudienciaSeclo";

	private Seclo seclo;
	private java.util.Date fecha;
	private String Hora;
	private String direccion;
	private String conciliador;
	private String telefonos;
	private Boolean activo;

	public Seclo getSeclo() throws BaseException {
		supportRefresh();
		return seclo;
	}

	public void setSeclo(Seclo aSeclo) {
		this.seclo = aSeclo;
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
		return Hora;
	}

	public void setHora(String aHora) {
		this.Hora = aHora;
	}

	public String getDireccion() throws BaseException {
		supportRefresh();
		return direccion;
	}

	public void setDireccion(String aDireccion) {
		this.direccion = aDireccion;
	}

	public String getConciliador() throws BaseException {
		supportRefresh();
		return conciliador;
	}

	public void setConciliador(String aConciliador) {
		this.conciliador = aConciliador;
	}

	public String getTelefonos() throws BaseException {
		supportRefresh();
		return telefonos;
	}

	public void setTelefonos(String aTelefonos) {
		this.telefonos = aTelefonos;
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

	public static AudienciaSeclo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AudienciaSeclo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AudienciaSeclo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AudienciaSeclo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(seclo, "Debe ingresar el Seclo");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
	}
	
	public static List getAudiencias(Seclo aSeclo,
	          ISesion aSesion) throws BaseException {
		  return DBAudienciaSeclo.getAudiencias(aSeclo,aSesion);
	}
	
	public String getLeyendaAudiencia() throws BaseException {
		
		String leyenda = "";
		if (this.getFecha()!=null)
			leyenda = "Fecha "+Fecha.getddmmyyyy(this.getFecha());
		
		if (this.getHora()!=null)
			leyenda = leyenda + " "+this.getHora().trim();
		
		if ((this.getDireccion()!=null) && (this.getDireccion().trim()!=""))
			leyenda = leyenda + Util.ENTER() + this.getDireccion().trim();
		
		if ((this.getConciliador()!=null) && (this.getConciliador().trim()!=""))
			leyenda = leyenda + Util.ENTER() +"Conciliador "+this.getConciliador()+" ";
		
		if ((this.getTelefonos()!=null) && (this.getTelefonos().trim()!=""))
			leyenda = leyenda + this.getTelefonos().trim();
		
		
		return leyenda;
		
	}

}
