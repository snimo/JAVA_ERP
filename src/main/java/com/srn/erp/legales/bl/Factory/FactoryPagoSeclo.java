package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.ConcPagoSeclo;
import com.srn.erp.legales.bm.PagoSeclo;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.legales.da.DBPagoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPagoSeclo extends FactoryObjetoLogico {

	public FactoryPagoSeclo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		PagoSeclo pagoseclo = (PagoSeclo) objLog;
		pagoseclo.setOID(db.getInteger(DBPagoSeclo.OID_PAGO_SECLO));
		pagoseclo.setSeclo(Seclo.findByOidProxy(db.getInteger(DBPagoSeclo.OID_SECLO), getSesion()));
		pagoseclo.setFec_pago(db.getDate(DBPagoSeclo.FEC_PAGO));
		pagoseclo.setObservacion(db.getString(DBPagoSeclo.OBSERVACION));
		pagoseclo.setPago_acuerdo(db.getMoney(DBPagoSeclo.PAGO_ACUERDO));
		pagoseclo.setActivo(db.getBoolean(DBPagoSeclo.ACTIVO));
		pagoseclo.setPago_letrado(db.getMoney(DBPagoSeclo.PAGO_LETRADO));
		pagoseclo.setConc_pago(ConcPagoSeclo.findByOidProxy(db.getInteger(DBPagoSeclo.OID_CONC_PAGO_SECLO), getSesion()));
		pagoseclo.setPago_conciliador(db.getMoney(DBPagoSeclo.PAGO_CONCILIADOR));
		pagoseclo.setPago_otros(db.getMoney(DBPagoSeclo.PAGO_OTROS));

	}
}
