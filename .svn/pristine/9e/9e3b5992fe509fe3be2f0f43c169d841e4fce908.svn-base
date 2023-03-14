package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.pagos.bm.RendicionFFUniOrg;
import com.srn.erp.pagos.da.DBRendicionFFUniOrg;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFFUniOrg extends FactoryObjetoLogico { 

  public FactoryRendicionFFUniOrg() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFFUniOrg rendicionffuniorg = (RendicionFFUniOrg) objLog;
    rendicionffuniorg.setOID(db.getInteger(DBRendicionFFUniOrg.OID_UNI_ORG_FF));
    rendicionffuniorg.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBRendicionFFUniOrg.OID_UNI_ORG),getSesion()));
    rendicionffuniorg.setActivo(db.getBoolean(DBRendicionFFUniOrg.ACTIVO));

  }
}
