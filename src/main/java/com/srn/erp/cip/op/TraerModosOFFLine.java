package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.ModosOFFLineCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerModosOFFLine extends Operation {

	public TraerModosOFFLine() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetModosOFFLine();
		Iterator iterModos = ModosOFFLineCIP.getModos().keySet().iterator();
		while (iterModos.hasNext()) {
			Integer codigo = (Integer) iterModos.next();
			String descripcion = (String) ModosOFFLineCIP.getModos().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetModosOFFLine() {
		IDataSet dataset = new TDataSet();
		dataset.create("TModosOFFLibe");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Integer codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
