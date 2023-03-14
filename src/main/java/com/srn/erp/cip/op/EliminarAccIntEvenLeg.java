package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CategEvenAccLegDet;
import com.srn.erp.cip.bm.CategEvenAccesoLeg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class EliminarAccIntEvenLeg extends Operation {

	public EliminarAccIntEvenLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		CategEvenAccesoLeg categEvenAccesoLeg = CategEvenAccesoLeg.findByOid(mapaDatos.getInteger("oid_categ_eve_leg"), this.getSesion());
		categEvenAccesoLeg.delete();
		categEvenAccesoLeg.save();
		Iterator iterCategAccEven = 
			categEvenAccesoLeg.getCategAccesosEventuales().iterator();
		while (iterCategAccEven.hasNext()) {
			CategEvenAccLegDet categEvenAccLegDet = (CategEvenAccLegDet) iterCategAccEven.next();
			categEvenAccLegDet.delete();
			categEvenAccLegDet.save();
		}
		
	}
}
