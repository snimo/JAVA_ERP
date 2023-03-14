package com.srn.erp.ventas.bm;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bm.Varios.Money;

public class ConceptoTotales {
	
	int secu;
	String comportamiento;
	ConceptoImpuesto conceptoImpuesto;
	String descConcepto;
	Money importe;
	
	public void setSecu(int aSecu) {
		this.secu = aSecu;
	}
	
	public int getSecu() {
		return this.secu;
	}
	
	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}
	
	public String getComportamiento() {
		return this.comportamiento;
	}
	
	public void setConceptoImpuesto(ConceptoImpuesto aConceptoImpuesto) {
		this.conceptoImpuesto = aConceptoImpuesto;
	}
	
	public ConceptoImpuesto getConceptoImpuesto() {
		return this.conceptoImpuesto;
	}
	
	public void setDescConcepto(String aDescConcepto) {
		this.descConcepto = aDescConcepto;
	}
	
	public String getDescConcepto() {
		return this.descConcepto;
	}
	
	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}
	
	public Money getImporte() {
		return this.importe;
	}
	
	public String getClave() {
		String claveBusqueda = this.comportamiento;
		if (this.getConceptoImpuesto()!=null)
			 claveBusqueda = claveBusqueda + '_' + this.getConceptoImpuesto().getOIDInteger().toString();
		return claveBusqueda;
	}
	
	

}
