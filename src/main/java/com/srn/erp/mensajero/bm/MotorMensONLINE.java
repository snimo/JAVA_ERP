package com.srn.erp.mensajero.bm;

import java.util.List;

public class MotorMensONLINE {
	
	private static MotorMensONLINE motorMensOL = null;
	private ListaMensajesONLINE listaMensOL = new ListaMensajesONLINE();
	
	public static MotorMensONLINE getMotor() {
		if (motorMensOL!=null)
			return motorMensOL;
		else {
			motorMensOL = new MotorMensONLINE();
			return motorMensOL; 
		}
	}
	
	public void enviar(MensajeONLINE aMensajeON) {
		listaMensOL.addMensaje(aMensajeON);
		MiSenialONLINE.getMiSenialONLINE().doNotify();
	}
	
	public static void esperarMensaje() {
		
		if (ListaMensajesONLINE.getCantMens()>250) {
			getMotor().listaMensOL.eliminarMensajes();
			ListaMensajesONLINE.setCantMens(0);
		}
		
		MiSenialONLINE.getMiSenialONLINE().doWait();
		
	}
	
	public List getListaMensajes()  {
		return this.listaMensOL.getListaMensajes();
	}
	
	public static void notificarMensaje()  {
		MiSenialONLINE.getMiSenialONLINE().doNotify();
	}
	
	
	
}
