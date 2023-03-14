package com.srn.erp.legales.bl.Factory;


import com.srn.erp.legales.bm.EstadoSeclo;
import com.srn.erp.legales.da.DBEstadoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoSeclo extends FactoryObjetoLogico { 

  public FactoryEstadoSeclo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoSeclo estadoseclo = (EstadoSeclo) objLog;
    estadoseclo.setOID(db.getInteger(DBEstadoSeclo.OID_ESTADO_SECLO));
    estadoseclo.setDescripcion(db.getString(DBEstadoSeclo.DESCRIPCION));
    estadoseclo.setActivo(db.getBoolean(DBEstadoSeclo.ACTIVO));

  }
}
