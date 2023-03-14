package com.srn.erp.ctasAPagar.bm;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasACobrar.da.DBTranClieVto;
import com.srn.erp.ctasAPagar.da.DBTranProvVto;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class TranProvVto extends ObjetoLogico {

	private boolean esNuevo = false;

	public TranProvVto() {
	}

	public static String NICKNAME = "cap.TranProvVto";

	private TranProv tranProv;

	private java.util.Date vencimiento;

	private Money importe;

	private Money saldo;

	private Moneda moneda;

	private Boolean pendiente;

	private boolean grabarAutorizacion = false;

	private java.util.Date fecConfPago;

	private Integer nroCuota;

	public void setGrabarAutorizacion(boolean aGrabarAutorizacion) throws BaseException {
		this.grabarAutorizacion = aGrabarAutorizacion;
	}

	public boolean grabarAutorizacion() throws BaseException {
		return grabarAutorizacion;
	}

	public TranProv getTranprov() throws BaseException {
		supportRefresh();
		return tranProv;
	}

	public java.util.Date getFecConfPago() throws BaseException {
		supportRefresh();
		return this.fecConfPago;
	}

	public int getSigno() throws BaseException {
		if (importe.doubleValue() >= 0)
			return 1;
		else
			return -1;
	}

	public void setTranprov(TranProv aTranprov) {
		this.tranProv = aTranprov;
	}

	public void setFecConfPago(java.util.Date aFecConfPago) {
		this.fecConfPago = aFecConfPago;
	}

	public java.util.Date getVencimiento() throws BaseException {
		supportRefresh();
		return vencimiento;
	}

	public void setVencimiento(java.util.Date aVencimiento) {
		this.vencimiento = aVencimiento;
	}

	public Integer getNroCuota() throws BaseException {
		supportRefresh();
		return this.nroCuota;
	}

	public void setNroCuota(Integer aNroCuota) {
		this.nroCuota = aNroCuota;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public Money getSaldo() throws BaseException {
		supportRefresh();
		return saldo;
	}

	public void setSaldo(Money aSaldo) {
		this.saldo = aSaldo;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Boolean isPendiente() throws BaseException {
		supportRefresh();
		return pendiente;
	}

	public void setPendiente(Boolean aPendiente) {
		this.pendiente = aPendiente;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TranProvVto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TranProvVto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TranProvVto findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TranProvVto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TranProvVto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TranProvVto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return null;
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	public void beforeSave() throws BaseException {
		if (this.isNew())
			esNuevo = true;
		else
			esNuevo = false;
	}

	public void afterSave() throws BaseException {
		if (esNuevo)
			grabarAutorizacionCuota();
	}

	private void grabarAutorizacionCuota() throws BaseException {
		// Grabar si se encuentra o no autorizado
		if (grabarAutorizacion()) {
			grabarAutorizComproProv();
		}

	}

	private void grabarAutorizComproProv() throws BaseException {
		AutorizacionFactProv autorizFactProv = (AutorizacionFactProv) AutorizacionFactProv.getNew(AutorizacionFactProv.NICKNAME,
				getSesion());
		autorizFactProv.setTranprovVto(this);
		autorizFactProv.setComproCab(this.getTranprov().getComprobante());
		if (this.requiereAutorizacion()) {
			autorizFactProv.setPorcautoriz(new Money(0));
			autorizFactProv.setMontoautoriz(new Money(0));
			autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
		} else {
			autorizFactProv.setPorcautoriz(new Money(100));
			autorizFactProv.setMontoautoriz(new Money(importe.doubleValue()*-1));
			autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.AUTORIZADA));
		}
		autorizFactProv.setUsuario(getSesion().getLogin().getUsuario());
		autorizFactProv.setFecautoriz(Fecha.getFechaActual());
		autorizFactProv.setActivo(new Boolean(true));
		autorizFactProv.save();
	}

	private boolean requiereAutorizacion() throws BaseException {
		ValorParametro valorParamAutoriz = ValorParametro.findByCodigoParametro("AUTORIZ_FACT_PROV_AUTOMATICA", getSesion());
		return (!valorParamAutoriz.getBoolean());
	}

	public AutorizacionFactProv getAutorizacionFactProv() throws BaseException {
		return AutorizacionFactProv.getAutorizByTranProvVto(this, getSesion());
	}

	public static void cambiarFechaConfirmacionPago(TranProvVto tranProvVto, java.util.Date fecha, ISesion aSesion) throws BaseException {
		DBTranProvVto.cambiarFechaConfirmacionPago(tranProvVto, fecha , aSesion);
	}
	
	public java.util.Date getFechaCF() throws BaseException {
		if (this.getFecConfPago()!=null)
			return this.getFecConfPago();
		else
			return this.getVencimiento();
	}


}
