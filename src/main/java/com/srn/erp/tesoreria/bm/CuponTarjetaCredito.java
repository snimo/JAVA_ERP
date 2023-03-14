package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CuponTarjetaCredito extends ValorBase {

	public CuponTarjetaCredito() {
	}

	public void beforeSave() throws BaseException {
		validarDatosChequePropio();
	}

	public void validarDatosChequePropio() throws BaseException {
		if (getTipoValor() == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de Valor");
		if (getFechaEmision() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión");
		if (getFechaVencimiento() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento");
		if (getImporte() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Importe");
		if (getTarjetCredito() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Tarjeta de Crédito");

	}

	public void save() throws BaseException {

		if (this.getTipoOper().equals(ENTRADA)) {

			if (this.isAnulacionOP()) {
				anularSalidaCuponPorOP();
			} else {
				beforeSave();
				setCuponTarjetaCredito((Valor) Valor.getNew(Valor.NICKNAME, getSesion()));
				this.getCuponTarjetaCredito().setTipovalor(getTipoValor());
				this.getCuponTarjetaCredito().setCaja(this.getCaja());
				this.getCuponTarjetaCredito().setFechaemision(getFechaEmision());
				this.getCuponTarjetaCredito().setFechavto(getFechaVencimiento());
				this.getCuponTarjetaCredito().setAnulado(new Boolean(false));
				this.getCuponTarjetaCredito().setEndosado(new Boolean(false));
				this.getCuponTarjetaCredito().setDepositado(new Boolean(false));
				this.getCuponTarjetaCredito().setRechazado(new Boolean(false));
				this.getCuponTarjetaCredito().setCobrado(new Boolean(false));
				this.getCuponTarjetaCredito().setRecibido(new Boolean(false));
				this.getCuponTarjetaCredito().setLiquidado(new Boolean(false));
				this.getCuponTarjetaCredito().setSujeto(this.getSujeto());
				this.getCuponTarjetaCredito().setImporte(getImporte());
				this.getCuponTarjetaCredito().setSaldo(getImporte());
				if (this.getTipoValor().isSeguimientoCaja())
					this.getCuponTarjetaCredito().setEstaencaja(new Boolean(true));
				else 
					this.getCuponTarjetaCredito().setEstaencaja(new Boolean(false));
				this.getCuponTarjetaCredito().setUsuario(getSesion().getLogin().getUsuario());
				this.getCuponTarjetaCredito().setCotizacion(getCotizMonOri());
				this.getCuponTarjetaCredito().setLote(this.getLote());
				this.getCuponTarjetaCredito().setCupon(this.getNroCupon());
				this.getCuponTarjetaCredito().setNro_tarjeta(this.getNroTarjeta());
				this.getCuponTarjetaCredito().setTarjetacredito(this.getTarjetCredito());
				this.getCuponTarjetaCredito().setCuotas(this.getCuotas());
				this.getCuponTarjetaCredito().setCodigoAutorizacion(this.getCodigoAutorizacion());
				this.getCuponTarjetaCredito().save();
			}
		} else {
			if (this.depositar())
				depositarTarjetaCredito();
			else if (this.isDevolucion())
				devolverTarjetaCredito();
			else if (this.isEndosar())
				endosarTarjetaCredito();
			else if (this.isLiquidando())
				liquidandoCupones();
			
		}
		afterSave();
	}

	private void devolverTarjetaCredito() throws BaseException {
		// Marcar el cheque como depositado
		this.getCuponTarjetaCredito().supportRefresh();
		this.getCuponTarjetaCredito().setDevuelto(true);
		this.getCuponTarjetaCredito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaCredito().save();
	}

	private void anularSalidaCuponPorOP() throws BaseException {
		this.getCuponTarjetaCredito().supportRefresh();
		if (this.getTipoValor().isSeguimientoCaja())
			this.getCuponTarjetaCredito().setEstaencaja(new Boolean(true));
		else
			this.getCuponTarjetaCredito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaCredito().setEndosado(false);
		this.getCuponTarjetaCredito().save();

	}
	
	private void endosarTarjetaCredito() throws BaseException {
		this.getCuponTarjetaCredito().supportRefresh();
		this.getCuponTarjetaCredito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaCredito().setEndosado(true);
		this.getCuponTarjetaCredito().save();
	}
	
	private void liquidandoCupones() throws BaseException {
		
		this.getCuponTarjetaCredito().supportRefresh();

		// Calcular al Saldo del Valor
		CalculadorMoney calcNuevoSaldo = new CalculadorMoney(this.getCuponTarjetaCredito().getSaldo());
		calcNuevoSaldo.restar(getImporteValorALiquidar());
		if (calcNuevoSaldo.getResultMoney().doubleValue()<=0.1) {
			this.getCuponTarjetaCredito().setLiquidado(true);
			this.getCuponTarjetaCredito().setSaldo(new Money(0));
			this.getCuponTarjetaCredito().setEstaencaja(new Boolean(false));
		} else this.getCuponTarjetaCredito().setSaldo(calcNuevoSaldo.getResultMoney());
		
		this.getCuponTarjetaCredito().save();
	}	

	private void depositarTarjetaCredito() throws BaseException {
		// Marcar el cheque como depositado
		this.getCuponTarjetaCredito().supportRefresh();
		this.getCuponTarjetaCredito().setDepositado(new Boolean(true));
		this.getCuponTarjetaCredito().setEstaencaja(new Boolean(false));
		this.getCuponTarjetaCredito().save();
	}

	public void afterSave() throws BaseException {
		
		if ((this.getTipoValor()!=null) && (this.getTipoValor().isSeguimientoCaja()!=null) && (this.getTipoValor().isSeguimientoCaja().booleanValue() == false))
			return;
		
		if ((this.getCuponTarjetaCredito()!=null) && (this.getCuponTarjetaCredito().getTipovalor()!=null) && (this.getCuponTarjetaCredito().getTipovalor().isSeguimientoCaja()==false))
			return;
		
		movimientoArqueo();
	}

	private void movimientoArqueo() throws BaseException {
		MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME, getSesion());
		if (getTipoOper().equals(ENTRADA)) {

			movCaja.setCaja(getCaja());
			movCaja.setComprobante(getComprobante());
			movCaja.setFechacaja(getCaja().getFechaCaja());
			movCaja.setValor(this.getCuponTarjetaCredito());
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

			movCaja.setCaja(this.getCuponTarjetaCredito().getCaja());
			movCaja.setComprobante(getComprobante());
			movCaja.setFechacaja(this.getCuponTarjetaCredito().getCaja().getFechaCaja());
			movCaja.setValor(this.getCuponTarjetaCredito());

			movCaja.setSigno(new Integer(-1));
			movCaja.setEntrada(new Money(0));
			movCaja.setSalida(this.getCuponTarjetaCredito().getImporte());
			movCaja.setImporte(this.getCuponTarjetaCredito().getImporte());
			movCaja.setMoneda(this.getCuponTarjetaCredito().getTipovalor().getMoneda());
			movCaja.setTipovalor(this.getCuponTarjetaCredito().getTipovalor());
			movCaja.setCompotipovalor(this.getCuponTarjetaCredito().getTipovalor().getCompo());
			movCaja.setCotizacion(this.getCuponTarjetaCredito().getCotizacion());
			movCaja.setFechaReal(Fecha.getFechaActual());
			movCaja.setHora(Fecha.getHoraActual());
			movCaja.setUsuario(this.getSesion().getLogin().getUsuario());
			movCaja.setActivo(new Boolean(true));

		}
		movCaja.save();

	}

}
