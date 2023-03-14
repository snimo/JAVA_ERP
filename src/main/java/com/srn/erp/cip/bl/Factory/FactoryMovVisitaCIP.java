package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MovVisitaCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.cip.da.DBMovVisitaCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMovVisitaCIP extends FactoryObjetoLogico { 

  public FactoryMovVisitaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MovVisitaCIP movvisitacip = (MovVisitaCIP) objLog;
    movvisitacip.setOID(db.getInteger(DBMovVisitaCIP.OID_MOVI_VISITA));
    movvisitacip.setVisita(Visita.findByOidProxy(db.getInteger(DBMovVisitaCIP.OID_VISITA),getSesion()));
    movvisitacip.setPuerta(Puerta.findByOidProxy(db.getInteger(DBMovVisitaCIP.OID_PUERTA),getSesion()));
    movvisitacip.setFecha(db.getDate(DBMovVisitaCIP.FECHA));
    movvisitacip.setHora(db.getString(DBMovVisitaCIP.HORA));
    movvisitacip.setHora_en_min(db.getInteger(DBMovVisitaCIP.HORA_EN_MIN));
    movvisitacip.setSentido(db.getString(DBMovVisitaCIP.SENTIDO));
    movvisitacip.setFec_hor(db.getDateTime(DBMovVisitaCIP.FEC_HOR));
    movvisitacip.setZona_origen(ZonaCIP.findByOidProxy(db.getInteger(DBMovVisitaCIP.OID_ZONA_ORIGEN),getSesion()));
    movvisitacip.setZona_destino(ZonaCIP.findByOidProxy(db.getInteger(DBMovVisitaCIP.OID_ZONA_DESTINO),getSesion()));
    movvisitacip.setVisita_a(Legajo.findByOidProxy(db.getInteger(DBMovVisitaCIP.OID_VISITA_A),getSesion()));
    movvisitacip.setAutorizo(Legajo.findByOidProxy(db.getInteger(DBMovVisitaCIP.OID_AUTORIZO),getSesion()));
    movvisitacip.setActivo(db.getBoolean(DBMovVisitaCIP.ACTIVO));
    movvisitacip.setTarjeta(TarjetaCIP.findByOidProxy(db.getInteger(DBMovVisitaCIP.OID_TARJETA),getSesion()));

  }
}
