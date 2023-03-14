package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;
import com.srn.erp.excluidos.da.DBMotivoNovedadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoNovedadExcluido extends FactoryObjetoLogico {

	public FactoryMotivoNovedadExcluido() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		MotivoNovedadExcluido motivonovedadexcluido = (MotivoNovedadExcluido) objLog;
		motivonovedadexcluido.setOID(db.getInteger(DBMotivoNovedadExcluido.OID_MOTIVO));
		motivonovedadexcluido.setCodigo(db.getString(DBMotivoNovedadExcluido.CODIGO));
		motivonovedadexcluido.setDescripcion(db.getString(DBMotivoNovedadExcluido.DESCRIPCION));
		motivonovedadexcluido.setActivo(db.getBoolean(DBMotivoNovedadExcluido.ACTIVO));

	}
}
