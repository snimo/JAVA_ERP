package com.srn.erp.general.bm;

import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;

public class Precio {
	
	private Moneda moneda;
	private Money importe;
	private Porcentaje porcDto1;
	private Porcentaje porcDto2;
	private Porcentaje porcDto3;
	private boolean incluyeIVA;
	private boolean enCascada;
	private String fuente;
	private UnidadMedida um;
	private Money cantidad;
	private java.util.Date fecVigencia;
	
	public java.util.Date getFecVigencia() {
		return fecVigencia;
	}

	public void setFecVigencia(java.util.Date fecVigencia) {
		this.fecVigencia = fecVigencia;
	}

	public boolean isEnCascada() {
		return enCascada;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public void setEnCascada(boolean enCascada) {
		this.enCascada = enCascada;
	}
	
	public boolean isIncluyeIVA() {
		return this.incluyeIVA;
	}

	public void setIncluyeIVA(boolean aIncluyeIVA) {
		this.incluyeIVA = aIncluyeIVA;
	}
	

	public UnidadMedida getUm() {
		return um;
	}

	public void setUm(UnidadMedida um) {
		this.um = um;
	}

	public Money getCantidad() {
		return cantidad;
	}

	public void setCantidad(Money cantidad) {
		this.cantidad = cantidad;
	}

	public Porcentaje getPorcDto1() {
		return porcDto1;
	}

	public void setPorcDto1(Porcentaje porcDto1) {
		this.porcDto1 = porcDto1;
	}

	public Porcentaje getPorcDto2() {
		return porcDto2;
	}

	public void setPorcDto2(Porcentaje porcDto2) {
		this.porcDto2 = porcDto2;
	}

	public Porcentaje getPorcDto3() {
		return porcDto3;
	}

	public void setPorcDto3(Porcentaje porcDto3) {
		this.porcDto3 = porcDto3;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public void setImporte(Money aImporte) throws BaseException {
		this.importe = aImporte;
	}
	
	public Money getImporte() throws BaseException {
		return importe;
	}
	
	public Moneda getMoneda() throws BaseException {
		return moneda;
	}
	
	 public static Integer getSugerenciaCantDecPrecioVenta(ISesion aSesion) throws BaseException {
	   return ValorParametro.findByCodigoParametro("CANT_DEC_PV_DEF_ABM_PROD",aSesion).getValorEntero();
	 } 
	
	
	

}
