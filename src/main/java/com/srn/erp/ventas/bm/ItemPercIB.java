package com.srn.erp.ventas.bm;

import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bm.Varios.Money;

public class ItemPercIB {
	
	private Money netoGravado;
	private Producto producto;
	
	public Money getNetoGravado() {
		return netoGravado;
	}
	public void setNetoGravado(Money netoGravado) {
		this.netoGravado = netoGravado;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
