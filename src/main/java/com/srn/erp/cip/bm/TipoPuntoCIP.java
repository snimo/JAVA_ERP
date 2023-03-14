package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class TipoPuntoCIP {

	public static final Integer TURN_STYLE_NC = 1;
	public static final Integer TURN_STYLE_NA = 2;
	public static final Integer GATE_M = 3;
	public static final Integer GATE = 4;
	public static final Integer BARRERA = 5;
	public static final Integer BARRERA_PULSO = 6;
	
	public static HashTableDatos getTiposPuntos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TURN_STYLE_NC, "Turnstyle NC");
		condiciones.put(TURN_STYLE_NA, "Turnstyle NA");
		condiciones.put(GATE_M, "GATE M");
		condiciones.put(GATE, "GATE");
		condiciones.put(BARRERA, "BARRERA");
		condiciones.put(BARRERA_PULSO, "BARRERA Pulso");
		return condiciones;
	}

}