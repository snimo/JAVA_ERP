package com.srn.erp.tesoreria.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.tesoreria.da.DBMovimientoCtaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class MovimientoCtaBancaria extends ObjetoLogico {

	public static String SALDO_INICIAL = "SALDO_INI";

	public static String EMISION_CHE_PROP = "EMI_CHE_PRO";

	public static String TRANS_BANCA_CLIE = "TRA_BCA_CLI";

	public static String BOLETA_DEPOSITO = "BOL_DEP";

	public static String BOL_DEP_EFECTIVO = "BOL_DEP_EFE";

	public static String BOL_DEP_CHEQUE = "BOL_DEP_CHE";

	public static String NOTA_DEBITO = "NDB";

	public static String NOTA_CREDITO = "NCB";

	public static String ANULACION_OP = "ANU_OP";

	public static String ANULACION_RECIBO = "ANU_REC";

	public static final int ENTRADA = 1;

	public static final int SALIDA = -1;

	public MovimientoCtaBancaria() {
	}

	public static String NICKNAME = "ba.MovimientoCtaBancaria";

	private CuentaBancaria ctaBancaria;

	private Integer nroValor;

	private String tipoMov;

	private Date fechaContable;

	private Date fechaEmision;

	private Date fechaVto;

	private Integer signo;

	private Money importe;

	private ComproCab comprobante;

	private Boolean activo;

	private Money importeHist;

	private Money importeAju;

	private Money importeExt1;

	private Money importeExt2;

	private ValorCotizacion cotizMonOri;

	private ValorCotizacion cotizMonExt1;

	private ValorCotizacion cotizMonExt2;

	private ValorCotizacion cotizMonOriCon;

	private ValorCotizacion cotizMonExt1Con;

	private ValorCotizacion cotizMonExt2Con;

	private Date fechaOperativa;

	private Valor valor;

	private CuentaImputable cuenta;

	private TipoValor tipoValor;

	private Boolean conciliado;

	private ConciliacionCab conciliacionCab;

	public void setFechaOperativa(Date aFechaOperativa) throws BaseException {
		this.fechaOperativa = aFechaOperativa;
	}

	public Date getFechaOperativa() throws BaseException {
		this.supportRefresh();
		return this.fechaOperativa;
	}

	public void setConciliacionCab(ConciliacionCab aConciliacionCab) throws BaseException {
		this.conciliacionCab = aConciliacionCab;
	}

	public ConciliacionCab getConciliacionCab() throws BaseException {
		this.supportRefresh();
		return this.conciliacionCab;
	}

	public void setConciliado(Boolean aConciliado) throws BaseException {
		this.conciliado = aConciliado;
	}

	public Boolean isConciliado() throws BaseException {
		return this.conciliado;
	}

	public void setTipoValor(TipoValor aTipoValor) throws BaseException {
		this.tipoValor = aTipoValor;
	}

	public TipoValor getTipoValor() throws BaseException {
		this.supportRefresh();
		return this.tipoValor;
	}

	public void setValor(Valor aValor) throws BaseException {
		this.valor = aValor;
	}

	public Valor getValor() throws BaseException {
		return this.valor;
	}

	public void setCuenta(CuentaImputable aCuenta) throws BaseException {
		this.cuenta = aCuenta;
	}

	public CuentaImputable getCuenta() throws BaseException {
		return this.cuenta;
	}

	public ValorCotizacion getCotizMonOri() throws BaseException {
		supportRefresh();
		return cotizMonOri;
	}

	public void setCotizMonOri(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonOri = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt1() throws BaseException {
		supportRefresh();
		return cotizMonExt1;
	}

	public void setCotizMonExt1(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt1 = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt2() throws BaseException {
		supportRefresh();
		return cotizMonExt2;
	}

	public void setCotizMonExt2(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt2 = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonOriCon() throws BaseException {
		supportRefresh();
		return cotizMonOriCon;
	}

	public void setCotizMonOriCon(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonOriCon = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt1Con() throws BaseException {
		supportRefresh();
		return cotizMonExt1Con;
	}

	public void setCotizMonExt1Con(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt1Con = aValorCotizacion;
	}

	public ValorCotizacion getCotizMonExt2Con() throws BaseException {
		supportRefresh();
		return cotizMonExt2Con;
	}

	public void setCotizMonExt2Con(ValorCotizacion aValorCotizacion) throws BaseException {
		this.cotizMonExt2Con = aValorCotizacion;
	}

	public CuentaBancaria getCtabancaria() throws BaseException {
		supportRefresh();
		return ctaBancaria;
	}

	public void setCtabancaria(CuentaBancaria aCtabancaria) {
		this.ctaBancaria = aCtabancaria;
	}

	public Integer getNrovalor() throws BaseException {
		supportRefresh();
		return nroValor;
	}

	public void setNrovalor(Integer aNrovalor) {
		this.nroValor = aNrovalor;
	}

	public String getTipomov() throws BaseException {
		supportRefresh();
		return tipoMov;
	}

	public void setTipomov(String aTipomov) {
		this.tipoMov = aTipomov;
	}

	public Date getFechacontable() throws BaseException {
		supportRefresh();
		return fechaContable;
	}

	public void setFechacontable(Date aFechacontable) {
		this.fechaContable = aFechacontable;
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

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public Money getImportePorSigno() throws BaseException {
		CalculadorMoney impoPorSig = new CalculadorMoney(this.getImporte());
		impoPorSig.multiplicarPor(new Money(this.getSigno()));
		return impoPorSig.getResultMoney();
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Money getImportehist() throws BaseException {
		supportRefresh();
		return importeHist;
	}

	public void setImportehist(Money aImportehist) {
		this.importeHist = aImportehist;
	}

	public Money getImporteaju() throws BaseException {
		supportRefresh();
		return importeAju;
	}

	public void setImporteaju(Money aImporteaju) {
		this.importeAju = aImporteaju;
	}

	public Money getImporteext1() throws BaseException {
		supportRefresh();
		return importeExt1;
	}

	public void setImporteext1(Money aImporteext1) {
		this.importeExt1 = aImporteext1;
	}

	public Money getImporteext2() throws BaseException {
		supportRefresh();
		return importeExt2;
	}

	public void setImporteext2(Money aImporteext2) {
		this.importeExt2 = aImporteext2;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static MovimientoCtaBancaria findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MovimientoCtaBancaria) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MovimientoCtaBancaria findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MovimientoCtaBancaria) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MovimientoCtaBancaria findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MovimientoCtaBancaria) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public static List getMovCtaBancoContable(CuentaBancaria cuentaBancaria, java.util.Date fechaDesde, java.util.Date fechaHasta,
			ISesion aSesion) throws BaseException {
		return DBMovimientoCtaBancaria.getMovCtaBancoContable(cuentaBancaria, fechaDesde, fechaHasta, aSesion);
	}

	public static List getMovCtaBancoOperativos(CuentaBancaria cuentaBancaria, java.util.Date fechaDesde, java.util.Date fechaHasta,
			ISesion aSesion) throws BaseException {
		return DBMovimientoCtaBancaria.getMovCtaBancoOperativo(cuentaBancaria, fechaDesde, fechaHasta, aSesion);
	}

	public static String getDescTipoMov(String codigo) throws BaseException {
		if (codigo.equals(EMISION_CHE_PROP))
			return "Emisión Cheque";
		else if (codigo.equals(BOLETA_DEPOSITO))
			return "Depósito";
		else if (codigo.equals(BOL_DEP_EFECTIVO))
			return "Depósito Efectivo";
		else if (codigo.equals(SALDO_INICIAL))
			return "Saldo Inicial";
		else if (codigo.equals(BOL_DEP_CHEQUE))
			return "Depósito Cheque";
		else if (codigo.equals(NOTA_DEBITO))
			return "Debito";
		else if (codigo.equals(NOTA_CREDITO))
			return "Crédito";
		else if (codigo.equals(ANULACION_OP))
			return "Anulación O.P.";
		else if (codigo.equals(ANULACION_RECIBO))
			return "Anulación Recibo";		
		else if (codigo.equals(TRANS_BANCA_CLIE))
			return "Transferencia Bancaria Cliente";
		else
			return "No definido";

	}

	public static HashTableDatos getTiposMovimientos() throws BaseException {
		HashTableDatos tiposMovimientos = new HashTableDatos();
		tiposMovimientos.put(EMISION_CHE_PROP, getDescTipoMov(EMISION_CHE_PROP));
		tiposMovimientos.put(BOLETA_DEPOSITO, getDescTipoMov(BOLETA_DEPOSITO));
		tiposMovimientos.put(BOL_DEP_EFECTIVO, getDescTipoMov(BOL_DEP_EFECTIVO));
		tiposMovimientos.put(BOL_DEP_CHEQUE, getDescTipoMov(BOL_DEP_CHEQUE));
		tiposMovimientos.put(NOTA_DEBITO, getDescTipoMov(NOTA_DEBITO));
		tiposMovimientos.put(NOTA_CREDITO, getDescTipoMov(NOTA_CREDITO));
		tiposMovimientos.put(SALDO_INICIAL, getDescTipoMov(SALDO_INICIAL));
		tiposMovimientos.put(ANULACION_OP, getDescTipoMov(ANULACION_OP));
		tiposMovimientos.put(TRANS_BANCA_CLIE, getDescTipoMov(TRANS_BANCA_CLIE));
		tiposMovimientos.put(ANULACION_RECIBO, getDescTipoMov(ANULACION_RECIBO));
		return tiposMovimientos;
	}

	public static List getMovCtaBancoNoConciliados(CuentaBancaria cuentaBancaria, ISesion aSesion) throws BaseException {
		return DBMovimientoCtaBancaria.getMovCtaBancoNoConciliados(cuentaBancaria, aSesion);
	}

	public java.util.Date getFechaConciliacion() throws BaseException {
		if (this.getTipomov().equals(BOL_DEP_EFECTIVO)) {
			// Instanciar la Boleta de Depósito y Devolver la Fecha Correcta
			return this.getFechavto();
		}
		return this.getFechacontable();
	}

	public static MovimientoCtaBancaria getMovCuentaByCuentaValorSalida(CuentaBancaria cuentaBancaria, Valor valor, ISesion aSesion)
			throws BaseException {
		return DBMovimientoCtaBancaria.getMovCuentaByCuentaValorSalida(cuentaBancaria, valor, aSesion);
	}

	public static MovimientoCtaBancaria getMovByCuentaSignoValor(CuentaBancaria cuentaBancaria, Integer signo, Valor valor, ISesion aSesion)
			throws BaseException {
		return DBMovimientoCtaBancaria.getMovByCuentaSignoValor(cuentaBancaria, signo, valor, aSesion);
	}

}
