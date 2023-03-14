package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.tesoreria.da.DBTransferenciaValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TransferenciaValor extends ObjetoLogico {

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		saveMovTransferencia();		
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TransferenciaValor() {
	}

	public static String					NICKNAME	= "te.TransferenciaValor";

	private Valor									valor;

	private Money									importe;

	private TransferenciaValores	transferencia_valores;

	private Money									transferido;

	public Valor getValor() throws BaseException {
		supportRefresh();
		return valor;
	}

	public void setValor(Valor aValor) {
		this.valor = aValor;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public TransferenciaValores getTransferencia_valores() throws BaseException {
		supportRefresh();
		return transferencia_valores;
	}

	public void setTransferencia_valores(TransferenciaValores aTransferencia_valores) {
		this.transferencia_valores = aTransferencia_valores;
	}

	public Money getTransferido() throws BaseException {
		supportRefresh();
		return transferido;
	}

	public void setTransferido(Money aTransferido) {
		this.transferido = aTransferido;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TransferenciaValor findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TransferenciaValor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TransferenciaValor findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TransferenciaValor) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TransferenciaValor findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TransferenciaValor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(valor, "Debe ingresar el Valor");
		Validar.noNulo(importe, "Debe ingresar el Importe");
		Validar.noNulo(transferencia_valores, "Debe ingresar la Transferencia");
	}

	public static List getTransferenciasValor(TransferenciaValores transferencia, ISesion aSesion) throws BaseException {
		return DBTransferenciaValor.getTransferenciasValor(transferencia, aSesion);
	}
	
	private void saveMovTransferencia() throws BaseException {
		movimientoSalidaCajaOrigen();
		movimientoEntradaCajaDestino();
		ponerValorEnCajaDestino();
	}
	
	private void ponerValorEnCajaDestino() throws BaseException {
		Valor.cambiarCaja(this.getValor(),
											this.getTransferencia_valores().getCajaDestino(),
											this.getSesion());
	}

	private void movimientoSalidaCajaOrigen() throws BaseException {
		MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME, getSesion());
		movCaja.setCaja(this.getTransferencia_valores().getCajaOrigen());
		movCaja.setComprobante(this.getTransferencia_valores());
		movCaja.setFechacaja(this.getTransferencia_valores().getCajaOrigen().getFechaCaja());
		movCaja.setValor(this.getValor());
		movCaja.setSigno(new Integer(-1));
		movCaja.setEntrada(new Money(0));
		movCaja.setSalida(this.getValor().getImporte());
		movCaja.setImporte(this.getValor().getImporte());
		movCaja.setMoneda(this.getValor().getTipovalor().getMoneda());
		movCaja.setTipovalor(this.getValor().getTipovalor());
		movCaja.setCompotipovalor(this.getValor().getTipovalor().getCompo());
		movCaja.setCotizacion(this.getTransferencia_valores().getCotizacionMoneda(
				this.getValor().getTipovalor().getMoneda()));
		movCaja.setFechaReal(Fecha.getFechaActual());
		movCaja.setHora(Fecha.getHoraActual());
		movCaja.setUsuario(this.getSesion().getLogin().getUsuario());
		movCaja.setActivo(new Boolean(true));
		movCaja.save();
	}
	
	private void movimientoEntradaCajaDestino() throws BaseException {
		MovimientoCaja movCaja = (MovimientoCaja) MovimientoCaja.getNew(MovimientoCaja.NICKNAME, getSesion());
		movCaja.setCaja(this.getTransferencia_valores().getCajaDestino());
		movCaja.setComprobante(this.getTransferencia_valores());
		movCaja.setFechacaja(this.getTransferencia_valores().getCajaDestino().getFechaCaja());
		movCaja.setValor(this.getValor());
		movCaja.setSigno(new Integer(1));
		movCaja.setEntrada(this.getValor().getImporte());
		movCaja.setSalida(new Money(0));
		movCaja.setImporte(this.getValor().getImporte());
		movCaja.setMoneda(this.getValor().getTipovalor().getMoneda());
		movCaja.setTipovalor(this.getValor().getTipovalor());
		movCaja.setCompotipovalor(this.getValor().getTipovalor().getCompo());
		movCaja.setCotizacion(this.getTransferencia_valores().getCotizacionMoneda(
				this.getValor().getTipovalor().getMoneda()));
		movCaja.setFechaReal(Fecha.getFechaActual());
		movCaja.setHora(Fecha.getHoraActual());
		movCaja.setUsuario(this.getSesion().getLogin().getUsuario());
		movCaja.setActivo(new Boolean(true));
		movCaja.save();
	}
	

}
