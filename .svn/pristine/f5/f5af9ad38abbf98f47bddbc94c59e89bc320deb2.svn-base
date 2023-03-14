package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotEntInterPlanifS;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.da.DBMotEntInterPlanifS;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotEntInterPlanifS extends FactoryObjetoLogico { 

  public FactoryMotEntInterPlanifS() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotEntInterPlanifS motentinterplanifs = (MotEntInterPlanifS) objLog;
    motentinterplanifs.setOID(db.getInteger(DBMotEntInterPlanifS.OID_PSEM_ENT_INT));
    motentinterplanifs.setPermiso_semanal(PermisoSemanalCIP.findByOidProxy(db.getInteger(DBMotEntInterPlanifS.OID_PERM_SEMANAL),getSesion()));
    motentinterplanifs.setMotivo(MotivoEntIntermedias.findByOidProxy(db.getInteger(DBMotEntInterPlanifS.OID_MOTIVO),getSesion()));
    motentinterplanifs.setDia(db.getString(DBMotEntInterPlanifS.DIA));
    motentinterplanifs.setActivo(db.getBoolean(DBMotEntInterPlanifS.ACTIVO));
    motentinterplanifs.setHorario_desde(db.getString(DBMotEntInterPlanifS.HORARIO_DESDE));
    motentinterplanifs.setHorario_hasta(db.getString(DBMotEntInterPlanifS.HORARIO_HASTA));
    motentinterplanifs.setAsignacion(db.getString(DBMotEntInterPlanifS.ASIGNACION));

  }
}
