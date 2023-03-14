package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MovimientoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.cip.da.DBMovimientoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMovimientoCIP extends FactoryObjetoLogico { 

  public FactoryMovimientoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MovimientoCIP movimientocip = (MovimientoCIP) objLog;
    movimientocip.setOID(db.getInteger(DBMovimientoCIP.OID_MOV));
    movimientocip.setLegajo(Legajo.findByOidProxy(db.getInteger(DBMovimientoCIP.OID_LEGAJO),getSesion()));
    movimientocip.setPuerta(Puerta.findByOidProxy(db.getInteger(DBMovimientoCIP.OID_PUERTA),getSesion()));
    movimientocip.setFecha(db.getDate(DBMovimientoCIP.FECHA));
    movimientocip.setHora(db.getString(DBMovimientoCIP.HORA));
    movimientocip.setHora_en_min(db.getInteger(DBMovimientoCIP.HORA_EN_MIN));
    movimientocip.setSentido(db.getString(DBMovimientoCIP.SENTIDO));
    movimientocip.setActivo(db.getBoolean(DBMovimientoCIP.ACTIVO));
    movimientocip.setFecHora(db.getDateTime(DBMovimientoCIP.FEC_HOR));
    movimientocip.setZonaOrigen(ZonaCIP.findByOidProxy(db.getInteger(DBMovimientoCIP.OID_ZONA_ORIGEN), this.getSesion()));
    movimientocip.setZonaDestino(ZonaCIP.findByOidProxy(db.getInteger(DBMovimientoCIP.OID_ZONA_DESTINO), this.getSesion()));
  }
}
