package com.srn.erp.tesoreria.bm;

import java.util.Date;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoMediosPago;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoMedioPago;
import com.srn.erp.ventas.bm.CobranzaVtaMostrador;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class MedioPago {

	public static final int INGRESO = 1;
	public static final int EGRESO = 2;

	private boolean devolucion;
	private boolean endosar;
	private int ingreso_egreso;
	private Integer oidOPMedioPago;
	private TipoValor tipoValor;
	private Integer oidEntidad;
	private Integer nro_cheque;
	private java.util.Date fecEmision;
	private java.util.Date fecVencimiento;
	private java.util.Date fecContable;
	private Money importeMonedaValor;
	private Money importeMonedaPago;
	private ValorCotizacion cotizMonedaValor;
	private ValorCotizacion cotizMonedaPago;
	private ISesion sesion;
	private ComproCab comproCab;
	private ImportesContables importesContables;
	private Caja caja;
	private Sujeto sujeto;
	private Proveedor proveedor;
	private Integer lote;
	private Integer cupon;
	private Integer cuotas;
	private String nroTarjeta;
	private TarjetaCredito tarjetaCredito;
	private Ticket ticket;
	private Integer nro;
	private Banco banco;
	private Valor valor;
	private boolean depositar;
	private String nroCertificado;
	private Provincia provincia;
	private String codigoAutorizacion;
	private boolean anulado;
	private String cuit;
	private boolean isAnulacionOP;
	private boolean isAnulacionRecibo;
	private Valor valorGrabado;
	private boolean liquidar;
	private boolean seEstaLiquidando;
	private Money importeALiquidar;

	public void setDevolucion(boolean aDevolucion) throws BaseException {
		this.devolucion = aDevolucion;
	}
	
	public void setValorGrabado(Valor aValorGrabado) throws BaseException {
		this.valorGrabado = aValorGrabado;
	}
	
	public Valor getValorGrabado() throws BaseException {
		return this.valorGrabado; 
	}
	
	public void setImporteALiquidar(Money aImporteALiquidar) throws BaseException {
		this.importeALiquidar = aImporteALiquidar;
	}
	
	public Money getImporteALiquidar() throws BaseException {
		return this.importeALiquidar; 
	}	

	public void setEndosar(boolean aEndosar) throws BaseException {
		this.endosar = aEndosar;
	}

	public void setIsAnulacionOP(boolean aIsAnulacionOP) throws BaseException {
		this.isAnulacionOP = aIsAnulacionOP;
	}
	
	public void setIsAnulacionRecibo(boolean aIsAnulacionRecibo) throws BaseException {
		this.isAnulacionRecibo = aIsAnulacionRecibo;
	}

	public boolean isAnulacionOP() throws BaseException {
		return this.isAnulacionOP;
	}
	
	public boolean isAnulacionRecibo() throws BaseException {
		return this.isAnulacionRecibo;
	}
	
	
	public boolean isLiquidando() throws BaseException {
		return this.seEstaLiquidando; 
	}
	
	public void setEstaLiquidando(boolean aSeEstaLiquidando) throws BaseException {
		this.seEstaLiquidando = aSeEstaLiquidando;
	}

	public boolean isDevolucion() throws BaseException {
		return this.devolucion;
	}

	public boolean isEndosar() throws BaseException {
		return this.endosar;
	}

	public void setAnulado(boolean aAnulado) throws BaseException {
		this.anulado = aAnulado;
	}

	public boolean isAnulado() throws BaseException {
		return this.anulado;
	}

	public void setCUIT(String aCUIT) throws BaseException {
		this.cuit = aCUIT;
	}

	public String getCUIT() throws BaseException {
		return cuit;
	}

	public void setDepositar(boolean aDepositar) throws BaseException {
		this.depositar = aDepositar;
	}
	
	public void setLiquidar(boolean aLiquidar) throws BaseException {
		this.liquidar = aLiquidar;
	}
	
	public boolean liquidar() throws BaseException {
		return this.liquidar;
	}

	public boolean depositarCheque() throws BaseException {
		return depositar;
	}

	public void setProvincia(Provincia aProvincia) throws BaseException {
		this.provincia = aProvincia;
	}

	public Provincia getProvincia() throws BaseException {
		return this.provincia;
	}

	public void setCodigoAutorizacion(String acodigoAutorizacion) throws BaseException {
		this.codigoAutorizacion = acodigoAutorizacion;
	}

	public String getCodigoAutorizacion() throws BaseException {
		return this.codigoAutorizacion;
	}

	public void setNroCertificado(String aNroCertificado) throws BaseException {
		this.nroCertificado = aNroCertificado;
	}

	public String getNroCertificado() throws BaseException {
		return this.nroCertificado;
	}

	public void setCaja(Caja aCaja) throws BaseException {
		this.caja = aCaja;
	}

	public Caja getCaja() throws BaseException {
		return this.caja;
	}
	

	public void setValor(Valor aValor) throws BaseException {
		this.valor = aValor;
	}
	
	public Valor getValor() throws BaseException {
		return this.valor;
	}

	public void setNro(Integer aNro) throws BaseException {
		this.nro = aNro;
	}

	public Integer getNro() throws BaseException {
		return this.nro;
	}

	public void setTicket(Ticket aTicket) throws BaseException {
		this.ticket = aTicket;
	}

	public Ticket getTicket() throws BaseException {
		return this.ticket;
	}

	public void setTarjetaCredito(TarjetaCredito aTarjetaCredito) throws BaseException {
		this.tarjetaCredito = aTarjetaCredito;
	}

	public TarjetaCredito getTarjetaCredito() throws BaseException {
		return this.tarjetaCredito;
	}

	public void setNroTarjeta(String aNroTarjeta) throws BaseException {
		this.nroTarjeta = aNroTarjeta;
	}

	public String getNroTarjeta() throws BaseException {
		return this.nroTarjeta;
	}

	public void setLote(Integer aLote) throws BaseException {
		this.lote = aLote;
	}

	public Integer getLote() throws BaseException {
		return this.lote;
	}

	public void setCupon(Integer aCupon) throws BaseException {
		this.cupon = aCupon;
	}

	public Integer getCupon() throws BaseException {
		return this.cupon;
	}

	public void setCuotas(Integer aCuotas) throws BaseException {
		this.cuotas = aCuotas;
	}

	public Integer getCuotas() throws BaseException {
		return this.cuotas;
	}

	public void setSujeto(Sujeto aSujeto) throws BaseException {
		this.sujeto = aSujeto;
	}

	public Sujeto getSujeto() throws BaseException {
		return this.sujeto;
	}
	
	public void setProveedor(Proveedor aProveedor) throws BaseException {
		this.proveedor = aProveedor;
	}

	public Proveedor getProveedor() throws BaseException {
		return this.proveedor;
	}
	

	public void setIngresoEgreso(int aIngresoEgreso) throws BaseException {
		this.ingreso_egreso = aIngresoEgreso;
	}

	public int getIngresoEgreso() throws BaseException {
		return this.ingreso_egreso;
	}

	public void setOidOPMedioPago(Integer oidOPMedioPago) {
		this.oidOPMedioPago = oidOPMedioPago;
	}

	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	public void setOidEntidad(Integer oidEntidad) {
		this.oidEntidad = oidEntidad;
	}

	public void setFechaContable(java.util.Date aFechaContable) throws BaseException {
		fecContable = aFechaContable;
	}

	public void setNro_cheque(Integer nro_cheque) {
		this.nro_cheque = nro_cheque;
	}

	public void setFecVencimiento(Date fecVencimiento) {
		this.fecVencimiento = fecVencimiento;
	}

	public void setFecEmision(Date fecEmision) {
		this.fecEmision = fecEmision;
	}

	public void setImporteMonedaValor(Money importeMonedaValor) {
		this.importeMonedaValor = importeMonedaValor;
	}

	public void setImporteMonedaPago(Money importeMonedaPago) {
		this.importeMonedaPago = importeMonedaPago;
	}

	public void setCotizMonedaPago(ValorCotizacion cotizMonedaPago) {
		this.cotizMonedaPago = cotizMonedaPago;
	}

	public void setCotizMonedaValor(ValorCotizacion cotizMonedaValor) {
		this.cotizMonedaValor = cotizMonedaValor;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}

	public void setComprobante(ComproCab aComproCab) {
		this.comproCab = aComproCab;
	}

	public void setImportesContables(ImportesContables importesContables) {
		this.importesContables = importesContables;
	}

	public Integer getOidOPMedioPago() {
		return oidOPMedioPago;
	}

	public TipoValor getTipoValor() throws BaseException {
		if (tipoValor != null)
			return tipoValor;
		else if (getValor() != null)
			return this.getValor().getTipovalor();
		else
			return null;
	}

	public Integer getOidEntidad() {
		return oidEntidad;
	}

	public java.util.Date getFechaContable() throws BaseException {
		return fecContable;
	}

	public Integer getNro_cheque() {
		return nro_cheque;
	}

	public Date getFecVencimiento() {
		return fecVencimiento;
	}

	public Date getFecEmision() {
		return fecEmision;
	}

	public Money getImporteMonedaValor() {
		return importeMonedaValor;
	}

	public Money getImporteMonedaPago() {
		return importeMonedaPago;
	}

	public ValorCotizacion getCotizMonedaPago() {
		return cotizMonedaPago;
	}

	public ValorCotizacion getCotizMonedaValor() {
		return cotizMonedaValor;
	}

	public ISesion getSesion() {
		return sesion;
	}

	public ComproCab getComproCab() {
		return this.comproCab;
	}

	public ImportesContables getImportesContables() {
		return importesContables;
	}

	public MedioPago() throws BaseException {
	}
	
	public Valor grabarTransferenciaClieBanco() throws BaseException {

		TransferenciaBancariaCliente transfBancariaCliente = new TransferenciaBancariaCliente();
		if (getIngresoEgreso() == MedioPago.INGRESO) {
			
			transfBancariaCliente.setSesion(this.getSesion());
			transfBancariaCliente.setTipoOper(MovimientoCtaBancaria.TRANS_BANCA_CLIE);
			transfBancariaCliente.setTipoValor(getTipoValor());
			transfBancariaCliente.setCuentaBancaria(CuentaBancaria.findByOidProxy(getOidEntidad(), getSesion()));
			if (getNro()!=null)
				transfBancariaCliente.setNro(getNro());
			else if (getNro_cheque()!=null)
				transfBancariaCliente.setNro(getNro_cheque());
			transfBancariaCliente.setFechaEmision(getFecEmision());
			transfBancariaCliente.setFechaVencimiento(getFecVencimiento());
			transfBancariaCliente.setFechaContable(getFechaContable());
			transfBancariaCliente.setImporte(getImporteMonedaValor());
			transfBancariaCliente.setComprobante(getComproCab());
			transfBancariaCliente.setImporteHist(getImportesContables().getImpoMonLoc());
			transfBancariaCliente.setImporteAju(getImportesContables().getImpoMonLocAju());
			transfBancariaCliente.setImporteExt1(getImportesContables().getImpoMonExt1());
			transfBancariaCliente.setImporteExt2(getImportesContables().getImpoMonExt2());
			transfBancariaCliente.setCotizMonOri(getCotizMonedaValor());
			transfBancariaCliente.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
			transfBancariaCliente.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
			transfBancariaCliente.setCotizMonOriCon(getCotizMonedaValor());
			transfBancariaCliente.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
			transfBancariaCliente.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
			transfBancariaCliente.setAnulado(this.isAnulado());
			transfBancariaCliente.setSujeto(this.getSujeto());
			transfBancariaCliente.save();
		} else {

			if (this.isAnulacionRecibo()) {
				transfBancariaCliente.setSesion(getSesion());
				transfBancariaCliente.setTipoOper(MovimientoCtaBancaria.ANULACION_RECIBO);
				transfBancariaCliente.setTransBancariaCliente(this.getValor());
				transfBancariaCliente.setFechaContable(getFechaContable());
				transfBancariaCliente.setAnulado(true);
				transfBancariaCliente.setComprobante(getComproCab());
				transfBancariaCliente.save();
			} else
				throw new ExceptionValidation(null, "No puede realizarse una operación de egreso de una Transferencia de Cliente");
			
			
		}
		return transfBancariaCliente.getTransBancariaCliente();
	}

		
	public Valor grabarChequePropio() throws BaseException {
		ChequePropio chequePropio = new ChequePropio();
		if (getIngresoEgreso() == MedioPago.INGRESO) {
			if (this.isAnulacionOP()) {
				chequePropio.setSesion(getSesion());
				chequePropio.setTipoOper(MovimientoCtaBancaria.ANULACION_OP);
				chequePropio.setChequePropio(this.getValor());
				chequePropio.setFechaContable(getFechaContable());
				chequePropio.setAnulado(true);
				chequePropio.setComprobante(getComproCab());
				chequePropio.save();
			} else
				throw new ExceptionValidation(null, "No puede realizarse una operación de ingreso de un cheque propio");

		} else {

			chequePropio.setSesion(getSesion());
			chequePropio.setTipoOper(MovimientoCtaBancaria.EMISION_CHE_PROP);
			chequePropio.setTipoValor(getTipoValor());
			chequePropio.setCuentaBancaria(CuentaBancaria.findByOidProxy(getOidEntidad(), getSesion()));
			chequePropio.setNroCheque(getNro_cheque());
			chequePropio.setFechaEmision(getFecEmision());
			chequePropio.setFechaVencimiento(getFecVencimiento());
			chequePropio.setFechaContable(getFechaContable());
			chequePropio.setImporte(getImporteMonedaValor());
			chequePropio.setComprobante(getComproCab());
			chequePropio.setImporteHist(getImportesContables().getImpoMonLoc());
			chequePropio.setImporteAju(getImportesContables().getImpoMonLocAju());
			chequePropio.setImporteExt1(getImportesContables().getImpoMonExt1());
			chequePropio.setImporteExt2(getImportesContables().getImpoMonExt2());
			chequePropio.setCotizMonOri(getCotizMonedaValor());
			chequePropio.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
			chequePropio.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
			chequePropio.setCotizMonOriCon(getCotizMonedaValor());
			chequePropio.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
			chequePropio.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
			chequePropio.setAnulado(this.isAnulado());
			chequePropio.setProveedor(getProveedor());
			chequePropio.save();
		}

		return chequePropio.getChequePropio();
	}

	public Valor grabarCuponTarCred() throws BaseException {

		return null;
	}

	public Valor grabarChequeTercero() throws BaseException {

		ChequeTercero chequeTercero = new ChequeTercero();
		chequeTercero.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {
			chequeTercero.setTipoOper(ChequeTercero.ENTRADA);

			if (this.isAnulacionOP()) {
				chequeTercero.setEndosar(false);
				chequeTercero.setChequeTercero(this.getValor());
				chequeTercero.setIsAnulacionOP(this.isAnulacionOP());
			} else {

				chequeTercero.setChequeTercero(this.getValor());
				chequeTercero.setCaja(this.getCaja());
				chequeTercero.setTipoValor(getTipoValor());
				chequeTercero.setBanco(Banco.findByOidProxy(getOidEntidad(), getSesion()));
				chequeTercero.setCUIT(getCUIT());
				chequeTercero.setNroCheque(getNro_cheque());
				chequeTercero.setFechaEmision(getFecEmision());
				chequeTercero.setFechaVencimiento(getFecVencimiento());
				chequeTercero.setFechaContable(getFechaContable());
				chequeTercero.setImporte(getImporteMonedaValor());
				if (getImportesContables() != null) {
					chequeTercero.setImporteHist(getImportesContables().getImpoMonLoc());
					chequeTercero.setImporteAju(getImportesContables().getImpoMonLocAju());
					chequeTercero.setImporteExt1(getImportesContables().getImpoMonExt1());
					chequeTercero.setImporteExt2(getImportesContables().getImpoMonExt2());
				}
				chequeTercero.setCotizMonOri(getCotizMonedaValor());
				chequeTercero.setSujeto(getSujeto());
				if (getImportesContables() != null) {
					chequeTercero.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
					chequeTercero.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
					chequeTercero.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
					chequeTercero.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
				}
				chequeTercero.setIsAnulacionOP(this.isAnulacionOP());
			}
		} else {
			chequeTercero.setChequeTercero(this.getValor());
			chequeTercero.setTipoOper(ChequeTercero.SALIDA);
			chequeTercero.setCotizMonOri(getCotizMonedaValor());
			if (this.depositarCheque())
				chequeTercero.setDepositarCheque(true);
			else if (this.isDevolucion())
				chequeTercero.setDevolucion(true);
			else if (this.isEndosar())
				chequeTercero.setEndosar(true);

		}
		chequeTercero.setComprobante(getComproCab());
		chequeTercero.setAnulado(this.isAnulado());

		chequeTercero.save();

		return chequeTercero.getChequeTercero();
	}
	
	public Valor grabarLiquidacionTarjteCredito() throws BaseException {
		ValorLiquidacionTarjetaCredito valorLiquidacion = new ValorLiquidacionTarjetaCredito();
		valorLiquidacion.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {
			valorLiquidacion.setTipoOper(ValorLiquidacionTarjetaCredito.ENTRADA);
			valorLiquidacion.setValorLiquidacionTarjeta(this.getValor());
			valorLiquidacion.setCaja(this.getCaja());
			valorLiquidacion.setTipoValor(this.getTipoValor());
			valorLiquidacion.setTarjetaCredito(this.getTarjetaCredito());
			valorLiquidacion.setNroCheque(this.getComproCab().getNroExt());
			valorLiquidacion.setNro(this.getComproCab().getNroExt());
			valorLiquidacion.setFechaEmision(getFecEmision());
			valorLiquidacion.setFechaVencimiento(getFecVencimiento());
			valorLiquidacion.setFechaContable(getFechaContable());
			valorLiquidacion.setImporte(getImporteMonedaValor());
			valorLiquidacion.setImporteHist(getImportesContables().getImpoMonLoc());
			valorLiquidacion.setImporteAju(getImportesContables().getImpoMonLocAju());
			valorLiquidacion.setImporteExt1(getImportesContables().getImpoMonExt1());
			valorLiquidacion.setImporteExt2(getImportesContables().getImpoMonExt2());
			valorLiquidacion.setCotizMonOri(getCotizMonedaValor());
			valorLiquidacion.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
			valorLiquidacion.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
			valorLiquidacion.setCotizMonOriCon(getCotizMonedaValor());
			valorLiquidacion.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
			valorLiquidacion.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
			valorLiquidacion.setIsAnulacionOP(false);
			
			valorLiquidacion.setComprobante(getComproCab());
			valorLiquidacion.setAnulado(this.isAnulado());
			valorLiquidacion.save();
			
		}
		
		return valorLiquidacion.getValorLiquidacionTarjeta();
	}

	public Valor grabarChequeCliente() throws BaseException {

		ChequeCliente chequeCliente = new ChequeCliente();
		chequeCliente.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {
			chequeCliente.setTipoOper(ChequeCliente.ENTRADA);

			if (this.isAnulacionOP()) {
				chequeCliente.setEndosar(false);
				chequeCliente.setChequeTercero(this.getValor());
				chequeCliente.setIsAnulacionOP(this.isAnulacionOP());
			} else {

				chequeCliente.setChequeTercero(this.getValor());
				chequeCliente.setCaja(this.getCaja());
				chequeCliente.setTipoValor(getTipoValor());
				chequeCliente.setBanco(Banco.findByOidProxy(getOidEntidad(), getSesion()));
				chequeCliente.setNroCheque(getNro_cheque());
				chequeCliente.setCUIT(getCUIT());
				chequeCliente.setFechaEmision(getFecEmision());
				chequeCliente.setFechaVencimiento(getFecVencimiento());
				chequeCliente.setFechaContable(getFechaContable());
				chequeCliente.setImporte(getImporteMonedaValor());
				chequeCliente.setImporteHist(getImportesContables().getImpoMonLoc());
				chequeCliente.setImporteAju(getImportesContables().getImpoMonLocAju());
				chequeCliente.setImporteExt1(getImportesContables().getImpoMonExt1());
				chequeCliente.setImporteExt2(getImportesContables().getImpoMonExt2());
				chequeCliente.setCotizMonOri(getCotizMonedaValor());
				chequeCliente.setSujeto(getSujeto());
				chequeCliente.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
				chequeCliente.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
				chequeCliente.setCotizMonOriCon(getCotizMonedaValor());
				chequeCliente.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
				chequeCliente.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
				chequeCliente.setIsAnulacionOP(this.isAnulacionOP());
			}
		} else {
			chequeCliente.setChequeTercero(this.getValor());
			chequeCliente.setTipoOper(ChequeCliente.SALIDA);
			chequeCliente.setCotizMonOri(getCotizMonedaValor());
			if (this.depositarCheque())
				chequeCliente.setDepositarCheque(true);
			else if (this.isDevolucion())
				chequeCliente.setDevolucion(true);
			else if (this.isEndosar())
				chequeCliente.setEndosar(true);
		}
		chequeCliente.setComprobante(getComproCab());
		chequeCliente.setAnulado(this.isAnulado());
		chequeCliente.save();

		return chequeCliente.getChequeTercero();
	}

	public Valor grabarCertificadoRetencionGan() throws BaseException {

		CertificadoRetencionGanancias certificado = new CertificadoRetencionGanancias();
		certificado.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {
			certificado.setTipoOper(CertificadoRetencionGanancias.ENTRADA);
			certificado.setCaja(this.getCaja());
			certificado.setTipoValor(getTipoValor());
			certificado.setFechaEmision(getFecEmision());
			certificado.setFechaContable(getFechaContable());
			certificado.setImporte(getImporteMonedaValor());
			certificado.setComprobante(getComproCab());
			certificado.setImporteHist(getImportesContables().getImpoMonLoc());
			certificado.setImporteAju(getImportesContables().getImpoMonLocAju());
			certificado.setImporteExt1(getImportesContables().getImpoMonExt1());
			certificado.setImporteExt2(getImportesContables().getImpoMonExt2());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(getSujeto());
			certificado.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
			certificado.setCotizMonOriCon(getCotizMonedaValor());
			certificado.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
			certificado.setNroCertificado(this.getNroCertificado());
			certificado.setAnulado(this.isAnulado());
		} else {
			certificado.setValorCertificado(this.getValor());
			certificado.setTipoOper(CertificadoRetencionGanancias.SALIDA);

			certificado.setFechaEmision(this.getValor().getFechaemision());
			certificado.setFechaContable(this.getFechaContable());
			certificado.setImporte(this.getValor().getImporte());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(this.getValor().getSujeto());
			certificado.setNroCertificado(this.getValor().getNroCertificado());
			certificado.setTipoValor(this.getValor().getTipovalor());
			certificado.setCaja(this.getValor().getCaja());
			certificado.setComprobante(getComproCab());
			certificado.setAnulado(this.isAnulado());

			if (this.depositarCheque())
				certificado.setDepositarCheque(true);
			else if (this.isDevolucion())
				certificado.setDevolucion(true);
			else if (this.isLiquidando())
				certificado.setEstaLiquidando(true);
			

		}

		certificado.save();

		return certificado.getValorCertificado();

	}

	public Valor grabarCertificadoRetencionIB() throws BaseException {

		CertificadoRetencionIB certificado = new CertificadoRetencionIB();
		certificado.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {
			certificado.setTipoOper(CertificadoRetencionIB.ENTRADA);
			certificado.setFechaEmision(getFecEmision());
			certificado.setProvincia(this.getProvincia());
			certificado.setFechaContable(getFechaContable());
			certificado.setImporte(getImporteMonedaValor());

			certificado.setImporteHist(getImportesContables().getImpoMonLoc());
			certificado.setImporteAju(getImportesContables().getImpoMonLocAju());
			certificado.setImporteExt1(getImportesContables().getImpoMonExt1());
			certificado.setImporteExt2(getImportesContables().getImpoMonExt2());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(getSujeto());
			certificado.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
			certificado.setCotizMonOriCon(getCotizMonedaValor());
			certificado.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
			certificado.setNroCertificado(this.getNroCertificado());
			certificado.setAnulado(this.isAnulado());
			certificado.setTipoValor(getTipoValor());
			certificado.setCaja(this.getCaja());
			certificado.setComprobante(getComproCab());
			certificado.setAnulado(this.isAnulado());
		} else {

			certificado.setValorCertificado(this.getValor());
			certificado.setTipoOper(CertificadoRetencionIB.SALIDA);

			certificado.setFechaEmision(this.getValor().getFechaemision());
			certificado.setProvincia(this.getValor().getProvincia());
			certificado.setFechaContable(this.getFechaContable());
			certificado.setImporte(this.getValor().getImporte());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(this.getValor().getSujeto());
			certificado.setNroCertificado(this.getValor().getNroCertificado());
			certificado.setTipoValor(this.getValor().getTipovalor());
			certificado.setCaja(this.getValor().getCaja());
			certificado.setComprobante(getComproCab());
			certificado.setAnulado(this.isAnulado());

			if (this.depositarCheque())
				certificado.setDepositarCheque(true);
			else if (this.isDevolucion())
				certificado.setDevolucion(true);
			else if (this.isLiquidando())
				certificado.setEstaLiquidando(true);
			
		}

		certificado.save();

		return certificado.getValorCertificado();

	}

	public Valor grabarCertificadoRetencionSUS() throws BaseException {

		CertificadoRetencionSUS certificado = new CertificadoRetencionSUS();
		certificado.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {
			certificado.setTipoOper(CertificadoRetencionSUS.ENTRADA);
			certificado.setCaja(this.getCaja());
			certificado.setTipoValor(getTipoValor());
			certificado.setFechaEmision(getFecEmision());
			certificado.setFechaContable(getFechaContable());
			certificado.setImporte(getImporteMonedaValor());
			certificado.setComprobante(getComproCab());
			certificado.setImporteHist(getImportesContables().getImpoMonLoc());
			certificado.setImporteAju(getImportesContables().getImpoMonLocAju());
			certificado.setImporteExt1(getImportesContables().getImpoMonExt1());
			certificado.setImporteExt2(getImportesContables().getImpoMonExt2());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(getSujeto());
			certificado.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
			certificado.setCotizMonOriCon(getCotizMonedaValor());
			certificado.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
			certificado.setNroCertificado(this.getNroCertificado());
			certificado.setAnulado(this.isAnulado());

		} else {
			certificado.setValorCertificado(this.getValor());
			certificado.setTipoOper(CertificadoRetencionSUS.SALIDA);
			certificado.setFechaEmision(this.getValor().getFechaemision());
			certificado.setFechaContable(this.getFechaContable());
			certificado.setImporte(this.getValor().getImporte());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(this.getValor().getSujeto());
			certificado.setNroCertificado(this.getValor().getNroCertificado());
			certificado.setTipoValor(this.getValor().getTipovalor());
			certificado.setCaja(this.getValor().getCaja());
			certificado.setComprobante(getComproCab());
			certificado.setAnulado(this.isAnulado());

			if (this.depositarCheque())
				certificado.setDepositarCheque(true);
			else if (this.isDevolucion())
				certificado.setDevolucion(true);
			else if (this.isLiquidando())
				certificado.setEstaLiquidando(true);
			
		}
		certificado.save();

		return certificado.getValorCertificado();

	}

	public Valor grabarCertificadoRetencionIVA() throws BaseException {

		CertificadoRetencionIVA certificado = new CertificadoRetencionIVA();
		certificado.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {
			certificado.setTipoOper(CertificadoRetencionIVA.ENTRADA);
			certificado.setCaja(this.getCaja());
			certificado.setTipoValor(getTipoValor());
			certificado.setFechaEmision(getFecEmision());
			certificado.setFechaContable(getFechaContable());
			certificado.setImporte(getImporteMonedaValor());
			certificado.setComprobante(getComproCab());
			certificado.setImporteHist(getImportesContables().getImpoMonLoc());
			certificado.setImporteAju(getImportesContables().getImpoMonLocAju());
			certificado.setImporteExt1(getImportesContables().getImpoMonExt1());
			certificado.setImporteExt2(getImportesContables().getImpoMonExt2());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(getSujeto());
			certificado.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
			certificado.setCotizMonOriCon(getCotizMonedaValor());
			certificado.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
			certificado.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
			certificado.setNroCertificado(this.getNroCertificado());
			certificado.setAnulado(this.isAnulado());
		} else {
			certificado.setValorCertificado(this.getValor());
			certificado.setTipoOper(CertificadoRetencionIVA.SALIDA);

			certificado.setFechaEmision(this.getValor().getFechaemision());
			certificado.setFechaContable(this.getFechaContable());
			certificado.setImporte(this.getValor().getImporte());
			certificado.setCotizMonOri(getCotizMonedaValor());
			certificado.setSujeto(this.getValor().getSujeto());
			certificado.setNroCertificado(this.getValor().getNroCertificado());
			certificado.setTipoValor(this.getValor().getTipovalor());
			certificado.setCaja(this.getValor().getCaja());
			certificado.setComprobante(getComproCab());
			certificado.setAnulado(this.isAnulado());

			if (this.depositarCheque())
				certificado.setDepositarCheque(true);
			else if (this.isDevolucion())
				certificado.setDevolucion(true);
			else if (this.isLiquidando())
				certificado.setEstaLiquidando(true);
		}
		certificado.save();

		return certificado.getValorCertificado();

	}

	public Valor grabarCuponTarjetoCredito() throws BaseException {

		CuponTarjetaCredito cupon = new CuponTarjetaCredito();
		cupon.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {

			if (this.isAnulacionOP()) {
				cupon.setEndosar(false);
				cupon.setTipoOper(CuponTarjetaCredito.ENTRADA);
				cupon.setCuponTarjetaCredito(this.getValor());
				cupon.setIsAnulacionOP(this.isAnulacionOP());
				cupon.setCaja(this.getCaja());
				cupon.setTipoValor(this.getValor().getTipovalor());
				cupon.setComprobante(getComproCab());
				cupon.setImporte(this.getValor().getImporte());
				cupon.setCotizMonOri(this.getValor().getCotizacion());

			} else {

				cupon.setTipoOper(CuponTarjetaCredito.ENTRADA);
				cupon.setCaja(this.getCaja());
				cupon.setTipoValor(getTipoValor());
				cupon.setFechaEmision(getFecEmision());
				cupon.setFechaVencimiento(getFecVencimiento());
				cupon.setFechaContable(getFechaContable());
				cupon.setImporte(getImporteMonedaValor());
				cupon.setComprobante(getComproCab());
				cupon.setNroCupon(this.getCupon());
				cupon.setLote(this.getLote());
				cupon.setCuotas(this.getCuotas());
				cupon.setNroTarjeta(this.getNroTarjeta());
				cupon.setTarjetaCredito(this.getTarjetaCredito());
				cupon.setImporteHist(getImportesContables().getImpoMonLoc());
				cupon.setImporteAju(getImportesContables().getImpoMonLocAju());
				cupon.setImporteExt1(getImportesContables().getImpoMonExt1());
				cupon.setImporteExt2(getImportesContables().getImpoMonExt2());
				cupon.setCotizMonOri(getCotizMonedaValor());
				cupon.setSujeto(getSujeto());
				cupon.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
				cupon.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
				cupon.setCotizMonOriCon(getCotizMonedaValor());
				cupon.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
				cupon.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
				cupon.setCodigoAutorizacion(this.getCodigoAutorizacion());
				cupon.setAnulado(this.isAnulado());
			}

		} else {
			cupon.setCuponTarjetaCredito(this.getValor());
			cupon.setTipoOper(CuponTarjetaCredito.SALIDA);
			cupon.setComprobante(getComproCab());

			if (this.depositarCheque())
				cupon.setDepositarCheque(true);
			else if (this.isDevolucion())
				cupon.setDevolucion(true);
			else if (this.isEndosar())
				cupon.setEndosar(true);
			else if (this.isLiquidando()) {
				cupon.setImporteValorALiquidar(this.getImporteALiquidar());
				cupon.setEstaLiquidando(true);
			}
			
		}
		cupon.save();

		return cupon.getCuponTarjetaCredito();
	}

	public Valor grabarCuponTarjetoDebito() throws BaseException {

		CuponTarjetaDebito cupon = new CuponTarjetaDebito();
		cupon.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO) {

			if (this.isAnulacionOP()) {
				cupon.setEndosar(false);
				cupon.setTipoOper(CuponTarjetaCredito.ENTRADA);
				cupon.setCuponTarjetaDebito(this.getValor());
				cupon.setIsAnulacionOP(this.isAnulacionOP());
				cupon.setCaja(this.getCaja());
				cupon.setTipoValor(this.getValor().getTipovalor());
				cupon.setComprobante(getComproCab());
				cupon.setImporte(this.getValor().getImporte());
				cupon.setCotizMonOri(this.getValor().getCotizacion());

			} else {

				cupon.setTipoOper(CuponTarjetaCredito.ENTRADA);
				cupon.setBanco(Banco.findByOidProxy(getOidEntidad(), getSesion()));
				cupon.setCaja(this.getCaja());
				cupon.setTipoValor(getTipoValor());
				cupon.setFechaEmision(getFecEmision());
				cupon.setFechaVencimiento(getFecVencimiento());
				cupon.setFechaContable(getFechaContable());
				cupon.setImporte(getImporteMonedaValor());
				cupon.setComprobante(getComproCab());
				cupon.setNroCupon(this.getCupon());
				cupon.setLote(this.getLote());
				cupon.setCuotas(this.getCuotas());
				cupon.setNroTarjeta(this.getNroTarjeta());
				cupon.setImporteHist(getImportesContables().getImpoMonLoc());
				cupon.setImporteAju(getImportesContables().getImpoMonLocAju());
				cupon.setImporteExt1(getImportesContables().getImpoMonExt1());
				cupon.setImporteExt2(getImportesContables().getImpoMonExt2());
				cupon.setCotizMonOri(getCotizMonedaValor());
				cupon.setSujeto(getSujeto());
				cupon.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
				cupon.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
				cupon.setCotizMonOriCon(getCotizMonedaValor());
				cupon.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
				cupon.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
				cupon.setNro(this.getNro_cheque());
				cupon.setCodigoAutorizacion(this.getCodigoAutorizacion());
				cupon.setAnulado(this.isAnulado());
			}
		} else {
			cupon.setCuponTarjetaDebito(this.getValor());
			cupon.setTipoOper(CuponTarjetaCredito.SALIDA);
			cupon.setComprobante(getComproCab());
			if (this.depositarCheque())
				cupon.setDepositarCheque(true);
			else if (this.isDevolucion())
				cupon.setDevolucion(true);
			else if (this.isEndosar())
				cupon.setEndosar(true);

		}
		cupon.save();

		return cupon.getCuponTarjetaDebito();
	}

	public Valor grabarDocumentoCliente() throws BaseException {

		DocumentoCliente documentoCliente = new DocumentoCliente();
		documentoCliente.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO)
			documentoCliente.setTipoOper(CuponTarjetaCredito.ENTRADA);
		else {
			documentoCliente.setDocumentoCliente(this.getValor());
			documentoCliente.setTipoOper(CuponTarjetaCredito.SALIDA);
			if (this.depositarCheque())
				documentoCliente.setDepositarCheque(true);
			else if (this.isDevolucion())
				documentoCliente.setDevolucion(true);
		}
		documentoCliente.setCaja(this.getCaja());
		documentoCliente.setTipoValor(getTipoValor());
		documentoCliente.setFechaEmision(getFecEmision());
		documentoCliente.setFechaVencimiento(getFecVencimiento());
		documentoCliente.setFechaContable(getFechaContable());
		documentoCliente.setImporte(getImporteMonedaValor());
		documentoCliente.setComprobante(getComproCab());
		documentoCliente.setNro(this.getNro());
		documentoCliente.setImporteHist(getImportesContables().getImpoMonLoc());
		documentoCliente.setImporteAju(getImportesContables().getImpoMonLocAju());
		documentoCliente.setImporteExt1(getImportesContables().getImpoMonExt1());
		documentoCliente.setImporteExt2(getImportesContables().getImpoMonExt2());
		documentoCliente.setCotizMonOri(getCotizMonedaValor());
		documentoCliente.setSujeto(getSujeto());
		documentoCliente.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
		documentoCliente.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
		documentoCliente.setCotizMonOriCon(getCotizMonedaValor());
		documentoCliente.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
		documentoCliente.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
		documentoCliente.setNro(this.getNro_cheque());
		documentoCliente.setAnulado(this.isAnulado());
		documentoCliente.save();

		return documentoCliente.getDocumentoCliente();
	}

	public Valor grabarCuponTicket() throws BaseException {

		CuponTicket cupon = new CuponTicket();
		cupon.setSesion(getSesion());
		if (this.getIngresoEgreso() == INGRESO)
			cupon.setTipoOper(CuponTarjetaCredito.ENTRADA);
		else {
			cupon.setCuponTicket(this.getValor());
			cupon.setTipoOper(CuponTarjetaCredito.SALIDA);
			if (this.depositarCheque())
				cupon.setDepositarCheque(true);
			else if (this.isDevolucion())
				cupon.setDevolucion(true);

		}
		cupon.setCaja(this.getCaja());
		cupon.setTipoValor(getTipoValor());
		cupon.setFechaEmision(getFecEmision());
		cupon.setFechaVencimiento(getFecVencimiento());
		cupon.setFechaContable(getFechaContable());
		cupon.setImporte(getImporteMonedaValor());
		cupon.setComprobante(getComproCab());
		cupon.setNroCupon(this.getCupon());
		cupon.setLote(this.getLote());
		cupon.setCuotas(this.getCuotas());
		cupon.setNroTarjeta(this.getNroTarjeta());
		cupon.setTicket(this.getTicket());
		cupon.setImporteHist(getImportesContables().getImpoMonLoc());
		cupon.setImporteAju(getImportesContables().getImpoMonLocAju());
		cupon.setImporteExt1(getImportesContables().getImpoMonExt1());
		cupon.setImporteExt2(getImportesContables().getImpoMonExt2());
		cupon.setCotizMonOri(getCotizMonedaValor());
		cupon.setSujeto(getSujeto());
		cupon.setCotizMonExt1(getImportesContables().getValorCotizMonExt1());
		cupon.setCotizMonExt2(getImportesContables().getValorCotizMonExt2());
		cupon.setCotizMonOriCon(getCotizMonedaValor());
		cupon.setCotizMonExt1Con(getImportesContables().getValorCotizMonExt1());
		cupon.setCotizMonExt2Con(getImportesContables().getValorCotizMonExt2());
		cupon.setAnulado(this.isAnulado());
		cupon.save();

		return cupon.getCuponTicket();
	}

	public Efectivo grabarEfectivo() throws BaseException {
		Efectivo efectivo = new Efectivo();
		efectivo.setSesion(getSesion());
		efectivo.setTipoValor(getTipoValor());
		Caja caja = null;
		if (this.getCaja() != null)
			caja = this.getCaja();
		if (caja == null) {
			Integer oidCaja = getOidEntidad();
			caja = Caja.findByOid(oidCaja, getSesion());
		}
		if (caja == null)
			throw new ExceptionValidation(null, "Debe ingresar la caja");
		efectivo.setCaja(caja);
		efectivo.setSujeto(this.getSujeto());
		efectivo.setFechaCaja(caja.getFechaCaja());
		efectivo.setImporte(getImporteMonedaValor());
		if (getIngresoEgreso() == MedioPago.EGRESO)
			efectivo.setTipoOper(Efectivo.SALIDA);
		else
			efectivo.setTipoOper(Efectivo.ENTRADA);
		efectivo.setComprobante(getComproCab());
		efectivo.setCotizacion(getCotizMonedaValor());
		efectivo.setActivo(new Boolean(true));
		efectivo.save();
		return efectivo;
	}

	public void anular() throws BaseException {

		// Verificar el Tipo de Valor
		Valor valor = null;
		Efectivo efectivo = null;

		// Verificar si afecta la caja
		if (getTipoValor().isAfectaCaja()) {
			if (getTipoValor().isEfectivo())
				efectivo = anularEfectivo();
		}

	}

	private Efectivo anularEfectivo() throws BaseException {
		// Segun el comprobante hacer una entreda o salida del efectivo

		return this.grabarEfectivo();
	}

	public void save() throws BaseException {

		// Si no hay seguimiento de caja no actualizar nada
		//if (this.getTipoValor().isSeguimientoCaja().booleanValue() == false)
		//	return;

		// Verificar el Tipo de Valor
		Valor valor = null;
		Efectivo efectivo = null;

		// Cheque Propio
		if (getTipoValor().isChequePropio())
			valor = grabarChequePropio();

		// Cheque Tercero
		if (getTipoValor().isChequeTercero())
			valor = grabarChequeTercero();

		// Cheque Cliente
		if (getTipoValor().isChequeCliente())
			valor = grabarChequeCliente();

		// Grabar Cupon Tarjeta de Credito
		if (getTipoValor().isTarjetaCredito())
			valor = grabarCuponTarjetoCredito();

		// Grabar Ticket
		if (getTipoValor().isTicket())
			valor = this.grabarCuponTicket();

		// Grabar documento cliente
		if (getTipoValor().isDocumentoCliente())
			valor = grabarDocumentoCliente();

		// Grabar Tarjeta Debito
		if (getTipoValor().isCuponTarjetaDebito())
			valor = grabarCuponTarjetoDebito();

		// Grabar Certificado Retencion de Ganancias
		if (getTipoValor().isCertificadoRetGan())
			valor = grabarCertificadoRetencionGan();

		// Grabar Certificado Retencion de SUS
		if (getTipoValor().isCertificadoRetSUS())
			valor = grabarCertificadoRetencionSUS();

		// Grabar Certificado Retencion de IVA
		if (getTipoValor().isCertificadoRetIVA())
			valor = grabarCertificadoRetencionIVA();

		// Grabar Certificado Retencion de IB
		if (getTipoValor().isCertificadoRetIB())
			valor = grabarCertificadoRetencionIB();
		
		if (getTipoValor().isLiquidacionTarjetaCredito())
			valor = grabarLiquidacionTarjteCredito();
		
		if (getTipoValor().isTransClieBanco())
			valor = grabarTransferenciaClieBanco();
		

		// Verificar si afecta la caja
		if (getTipoValor().isAfectaCaja()) {
			if (getTipoValor().isEfectivo())
				efectivo = grabarEfectivo();
		}
		
		if (valor!=null)
			setValorGrabado(valor);

		if (getComproCab() instanceof ComproOrdenPagoCab)
			grabarMediosPagoOP(this.getCaja(), getTipoValor(), valor);
		else if (getComproCab() instanceof RendicionFondoFijo)
			grabarMediosPagoFF(getTipoValor(), valor, this.getIngresoEgreso());
		else if (getComproCab() instanceof FacturaCab)
			grabarModiosPagoCobranzaVtaMos(getTipoValor(), valor);
		else if (getComproCab() instanceof Recibo)
			grabarModiosPagoCobranzaRecibo(getTipoValor(), valor);
		else if (getComproCab() instanceof LiquidacionTarCab)
			grabarModiosPagoLiquidacionTarjeta(getTipoValor(), valor);

	}

	public void grabarMediosPagoFF(TipoValor tipoValor, Valor valor, int ingresoEgreso) throws BaseException {
		RendicionFondoFijoMedioPago rendFFMedioPago = (RendicionFondoFijoMedioPago) RendicionFondoFijoMedioPago.getNew(
				RendicionFondoFijoMedioPago.NICKNAME, getSesion());
		rendFFMedioPago.setRendicion_fondo((RendicionFondoFijo) getComproCab());
		if (ingresoEgreso == MedioPago.INGRESO)
			rendFFMedioPago.setIngresoEgreso("INGRESO");
		else
			rendFFMedioPago.setIngresoEgreso("EGRESO");
		rendFFMedioPago.setValor(valor);
		rendFFMedioPago.setTipo_valor(tipoValor);
		rendFFMedioPago.setImporte(new Double(getImporteMonedaValor().doubleValue()));
		rendFFMedioPago.setImpo_mon_rend_ff(new Double(getImporteMonedaPago().doubleValue()));
		rendFFMedioPago.setImpo_mon_loc(new Double(getImportesContables().getImpoMonLoc().doubleValue()));
		rendFFMedioPago.setCaja(getCaja());
		rendFFMedioPago.setCotizacion(new Double(getCotizMonedaValor().doubleValue()));
		rendFFMedioPago.save();
	}

	public void grabarMediosPagoOP(Caja caja, TipoValor tipoValor, Valor valor) throws BaseException {
		ComproOrdenPagoMediosPago medioPagoOP = (ComproOrdenPagoMediosPago) ComproOrdenPagoMediosPago.getNew(
				ComproOrdenPagoMediosPago.NICKNAME, getSesion());
		medioPagoOP.setComprobante(getComproCab());
		medioPagoOP.setValor(valor);
		medioPagoOP.setTipovalor(tipoValor);
		medioPagoOP.setImpomonvalor(getImporteMonedaValor());
		medioPagoOP.setImpomonpago(getImporteMonedaPago());
		medioPagoOP.setImpoMonLocal(getImportesContables().getImpoMonLoc());
		medioPagoOP.setCotizacion(new Double(getCotizMonedaValor().doubleValue()));
		if (caja != null)
			medioPagoOP.setCaja(caja);
		else if ((valor != null) && (valor.getCaja() != null))
			medioPagoOP.setCaja(valor.getCaja());
		medioPagoOP.save();
	}
	
	
	public void grabarModiosPagoLiquidacionTarjeta(TipoValor tipoValor, Valor valor) throws BaseException {
		LiquidacionTarjetaValor liquidacionTarjetaValor = (LiquidacionTarjetaValor) LiquidacionTarjetaValor.getNew(ValoresRecibo.NICKNAME, getSesion());
		liquidacionTarjetaValor.setLiquidacion_tarjeta((LiquidacionTarCab)this.getComproCab());
		liquidacionTarjetaValor.setValor(valor);
		liquidacionTarjetaValor.setImporte(this.getImporteMonedaValor());
		liquidacionTarjetaValor.setImporte_mon_loc(getImpoMonLocal());
		liquidacionTarjetaValor.setCotizacion(this.getCotizMonedaValor());
		liquidacionTarjetaValor.setNro(this.getComproCab().getNroExt());
		liquidacionTarjetaValor.setTarjeta(this.getTarjetaCredito());
		liquidacionTarjetaValor.setBanco(null);
		liquidacionTarjetaValor.setCuenta(null);
		liquidacionTarjetaValor.setActivo(new Boolean(true));
		liquidacionTarjetaValor.save();
	}

	public void grabarModiosPagoCobranzaRecibo(TipoValor tipoValor, Valor valor) throws BaseException {
		ValoresRecibo valorRecibo = (ValoresRecibo) ValoresRecibo.getNew(ValoresRecibo.NICKNAME, getSesion());
		valorRecibo.setRecibo((Recibo) getComproCab());
		valorRecibo.setTipo_valor(tipoValor);
		valorRecibo.setValor(valor);
		valorRecibo.setImpo_mon_ori(this.getImporteMonedaValor());
		valorRecibo.setImpo_mon_loc(getImpoMonLocal());
		valorRecibo.setCotizacion(this.getCotizMonedaValor());
		valorRecibo.setImpoMonRec(this.getImporteMonedaPago());
		valorRecibo.save();
	}

	public void grabarModiosPagoCobranzaVtaMos(TipoValor tipoValor, Valor valor) throws BaseException {
		CobranzaVtaMostrador cobranzaVtaMostrador = (CobranzaVtaMostrador) CobranzaVtaMostrador.getNew(CobranzaVtaMostrador.NICKNAME,
				getSesion());
		cobranzaVtaMostrador.setFacturaCab((FacturaCab) this.getComproCab());
		cobranzaVtaMostrador.setValor(valor);
		cobranzaVtaMostrador.setTipo_valor(tipoValor);
		cobranzaVtaMostrador.setImpo_mon_tv(getImporteMonedaValor());
		cobranzaVtaMostrador.setImpo_mon_fact(getImporteMonedaPago());
		cobranzaVtaMostrador.setCotizacion(getCotizMonedaValor());
		cobranzaVtaMostrador.save();
	}

	public CuentaImputable getCuentaImputable() throws BaseException {
		if (getTipoValor().isChequePropio()) {
			CuentaBancaria ctaBancaria = CuentaBancaria.findByOidProxy(getOidEntidad(), getSesion());
			return ctaBancaria.getCuentaimputableAConciliar();
		} else { 
			if (this.getValorGrabado()!=null)
					return this.getValorGrabado().getCuentaImputable();
			else if (this.getTipoValor()!=null) 
			  		return this.getTipoValor().getCuentaImputable();
		}
		return null;
	}

	public Money getImpoMonLocal() throws BaseException {
		CalculadorMoney calcImpoMonLoc = new CalculadorMoney(this.getImporteMonedaValor());
		calcImpoMonLoc.multiplicarPor(this.getCotizMonedaValor());
		return calcImpoMonLoc.getResultMoney();
	}

}
