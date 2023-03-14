package com.srn.erp.tesoreria.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.da.DBMovimientoCtaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CuentaBancaria extends ObjetoLogico {

	public CuentaBancaria() {
	}

	public static String NICKNAME = "te.CuentaBancaria";

	private String codigo;
	private Banco banco;
	private String nroCuenta;
	private String descripcion;
	private Boolean activo;
	private String compo;
	private CuentaImputable cuentaImputableAConc;
	private CuentaImputable cuentaMovRealesBco;
	private Moneda moneda;
	private Integer clearingEnDias;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) throws BaseException {
		this.codigo = aCodigo;
	}

	public Integer getClearingEnDias() throws BaseException {
		supportRefresh();
		return this.clearingEnDias;
	}

	public void setClearingEnDias(Integer aClearingEnDias) throws BaseException {
		this.clearingEnDias = aClearingEnDias;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return this.moneda;
	}

	public void setMoneda(Moneda aMoneda) throws BaseException {
		this.moneda = aMoneda;
	}

	public Banco getBanco() throws BaseException {
		supportRefresh();
		return banco;
	}

	public void setBanco(Banco aBanco) {
		this.banco = aBanco;
	}

	public String getNrocuenta() throws BaseException {
		supportRefresh();
		return nroCuenta;
	}

	public void setNrocuenta(String aNrocuenta) {
		this.nroCuenta = aNrocuenta;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getCompo() throws BaseException {
		supportRefresh();
		return compo;
	}

	public void setCompo(String aCompo) {
		this.compo = aCompo;
	}

	public CuentaImputable getCuentaimputableAConciliar() throws BaseException {
		supportRefresh();
		return cuentaImputableAConc;
	}

	public void setCuentaimputableAConciliar(CuentaImputable aCuentaimputable) {
		this.cuentaImputableAConc = aCuentaimputable;
	}

	public CuentaImputable getCuentaMovRealesBco() throws BaseException {
		supportRefresh();
		return cuentaMovRealesBco;
	}

	public void setCuentaMovRealesBco(CuentaImputable aCuentaimputable) {
		this.cuentaMovRealesBco = aCuentaimputable;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CuentaBancaria findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CuentaBancaria) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CuentaBancaria findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CuentaBancaria) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CuentaBancaria findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CuentaBancaria) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(banco, "Debe ingresar el Banco");
		Validar.noNulo(nroCuenta, "Debe ingresar el Nro. de Cuenta");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(compo, "Debe ingresar el tipo de cuenta");
		Validar.noNulo(cuentaImputableAConc, "Debe ingresar la cuenta de imputación a conciliar");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public static Hashtable getTiposCuentas() throws BaseException {
		TipoCuentasBancarias tipoCuentas = new TipoCuentasBancarias();
		return tipoCuentas.getTipos();
	}

	public List getMovCtaBancoNoConciliados() throws BaseException {
		return DBMovimientoCtaBancaria.getMovCtaBancoNoConciliados(this, this.getSesion());
	}

	public MovimientoCtaBancaria getMovCuentaByCuentaValorSalida(Valor valor) throws BaseException {
		return MovimientoCtaBancaria.getMovCuentaByCuentaValorSalida(this, valor, this.getSesion());
	}
	
	public SaldoCuentaBanco getSaldo() throws BaseException {
		return SaldoCuentaBanco.getSaldo(this, this.getSesion());
	}
	

}
