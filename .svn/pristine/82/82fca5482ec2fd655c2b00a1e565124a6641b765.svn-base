package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.tesoreria.bm.MotivoHabIngVar;
import com.srn.erp.tesoreria.da.DBMotivoHabIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoHabIngVar extends FactoryObjetoLogico { 

  public FactoryMotivoHabIngVar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoHabIngVar motivohabingvar = (MotivoHabIngVar) objLog;
    motivohabingvar.setOID(db.getInteger(DBMotivoHabIngVar.OID_MOT_HAB_IV));
    motivohabingvar.setMotivo_tc(MotivoTC.findByOidProxy(db.getInteger(DBMotivoHabIngVar.OID_MOTIVO_TC),getSesion()));
    motivohabingvar.setHabilitado(db.getBoolean(DBMotivoHabIngVar.HABILITADO));
  }
}
