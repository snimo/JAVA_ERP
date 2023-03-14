package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.DeudaPorConcTurno;
import com.srn.erp.turnos.bm.GrupoConceptoTurno;
import com.srn.erp.turnos.da.DBGrupoConceptoTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoConceptoTurno extends FactoryObjetoLogico { 

  public FactoryGrupoConceptoTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoConceptoTurno grupoconceptoturno = (GrupoConceptoTurno) objLog;
    grupoconceptoturno.setOID(db.getInteger(DBGrupoConceptoTurno.OID_GRUPO_CONC));
    grupoconceptoturno.setDeuda_por_concepto(DeudaPorConcTurno.findByOidProxy(db.getInteger(DBGrupoConceptoTurno.OID_DEUDA_CONC),getSesion()));
    grupoconceptoturno.setConcepto(db.getString(DBGrupoConceptoTurno.CONCEPTO));

  }
}
