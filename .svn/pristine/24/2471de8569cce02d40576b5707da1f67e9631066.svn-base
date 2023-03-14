package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.PlanifDiaCacheo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePlanifDiaCacheo extends Operation {

	public SavePlanifDiaCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TDefPuertas");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			
			PlanifDiaCacheo planifdiacacheo = null;
			if (PlanifDiaCacheo.getListaPlanifDiaCacheo(this.getSesion()).size() == 0)
				planifdiacacheo = (PlanifDiaCacheo)PlanifDiaCacheo.getNew(PlanifDiaCacheo.NICKNAME, this.getSesion());
			else  
				planifdiacacheo = (PlanifDiaCacheo)PlanifDiaCacheo.getListaPlanifDiaCacheo(this.getSesion()).get(0);
			
			planifdiacacheo.setLunes_entrada(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_lun_ent"),this.getSesion()));
			planifdiacacheo.setLunes_salida(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_lun_sal"),this.getSesion()));
			planifdiacacheo.setMartes_entrada(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_mar_ent"),this.getSesion()));
			planifdiacacheo.setMartes_salida(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_mar_sal"),this.getSesion()));
			planifdiacacheo.setMiercoles_entrada(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_mie_ent"),this.getSesion()));
			planifdiacacheo.setMiercoles_salida(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_mie_sal"),this.getSesion()));
			planifdiacacheo.setJueves_entrada(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_jue_ent"),this.getSesion()));
			planifdiacacheo.setJueves_salida(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_jue_sal"),this.getSesion()));
			planifdiacacheo.setViernes_entrada(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_vie_ent"),this.getSesion()));
			planifdiacacheo.setViermes_salida(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_vie_sal"),this.getSesion()));
			planifdiacacheo.setSabado_entrada(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_sab_ent"),this.getSesion()));
			planifdiacacheo.setSabado_salida(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_sab_sal"),this.getSesion()));
			planifdiacacheo.setDomingo_entrada(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_dom_ent"),this.getSesion()));
			planifdiacacheo.setDomingo_salida(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_dom_sal"),this.getSesion()));
			addTransaccion(planifdiacacheo);
			dataset.next();
		}
	}

}
