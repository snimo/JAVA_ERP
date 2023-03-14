package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.GrupoBien;
import com.srn.erp.bienUso.da.DBGrupoBien;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoBien extends FactoryObjetoLogico { 

  public FactoryGrupoBien() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoBien grupobien = (GrupoBien) objLog;
   grupobien.setOID(db.getInteger(DBGrupoBien.OID_GRUPO_BIEN_USO));
    grupobien.setCodigo(db.getString(DBGrupoBien.CODIGO));
    grupobien.setDescripcion(db.getString(DBGrupoBien.DESCRIPCION));
    grupobien.setAmortiza(db.getBoolean(DBGrupoBien.AMORTIZA));
    grupobien.setAi_vo(CuentaImputable.findByOidProxy(db.getInteger(DBGrupoBien.OID_AI_VO),getSesion()));
    grupobien.setAi_aa(CuentaImputable.findByOidProxy(db.getInteger(DBGrupoBien.OID_AI_AA),getSesion()));
    grupobien.setAi_rvo(CuentaImputable.findByOidProxy(db.getInteger(DBGrupoBien.OID_AI_RVO),getSesion()));
    grupobien.setAi_raa(CuentaImputable.findByOidProxy(db.getInteger(DBGrupoBien.OID_AI_RAA),getSesion()));
    grupobien.setActivo(db.getBoolean(DBGrupoBien.ACTIVO));

  }
}
