package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.da.DBLegajoRotaFecha;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLegajoRotaFecha extends FactoryObjetoLogico { 

  public FactoryLegajoRotaFecha() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LegajoRotaFecha legajorotafecha = (LegajoRotaFecha) objLog;
    legajorotafecha.setOID(db.getInteger(DBLegajoRotaFecha.OID_LEG_ROT_FEC));
    legajorotafecha.setLegajo(Legajo.findByOidProxy(db.getInteger(DBLegajoRotaFecha.OID_LEGAJO),getSesion()));
    legajorotafecha.setRota(Rota.findByOidProxy(db.getInteger(DBLegajoRotaFecha.OID_ROTA),getSesion()));
    legajorotafecha.setFecha(db.getDate(DBLegajoRotaFecha.FECHA));
    legajorotafecha.setActivo(db.getBoolean(DBLegajoRotaFecha.ACTIVO));
  }
}
