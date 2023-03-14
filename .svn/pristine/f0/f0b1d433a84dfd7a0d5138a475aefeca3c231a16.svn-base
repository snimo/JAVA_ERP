package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.TipoUnidadEdilicia;
import com.srn.erp.ventas.da.DBTipoUnidadEdilicia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoUnidadEdilicia extends FactoryObjetoLogico {

  public FactoryTipoUnidadEdilicia() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoUnidadEdilicia tipounidadedilicia = (TipoUnidadEdilicia) objLog;
    tipounidadedilicia.setOID(db.getInteger(DBTipoUnidadEdilicia.OID_TIPO_UNI_EDI));
    tipounidadedilicia.setCodigo(db.getString(DBTipoUnidadEdilicia.CODIGO));
    tipounidadedilicia.setDescripcion(db.getString(DBTipoUnidadEdilicia.DESCRIPCION));
    tipounidadedilicia.setComportamiento(db.getString(DBTipoUnidadEdilicia.COMPO));
    tipounidadedilicia.setActivo(db.getBoolean(DBTipoUnidadEdilicia.ACTIVO));

  }
}
