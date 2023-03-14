package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBDocumentacionVisitaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class DocumentacionVisitaCIP extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DocumentacionVisitaCIP() {
	}

	public static String NICKNAME = "cip.DocumentacionVisitaCIP";

	private Visita vistat;
	private TipoDocumentacionCIP tipo_documentacion;
	private Boolean controla_fecha;
	private java.util.Date fec_vto;
	private String observacion;
	private Boolean activo;
	private Boolean presentado;
	private java.util.Date fecPresen;
	private java.util.Date fecEmision; 
	private GrupoVisita grupoVisita;

	public Visita getVistat() throws BaseException {
		supportRefresh();
		return vistat;
	}
	
	public GrupoVisita getGrupoVisita() throws BaseException {
		supportRefresh();
		return grupoVisita;
	}
	

	public java.util.Date getFecPresentacion() throws BaseException {
		supportRefresh();
		return this.fecPresen;
	}
	
	public java.util.Date getFecEmision() throws BaseException {
		supportRefresh();
		return this.fecEmision;
	}	

	public void setVistat(Visita aVistat) {
		this.vistat = aVistat;
	}
	
	public void setGrupoVisita(GrupoVisita aGrupoVisita) {
		this.grupoVisita = aGrupoVisita;
	}
	

	public void setFecPresentacion(java.util.Date aFecPresentacion) {
		this.fecPresen = aFecPresentacion;
	}
	
	public void setFecEmision(java.util.Date aFecEmision) {
		this.fecEmision = aFecEmision;
	}
	

	public Boolean isPresentado() throws BaseException {
		supportRefresh();
		return this.presentado;
	}

	public void setPresentado(Boolean aPresentado) {
		this.presentado = aPresentado;
	}

	public TipoDocumentacionCIP getTipo_documentacion() throws BaseException {
		supportRefresh();
		return tipo_documentacion;
	}

	public void setTipo_documentacion(TipoDocumentacionCIP aTipo_documentacion) {
		this.tipo_documentacion = aTipo_documentacion;
	}

	public Boolean isControla_fecha() throws BaseException {
		supportRefresh();
		return controla_fecha;
	}

	public void setControla_fecha(Boolean aControla_fecha) {
		this.controla_fecha = aControla_fecha;
	}

	public java.util.Date getFec_vto() throws BaseException {
		supportRefresh();
		return fec_vto;
	}

	public void setFec_vto(java.util.Date aFec_vto) {
		this.fec_vto = aFec_vto;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
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

	public static DocumentacionVisitaCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DocumentacionVisitaCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DocumentacionVisitaCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DocumentacionVisitaCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_documentacion, "Debe ingresar el Tipo de Documentación");
		Validar.noNulo(controla_fecha, "Debe ingresar si controla o no la fecha");
	}

	public static List getDocumentacion(Visita aVisita, ISesion aSesion) throws BaseException {
		return DBDocumentacionVisitaCIP.getDocumentacion(aVisita, aSesion);
	}
	
	public static List getDocumentacion(GrupoVisita aGrupoVisita, ISesion aSesion) throws BaseException {
		return DBDocumentacionVisitaCIP.getDocumentacion(aGrupoVisita, aSesion);
	}
	
	public static DocumentacionVisitaCIP getDocumentacion(
			  java.util.Date fecha,
			  Visita visita,
			  TipoDocumentacionCIP tipoDocu,
	          ISesion aSesion)
	          throws BaseException {
		  return DBDocumentacionVisitaCIP.getDocumentacion(fecha,visita,tipoDocu,aSesion);
	}

}
