package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.GrupoCondPago;
import com.srn.erp.ventas.da.DBGrupoCondPago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoCondPago extends FactoryObjetoLogico {

  public FactoryGrupoCondPago() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoCondPago grupocondpago = (GrupoCondPago) objLog;
    grupocondpago.setOID(db.getInteger(DBGrupoCondPago.OID_GRUPO_CP));
    grupocondpago.setCodigo(db.getString(DBGrupoCondPago.CODIGO));
    grupocondpago.setDescripcion(db.getString(DBGrupoCondPago.DESCRIPCION));
    grupocondpago.setActivo(db.getBoolean(DBGrupoCondPago.ACTIVO));
  }
}
