package com.srn.erp.conciTarjeta.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class RegCabPOSNET {
	
	private String  estado;
	private String  nroHost;
	private String  nombreHost;
	private Integer nroLote;
	private Integer cantTransacciones;
	private String 	fechaCierre;
	private String 	nroTerminal;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNroHost() {
		return nroHost;
	}
	public void setNroHost(String nroHost) {
		this.nroHost = nroHost;
	}
	public String getNombreHost() {
		return nombreHost;
	}
	public void setNombreHost(String nombreHost) {
		this.nombreHost = nombreHost;
	}
	public Integer getNroLote() {
		return nroLote;
	}
	public void setNroLote(Integer nroLote) {
		this.nroLote = nroLote;
	}
	public Integer getCantTransacciones() {
		return cantTransacciones;
	}
	public void setCantTransacciones(Integer cantTransacciones) {
		this.cantTransacciones = cantTransacciones;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getNroTerminal() {
		return nroTerminal;
	}
	public void setNroTerminal(String nroTerminal) {
		this.nroTerminal = nroTerminal;
	}
	
	public int getDia() {
		return new Integer(fechaCierre.substring(0,2)).intValue();
	}
	
	public int getMes() {
		return new Integer(fechaCierre.substring(2,4)).intValue();
	}	
	
	public int getAnio() {
		return new Integer(fechaCierre.substring(4,6)).intValue()+2000;
	}	
	
	public java.util.Date getDateFechaCierre() throws BaseException {
		return Fecha.getFecha(this.getDia(), this.getMes(), this.getAnio());
	}
}
