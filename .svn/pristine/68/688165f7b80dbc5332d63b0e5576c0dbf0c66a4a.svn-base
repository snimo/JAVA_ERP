package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluSelector;
import com.srn.erp.reclutamiento.da.DBRecluSelector;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluSelector extends FactoryObjetoLogico { 

  public FactoryRecluSelector() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluSelector recluselector = (RecluSelector) objLog;
    recluselector.setOID(db.getInteger(DBRecluSelector.OID_SELECTOR));
    recluselector.setCodigo(db.getString(DBRecluSelector.CODIGO));
    recluselector.setDescripcion(db.getString(DBRecluSelector.DESCRIPCION));
    recluselector.setUsuario(Usuario.findByOidProxy(db.getInteger(DBRecluSelector.OID_USUARIO),getSesion()));
    recluselector.setActivo(db.getBoolean(DBRecluSelector.ACTIVO));

  }
}
