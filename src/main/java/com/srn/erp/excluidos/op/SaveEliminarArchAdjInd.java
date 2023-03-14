package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.ArchAdjExc;
import com.srn.erp.excluidos.bm.IndividuoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveEliminarArchAdjInd extends Operation {

	public SaveEliminarArchAdjInd() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IndividuoExcluido individuo = 
			(IndividuoExcluido) IndividuoExcluido.findByOidProxy(mapaDatos.getInteger("oid_individuo"), this.getSesion());
		Integer orden = mapaDatos.getInteger("orden");
		ArchAdjExc archAdjExc = ArchAdjExc.getArchivoAdjExc(individuo, orden, this.getSesion());
		if (archAdjExc!=null) {
			archAdjExc.setFecha(null);
			archAdjExc.setNombre(null);
			archAdjExc.setTitulo(null);
			archAdjExc.save();
		}
		
	}

}
