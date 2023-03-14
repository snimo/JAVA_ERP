package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.List;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ListaDesgloseCalifGral {

	List lista = new ArrayList();

	public void add(String agrupado, 
					java.util.Date fecha, 
					String motivo, 
					Money puntaje, 
					Money cantidad, 
					Money ponderacion, 
					Money totPuntPond, 
					Integer orden) throws BaseException {
		
		DesgloseCalifGral desgloseCalifGral = new DesgloseCalifGral();
		desgloseCalifGral.setAgrupador(agrupado);
		desgloseCalifGral.setFecha(fecha);
		desgloseCalifGral.setMotivo(motivo);
		desgloseCalifGral.setPuntaje(puntaje);
		desgloseCalifGral.setCantidad(cantidad);
		desgloseCalifGral.setPonderacion(ponderacion);
		desgloseCalifGral.setTotPuntosPond(totPuntPond);
		desgloseCalifGral.setOrden(orden);
		
		lista.add(desgloseCalifGral);

	}
	
	public List getLista() throws BaseException {
		return lista;
	}

}
