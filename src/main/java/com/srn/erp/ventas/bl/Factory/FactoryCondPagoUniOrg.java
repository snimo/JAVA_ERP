package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.ventas.bm.CondPagoUniOrg;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.da.DBCondPagoUniOrg;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondPagoUniOrg extends FactoryObjetoLogico {

  public FactoryCondPagoUniOrg() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondPagoUniOrg condpagouniorg = (CondPagoUniOrg) objLog;
    condpagouniorg.setOID(db.getInteger(DBCondPagoUniOrg.OID_CP_UNI_ORG));
    condpagouniorg.setCondicion_pago(CondicionPago.findByOidProxy(db.getInteger(DBCondPagoUniOrg.OID_COND_PAGO),getSesion()));
    condpagouniorg.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBCondPagoUniOrg.OID_UNI_ORG),getSesion()));
  }
}
