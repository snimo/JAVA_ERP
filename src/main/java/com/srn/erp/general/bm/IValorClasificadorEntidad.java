package com.srn.erp.general.bm;

import framework.request.bl.Utils.BaseException;

public interface IValorClasificadorEntidad {
	
	public int getOID() throws BaseException;
	public String getCodigo() throws BaseException;
	public String getDescripcion() throws BaseException;
	public String getIDTitulo() throws BaseException;
	public String getIDTituloPadre() throws BaseException;
	

}
