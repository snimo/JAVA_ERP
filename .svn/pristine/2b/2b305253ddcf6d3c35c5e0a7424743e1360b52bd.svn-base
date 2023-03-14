package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.Escenario;
import com.srn.erp.presupuesto.da.DBEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEscenario extends FactoryObjetoLogico { 

  public FactoryEscenario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Escenario estructuraversionplanificacion = (Escenario) objLog;
    estructuraversionplanificacion.setOID(db.getInteger(DBEscenario.OID_ESCENARIO));
    estructuraversionplanificacion.setCodigo(db.getString(DBEscenario.CODIGO));
    estructuraversionplanificacion.setDescripcion(db.getString(DBEscenario.DESCRIPCION));
    estructuraversionplanificacion.setActivo(db.getBoolean(DBEscenario.ACTIVO));

  }
}
