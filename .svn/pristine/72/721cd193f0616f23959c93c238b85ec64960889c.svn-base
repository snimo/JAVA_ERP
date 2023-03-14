package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBAudienciaJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AudienciaJuicio extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AudienciaJuicio() {
	}

	public static String NICKNAME = "leg.AudienciaJuicio";

	private Juicio juicio;
	private java.util.Date fecha;
	private String hora;
	private String persona;
	private TipoAudiencia tipo_audiencia;
	private Boolean activo;

	public Juicio getJuicio() throws BaseException {
		supportRefresh();
		return juicio;
	}

	public void setJuicio(Juicio aJuicio) {
		this.juicio = aJuicio;
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

	public String getPersona() throws BaseException {
		supportRefresh();
		return persona;
	}

	public void setPersona(String aPersona) {
		this.persona = aPersona;
	}

	public TipoAudiencia getTipo_audiencia() throws BaseException {
		supportRefresh();
		return tipo_audiencia;
	}

	public void setTipo_audiencia(TipoAudiencia aTipo_audiencia) {
		this.tipo_audiencia = aTipo_audiencia;
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

	public static AudienciaJuicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AudienciaJuicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AudienciaJuicio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AudienciaJuicio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(juicio, "Debe ingresar el Juicio");
	}
	
	public static List getAudienciasJuicio(Juicio aJuicio,ISesion aSesion) throws BaseException {
		  return DBAudienciaJuicio.getAudienciasJuicio(aJuicio,aSesion);
	}
	
	public String getLeyendaAudiencia() throws BaseException {
		
		String leyenda = "";
		if (this.getFecha()!=null)
			leyenda = "Fecha "+Fecha.getddmmyyyy(this.getFecha());
		
		if (this.getHora()!=null)
			leyenda = leyenda + " "+this.getHora().trim();
		
		if ((this.getPersona()!=null) && (this.getPersona().trim()!=""))
			leyenda = leyenda + Util.ENTER() +"     Persona "+this.getPersona()+" ";
		
		if ((this.getTipo_audiencia()!=null) && (this.getTipo_audiencia().getDescripcion().trim()!=""))
			leyenda = leyenda + this.getTipo_audiencia().getDescripcion();
		
		
		return leyenda;
		
	}	
	

}
