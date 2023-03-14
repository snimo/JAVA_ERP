package com.srn.erp.schedule.op;

import java.util.Iterator;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;
import framework.schedule.bm.TriggerBase;

public class TraerTiposDisparadores extends Operation {

	public TraerTiposDisparadores() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetTiposDisparadores();
		Iterator iterTipoDispador = TriggerBase.getTiposDisparadores().keySet().iterator();
		while (iterTipoDispador.hasNext()) {
			String tipoDisparador = (String) iterTipoDispador.next();
			String descripcion = (String) TriggerBase.getTiposDisparadores().get(tipoDisparador);
			cargarRegistro(ds, tipoDisparador, descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetTiposDisparadores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposDisparadores");
		dataset.fieldDef(new Field("tipo_disparador", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String tipoDisparador, String descripcion) {
		dataset.append();
		dataset.fieldValue("tipo_disparador", tipoDisparador);
		dataset.fieldValue("descripcion", descripcion);
	}
}
