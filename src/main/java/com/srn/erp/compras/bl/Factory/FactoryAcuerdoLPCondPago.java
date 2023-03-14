package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.AcuerdoLPCondPago;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.da.DBAcuerdoLPCondPago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAcuerdoLPCondPago extends FactoryObjetoLogico { 

  public FactoryAcuerdoLPCondPago() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AcuerdoLPCondPago acuerdolpcondpago = (AcuerdoLPCondPago) objLog;
    acuerdolpcondpago.setOID(db.getInteger(DBAcuerdoLPCondPago.OID_ACU_LP_DTOS));
    acuerdolpcondpago.setAcuerdolp(AcuerdoLP.findByOidProxy(db.getInteger(DBAcuerdoLPCondPago.OID_ACUERDO_LP),getSesion()));
    acuerdolpcondpago.setCondicion_pago(CondicionCompra.findByOidProxy(db.getInteger(DBAcuerdoLPCondPago.OID_COND_COMPRA),getSesion()));
    acuerdolpcondpago.setDto_1(db.getDouble(DBAcuerdoLPCondPago.DTO_1));
    acuerdolpcondpago.setDto_2(db.getDouble(DBAcuerdoLPCondPago.DTO_2));
    acuerdolpcondpago.setDto_3(db.getDouble(DBAcuerdoLPCondPago.DTO_3));
    acuerdolpcondpago.setDto_4(db.getDouble(DBAcuerdoLPCondPago.DTO_4));
    acuerdolpcondpago.setDto_5(db.getDouble(DBAcuerdoLPCondPago.DTO_5));
    acuerdolpcondpago.setEn_cascada(db.getBoolean(DBAcuerdoLPCondPago.EN_CASCADA));
    acuerdolpcondpago.setActivo(db.getBoolean(DBAcuerdoLPCondPago.ACTIVO));

  }
}
