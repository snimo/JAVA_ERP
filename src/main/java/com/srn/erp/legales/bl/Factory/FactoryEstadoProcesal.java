package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.EstadoProcesal;
import com.srn.erp.legales.da.DBEstadoProcesal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoProcesal extends FactoryObjetoLogico {

	public FactoryEstadoProcesal() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstadoProcesal estadoprocesal = (EstadoProcesal) objLog;
		estadoprocesal.setOID(db.getInteger(DBEstadoProcesal.OID_EST_PROCESAL));
		estadoprocesal.setCodigo(db.getString(DBEstadoProcesal.CODIGO));
		estadoprocesal.setDescripcion(db.getString(DBEstadoProcesal.DESCRIPCION));
		estadoprocesal.setActivo(db.getBoolean(DBEstadoProcesal.ACTIVO));

	}
}
