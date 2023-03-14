package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.MaqPuertasVisita;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.da.DBMaqPuertasVisita;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMaqPuertasVisita extends FactoryObjetoLogico { 

  public FactoryMaqPuertasVisita() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MaqPuertasVisita maqpuertasvisita = (MaqPuertasVisita) objLog;
    maqpuertasvisita.setOID(db.getInteger(DBMaqPuertasVisita.OID_MAQ_PUE_VIS));
    maqpuertasvisita.setMaquina(db.getString(DBMaqPuertasVisita.MAQUINA));
    maqpuertasvisita.setPuerta_entrada(Puerta.findByOidProxy(db.getInteger(DBMaqPuertasVisita.OID_PUERTA_ENT),getSesion()));
    maqpuertasvisita.setPuerta_salida(Puerta.findByOidProxy(db.getInteger(DBMaqPuertasVisita.OID_PUERTA_SAL),getSesion()));
    maqpuertasvisita.setActivo(db.getBoolean(DBMaqPuertasVisita.ACTIVO));
    maqpuertasvisita.setGrupoPuerta(GrupoPuerta.findByOidProxy(db.getInteger(DBMaqPuertasVisita.OID_GRUPO_PUERTA),getSesion()));
  }
}
