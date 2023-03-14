package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.ZonaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadosZonas extends Operation {

	public TraerEstadosZonas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetEstadosZonas();
		HashTableDatos estados = ZonaCIP.getEstados(this.getSesion());
		Iterator iterEstados = estados.keySet().iterator();
		while (iterEstados.hasNext()) {
			String codigo = (String) iterEstados.next();
			String descripcion = (String) estados.get(codigo);
			cargarRegistroEstadoZona(ds, codigo, descripcion);
		}

		writeCliente(ds);

	}

	private IDataSet getDataSetEstadosZonas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadosZonas");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroEstadoZona(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
