package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.Fuero;
import com.srn.erp.legales.da.DBFuero;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFuero extends FactoryObjetoLogico {

	public FactoryFuero() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Fuero fuero = (Fuero) objLog;
		fuero.setOID(db.getInteger(DBFuero.OID_FUERO));
		fuero.setCodigo(db.getString(DBFuero.CODIGO));
		fuero.setDescripcion(db.getString(DBFuero.DESCRIPCION));
		fuero.setActivo(db.getBoolean(DBFuero.ACTIVO));

	}
}
