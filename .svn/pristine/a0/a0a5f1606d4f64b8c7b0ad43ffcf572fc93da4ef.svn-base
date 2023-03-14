package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.bm.SubReparto;
import com.srn.erp.contabilidad.bm.SubRepartoDet;
import com.srn.erp.contabilidad.da.DBSubRepartoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySubRepartoDet extends FactoryObjetoLogico { 

  public FactorySubRepartoDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SubRepartoDet subrepartodet = (SubRepartoDet) objLog;
    subrepartodet.setOID(db.getInteger(DBSubRepartoDet.OID_SUB_DET));
    subrepartodet.setSecu(db.getInteger(DBSubRepartoDet.SECU));
    subrepartodet.setSubreparto(SubReparto.findByOidProxy(db.getInteger(DBSubRepartoDet.OID_SUBREPARTO),getSesion()));
    subrepartodet.setFase(FaseSubReparto.findByOidProxy(db.getInteger(DBSubRepartoDet.OID_FASE),getSesion()));
    subrepartodet.setActivo(db.getBoolean(DBSubRepartoDet.ACTIVO));

  }
}
