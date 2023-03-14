package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AnuladorFactCab;
import com.srn.erp.ventas.bm.AnuladorFactCabDet;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.da.DBAnuladorFactCabDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorFactCabDet extends FactoryObjetoLogico { 

  public FactoryAnuladorFactCabDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorFactCabDet anuladorfactcabdet = (AnuladorFactCabDet) objLog;
    anuladorfactcabdet.setOID(db.getInteger(DBAnuladorFactCabDet.OID_ANU_FACT_DET));
    anuladorfactcabdet.setAnulador_factura_cab(AnuladorFactCab.findByOidProxy(db.getInteger(DBAnuladorFactCabDet.OID_ANU_FACT_CAB),getSesion()));
    anuladorfactcabdet.setFactura_det(FacturaDet.findByOidProxy(db.getInteger(DBAnuladorFactCabDet.OID_FACT_DET),getSesion()));

  }
}
