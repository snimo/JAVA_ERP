package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerAlturaExcluido extends Operation {

	public TraerAlturaExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		AlturaExcluido alturaexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			alturaexcluido = AlturaExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			alturaexcluido = AlturaExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetAlturaExcluido = getDataSetAlturaExcluido();
		if (alturaexcluido != null)
			cargarRegistroAlturaExcluido(datasetAlturaExcluido, alturaexcluido);

		writeCliente(datasetAlturaExcluido);
	}

	private IDataSet getDataSetAlturaExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAlturaExcluido");
		dataset.fieldDef(new Field("oid_altura", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroAlturaExcluido(IDataSet dataset, AlturaExcluido altura) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_altura", altura.getOIDInteger());
		dataset.fieldValue("codigo", altura.getCodigo());
		dataset.fieldValue("descripcion", altura.getDescripcion());
		dataset.fieldValue("activo", altura.isActivo());
	}
}
