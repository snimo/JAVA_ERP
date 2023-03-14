package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.DefEstrucLPCab;
import com.srn.erp.ventas.da.DBDefEstrucLPCab;

public class FactoryDefEstrucLPCab extends FactoryObjetoLogico { 

  public FactoryDefEstrucLPCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DefEstrucLPCab defestruclpcab = (DefEstrucLPCab) objLog;
    defestruclpcab.setOID(db.getInteger(DBDefEstrucLPCab.OID_DEF_ESTRUC_LP));
    defestruclpcab.setCodigo(db.getString(DBDefEstrucLPCab.CODIGO));
    defestruclpcab.setDescripcion(db.getString(DBDefEstrucLPCab.DESCRIPCION));
    defestruclpcab.setActivo(db.getBoolean(DBDefEstrucLPCab.ACTIVO));

  }
}
