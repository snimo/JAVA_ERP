package com.srn.erp.tesoreria.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.tesoreria.da.DBLiquidacionTarjetaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LiquidacionTarjetaDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public LiquidacionTarjetaDet() {
	}

	public static String NICKNAME = "va.LiquidacionTarjetaDet";

	private LiquidacionTarCab liquidacion_tar;
	private Valor valor;
	private Money importe_liquidado;
	private Boolean activo;
	private Integer nroCuota;

	public LiquidacionTarCab getLiquidacion_tar() throws BaseException {
		supportRefresh();
		return liquidacion_tar;
	}

	public void setLiquidacion_tar(LiquidacionTarCab aLiquidacion_tar) {
		this.liquidacion_tar = aLiquidacion_tar;
	}

	public Integer getNroCuota() throws BaseException {
		supportRefresh();
		return this.nroCuota;
	}

	public void setNroCuota(Integer aNroCuota) {
		this.nroCuota = aNroCuota;
	}

	public Valor getValor() throws BaseException {
		supportRefresh();
		return valor;
	}

	public void setValor(Valor aValor) {
		this.valor = aValor;
	}

	public Money getImporte_liquidado() throws BaseException {
		supportRefresh();
		return importe_liquidado;
	}

	public void setImporte_liquidado(Money aImporte_liquidado) {
		this.importe_liquidado = aImporte_liquidado;
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

	public static LiquidacionTarjetaDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LiquidacionTarjetaDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LiquidacionTarjetaDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LiquidacionTarjetaDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(liquidacion_tar, "Debe ingresar la Liquidación");
		Validar.noNulo(valor, "Debe ingresar el Valor");
	}

	public static List getLiquidacionTarjetasDet(LiquidacionTarCab liquidacionTarCab, ISesion aSesion) throws BaseException {
		return DBLiquidacionTarjetaDet.getLiquidacionTarjetasDet(liquidacionTarCab, aSesion);
	}


}
