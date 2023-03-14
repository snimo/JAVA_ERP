package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.Juzgado;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveJuzgado extends Operation {

	public SaveJuzgado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TJuzgado");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			Juzgado juzgado = Juzgado.findByOid(dataset.getInteger("oid_juzgado"), getSesion());
			juzgado.setOID(dataset.getInteger("oid_juzgado"));
			juzgado.setNro(dataset.getString("nro"));
			juzgado.setJuzgado(dataset.getString("juzgado"));
			juzgado.setDireccion(dataset.getString("direccion"));
			juzgado.setObservacion(dataset.getString("observacion"));
			juzgado.setTelefono(dataset.getString("telefono"));
			juzgado.setActivo(dataset.getBoolean("activo"));
			addTransaccion(juzgado);
			dataset.next();
		}
	}

}
