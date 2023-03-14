package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ValorLiquidacionTarjeta extends ValorBase {

	public ValorLiquidacionTarjeta() {
	}

	public void beforeSave() throws BaseException {
		validarDatosValorLiquidacionTarjeta();
	}

	public void validarDatosValorLiquidacionTarjeta() throws BaseException {
		if (getTipoValor() == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de Valor");
		if (getFechaEmision() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión");
		if (getFechaVencimiento() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento");		
		if (getImporte() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Importe");
		
		if (this.getTipoValor().isLiquidacionTarjetaCredito())
			if (this.getTarjetCredito()==null)
				throw new ExceptionValidation(null,"Debe ingresar la Tarjeta de Crédito");
	}

	public void save() throws BaseException {

		if (this.getTipoOper().equals(ENTRADA)) {

			if (this.isAnulacionOP()) {
				anularSalidaCuponPorOP();
			} else {
				beforeSave();
				setValorLiquidacionTarjeta((Valor) Valor.getNew(Valor.NICKNAME, getSesion()));
				this.getValorLiquidacionTarjeta().setTipovalor(getTipoValor());
				this.getValorLiquidacionTarjeta().setCaja(this.getCaja());
				this.getValorLiquidacionTarjeta().setFechaemision(getFechaEmision());
				this.getValorLiquidacionTarjeta().setFechavto(getFechaVencimiento());
				this.getValorLiquidacionTarjeta().setAnulado(new Boolean(false));
				this.getValorLiquidacionTarjeta().setEndosado(new Boolean(false));
				this.getValorLiquidacionTarjeta().setDepositado(new Boolean(false));
				this.getValorLiquidacionTarjeta().setRechazado(new Boolean(false));
				this.getValorLiquidacionTarjeta().setCobrado(new Boolean(false));
				this.getValorLiquidacionTarjeta().setRecibido(new Boolean(false));
				this.getValorLiquidacionTarjeta().setLiquidado(new Boolean(false));
				this.getValorLiquidacionTarjeta().setImporte(getImporte());
				this.getValorLiquidacionTarjeta().setSaldo(getImporte());
				if (this.getValorLiquidacionTarjeta().getTipovalor().isSeguimientoCaja())
					this.getValorLiquidacionTarjeta().setEstaencaja(new Boolean(true));
				else 
					this.getValorLiquidacionTarjeta().setEstaencaja(new Boolean(false));
				this.getValorLiquidacionTarjeta().setUsuario(getSesion().getLogin().getUsuario());
				this.getValorLiquidacionTarjeta().setCotizacion(getCotizMonOri());
				this.getValorLiquidacionTarjeta().setNrocheque(this.getComprobante().getNroExt());
				this.getValorLiquidacionTarjeta().setNro_valor(this.getComprobante().getNroExt());
				this.getValorLiquidacionTarjeta().setTarjetacredito(this.getTarjetCredito());
				this.getValorLiquidacionTarjeta().save();
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
