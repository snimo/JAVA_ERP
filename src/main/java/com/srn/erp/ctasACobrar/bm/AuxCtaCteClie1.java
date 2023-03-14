package com.srn.erp.ctasACobrar.bm;

import java.util.ArrayList;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ConsultaCtaCteProv;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Utils.BaseException;

public class AuxCtaCteClie1 {
	
	private List listaTransacPos = new ArrayList();
	private List listaTransacNeg = new ArrayList();
	private Sujeto sujeto;
	
	public List getListaTransacPos() {
		return listaTransacPos;
	}
	public void setListaTransacPos(List listaTransacPos) {
		this.listaTransacPos = listaTransacPos;
	}
	public List getListaTransacNeg() {
		return listaTransacNeg;
	}
	public void setListaTransacNeg(List listaTransacNeg) {
		this.listaTransacNeg = listaTransacNeg;
	}
	public Sujeto getSujeto() {
		return sujeto;
	}
	public void setSujeto(Sujeto sujeto) {
		this.sujeto = sujeto;
	}
	
	public void addTransaccionPositiva(ConsultaCtaCteClie consCtaCteClie) throws BaseException {
		this.listaTransacPos.add(consCtaCteClie);
	}
	
	public void addTransaccionPositiva(ConsultaCtaCteProv consCtaCteProv) throws BaseException {
		this.listaTransacPos.add(consCtaCteProv);
	}
	
	public void addTransaccionNegativa(ConsultaCtaCteClie consCtaCteClie) throws BaseException {
		this.listaTransacNeg.add(consCtaCteClie);
	}
	
	public void addTransaccionNegativa(ConsultaCtaCteProv consCtaCteProv) throws BaseException {
		this.listaTransacNeg.add(consCtaCteProv);
	}
	
	
}
