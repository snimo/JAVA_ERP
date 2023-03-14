package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCompeBusqAct;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveRecluAltaCompeBusqueda extends Operation {

	public SaveRecluAltaCompeBusqueda() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidBusquedaAct = mapaDatos.getInteger("oid_busqueda_act");
		Integer oidCompetencia = mapaDatos.getInteger("oid_competencia");

		RecluBusqueda recluBusqueda = RecluBusqueda.findByOidProxy(oidBusquedaAct, this.getSesion());
		RecluCompetencias recluCompetencia = RecluCompetencias.findByOidProxy(oidCompetencia, this.getSesion());

		RecluCompeBusqAct recluCompeBusqAct = (RecluCompeBusqAct) RecluCompeBusqAct.getNew(RecluCompeBusqAct.NICKNAME, this.getSesion());
		recluCompeBusqAct.setBusqueda(recluBusqueda);
		recluCompeBusqAct.setCompetencia(recluCompetencia);
		recluCompeBusqAct.setActivo(true);

		this.addTransaccion(recluCompeBusqAct);

	}

}
