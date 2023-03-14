package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.ColorExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerColorExcluido extends Operation {

	public TraerColorExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		ColorExcluido colorexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			colorexcluido = ColorExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			colorexcluido = ColorExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetColorExcluido = getDataSetColorExcluido();
		if (colorexcluido != null) 
			cargarRegistroColorExcluido(datasetColorExcluido, colorexcluido);
		
		writeCliente(datasetColorExcluido);
	}

	private IDataSet getDataSetColorExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColorExcluido");
		dataset.fieldDef(new Field("oid_color", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroColorExcluido(IDataSet dataset, ColorExcluido color) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_color", color.getOIDInteger());
		dataset.fieldValue("codigo", color.getCodigo());
		dataset.fieldValue("descripcion", color.getDescripcion());
		dataset.fieldValue("activo", color.isActivo());
	}
}
