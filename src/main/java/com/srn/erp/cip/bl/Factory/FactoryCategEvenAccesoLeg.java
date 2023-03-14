package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategEvenAccesoLeg;
import com.srn.erp.cip.da.DBCategEvenAccesoLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategEvenAccesoLeg extends FactoryObjetoLogico {

	public FactoryCategEvenAccesoLeg() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db)
			throws BaseException {
		CategEvenAccesoLeg categevenaccesoleg = (CategEvenAccesoLeg) objLog;
		categevenaccesoleg.setOID(db.getInteger(DBCategEvenAccesoLeg.OID_CATEG_EVE_LEG));
		categevenaccesoleg.setLegajo(Legajo.findByOidProxy(db.getInteger(DBCategEvenAccesoLeg.OID_LEGAJO), getSesion()));
		categevenaccesoleg.setFecha_desde(db.getDateTime(DBCategEvenAccesoLeg.FEC_DESDE));
		categevenaccesoleg.setFecha_hasta(db.getDateTime(DBCategEvenAccesoLeg.FEC_HASTA));
		categevenaccesoleg.setTipo_acceso(db.getString(DBCategEvenAccesoLeg.TIPO_ACCESO));
		categevenaccesoleg.setActivo(db.getBoolean(DBCategEvenAccesoLeg.ACTIVO));

	}
}
