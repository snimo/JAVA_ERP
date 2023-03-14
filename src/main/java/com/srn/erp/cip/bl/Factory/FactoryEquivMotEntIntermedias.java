package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.EquivMotEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.da.DBEquivMotEntIntermedias;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEquivMotEntIntermedias extends FactoryObjetoLogico { 

  public FactoryEquivMotEntIntermedias() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EquivMotEntIntermedias equivmotentintermedias = (EquivMotEntIntermedias) objLog;
    equivmotentintermedias.setOID(db.getInteger(DBEquivMotEntIntermedias.OID_EQUIV_MOT));
    equivmotentintermedias.setCodigo(db.getString(DBEquivMotEntIntermedias.CODIGO));
    equivmotentintermedias.setMotivo(MotivoEntIntermedias.findByOidProxy(db.getInteger(DBEquivMotEntIntermedias.OID_MOTIVO),getSesion()));
    equivmotentintermedias.setActivo(db.getBoolean(DBEquivMotEntIntermedias.ACTIVO));

  }
}
