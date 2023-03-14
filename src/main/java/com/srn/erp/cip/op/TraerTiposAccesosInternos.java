package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CategEvenAccesoLeg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAccesosInternos extends Operation {

	public TraerTiposAccesosInternos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetTiposAccesos();
		Iterator iterTiposAccesos = CategEvenAccesoLeg.getTiposAccesos().keySet().iterator();
		while (iterTiposAccesos.hasNext()) {
			String codigo = (String) iterTiposAccesos.next();
			String desc = (String) CategEvenAccesoLeg.getTiposAccesos().get(codigo);
			cargarRegistro(ds, codigo, desc);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetTiposAccesos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposAccesosInternos");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo,
			String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
