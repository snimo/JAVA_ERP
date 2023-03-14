package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.rrhh.da.DBTipoNovedad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoNovedad extends FactoryObjetoLogico { 

  public FactoryTipoNovedad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoNovedad tiponovedad = (TipoNovedad) objLog;
    tiponovedad.setOID(db.getInteger(DBTipoNovedad.OID_TIPO_NOVEDAD));
    tiponovedad.setCodigo(db.getString(DBTipoNovedad.CODIGO));
    tiponovedad.setDescripcion(db.getString(DBTipoNovedad.DESCRIPCION));
    tiponovedad.setActivo(db.getBoolean(DBTipoNovedad.ACTIVO));

  }
}
