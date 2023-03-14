package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.AnuladorOPMedPago;
import com.srn.erp.pagos.bm.AnuladorOrdenDePago;
import com.srn.erp.pagos.bm.ComproOrdenPagoMediosPago;
import com.srn.erp.pagos.da.DBAnuladorOPMedPago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorOPMedPago extends FactoryObjetoLogico { 

  public FactoryAnuladorOPMedPago() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorOPMedPago anuladoropmedpago = (AnuladorOPMedPago) objLog;
    anuladoropmedpago.setOID(db.getInteger(DBAnuladorOPMedPago.OID_ANU_OP_MP));
    anuladoropmedpago.setAnulador_op_cab(AnuladorOrdenDePago.findByOidProxy(db.getInteger(DBAnuladorOPMedPago.OID_ANU_OP_CAB),getSesion()));
    anuladoropmedpago.setMedio_pago(ComproOrdenPagoMediosPago.findByOidProxy(db.getInteger(DBAnuladorOPMedPago.OID_OP_MEDIO_PAGO),getSesion()));

  }
}
