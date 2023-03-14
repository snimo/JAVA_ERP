package com.srn.erp.tesoreria.bm;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.tesoreria.da.DBValor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;

public class Valor extends ObjetoLogico {

	public Valor() {
	}

	public static String NICKNAME = "te.Valor";

	private TipoValor tipoValor;

	private TarjetaCredito tarjetaCredito;

	private Ticket ticket;

	private Banco banco;

	private Integer nroCheque;

	private Date fechaEmision;

	private Date fechaVto;

	private Boolean anulado;

	private Boolean endosado;

	private CuentaBancaria cuentaBancaria;

	private Boolean depositado;

	private Boolean rechazado;

	private Boolean cobrado;

	private String titular;

	private Boolean recibido;

	private Integer cupon;

	private String nro_tarjeta;

	private Integer nro_valor;

	private Caja caja;

	private Boolean estaEnCaja;

	private Money saldo;

	private Money importe;

	private Usuario usuario;

	private ValorCotizacion cotizacion;

	private Sujeto sujeto;

	private Integer lote;

	private Integer cuotas;

	private boolean depositarCheque;

	private String nroCertificado;

	private Provincia provincia;

	private boolean devuelto;

	private String codigoAutorizacion;

	private String cuit;

	private java.util.Date nuevaFecVto;
	
	private Proveedor proveedor;
	
	private Boolean liquidado;

	public void setCUIT(String aCUIT) throws BaseException {
		this.cuit = aCUIT;
	}

	public String getCUIT() throws BaseException {
		supportRefresh();
		return this.cuit;
	}
	
	public void setProveedor(Proveedor aProveedor) throws BaseException {
		this.proveedor = aProveedor;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return this.proveedor;
	}
	

	public void setNuevaFecVto(java.util.Date aNuevaFecVto) throws BaseException {
		this.nuevaFecVto = aNuevaFecVto;
	}

	public java.util.Date getNuevaFecVto() throws BaseException {
		supportRefresh();
		return this.nuevaFecVto;
	}

	public void setDepositarCheque(boolean aDepositarCheque) throws BaseException {
		this.depositarCheque = aDepositarCheque;
	}

	public String getCodigoAutorizacion() throws BaseException {
		supportRefresh();
		return this.codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String aCodigoAutorizacion) {
		this.codigoAutorizacion = aCodigoAutorizacion;
	}

	public boolean isDepositandoCheque() throws BaseException {
		return this.depositarCheque;
	}

	public void setDevuelto(boolean aDevuelto) throws BaseException {
		this.devuelto = aDevuelto;
	}

	public boolean isDevuelto() throws BaseException {
		return this.devuelto;
	}

