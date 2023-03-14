package com.srn.erp.tesoreria.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class TransferenciaBancariaCliente extends ValorBase {

	public TransferenciaBancariaCliente() {
	}

	public void beforeSave() throws BaseException {
		validarDatosChequePropio();
	}

	public void validarDatosChequePropio() throws BaseException {
		if (getTipoValor() == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de Valor");
		if (this.getCuentaBancaria() == null)
			throw new ExceptionValidation(null, "Debe ingresar la cuenta bancaria");
		if (this.getNro() == null)
			throw new ExceptionValidation(null, "Debe ingresar el nro. de Transferencia");
		if (getFechaEmision() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión");
		if (getFechaVencimiento() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento");
		if (getImporte() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Importe");
	}

	public void save() throws BaseException {

		if (getTipoOper().equals(MovimientoCtaBancaria.TRANS_BANCA_CLIE)) {
			beforeSave();
			setTransBancariaCliente((Valor) Valor.getNew(Valor.NICKNAME, getSesion()));
			
			this.getTransBancariaCliente().setTipovalor(getTipoValor());
			this.getTransBancariaCliente().setCuentabancaria(getCuentaBancaria());
			this.getTransBancariaCliente().setNro_valor(getNro());
			this.getTransBancariaCliente().setFechaemision(getFechaEmision());
			this.getTransBancariaCliente().setFechavto(getFechaVencimiento());
			this.getTransBancariaCliente().setAnulado(new Boolean(false));
			this.getTransBancariaCliente().setEndosado(new Boolean(false));
			this.getTransBancariaCliente().setDepositado(new Boolean(true));
			this.getTransBancariaCliente().setRechazado(new Boolean(false));
			this.getTransBancariaCliente().setCobrado(new Boolean(false));
			this.getTransBancariaCliente().setRecibido(new Boolean(false));
			this.getTransBancariaCliente().setLiquidado(new Boolean(false));
			this.getTransBancariaCliente().setImporte(getImporte());
			this.getTransBancariaCliente().setSaldo(getImporte());
			this.getTransBancariaCliente().setEstaencaja(new Boolean(false));
			this.getTransBancariaCliente().setUsuario(getSesion().getLogin().getUsuario());
			this.getTransBancariaCliente().setCotizacion(getCotizMonOri());
			this.getTransBancariaCliente().setSujeto(getSujeto());
		} else if (getTipoOper().equals(MovimientoCtaBancaria.ANULACION_RECIBO)) {
			this.getTransBancariaCliente().setAnulado(true);
		}
		
		getTransBancariaCliente().save();
		afterSave();

	}

	public void afterSave() throws BaseException {

		if (this.getTipoOper().equals(MovimientoCtaBancaria.TRANS_BANCA_CLIE)) {
			OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
			operacionCuentaBancaria.setSesion(getSesion());
			operacionCuentaBancaria.setCtaBancaria(getCuentaBancaria());
			operacionCuentaBancaria.setNroValor(this.getNro());
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.TRANS_BANCA_CLIE);
			operacionCuentaBancaria.setFechaContable(getFechaContable());
			operacionCuentaBancaria.setFechaEmision(getFechaEmision());
			operacionCuentaBancaria.setFechaVto(getFechaVencimiento());
			operacionCuentaBancaria.setSigno(new Integer(1));
			operacionCuentaBancaria.setImporte(getImporte());
			operacionCuentaBancaria.setComprobante(getComprobante());
			operacionCuentaBancaria.setImporteHist(getImporteHist());
			operacionCuentaBancaria.setImporteAju(getImporteAju());
			operacionCuentaBancaria.setImporteExt1(getImporteExt1());
			operacionCuentaBancaria.setImporteExt2(getImporteExt2());
			operacionCuentaBancaria.setActivo(new Boolean(true));
			operacionCuentaBancaria.setCotizMonOri(getCotizMonOri());
			operacionCuentaBancaria.setCotizMonExt1(getCotizMonExt1());
			operacionCuentaBancaria.setCotizMonExt2(getCotizMonExt2());
			operacionCuentaBancaria.setCotizMonOriCon(getCotizMonOriCon());
			operacionCuentaBancaria.setCotizMonExt1Con(getCotizMonExt1Con());
			operacionCuentaBancaria.setCotizMonExt2Con(getCotizMonExt2Con());
			operacionCuentaBancaria.setTipoValor(getTipoValor());
			operacionCuentaBancaria.setValor(this.getTransBancariaCliente());
			operacionCuentaBancaria.save();
		} else if (this.getTipoOper().equals(MovimientoCtaBancaria.ANULACION_RECIBO)) {
			OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
			operacionCuentaBancaria.setSesion(getSesion());
			
			operacionCuentaBancaria.setCtaBancaria(this.getTransBancariaCliente().getCuentabancaria());
			operacionCuentaBancaria.setNroValor(this.getTransBancariaCliente().getNro_valor());
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.ANULACION_RECIBO);
			
			operacionCuentaBancaria.setFechaContable(this.getComprobante().getImputac());;
			operacionCuentaBancaria.setFechaEmision(this.getComprobante().getEmision());
			operacionCuentaBancaria.setFechaVto(this.getComprobante().getImputac());
			operacionCuentaBancaria.setSigno(new Integer(-1));
			
			// Buscar datos del Movimiento en el banco
			MovimientoCtaBancaria movCtaBanco = 
				MovimientoCtaBancaria.getMovByCuentaSignoValor(this.getTransBancariaCliente().getCuentabancaria(),new Integer(1),this.getTransBancariaCliente(),this.getSesion());
			operacionCuentaBancaria.setImporte(movCtaBanco.getImporte());
			operacionCuentaBancaria.setComprobante(getComprobante());
			operacionCuentaBancaria.setImporteHist(movCtaBanco.getImportehist());
			operacionCuentaBancaria.setImporteAju(movCtaBanco.getImporteaju());
			operacionCuentaBancaria.setImporteExt1(movCtaBanco.getImporteext1());
			operacionCuentaBancaria.setImporteExt2(movCtaBanco.getImporteext2());
			operacionCuentaBancaria.setActivo(new Boolean(true));
			operacionCuentaBancaria.setCotizMonOri(movCtaBanco.getCotizMonOri());
			operacionCuentaBancaria.setCotizMonExt1(movCtaBanco.getCotizMonExt1());
			operacionCuentaBancaria.setCotizMonExt2(movCtaBanco.getCotizMonExt2());
			operacionCuentaBancaria.setCotizMonOriCon(movCtaBanco.getCotizMonOriCon());
			operacionCuentaBancaria.setCotizMonExt1Con(movCtaBanco.getCotizMonExt1Con());
			operacionCuentaBancaria.setCotizMonExt2Con(movCtaBanco.getCotizMonExt2Con());
			operacionCuentaBancaria.setTipoValor(this.getTransBancariaCliente().getTipovalor());
			operacionCuentaBancaria.setValor(this.getTransBancariaCliente());
			operacionCuentaBancaria.save();
		}
		
	}

}
