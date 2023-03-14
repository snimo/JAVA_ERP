package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBSaldoStkProdPorEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class SaldoStkProdPorEstado extends ObjetoLogico {

	public SaldoStkProdPorEstado() {
	}

	public static String NICKNAME = "st.SaldoStkProdPorEstado";

	private Producto producto;

	private UnidadMedida unidad_medida;

	private Deposito deposito;

	private EstadoStock estado_stock;

	private Double saldo;

	private Double movimiento;
	

	public void setMovimiento(Double aMovimiento) throws BaseException {
		this.movimiento = aMovimiento;
	}

	public Double getMovimiento() throws BaseException {
		return movimiento;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public EstadoStock getEstado_stock() throws BaseException {
		supportRefresh();
		return estado_stock;
	}

	public void setEstado_stock(EstadoStock aEstado_stock) {
		this.estado_stock = aEstado_stock;
	}

	public Double getSaldo() throws BaseException {
		supportRefresh();
		return saldo;
	}

	public void setSaldo(Double aSaldo) {
		this.saldo = aSaldo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static SaldoStkProdPorEstado findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SaldoStkProdPorEstado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SaldoStkProdPorEstado findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (SaldoStkProdPorEstado) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(deposito, "Debe ingresar el Depósito");
		Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
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

	public static SaldoStkProdPorEstado getSaldoStkProdPorEstado(
			Producto producto, Deposito deposito, EstadoStock estadoStock,
			ISesion aSesion) throws BaseException {
		return DBSaldoStkProdPorEstado.getSaldoStkProdPorEstado(producto,
				deposito, estadoStock, aSesion);
	}

	public static List getSaldosPorEstados(Producto producto,
			Deposito deposito, ISesion aSesion) throws BaseException {
		return DBSaldoStkProdPorEstado.getSaldosPorEstados(producto,deposito,aSesion);
	}
	
	public static List getSaldosPorEstados(List listaDepositos, List listaEstados, ISesion aSesion) throws BaseException {
		return DBSaldoStkProdPorEstado.getSaldosPorEstados(listaDepositos,listaEstados,aSesion); 
	}
	
	public static List getSaldosPorEstados(Producto producto, AgrupadorDeposito agrupadorDeposito, EstadoStock estadoStock, ISesion aSesion) throws BaseException {
		return DBSaldoStkProdPorEstado.getSaldosPorEstados(producto,agrupadorDeposito,estadoStock,aSesion);
	}
		
	

}
