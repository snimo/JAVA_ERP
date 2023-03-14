package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.Cacheo;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePlanifCacheo extends Operation {

	HashTableDatos codRotas = new HashTableDatos();

	public SavePlanifCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TCacheos");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {

			Cacheo cacheo = Cacheo.findByOid(dataset.getInteger("oid_cacheo"), this.getSesion());
			
			cacheo.setLegajo(Legajo.findByOidProxy(dataset.getInteger("oid_legajo"), this.getSesion()));
			cacheo.setFec_planif_cacheo(dataset.getDate("fec_planif_cacheo"));
			cacheo.setEnt_o_sal(dataset.getString("ent_o_sal"));
			cacheo.setActivo(dataset.getBoolean("activo"));
			cacheo.setGrupoPuerta(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta"), this.getSesion()));
			cacheo.save();
			
			dataset.next();
		}
	}

}
