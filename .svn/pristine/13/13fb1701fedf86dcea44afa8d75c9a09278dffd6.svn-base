package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ComproAjusteStkAnu;
import com.srn.erp.stock.bm.ComproAjusteStkDet;
import com.srn.erp.stock.bm.ComproAjusteStkDetAnu;
import com.srn.erp.stock.da.DBComproAjusteStkDetAnu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproAjusteStkDetAnu extends FactoryObjetoLogico { 

  public FactoryComproAjusteStkDetAnu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproAjusteStkDetAnu comproajustestkdetanu = (ComproAjusteStkDetAnu) objLog;
    comproajustestkdetanu.setOID(db.getInteger(DBComproAjusteStkDetAnu.OID_AJU_DET_ANU));
    comproajustestkdetanu.setCompro_aju_stk_anu(ComproAjusteStkAnu.findByOidProxy(db.getInteger(DBComproAjusteStkDetAnu.OID_AJU_ANU),getSesion()));
    comproajustestkdetanu.setCompro_aju_stk_det(ComproAjusteStkDet.findByOidProxy(db.getInteger(DBComproAjusteStkDetAnu.OID_AJU_STK_DET),getSesion()));

  }
}
