package com.srn.erp.turnos.bm;

public class ItemDeudaSujetoTurno {

	public String getCodMov() {
		return codMov;
	}

	public void setCodMov(String codMov) {
		this.codMov = codMov;
	}

	public Integer getNroMov() {
		return nroMov;
	}

	public void setNroMov(Integer nroMov) {
		this.nroMov = nroMov;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public double getSaldoPendPago() {
		return this.getImporte()-this.getPagado();
	}

	public double getPagado() {
		return pagado;
	}

	public void setPagado(double pagado) {
		this.pagado = pagado;
	}

	private String codMov;
	private Integer nroMov;
	private java.util.Date fecha;
	private String concepto;
	private double importe;
	private double pagado;

	public ItemDeudaSujetoTurno() {

	}
	

}
