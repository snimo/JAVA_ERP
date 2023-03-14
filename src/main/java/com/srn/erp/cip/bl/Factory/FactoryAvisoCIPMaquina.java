package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AvisoCIPMaquina;
import com.srn.erp.cip.da.DBAvisoCIPMaquina;
import com.srn.erp.mensajero.bm.Maquina;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAvisoCIPMaquina extends FactoryObjetoLogico { 

  public FactoryAvisoCIPMaquina() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AvisoCIPMaquina avisocipmaquina = (AvisoCIPMaquina) objLog;
    avisocipmaquina.setOID(db.getInteger(DBAvisoCIPMaquina.OID_AVI_CAC_MAQ));
    avisocipmaquina.setMaquina(Maquina.findByOidProxy(db.getInteger(DBAvisoCIPMaquina.OID_MAQUINA),getSesion()));
    avisocipmaquina.setOid_obj_neg(db.getInteger(DBAvisoCIPMaquina.OID_OBJ_NEG));
    avisocipmaquina.setCircuito(db.getString(DBAvisoCIPMaquina.CIRCUITO));

  }
}
