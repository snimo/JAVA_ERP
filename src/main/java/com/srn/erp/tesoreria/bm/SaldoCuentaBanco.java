package com.srn.erp.tesoreria.bm;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.da.DBSaldoCuentaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class SaldoCuentaBanco extends ObjetoLogico {

	public SaldoCuentaBanco() {
	}

	public static String		NICKNAME	= "te.SaldoCuentaBanco";

	private Moneda					moneda;

	private CuentaBancaria	cuenta_bancaria;

	private Money						saldo;

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public CuentaBancaria getCuenta_bancaria() throws BaseException {
		supportRefresh();
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(CuentaBancaria aCuenta_bancaria) {
		this.cuenta_bancaria = aCuenta_bancaria;
	}

	public Money getSaldo() throws BaseException {
		supportRefresh();
		return saldo;
	}

	public void setSaldo(Money aSaldo) {
		this.saldo = aSaldo;
	}

	public String getNickName() {
		return NICKNAME;
	}
	
	public static SaldoCuentaBanco findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SaldoCuentaBanco) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SaldoCuentaBanco findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SaldoCuentaBanco) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(cuenta_bancaria, "Debe ingresar la Cuenta Bancaria");
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

	public static SaldoCuentaBanco getSaldoInicialContableAFecha(java.util.Date fecha, CuentaBancaria cuentaBancaria,
			ISesion aSesion) throws BaseException {
		return DBSaldoCuentaBanco.getSaldoInicialContableAFecha(fecha, cuentaBancaria, aSesion);
	}
	
	public static SaldoCuentaBanco getSaldoInicialOperativoAFecha(java.util.Date fecha, CuentaBancaria cuentaBancaria,
			ISesion aSesion) throws BaseException {
		return DBSaldoCuentaBanco.getSaldoInicialOperativoAFecha(fecha, cuentaBancaria, aSesion);
	}

	public static SaldoCuentaBanco getSaldo(CuentaBancaria cuentaBancaria,
			ISesion aSesion) throws BaseException {
		return DBSaldoCuentaBanco.getSaldo(cuentaBancaria,aSesion);
	}
	

}
