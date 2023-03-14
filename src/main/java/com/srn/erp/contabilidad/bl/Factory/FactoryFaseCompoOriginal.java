package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.FaseCompoOriginal;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.da.DBFaseCompoOriginal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFaseCompoOriginal extends FactoryObjetoLogico { 

  public FactoryFaseCompoOriginal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FaseCompoOriginal fasecompooriginal = (FaseCompoOriginal) objLog;
    fasecompooriginal.setOID(db.getInteger(DBFaseCompoOriginal.OID_FASE_COMPO_ORI));
    fasecompooriginal.setFase(FaseSubReparto.findByOidProxy(db.getInteger(DBFaseCompoOriginal.OID_FASE),getSesion()));
    fasecompooriginal.setComponente(Componente.findByOidProxy(db.getInteger(DBFaseCompoOriginal.OID_COMPO),getSesion()));
    fasecompooriginal.setActivo(db.getBoolean(DBFaseCompoOriginal.ACTIVO));

  }
}
