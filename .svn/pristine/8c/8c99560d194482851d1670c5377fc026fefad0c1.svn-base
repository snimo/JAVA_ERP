package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.RemitoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarRemito extends Operation {

	public ValidarRemito() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		RemitoCab remito = null;

		IDataSet ds = this.getDataSetValidarRemito();

		if (mapaDatos.containsKey("oid_cco")) {
			remito = RemitoCab.findByOid(mapaDatos.getInteger("oid_cco"),
					this.getSesion());
		} else {
			String codigoRemito = mapaDatos.getString("codigo");
			remito = RemitoCab.buscarRemitoByCodigo(codigoRemito, true,
					this.getSesion());
			if (remito == null)
				remito = RemitoCab.buscarRemitoByCodigo(codigoRemito,
						false, this.getSesion());
		}
		if (remito != null) {
			cargarRegistroRemito(ds, remito);
		}

		writeCliente(ds);
	}

	private IDataSet getDataSetValidarRemito() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValRemito");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroRemito(IDataSet dataset, RemitoCab remito)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", remito.getOIDInteger());
		dataset.fieldValue("codigo", remito.getCodigo());
		if (remito.getSujeto()!=null) {
			dataset.fieldValue("oid_sujeto", remito.getSujeto().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remito.getSujeto().getCodigo());
			dataset.fieldValue("rs_sujeto", remito.getSujeto().getRazon_social());
		} else if (remito.getProveedor()!=null) {
			dataset.fieldValue("oid_sujeto", remito.getProveedor().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remito.getProveedor().getCodigo());
			dataset.fieldValue("rs_sujeto", remito.getProveedor().getRazonsocial());
		} else if (remito.getDepo_destino()!=null) {
			dataset.fieldValue("oid_sujeto", remito.getDepo_destino().getOIDInteger());
			dataset.fieldValue("cod_sujeto", remito.getDepo_destino().getCodigo());
			dataset.fieldValue("rs_sujeto", remito.getDepo_destino().getDescripcion());
		} else {
			dataset.fieldValue("oid_sujeto", "");
			dataset.fieldValue("cod_sujeto", "");
			dataset.fieldValue("rs_sujeto", "");
		}
		dataset.fieldValue("activo", remito.isActivo());
	}
}
