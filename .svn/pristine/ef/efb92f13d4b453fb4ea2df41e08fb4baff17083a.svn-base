package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProveedorAnulador;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.da.DBComproProveedorAnulador;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProveedorAnulador extends FactoryObjetoLogico { 

  public FactoryComproProveedorAnulador() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProveedorAnulador comproproveedoranulador = (ComproProveedorAnulador) objLog;
    comproproveedoranulador.setOID(db.getInteger(DBComproProveedorAnulador.OID_COMPRO_PROV_A));
    comproproveedoranulador.setComprobanteBase(ComproProveedorBase.findByOidProxy(db.getInteger(DBComproProveedorAnulador.OID_CCO),getSesion()));
  }
}
