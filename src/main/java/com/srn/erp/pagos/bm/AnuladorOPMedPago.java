package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.pagos.da.DBAnuladorOPMedPago;
import com.srn.erp.tesoreria.bm.MedioPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorOPMedPago extends ObjetoLogico {

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void anulacionTarjetaCredito() throws BaseException {

		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setOidOPMedioPago(null);
		medioPago.setFechaContable(this.getAnulador_op_cab().getImputac());
		medioPago.setTipoValor(this.getMedio_pago().getTipovalor());
		medioPago.setIsAnulacionOP(true);
		medioPago.setComprobante(this.getAnulador_op_cab());
		medioPago.setIngresoEgreso(MedioPago.INGRESO);
		medioPago.setFecEmision(this.getAnulador_op_cab().getEmision());
		medioPago.setImporteMonedaPago(this.getMedio_pago().getImpomonpago());
		medioPago.setImporteMonedaValor(this.getMedio_pago().getImpomonvalor());
		medioPago.setCotizMonedaValor(new ValorCotizacion(this.getMedio_pago().getCotizacion()));
		medioPago.setCaja(this.getMedio_pago().getCaja());
		medioPago.setImportesContables(null);
		medioPago.setValor(this.getMedio_pago().getValor());
		medioPago.save();
		
		
	}
	
	private void anulacionTarjetaDebito() throws BaseException {

		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setOidOPMedioPago(null);
		medioPago.setFechaContable(this.getAnulador_op_cab().getImputac());
		medioPago.setTipoValor(this.getMedio_pago().getTipovalor());
		medioPago.setIsAnulacionOP(true);
		medioPago.setComprobante(this.getAnulador_op_cab());
		medioPago.setIngresoEgreso(MedioPago.INGRESO);
		medioPago.setFecEmision(this.getAnulador_op_cab().getEmision());
		medioPago.setImporteMonedaPago(this.getMedio_pago().getImpomonpago());
		medioPago.setImporteMonedaValor(this.getMedio_pago().getImpomonvalor());
		medioPago.setCotizMonedaValor(new ValorCotizacion(this.getMedio_pago().getCotizacion()));
		medioPago.setCaja(this.getMedio_pago().getCaja());
		medioPago.setImportesContables(null);
		medioPago.setValor(this.getMedio_pago().getValor());
		medioPago.save();
		
		
	}
	

	private void anulacionChequeCliente() throws BaseException {
		
		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setOidOPMedioPago(null);
		medioPago.setFechaContable(this.getAnulador_op_cab().getImputac());
		medioPago.setTipoValor(this.getMedio_pago().getTipovalor());
		medioPago.setIsAnulacionOP(true);
		medioPago.setComprobante(this.getAnulador_op_cab());
		medioPago.setIngresoEgreso(MedioPago.INGRESO);
		medioPago.setFecEmision(this.getAnulador_op_cab().getEmision());
		medioPago.setImporteMonedaPago(this.getMedio_pago().getImpomonpago());
		medioPago.setImporteMonedaValor(this.getMedio_pago().getImpomonvalor());
		medioPago.setCotizMonedaValor(new ValorCotizacion(this.getMedio_pago().getCotizacion()));
		medioPago.setCaja(this.getMedio_pago().getCaja());
		medioPago.setImportesContables(null);
		medioPago.setValor(this.getMedio_pago().getValor());
		medioPago.save();
		
	}
	
	private void anulacionChequePropio() throws BaseException {
		
		// Hacer un Movimiento de Ingreso en el Banco
		MedioPago medioPago = new MedioPago();
		medioPago.setCaja(null);
		medioPago.setSesion(getSesion());
		medioPago.setTipoValor(this.getMedio_pago().getTipovalor());
		medioPago.setComprobante(this.getAnulador_op_cab());
		medioPago.setIngresoEgreso(MedioPago.INGRESO);
		medioPago.setFechaContable(this.getAnulador_op_cab().getEmision());
		medioPago.setValor(this.getMedio_pago().getValor());
		medioPago.setImporteMonedaValor(this.getMedio_pago().getValor().getImporte());
		medioPago.setCotizMonedaValor(new ValorCotizacion(this.getMedio_pago().getCotizacion()));
		medioPago.setIsAnulacionOP(true);
		medioPago.save();
		
		
	}
	

	private void anulacionEfectivo() throws BaseException {

		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setComprobante(this.getAnulador_op_cab());
		medioPago.setIngresoEgreso(MedioPago.INGRESO);
		medioPago.setSujeto(null);
		medioPago.setOidOPMedioPago(null);
		medioPago.setFechaContable(this.getAnulador_op_cab().getImputac());
		medioPago.setTipoValor(this.getMedio_pago().getTipovalor());
		medioPago.setFecEmision(this.getAnulador_op_cab().getEmision());
		medioPago.setImporteMonedaPago(this.getMedio_pago().getImpomonpago());
		medioPago.setImporteMonedaValor(this.getMedio_pago().getImpomonvalor());
		medioPago.setCotizMonedaValor(new ValorCotizacion(this.getMedio_pago().getCotizacion()));
		medioPago.setCaja(this.getMedio_pago().getCaja());
		medioPago.setImportesContables(null);
		medioPago.save();

	}

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();

		if (this.getMedio_pago().getTipovalor().isEfectivo()) {
			// Volver a ingresar el efectivo a la caja
			anulacionEfectivo();
		} else if (this.getMedio_pago().getTipovalor().isChequeCliente() || this.getMedio_pago().getTipovalor().isChequeTercero()) {
			anulacionChequeCliente();
		} else if (this.getMedio_pago().getTipovalor().isChequePropio()) {
			anulacionChequePropio();
		} else if (this.getMedio_pago().getTipovalor().isTarjetaCredito()) {
			anulacionTarjetaCredito();
		}  else if (this.getMedio_pago().getTipovalor().isCuponTarjetaDebito()) {
			anulacionTarjetaDebito();
		}
			

	}
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorOPMedPago() {
	}

	public static String NICKNAME = "pag.AnuladorOPMedPago";

	private AnuladorOrdenDePago anulador_op_cab;
	private ComproOrdenPagoMediosPago medio_pago;

	public AnuladorOrdenDePago getAnulador_op_cab() throws BaseException {
		supportRefresh();
		return anulador_op_cab;
	}

	public void setAnulador_op_cab(AnuladorOrdenDePago aAnulador_op_cab) {
		this.anulador_op_cab = aAnulador_op_cab;
	}

	public ComproOrdenPagoMediosPago getMedio_pago() throws BaseException {
		supportRefresh();
		return medio_pago;
	}

	public void setMedio_pago(ComproOrdenPagoMediosPago aMedio_pago) {
		this.medio_pago = aMedio_pago;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorOPMedPago findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorOPMedPago) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorOPMedPago findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AnuladorOPMedPago) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(anulador_op_cab, "Debe ingresar el Anulador Orden de Pago");
		Validar.noNulo(medio_pago, "Debe ingresar el Medio de Pago");
	}

	public static List getAnuladoresMediosPago(AnuladorOrdenDePago anuladorOP, ISesion aSesion) throws BaseException {
		return DBAnuladorOPMedPago.getAnuladoresMediosPago(anuladorOP, aSesion);
	}

}
