package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.tesoreria.bm.MotivoHabCobCli;
import com.srn.erp.tesoreria.da.DBMotivoHabCobCli;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoHabCobCli extends FactoryObjetoLogico { 

  public FactoryMotivoHabCobCli() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoHabCobCli motivohabcobcli = (MotivoHabCobCli) objLog;
    motivohabcobcli.setOID(db.getInteger(DBMotivoHabCobCli.OID_MOT_HAB_COBCLI));
    motivohabcobcli.setMotivo_tc(MotivoTC.findByOidProxy(db.getInteger(DBMotivoHabCobCli.OID_MOTIVO_TC),getSesion()));
    motivohabcobcli.setHabilitado(db.getBoolean(DBMotivoHabCobCli.HABILITADO));

  }
}
