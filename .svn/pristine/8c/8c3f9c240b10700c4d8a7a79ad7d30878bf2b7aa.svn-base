package com.srn.erp.cip.mail;

import com.srn.erp.cip.bm.Puerta;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class CIPConfigMailPuertaDesconectada extends CIPConfigMail{
	
	public static final String CODIGO = "MAIL_PUERTA_DESCONECTADA";
	
	private String remitente;
	private Puerta puerta; 
	private String asunto;
	private String cuerpoMensaje;
	private String destinatario;

	public Puerta getPuerta() {
		return puerta;
	}

	public void setPuerta(Puerta puerta) {
		this.puerta = puerta;
	}

	public CIPConfigMailPuertaDesconectada(ISesion sesion) throws BaseException {
		super(sesion);
		this.remitente = ValorParametro.findByCodigoParametro("EMAIL_REMITENTE_PLACA_DESC", sesion).getValorCadena();
		this.destinatario = ValorParametro.findByCodigoParametro("EMAIL_DESTINATARIO_PLACA_DESC", sesion).getValorCadena();
		this.asunto = ValorParametro.findByCodigoParametro("ASUNTO_MAIL_PLACA_DESC", sesion).getValorCadena();
		this.cuerpoMensaje = ValorParametro.findByCodigoParametro("CUERPO_MAIL_PLACA_DESC", sesion).getValorCadena();
	}

	@Override
	public String getAsunto() throws BaseException {
		return "COD: " + this.getPuerta().getCodigo() +" IP: " + this.getPuerta().getIP() + ": " + " ID: "+ this.getPuerta().getIdentifPuerta() +" "+this.asunto;
	}

	@Override
	public String getCuerpoMensaje() throws BaseException {
		return  "COD: " + this.getPuerta().getCodigo() +" IP: " + this.getPuerta().getIP() + ": " + " ID: "+ this.getPuerta().getIdentifPuerta() + " " + this.cuerpoMensaje;
	}

	@Override
	public String getDestinatario() throws BaseException {
		return destinatario;
	}
	
	@Override
	public String getRemitente() {
		return remitente;
	}
	
}
