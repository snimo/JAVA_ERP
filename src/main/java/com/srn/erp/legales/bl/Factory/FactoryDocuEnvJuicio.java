package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.DocuEnvJuicio;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.da.DBDocuEnvJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDocuEnvJuicio extends FactoryObjetoLogico {

	public FactoryDocuEnvJuicio() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		DocuEnvJuicio docuenvjuicio = (DocuEnvJuicio) objLog;
		docuenvjuicio.setOID(db.getInteger(DBDocuEnvJuicio.OID_DOC_ENV_JUICIO));
		docuenvjuicio.setJuicio(Juicio.findByOidProxy(db.getInteger(DBDocuEnvJuicio.OID_JUICIO), getSesion()));
		docuenvjuicio.setFecha_envio(db.getDate(DBDocuEnvJuicio.FECHA_ENVIO));
		docuenvjuicio.setDocumentacion(db.getString(DBDocuEnvJuicio.DOCUMENTACION));
		docuenvjuicio.setActivo(db.getBoolean(DBDocuEnvJuicio.ACTIVO));

	}
}
