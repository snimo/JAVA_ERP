package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.ConcPagoSeclo;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.PagoJuicio;
import com.srn.erp.legales.da.DBPagoJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPagoJuicio extends FactoryObjetoLogico {

	public FactoryPagoJuicio() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		PagoJuicio pagojuicio = (PagoJuicio) objLog;
		pagojuicio.setOID(db.getInteger(DBPagoJuicio.OID_PAGO_JUICIO));
		pagojuicio.setJuicio(Juicio.findByOidProxy(db.getInteger(DBPagoJuicio.OID_JUICIO), getSesion()));
		pagojuicio.setFec_pago(db.getDate(DBPagoJuicio.FEC_PAGO));
		pagojuicio.setObservacion(db.getString(DBPagoJuicio.OBSERVACION));
		pagojuicio.setConcepto_pago_seclo(ConcPagoSeclo.findByOidProxy(db.getInteger(DBPagoJuicio.OID_CONC_PAGO_SECLO), getSesion()));
		pagojuicio.setPago_acuerdo(db.getMoney(DBPagoJuicio.PAGO_ACUERDO));
		pagojuicio.setPago_horario(db.getMoney(DBPagoJuicio.PAGO_HORARIO));
		pagojuicio.setPago_perito(db.getMoney(DBPagoJuicio.PAGO_PERITO));
		pagojuicio.setPago_tasa_just(db.getMoney(DBPagoJuicio.PAGO_TASA_JUST));
		pagojuicio.setActivo(db.getBoolean(DBPagoJuicio.ACTIVO));
		pagojuicio.setPagoLetrado(db.getMoney(DBPagoJuicio.PAGO_ABOGADO));

	}
}
