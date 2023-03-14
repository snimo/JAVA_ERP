package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.TareaDesempeneada;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTareaDesempeneada extends Operation {

	public SaveTareaDesempeneada() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTareaDesempeneada");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TareaDesempeneada tareadesempeneada = TareaDesempeneada.findByOid(dataset.getInteger("oid_tarea_desemp"), getSesion());
			tareadesempeneada.setOID(dataset.getInteger("oid_tarea_desemp"));
			tareadesempeneada.setCodigo(dataset.getString("codigo"));
			tareadesempeneada.setDescripcion(dataset.getString("descripcion"));
			tareadesempeneada.setActivo(dataset.getBoolean("activo"));
			addTransaccion(tareadesempeneada);
			dataset.next();
		}
	}

}
