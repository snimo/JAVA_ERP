package com.srn.erp.legales.bl.Factory;


import com.srn.erp.legales.bm.CartasDocRemLega;
import com.srn.erp.legales.bm.TipoCausaLegales;
import com.srn.erp.legales.da.DBCartasDocRemLega;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCartasDocRemLega extends FactoryObjetoLogico { 

  public FactoryCartasDocRemLega() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CartasDocRemLega cartasdocremlega = (CartasDocRemLega) objLog;
    cartasdocremlega.setOID(db.getInteger(DBCartasDocRemLega.OID_CARTA_REMITIDA));
    cartasdocremlega.setNro_orden(db.getInteger(DBCartasDocRemLega.NRO_ORDEN));
    cartasdocremlega.setLegajo(Legajo.findByOidProxy(db.getInteger(DBCartasDocRemLega.OID_LEGAJO),getSesion()));
    cartasdocremlega.setNro_carta_doc(db.getString(DBCartasDocRemLega.NRO_CARTA_DOC));
    cartasdocremlega.setFecha(db.getDate(DBCartasDocRemLega.FECHA));
    cartasdocremlega.setTipocausa(TipoCausaLegales.findByOidProxy(db.getInteger(DBCartasDocRemLega.OID_TIPO_CAUSA),getSesion()));
    cartasdocremlega.setCausa(db.getString(DBCartasDocRemLega.CAUSA));
    cartasdocremlega.setRecibido(db.getDate(DBCartasDocRemLega.RECIBIDO));
    cartasdocremlega.setObservaciones(db.getString(DBCartasDocRemLega.OBSERVACIONES));
    cartasdocremlega.setActivo(db.getBoolean(DBCartasDocRemLega.ACTIVO));
  }
}
