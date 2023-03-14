package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoLegajo;
import com.srn.erp.cip.da.DBCategAccesoLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategAccesoLegajo extends FactoryObjetoLogico {

	public FactoryCategAccesoLegajo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db)
			throws BaseException {
		CategAccesoLegajo categaccesolegajo = (CategAccesoLegajo) objLog;
		categaccesolegajo.setOID(db.getInteger(DBCategAccesoLegajo.OID_CAT_ACC_LEG));
		categaccesolegajo.setCategoria(CategAccesoCIP.findByOidProxy(db.getInteger(DBCategAccesoLegajo.OID_CATEG_ACCESO),
						getSesion()));
		categaccesolegajo.setLegajo(Legajo.findByOidProxy(db
				.getInteger(DBCategAccesoLegajo.OID_LEGAJO), getSesion()));
		categaccesolegajo.setActivo(db.getBoolean(DBCategAccesoLegajo.ACTIVO));

	}
}
