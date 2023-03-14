package com.srn.erp.payroll.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.payroll.bm.PaySectores;
import com.srn.erp.payroll.da.DBPaySectores;

public class FactoryPaySectores extends FactoryObjetoLogico { 

  public FactoryPaySectores() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PaySectores paysectores = (PaySectores) objLog;
    paysectores.setCodigo(db.getInteger(DBPaySectores.CODIGO));
    paysectores.setDescripcion(db.getString(DBPaySectores.DESCRIP));

  }
}
