package com.srn.erp.produccion.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.produccion.bm.ProcesoProductivo;
import com.srn.erp.produccion.da.DBProcesoProductivo;

public class FactoryProcesoProductivo extends FactoryObjetoLogico { 

  public FactoryProcesoProductivo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProcesoProductivo procesoproductivo = (ProcesoProductivo) objLog;
    procesoproductivo.setOID(db.getInteger(DBProcesoProductivo.OID_PROCESO));
    procesoproductivo.setCodigo(db.getString(DBProcesoProductivo.CODIGO));
    procesoproductivo.setDescripcion(db.getString(DBProcesoProductivo.DESCRIPCION));
    procesoproductivo.setActivo(db.getBoolean(DBProcesoProductivo.ACTIVO));

  }
}
