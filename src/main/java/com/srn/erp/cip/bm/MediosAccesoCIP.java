package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;


public class MediosAccesoCIP {
	
	public static final String BIOMETRICO = "BIO";
	public static final String HID = "HID";
	
	public MediosAccesoCIP() {
	}
	
	public static HashTableDatos getMediosAcceso() throws BaseException {
		HashTableDatos medios = new HashTableDatos();
		medios.put(BIOMETRICO, "Biométrico ZKSoftware LCD");
		medios.put(HID, "Lector de Tarjeta de Proximidad HID");
		return medios;
	}

}
