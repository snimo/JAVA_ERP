package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.da.DBCompoAtributo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoAtributo extends FactoryObjetoLogico {

  public FactoryCompoAtributo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoAtributo compoatributo = (CompoAtributo) objLog;
    compoatributo.setOID(db.getInteger(DBCompoAtributo.OID_COMPO_ATRI));
    compoatributo.setCompo(Componente.findByOidProxy(db.getInteger(DBCompoAtributo.OID_COMPO),getSesion()));
    compoatributo.setSecu(db.getInteger(DBCompoAtributo.SECU));
    compoatributo.setAtributo(Atributo.findByOidProxy(db.getInteger(DBCompoAtributo.OID_ATRIBUTO),getSesion()));
    compoatributo.setActivo(db.getBoolean(DBCompoAtributo.ACTIVO));
  }
}
