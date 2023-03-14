package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.GerenteExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGerenteExcluido extends Operation {

	public TraerGerenteExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		GerenteExcluido gerenteexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			gerenteexcluido = GerenteExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			gerenteexcluido = GerenteExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetGerenteExcluido = getDataSetGerenteExcluido();
		if (gerenteexcluido != null) {
			cargarRegistroGerenteExcluido(datasetGerenteExcluido, gerenteexcluido.getOIDInteger(), gerenteexcluido.getCodigo(),
					gerenteexcluido.getDescripcion(), gerenteexcluido.isActivo());
		}
		writeCliente(datasetGerenteExcluido);
	}

	private IDataSet getDataSetGerenteExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGerenteExcluido");
		dataset.fieldDef(new Field("oid_gerente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroGerenteExcluido(IDataSet dataset, Integer oid_gerente, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_gerente", oid_gerente);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
