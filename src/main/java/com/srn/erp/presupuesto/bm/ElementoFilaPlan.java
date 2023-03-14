package com.srn.erp.presupuesto.bm;

import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;

public class ElementoFilaPlan implements Comparable {
	
	private int NroPosColumna;
	private int tipoCampo;
	private String titulo;
	private int NroBanda;
	private boolean agrupar;
	private boolean filtros;
	private boolean busquedaInc;
	private boolean permitirCambiarOrden;
	private String ordenPorDefecto;
	private int anchoColumna;
	private CompoPresupuestario compoPresu;
	private String formato;
	private String formula;
	private String color;
	private int nroIntPosCol;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public CompoPresupuestario getCompoPresu() {
		return compoPresu;
	}

	public void setCompoPresu(CompoPresupuestario compoPresu) {
		this.compoPresu = compoPresu;
	}

	public void setNroPosCol(int aNroPosCol)  {
		this.NroPosColumna = aNroPosCol;
	}
	
	public int getNroPosCol() {
		return this.NroPosColumna;
	}

	public boolean isAgrupar() {
		return agrupar;
	}

	public void setAgrupar(boolean agrupar) {
		this.agrupar = agrupar;
	}

	public int getAnchoColumna() {
		return anchoColumna;
	}

	public void setAnchoColumna(int anchoColumna) {
		this.anchoColumna = anchoColumna;
	}

	public boolean isBusquedaInc() {
		return busquedaInc;
	}

	public void setBusquedaInc(boolean busquedaInc) {
		this.busquedaInc = busquedaInc;
	}

	public boolean isFiltros() {
		return filtros;
	}

	public void setFiltros(boolean filtros) {
		this.filtros = filtros;
	}

	public int getNroBanda() {
		return NroBanda;
	}

	public void setNroBanda(int nroBanda) {
		NroBanda = nroBanda;
	}

	public String getOrdenPorDefecto() {
		return ordenPorDefecto;
	}

	public void setOrdenPorDefecto(String ordenPorDefecto) {
		this.ordenPorDefecto = ordenPorDefecto;
	}

	public boolean isPermitirCambiarOrden() {
		return permitirCambiarOrden;
	}

	public void setPermitirCambiarOrden(boolean permitirCambiarOrden) {
		this.permitirCambiarOrden = permitirCambiarOrden;
	}

	public int getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(int tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int compareTo(Object arg0) {
		ElementoFilaPlan aElementoFilaPlan = (ElementoFilaPlan) arg0;
		if (aElementoFilaPlan.NroPosColumna<this.NroPosColumna)
			return 1;
		else if (aElementoFilaPlan.NroPosColumna>this.NroPosColumna)
			return -1;
		else return 0;
			
	}
	
	public String getValorCompoPresuParaPlan(ValorCompoPresu valorCompoPresu) throws BaseException {
		if (this.getTipoCampo() == 1)
			return valorCompoPresu.getCodigo();
		else
			if (this.getTipoCampo() == 2)
				return valorCompoPresu.getDescripcion();
			else
				if (this.getTipoCampo() == 3)
					return valorCompoPresu.getCodigo()+" - "+ valorCompoPresu.getDescripcion();
				else
					if (this.getTipoCampo() == 4)
						return valorCompoPresu.getDescripcion()+" - "+ valorCompoPresu.getCodigo();
		return "";
		
	}
	
	public String getCampoTabla() {		
		
		StringBuffer nombreCampoTabla = new StringBuffer();
		
		// Primera letra indica:
		//	C = Componente
		//  M = Metrica
		//  X = Metrica Calculado
		
		nombreCampoTabla.append("C");
		
		// Segunda letra indica que informacion del componente se va a visualizar en la columna
		
		// 1 - Codigo
		// 2 - Descripcion
		// 3 - Codigo / Descripcion
		// 4 - Descripcion / Codigo
		
		nombreCampoTabla.append(this.getTipoCampo());
		
		// De la letra 3 a la 10 estab reservadas
		nombreCampoTabla.append("XXXXXXX");
		
		// A Partir del caracer 11 inclusive va el numero del oid
		nombreCampoTabla.append(this.getCompoPresu().getOIDInteger().toString());
		return nombreCampoTabla.toString();
	}
	
	public String getTipoDatoCampoTabla() {
		if ((this.getTipoCampo()>=1 && this.getTipoCampo()<=4))
			return Field.STRING;
		else
			return "";
	}
	
	public Integer getSizeCampoTable() {
		return new Integer(255);
		
	}

	public int getNroIntPosCol() {
		return nroIntPosCol;
	}

	public void setNroIntPosCol(int nroIntPosCol) {
		this.nroIntPosCol = nroIntPosCol;
	}
	
}
