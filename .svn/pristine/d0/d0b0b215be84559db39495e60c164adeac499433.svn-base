package com.srn.erp.ctacte.bl.Factory;

import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctacte.da.DBTipoCtaCteProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoCtaCteProv extends FactoryObjetoLogico {

  public FactoryTipoCtaCteProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoCtaCteProv tipoctacteprov = (TipoCtaCteProv) objLog;
    tipoctacteprov.setOID(db.getInteger(DBTipoCtaCteProv.OID_TIPO_CTA_PROV));
    tipoctacteprov.setCodigo(db.getString(DBTipoCtaCteProv.CODIGO));
    tipoctacteprov.setDescripcion(db.getString(DBTipoCtaCteProv.DESCRIPCION));
    tipoctacteprov.setActivo(db.getBoolean(DBTipoCtaCteProv.ACTIVO));

  }
}
