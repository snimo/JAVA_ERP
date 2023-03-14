package com.srn.erp.compras.bm;



import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class AnalizarAutorizMontoOC {
	
	private ISesion sesion;
	
	public void setSesion(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}
	
	public ISesion getSesion() {
		return sesion; 
	}
	
	
	public void analizar() throws BaseException {
		
		
	}	

}
