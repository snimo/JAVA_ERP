package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.NegociacionLegales;
import com.srn.erp.legales.da.DBNegociacionLegales;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNegociacionLegales extends FactoryObjetoLogico {

	public FactoryNegociacionLegales() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		NegociacionLegales negociacionlegales = (NegociacionLegales) objLog;
		negociacionlegales.setOID(db.getInteger(DBNegociacionLegales.OID_NEGOCIACION));
		negociacionlegales.setLegajo(Legajo.findByOidProxy(db.getInteger(DBNegociacionLegales.OID_LEGAJO), getSesion()));
		negociacionlegales.setFecha(db.getDate(DBNegociacionLegales.FECHA));
		negociacionlegales.setObservacion(db.getString(DBNegociacionLegales.OBSERVACION));
		negociacionlegales.setMonto(db.getMoney(DBNegociacionLegales.MONTO));
		negociacionlegales.setActivo(db.getBoolean(DBNegociacionLegales.ACTIVO));

	}
}
