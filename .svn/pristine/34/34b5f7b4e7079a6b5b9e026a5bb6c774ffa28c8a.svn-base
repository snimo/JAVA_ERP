package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.LegFecRotPayroll;
import com.srn.erp.cip.da.DBLegFecRotPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLegFecRotPayroll extends FactoryObjetoLogico { 

  public FactoryLegFecRotPayroll() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LegFecRotPayroll legfecrotpayroll = (LegFecRotPayroll) objLog;
    legfecrotpayroll.setOID(db.getInteger(DBLegFecRotPayroll.OID_LEG_ROT_FEC));
    legfecrotpayroll.setEtrlegajo(db.getString(DBLegFecRotPayroll.ETRLEGAJO));
    legfecrotpayroll.setEtrfecha(db.getDate(DBLegFecRotPayroll.ETRFECHA));
    legfecrotpayroll.setEtrtramo(db.getString(DBLegFecRotPayroll.ETRTRAMO));
    legfecrotpayroll.setActivo(db.getBoolean(DBLegFecRotPayroll.ACTIVO));

  }
}
