package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AlgoritmoCacheo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAlgoritmoCacheo extends Operation {

	public TraerAlgoritmoCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		AlgoritmoCacheo algoritmocacheo = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			algoritmocacheo = AlgoritmoCacheo.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			algoritmocacheo = AlgoritmoCacheo.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetAlgoritmoCacheo = getDataSetAlgoritmoCacheo();
		if (algoritmocacheo != null) {
			cargarRegistroAlgoritmoCacheo(datasetAlgoritmoCacheo, algoritmocacheo);
		}
		writeCliente(datasetAlgoritmoCacheo);
	}

	private IDataSet getDataSetAlgoritmoCacheo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAlgoritmoCacheo");
		dataset.fieldDef(new Field("oid_algo_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("filtro_legajo", Field.STRING, 10));
		dataset.fieldDef(new Field("tipo_planif", Field.STRING, 10));
		dataset.fieldDef(new Field("porc_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prob_cach_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_sal", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("prob_cach_sal", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegistroAlgoritmoCacheo(IDataSet dataset, AlgoritmoCacheo algoritmoCacheo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_algo_cacheo", algoritmoCacheo.getOIDInteger());
		dataset.fieldValue("filtro_legajo", algoritmoCacheo.getFiltro_legajo());
		dataset.fieldValue("tipo_planif", algoritmoCacheo.getTipo_planif());
		dataset.fieldValue("porc_ent", algoritmoCacheo.getPorc_ent());
		dataset.fieldValue("activo", algoritmoCacheo.isActivo());
		dataset.fieldValue("prob_cach_ent", algoritmoCacheo.getProb_cach_ent());
		dataset.fieldValue("porc_sal", algoritmoCacheo.getPorc_sal());
		dataset.fieldValue("prob_cach_sal", algoritmoCacheo.getProb_cach_sal());
	}
}
