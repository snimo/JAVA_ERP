package com.srn.erp.legales.bl.Factory;


import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.legales.bm.TipoCausaLegales;
import com.srn.erp.legales.da.DBTipoCausaLegales;

public class FactoryTipoCausaLegales extends FactoryObjetoLogico { 

  public FactoryTipoCausaLegales() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoCausaLegales tipocausalegales = (TipoCausaLegales) objLog;
    tipocausalegales.setOID(db.getInteger(DBTipoCausaLegales.OID_TIPO_CAUSA));
    tipocausalegales.setDescripcion(db.getString(DBTipoCausaLegales.DESCRIPCION));
    tipocausalegales.setActivo(db.getBoolean(DBTipoCausaLegales.ACTIVO));
  }
}
