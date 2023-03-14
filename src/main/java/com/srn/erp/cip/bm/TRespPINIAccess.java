package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.List;

import framework.request.bl.Utils.BaseException;

public class TRespPINIAccess {
	
	private String seccion;
	private List listaClaveValor = new ArrayList();

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public ClaveValorPINIAccess add(String clave,String valor) throws BaseException {
		ClaveValorPINIAccess claveValorPINIAccess = new ClaveValorPINIAccess();
		claveValorPINIAccess.setClave(clave);
		claveValorPINIAccess.setValor(valor);
		listaClaveValor.add(claveValorPINIAccess);
		return claveValorPINIAccess;
	}
	
	public static String getSTART() throws BaseException {
		return "<"; 
	}
	
	public static String getSTART_SECTION() throws BaseException {
		return "["; 
	}	
	
	public static String getEND_SECTION() throws BaseException {
		return "]"; 
	}	
	
	public static String getEND() throws BaseException {
		return ">"; 
	}	
	
	public static String getASIG_CLAVE_VALOR() throws BaseException {
		return "="; 
	}	
	
	public static String getSEP_CLAVE_VALOR() throws BaseException {
		return ";"; 
	}	
	
}
