package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CompePotencial;
import com.srn.erp.rrhh.da.DBCompePotencial;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompePotencial extends FactoryObjetoLogico {

	public FactoryCompePotencial() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CompePotencial compepotencial = (CompePotencial) objLog;
		compepotencial.setOID(db.getInteger(DBCompePotencial.OID_COMPE_POT));
		compepotencial.setCosigo(db.getString(DBCompePotencial.CODIGO));
		compepotencial.setDescripcion(db.getString(DBCompePotencial.DESCRIPCION));
		compepotencial.setActivo(db.getBoolean(DBCompePotencial.ACTIVO));

	}
}
