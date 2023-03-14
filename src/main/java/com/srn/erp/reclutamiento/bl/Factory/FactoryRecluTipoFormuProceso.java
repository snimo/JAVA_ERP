package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;
import com.srn.erp.reclutamiento.da.DBRecluTipoFormuProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluTipoFormuProceso extends FactoryObjetoLogico { 

  public FactoryRecluTipoFormuProceso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluTipoFormuProceso reclutipoformuproceso = (RecluTipoFormuProceso) objLog;
    reclutipoformuproceso.setOID(db.getInteger(DBRecluTipoFormuProceso.OID_TIPO_FORMU));
    reclutipoformuproceso.setCodigo(db.getString(DBRecluTipoFormuProceso.CODIGO));
    reclutipoformuproceso.setDescripcion(db.getString(DBRecluTipoFormuProceso.DESCRIPCION));
    reclutipoformuproceso.setActivo(db.getBoolean(DBRecluTipoFormuProceso.ACTIVO));

  }
}
