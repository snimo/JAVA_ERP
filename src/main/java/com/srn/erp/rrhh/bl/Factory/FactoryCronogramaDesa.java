package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.CronogramaDesa;
import com.srn.erp.rrhh.da.DBCronogramaDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCronogramaDesa extends FactoryObjetoLogico {

	public FactoryCronogramaDesa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CronogramaDesa cronogramadesa = (CronogramaDesa) objLog;
		cronogramadesa.setOID(db.getInteger(DBCronogramaDesa.OID_CRONO_DESA));
		cronogramadesa.setCodigo(db.getString(DBCronogramaDesa.CODIGO));
		cronogramadesa.setDescripcion(db.getString(DBCronogramaDesa.DESCRIPCION));
		cronogramadesa.setObservaciones(db.getString(DBCronogramaDesa.OBSERVACIONES));
		cronogramadesa.setActivo(db.getBoolean(DBCronogramaDesa.ACTIVO));

	}
}
