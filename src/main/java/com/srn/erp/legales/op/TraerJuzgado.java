package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.Juzgado;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerJuzgado extends Operation {

	public TraerJuzgado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Juzgado juzgado = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			juzgado = Juzgado.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			juzgado = Juzgado.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetJuzgado = getDataSetJuzgado();
		if (juzgado != null) {
			cargarRegistroJuzgado(datasetJuzgado, juzgado.getOIDInteger(), juzgado.getNro(), juzgado.getJuzgado(), juzgado.getDireccion(), juzgado.getObservacion(), juzgado.getTelefono(), juzgado
					.isActivo());
		}
		writeCliente(datasetJuzgado);
	}

	private IDataSet getDataSetJuzgado() {
		IDataSet dataset = new TDataSet();
		dataset.create("TJuzgado");
		dataset.fieldDef(new Field("oid_juzgado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro", Field.STRING, 20));
		dataset.fieldDef(new Field("juzgado", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion", Field.STRING, 100));
		dataset.fieldDef(new Field("observacion", Field.STRING, 4000));
		dataset.fieldDef(new Field("telefono", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroJuzgado(IDataSet dataset, Integer oid_juzgado, String nro, String juzgado, String direccion, String observacion, String telefono, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_juzgado", oid_juzgado);
		dataset.fieldValue("nro", nro);
		dataset.fieldValue("juzgado", juzgado);
		dataset.fieldValue("direccion", direccion);
		dataset.fieldValue("observacion", observacion);
		dataset.fieldValue("telefono", telefono);
		dataset.fieldValue("activo", activo);
	}
}
