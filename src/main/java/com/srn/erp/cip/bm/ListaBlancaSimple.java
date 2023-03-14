package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.srn.erp.cip.da.DBListaBlanca;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ListaBlancaSimple {

	private Integer nro_a_validar;
	private Integer nro_orden;
	private String puerta;
	
	public ListaBlancaSimple(String puerta, int nro_orden, Integer nro_a_validar) {
		this.puerta = puerta;
		this.nro_orden = nro_orden;
		this.nro_a_validar = nro_a_validar;
	}
	public Integer getNro_a_validar() {
		return nro_a_validar;
	}
	public void setNro_a_validar(Integer nro_a_validar) {
		this.nro_a_validar = nro_a_validar;
	}
	public Integer getNro_orden() {
		return nro_orden;
	}
	public void setNro_orden(Integer nro_orden) {
		this.nro_orden = nro_orden;
	}
	public String getPuerta() {
		return puerta;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

}
