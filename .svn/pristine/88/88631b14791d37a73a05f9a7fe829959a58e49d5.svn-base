package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.TipoCampania;
import com.srn.erp.crm.da.DBTipoCampania;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoCampania extends FactoryObjetoLogico { 

  public FactoryTipoCampania() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoCampania tipocampania = (TipoCampania) objLog;
    tipocampania.setCodigo(db.getString(DBTipoCampania.CODIGO));
    tipocampania.setDescripcion(db.getString(DBTipoCampania.DESCRIPCION));
    tipocampania.setActivo(db.getBoolean(DBTipoCampania.ACTIVO));
    tipocampania.setOID(db.getInteger(DBTipoCampania.OID_TIPO_CAMP));

  }
}
