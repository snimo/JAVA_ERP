package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AnuladorInfCC;
import com.srn.erp.compras.bm.AnuladorInfCCDet;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.da.DBAnuladorInfCCDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorInfCCDet extends FactoryObjetoLogico { 

  public FactoryAnuladorInfCCDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorInfCCDet anuladorinfccdet = (AnuladorInfCCDet) objLog;
    anuladorinfccdet.setOID(db.getInteger(DBAnuladorInfCCDet.OID_DET_CC_ANU));
    anuladorinfccdet.setAnulador_inf_cc(AnuladorInfCC.findByOidProxy(db.getInteger(DBAnuladorInfCCDet.OID_ANU_CC),getSesion()));
    anuladorinfccdet.setDetalle_inf_cc(InformeControlCalidadDet.findByOidProxy(db.getInteger(DBAnuladorInfCCDet.OID_CC_DET),getSesion()));

  }
}
