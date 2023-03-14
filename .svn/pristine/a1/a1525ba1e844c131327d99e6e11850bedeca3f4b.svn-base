package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.NovedadPermisoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInhhabilitacionesNov extends Operation {

	public TraerInhhabilitacionesNov() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetHabNov();
		Iterator iterHabNov = NovedadPermisoCIP.getInhabilitacionesYAmbos().keySet().iterator();
		while (iterHabNov.hasNext()) {
			String codigo = (String) iterHabNov.next();
			String descripcion = (String) NovedadPermisoCIP.getInhabilitacionesYAmbos().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetHabNov() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInhabNov");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
