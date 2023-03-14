package com.srn.erp.cip.mail;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public abstract class CIPConfigMail {
	
	private String smtpServer;
	private String userName;
	private String password;
	private ISesion sesion;

	public CIPConfigMail(ISesion sesion)
			throws BaseException {
		this.sesion = sesion;
		this.smtpServer = ValorParametro.findByCodigoParametro("SMTP_SERVER_CORREO", sesion).getValorCadena();
		this.userName = ValorParametro.findByCodigoParametro("USER_NAME_SERV_CORREO", this.sesion).getValorCadena();
		this.password = ValorParametro.findByCodigoParametro("CLAVE_SERV_CORREO", this.sesion).getValorCadena();
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract String getAsunto() throws BaseException;
	public abstract String getCuerpoMensaje() throws BaseException;
	public abstract String getRemitente() throws BaseException;
	public abstract String getDestinatario() throws BaseException;
}
