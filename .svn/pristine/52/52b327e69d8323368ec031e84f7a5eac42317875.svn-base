package com.srn.erp.cip.op;

import java.util.Date;

import com.srn.erp.cip.bm.AlgoritmoCacheo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveSchedulePlanifCacheo extends Operation {

	public SaveSchedulePlanifCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		java.util.Date fecha = new Date();
		java.util.Date fechaProdDia = Fecha.getFechaDiaPosterior(fecha);
		
		AlgoritmoCacheo algoritmo =
			AlgoritmoCacheo.getAlgoritmoCacheo(this.getSesion());
		algoritmo.planificar(Fecha.getFechaTruncada(fechaProdDia), Fecha.getFechaTruncada(fechaProdDia), AlgoritmoCacheo.TIPO_PLANIF);
		
		
	}
}
