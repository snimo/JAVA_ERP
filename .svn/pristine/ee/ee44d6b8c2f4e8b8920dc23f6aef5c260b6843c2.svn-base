package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.RubroCondena;
import com.srn.erp.legales.bm.RubroReclamoSeclo;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.legales.da.DBRubroReclamoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRubroReclamoSeclo extends FactoryObjetoLogico {

	public FactoryRubroReclamoSeclo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RubroReclamoSeclo rubroreclamoseclo = (RubroReclamoSeclo) objLog;
		rubroreclamoseclo.setOID(db.getInteger(DBRubroReclamoSeclo.OID_RUB_REC_SECLO));
		rubroreclamoseclo.setRubro_condena(RubroCondena.findByOidProxy(db.getInteger(DBRubroReclamoSeclo.OID_RUBRO_CONDENA), getSesion()));
		rubroreclamoseclo.setSeclo(Seclo.findByOidProxy(db.getInteger(DBRubroReclamoSeclo.OID_SECLO), getSesion()));
		rubroreclamoseclo.setActivo(db.getBoolean(DBRubroReclamoSeclo.ACTIVO));

	}
}
