package com.srn.erp.excelReport.bm;

import framework.request.bl.Tablas.Field;

import framework.applicarionServer.bm.Varios.Money;

public class ResultFuncExcel {
	
	private String tipo;
	private String result;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	} 
	
	public void setMoney(Money valor) {
		if (this.getTipo().equals(Field.CURRENCY)) {
			if (valor == null)
				setResult("0");
			else
				setResult("="+new Double(valor.doubleValue()).toString().replace(".", ","));
		}
	}
	

}
