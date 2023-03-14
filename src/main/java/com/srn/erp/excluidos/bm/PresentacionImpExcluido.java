package com.srn.erp.excluidos.bm;

public class PresentacionImpExcluido {
	
	private String nroLote;
	private String fecha;
	private String hora;
	private String codigoImportacion;
	private String eliminarTodo;
	
	public String getEliminarTodo() {
		return eliminarTodo;
	}
	public void setEliminarTodo(String eliminarTodo) {
		this.eliminarTodo = eliminarTodo;
	}
	public String getNroLote() {
		return nroLote;
	}
	public void setNroLote(String nroLote) {
		this.nroLote = nroLote;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getCodigoImportacion() {
		return codigoImportacion;
	}
	public void setCodigoImportacion(String codigoImportacion) {
		this.codigoImportacion = codigoImportacion;
	} 
}
