package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotivoBajaTarjeta;
import com.srn.erp.cip.da.DBMotivoBajaTarjeta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoBajaTarjeta extends FactoryObjetoLogico {

	public FactoryMotivoBajaTarjeta() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		MotivoBajaTarjeta motivobajatarjeta = (MotivoBajaTarjeta) objLog;
		motivobajatarjeta.setOID(db.getInteger(DBMotivoBajaTarjeta.OID_MOT_BAJ_TAR));
		motivobajatarjeta.setCodigo(db.getString(DBMotivoBajaTarjeta.CODIGO));
		motivobajatarjeta.setDescripcion(db.getString(DBMotivoBajaTarjeta.DESCRIPCION));
		motivobajatarjeta.setActivo(db.getBoolean(DBMotivoBajaTarjeta.ACTIVO));

	}
}
