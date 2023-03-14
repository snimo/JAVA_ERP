package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.TipoZona;
import com.srn.erp.cip.da.DBTipoZona;

public class FactoryTipoZona extends FactoryObjetoLogico { 

  public FactoryTipoZona() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoZona tipozona = (TipoZona) objLog;
    tipozona.setOID(db.getInteger(DBTipoZona.OID_TIPO_ZONA));
    tipozona.setCodigo(db.getString(DBTipoZona.CODIGO));
    tipozona.setDescripcion(db.getString(DBTipoZona.DESCRIPCION));
    tipozona.setActivo(db.getBoolean(DBTipoZona.ACTIVO));

  }
}
