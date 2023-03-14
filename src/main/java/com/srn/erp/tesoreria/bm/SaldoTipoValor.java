package com.srn.erp.tesoreria.bm;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.da.DBSaldoTipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class SaldoTipoValor extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public SaldoTipoValor() {
	}

	public static String NICKNAME = "te.SaldoTipoValor";

	private Moneda moneda;
	private Money saldo_inicial;
	private Money entradas;
	private Money salidas;
	private Money saldo_final;
	private Caja caja;

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Money getSaldo_inicial() throws BaseException {
		supportRefresh();
		return saldo_inicial;
	}

	public void setSaldo_inicial(Money aSaldo_inicial) {
		this.saldo_inicial = aSaldo_inicial;
	}

	public Money getEntradas() throws BaseException {
		supportRefresh();
		return entradas;
	}

	public void setEntradas(Money aEntradas) {
		this.entradas = aEntradas;
	}

	public Money getSalidas() throws BaseException {
		supportRefresh();
		return salidas;
	}

	public void setSalidas(Money aSalidas) {
		this.salidas = aSalidas;
	}

	public Money getSaldo_final() throws BaseException {
		supportRefresh();
		return saldo_final;
	}

	public void setSaldo_final(Money aSaldo_final) {
		this.saldo_final = aSaldo_final;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static SaldoTipoValor findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SaldoTipoValor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SaldoTipoValor findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SaldoTipoValor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static SaldoTipoValor getSaldoTipoValor(Caja caja, java.util.Date fecha, TipoValor tipoValor, ISesion aSesion)
			throws BaseException {
		return DBSaldoTipoValor.getSaldoTipoValor(caja, fecha, tipoValor, aSesion);
	}

	public static SaldoTipoValor getSaldoTipoValorAHoy(Caja caja, TipoValor tipoValor, ISesion aSesion) throws BaseException {
		return DBSaldoTipoValor.getSaldoTipoValorAHoy(caja, tipoValor, aSesion);
	}

}
