package com.srn.erp.ventas.bm;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class PrecioEnLP {
	
	private Money precio;
	private Money cantidad;
	private UnidadMedida um;
	private Moneda moneda;
	
	public Money getCantidad() {
		return cantidad;
	}

	public void setCantidad(Money cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public Moneda getMoneda() {
		return moneda;
	}
	
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
	public Money getPrecio() {
		return precio;
	}
	
	public void setPrecio(Money precio) {
		this.precio = precio;
	}
	
	public UnidadMedida getUm() {
		return um;
	}
	
	public void setUm(UnidadMedida um) {
		this.um = um;
	}
	
	public Money getPrecioUnitario() throws BaseException {
		CalculadorMoney calcPU = new CalculadorMoney(this.getPrecio());
		calcPU.dividirPor(this.getCantidad());
		return calcPU.getResultMoney();
	}
	

}
