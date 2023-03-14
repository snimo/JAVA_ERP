package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctasAPagar.da.DBEsquemaAutorizFactMonto;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsquemaAutorizFactProv extends ObjetoLogico {

	public EsquemaAutorizFactProv() {
	}

	public static String	NICKNAME									= "cap.EsquemaAutorizFactProv";

	private String				codigo;

	private String				descripcion;

	private Moneda				moneda;

	private Boolean				activo;

	private List					esquemasAutFactMontos			= new ArrayList();

	private boolean				readEsquemasAutFactMontos	= true;

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

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
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

	public static EsquemaAutorizFactProv findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactProv) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EsquemaAutorizFactProv findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactProv) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EsquemaAutorizFactProv findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactProv) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
	}

	public List getEsquemasMontos() throws BaseException {
		if (this.readEsquemasAutFactMontos) {
			List listaEsquemasMontos = EsquemaAutorizFactMonto.getEsqAutorizMontos(this, getSesion());
			this.esquemasAutFactMontos.addAll(listaEsquemasMontos);
			this.readEsquemasAutFactMontos = false;
		}
		return this.esquemasAutFactMontos;
	}

	public void addEsquemaAutorizFactMonto(EsquemaAutorizFactMonto esquemaAutorizFactMonto) throws BaseException {
		esquemaAutorizFactMonto.setEsquema_autoriz_factura(this);
		this.esquemasAutFactMontos.add(esquemaAutorizFactMonto);
	}

	public void afterSave() throws BaseException {
		Iterator iterEsquemasAutorizFactMonto = this.esquemasAutFactMontos.iterator();
		while (iterEsquemasAutorizFactMonto.hasNext()) {
			EsquemaAutorizFactMonto esqAutorizFactMonto = (EsquemaAutorizFactMonto) iterEsquemasAutorizFactMonto.next();
			esqAutorizFactMonto.save();
			esqAutorizFactMonto = null;
		}
		iterEsquemasAutorizFactMonto = null;
	}
	
	public EsquemaAutorizFactMonto getEsqAutorizFactMonto(Money monto) throws BaseException {
		return EsquemaAutorizFactMonto.getEsqAutorizFactMonto(monto,this,this.getSesion());
	}
	

}
