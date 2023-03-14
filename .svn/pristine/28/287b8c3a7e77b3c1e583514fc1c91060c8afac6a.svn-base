package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.rrhh.bm.GrabarConsRotasCab;
import com.srn.erp.rrhh.bm.GrabarConsRotasDet;
import com.srn.erp.rrhh.da.DBGrabarConsRotasDet;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrabarConsRotasDet extends FactoryObjetoLogico {

	public FactoryGrabarConsRotasDet() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		
		GrabarConsRotasDet grabarconsrotasdet = (GrabarConsRotasDet) objLog;
		grabarconsrotasdet.setOID(db.getInteger(DBGrabarConsRotasDet.OID_GRAB_CONS_DET));
		grabarconsrotasdet.setGrab_cons_rota(GrabarConsRotasCab.findByOidProxy(db.getInteger(DBGrabarConsRotasDet.OID_GRAB_CONS_ROTA), getSesion()));
		grabarconsrotasdet.setLegajo(Legajo.findByOidProxy(db.getInteger(DBGrabarConsRotasDet.OID_LEGAJO), getSesion()));
		grabarconsrotasdet.setFecha(db.getDate(DBGrabarConsRotasDet.FECHA));
		grabarconsrotasdet.setRota(db.getString(DBGrabarConsRotasDet.ROTA));
		grabarconsrotasdet.setTurno(Rota.findByOidProxy(db.getInteger(DBGrabarConsRotasDet.OID_ROTA), getSesion()));
		grabarconsrotasdet.setActivo(db.getBoolean(DBGrabarConsRotasDet.ACTIVO));

	}
}
