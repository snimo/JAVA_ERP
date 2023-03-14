package com.srn.erp.general.bm;

import java.util.Date;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class ComprobanteImpreso extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ComprobanteImpreso() {
	}

	public static String NICKNAME = "ge.ComprobanteImpreso";

	private Boolean impre_generada;
	private java.util.Date impre_fecha;
	private String impre_hora;
	private Integer impre_usu;
	private Integer impre_cant;
	private Boolean pdf_generado;
	private java.util.Date pdf_fecha;
	private String pdf_hora;
	private Integer pdf_usu;
	private Integer pdf_cant;
	private Integer version_externa;
	private Boolean congelarVersion;
	private java.util.Date version_fecha;
	private String version_hora;
	private Integer version_usu;

	public Boolean isImpre_generada() throws BaseException {
		supportRefresh();
		return impre_generada;
	}

	public void setImpre_generada(Boolean aImpre_generada) {
		this.impre_generada = aImpre_generada;
	}

	public Boolean isVersionCongelada() throws BaseException {
		supportRefresh();
		return this.congelarVersion;
	}

	public void setCongelarVersion(Boolean aCongelarVersion) {
		this.congelarVersion = aCongelarVersion;
	}

	public java.util.Date getVersion_fecha() throws BaseException {
		supportRefresh();
		return version_fecha;
	}

	public void setVersion_fecha(java.util.Date aVersion_fecha) {
		this.version_fecha = aVersion_fecha;
	}

	public String getVersion_hora() throws BaseException {
		supportRefresh();
		return version_hora;
	}

	public void setVersion_hora(String aVersion_hora) {
		this.version_hora = aVersion_hora;
	}

	public Integer getVersion_usu() throws BaseException {
		supportRefresh();
		return version_usu;
	}

	public void setVersion_usu(Integer aVersion_usu) {
		this.version_usu = aVersion_usu;
	}

	public java.util.Date getImpre_fecha() throws BaseException {
		supportRefresh();
		return impre_fecha;
	}

	public void setImpre_fecha(java.util.Date aImpre_fecha) {
		this.impre_fecha = aImpre_fecha;
	}

	public String getImpre_hora() throws BaseException {
		supportRefresh();
		return impre_hora;
	}

	public void setImpre_hora(String aImpre_hora) {
		this.impre_hora = aImpre_hora;
	}

	public Integer getImpre_usu() throws BaseException {
		supportRefresh();
		return impre_usu;
	}

	public void setImpre_usu(Integer aImpre_usu) {
		this.impre_usu = aImpre_usu;
	}

	public Integer getImpre_cant() throws BaseException {
		supportRefresh();
		return impre_cant;
	}

	public void setImpre_cant(Integer aImpre_cant) {
		this.impre_cant = aImpre_cant;
	}

	public Boolean isPdf_generado() throws BaseException {
		supportRefresh();
		return pdf_generado;
	}

	public void setPdf_generado(Boolean aPdf_generado) {
		this.pdf_generado = aPdf_generado;
	}

	public java.util.Date getPdf_fecha() throws BaseException {
		supportRefresh();
		return pdf_fecha;
	}

	public void setPdf_fecha(java.util.Date aPdf_fecha) {
		this.pdf_fecha = aPdf_fecha;
	}

	public String getPdf_hora() throws BaseException {
		supportRefresh();
		return pdf_hora;
	}

	public void setPdf_hora(String aPdf_hora) {
		this.pdf_hora = aPdf_hora;
	}

	public Integer getPdf_usu() throws BaseException {
		supportRefresh();
		return pdf_usu;
	}

	public void setPdf_usu(Integer aPdf_usu) {
		this.pdf_usu = aPdf_usu;
	}

	public Integer getPdf_cant() throws BaseException {
		supportRefresh();
		return pdf_cant;
	}

	public void setPdf_cant(Integer aPdf_cant) {
		this.pdf_cant = aPdf_cant;
	}

	public Integer getVersion_externa() throws BaseException {
		supportRefresh();
		return version_externa;
	}

	public void setVersion_externa(Integer aVersion_externa) {
		this.version_externa = aVersion_externa;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComprobanteImpreso findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComprobanteImpreso) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComprobanteImpreso findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ComprobanteImpreso) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public void siEstaCongeladoGenerarNuevaVersion() throws BaseException {
		
		if ((this.isVersionCongelada()!=null) && (this.isVersionCongelada().booleanValue())) {
			  this.setCongelarVersion(new Boolean(false));
			  this.setVersion_fecha(Fecha.getFechaActual());
			  this.setVersion_hora(Fecha.getHoraActual());
			  this.setVersion_usu(this.getSesion().getLogin().getUsuario().getOID());
			  this.setImpre_generada(new Boolean(false));
			  this.setPdf_generado(new Boolean(false));
			  
			  int versionActual = 0;
			  if (this.getVersion_externa()!=null)
				  versionActual = this.getVersion_externa().intValue();
			  
			  this.setVersion_externa(new Integer(++versionActual));
			  save();
		}
		
	}

}
