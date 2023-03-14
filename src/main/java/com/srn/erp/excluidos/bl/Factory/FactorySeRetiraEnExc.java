package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.SeRetiraEnExc;
import com.srn.erp.excluidos.da.DBSeRetiraEnExc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeRetiraEnExc extends FactoryObjetoLogico { 

  public FactorySeRetiraEnExc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeRetiraEnExc excseretiraen = (SeRetiraEnExc) objLog;
    excseretiraen.setOID(db.getInteger(DBSeRetiraEnExc.OID_SE_RETIRA));
    excseretiraen.setCodigo(db.getString(DBSeRetiraEnExc.CODIGO));
    excseretiraen.setDescripcion(db.getString(DBSeRetiraEnExc.DESCRIPCION));
    excseretiraen.setActivo(db.getBoolean(DBSeRetiraEnExc.ACTIVO));

  }
}
