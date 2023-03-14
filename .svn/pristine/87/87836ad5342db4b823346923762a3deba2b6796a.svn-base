package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBDocEnvSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DocEnvSeclo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DocEnvSeclo() {
	}

	public static String NICKNAME = "leg.DocEnvSeclo";

	private Seclo seclo;
	private java.util.Date fecha_envio;
	private String documentacion;
	private Boolean activo;

	public Seclo getSeclo() throws BaseException {
		supportRefresh();
		return seclo;
	}

	public void setSeclo(Seclo aSeclo) {
		this.seclo = aSeclo;
	}

	public java.util.Date getFecha_envio() throws BaseException {
		supportRefresh();
		return fecha_envio;
	}

	public void setFecha_envio(java.util.Date aFecha_envio) {
		this.fecha_envio = aFecha_envio;
	}

	public String getDocumentacion() throws BaseException {
		supportRefresh();
		return documentacion;
	}

	public void setDocumentacion(String aDocumentacion) {
		this.documentacion = aDocumentacion;
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

	public static DocEnvSeclo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DocEnvSeclo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DocEnvSeclo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DocEnvSeclo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(seclo, "Debe ingresar el Seclo");
		Validar.noNulo(fecha_envio, "Debe ingresar la Fecha");
	}

	public static List getDocEnvBySeclos(Seclo aSeclo, ISesion aSesion) throws BaseException {
		return DBDocEnvSeclo.getDocEnvBySeclos(aSeclo, aSesion);
	}
	
	public String getLeyendaDocuEnv() throws BaseException {
		String resp = "";
		if (this.getFecha_envio()!=null)
			resp = Fecha.getddmmyyyy(this.getFecha_envio())+" ";
		if (this.getDocumentacion()!=null)
			resp = resp + this.getDocumentacion();
		return resp;
	}

}
