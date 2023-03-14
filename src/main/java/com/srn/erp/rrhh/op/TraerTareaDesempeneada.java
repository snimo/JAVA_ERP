package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.TareaDesempeneada;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTareaDesempeneada extends Operation {

	public TraerTareaDesempeneada() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TareaDesempeneada tareadesempeneada = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tareadesempeneada = TareaDesempeneada.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tareadesempeneada = TareaDesempeneada.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTareaDesempeneada = getDataSetTareaDesempeneada();
		if (tareadesempeneada != null) {
			cargarRegistroTareaDesempeneada(datasetTareaDesempeneada, tareadesempeneada.getOIDInteger(), tareadesempeneada.getCodigo(), tareadesempeneada.getDescripcion(), tareadesempeneada
					.isActivo());
		}
		writeCliente(datasetTareaDesempeneada);
	}

	private IDataSet getDataSetTareaDesempeneada() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTareaDesempeneada");
		dataset.fieldDef(new Field("oid_tarea_desemp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTareaDesempeneada(IDataSet dataset, Integer oid_tarea_desemp, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tarea_desemp", oid_tarea_desemp);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
