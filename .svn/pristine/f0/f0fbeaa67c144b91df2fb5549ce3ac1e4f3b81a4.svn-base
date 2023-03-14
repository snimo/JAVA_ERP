package com.srn.erp.rrhh.bm;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class RankItemDesarrollo {
	
	private Money puntaje;
	private Money ponderacion;
	private String leyenda;
	
	public Money getPuntaje() {
		if (puntaje==null)
			return new Money(0);
		else
			return puntaje;
	}
	public void setPuntaje(Money puntaje) {
		this.puntaje = puntaje;
	}
	public Money getPonderacion() {
		if (ponderacion==null)
			return new Money(0);
		else
			return ponderacion;
	}
	public void setPonderacion(Money ponderacion) {
		this.ponderacion = ponderacion;
	}
	public String getLeyenda() {
		return leyenda;
	}
	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
	
	public Money getTotPuntXPond() throws BaseException {
		CalculadorMoney calc = new CalculadorMoney(this.getPuntaje());
		calc.multiplicarPor(this.getPonderacion());
		return calc.getResultMoney();
	}
	
	public Money getTotPuntXPondDiv100() throws BaseException {
		CalculadorMoney calc = new CalculadorMoney(this.getPuntaje());
		calc.multiplicarPor(this.getPonderacion());
		calc.dividirPor(new Money(100));
		return calc.getResultMoney();
	}
	

}
