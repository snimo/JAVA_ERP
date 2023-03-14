package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.MotEntInterEst;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.da.DBMotEntInterEst;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotEntInterEst extends FactoryObjetoLogico { 

  public FactoryMotEntInterEst() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotEntInterEst motentinterest = (MotEntInterEst) objLog;
    motentinterest.setOID(db.getInteger(DBMotEntInterEst.OID_MOT_EST_INT));
    motentinterest.setMotivo(MotivoEntIntermedias.findByOidProxy(db.getInteger(DBMotEntInterEst.OID_MOTIVO),getSesion()));
    motentinterest.setEstado(EstadoCIP.findByOidProxy(db.getInteger(DBMotEntInterEst.OID_ESTADO),getSesion()));
    motentinterest.setActivo(db.getBoolean(DBMotEntInterEst.ACTIVO));

  }
}
