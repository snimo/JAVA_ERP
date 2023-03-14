package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.RubroCondena;
import com.srn.erp.legales.bm.RubroCondenaJuicio;
import com.srn.erp.legales.da.DBRubroCondenaJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRubroCondenaJuicio extends FactoryObjetoLogico {

	public FactoryRubroCondenaJuicio() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RubroCondenaJuicio rubrocondenajuicio = (RubroCondenaJuicio) objLog;
		rubrocondenajuicio.setOID(db.getInteger(DBRubroCondenaJuicio.OID_RUB_COND_JUI));
		rubrocondenajuicio.setRubro_condena(RubroCondena.findByOidProxy(db.getInteger(DBRubroCondenaJuicio.OID_RUBRO_CONDENA), getSesion()));
		rubrocondenajuicio.setJuicio(Juicio.findByOidProxy(db.getInteger(DBRubroCondenaJuicio.OID_JUICIO), getSesion()));
		rubrocondenajuicio.setActivo(db.getBoolean(DBRubroCondenaJuicio.ACTIVO));

	}
}
