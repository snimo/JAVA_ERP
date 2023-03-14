package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PaseRechazado;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.da.DBPaseRechazado;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPaseRechazado extends FactoryObjetoLogico { 

  public FactoryPaseRechazado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PaseRechazado paserechazado = (PaseRechazado) objLog;
    paserechazado.setOID(db.getInteger(DBPaseRechazado.OID_PASE_RECH));
    paserechazado.setLegajo(Legajo.findByOidProxy(db.getInteger(DBPaseRechazado.OID_LEGAJO),getSesion()));
    paserechazado.setFecha(db.getDate(DBPaseRechazado.FECHA));
    paserechazado.setHora(db.getString(DBPaseRechazado.HORA));
    paserechazado.setPuerta(Puerta.findByOidProxy(db.getInteger(DBPaseRechazado.OID_PUERTA),getSesion()));
    paserechazado.setMedia(db.getInteger(DBPaseRechazado.MEDIA));
    paserechazado.setMotivo(db.getString(DBPaseRechazado.MOTIVO));
    paserechazado.setActivo(db.getBoolean(DBPaseRechazado.ACTIVO));
    paserechazado.setEntradaSalida(db.getString(DBPaseRechazado.ENTRADA_SALIDA));
    paserechazado.setVisita(Visita.findByOidProxy(db.getInteger(DBPaseRechazado.OID_VISITA),getSesion()));
  }
}
