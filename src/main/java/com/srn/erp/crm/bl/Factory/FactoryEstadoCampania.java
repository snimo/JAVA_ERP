package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.EstadoCampania;
import com.srn.erp.crm.da.DBEstadoCampania;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoCampania extends FactoryObjetoLogico { 

  public FactoryEstadoCampania() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoCampania estadocampania = (EstadoCampania) objLog;
    estadocampania.setCodigo(db.getString(DBEstadoCampania.CODIGO));
    estadocampania.setDescripcion(db.getString(DBEstadoCampania.DESCRIPCION));
    estadocampania.setActivo(db.getBoolean(DBEstadoCampania.ACTIVO));
    estadocampania.setComportamiento(db.getString(DBEstadoCampania.COMPO_EST_CAMP));
   estadocampania.setOID(db.getInteger(DBEstadoCampania.OID_ESTADO_CAMP));

  }
}
