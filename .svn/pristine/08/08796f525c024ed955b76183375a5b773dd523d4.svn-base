package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TarjetaRotaVisita;
import com.srn.erp.cip.da.DBTarjetaRotaVisita;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTarjetaRotaVisita extends FactoryObjetoLogico { 

  public FactoryTarjetaRotaVisita() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TarjetaRotaVisita tarjetarotavisita = (TarjetaRotaVisita) objLog;
    tarjetarotavisita.setOID(db.getInteger(DBTarjetaRotaVisita.OID_TARJ_ROT));
    tarjetarotavisita.setTarjeta(TarjetaCIP.findByOidProxy(db.getInteger(DBTarjetaRotaVisita.OID_TARJETA),getSesion()));
    tarjetarotavisita.setFecha(db.getDate(DBTarjetaRotaVisita.FECHA));
    tarjetarotavisita.setRota(Rota.findByOidProxy(db.getInteger(DBTarjetaRotaVisita.OID_ROTA),getSesion()));
    tarjetarotavisita.setActivo(db.getBoolean(DBTarjetaRotaVisita.ACTIVO));

  }
}
