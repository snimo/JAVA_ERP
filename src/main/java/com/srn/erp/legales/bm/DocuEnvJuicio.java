package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBDocuEnvJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DocuEnvJuicio extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DocuEnvJuicio() {
	}

	public static String NICKNAME = "leg.DocuEnvJuicio";

	private Juicio juicio;
	private java.util.Date fecha_envio;
	private String documentacion;
	private Boolean activo;

	public Juicio getJuicio() throws BaseException {
		supportRefresh();
		return juicio;
	}

	public void setJuicio(Juicio aJuicio) {
		this.juicio = aJuicio;
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

	public static DocuEnvJuicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DocuEnvJuicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DocuEnvJuicio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DocuEnvJuicio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(juicio, "Debe ingresar el Juicio");
		Validar.noNulo(fecha_envio, "Debe ingresar la Fecha de Envío");
	}

	public static List getDocuEnvJuicio(Juicio juicio, ISesion aSesion) throws BaseException {
		return DBDocuEnvJuicio.getDocuEnvJuicio(juicio, aSesion);
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
