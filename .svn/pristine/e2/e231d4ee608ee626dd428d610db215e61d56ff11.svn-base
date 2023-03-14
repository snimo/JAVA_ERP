package com.srn.erp.ctasACobrar.bm;

import com.srn.erp.ctasACobrar.da.DBTranClieVto;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TranClieVto extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		return this.getTran_clie().getSujeto().getRazon_social()+" "+this.getTran_clie().getComprobante().getCodigo();
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TranClieVto() {
	}

	public static String NICKNAME = "cac.TranClieVto";

	private TranClie tran_clie;
	private java.util.Date vto;
	private Money importe;
	private Money saldo;
	private Moneda moneda;
	private Boolean pendiente;
	private Integer nroCuota;
	private java.util.Date fechaConfirmacionCobro;

	public TranClie getTran_clie() throws BaseException {
		supportRefresh();
		return tran_clie;
	}

	public void setTran_clie(TranClie aTran_clie) {
		this.tran_clie = aTran_clie;
	}

	public java.util.Date getFechaConfirmacionCobro() throws BaseException {
		supportRefresh();
		return this.fechaConfirmacionCobro;
	}

	public void setFechaConfirmacionCobror(java.util.Date aFechaConfirmacionCobro) {
		this.fechaConfirmacionCobro = aFechaConfirmacionCobro;
	}

	public Integer getNroCuota() throws BaseException {
		supportRefresh();
		return this.nroCuota;
	}

	public void setNroCuota(Integer aNroCuota) {
		this.nroCuota = aNroCuota;
	}

	public java.util.Date getVto() throws BaseException {
		supportRefresh();
		return vto;
	}

	public void setVto(java.util.Date aVto) {
		this.vto = aVto;
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

	public static TranClieVto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TranClieVto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TranClieVto findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TranClieVto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TranClieVto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TranClieVto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tran_clie, "Debe ingresar la Transacción Cliente");
		Validar.noNulo(vto, "Debe ingresat el Vto");
		Validar.noNulo(importe, "Debe ingresar el Importe");
		Validar.noNulo(saldo, "Debe ingresar el Saldo");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
	}

	public static void cambiarFechaConfirmacionCobro(TranClieVto tranClieVto, java.util.Date fecha, ISesion aSesion) throws BaseException {
		DBTranClieVto.cambiarFechaConfirmacionCobro(tranClieVto, fecha, aSesion);
	}

	public void cambiarFechaConfirmacionCobro(java.util.Date fecha, ISesion aSesion) throws BaseException {
		DBTranClieVto.cambiarFechaConfirmacionCobro(this, fecha, this.getSesion());
	}
	
	public java.util.Date getFechaCF() throws BaseException {
		if (this.getFechaConfirmacionCobro()!=null)
			return this.getFechaConfirmacionCobro();
		else
			return this.getVto();
	}
	

}
