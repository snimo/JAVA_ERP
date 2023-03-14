package com.srn.erp.proveedoresMaterials.bl.Factory;

import com.srn.erp.proveedoresMaterials.bm.NumeradorMaterial;
import com.srn.erp.proveedoresMaterials.da.DBNumeradorMaterial;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNumeradorMaterial extends FactoryObjetoLogico { 

  public FactoryNumeradorMaterial() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NumeradorMaterial numeradormaterial = (NumeradorMaterial) objLog;
    numeradormaterial.setStb_name(db.getString(DBNumeradorMaterial.STB_NAME));
    numeradormaterial.setStb_identnr(db.getInteger(DBNumeradorMaterial.STB_IDENTNR));
  }
  
}
