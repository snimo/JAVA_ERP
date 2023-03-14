package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluCurriPostu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluCurriPostu extends ObjetoLogico {

	public RecluCurriPostu() {
	}

	public static String NICKNAME = "rs.RecluCurriPostu";

	private RecluPostulante postulante;
	private java.util.Date fecha_recepcion;
	private String entregado_por;
	private String observacion;
	private Boolean activo;
	private Integer nroArchivoCV;
	private String nombreArchivo;

	public RecluPostulante getPostulante() throws BaseException {
		supportRefresh();
		return postulante;
	}
	
	
	public String getNombreArchivo() throws BaseException {
		supportRefresh();
		return this.nombreArchivo;
	}	
	
	public Integer getNroArchivoCV() throws BaseException {
		supportRefresh();
		return this.nroArchivoCV;
	}	

	public void setPostulante(RecluPostulante aPostulante) {
		this.postulante = aPostulante;
	}
	
	public void setNombreArchivo(String aNombreArchivo) {
		this.nombreArchivo = aNombreArchivo;
	}	

	
	public void setNroArchivoCV(Integer aNroArchivoCV) {
		this.nroArchivoCV = aNroArchivoCV;
	}
	
	
	public java.util.Date getFecha_recepcion() throws BaseException {
		supportRefresh();
		return fecha_recepcion;
	}

	public void setFecha_recepcion(java.util.Date aFecha_recepcion) {
		this.fecha_recepcion = aFecha_recepcion;
	}

	public String getEntregado_por() throws BaseException {
		supportRefresh();
		return entregado_por;
	}

	public void setEntregado_por(String aEntregado_por) {
		this.entregado_por = aEntregado_por;
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

	public static RecluCurriPostu findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluCurriPostu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecluCurriPostu findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluCurriPostu) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(postulante, "Debe ingresar el Postulante");
		Validar.noNulo(fecha_recepcion, "Debe ingresar la Fecha de Recepción");
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

	public static List getRecluCurriculumns(RecluPostulante postulante, ISesion aSesion) throws BaseException {
		return DBRecluCurriPostu.getRecluCurriculumns(postulante, aSesion);
	}

}
