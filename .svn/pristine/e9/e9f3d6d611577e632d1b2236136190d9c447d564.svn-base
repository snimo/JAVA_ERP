package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBArchAdjExc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ArchAdjExc extends ObjetoLogico {

	public ArchAdjExc() {
	}

	public static String NICKNAME = "exc.ArchAdjExc";

	private java.util.Date fecha;
	private String nombre;
	private String titulo;
	private Boolean activo;
	private IndividuoExcluido individuo;
	private Integer orden;
	private PredioExcluido predio;

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}
	
	public PredioExcluido getPredio() throws BaseException {
		supportRefresh();
		return predio;
	}

	public void setPredio(PredioExcluido aPredio) {
		this.predio = aPredio;
	}
	

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return this.orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public IndividuoExcluido getIndividuo() throws BaseException {
		supportRefresh();
		return this.individuo;
	}

	public void setIndividuo(IndividuoExcluido aIndividuo) {
		this.individuo = aIndividuo;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getTitulo() throws BaseException {
		supportRefresh();
		return titulo;
	}

	public void setTitulo(String aTitulo) {
		this.titulo = aTitulo;
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

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArchAdjExc findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ArchAdjExc) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ArchAdjExc findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ArchAdjExc) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.predio, "Debe ingresar el Predio correspondiente al archivo adjunto");
	}

	public static List getArchAdjInd(ISesion aSesion, IndividuoExcluido individuo) throws BaseException {
		return DBArchAdjExc.getArchAdjInd(aSesion, individuo);
	}

	public static ArchAdjExc getArchivoAdjExc(IndividuoExcluido individuo, Integer orden, ISesion aSesion) throws BaseException {
		return DBArchAdjExc.getArchivoAdjExc(individuo, orden, aSesion);
	}

}
