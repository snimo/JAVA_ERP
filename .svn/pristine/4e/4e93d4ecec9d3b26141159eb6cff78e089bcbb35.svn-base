package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.TipoArchivoConciliacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoArchConciTar extends Operation {

	public TraerTipoArchConciTar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet datasetTipoArchConciTar = getDataSetTipoArchConciTar();
		Iterator iterKeys = TipoArchivoConciliacion.getTiposArchivos().keySet().iterator();
		while (iterKeys.hasNext()) {
			String codigo = (String) iterKeys.next();
			String desc = (String) TipoArchivoConciliacion.getTiposArchivos().get(codigo);
			cargarRegistroTipoArchConciTar(datasetTipoArchConciTar, codigo, desc);
		}
		writeCliente(datasetTipoArchConciTar);
	}

	private IDataSet getDataSetTipoArchConciTar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComporTipoArch");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroTipoArchConciTar(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
