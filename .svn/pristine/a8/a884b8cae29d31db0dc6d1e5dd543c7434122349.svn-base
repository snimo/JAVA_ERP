package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerCargoLegajoExcluido extends Operation {

	public TraerCargoLegajoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		CargoLegajoExcluido cargolegajoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			cargolegajoexcluido = CargoLegajoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			cargolegajoexcluido = CargoLegajoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetCargoLegajoExcluido = getDataSetCargoLegajoExcluido();
		if (cargolegajoexcluido != null)
			cargarRegistroCargoLegajoExcluido(datasetCargoLegajoExcluido, cargolegajoexcluido);
		writeCliente(datasetCargoLegajoExcluido);
	}

	private IDataSet getDataSetCargoLegajoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCargoLegajoExcluido");
		dataset.fieldDef(new Field("oid_cargo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCargoLegajoExcluido(IDataSet dataset, CargoLegajoExcluido cargo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cargo", cargo.getOIDInteger());
		dataset.fieldValue("codigo", cargo.getCodigo());
		dataset.fieldValue("descripcion", cargo.getDescripcion());
		dataset.fieldValue("activo", cargo.isActivo());
	}
}
