package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.legales.da.DBTipoReclamoLeg;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoReclamoLeg extends FactoryObjetoLogico {

	public FactoryTipoReclamoLeg() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		TipoReclamoLeg tiporeclamoleg = (TipoReclamoLeg) objLog;
		tiporeclamoleg.setOID(db.getInteger(DBTipoReclamoLeg.OID_TIPO_RECLAMO));
		tiporeclamoleg.setDescripcion(db.getString(DBTipoReclamoLeg.DESCRIPCION));
		tiporeclamoleg.setActivo(db.getBoolean(DBTipoReclamoLeg.ACTIVO));

	}
}
