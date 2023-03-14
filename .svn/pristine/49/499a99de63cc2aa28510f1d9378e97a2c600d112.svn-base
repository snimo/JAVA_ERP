package com.srn.erp.tesoreria.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ChequeTercero extends ValorBase {

	public ChequeTercero() {
	}

	public void beforeSave() throws BaseException {
		validarDatosChequePropio();
	}

	public void validarDatosChequePropio() throws BaseException {
		if (this.getTipoOper().equals(ChequeTercero.ENTRADA)) {
			if (getTipoValor() == null)
				throw new ExceptionValidation(null, "Debe ingresar el tipo de Valor");
			if (getBanco() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Banco");
			if (getNroCheque() == null)
				throw new ExceptionValidation(null, "Debe ingresar el nro. de cheque");
			if (getFechaEmision() == null)
				throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión");
			if (getFechaVencimiento() == null)
				throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento");
			if (getImporte() == null)
				throw new ExceptionValidation(null, "Debe ingresar el Importe");
		}
	}
	
	private void anularSalidaChequeTecero() throws BaseException {

		this.getChequeTercero().supportRefresh();
		this.getChequeTercero().setEndosado(false);
		if (this.getChequeTercero().getTipovalor().isSeguimientoCaja())
			this.getChequeTercero().setEstaencaja(new Boolean(true));
		else
			this.getChequeTercero().setEstaencaja(new Boolean(false));
		this.getChequeTercero().save();		
		
		// Que ingrese en la caja que figura el cheque
		setCaja(this.getChequeTercero().getCaja());
		setTipoValor(this.getChequeTercero().getTipovalor());
		setImporte(this.getChequeTercero().getImporte());
		setCotizMonOri(this.getChequeTercero().getCotizacion());
	}

	public void save() throws BaseException {

		if (this.getTipoOper().equals(ENTRADA)) {
			
			if (this.isAnulacionOP()) {
				anularSalidaChequeTecero();
			} else {

				beforeSave();
				this.setChequeTercero((Valor) Valor.getNew(Valor.NICKNAME, getSesion()));
				this.getChequeTercero().setTipovalor(getTipoValor());
				this.getChequeTercero().setBanco(getBanco());
				this.getChequeTercero().setNrocheque(getNroCheque());
				this.getChequeTercero().setCaja(this.getCaja());
				this.getChequeTercero().setFechaemision(getFechaEmision());
				this.getChequeTercero().setFechavto(getFechaVencimiento());
				this.getChequeTercero().setAnulado(new Boolean(false));
				this.getChequeTercero().setEndosado(new Boolean(false));
				this.getChequeTercero().setDepositado(new Boolean(false));
				this.getChequeTercero().setCUIT(getCUIT());
				this.getChequeTercero().setRechazado(new Boolean(false));
				this.getChequeTercero().setCobrado(new Boolean(false));
				this.getChequeTercero().setRecibido(new Boolean(false));
				this.getChequeTercero().setLiquidado(new Boolean(false));
				this.getChequeTercero().setSujeto(this.getSujeto());
				this.getChequeTercero().setImporte(getImporte());
				this.getChequeTercero().setSaldo(getImporte());
				if (this.getTipoValor().isSeguimientoCaja())
					this.getChequeTercero().setEstaencaja(new Boolean(true));
				else
					this.getChequeTercero().setEstaencaja(new Boolean(false));
				this.getChequeTercero().setUsuario(getSesion().getLogin().getUsuario());
				this.getChequeTercero().setCotizacion(getCotizMonOri());
				this.getChequeTercero().save();
			}
		} else {
			if (this.depositar())
				depositoChequeCliente();
			else if (this.isDevolucion())
				devolverChequeAlCliente();
			else if (this.isEndosar())
				endosarChequeCliente();

		}
		afterSave();
	}

	private void depositoChequeCliente() throws BaseException {
		// Marcar el cheque como depositado
		this.getChequeTercero().supportRefresh();
		this.getChequeTercero().setDepositarCheque(true);
		this.getChequeTercero().setEstaencaja(new Boolean(false));
		this.getChequeTercero().save();
	}

	private void endosarChequeCliente() throws BaseException {
		// Marcar el cheque como depositado
		this.getChequeTercero().supportRefresh();
		this.getChequeTercero().setEndosado(new Boolean(true));
		this.getChequeTercero().setEstaencaja(new Boolean(false));
		this.getChequeTercero().save();
	}

	private void devolverChequeAlCliente() throws BaseException {
		// Marcar el cheque como depositado
		this.getChequeTercero().supportRefresh();
		this.getChequeTercero().setDevuelto(true);
		this.getChequeTercero().setEstaencaja(new Boolean(false));
		this.getChequeTercero().save();
	}

	public void afterSave() throws BaseException {
		
		if ((getTipoValor()!=null) && (getTipoValor().isSeguimientoCaja().booleanValue()==false))
			return;
		
		if ((this.getChequeTercero()!=null) && (this.getChequeTercero().getTipovalor()!=null) && (this.getChequeTercero().getTipovalor().isSeguimientoCaja().booleanValue()==false))
			return;
		
		movimientoArqueo();
		
	}

	private void movimientoArqueo() throws BaseException {
		MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME, getSesion());

		movCaja.setComprobante(getComprobante());

		movCaja.setValor(this.getChequeTercero());
		if (getTipoOper().equals(ENTRADA)) {
			movCaja.setFechacaja(getCaja().getFechaCaja());
			movCaja.setCaja(getCaja());
			movCaja.setSigno(new Integer(1));
			movCaja.setEntrada(getImporte());
			movCaja.setSalida(new Money(0));
			movCaja.setImporte(getImporte());
			movCaja.setMoneda(getTipoValor().getMoneda());
			movCaja.setCompotipovalor(getTipoValor().getCompo());
			movCaja.setTipovalor(getTipoValor());
			movCaja.setSujeto(getSujeto());
		} else {
			if (this.getChequeTercero() == null)
				throw new ExceptionValidation(null, "No pudo encontrarse el cheque");
			movCaja.setCaja(this.getChequeTercero().getCaja());
			movCaja.setFechacaja(this.getChequeTercero().getCaja().getFechaCaja());
			movCaja.setSigno(new Integer(-1));
			movCaja.setEntrada(new Money(0));
			movCaja.setSalida(this.getChequeTercero().getImporte());
			movCaja.setImporte(this.getChequeTercero().getImporte());
			movCaja.setMoneda(this.getChequeTercero().getTipovalor().getMoneda());
			movCaja.setCompotipovalor(this.getChequeTercero().getTipovalor().getCompo());
			movCaja.setTipovalor(this.getChequeTercero().getTipovalor());
		}

		movCaja.setCotizacion(getCotizMonOri());
		movCaja.setFechaReal(Fecha.getFechaActual());
		movCaja.setHora(Fecha.getHoraActual());
		movCaja.setUsuario(this.getSesion().getLogin().getUsuario());
		movCaja.setActivo(new Boolean(true));
		movCaja.save();

	}

}
