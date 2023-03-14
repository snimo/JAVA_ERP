package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.EstadoJuicio;
import com.srn.erp.legales.da.DBEstadoJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoJuicio extends FactoryObjetoLogico {

	public FactoryEstadoJuicio() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstadoJuicio estadojuicio = (EstadoJuicio) objLog;
		estadojuicio.setOID(db.getInteger(DBEstadoJuicio.OID_EST_JUICIO));
		estadojuicio.setCodigo(db.getString(DBEstadoJuicio.CODIGO));
		estadojuicio.setDescripcion(db.getString(DBEstadoJuicio.DESCRIPCION));
		estadojuicio.setActivo(db.getBoolean(DBEstadoJuicio.ACTIVO));

	}
}
