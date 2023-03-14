package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoEscenario;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.Escenario;
import com.srn.erp.presupuesto.da.DBCompoEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoEscenario extends FactoryObjetoLogico { 

  public FactoryCompoEscenario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoEscenario estructuraversionplanificaciondet = (CompoEscenario) objLog;
    estructuraversionplanificaciondet.setOID(db.getInteger(DBCompoEscenario.OID_COMPO_ESCENARIO));
    estructuraversionplanificaciondet.setEscenario(Escenario.findByOidProxy(db.getInteger(DBCompoEscenario.OID_ESCENARIO),getSesion()));
    estructuraversionplanificaciondet.setNivel(db.getInteger(DBCompoEscenario.NIVEL));
    estructuraversionplanificaciondet.setCompoPresupuestario(CompoPresupuestario.findByOidProxy(db.getInteger(DBCompoEscenario.OID_COMPO_PRESU),getSesion()));
    estructuraversionplanificaciondet.setActivo(db.getBoolean(DBCompoEscenario.ACTIVO));

  }
}
