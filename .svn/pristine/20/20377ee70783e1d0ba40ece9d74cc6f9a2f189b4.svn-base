package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.List;

import framework.request.bl.Utils.BaseException;

public class ElementoFiltroPlan implements Comparable {
	
	private int nroOrden;
	private CompoPresupuestario compoPresu;
	private boolean usarEnFiltro;
	private boolean filtroObligatorio;
	private String tipoRestriccion;
	private boolean multipleSeleccion;
	
	private List listaValoresRestriccion = new ArrayList();
	
	public CompoPresupuestario getCompoPresu() {
		return compoPresu;
	}
	public void setCompoPresu(CompoPresupuestario compoPresu) {
		this.compoPresu = compoPresu;
	}
	public boolean isFiltroObligatorio() {
		return filtroObligatorio;
	}
	public void setFiltroObligatorio(boolean filtroObligatorio) {
		this.filtroObligatorio = filtroObligatorio;
	}
	public boolean isMultipleSeleccion() {
		return this.multipleSeleccion;
	}
	public void setMultipleSeleccion(boolean aMultipleSeleccion) {
		this.multipleSeleccion = aMultipleSeleccion;
	}
	
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public String getTipoRestriccion() {
		return tipoRestriccion;
	}
	public void setTipoRestriccion(String tipoRestriccion) {
		this.tipoRestriccion = tipoRestriccion;
	}
	public boolean isUsarEnFiltro() {
		return usarEnFiltro;
	}
	public void setUsarEnFiltro(boolean usarEnFiltro) {
		this.usarEnFiltro = usarEnFiltro;
	}
	
	public int compareTo(Object arg0) {
		ElementoFiltroPlan aElementoFiltroPlan = (ElementoFiltroPlan) arg0;
		if (aElementoFiltroPlan.nroOrden<this.nroOrden)
			return 1;
		else if (aElementoFiltroPlan.nroOrden>this.nroOrden)
			return -1;
		else return 0;
			
	}
	
	public void addValorPresu(ValorCompoPresu aValorCompoPresu) throws BaseException {
		this.listaValoresRestriccion.add(aValorCompoPresu);
	}
	
	
	
	

	
}
