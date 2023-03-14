package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TarjetaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHabTarjeta extends Operation {

	public TraerHabTarjeta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetHabilitacion();
		Iterator iterHab = 
			TarjetaCIP.getHabilitaciones().keySet().iterator();
		while (iterHab.hasNext()) {
			String codigo = (String) iterHab.next();
			String descripcion = (String) TarjetaCIP.getHabilitaciones().get(codigo);
			cargarRegistroHabilitacion(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetHabilitacion() {
		IDataSet dataset = new TDataSet();
		dataset.create("THabTar");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroHabilitacion(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
