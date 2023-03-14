package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBReferenciaArchivoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ReferenciaArchivoExcluido extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ReferenciaArchivoExcluido() {
	}

	public static String NICKNAME = "exc.ReferenciaArchivoExcluido";

	private IndividuoExcluido individuo;
	private java.util.Date fecha;
	private String titulo;
	private Boolean activo;

	public IndividuoExcluido getIndividuo() throws BaseException {
		supportRefresh();
		return individuo;
	}

	public void setIndividuo(IndividuoExcluido aIndividuo) {
		this.individuo = aIndividuo;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
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

	public static ReferenciaArchivoExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ReferenciaArchivoExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ReferenciaArchivoExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ReferenciaArchivoExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(individuo, "Debe ingresar el Individuo");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
	}

	public static List getReferenciasArchivos(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return DBReferenciaArchivoExcluido.getReferenciasArchivos(individuo, aSesion);
	}

}
