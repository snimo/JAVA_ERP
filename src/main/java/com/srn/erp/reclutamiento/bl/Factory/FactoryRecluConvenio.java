package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluConvenio;
import com.srn.erp.reclutamiento.da.DBRecluConvenio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluConvenio extends FactoryObjetoLogico { 

  public FactoryRecluConvenio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluConvenio recluconvenio = (RecluConvenio) objLog;
    recluconvenio.setOID(db.getInteger(DBRecluConvenio.OID_CONVENIO));
    recluconvenio.setCodigo(db.getString(DBRecluConvenio.CODIGO));
    recluconvenio.setDescripcion(db.getString(DBRecluConvenio.DESCRIPCION));
    recluconvenio.setActivo(db.getBoolean(DBRecluConvenio.ACTIVO));

  }
}
