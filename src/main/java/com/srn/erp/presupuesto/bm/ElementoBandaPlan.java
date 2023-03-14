package com.srn.erp.presupuesto.bm;

public class ElementoBandaPlan implements Comparable {
	
	public static final String UBI_FIJO_IZQUIERDA = "I";
	public static final String UBI_FIJO_DERECHA = "D";
	public static final String UBI_CENTRO = "C";
	
	private int nroBanda;
	private int nroOrden;
	private String titulo;
	private String ubicacion;
	
	public int getNroBanda() {
		return nroBanda;
	}
	public void setNroBanda(int nroBanda) {
		this.nroBanda = nroBanda;
	}
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public int compareTo(Object arg0) {
		ElementoBandaPlan aElementoBandaPlan = (ElementoBandaPlan) arg0;
		if (aElementoBandaPlan.nroOrden<this.nroOrden)
			return 1;
		else if (aElementoBandaPlan.nroOrden>this.nroOrden)
			return -1;
		else return 0;
			
	}
		
}
