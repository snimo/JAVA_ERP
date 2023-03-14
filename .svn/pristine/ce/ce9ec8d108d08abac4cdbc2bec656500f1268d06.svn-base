package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.TipoAudiencia;
import com.srn.erp.legales.da.DBTipoAudiencia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoAudiencia extends FactoryObjetoLogico {

	public FactoryTipoAudiencia() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		TipoAudiencia tipoaudiencia = (TipoAudiencia) objLog;
		tipoaudiencia.setOID(db.getInteger(DBTipoAudiencia.OID_TIPO_AUD));
		tipoaudiencia.setCodigo(db.getString(DBTipoAudiencia.CODIGO));
		tipoaudiencia.setDescripcion(db.getString(DBTipoAudiencia.DESCRIPCION));
		tipoaudiencia.setActivo(db.getBoolean(DBTipoAudiencia.ACTIVO));

	}
}
