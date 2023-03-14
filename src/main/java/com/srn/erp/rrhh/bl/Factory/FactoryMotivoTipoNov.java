package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.rrhh.da.DBMotivoTipoNov;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoTipoNov extends FactoryObjetoLogico {

	public FactoryMotivoTipoNov() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		MotivoTipoNov motivotiponov = (MotivoTipoNov) objLog;
		motivotiponov.setOID(db.getInteger(DBMotivoTipoNov.OID_MOT_TIPO_NOV));
		motivotiponov.setTipo_novedad(TipoNovedad.findByOidProxy(db.getInteger(DBMotivoTipoNov.OID_TIPO_NOV), getSesion()));
		motivotiponov.setCodigo(db.getString(DBMotivoTipoNov.CODIGO));
		motivotiponov.setDescripcion(db.getString(DBMotivoTipoNov.DESCRIPCION));
		motivotiponov.setActivo(db.getBoolean(DBMotivoTipoNov.ACTIVO));

	}
}
