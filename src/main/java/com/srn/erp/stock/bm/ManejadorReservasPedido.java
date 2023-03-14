package com.srn.erp.stock.bm;

import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;


public class ManejadorReservasPedido extends ManejadorMovStock {
	
	private Deposito deposito;
	private Producto producto;
	private Double cantidad;
	private PedidoDet pedidoDet;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public PedidoDet getPedidoDet() {
		return pedidoDet;
	}

	public void setPedidoDet(PedidoDet pedidoDet) {
		this.pedidoDet = pedidoDet;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	
	public RenglonesStock getRenglonesStock() throws BaseException {

		RenglonesStock renglonesStock = new RenglonesStock();
		
		// Sacar de Libre
		EstadoStock estadoSalida = null;
		EstadoStock estadoEntrada = null;
		CalculadorMoney calcCantStock = new CalculadorMoney(new Money(this.getCantidad().doubleValue()));
		
		if (this.getCantidad().doubleValue()>0) {
			estadoSalida = EstadoStock.getEstadoStockLibre(this.getSesion());
			estadoEntrada = EstadoStock.getEstadoStockReservado(this.getSesion());
		} else {
			calcCantStock.multiplicarPor(new NumeroBase(-1));
			estadoEntrada = EstadoStock.getEstadoStockLibre(this.getSesion());
			estadoSalida = EstadoStock.getEstadoStockReservado(this.getSesion());
		}
			
		// Movimiento por la Salida de Producto	
		RenglonMovStock renglonMovStkSalida = renglonesStock.addRenglonMovStock();
		renglonMovStkSalida.setComproCab(this.getComprobante());
		renglonMovStkSalida.setDeposito(this.getDeposito());
		renglonMovStkSalida.setUbicacionDeposito(this.getDeposito().getUbicacionDepositoDefault());
		renglonMovStkSalida.setEstadoStock(estadoSalida);
		renglonMovStkSalida.setPartida(null);
		renglonMovStkSalida.setSerie(null);
		renglonMovStkSalida.setFecha(Fecha.getFechaActual());
		renglonMovStkSalida.setCantidad(calcCantStock.getResultMoney().doubleValue());
		renglonMovStkSalida.setSigno(new Integer(-1));
		renglonMovStkSalida.setUnidadMedida(this.getProducto().getUm_stk());
		renglonMovStkSalida.setAfectaStockFisico(new Boolean(false));
		renglonMovStkSalida.setActivo(new Boolean(true));
		renglonMovStkSalida.setProducto(this.getProducto());
		renglonMovStkSalida.setComproCabDestino(this.getComprobante());
		renglonMovStkSalida.setOidCCODet(this.getPedidoDet().getOIDInteger());
		renglonMovStkSalida.setOidCCODetDestino(this.getPedidoDet().getOIDInteger());
		
		
		
		// Movimiento por la entreda de Producto
		RenglonMovStock renglonMovStkEntrada = renglonesStock.addRenglonMovStock();
		renglonMovStkEntrada.setComproCab(this.getComprobante());
		renglonMovStkEntrada.setDeposito(this.getDeposito());
		renglonMovStkEntrada.setUbicacionDeposito(this.getDeposito().getUbicacionDepositoDefault());
		renglonMovStkEntrada.setEstadoStock(estadoEntrada);
		renglonMovStkEntrada.setPartida(null);
		renglonMovStkEntrada.setSerie(null);
		renglonMovStkEntrada.setFecha(Fecha.getFechaActual());
		renglonMovStkEntrada.setCantidad(calcCantStock.getResultMoney().doubleValue());
		renglonMovStkEntrada.setSigno(new Integer(1));
		renglonMovStkEntrada.setUnidadMedida(this.getProducto().getUm_stk());
		renglonMovStkEntrada.setAfectaStockFisico(new Boolean(false));
		renglonMovStkEntrada.setActivo(new Boolean(true));
		renglonMovStkEntrada.setProducto(this.getProducto());
		renglonMovStkEntrada.setComproCabDestino(this.getComprobante());
		renglonMovStkEntrada.setOidCCODet(this.getPedidoDet().getOIDInteger());
		renglonMovStkEntrada.setOidCCODetDestino(this.getPedidoDet().getOIDInteger());
		
		
		return renglonesStock;
	}
	

}
