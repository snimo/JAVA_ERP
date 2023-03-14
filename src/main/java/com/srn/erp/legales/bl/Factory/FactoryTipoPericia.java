package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.TipoPericia;
import com.srn.erp.legales.da.DBTipoPericia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoPericia extends FactoryObjetoLogico {

	public FactoryTipoPericia() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		TipoPericia tipopericia = (TipoPericia) objLog;
		tipopericia.setOID(db.getInteger(DBTipoPericia.OID_TIPO_PERICIA));
		tipopericia.setDescripcion(db.getString(DBTipoPericia.DESCRIPCION));
		tipopericia.setActivo(db.getBoolean(DBTipoPericia.ACTIVO));

	}
}
