package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.ColorCabelloExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerColorCabelloExcluido extends Operation {

	public TraerColorCabelloExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		ColorCabelloExcluido colorcabelloexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			colorcabelloexcluido = ColorCabelloExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			colorcabelloexcluido = ColorCabelloExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetColorCabelloExcluido = getDataSetColorCabelloExcluido();
		if (colorcabelloexcluido != null) {
			cargarRegistroColorCabelloExcluido(datasetColorCabelloExcluido, colorcabelloexcluido);
		}
		writeCliente(datasetColorCabelloExcluido);
	}

	private IDataSet getDataSetColorCabelloExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColorCabelloExcluido");
		dataset.fieldDef(new Field("oid_color", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroColorCabelloExcluido(IDataSet dataset, ColorCabelloExcluido colorCabello) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_color", colorCabello.getOIDInteger());
		dataset.fieldValue("codigo", colorCabello.getCodigo());
		dataset.fieldValue("descripcion", colorCabello.getDescripcion());
		dataset.fieldValue("activo", colorCabello.isActivo());
	}
}
