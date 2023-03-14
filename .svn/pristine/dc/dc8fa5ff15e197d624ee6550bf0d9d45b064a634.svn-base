package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.GrupoTarjeta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoTarjeta extends Operation {

	public TraerGrupoTarjeta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		GrupoTarjeta grupotarjeta = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			grupotarjeta = GrupoTarjeta.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			grupotarjeta = GrupoTarjeta.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetGrupoTarjeta = getDataSetGrupoTarjeta();
		if (grupotarjeta != null) {
			cargarRegistroGrupoTarjeta(datasetGrupoTarjeta, grupotarjeta);
		}
		writeCliente(datasetGrupoTarjeta);
	}

	private IDataSet getDataSetGrupoTarjeta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoTarjeta");
		dataset.fieldDef(new Field("oid_grupo_tar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroGrupoTarjeta(IDataSet dataset, GrupoTarjeta grupo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupo_tar", grupo.getOIDInteger());
		dataset.fieldValue("codigo", grupo.getCodigo());
		dataset.fieldValue("descripcion", grupo.getDescripcion());
		dataset.fieldValue("activo", grupo.isActivo());
	}
}
