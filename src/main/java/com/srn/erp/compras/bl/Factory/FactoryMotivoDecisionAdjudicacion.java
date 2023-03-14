package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.MotivoDecisionAdjudicacion;
import com.srn.erp.compras.da.DBMotivoDecisionAdjudicacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoDecisionAdjudicacion extends FactoryObjetoLogico {

	public FactoryMotivoDecisionAdjudicacion() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db)
			throws BaseException {
		MotivoDecisionAdjudicacion motivodecisionadjudicacion = (MotivoDecisionAdjudicacion) objLog;
		motivodecisionadjudicacion.setOID(db
				.getInteger(DBMotivoDecisionAdjudicacion.OID));
		motivodecisionadjudicacion.setCodigo(db
				.getString(DBMotivoDecisionAdjudicacion.CODIGO));
		motivodecisionadjudicacion.setDescripcion(db
				.getString(DBMotivoDecisionAdjudicacion.DESCRIPCION));
		motivodecisionadjudicacion.setActivo(db
				.getBoolean(DBMotivoDecisionAdjudicacion.ACTIVO));

	}
}
