package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotEntInterLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntradasInterRota;
import com.srn.erp.cip.da.DBMotEntInterLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotEntInterLeg extends FactoryObjetoLogico {

	public FactoryMotEntInterLeg() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db)
			throws BaseException {
		MotEntInterLeg motentinterleg = (MotEntInterLeg) objLog;
		motentinterleg.setOID(db.getInteger(DBMotEntInterLeg.OID_MOT_ENT_LEG));
		motentinterleg.setMotivo(MotivoEntIntermedias.findByOidProxy(db.getInteger(DBMotEntInterLeg.OID_MOTIVO), getSesion()));
		motentinterleg.setLegajo(Legajo.findByOidProxy(db.getInteger(DBMotEntInterLeg.OID_LEGAJO), getSesion()));
		motentinterleg.setActivo(db.getBoolean(DBMotEntInterLeg.ACTIVO));

	}
}
