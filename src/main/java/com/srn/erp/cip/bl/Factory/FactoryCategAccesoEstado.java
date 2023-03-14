package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoEstado;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.da.DBCategAccesoEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategAccesoEstado extends FactoryObjetoLogico { 

  public FactoryCategAccesoEstado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategAccesoEstado categaccesoestado = (CategAccesoEstado) objLog;
    categaccesoestado.setOID(db.getInteger(DBCategAccesoEstado.OID_ACC_EST));
    categaccesoestado.setEstado(EstadoCIP.findByOidProxy(db.getInteger(DBCategAccesoEstado.OID_ESTADO),getSesion()));
    categaccesoestado.setCategoria(CategAccesoCIP.findByOidProxy(db.getInteger(DBCategAccesoEstado.OID_CATEG_ACCESO),getSesion()));
    categaccesoestado.setActivo(db.getBoolean(DBCategAccesoEstado.ACTIVO));

  }
}
