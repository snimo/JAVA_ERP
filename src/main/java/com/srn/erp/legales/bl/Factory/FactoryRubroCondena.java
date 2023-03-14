package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.RubroCondena;
import com.srn.erp.legales.da.DBRubroCondena;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRubroCondena extends FactoryObjetoLogico {

	public FactoryRubroCondena() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RubroCondena rubrocondena = (RubroCondena) objLog;
		rubrocondena.setOID(db.getInteger(DBRubroCondena.OID_RUBRO_CONDENA));
		rubrocondena.setCodigo(db.getString(DBRubroCondena.CODIGO));
		rubrocondena.setDescripcion(db.getString(DBRubroCondena.DESCRIPCION));
		rubrocondena.setActivo(db.getBoolean(DBRubroCondena.ACTIVO));

	}
}
