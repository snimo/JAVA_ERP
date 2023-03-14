package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.Abogado;
import com.srn.erp.legales.da.DBAbogado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAbogado extends FactoryObjetoLogico {

	public FactoryAbogado() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Abogado abogado = (Abogado) objLog;
		abogado.setOID(db.getInteger(DBAbogado.OID_ABOGADO));
		abogado.setApellido(db.getString(DBAbogado.APELLIDO));
		abogado.setNombre(db.getString(DBAbogado.NOMBRE));
		abogado.setTelefonos(db.getString(DBAbogado.TELEFONOS));
		abogado.setMail(db.getString(DBAbogado.MAIL));
		abogado.setDireccion(db.getString(DBAbogado.DIRECCION));
		abogado.setEstudio(db.getString(DBAbogado.ESTUDIO));
		abogado.setActivo(db.getBoolean(DBAbogado.ACTIVO));
		abogado.setCUIT(db.getString(DBAbogado.CUIT));
	}
}
