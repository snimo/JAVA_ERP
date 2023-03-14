package com.srn.erp.tesoreria.bm;

import java.util.Date;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ValorBase {

	private Ticket					ticket;

	public static String		ENTRADA		= "ENTRADA";

	public static String		SALIDA		= "SALIDA";
	
	private Valor valorLiquidacionTarjeta;

	private Valor transBancariaCliente;
	
	private Valor						cupon;

	private String					nroTarjeta;

	private Integer					lote;

	private Integer					nroCupon;

	private TarjetaCredito	tarjetaCredito;

	private Integer					cuotas;

	private Valor						chequePropio;

	private CuentaBancaria	cuentaBancaria;

	private Valor						valorCertificado;

	private String					nroCertificado;

	private ISesion					sesion;

	private TipoValor				tipoValor;

	private Valor						chequeTercero;

	private Banco						banco;

	private Integer					nroCheque;

	private Date						fechaEmision;

	private Date						fechaVencimiento;

	private Date						fechaContable;

	private Money						importe;

	private String					tipoOper;

	private ComproCab				comprobante;

	private Money						importeHist;

	private Money						importeAju;

	private Money						importeExt1;

	private Money						importeExt2;

	private ValorCotizacion	cotizMonOri;

	private ValorCotizacion	cotizMonExt1;

	private ValorCotizacion	cotizMonExt2;

	private ValorCotizacion	cotizMonOriCon;

	private ValorCotizacion	cotizMonExt1Con;

	private ValorCotizacion	cotizMonExt2Con;

	private Caja						caja;

	private Sujeto					sujeto;
	
	private Proveedor 				proveedor;

	private boolean					depositar	= false;

	private boolean 				devolucion = false;
	
	private boolean					endosar = false;
	
	private boolean					anulado = false;
	
	private boolean					isAnulacionOP = false;
	
	private boolean 				isLiquidando = false;
	
	private Integer					nro;

	private Valor						cuponTarjetaDebito;

	private Valor						cuponTicket;

	private Valor						documentoCliente;
	
	private Valor						certificado;
	
	private String 					codigoAutorizacion;
	
	private String 					cuit;
	
	private Money					importeValorALiquidar;

	public boolean depositar() throws BaseException {
		return this.depositar;
	}

	public void setDepositarCheque(boolean depositarCheque) throws BaseException {
		this.depositar = depositarCheque;
	}
	
	public String getCUIT() throws BaseException {
		return this.cuit;
	}
	
	public void setImporteValorALiquidar(Money aImporteValorALiquidar) throws BaseException {
		this.importeValorALiquidar = aImporteValorALiquidar;
	}
	
	public Money getImporteValorALiquidar() throws BaseException {
		return this.importeValorALiquidar;
	}
	

	public void setCUIT(String aCUIT) throws BaseException {
		this.cuit = aCUIT;
	}
	
	
	public String getCodigoAutorizacion() throws BaseException {
		return this.codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String aCodigoAutorizacion) throws BaseException {
		this.codigoAutorizacion = aCodigoAutorizacion;
	}
	
	
	public boolean isDevolucion() throws BaseException {
		return this.devolucion;
	}

	public void setDevolucion(boolean aDevolucion) throws BaseException {
		this.devolucion = aDevolucion;
	}
	
	public boolean isEndosar() throws BaseException {
		return this.endosar;
	}

	public void setEndosar(boolean aEndosar) throws BaseException {
		this.endosar = aEndosar;
	}
	
	
	public boolean isAnulado() throws BaseException {
		return this.anulado;
	}

	public void setAnulado(boolean aAnulado) throws BaseException {
		this.anulado = aAnulado;
	}
	
	public boolean isAnulacionOP() throws BaseException {
		return this.isAnulacionOP;
	}
	
	public boolean isLiquidando() throws BaseException {
		return this.isLiquidando; 
	}

	public void setIsAnulacionOP(boolean aIsAnulacionOP) throws BaseException {
		this.isAnulacionOP = aIsAnulacionOP;
	}
	
	public void setEstaLiquidando(boolean aEstaLiquidando) throws BaseException {
		this.isLiquidando = aEstaLiquidando;
	}
	

	public Caja getCaja() throws BaseException {
		
		if (this.getTipoValor().getCajaFija()!=null)
			return this.getTipoValor().getCajaFija();
		
		return caja;
	}

	public void setCaja(Caja aCaja) throws BaseException {
		this.caja = aCaja;
	}

	public Sujeto getSujeto() throws BaseException {
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) throws BaseException {
		this.sujeto = aSujeto;
	}
	
	public Proveedor getProveedor() throws BaseException {
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) throws BaseException {
		this.proveedor = aProveedor;
	}
	

	public String getTipoOper() throws BaseException {
		return this.tipoOper;
	}

	public ValorCotizacion getCotizMonOri() throws BaseException {
		return cotizMonOri;
	}

	public void setCotizMonOri(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonOri = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt1() throws BaseException {
		return cotizMonExt1;
	}

	public void setCotizMonExt1(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt1 = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt2() throws BaseException {
		return cotizMonExt2;
	}

	public void setCotizMonExt2(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt2 = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonOriCon() throws BaseException {
		return cotizMonOriCon;
	}

	public void setCotizMonOriCon(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonOriCon = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt1Con() throws BaseException {
		return cotizMonExt1Con;
	}

	public void setCotizMonExt1Con(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt1Con = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt2Con() throws BaseException {
		return cotizMonExt2Con;
	}

	public void setCotizMonExt2Con(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt2Con = aValorCotizacion;
	}

	public void setComprobante(ComproCab aComproCAB) {
		this.comprobante = aComproCAB;
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public void setTipoOper(String aTipoOper) {
		this.tipoOper = aTipoOper;
	}

	public Integer getNroCheque() {
		return nroCheque;
	}

	public Banco getBanco() {
		return banco;
	}

	public Money getImporte() {
		return importe;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setFechaContable(Date aFechaContable) {
		this.fechaContable = aFechaContable;
	}

	public void setNroCheque(Integer nroCheque) {
		this.nroCheque = nroCheque;
	}

	public void setBanco(Banco aBanco) {
		this.banco = aBanco;
	}

	public void setImporte(Money importe) {
		this.importe = importe;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}

	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	public void setImporteAju(Money importeAju) {
		this.importeAju = importeAju;
	}

	public void setImporteExt1(Money importeExt1) {
		this.importeExt1 = importeExt1;
	}

	public void setImporteHist(Money importeHist) {
		this.importeHist = importeHist;
	}

	public void setImporteExt2(Money importeExt2) {
		this.importeExt2 = importeExt2;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public Date getFechaContable() {
		return fechaContable;
	}

	public Valor getChequeTercero() {
		return this.chequeTercero;
	}

	public void setChequeTercero(Valor aChequeTercero) throws BaseException {
		this.chequeTercero = aChequeTercero;
	}

	public ISesion getSesion() {
		return sesion;
	}

	public TipoValor getTipoValor() {
		return tipoValor;
	}

	public Money getImporteAju() {
		return importeAju;
	}

	public Money getImporteExt1() {
		return importeExt1;
	}

	public Money getImporteHist() {
		return importeHist;
	}

	public Money getImporteExt2() {
		return importeExt2;
	}

	public String getNroCertificado() throws BaseException {
		return this.nroCertificado;
	}

	public void setNroCertificado(String aNroCertificado) throws BaseException {
		this.nroCertificado = aNroCertificado;
	}

	public Valor getValorCertificado() throws BaseException {
		return this.valorCertificado;
	}

	public void setValorCertificado(Valor aValorCertificado) throws BaseException {
		this.valorCertificado = aValorCertificado;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public Valor getChequePropio() {
		return chequePropio;
	}

	public void setChequePropio(Valor aChequePropio) {
		this.chequePropio = aChequePropio;
	}

	public Integer getNroCupon() throws BaseException {
		return nroCupon;
	}

	public void setNroCupon(Integer aNroCupon) throws BaseException {
		this.nroCupon = aNroCupon;
	}
	
	public Valor getValorLiquidacionTarjeta() throws BaseException {
		return this.valorLiquidacionTarjeta;
	}

	public void setValorLiquidacionTarjeta(Valor aValorLiquidacionTarjeta) throws BaseException {
		this.valorLiquidacionTarjeta = aValorLiquidacionTarjeta;
	}
	
	public Valor getTransBancariaCliente() throws BaseException {
		return this.transBancariaCliente;
	}

	public void setTransBancariaCliente(Valor aTransBancariaCliente) throws BaseException {
		this.transBancariaCliente = aTransBancariaCliente;
	}
	
	

	public String getNroTarjeta() throws BaseException {
		return this.nroTarjeta;
	}

	public void setNroTarjeta(String aNroTarjeta) throws BaseException {
		this.nroTarjeta = aNroTarjeta;
	}

	public void save() throws BaseException {

	}

	public Integer getLote() throws BaseException {
		return lote;
	}

	public void setLote(Integer aLote) throws BaseException {
		this.lote = aLote;
	}

	public TarjetaCredito getTarjetCredito() throws BaseException {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCredito aTarjetaCredito) throws BaseException {
		this.tarjetaCredito = aTarjetaCredito;
	}

	public Valor getCuponTarjetaCredito() {
		return this.cupon;
	}

	public void setCuponTarjetaCredito(Valor aCupon) {
		this.cupon = aCupon;
	}

	public Integer getCuotas() throws BaseException {
		return cuotas;
	}

	public void setCuotas(Integer aCuotas) throws BaseException {
		this.cuotas = aCuotas;
	}

	public Integer getNro() throws BaseException {
		return nro;
	}

	public void setNro(Integer aNro) throws BaseException {
		this.nro = aNro;
	}

	public Valor getCuponTarjetaDebito() throws BaseException {
		return this.cuponTarjetaDebito;
	}

	public void setCuponTarjetaDebito(Valor aCuponTarjetaDebito) throws BaseException {
		this.cuponTarjetaDebito = aCuponTarjetaDebito;
	}

	public Ticket getTicket() throws BaseException {
		return this.ticket;
	}

	public void setTicket(Ticket aTicket) throws BaseException {
		this.ticket = aTicket;
	}

	public Valor getCuponTicket() throws BaseException {
		return this.cuponTicket;
	}

	public void setCuponTicket(Valor aCuponTicket) throws BaseException {
		this.cuponTicket = aCuponTicket;
	}

	public Valor getDocumentoCliente() throws BaseException {
		return this.documentoCliente;
	}

	public void setDocumentoCliente(Valor aDocumentoCliente) throws BaseException {
		this.documentoCliente = aDocumentoCliente;
	}

	public static ValorBase getNewValor(String comportamiento) throws BaseException {

		if (comportamiento.equals(TipoValorCompo.TV_CHEQUE_TERCERO))
			return new ChequeTercero();
		else if (comportamiento.equals(TipoValorCompo.TV_CHEQUE_CLIENTE))
			return new ChequeCliente();
		else if (comportamiento.equals(TipoValorCompo.TV_TARJETA_CREDITO))
			return new CuponTarjetaCredito();
		else if (comportamiento.equals(TipoValorCompo.TV_TICKET))
			return new CuponTicket();
		else if (comportamiento.equals(TipoValorCompo.TV_DOCU_CLIE))
			return new DocumentoCliente();
		else if (comportamiento.equals(TipoValorCompo.TV_TAR_DEBITO))
			return new CuponTarjetaDebito();
		else if (comportamiento.equals(TipoValorCompo.TV_CERT_RET_GAN))
			return new CertificadoRetencionGanancias();
		else if (comportamiento.equals(TipoValorCompo.TV_CERT_RET_IVA))
			return new CertificadoRetencionIVA();
		else if (comportamiento.equals(TipoValorCompo.TV_CERT_RET_IB))
			return new CertificadoRetencionIB();
		else if (comportamiento.equals(TipoValorCompo.TV_CERT_RET_SUS))
			return new CertificadoRetencionSUS();
		else throw new ExceptionValidation(null,"Se desconoce el comportamiento del tipo de Valor "+comportamiento);

	}

}
