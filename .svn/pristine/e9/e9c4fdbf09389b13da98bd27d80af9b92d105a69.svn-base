package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AnuladorCobVtaMos;
import com.srn.erp.ventas.bm.AnuladorFactCab;
import com.srn.erp.ventas.bm.CobranzaVtaMostrador;
import com.srn.erp.ventas.da.DBAnuladorCobVtaMos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorCobVtaMos extends FactoryObjetoLogico { 

  public FactoryAnuladorCobVtaMos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorCobVtaMos anuladorcobvtamos = (AnuladorCobVtaMos) objLog;
    anuladorcobvtamos.setOID(db.getInteger(DBAnuladorCobVtaMos.OID_ANU_COB_VTA));
    anuladorcobvtamos.setCobranza_vta_mos(CobranzaVtaMostrador.findByOidProxy(db.getInteger(DBAnuladorCobVtaMos.OID_COB_VTA_MOS),getSesion()));
    anuladorcobvtamos.setAnuladorFactura_cab(AnuladorFactCab.findByOidProxy(db.getInteger(DBAnuladorCobVtaMos.OID_ANU_FACT_CAB),getSesion()));

  }
}
