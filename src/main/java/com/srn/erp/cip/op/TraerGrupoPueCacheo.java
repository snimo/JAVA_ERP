package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.GrupoPuerta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoPueCacheo extends Operation {

	public TraerGrupoPueCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dsGrupoPuerta = this.getDataSetGrupoPuerta();
		Iterator iterGrupoPuertas = 
			GrupoPuerta.getGrupoPuertasCacheo(this.getSesion()).iterator();
		while (iterGrupoPuertas.hasNext()) {
			GrupoPuerta grupoPuerta = (GrupoPuerta) iterGrupoPuertas.next();
			cargarRegistro(dsGrupoPuerta, grupoPuerta);
		}
		writeCliente(dsGrupoPuerta);
	}

	private IDataSet getDataSetGrupoPuerta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoPuertasCacheo");
		dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, GrupoPuerta grupoPuerta) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupo_puerta", grupoPuerta.getOIDInteger());
		dataset.fieldValue("codigo", grupoPuerta.getCodigo());
		dataset.fieldValue("descripcion", grupoPuerta.getDescripcion());
	}

}
