package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.MesCronoDesa;
import com.srn.erp.rrhh.da.DBMesCronoDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMesCronoDesa extends FactoryObjetoLogico {

	public FactoryMesCronoDesa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		MesCronoDesa mescronodesa = (MesCronoDesa) objLog;
		mescronodesa.setOID(db.getInteger(DBMesCronoDesa.OID_MES_A_EVAL));
		mescronodesa.setAccion(AccCronoDesa.findByOidProxy(db.getInteger(DBMesCronoDesa.OID_ACCION_CRO), getSesion()));
		mescronodesa.setMes(db.getString(DBMesCronoDesa.MES));
		mescronodesa.setActivo(db.getBoolean(DBMesCronoDesa.ACTIVO));

	}
}
