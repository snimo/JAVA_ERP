package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.tesoreria.da.DBLiquidacionTarjetaValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LiquidacionTarjetaValor extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public LiquidacionTarjetaValor() {
	}

	public static String NICKNAME = "te.LiquidacionTarjetaValor";

	private LiquidacionTarCab liquidacion_tarjeta;
	private Valor valor;
	private Money importe;
	private Money importe_mon_loc;
	private ValorCotizacion cotizacion;
	private Integer nro;
	private TarjetaCredito tarjeta;
	private Cuenta cuenta;
	private Banco banco;
	private Boolean activo;

	public LiquidacionTarCab getLiquidacion_tarjeta() throws BaseException {
		supportRefresh();
		return liquidacion_tarjeta;
	}

	public void setLiquidacion_tarjeta(LiquidacionTarCab aLiquidacion_tarjeta) {
		this.liquidacion_tarjeta = aLiquidacion_tarjeta;
	}

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

	public Money getImporte_mon_loc() throws BaseException {
		supportRefresh();
		return importe_mon_loc;
	}

	public void setImporte_mon_loc(Money aImporte_mon_loc) {
		this.importe_mon_loc = aImporte_mon_loc;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public Integer getNro() throws BaseException {
		supportRefresh();
		return nro;
	}

	public void setNro(Integer aNro) {
		this.nro = aNro;
	}

	public TarjetaCredito getTarjeta() throws BaseException {
		supportRefresh();
		return tarjeta;
	}

	public void setTarjeta(TarjetaCredito aTarjeta) {
		this.tarjeta = aTarjeta;
	}

	public Cuenta getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(Cuenta aCuenta) {
		this.cuenta = aCuenta;
	}

	public Banco getBanco() throws BaseException {
		supportRefresh();
		return banco;
	}

	public void setBanco(Banco aBanco) {
		this.banco = aBanco;
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

	public static LiquidacionTarjetaValor findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LiquidacionTarjetaValor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LiquidacionTarjetaValor findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LiquidacionTarjetaValor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(liquidacion_tarjeta, "Debe ingresar la Liquidación");
		Validar.noNulo(valor, "Debe ingresar el Valor");
		Validar.noNulo(importe, "Debe ingresar el importe");
		Validar.noNulo(importe_mon_loc, "Debe ingresar el importe en moneda local");
		Validar.noNulo(cotizacion, "Debe ingresar la cotización");
		Validar.noNulo(nro, "Debe ingresar el Nro. del Valor");
	}

	public static List getLiquidacionesTarjetasValor(LiquidacionTarCab liquidacionTarCab, ISesion aSesion) throws BaseException {
		return DBLiquidacionTarjetaValor.getLiquidacionesTarjetasValor(liquidacionTarCab, aSesion);
	}

}
