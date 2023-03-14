package com.srn.erp.tesoreria.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.tesoreria.da.DBTipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class TipoValor extends ObjetoLogico {

	public TipoValor() {
	}

	public static String NICKNAME = "te.TipoValor";

	private String codigo;
	private String descripcion;
	private String compo;
	private Moneda moneda;
	private Boolean activo;
	private CuentaImputable cuentaImputable;
	private Boolean seguimientoCaja;
	private Boolean depositable;
	private Boolean discValBolDep;
	private Boolean usarTipoValorEnOP;
	private Boolean esDeudaFinan;
	private Boolean esDeudaFinanProv;
	private Cuenta cuenta;
	private Caja cajaFija;

	public Boolean isUsarTipoValorEnOP() throws BaseException {
		supportRefresh();
		return this.usarTipoValorEnOP;
	}

	public void setUsarTipoValorEnOP(Boolean aUsarTipoValorEnOP) {
		this.usarTipoValorEnOP = aUsarTipoValorEnOP;
	}
	
	public Caja getCajaFija() throws BaseException {
		supportRefresh();
		return this.cajaFija;
	}

	public void setCajaFija(Caja aCajaFija) {
		this.cajaFija = aCajaFija;
	}
	
	
	public Boolean isDeudaFinanciera() throws BaseException {
		supportRefresh();
		return this.esDeudaFinan;
	}

	public void setEsDeudaFinanciera(Boolean aEsDuedaFinanciera) {
		this.esDeudaFinan = aEsDuedaFinanciera;
	}
	
	public Boolean isDeudaFinancieraProveedor() throws BaseException {
		supportRefresh();
		return this.esDeudaFinanProv;
	}
	
	public void setCuenta(Cuenta aCuenta) {
		this.cuenta = aCuenta;
	}
	
	public Cuenta getCuenta() throws BaseException {
		supportRefresh();
		return this.cuenta;
	}
	

	public void setEsDeudaFinancieraProveedor(Boolean aEsDuedaFinancieraProveedor) {
		this.esDeudaFinanProv = aEsDuedaFinancieraProveedor;
	}

	public CuentaImputable getCuentaImputable() throws BaseException {
		supportRefresh();
		return cuentaImputable;
	}

	public void setDepositable(Boolean aDepositable) {
		this.depositable = aDepositable;
	}

	public Boolean isDiscValBolDep() throws BaseException {
		supportRefresh();
		return this.discValBolDep;
	}

	public void setDiscValBolDep(Boolean aDiscValBolDep) {
		this.discValBolDep = aDiscValBolDep;
	}

	public Boolean isDepositable() throws BaseException {
		supportRefresh();
		return this.depositable;
	}

	public void setCuentaImputable(CuentaImputable aCuentaImputable) {
		this.cuentaImputable = aCuentaImputable;
	}

	public Boolean isSeguimientoCaja() throws BaseException {
		supportRefresh();
		return this.seguimientoCaja;
	}

	public void setSeguimientoCaja(Boolean aSeguimientoCaja) {
		this.seguimientoCaja = aSeguimientoCaja;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getCompo() throws BaseException {
		supportRefresh();
		return compo;
	}

	public void setCompo(String aCompo) {
		this.compo = aCompo;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TipoValor findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TipoValor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoValor findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TipoValor) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TipoValor findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (TipoValor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(compo, "Debe ingresar el Comportamiento");
		Validar.noNulo(moneda, "Debe ingresar la moneda");
		if ((!this.isChequePropio()) && (!this.isTransClieBanco())) {
			if ((this.getCuentaImputable() == null) && (this.getCuenta()==null))
				throw new ExceptionValidation(null,"Debe ingresar una cuenta");
			
		}

	}

	public static Hashtable getComportamientos() throws BaseException {
		return TipoValorCompo.getComportamientos();
	}

	public static List getTiposValorByFormaPago(FormaPago formaPago,
			ISesion aSesion) throws BaseException {
		return DBTipoValor.getTiposValorByFormaPago(formaPago, aSesion);
	}

	public static TipoValor getTipoValorByFormaPago(String codigo,
			FormaPago formaPago, ISesion aSesion) throws BaseException {
		return DBTipoValor.getValidarTipoValorByFormaPago(codigo, formaPago,
				aSesion);
	}

	public boolean isChequePropio() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_CHEQUE_PROPIO))
			return true;
		else
			return false;
	}

	public boolean isAfectaCaja() throws BaseException {
		if ((getCompo().equals(TipoValorCompo.TV_CHEQUE_TERCERO)
				|| getCompo().equals(TipoValorCompo.TV_DOCU_CLIE)
				|| getCompo().equals(TipoValorCompo.TV_CHEQUE_CLIENTE)
				|| getCompo().equals(TipoValorCompo.TV_EFECTIVO_ME)
				|| getCompo().equals(TipoValorCompo.TV_EFECTIVO_ML)
				|| getCompo().equals(TipoValorCompo.TV_TARJETA_CREDITO) || getCompo()
				.equals(TipoValorCompo.TV_TICKET)))
			return true;
		else
			return false;
	}

	public boolean isEfectivo() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_EFECTIVO_ME)
				|| getCompo().equals(TipoValorCompo.TV_EFECTIVO_ML))
			return true;
		else
			return false;
	}

	public boolean isTicket() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_TICKET))
			return true;
		else
			return false;
	}

	public boolean isDocumentoCliente() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_DOCU_CLIE))
			return true;
		else
			return false;
	}

	public boolean isTransClieBanco() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_TRA_CLI_BCO))
			return true;
		else
			return false;
		
	}
	
	public boolean isCuponTarjetaDebito() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_TAR_DEBITO))
			return true;
		else
			return false;
	}

	public boolean isCertificadoRetIVA() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_CERT_RET_IVA))
			return true;
		else
			return false;
	}

	public boolean isCertificadoRetGan() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_CERT_RET_GAN))
			return true;
		else
			return false;
	}

	public boolean isCertificadoRetIB() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_CERT_RET_IB))
			return true;
		else
			return false;
	}

	public boolean isCertificadoRetSUS() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_CERT_RET_SUS))
			return true;
		else
			return false;
	}
	
	public boolean isLiquidacionTarjetaCredito() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_LIQ_TCR))
			return true;
		else
			return false;
	}
	
	public boolean isTarjetaCredito() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_TARJETA_CREDITO))
			return true;
		else
			return false;
	}
	
	public boolean isChequeTercero() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_CHEQUE_TERCERO))
			return true;
		else
			return false;
	}

	public boolean isChequeCliente() throws BaseException {
		if (getCompo().equals(TipoValorCompo.TV_CHEQUE_CLIENTE))
			return true;
		else
			return false;
	}

	public static List getAllTiposValores(ISesion aSesion) throws BaseException {
		return DBTipoValor.getAllTiposValores(aSesion);
	}

	public static List getValoresIngresoRecibo(ISesion aSesion)
			throws BaseException {
		return DBTipoValor.getValoresIngresoRecibo(aSesion);
	}

	public boolean isIngresoRecibo() throws BaseException {
		if (this.getCompo().equals(TipoValorCompo.TV_EFECTIVO_ML))
			return true;
		else if (this.getCompo().equals(TipoValorCompo.TV_EFECTIVO_ME))
			return true;
		else if (this.getCompo().equals(TipoValorCompo.TV_CHEQUE_TERCERO))
			return true;
		else if (this.getCompo().equals(TipoValorCompo.TV_TARJETA_CREDITO))
			return true;
		else if (this.getCompo().equals(TipoValorCompo.TV_TICKET))
			return true;
		else if (this.getCompo().equals(TipoValorCompo.TV_DOCU_CLIE))
			return true;
		else if (this.getCompo().equals(TipoValorCompo.TV_TAR_DEBITO))
			return true;
		else if (this.getCompo().equals(TipoValorCompo.TV_CHEQUE_CLIENTE))
			return true;
		else
			return false;
	}

	public static TipoValor getTipoValorEfectivoPesos(ISesion aSesion)
			throws BaseException {
		Integer oidTipoValor = ValorParametro.findByCodigoParametro(
				"TIPO_VALOR_EFE_PESOS", aSesion).getOidObjNeg();
		TipoValor tipoValor = TipoValor.findByOid(oidTipoValor, aSesion);
		return tipoValor;
	}

	public static List getTiposValoresDepositables(ISesion aSesion)
			throws BaseException {
		return DBTipoValor.getTiposValoresDepositables(aSesion);
	}
	
	public static List getTiposValoresDeudaFinanciera(ISesion aSesion) throws BaseException {
		return DBTipoValor.getTiposValoresDeudaFinanciera(aSesion);
	}
	
	public static List getTiposValoresDeudaFinancieraProveedor(ISesion aSesion) throws BaseException {
		return DBTipoValor.getTiposValoresDeudaFinancieraProveedor(aSesion);
	}
	
	public static List getTiposValoresConMoviEnCaja(ISesion aSesion) throws BaseException {
		return DBTipoValor.getTiposValoresConMoviEnCaja(aSesion);
	}
	
	public static List getTiposValoresByComportamiento(String comportamiento,
			ISesion aSesion) throws BaseException {
		return DBTipoValor.getTiposValoresByComportamiento(comportamiento,aSesion);
	}
	
	public static List getTiposValoresByTCyTD(ISesion aSesion) throws BaseException {
		return TipoValor.getTiposValoresByTCyTD(aSesion);
	}
	

}