	public void setProvincia(Provincia aProvincia) throws BaseException {
		this.provincia = aProvincia;
	}

	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return this.provincia;
	}

	public void setNroCertificado(String aNroCertificado) throws BaseException {
		this.nroCertificado = aNroCertificado;
	}

	public String getNroCertificado() throws BaseException {
		supportRefresh();
		return this.nroCertificado;
	}

	public TipoValor getTipovalor() throws BaseException {
		supportRefresh();
		return tipoValor;
	}

	public void setTipovalor(TipoValor aTipovalor) {
		this.tipoValor = aTipovalor;
	}

	public Integer getLote() throws BaseException {
		supportRefresh();
		return lote;
	}

	public void setLote(Integer aLote) {
		this.lote = aLote;
	}

	public Integer getCuotas() throws BaseException {
		supportRefresh();
		return cuotas;
	}

	public void setCuotas(Integer aCuotas) {
		this.cuotas = aCuotas;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aValorCotizacion) {
		this.cotizacion = aValorCotizacion;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public TarjetaCredito getTarjetacredito() throws BaseException {
		supportRefresh();
		return tarjetaCredito;
	}

	public void setTarjetacredito(TarjetaCredito aTarjetacredito) {
		this.tarjetaCredito = aTarjetacredito;
	}

	public Ticket getTicket() throws BaseException {
		supportRefresh();
		return ticket;
	}

	public void setTicket(Ticket aTicket) {
		this.ticket = aTicket;
	}

	public Banco getBanco() throws BaseException {
		supportRefresh();
		return banco;
	}

	public void setBanco(Banco aBanco) {
		this.banco = aBanco;
	}

	public Integer getNrocheque() throws BaseException {
		supportRefresh();
		return nroCheque;
	}

	public void setNrocheque(Integer aNrocheque) {
		this.nroCheque = aNrocheque;
	}

	public Date getFechaemision() throws BaseException {
		supportRefresh();
		return fechaEmision;
	}

	public void setFechaemision(Date aFechaemision) {
		this.fechaEmision = aFechaemision;
	}

	public Date getFechavto() throws BaseException {
		supportRefresh();
		return fechaVto;
	}

	public void setFechavto(Date aFechavto) {
		this.fechaVto = aFechavto;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean aAnulado) {
		this.anulado = aAnulado;
	}

	public Boolean isEndosado() throws BaseException {
		supportRefresh();
		return endosado;
	}

	public void setEndosado(Boolean aEndosado) {
		this.endosado = aEndosado;
	}

	public CuentaBancaria getCuentabancaria() throws BaseException {
		supportRefresh();
		return cuentaBancaria;
	}

	public void setCuentabancaria(CuentaBancaria aCuentabancaria) {
		this.cuentaBancaria = aCuentabancaria;
	}

	public Boolean isDepositado() throws BaseException {
		supportRefresh();
		return depositado;
	}

	public void setDepositado(Boolean aDepositado) {
		this.depositado = aDepositado;
	}
	
	public Boolean isLiquidado() throws BaseException {
		supportRefresh();
		return liquidado;
	}

	public void setLiquidado(Boolean aLiquidado) {
		this.liquidado = aLiquidado;
	}
	

	public Boolean isRechazado() throws BaseException {
		supportRefresh();
		return rechazado;
	}

	public void setRechazado(Boolean aRechazado) {
		this.rechazado = aRechazado;
	}

	public Boolean isCobrado() throws BaseException {
		supportRefresh();
		return cobrado;
	}

	public void setCobrado(Boolean aCobrado) {
		this.cobrado = aCobrado;
	}

	public String getTitular() throws BaseException {
		supportRefresh();
		return titular;
	}

	public void setTitular(String aTitular) {
		this.titular = aTitular;
	}

	public Boolean isRecibido() throws BaseException {
		supportRefresh();
		return recibido;
	}

	public void setRecibido(Boolean aRecibido) {
		this.recibido = aRecibido;
	}

	public Integer getCupon() throws BaseException {
		supportRefresh();
		return cupon;
	}

	public void setCupon(Integer aCupon) {
		this.cupon = aCupon;
	}

	public String getNro_tarjeta() throws BaseException {
		supportRefresh();
		return nro_tarjeta;
	}

	public void setNro_tarjeta(String aNro_tarjeta) {
		this.nro_tarjeta = aNro_tarjeta;
	}

	public Integer getNro_valor() throws BaseException {
		supportRefresh();
		return nro_valor;
	}

	public void setNro_valor(Integer aNro_valor) {
		this.nro_valor = aNro_valor;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public Boolean isEstaencaja() throws BaseException {
		supportRefresh();
		return estaEnCaja;
	}

	public void setEstaencaja(Boolean aEstaencaja) {
		this.estaEnCaja = aEstaencaja;
	}

	public Money getSaldo() throws BaseException {
		supportRefresh();
		return saldo;
	}

	public void setSaldo(Money aSaldo) {
		this.saldo = aSaldo;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Valor findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Valor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Valor findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Valor) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Valor findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Valor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

	}

	@Override
	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();

		if (this.getTipovalor() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Tipo de Valor");

		// Validar que se ecuentren completos todos los dados
		if (this.getTipovalor().isCuponTarjetaDebito())
			validarTarjetaDebito();
		else if (this.getTipovalor().isTarjetaCredito())
			validarTarjetaCredito();
		else if (this.getTipovalor().isCertificadoRetIB())
			validarCertificadoRetencionIB();
		else if (this.getTipovalor().isCertificadoRetGan())
			validarCertificadoRetencionGanancias();
		else if (this.getTipovalor().isCertificadoRetIVA())
			validarCertificadoRetencionIVA();
		else if (this.getTipovalor().isCertificadoRetSUS())
			validarCertificadoRetencionSUS();
		else if (this.getTipovalor().isLiquidacionTarjetaCredito())
			validarLiquidacionTarjetaCredito();
		else if (this.getTipovalor().isChequeCliente() || this.getTipovalor().isChequeTercero())
			validarChequeCliente();

	}
	
	
	private void validarLiquidacionTarjetaCredito() throws BaseException {

		if ((this.getTarjetacredito() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Tarjeta de Crédito");

		if ((this.getNrocheque() == null))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Liquidación");

		if ((this.getFechavto() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe");

	}
	

	private void validarChequeCliente() throws BaseException {

		if ((this.getBanco() == null))
			throw new ExceptionValidation(null, "Debe ingresar el Banco del cheque");

		if ((this.getNrocheque() == null))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Cheque");

		if ((this.getFechavto() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento del Cheque");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión del Cheque");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe del Cheque");

	}

	private void validarCertificadoRetencionGanancias() throws BaseException {

		if ((this.getNroCertificado() == null) || (this.getNroCertificado().length() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Certificado de Retención de Ganancias");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión del Certificado de Ganancias");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe del Certificado de Retención de Ganancias");

	}

	private void validarCertificadoRetencionIVA() throws BaseException {

		if ((this.getNroCertificado() == null) || (this.getNroCertificado().length() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Certificado de Retención de IVA");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión del Certificado de Retención de IVA");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe del Certificado de Retención de IVA");

	}

	private void validarCertificadoRetencionSUS() throws BaseException {

		if ((this.getNroCertificado() == null) || (this.getNroCertificado().length() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Certificado de Retención de SUS");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión del Certificado de Retención de SUS");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe del Certificado de Retención de SUS");

	}

	private void validarCertificadoRetencionIB() throws BaseException {

		if ((this.getNroCertificado() == null) || (this.getNroCertificado().length() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de Certificado de Retención de I.B.");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión del Certificado de Retención de I.B.");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe del Certificado de Retención de I.B.");

		if ((this.getProvincia() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Provincia del Certificado de Retención de I.B.");

	}

	private void validarTarjetaDebito() throws BaseException {

		if (this.getBanco() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Banco para la tarjeta de Dóbito");

		if ((this.getNro_tarjeta() == null) || (this.getNro_tarjeta().length() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de la Tarjeta de Débito");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión de la Tarjeta de Débito");

		if ((this.getFechavto() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento de la Tarjeta de Débito");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe de la Tarjeta de Débito");

	}

	private void validarTarjetaCredito() throws BaseException {

		if (this.getTarjetacredito() == null)
			throw new ExceptionValidation(null, "Debe ingresar la Tarjeta de Crédito");

		if ((this.getNro_tarjeta() == null) || (this.getNro_tarjeta().length() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el Nro. de la Tarjeta de Crédito");

		if ((this.getFechaemision() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Emisión de la Tarjeta de Crédito");

		if ((this.getFechavto() == null))
			throw new ExceptionValidation(null, "Debe ingresar la Fecha de Vencimiento de la Tarjeta de Crédito");

		if ((this.getImporte() == null) || (this.getImporte().doubleValue() == 0))
			throw new ExceptionValidation(null, "Debe ingresar el importe de la Tarjeta de Crédito");

	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return null;
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */

	public String getNroValorGenerico() throws BaseException {
		StringBuffer nroValor = new StringBuffer();
		// Armar descripciones segun el comportamiento del tipo de valor
		if (this.getTipovalor().isChequeCliente() || this.getTipovalor().isChequeTercero()) {
			nroValor.append(this.getNrocheque());
		} else if (this.getTipovalor().isTarjetaCredito()) {
			nroValor.append(this.getNro_tarjeta());
		} else if (this.getTipovalor().isTicket()) {
			nroValor.append(this.getNro_valor());
		} else if (this.getTipovalor().isDocumentoCliente()) {
			nroValor.append(this.getNro_valor());
		} else if (this.getTipovalor().isChequePropio()) {
			nroValor.append(this.getNrocheque());
		} else if (this.getTipovalor().isCuponTarjetaDebito()) {
			nroValor.append(this.getNro_tarjeta());
		} else if (this.getTipovalor().isCertificadoRetGan() || this.getTipovalor().isCertificadoRetIVA()
				|| this.getTipovalor().isCertificadoRetSUS() || this.getTipovalor().isCertificadoRetIB()) {
			nroValor.append(this.getNroCertificado());
		} else
			nroValor.append("");

		return nroValor.toString();

	}
	
	public Integer getNroValorGenericoNumerico() throws BaseException {
		try {
			return new Integer(getNroValorGenerico().trim());
		} catch(Exception e) {
			return new Integer(0);
		}
	}

	public String getDescripcion() throws BaseException {

		StringBuffer descValor = new StringBuffer();
		// Armar descripciones segun el comportamiento del tipo de valor
		if (this.getTipovalor().isChequeCliente() || this.getTipovalor().isChequeTercero()) {
			descValor.append(this.getBanco().getDescripcion().trim() + " ");
			descValor.append(" Nro. " + this.getNrocheque().toString() + " ");
			descValor.append(" Emisión " + Fecha.getddmmyyyy(this.getFechaemision()) + " ");
			descValor.append(" Vto. " + Fecha.getddmmyyyy(this.getFechavto()) + " ");
			if (this.getSujeto() != null)
				descValor.append(this.getSujeto().getRazon_social() + " ");
			if ((this.getCUIT() != null) && (this.getCUIT().length() > 0))
				descValor.append("C.U.I.T. " + this.getCUIT()+" ");
		}
		if (this.getTipovalor().isChequePropio()) {
			if (this.getCuentabancaria() != null)
				descValor.append(this.getCuentabancaria().getDescripcion().trim() + " ");
			if (this.getNrocheque() != null)
				descValor.append(" Nro. " + this.getNrocheque().toString() + " ");
			if (this.getFechaemision() != null)
				descValor.append(" Emisión " + Fecha.getddmmyyyy(this.getFechaemision()) + " ");
			if (this.getFechavto() != null)
				descValor.append(" Vto. " + Fecha.getddmmyyyy(this.getFechavto()) + " ");
		}

		else if (this.getTipovalor().isTarjetaCredito()) {
			descValor.append(this.getTarjetacredito().getDescripcion() + " ");
			descValor.append(" Nro. " + this.getNro_tarjeta() + " ");
			if (this.getFechaemision()!=null)
				descValor.append(" Emisión " + Fecha.getddmmyyyy(this.getFechaemision()) + " ");
			if (this.getFechavto()!=null)
				descValor.append(" Vto. " + Fecha.getddmmyyyy(this.getFechavto()) + " ");
			if (this.getLote()!=null)
				descValor.append(" Lote " + this.getLote().toString() + " ");
			if (this.getCupon()!=null)
				descValor.append(" Cupón " + this.getCupon().toString() + " ");
			if (this.getCuotas()!=null)
				descValor.append(" Cuotas " + this.getCuotas().toString() + " ");
			if (this.getCodigoAutorizacion()!=null)
				descValor.append("Cód. Aut. " + this.getCodigoAutorizacion()+" ");
			
		} else if (this.getTipovalor().isTicket()) {
			descValor.append(this.getTicket().getDescripcion() + " ");
		} else if (this.getTipovalor().isTransClieBanco()) {
			descValor.append(this.getCuentabancaria().getDescripcion() + " Tranf. Nro. " + this.getNro_valor());
		} else if (this.getTipovalor().isDocumentoCliente()) {
			descValor.append(this.getTipovalor().getDescripcion() + " ");
		} else if (this.getTipovalor().isCuponTarjetaDebito()) {
			descValor.append(this.getBanco().getDescripcion().trim() + " ");
			descValor.append(" Nro. " + this.getNro_tarjeta() + " ");
			descValor.append(" Emisión " + Fecha.getddmmyyyy(this.getFechaemision()) + " ");
			descValor.append(" Vto. " + Fecha.getddmmyyyy(this.getFechavto()) + " ");
			descValor.append(" Lote " + this.getLote().toString() + " ");
			descValor.append(" Cupón " + this.getCupon().toString() + " ");
		} else if (this.getTipovalor().isCertificadoRetGan() || this.getTipovalor().isCertificadoRetIVA()
				|| this.getTipovalor().isCertificadoRetSUS() || this.getTipovalor().isCertificadoRetIB()) {
			if (this.getTipovalor().isCertificadoRetIB())
				descValor.append(" Provincia " + this.getProvincia().getDescripcion());
			descValor.append(" Nro. " + this.getNroCertificado().trim() + " ");
			descValor.append(" Emisión " + Fecha.getddmmyyyy(this.getFechaemision()) + " ");
		} else
			descValor.append(this.getTipovalor().getDescripcion());

		return descValor.toString();
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public static List getChequesEnCaja(Caja caja, ISesion aSesion) throws BaseException {
		return DBValor.getChequesEnCartera(caja, aSesion);
	}

	public static List getChequesClientesEnCartera(Caja caja, ISesion aSesion) throws BaseException {
		return DBValor.getChequesClientes(caja, aSesion);
	}

	public static List getChequesTercerosEnCartera(Caja caja, ISesion aSesion) throws BaseException {
		return DBValor.getChequesTerceros(caja, aSesion);
	}

	public static List getCuponesTarCredEnCartera(Caja caja, ISesion aSesion) throws BaseException {
		return DBValor.getCuponesTarCredEnCartera(caja, aSesion);
	}

	public static List getCuponesTicket(Caja caja, ISesion aSesion) throws BaseException {
		return DBValor.getCuponesTicket(caja, aSesion);
	}

	public static List getDocumentosClientes(Caja caja, ISesion aSesion) throws BaseException {
		return DBValor.getDocumentosClientes(caja, aSesion);
	}

	public static List getCuponesTarDebito(Caja caja, ISesion aSesion) throws BaseException {
		return DBValor.getCuponesTarDebito(caja, aSesion);
	}

	public static List getValoresEnCaja(Caja caja, Sujeto sujeto, TipoValor tipoValor, List tiposValores, ISesion aSesion)
			throws BaseException {
		return DBValor.getValoresEnCartera(caja, sujeto, tipoValor, tiposValores, aSesion);
	}

	public static List getValoresEnCaja(Caja caja, Sujeto sujeto, List listaTiposValor, ISesion aSesion) throws BaseException {
		return DBValor.getValoresEnCartera(caja, sujeto, listaTiposValor, aSesion);
	}

	public static List getValoresEnCajaCliente(Caja caja, Sujeto sujeto, ISesion aSesion) throws BaseException {
		return DBValor.getValoresEnCartera(caja, sujeto, aSesion);
	}

	public String getDescEntidad() throws BaseException {
		if (this.getBanco() != null)
			return this.getBanco().getDescripcion().trim();
		else if (this.getTicket() != null)
			return this.getTicket().getDescripcion();
		else if (this.getTarjetacredito() != null)
			return this.getTarjetacredito().getDescripcion();
		else if (this.getCuentabancaria() != null)
			return this.getCuentabancaria().getDescripcion();
		return this.getTipovalor().getDescripcion();
	}

	public String getCodEntidad() throws BaseException {
		if (this.getBanco() != null)
			return this.getBanco().getCodigo().trim();
		else if (this.getTicket() != null)
			return this.getTicket().getCodigo();
		else if (this.getTarjetacredito() != null)
			return this.getTarjetacredito().getCodigo();

		return "";
	}

	public Valor buscarValorEnCaja(Caja caja, TipoValor tipoValor, Banco banco, Integer nro, Date fecEmision, Date fecVto, Money importe)
			throws BaseException {

		return null;
	}

	public static void cambiarCaja(Valor valor, Caja caja, ISesion aSesion) throws BaseException {
		DBValor.cambiarCaja(valor, caja, aSesion);
	}

	public static List getValoresDeudaFinanProv(
			java.util.Date fecha, 
			Proveedor proveedor,
			java.util.Date fechaEmisionHasta,
			ISesion aSesion) throws BaseException {
		return DBValor.getValoresDeudaFinanProv(fecha, proveedor,fechaEmisionHasta,aSesion);
	}

	public static void cambiarNuevaFecVto(Valor valor, java.util.Date fecha, ISesion aSesion) throws BaseException {
		DBValor.cambiarNuevaFecVto(valor, fecha, aSesion);
	}

	public java.util.Date getFechaCF() throws BaseException {
		if (this.getNuevaFecVto() != null)
			return this.getNuevaFecVto();
		else
			return this.getFechavto();
	}

	public static List getBusquedaValores(Caja caja, java.util.Date fecEmiDesde, java.util.Date fecEmiHasta, java.util.Date fecVtoDesde,
			java.util.Date fecVtoHasta, TipoValor tipoValor, Sujeto sujeto, String cuit, Integer nroCheque, String nroTarjeta, Money importe,
			Banco banco, TarjetaCredito tarjeta, Integer nroLote, Integer nroCupon, String codAutorizacion, ISesion aSesion)
			throws BaseException {

		return DBValor.getBusquedaValores(caja, fecEmiDesde, fecEmiHasta, fecVtoDesde, fecVtoHasta, tipoValor, sujeto, cuit, nroCheque,
				nroTarjeta, importe, banco, tarjeta, nroLote, nroCupon, codAutorizacion, aSesion);
	}
	
	public static List getValoresDeudaFinanClie(java.util.Date fecha,
			Sujeto sujeto,
			Caja caja,
			TipoValor tipoValor,
			java.util.Date fecEmiHasta,
			ISesion aSesion) throws BaseException {
		return DBValor.getValoresDeudaFinanClie(fecha,sujeto,caja,tipoValor,fecEmiHasta,aSesion); 
	}
	
	  public static java.util.Date getFechaDeudaFinan(ISesion aSesion) throws BaseException {
		  
		  Integer dias = ValorParametro.findByCodigoParametro(
					"CLEARING_DIAS_DEUDA_FINAN", aSesion).getValorEntero();
		  
		  return Fecha.getFechaMasDias(Fecha.getFechaActual(), (dias+1)*-1);
		  
	  }
	  
	  public static java.util.Date getFechaDeudaFinanProv(ISesion aSesion) throws BaseException {
		  
		  Integer dias = ValorParametro.findByCodigoParametro(
					"CLEARING_DIAS_DEUDA_FINAN_PROV", aSesion).getValorEntero();
		  
		  return Fecha.getFechaMasDias(Fecha.getFechaActual(), dias*-1);
		  
	  }
	  
	  public CuentaImputable getCuentaImputable() throws BaseException {
		  CuentaImputable cuentaImpu = null;
		  if (this.getTipovalor().getCuentaImputable()!=null)
			  return this.getTipovalor().getCuentaImputable();
		  else if (this.getTipovalor().getCuenta()!=null) {
			  HashTableDatos valoresCompo = new HashTableDatos();
				Cuenta cuenta = this.getTipovalor().getCuenta();
				if ((cuenta!=null) && (cuenta.getEstructura()!=null)) {
					
					Iterator iterCompo = 
						cuenta.getEstructura().getEstrucComponenentes().iterator();
					while (iterCompo.hasNext()) {
						EstructuraCompo estrucCompo = (EstructuraCompo) iterCompo.next();
						if (estrucCompo.getComponente().getNombreNickName().equals(Valor.NICKNAME))
								valoresCompo.put(estrucCompo.getComponente(),this);
						else if (estrucCompo.getComponente().getNombreNickName().equals(TarjetaCredito.NICKNAME))
								valoresCompo.put(estrucCompo.getComponente(),this.getTarjetacredito());
					}
					
					return CuentaImputable.getImputable(cuenta,valoresCompo,this.getSesion());
				} 
			  
		  } else if (this.getTipovalor().isTransClieBanco())
				return this.getCuentabancaria().getCuentaimputableAConciliar();
			  
		  return cuentaImpu;
	  }
	  
	  
		public static List getTarjetasPendLiquidar(
				TipoValor tipoValor,
				TarjetaCredito tarjetaCredito,
				Banco banco,
				Caja caja,
				java.util.Date fecEmiDesde,
				java.util.Date fecEmiHasta,
				ISesion aSesion) throws BaseException {
			
			return DBValor.getTarjetasPendLiquidar(tipoValor, tarjetaCredito, banco, caja, fecEmiDesde, fecEmiHasta, aSesion);
		}
		
		public boolean isValorEnCartera() throws BaseException {
			if (this.isEstaencaja() && 
			   (!this.isAnulado()) && 
			   (!this.isDevuelto()) && 
			   (!this.isEndosado()) && 
			   (!this.isDepositado()) && 
			   (!this.isRechazado()) && 
			   (!this.isCobrado()) &&
			   (!this.isLiquidado())
			   )
				return true;
			else
				return false;
		}
	  
}
