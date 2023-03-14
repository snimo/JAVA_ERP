package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.ModosFuncPlacaCIP;
import com.srn.erp.cip.bm.ModosOFFLineCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerModosFuncPlacaCIP extends Operation {

	public TraerModosFuncPlacaCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetModosFuncPlacaCIP();
		Iterator iterModos = ModosFuncPlacaCIP.getModosFuncPlacaCIP().keySet().iterator();
		while (iterModos.hasNext()) {
			Integer codigo = (Integer) iterModos.next();
			String descripcion = (String) ModosFuncPlacaCIP.getModosFuncPlacaCIP().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetModosFuncPlacaCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TModosFunc");
		dataset.fieldDef(new Field("codigo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Integer codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
