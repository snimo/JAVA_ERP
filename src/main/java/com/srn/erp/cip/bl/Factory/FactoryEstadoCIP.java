package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.da.DBEstadoCIP;

public class FactoryEstadoCIP extends FactoryObjetoLogico { 

  public FactoryEstadoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoCIP estadocip = (EstadoCIP) objLog;
    estadocip.setOID(db.getInteger(DBEstadoCIP.OID_ESTADO));
    estadocip.setCodigo(db.getString(DBEstadoCIP.CODIGO));
    estadocip.setDescripcion(db.getString(DBEstadoCIP.DESCRIPCION));
    estadocip.setTipo_ingreso(db.getString(DBEstadoCIP.TIPO_INGRESO));
    estadocip.setTipo_egreso(db.getString(DBEstadoCIP.TIPO_EGRESO));
    estadocip.setActivo(db.getBoolean(DBEstadoCIP.ACTIVO));
    estadocip.setLeyendaIngDenegado(db.getString(DBEstadoCIP.LEY_ING_DENEGADO));
    estadocip.setLeyendaEgrDenegado(db.getString(DBEstadoCIP.LEY_EGR_DENEGADO));
    estadocip.setActivarAntiPassBack(db.getBoolean(DBEstadoCIP.ACTIVAR_ANTI_PASS_BACK));
    estadocip.setEsSusceptibleCacheo(db.getBoolean(DBEstadoCIP.ES_SUSCEP_CACHEO));
    estadocip.setMinEntAntEntrada(db.getInteger(DBEstadoCIP.MIN_ENT_ANT_ENTRADA));
    estadocip.setMinEntDesEntrada(db.getInteger(DBEstadoCIP.MIN_ENT_DES_ENTRADA));
  }
}
