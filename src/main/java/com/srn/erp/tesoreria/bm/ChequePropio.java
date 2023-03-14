package com.srn.erp.tesoreria.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ChequePropio extends ValorBase {

	public ChequePropio() {
	}

	public void beforeSave() throws BaseException {
		validarDatosChequePropio();
	}

	public void validarDatosChequePropio() throws BaseException {
		if (getTipoValor() == null)
			throw new ExceptionValidation(null, "Debe ingresar el tipo de Valor");
		if (getCuentaBancaria() == null)
			throw new ExceptionValidation(null, "Debe ingresar la cuenta bancaria");
		if (getNroCheque() == null)
			throw new ExceptionValidation(null, "Debe ingresar el nro. de cheque");
		if (getFechaEmision() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión");
		if (getFechaVencimiento() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento");
		if (getImporte() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Importe");
	}

	public void save() throws BaseException {

		if (getTipoOper().equals(MovimientoCtaBancaria.EMISION_CHE_PROP)) {
			beforeSave();
			setChequePropio((Valor) Valor.getNew(Valor.NICKNAME, getSesion()));
			getChequePropio().setTipovalor(getTipoValor());
			getChequePropio().setCuentabancaria(getCuentaBancaria());
			getChequePropio().setNrocheque(getNroCheque());
			getChequePropio().setFechaemision(getFechaEmision());
			getChequePropio().setFechavto(getFechaVencimiento());
			getChequePropio().setAnulado(new Boolean(false));
			getChequePropio().setEndosado(new Boolean(false));
			getChequePropio().setDepositado(new Boolean(false));
			getChequePropio().setRechazado(new Boolean(false));
			getChequePropio().setCobrado(new Boolean(false));
			getChequePropio().setRecibido(new Boolean(false));
			getChequePropio().setLiquidado(new Boolean(false));
			getChequePropio().setImporte(getImporte());
			getChequePropio().setSaldo(getImporte());
			getChequePropio().setEstaencaja(new Boolean(false));
			getChequePropio().setUsuario(getSesion().getLogin().getUsuario());
			getChequePropio().setCotizacion(getCotizMonOri());
			getChequePropio().setProveedor(getProveedor());
		} else if (getTipoOper().equals(MovimientoCtaBancaria.ANULACION_OP)) {
			getChequePropio().setAnulado(true);
		}
		getChequePropio().save();
		afterSave();

	}

	public void afterSave() throws BaseException {

		if (this.getTipoOper().equals(MovimientoCtaBancaria.EMISION_CHE_PROP)) {
			OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
			operacionCuentaBancaria.setSesion(getSesion());
			operacionCuentaBancaria.setCtaBancaria(getCuentaBancaria());
			operacionCuentaBancaria.setNroValor(getNroCheque());
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.EMISION_CHE_PROP);
			operacionCuentaBancaria.setFechaContable(getFechaContable());
			operacionCuentaBancaria.setFechaEmision(getFechaEmision());
			operacionCuentaBancaria.setFechaVto(getFechaVencimiento());
			operacionCuentaBancaria.setSigno(new Integer(-1));
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
			operacionCuentaBancaria.setValor(this.getChequePropio());
			operacionCuentaBancaria.save();
		} else if (this.getTipoOper().equals(MovimientoCtaBancaria.ANULACION_OP)) {
			
			// Buscar el Movimiento de Cuenta
						
			OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
			operacionCuentaBancaria.setSesion(getSesion());
			operacionCuentaBancaria.setValor(this.getChequePropio());
			operacionCuentaBancaria.setCtaBancaria(this.getChequePropio().getCuentabancaria());
			operacionCuentaBancaria.setNroValor(this.getChequePropio().getNrocheque());
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.ANULACION_OP);
			operacionCuentaBancaria.setFechaContable(getComprobante().getEmision());
			operacionCuentaBancaria.setFechaEmision(this.getChequePropio().getFechaemision());
			operacionCuentaBancaria.setFechaVto(this.getChequePropio().getFechavto());
			operacionCuentaBancaria.setSigno(new Integer(1));
			
			MovimientoCtaBancaria movinCta = 
				this.getChequePropio().getCuentabancaria().getMovCuentaByCuentaValorSalida(this.getChequePropio());
			
			if (movinCta == null)
				throw new ExceptionValidation(null,"No se pudo encontrar el movimiento de salida en el Banco del valor "+this.getChequePropio().getDescripcion());
			
			operacionCuentaBancaria.setImporte(movinCta.getImporte());
			operacionCuentaBancaria.setComprobante(getComprobante());
			operacionCuentaBancaria.setImporteHist(movinCta.getImportehist());
			operacionCuentaBancaria.setImporteAju(movinCta.getImporteaju());
			operacionCuentaBancaria.setImporteExt1(movinCta.getImporteext1());
			operacionCuentaBancaria.setImporteExt2(movinCta.getImporteext2());
			operacionCuentaBancaria.setActivo(new Boolean(true));
			operacionCuentaBancaria.setCotizMonOri(movinCta.getCotizMonOri());
			operacionCuentaBancaria.setCotizMonExt1(movinCta.getCotizMonExt1());
			operacionCuentaBancaria.setCotizMonExt2(movinCta.getCotizMonExt2());
			operacionCuentaBancaria.setCotizMonOriCon(movinCta.getCotizMonOriCon());
			operacionCuentaBancaria.setCotizMonExt1Con(movinCta.getCotizMonExt1Con());
			operacionCuentaBancaria.setCotizMonExt2Con(movinCta.getCotizMonExt2Con());
			operacionCuentaBancaria.setTipoValor(this.getChequePropio().getTipovalor());
			operacionCuentaBancaria.save();
			
		}

	}

}
