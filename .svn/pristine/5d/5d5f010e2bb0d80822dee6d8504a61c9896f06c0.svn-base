package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AlgoritmoCacheo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAlgoritmoCacheo extends Operation {

	public SaveAlgoritmoCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TAlgoritmoCacheo");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			AlgoritmoCacheo algoritmocacheo = AlgoritmoCacheo.findByOid(dataset.getInteger("oid_algo_cacheo"), getSesion());
			algoritmocacheo.setOID(dataset.getInteger("oid_algo_cacheo"));
			algoritmocacheo.setFiltro_legajo(dataset.getString("filtro_legajo"));
			algoritmocacheo.setTipo_planif(dataset.getString("tipo_planif"));
			algoritmocacheo.setPorc_ent(dataset.getDouble("porc_ent"));
			algoritmocacheo.setActivo(dataset.getBoolean("activo"));
			algoritmocacheo.setProb_cach_ent(dataset.getDouble("prob_cach_ent"));
			algoritmocacheo.setPorc_sal(dataset.getDouble("porc_sal"));
			algoritmocacheo.setProb_cach_sal(dataset.getDouble("prob_cach_sal"));
			addTransaccion(algoritmocacheo);
			dataset.next();
		}
	}

}
