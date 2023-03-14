package com.srn.erp.ventas.bm;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bm.Varios.Money;

public class RenglonAnaCumpPed  implements Comparable {
	
	private Producto producto;
	private Integer nroRenglon;
	private String concepto;
	private java.util.Date fecha;
	private ComproCab comprobante;
	private String referencia;
	private Money cantidad;
	private Money saldo;
	private int signo;
	
	public int getSigno() {
		return signo;
	}
	public void setSigno(int signo) {
		this.signo = signo;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getNroRenglon() {
		return nroRenglon;
	}
	public void setNroRenglon(Integer nroRenglon) {
		this.nroRenglon = nroRenglon;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public java.util.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public ComproCab getComprobante() {
		return comprobante;
	}
	public void setComprobante(ComproCab comprobante) {
		this.comprobante = comprobante;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Money getCantidad() {
		return cantidad;
	}
	public void setCantidad(Money cantidad) {
		this.cantidad = cantidad;
	}
	public Money getSaldo() {
		return saldo;
	}
	public void setSaldo(Money saldo) {
		this.saldo = saldo;
	}
	
	public int compareTo(Object arg0) {

		RenglonAnaCumpPed aElemento = (RenglonAnaCumpPed) arg0;
		
		if (aElemento.getFecha().before(this.getFecha()))
			return 1;
		else if (aElemento.getFecha().equals(this.getFecha()))
			return 0;
		else
			return -1;

	}
	
}
