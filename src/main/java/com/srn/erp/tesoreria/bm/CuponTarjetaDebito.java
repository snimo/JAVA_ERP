package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CuponTarjetaDebito extends ValorBase {

	public static String ENTRADA = "ENTRADA";

	public static String SALIDA = "SALIDA";

	public CuponTarjetaDebito() {
	}

	public void beforeSave() throws BaseException {
		validarDatosChequePropio();
	}

	public void validarDatosChequePropio() throws BaseException {
		if (getTipoValor() == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de Valor");
		if (getFechaEmision() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisién");
		if (getFechaVencimiento() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento");
		if (getImporte() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Importe");
	}

	public void save() throws BaseException {

		if (this.getTipoOper().equals(ENTRADA)) {
			

			if (this.isAnulacionOP()) {
				anularSalidaCuponPorOP();
			} else {
				beforeSave();
				this.setCuponTarjetaDebito((Valor) Valor.getNew(Valor.NICKNAME, getSesion()));
				this.getCuponTarjetaDebito().setTipovalor(getTipoValor());
				this.getCuponTarjetaDebito().setCaja(this.getCaja());
				this.getCuponTarjetaDebito().setFechaemision(getFechaEmision());
				this.getCuponTarjetaDebito().setFechavto(getFechaVencimiento());
				this.getCuponTarjetaDebito().setAnulado(new Boolean(false));
				this.getCuponTarjetaDebito().setEndosado(new Boolean(false));
				this.getCuponTarjetaDebito().setDepositado(new Boolean(false));
				this.getCuponTarjetaDebito().setRechazado(new Boolean(false));
				this.getCuponTarjetaDebito().setCobrado(new Boolean(false));
				this.getCuponTarjetaDebito().setRecibido(new Boolean(false));
				this.getCuponTarjetaDebito().setLiquidado(new Boolean(false));
				this.getCuponTarjetaDebito().setSujeto(this.getSujeto());
				this.getCuponTarjetaDebito().setImporte(getImporte());
				this.getCuponTarjetaDebito().setSaldo(getImporte());
				if (this.getTipoValor().isSeguimientoCaja())
					this.getCuponTarjetaDebito().setEstaencaja(new Boolean(true));
				else
					this.getCuponTarjetaDebito().setEstaencaja(new Boolean(false));
				this.getCuponTarjetaDebito().setUsuario(getSesion().getLogin().getUsuario());
				this.getCuponTarjetaDebito().setCotizacion(getCotizMonOri());
				this.getCuponTarjetaDebito().setLote(this.getLote());
				this.getCuponTarjetaDebito().setCupon(this.getNroCupon());
				this.getCuponTarjetaDebito().setNro_tarjeta(this.getNroTarjeta());
				this.getCuponTarjetaDebito().setTarjetacredito(this.getTarjetCredito());
				this.getCuponTarjetaDebito().setCuotas(this.getCuotas());
				this.getCuponTarjetaDebito().setBanco(this.getBanco());
				this.getCuponTarjetaDebito().setNro_valor(this.getNro());
				this.getCuponTarjetaDebito().setCodigoAutorizacion(this.getCodigoAutorizacion());
				this.getCuponTarjetaDebito().save();
			}
		} else {
			if (this.depositar())
				depositarTarjetaDebito();
			else if (this.isDevolucion())
				devolverTarjetaDebito();
			else if (this.isEndosar())
				endosarTarjetaDebito();

		}
		afterSave();
	}
	
	private void anularSalidaCuponPorOP() throws BaseException {
		this.getCuponTarjetaDebito().supportRefresh();
		if (this.getTipoValor().isSeguimientoCaja())
			this.getCuponTarjetaDebito().setEstaencaja(new Boolean(true));
		else
			this.getCuponTarjetaDebito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaDebito().setEndosado(false);
		this.getCuponTarjetaDebito().save();
		
	}

	private void endosarTarjetaDebito() throws BaseException {
		this.getCuponTarjetaDebito().supportRefresh();
		this.getCuponTarjetaDebito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaDebito().setEndosado(true);
		this.getCuponTarjetaDebito().save();

	}

	private void devolverTarjetaDebito() throws BaseException {
		// Marcar el cheque como depositado
		this.getCuponTarjetaDebito().supportRefresh();
		this.getCuponTarjetaDebito().setDevuelto(true);
		this.getCuponTarjetaDebito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaDebito().save();
	}

	private void depositarTarjetaDebito() throws BaseException {
		// Marcar el cheque como depositado
		this.getCuponTarjetaDebito().supportRefresh();
		this.getCuponTarjetaDebito().setDepositado(new Boolean(true));
		this.getCuponTarjetaDebito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaDebito().save();
	}

	public void afterSave() throws BaseException {
		if ((this.getTipoValor()!=null) && (this.getTipoValor().isSeguimientoCaja()!=null) && (this.getTipoValor().isSeguimientoCaja().booleanValue() == false))
			return;
		
		if ((this.getCuponTarjetaDebito()!=null) && (this.getCuponTarjetaDebito().getTipovalor()!=null) && (this.getCuponTarjetaDebito().getTipovalor().isSeguimientoCaja()!=null) && (this.getCuponTarjetaDebito().getTipovalor().isSeguimientoCaja().booleanValue()==false))
			return;
		
		movimientoArqueo();
	}

	private void movimientoArqueo() throws BaseException {
		MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME, getSesion());
		if (getTipoOper().equals(ENTRADA)) {
			movCaja.setCaja(getCaja());
			movCaja.setComprobante(getComprobante());
			movCaja.setFechacaja(getCaja().getFechaCaja());
			movCaja.setValor(this.getCuponTarjetaDebito());
			movCaja.setSujeto(getSujeto());
			movCaja.setSigno(new Integer(1));
			movCaja.setEntrada(getImporte());
			movCaja.setSalida(new Money(0));
			movCaja.setImporte(getImporte());
			movCaja.setMoneda(getTipoValor().getMoneda());
			movCaja.setTipovalor(getTipoValor());
			movCaja.setCompotipovalor(getTipoValor().getCompo());
			movCaja.setCotizacion(getCotizMonOri());
			movCaja.setFechaReal(Fecha.getFechaActual());
			movCaja.setHora(Fecha.getHoraActual());
			movCaja.setUsuario(this.getSesion().getLogin().getUsuario());
			movCaja.setActivo(new Boolean(true));
		} else {
			movCaja.setCaja(this.getCuponTarjetaDebito().getCaja());
			movCaja.setComprobante(getComprobante());
			movCaja.setFechacaja(this.getCuponTarjetaDebito().getCaja().getFechaCaja());
			movCaja.setValor(this.getCuponTarjetaDebito());

			movCaja.setSigno(new Integer(-1));
			movCaja.setEntrada(new Money(0));
			movCaja.setSalida(this.getCuponTarjetaDebito().getImporte());
			movCaja.setImporte(this.getCuponTarjetaDebito().getImporte());
			movCaja.setMoneda(this.getCuponTarjetaDebito().getTipovalor().getMoneda());
			movCaja.setTipovalor(this.getCuponTarjetaDebito().getTipovalor());
			movCaja.setCompotipovalor(this.getCuponTarjetaDebito().getTipovalor().getCompo());
			movCaja.setCotizacion(this.getCuponTarjetaDebito().getCotizacion());
			movCaja.setFechaReal(Fecha.getFechaActual());
			movCaja.setHora(Fecha.getHoraActual());
			movCaja.setUsuario(this.getSesion().getLogin().getUsuario());
			movCaja.setActivo(new Boolean(true));
		}
		movCaja.save();

	}

}
