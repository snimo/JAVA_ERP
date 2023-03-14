package com.srn.erp.reclutamiento.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluEstCandidatoBusq extends ObjetoLogico {

	public RecluEstCandidatoBusq() {
	}

	public static String NICKNAME = "rs.RecluEstCandidatoBusq";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Integer color;
	private Boolean puedeCerrarBusqueda;
	private RecluEstadoPostulante estadoPostulante;
	private Boolean sugerirCierre;
	private RecluEstCandidatoBusq alCierreEstado;

	private List warning = new ArrayList();
	private boolean readWarning = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public RecluEstCandidatoBusq getAlCierreEstado() throws BaseException {
		supportRefresh();
		return this.alCierreEstado;
	}	
	
	public RecluEstadoPostulante getEstadoPostulante() throws BaseException {
		supportRefresh();
		return this.estadoPostulante;
	}	

	public Boolean isPuedeCerrarBusqueda() throws BaseException {
		supportRefresh();
		return this.puedeCerrarBusqueda;
	}
	
	public Boolean isSugerirCierre() throws BaseException {
		supportRefresh();
		return this.sugerirCierre;
	}	

	public Integer getColor() throws BaseException {
		supportRefresh();
		return color;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setAlCierreEstado(RecluEstCandidatoBusq aAlCierreEstado) {
		this.alCierreEstado = aAlCierreEstado;
	}	
	
	public void setSugerirCierre(Boolean aSugerirCierre) {
		this.sugerirCierre = aSugerirCierre;
	}	
	
	public void setEstadoPostulante(RecluEstadoPostulante aRecluEstadoPostulante) {
		this.estadoPostulante = aRecluEstadoPostulante;
	}	

	public void setPuedeCerrarBusqueda(Boolean aPuedeCerrarBusqueda) {
		this.puedeCerrarBusqueda = aPuedeCerrarBusqueda;
	}

	public void setColor(Integer aColor) {
		this.color = aColor;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static RecluEstCandidatoBusq findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluEstCandidatoBusq) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecluEstCandidatoBusq findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluEstCandidatoBusq) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RecluEstCandidatoBusq findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluEstCandidatoBusq) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getWarning() throws BaseException {
		if (this.readWarning) {
			List listaWarning = RecluWarnEstBusqCandi.getWarnEstBusqCandi(this, getSesion());
			this.warning.addAll(listaWarning);
			this.readWarning = false;
		}
		return this.warning;
	}

	public void addWarning(RecluWarnEstBusqCandi aRecluWarnEstBusqCandi) throws BaseException {
		aRecluWarnEstBusqCandi.setEstado_busqueda(this);
		this.warning.add(aRecluWarnEstBusqCandi);
	}

	public void afterSave() throws BaseException {
		Iterator iterWarning = this.warning.iterator();
		while (iterWarning.hasNext()) {
			RecluWarnEstBusqCandi warning = (RecluWarnEstBusqCandi) iterWarning.next();
			warning.save();
			warning = null;
		}
		iterWarning = null;
	}

}
