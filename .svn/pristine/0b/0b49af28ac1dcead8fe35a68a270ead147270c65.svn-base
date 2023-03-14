package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBReporteContable;
import com.srn.erp.contabilidad.da.DBReporteContableDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ReporteContable extends ObjetoLogico {

	public ReporteContable() {
	}

	private List itemsReporte = new ArrayList();
	private boolean leerItemsReporte = true;

	public static String NICKNAME = "cg.ReporteContable";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Boolean showABMCtas;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public Boolean isShowEnABMCtas() throws BaseException {
		supportRefresh();
		return this.showABMCtas;
	}

	public void setShowEnABMCtas(Boolean aShowEnABMCtas) throws BaseException {
		this.showABMCtas = aShowEnABMCtas;
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

	public static ReporteContable findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ReporteContable) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ReporteContable findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ReporteContable) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ReporteContable findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ReporteContable) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("El reporte contable debe ingresarse en modo activo");

	}

	public List getItemsReporte() throws BaseException {
		if (leerItemsReporte) {
			List listaItemsReporte = DBReporteContableDet.getItemsReporte(this, getSesion());
			itemsReporte.addAll(listaItemsReporte);
			leerItemsReporte = false;
		}
		return itemsReporte;
	}

	public void addItemReporte(ReporteContableDet itemReporte) throws BaseException {
		itemReporte.setReporteContable(this);
		itemsReporte.add(itemReporte);
	}

	public void afterSave() throws BaseException {
		Iterator iterItemsReporte = itemsReporte.iterator();
		while (iterItemsReporte.hasNext()) {
			ReporteContableDet reporteContableDet = (ReporteContableDet) iterItemsReporte.next();
			reporteContableDet.save();
			reporteContableDet = null;
		}
		iterItemsReporte = null;
	}

	public static List getReportesActivosABMCtas(ISesion aSesion) throws BaseException {
		return DBReporteContable.getReportesActivosABMCtas(aSesion);
	}

	public List getSoloTitulosReporte() throws BaseException {
		return ReporteContableDet.getSoloTitulosReporte(this, this.getSesion());
	}

	public List getSoloReporteDetCtaActiva(Cuenta cuenta) throws BaseException {
		return ReporteContableDet.getSoloReporteDetCtaActiva(this, cuenta, this.getSesion());
	}

	public int getMaxOidTituReporte() throws BaseException {

		return ReporteContableDet.getMaxOidTituReporte(this, this.getSesion());

	}

}
