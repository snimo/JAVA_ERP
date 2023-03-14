package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoPuertaDet;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.da.DBGrupoPuertaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoPuertaDet extends FactoryObjetoLogico { 

  public FactoryGrupoPuertaDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoPuertaDet grupopuertadet = (GrupoPuertaDet) objLog;
    grupopuertadet.setOID(db.getInteger(DBGrupoPuertaDet.OID_GRUPO_DET));
    grupopuertadet.setGrupo_puertas(GrupoPuerta.findByOidProxy(db.getInteger(DBGrupoPuertaDet.OID_GRUPO_PUERTA),getSesion()));
    grupopuertadet.setPuerta(Puerta.findByOidProxy(db.getInteger(DBGrupoPuertaDet.OID_PUERTA),getSesion()));
    grupopuertadet.setActivo(db.getBoolean(DBGrupoPuertaDet.ACTIVO));

  }
}
