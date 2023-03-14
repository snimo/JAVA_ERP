package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.pagos.bm.RendicionFFUniOrg;
import com.srn.erp.pagos.bm.RendicionFFUniOrgCta;
import com.srn.erp.pagos.da.DBRendicionFFUniOrgCta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFFUniOrgCta extends FactoryObjetoLogico { 

  public FactoryRendicionFFUniOrgCta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFFUniOrgCta rendicionffuniorgcta = (RendicionFFUniOrgCta) objLog;
    rendicionffuniorgcta.setOID(db.getInteger(DBRendicionFFUniOrgCta.OID_FF_CTA));
    rendicionffuniorgcta.setUnidad_organizativa_ff(RendicionFFUniOrg.findByOidProxy(db.getInteger(DBRendicionFFUniOrgCta.OID_UNI_ORG_FF),getSesion()));
    rendicionffuniorgcta.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBRendicionFFUniOrgCta.OID_ANA_CON),getSesion()));
    rendicionffuniorgcta.setActivo(db.getBoolean(DBRendicionFFUniOrgCta.ACTIVO));

  }
}
