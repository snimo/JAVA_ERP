package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Idioma;
import com.srn.erp.ventas.da.DBObsCodifVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ObsCodifVtas extends ObjetoLogico {

	public ObsCodifVtas() {
	}

	public static String NICKNAME = "ve.ObsCodifVtas";

	private String codigo;
	private String descripcion;
	private Boolean incluir;
	private Boolean activo;
	private String tipo;
	private Integer orden;

	private List observacionesIdioma = new ArrayList();
	private boolean readObservacionesIdioma = true;

	private List observacionesSucursal = new ArrayList();
	private boolean readObservacionesSucursal = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isIncluir() throws BaseException {
		supportRefresh();
		return incluir;
	}

	public void setIncluir(Boolean aIncluir) {
		this.incluir = aIncluir;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ObsCodifVtas findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsCodifVtas) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ObsCodifVtas findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsCodifVtas) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ObsCodifVtas findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ObsCodifVtas) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(incluir, "Debe ingresar si se incluye o no");
		Validar.noNulo(tipo, "Debe ingresar el Tipo");
		Validar.noNulo(orden, "Debe ingresar el Orden");
	}

	public List getObservacionesIdioma() throws BaseException {
		if (this.readObservacionesIdioma) {
			List listaObsIdioma = ObsCodifVtasIdioma.getObsCodIdioma(this, getSesion());
			observacionesIdioma.addAll(listaObsIdioma);
			this.readObservacionesIdioma = false;
		}
		return observacionesIdioma;
	}

	public List getObservacionesSucursal() throws BaseException {
		if (this.readObservacionesSucursal) {
			List listaObsSucursal = ObsCodifVtasSucursal.getObsCodSucursal(this, getSesion());
			observacionesSucursal.addAll(listaObsSucursal);
			this.readObservacionesSucursal = false;
		}
		return observacionesSucursal;
	}

	public void addObservacionIdioma(ObsCodifVtasIdioma observacionIdioma) throws BaseException {
		observacionIdioma.setCodigo_observacion(this);
		observacionesIdioma.add(observacionIdioma);
	}

	public void addObservacionSucursal(ObsCodifVtasSucursal observacionSucursal) throws BaseException {
		observacionSucursal.setCodigo_observacion(this);
		observacionesSucursal.add(observacionSucursal);
	}

	public void afterSave() throws BaseException {

		Iterator iterObservacionesIdioma = this.observacionesIdioma.iterator();
		while (iterObservacionesIdioma.hasNext()) {
			ObsCodifVtasIdioma obsIdioma = (ObsCodifVtasIdioma) iterObservacionesIdioma.next();
			obsIdioma.save();
			obsIdioma = null;
		}
		iterObservacionesIdioma = null;

		Iterator iterObservacionesSucursal = this.observacionesSucursal.iterator();
		while (iterObservacionesSucursal.hasNext()) {
			ObsCodifVtasSucursal obsSucursal = (ObsCodifVtasSucursal) iterObservacionesSucursal.next();
			obsSucursal.save();
			obsSucursal = null;
		}
		iterObservacionesSucursal = null;

	}

	public static List getObsDefaultPresupuesto(ISesion aSesion) throws BaseException {
		return DBObsCodifVtas.getObsDefaultPresupuesto(aSesion);
	}

	public static List getObsDefaultPedido(ISesion aSesion) throws BaseException {
		return DBObsCodifVtas.getObsDefaultPedido(aSesion);
	}
	
	public String getDescripcion(Idioma idioma) throws BaseException {
		if (idioma == null)
			return this.getDescripcion();
		
		ObsCodifVtasIdioma obsIdioma =
			ObsCodifVtasIdioma.getObsCodifVtasIdioma(this, idioma, this.getSesion());
		
		if (obsIdioma == null)
			return this.getDescripcion();
		else
			return obsIdioma.getDescripcion();
	}

}
