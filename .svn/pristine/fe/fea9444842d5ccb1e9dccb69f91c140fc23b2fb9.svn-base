package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBReporteContaCompo;
import com.srn.erp.contabilidad.da.DBReporteContableDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ReporteContableDet extends ObjetoLogico {

	public ReporteContableDet() {
	}

	private List itemsReporteContaCompo = new ArrayList();
	private boolean leerItemsReporteCompo = true;

	public static String NICKNAME = "cg.ReporteContableDet";

	public static final String TIPO_TITULO = "TITU";
	public static final String TIPO_CTA = "CTA";
	public static final String TIPO_RANGO = "RANGO";
	public static final String TIPO_COMPO = "COMPO";
	public static final String TIPO_NCOMPO = "NCOMP";

	private ReporteContable reporteContable;
	private Integer oidTitulo;
	private Integer oidTituloPadre;
	
	
	@Override
	public void beforeSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveDelete();
		
		Iterator iterReporteCompo = 
			this.getItemsReporteCompo().iterator();
		while (iterReporteCompo.hasNext()) {
			ReporteContaCompo reporteContaCompo = (ReporteContaCompo) iterReporteCompo.next();
			reporteContaCompo.delete();
			reporteContaCompo.save();
		}
		
	}

	private String descTitulo;
	private Cuenta cuenta;
	private String codigoDesde;
	private String codigoHasta;
	private String tipo;
	private Boolean activo;
	private Integer orden;

	public boolean isTitulo() throws BaseException {
		if (getTipo().equals(TIPO_TITULO))
			return true;
		else
			return false;
	}

	public boolean isCuenta() throws BaseException {
		if (getTipo().equals(TIPO_CTA))
			return true;
		else
			return false;
	}

	public boolean isRangoCuentas() throws BaseException {
		if (getTipo().equals(TIPO_RANGO))
			return true;
		else
			return false;
	}

	public boolean isCuentaConComponentes() throws BaseException {
		if (getTipo().equals(TIPO_COMPO))
			return true;
		else
			return false;
	}

	public boolean isCuentaSinComponentes() throws BaseException {
		if (getTipo().equals(TIPO_NCOMPO))
			return true;
		else
			return false;
	}

	public ReporteContable getReporteContable() throws BaseException {
		supportRefresh();
		return reporteContable;
	}

	public void setReporteContable(ReporteContable aReporteContable) {
		this.reporteContable = aReporteContable;
	}

	public Integer getOidtitulo() throws BaseException {
		supportRefresh();
		return oidTitulo;
	}

	public void setOidtitulo(Integer aOidtitulo) {
		this.oidTitulo = aOidtitulo;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public Integer getOidtitulopadre() throws BaseException {
		supportRefresh();
		return oidTituloPadre;
	}

	public void setOidtitulopadre(Integer aOidtitulopadre) {
		this.oidTituloPadre = aOidtitulopadre;
	}

	public String getDesctitulo() throws BaseException {
		supportRefresh();
		return descTitulo;
	}

	public void setDesctitulo(String aDesctitulo) {
		this.descTitulo = aDesctitulo;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public Cuenta getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(Cuenta aCuenta) {
		this.cuenta = aCuenta;
	}

	public String getCodigodesde() throws BaseException {
		supportRefresh();
		return codigoDesde;
	}

	public void setCodigodesde(String aCodigodesde) {
		this.codigoDesde = aCodigodesde;
	}

	public String getCodigohasta() throws BaseException {
		supportRefresh();
		return codigoHasta;
	}

	public void setCodigohasta(String aCodigohasta) {
		this.codigoHasta = aCodigohasta;
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

	public static ReporteContableDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ReporteContableDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ReporteContableDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ReporteContableDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ReporteContableDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ReporteContableDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(reporteContable, "Debe ingresar el Reporte Contable");
		Validar.noNulo(oidTitulo, "Debe ingresar el Titulo");
		Validar.noNulo(oidTituloPadre, "Debe ingresar el Título Padre");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("El reporte contable detalle debe ingresarse en modo activo");

	}

	public void afterSave() throws BaseException {
		Iterator iterItemsReporteConta = itemsReporteContaCompo.iterator();
		while (iterItemsReporteConta.hasNext()) {
			ReporteContaCompo reporteContaCompo = (ReporteContaCompo) iterItemsReporteConta.next();
			reporteContaCompo.save();
			reporteContaCompo = null;
		}
		iterItemsReporteConta = null;
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
		if (this.isTitulo())
			return this.getDesctitulo();
		else if (this.isCuenta())
			return this.getCuenta().getCodigo() + " - " + this.getCuenta().getDescripcion();
		else if (this.isRangoCuentas())
			return "Rango por Código:" + this.getCodigodesde() + " al " + this.getCodigohasta();
		else if (this.isCuentaConComponentes())
			return this.getCuenta().getCodigo() + " - " + this.getCuenta().getDescripcion() + " (INCLUIR)";
		else if (this.isCuentaSinComponentes())
			return this.getCuenta().getCodigo() + " - " + this.getCuenta().getDescripcion() + " (EXCLUIR)";
		else
			return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public List getRangoCuentas(String codigoDesde, String codigoHasta) throws BaseException {
		return null;
	}

	public List getItemsReporteCompo() throws BaseException {
		if (leerItemsReporteCompo) {
			List listaItemsReporteCompo = DBReporteContaCompo.getReportesContaCompoByReporteDet(this, getSesion());
			itemsReporteContaCompo.addAll(listaItemsReporteCompo);
			leerItemsReporteCompo = false;
		}
		return itemsReporteContaCompo;
	}

	public HashTableDatos getValoresComponentes() throws BaseException {
		HashTableDatos valoresComponentes = new HashTableDatos();
		List itemsReporteCompo = getItemsReporteCompo();
		Iterator iterReporteCompo = itemsReporteCompo.iterator();
		while (iterReporteCompo.hasNext()) {
			ReporteContaCompo reporteContaCompo = (ReporteContaCompo) iterReporteCompo.next();
			valoresComponentes.put(reporteContaCompo.getComponente(), reporteContaCompo.getValorcomponente());
		}
		return valoresComponentes;
	}

	public void addItemReporte(ReporteContaCompo itemReporteCompo) throws BaseException {
		itemReporteCompo.setReportecontadet(this);
		itemsReporteContaCompo.add(itemReporteCompo);
	}

	public static ReporteContableDet getReporteContableDetByRepyTitu(Integer oidRepConta, Integer oidTitu, ISesion aSesion)
			throws BaseException {
		return DBReporteContableDet.getReporteContableDetByRepyTitu(oidRepConta, oidTitu, aSesion);
	}

	public ReporteContableDet getReporteContableDetPadre() throws BaseException {
		return ReporteContableDet.getReporteContableDetByRepyTitu(this.getReporteContable().getOIDInteger(), this.getOidtitulopadre(), this
				.getSesion());
	}

	public static List getSoloTitulosReporte(ReporteContable reporteContable, ISesion aSesion) throws BaseException {
		return DBReporteContableDet.getSoloTitulosReporte(reporteContable, aSesion);
	}

	public String getDescripcionJerarquia() throws BaseException {

		StringBuffer desc = new StringBuffer("");
		desc.append(this.getDescripcion());

		ReporteContableDet reporteContableDet = this.getReporteContableDetPadre();
		while (reporteContableDet != null) {
			desc.insert(0, reporteContableDet.getDescripcion() + Util.ENTER());
			reporteContableDet = reporteContableDet.getReporteContableDetPadre();
		}

		return desc.toString();
	}

	public static List getSoloReporteDetCtaActiva(ReporteContable reporteContable, Cuenta cuenta, ISesion aSesion) throws BaseException {
		return DBReporteContableDet.getSoloReporteDetCtaActiva(reporteContable, cuenta, aSesion);
	}

	public ReporteContaCompo getReporteContaCompo(Componente compo) throws BaseException {
		return ReporteContaCompo.getReporteContaCompo(this, compo, this.getSesion());

	}

	public static int getMaxOidTituReporte(ReporteContable reporte, ISesion sesion) throws BaseException {

		return DBReporteContableDet.getMaxOidTituReporte(reporte, sesion);

	}

}
