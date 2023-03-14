package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CIPLogPuerta;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.da.DBCIPLogPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class FactoryCIPLogPuerta extends FactoryObjetoLogico {

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CIPLogPuerta ciplogpuerta = (CIPLogPuerta) objLog;
		ciplogpuerta.setOID(db.getInteger(DBCIPLogPuerta.OID_LOG_PUERTA));
		ciplogpuerta.setPuerta(Puerta.findByOidProxy(db.getInteger(DBCIPLogPuerta.OID_PUERTA), getSesion()));
		ciplogpuerta.setFechora(db.getDateTime(DBCIPLogPuerta.FEC_HORA));
		ciplogpuerta.setEstado(db.getString(DBCIPLogPuerta.ESTADO));
		ciplogpuerta.setActivo(db.getBoolean(DBCIPLogPuerta.ACTIVO));

	}
}