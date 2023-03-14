package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.bm.GrupoCajasDet;
import com.srn.erp.tesoreria.da.DBGrupoCajasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoCajasDet extends FactoryObjetoLogico { 

  public FactoryGrupoCajasDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoCajasDet grupocajasdet = (GrupoCajasDet) objLog;
    grupocajasdet.setOID(db.getInteger(DBGrupoCajasDet.OID_GRUPO_CAJA_DET));
    grupocajasdet.setGrupo_caja(GrupoCajas.findByOidProxy(db.getInteger(DBGrupoCajasDet.OID_GRUPO_CAJA),getSesion()));
    grupocajasdet.setCaja(Caja.findByOidProxy(db.getInteger(DBGrupoCajasDet.OID_CAJA),getSesion()));
    grupocajasdet.setOrden(db.getInteger(DBGrupoCajasDet.ORDEN));
    grupocajasdet.setActivo(db.getBoolean(DBGrupoCajasDet.ACTIVO));

  }
}
