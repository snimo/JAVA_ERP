package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.MotivoEntradasInterRota;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoMotEntInter extends Operation {

	public TraerCompoMotEntInter() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSetCompoEntInter();
		
		Iterator iterMotEntIntRotas = 
			MotivoEntradasInterRota.getAsignaciones().keySet().iterator();
		while (iterMotEntIntRotas.hasNext()) {
			String codigo = (String) iterMotEntIntRotas.next();
			String desc   = (String) MotivoEntradasInterRota.getAsignaciones().getString(codigo);
			cargarRegistro(ds, codigo, desc);
		}
		
		writeCliente(ds);

	}

	private IDataSet getDataSetCompoEntInter() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCompoEntInter");
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
