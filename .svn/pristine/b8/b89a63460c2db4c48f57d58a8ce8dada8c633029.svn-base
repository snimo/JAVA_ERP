package com.srn.erp.produccion.bl.Factory;

import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.da.DBAlternativaFabricacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAlternativaFabricacion extends FactoryObjetoLogico { 

  public FactoryAlternativaFabricacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AlternativaFabricacion alternativafabricacion = (AlternativaFabricacion) objLog;
    alternativafabricacion.setOID(db.getInteger(DBAlternativaFabricacion.OID_ALTER_FABRI));
    alternativafabricacion.setReceta(RecetaCab.findByOidProxy(db.getInteger(DBAlternativaFabricacion.OID_REC_CAB),getSesion()));
    alternativafabricacion.setAlternativa(db.getString(DBAlternativaFabricacion.ALTERNATIVA));
    alternativafabricacion.setActivo(db.getBoolean(DBAlternativaFabricacion.ACTIVO));

  }
}
