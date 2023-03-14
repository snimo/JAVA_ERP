package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.ColorExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveColorExcluido extends Operation {

	public SaveColorExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TColorExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			ColorExcluido colorexcluido = ColorExcluido.findByOid(dataset.getInteger("oid_color"), getSesion());
			colorexcluido.setOID(dataset.getInteger("oid_color"));
			colorexcluido.setCodigo(dataset.getString("codigo"));
			colorexcluido.setDescripcion(dataset.getString("descripcion"));
			colorexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(colorexcluido);
			dataset.next();
		}
	}

}
