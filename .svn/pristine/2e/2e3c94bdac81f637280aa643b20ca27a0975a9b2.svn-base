package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosPorUniOrg;
import com.srn.erp.ventas.da.DBListaPreciosPorUniOrg;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListaPreciosPorUniOrg extends FactoryObjetoLogico {

  public FactoryListaPreciosPorUniOrg() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListaPreciosPorUniOrg listapreciosporuniorg = (ListaPreciosPorUniOrg) objLog;
    listapreciosporuniorg.setOID(db.getInteger(DBListaPreciosPorUniOrg.OID_PRECIO_UNI_ORG));
    listapreciosporuniorg.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBListaPreciosPorUniOrg.OID_UNI_ORG),getSesion()));
    listapreciosporuniorg.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBListaPreciosPorUniOrg.OID_PRECIO_CAB),getSesion()));

  }
}
