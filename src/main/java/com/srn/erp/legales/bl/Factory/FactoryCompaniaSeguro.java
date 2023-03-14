package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.CompaniaSeguro;
import com.srn.erp.legales.da.DBCompaniaSeguro;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompaniaSeguro extends FactoryObjetoLogico {

	public FactoryCompaniaSeguro() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CompaniaSeguro companiaseguro = (CompaniaSeguro) objLog;
		companiaseguro.setOID(db.getInteger(DBCompaniaSeguro.ID_COMP_SEG));
		companiaseguro.setNombre(db.getString(DBCompaniaSeguro.NOMBRE));
		companiaseguro.setEs_caucion(db.getBoolean(DBCompaniaSeguro.ES_CAUCION));
		companiaseguro.setActivo(db.getBoolean(DBCompaniaSeguro.ACTIVO));

	}
}
