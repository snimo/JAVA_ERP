package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioRubroCondena;
import com.srn.erp.legales.bm.RubroCondena;
import com.srn.erp.legales.da.DBJuicioRubroCondena;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryJuicioRubroCondena extends FactoryObjetoLogico {

	public FactoryJuicioRubroCondena() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		JuicioRubroCondena juiciorubrocondena = (JuicioRubroCondena) objLog;
		juiciorubrocondena.setOID(db.getInteger(DBJuicioRubroCondena.OID_JUI_RUB_COND));
		juiciorubrocondena.setJuicio(Juicio.findByOidProxy(db.getInteger(DBJuicioRubroCondena.OID_JUICIO), getSesion()));
		juiciorubrocondena.setRubro_condena(RubroCondena.findByOidProxy(db.getInteger(DBJuicioRubroCondena.OID_RUBRO_CONDENA), getSesion()));
		juiciorubrocondena.setActivo(db.getBoolean(DBJuicioRubroCondena.ACTIVO));

	}
}
