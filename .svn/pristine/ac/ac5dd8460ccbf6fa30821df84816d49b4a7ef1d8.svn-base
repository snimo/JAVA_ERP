package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.RotaVisita;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.da.DBRotaVisita;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRotaVisita extends FactoryObjetoLogico { 

  public FactoryRotaVisita() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RotaVisita rotavisita = (RotaVisita) objLog;
    rotavisita.setOID(db.getInteger(DBRotaVisita.OID_ROTA_VISITA));
    rotavisita.setFecha(db.getDate(DBRotaVisita.FECHA));
    rotavisita.setVisita(Visita.findByOidProxy(db.getInteger(DBRotaVisita.OID_VISITA),getSesion()));
    rotavisita.setRota(Rota.findByOidProxy(db.getInteger(DBRotaVisita.OID_ROTA),getSesion()));
    rotavisita.setActivo(db.getBoolean(DBRotaVisita.ACTIVO));
    rotavisita.setGrupoVisita(GrupoVisita.findByOidProxy(db.getInteger(DBRotaVisita.OID_GRUPO_VISITA),getSesion()));

  }
}
