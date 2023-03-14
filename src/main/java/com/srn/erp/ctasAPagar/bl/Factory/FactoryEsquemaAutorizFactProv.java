package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactProv;
import com.srn.erp.ctasAPagar.da.DBEsquemaAutorizFactProv;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaAutorizFactProv extends FactoryObjetoLogico { 

  public FactoryEsquemaAutorizFactProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsquemaAutorizFactProv esquemaautorizfactprov = (EsquemaAutorizFactProv) objLog;
    esquemaautorizfactprov.setOID(db.getInteger(DBEsquemaAutorizFactProv.OID_ESQ_AUT_FACT));
    esquemaautorizfactprov.setCodigo(db.getString(DBEsquemaAutorizFactProv.CODIGO));
    esquemaautorizfactprov.setDescripcion(db.getString(DBEsquemaAutorizFactProv.DESCRIPCION));
    esquemaautorizfactprov.setMoneda(Moneda.findByOidProxy(db.getInteger(DBEsquemaAutorizFactProv.OID_MONEDA),getSesion()));
    esquemaautorizfactprov.setActivo(db.getBoolean(DBEsquemaAutorizFactProv.ACTIVO));

  }
}
