package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadosExcluidosUltNroActaRev;
import com.srn.erp.excluidos.da.DBEstadosExcluidosUltNroActaRev;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadosExcluidosUltNroActaRev extends FactoryObjetoLogico {

	public FactoryEstadosExcluidosUltNroActaRev() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstadosExcluidosUltNroActaRev estadosexcluidosultnroacta = (EstadosExcluidosUltNroActaRev) objLog;
		estadosexcluidosultnroacta.setOID(db.getInteger(DBEstadosExcluidosUltNroActaRev.OID_ESTADO));
		estadosexcluidosultnroacta.setDescripcion(db.getString(DBEstadosExcluidosUltNroActaRev.DESCRIPCION));
		estadosexcluidosultnroacta.setUlt_nro(db.getInteger(DBEstadosExcluidosUltNroActaRev.ULT_NRO));

	}
}
