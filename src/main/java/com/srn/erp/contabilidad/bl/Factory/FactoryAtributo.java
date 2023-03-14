package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.da.DBAtributo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAtributo extends FactoryObjetoLogico {

  public FactoryAtributo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Atributo atributo = (Atributo) objLog;
    atributo.setOID(db.getInteger(DBAtributo.OID_ATRIBUTO));
    atributo.setCodigo(db.getString(DBAtributo.CODIGO));
    atributo.setDescripcion(db.getString(DBAtributo.DESCRIPCION));
    atributo.setTipo(db.getString(DBAtributo.TIPO));
    atributo.setCompo(Componente.findByOidProxy(db.getInteger(DBAtributo.OID_COMPO),getSesion()));
    atributo.setActivo(db.getBoolean(DBAtributo.ACTIVO));

  }
}
