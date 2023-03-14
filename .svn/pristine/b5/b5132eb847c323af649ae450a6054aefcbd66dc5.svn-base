package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.RemplazoAcumLeg;
import com.srn.erp.rrhh.da.DBRemplazoAcumLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRemplazoAcumLeg extends FactoryObjetoLogico {

	public FactoryRemplazoAcumLeg() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RemplazoAcumLeg remplazoacumleg = (RemplazoAcumLeg) objLog;
		remplazoacumleg.setOID(db.getInteger(DBRemplazoAcumLeg.OID_REM_TRA_LEG));
		remplazoacumleg.setLegajo(Legajo.findByOidProxy(db.getInteger(DBRemplazoAcumLeg.OID_LEGAJO), getSesion()));
		remplazoacumleg.setPeriodo(db.getString(DBRemplazoAcumLeg.PERIODO));
		remplazoacumleg.setHoras_acum(db.getInteger(DBRemplazoAcumLeg.HORAS_ACUM));
		remplazoacumleg.setObservacion(db.getString(DBRemplazoAcumLeg.OBSERVACION));
		remplazoacumleg.setActivo(db.getBoolean(DBRemplazoAcumLeg.ACTIVO));

	}
}
