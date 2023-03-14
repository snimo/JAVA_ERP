package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.AnteojoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAnteojoExcluido extends Operation {

	public TraerAnteojoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		AnteojoExcluido anteojoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			anteojoexcluido = AnteojoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			anteojoexcluido = AnteojoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetAnteojoExcluido = getDataSetAnteojoExcluido();
		if (anteojoexcluido != null) {
			cargarRegistroAnteojoExcluido(datasetAnteojoExcluido, anteojoexcluido.getOIDInteger(), anteojoexcluido.getCodigo(),
					anteojoexcluido.getDescripcion(), anteojoexcluido.isActivo());
		}
		writeCliente(datasetAnteojoExcluido);
	}

	private IDataSet getDataSetAnteojoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAnteojoExcluido");
		dataset.fieldDef(new Field("oid_anteojo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroAnteojoExcluido(IDataSet dataset, Integer oid_anteojo, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_anteojo", oid_anteojo);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
