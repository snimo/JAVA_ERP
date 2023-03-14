package com.srn.erp.cip.mail;

import framework.applicarionServer.bl.Mail.Correo;
import framework.request.bl.Utils.BaseException;

public class CIPMailService {
	
	private Correo correo;
	private CIPConfigMail configMail;
	
	public CIPMailService(CIPConfigMail configMail){
		this.configMail = configMail;
		this.correo = new Correo();
		this.correo.setPassword(this.configMail.getPassword());
		this.correo.setSmtpServer(this.configMail.getSmtpServer());
		this.correo.setUserName(this.configMail.getUserName());
	}

	public void enviar() throws BaseException {
		String asunto = this.configMail.getAsunto();
		String cuerpoMensaje = this.configMail.getCuerpoMensaje();
		String remitente = this.configMail.getRemitente();
		String destinatario = this.configMail.getDestinatario();
		
		this.correo.sendEmail(remitente, destinatario, "", asunto, cuerpoMensaje, null);
		
	}
}
