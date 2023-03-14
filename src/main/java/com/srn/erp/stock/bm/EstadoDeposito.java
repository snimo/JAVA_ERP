package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBEstadoDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoDeposito extends ObjetoLogico {

	public EstadoDeposito() {
	}

	public static String NICKNAME = "st.EstadoDeposito";

	private Deposito deposito;

	private EstadoStock estado_stock;

	private Boolean allow_saldo_neg;

	private AgrupadorEstadoStock agrupadorEstadoStock;

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public AgrupadorEstadoStock getAgrupadorEstadoStock() throws BaseException {
		supportRefresh();
		return agrupadorEstadoStock;
	}

	public void setAgrupadorEstadoStock(
			AgrupadorEstadoStock aAgrupadorEstadoStock) {
		this.agrupadorEstadoStock = aAgrupadorEstadoStock;
	}

	public EstadoStock getEstado_stock() throws BaseException {
		supportRefresh();
		return estado_stock;
	}

	public void setEstado_stock(EstadoStock aEstado_stock) {
		this.estado_stock = aEstado_stock;
	}

	public Boolean isAllow_saldo_neg() throws BaseException {
		supportRefresh();
		return allow_saldo_neg;
	}

	public void setAllow_saldo_neg(Boolean aAllow_saldo_neg) {
		this.allow_saldo_neg = aAllow_saldo_neg;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EstadoDeposito findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (EstadoDeposito) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadoDeposito findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (EstadoDeposito) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(deposito, "Debe ingresar el Depósito");
		Validar.noNulo(estado_stock, "Debe ingresar el Estado");
		Validar.noNulo(agrupadorEstadoStock, "Debe ingresar el agrupador");
		Validar.noNulo(allow_saldo_neg,
				"Debe ingresar si permite o no saldo negativo");
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

	public static List getEstadosByDeposito(Deposito deposito, ISesion aSesion)
			throws BaseException {
		return DBEstadoDeposito.getEstadosDeposito(deposito, aSesion);
	}

	public static EstadoDeposito getEstadoDeposito(Deposito deposito,
			EstadoStock estadoStock, ISesion aSesion) throws BaseException {
		return DBEstadoDeposito.getEstadoDeposito(deposito, estadoStock,
				aSesion);
	}

	

}
