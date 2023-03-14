package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CondMinSancion;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.da.DBCondMinSancion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondMinSancion extends FactoryObjetoLogico {

	public FactoryCondMinSancion() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CondMinSancion condminsancion = (CondMinSancion) objLog;
		condminsancion.setOID(db.getInteger(DBCondMinSancion.OID_COND_MIN_SANC));
		condminsancion.setNro_novedad(db.getInteger(DBCondMinSancion.NRO_NOVEDAD));
		condminsancion.setRankear(RankearCab.findByOidProxy(db.getInteger(DBCondMinSancion.OID_RANKEAR), getSesion()));
		condminsancion.setOid_mot_sancion(SancionesRRHH.findByOidProxy(db.getInteger(DBCondMinSancion.OID_MOT_SANCION), getSesion()));
		condminsancion.setActivo(db.getBoolean(DBCondMinSancion.ACTIVO));

	}
}
