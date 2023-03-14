package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBEstadoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoCIP extends ObjetoLogico {

	public EstadoCIP() {
	}

	public static String NICKNAME = "cip.EstadoCIP";

	private String codigo;
	private String descripcion;
	private String tipo_ingreso;
	private String tipo_egreso;
	private Boolean activo;
	private String leyendaIngDenegado;
	private String leyendaEgrDenegado;
	private Boolean activarAntiPassBack;
	private Boolean esSusceptibleCacheo;
	private Integer minEntAntEntrada;
	private Integer minEntDesEntrada;
	

	private List equivalencias = new ArrayList();
	private boolean readEquivalencias = true;
	
	private List motivosAccesosInter = new ArrayList();
	private boolean readMotivosAccesosInter = true;
	
	private List categoriasAccesos = new ArrayList();
	private boolean readCategoriasAccesos = true;
	
	public Boolean isActivarAntiPassBack() throws BaseException {
		supportRefresh();
		if (this.activarAntiPassBack == null)
			return false;
		else
			return this.activarAntiPassBack;
	}

	public void setActivarAntiPassBack(Boolean aActivarAntiPassBack) {
		this.activarAntiPassBack = aActivarAntiPassBack;
	}
	
	public Boolean isSusceptibleCacheo() throws BaseException {
		supportRefresh();
		if (this.esSusceptibleCacheo == null)
			return false;
		else
			return this.esSusceptibleCacheo;
	}

	public void setEsSusceptibleCacheo(Boolean aEsSusceptibleCacheo) {
		this.esSusceptibleCacheo = aEsSusceptibleCacheo;
	}	
	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public Integer getMinEntAntEntrada() throws BaseException {
		supportRefresh();
		if (this.minEntAntEntrada == null)
			return 0;
		else
			return this.minEntAntEntrada;
	}
	
	public Integer getMinEntDesEntrada() throws BaseException {
		supportRefresh();
		if (this.minEntDesEntrada == null)
			return 0;
		else
			return this.minEntDesEntrada;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setMinEntAntEntrada(Integer aMinEntAntEnt) {
		this.minEntAntEntrada = aMinEntAntEnt;
	}
	
	public void setMinEntDesEntrada(Integer aMinEntDesEnt) {
		this.minEntDesEntrada = aMinEntDesEnt;
	}
	
	public String getLeyendaIngDenegado() throws BaseException {
		supportRefresh();
		return this.leyendaIngDenegado;
	}

	public void setLeyendaIngDenegado(String aLeyendaIngDenegado) {
		this.leyendaIngDenegado = aLeyendaIngDenegado;
	}
	
	public String getLeyendaEgrDenegado() throws BaseException {
		supportRefresh();
		return this.leyendaEgrDenegado;
	}

	public void setLeyendaEgrDenegado(String aLeyendaEgrDenegado) {
		this.leyendaEgrDenegado = aLeyendaEgrDenegado;
	}	

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getTipo_ingreso() throws BaseException {
		supportRefresh();
		return tipo_ingreso;
	}

	public void setTipo_ingreso(String aTipo_ingreso) {
		this.tipo_ingreso = aTipo_ingreso;
	}

	public String getTipo_egreso() throws BaseException {
		supportRefresh();
		return tipo_egreso;
	}

	public void setTipo_egreso(String aTipo_egreso) {
		this.tipo_egreso = aTipo_egreso;
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

	public static EstadoCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadoCIP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EstadoCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(tipo_ingreso, "Debe ingresar el Tipo de Ingreso");
		Validar.noNulo(tipo_egreso, "Debe ingresar el Tipo de Egreso");
	}

	public List getEquivalencias() throws BaseException {
		if (this.readEquivalencias) {
			List listaEquivalencias = EquivalenciaEstadoCIP.getEquivalenciasEstado(this, getSesion());
			equivalencias.addAll(listaEquivalencias);
			this.readEquivalencias = false;
		}
		return equivalencias;
	}
	
	public List getCategoriasAccesos() throws BaseException {
		if (this.readCategoriasAccesos) {
			List listaCategoriasAccesos = CategAccesoEstado.getCategAccesoEstados(this, getSesion());
			this.categoriasAccesos.addAll(listaCategoriasAccesos);
			this.readCategoriasAccesos = false;
		}
		return categoriasAccesos;
	}
	
	
	public List getMotivosAccesosInter() throws BaseException {
		if (this.readMotivosAccesosInter) {
			List listaMotivosAccesosInter = MotEntInterEst.getMotEntInterEst(this, getSesion());
			motivosAccesosInter.addAll(listaMotivosAccesosInter);
			this.readMotivosAccesosInter = false;
		}
		return motivosAccesosInter;
	}
	

	public void addEquivalencia(EquivalenciaEstadoCIP aEquivalenciaEstadoCIP) throws BaseException {
		aEquivalenciaEstadoCIP.setEstado(this);
		this.equivalencias.add(aEquivalenciaEstadoCIP);
	}
	
	public void addCategoriaAcceso(CategAccesoEstado aCategAccesoEstado) throws BaseException {
		aCategAccesoEstado.setEstado(this);
		this.categoriasAccesos.add(aCategAccesoEstado);
	}
	
	
	public void addMotivoEntInterEstado(MotEntInterEst aMotEntInterEst) throws BaseException {
		aMotEntInterEst.setEstado(this);
		this.motivosAccesosInter.add(aMotEntInterEst);
	}	

	public void afterSave() throws BaseException {
		
		Iterator iterEquivalenciasCIP = equivalencias.iterator();
		while (iterEquivalenciasCIP.hasNext()) {
			EquivalenciaEstadoCIP equivEstadoCIP = (EquivalenciaEstadoCIP) iterEquivalenciasCIP.next();
			equivEstadoCIP.save();
			equivEstadoCIP = null;
		}
		iterEquivalenciasCIP = null;
		
		Iterator iterMotAccesosInter = motivosAccesosInter.iterator();
		while (iterMotAccesosInter.hasNext()) {
			MotEntInterEst motEntInterEst = (MotEntInterEst) iterMotAccesosInter.next();
			motEntInterEst.save();
			motEntInterEst = null;
		}
		iterMotAccesosInter = null;
		
		Iterator iterCategAccesos = this.categoriasAccesos.iterator();
		while (iterCategAccesos.hasNext()) {
			CategAccesoEstado categAccesoEstado = (CategAccesoEstado) iterCategAccesos.next();
			categAccesoEstado.save();
			categAccesoEstado = null;
		}
		iterCategAccesos = null;
		
		
		
	}
	
	public boolean isPermitirIngreso() throws BaseException {
		if (this.getTipo_ingreso()==null) return false;
		if (this.getTipo_ingreso().equals(TipoPermisoCIP.TP_PERMITIDO))
			return true;
		else
			return false;
	}
	
	public boolean isIngresoSegunPlanif() throws BaseException {
		if (this.getTipo_ingreso()==null) return false;
		if (this.getTipo_ingreso().equals(TipoPermisoCIP.TP_SEGUN_PLANIF))
			return true;
		else
			return false;
	}
	
	
	
	public boolean isPermitirEgreso() throws BaseException {
		if (this.getTipo_egreso()==null) return false;
		if (this.getTipo_egreso().equals(TipoPermisoCIP.TP_PERMITIDO))
			return true;
		else
			return false;
	}	
	
	public boolean isDenegarIngreso() throws BaseException {
		if (this.getTipo_ingreso()==null) return false;
		if (this.getTipo_ingreso().equals(TipoPermisoCIP.TP_DENEGADO))
			return true;
		else
			return false;
	}
	
	public boolean isDenegarEgreso() throws BaseException {
		if (this.getTipo_egreso()==null) return false;
		if (this.getTipo_egreso().equals(TipoPermisoCIP.TP_DENEGADO))
			return true;
		else
			return false;
	}
	
	public static List getAllEstadosCIP(
	          ISesion aSesion) throws BaseException {
		  return DBEstadoCIP.getAllEstadosCIP(aSesion);
	} 	
	
}
