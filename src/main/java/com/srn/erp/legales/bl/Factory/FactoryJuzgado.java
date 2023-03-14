package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.Juzgado;
import com.srn.erp.legales.da.DBJuzgado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryJuzgado extends FactoryObjetoLogico {

	public FactoryJuzgado() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Juzgado juzgado = (Juzgado) objLog;
		juzgado.setOID(db.getInteger(DBJuzgado.OID_JUZGADO));
		juzgado.setNro(db.getString(DBJuzgado.NRO));
		juzgado.setJuzgado(db.getString(DBJuzgado.JUZGADO));
		juzgado.setDireccion(db.getString(DBJuzgado.DIRECCION));
		juzgado.setObservacion(db.getString(DBJuzgado.OBSERVACION));
		juzgado.setTelefono(db.getString(DBJuzgado.TELEFONO));
		juzgado.setActivo(db.getBoolean(DBJuzgado.ACTIVO));

	}
}
