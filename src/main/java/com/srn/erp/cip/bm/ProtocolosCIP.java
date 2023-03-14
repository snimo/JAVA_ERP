package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;


public class ProtocolosCIP {
	
	public static final String WIEGAND26 = "WIEGAND26";
	public static final String WIEGAND37 = "WIEGAND37";
	public static final String WIEGAND32 = "WIEGAND32";
	public static final String NOHABILITADO = "NOHABILITADO";
	public static final String ABA = "ABA";
	public static final String GEMPLUS = "GEMPLUS";
	public static final String MANUAL = "Manual";
	public static final String MONEDA = "MONEDA";
	public static final String MAGNETICA = "MAGNETICA";
	public static final String CODEBAR = "CODEBAR";
	
	public ProtocolosCIP() {
	}
	
	public static HashTableDatos getProtocolos() throws BaseException {
		HashTableDatos protocolos = new HashTableDatos();
		protocolos.put(WIEGAND26, "Wiegand 26");
		protocolos.put(WIEGAND37, "Wiegand 37");
		protocolos.put(WIEGAND32, "Wiegand 32");
		protocolos.put(NOHABILITADO,"Ho habilitado");
		protocolos.put(ABA,"ABA");
		protocolos.put(GEMPLUS,"GEMPLUS");
		protocolos.put(MANUAL,"Manual");
		protocolos.put(MONEDA,"MONEDA");
		protocolos.put(MAGNETICA,"MAGNETICA");
		protocolos.put(CODEBAR,"CODEBAR");		
		return protocolos;
	}

}
