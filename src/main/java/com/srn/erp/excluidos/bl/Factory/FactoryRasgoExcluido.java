package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.RasgoExcluido;
import com.srn.erp.excluidos.da.DBRasgoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRasgoExcluido extends FactoryObjetoLogico {

	public FactoryRasgoExcluido() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RasgoExcluido rasgoexcluido = (RasgoExcluido) objLog;
		rasgoexcluido.setOID(db.getInteger(DBRasgoExcluido.OID_RASGO));
		rasgoexcluido.setCodigo(db.getString(DBRasgoExcluido.CODIGO));
		rasgoexcluido.setDescripcion(db.getString(DBRasgoExcluido.DESCRIPCION));
		rasgoexcluido.setActivo(db.getBoolean(DBRasgoExcluido.ACTIVO));
	}
}
