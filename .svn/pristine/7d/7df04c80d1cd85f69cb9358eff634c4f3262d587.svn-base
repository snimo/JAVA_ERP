package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AlgoritmoCacheo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProcPlanifCacheo extends Operation {

	public SaveProcPlanifCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TInput");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			
			java.util.Date fecDesde = dataset.getDate("fec_desde");
			java.util.Date fecHasta = dataset.getDate("fec_hasta");
			String tipo = dataset.getString("tipo");
			
			// Proceso de algoritmo de Planificacion de Cacheo
			AlgoritmoCacheo algoritmo = AlgoritmoCacheo.getAlgoritmoCacheo(this.getSesion());
			algoritmo.planificar(fecDesde,fecHasta,tipo);
			
			dataset.next();
			
		}
	}

}
