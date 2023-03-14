package com.srn.erp.payroll.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.payroll.bm.PayTareaDesempenada;
import com.srn.erp.payroll.da.DBPayTareaDesempenada;

public class FactoryPayTareaDesempenada extends FactoryObjetoLogico { 

  public FactoryPayTareaDesempenada() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PayTareaDesempenada paytareadesempenada = (PayTareaDesempenada) objLog;
    paytareadesempenada.setCodigo(db.getInteger(DBPayTareaDesempenada.CODIGO));
    paytareadesempenada.setDescripcion(db.getString(DBPayTareaDesempenada.DESCRIP));

  }
}
