package com.srn.erp.conciTarjeta.bm;

import framework.applicarionServer.bm.Varios.Money;

public class RenglonAsiCobTarj {
	
	private String cuenta;
	private String compo1;
	private String compo2;
	private String D_H;
	private Money importe;
	
	public Money getImporte() {
		return importe;
	}
	public void setImporte(Money importe) {
		this.importe = importe;
	}
	public String getD_H() {
		return D_H;
	}
	public void setD_H(String d_h) {
		D_H = d_h;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCompo1() {
		return compo1;
	}
	public void setCompo1(String compo1) {
		this.compo1 = compo1;
	}
	public String getCompo2() {
		return compo2;
	}
	public void setCompo2(String compo2) {
		this.compo2 = compo2;
	}
	
	public String getClave() {
		StringBuffer clave = new StringBuffer("");
		if (cuenta!=null)
			clave.append(cuenta);
		clave.append("%");
		if (compo1!=null)
			clave.append(compo1);
		clave.append("%");
		if (compo2!=null)
			clave.append(compo2);		
		return clave.toString();
	}
	
	public boolean isDebe() {
		if (this.getD_H().equals("D"))
			return true;
		else
			return false;
	}

}
