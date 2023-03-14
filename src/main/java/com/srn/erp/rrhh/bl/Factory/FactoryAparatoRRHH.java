package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.AparatoRRHH;
import com.srn.erp.rrhh.da.DBAparatoRRHH;

public class FactoryAparatoRRHH extends FactoryObjetoLogico { 

  public FactoryAparatoRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AparatoRRHH aparatorrhh = (AparatoRRHH) objLog;
    aparatorrhh.setOID(db.getInteger(DBAparatoRRHH.OID_APARATO));
    aparatorrhh.setCosigo(db.getString(DBAparatoRRHH.CODIGO));
    aparatorrhh.setDescripcion(db.getString(DBAparatoRRHH.DESCRIPCION));
    aparatorrhh.setActivo(db.getBoolean(DBAparatoRRHH.ACTIVO));

  }
}
