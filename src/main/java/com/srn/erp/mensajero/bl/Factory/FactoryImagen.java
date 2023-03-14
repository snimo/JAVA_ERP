package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.Imagen;
import com.srn.erp.mensajero.da.DBImagen;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryImagen extends FactoryObjetoLogico {

	public FactoryImagen() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Imagen imagen = (Imagen) objLog;
		imagen.setOID(db.getInteger(DBImagen.OID_IMAGEN));
		imagen.setCodigo(db.getString(DBImagen.CODIGO));
		imagen.setDescripcion(db.getString(DBImagen.DESCRIPCION));
		imagen.setActivo(db.getBoolean(DBImagen.ACTIVO));

	}
}
