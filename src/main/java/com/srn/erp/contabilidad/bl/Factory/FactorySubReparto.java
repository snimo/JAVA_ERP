package com.srn.erp.contabilidad.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.contabilidad.bm.SubReparto;
import com.srn.erp.contabilidad.da.DBSubReparto;

public class FactorySubReparto extends FactoryObjetoLogico { 

  public FactorySubReparto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SubReparto subreparto = (SubReparto) objLog;
    subreparto.setOID(db.getInteger(DBSubReparto.OID_SUBREPARTO));
    subreparto.setCodigo(db.getString(DBSubReparto.CODIGO));
    subreparto.setDescripcion(db.getString(DBSubReparto.DESCRIPCION));
    subreparto.setActivo(db.getBoolean(DBSubReparto.ACTIVO));
  }
}
