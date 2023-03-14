package com.srn.erp.cip.mail;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class FactoryCIPConfigMail {
	
	private CIPConfigMail configMail ;
	
	public FactoryCIPConfigMail(String codConfigMail, ISesion sesion) throws BaseException{
		if(codConfigMail.equals(CIPConfigMailPuertaDesconectada.CODIGO)){
			this.configMail =  new CIPConfigMailPuertaDesconectada(sesion);
		}
	}
	
	public CIPConfigMail getConfigMail(){
		return configMail;
	}
}
