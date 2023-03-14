package com.srn.erp.ctacte.bl.Factory;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctacte.da.DBTipoCtaCteClie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoCtaCteClie extends FactoryObjetoLogico {

  public FactoryTipoCtaCteClie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoCtaCteClie tipoctacteclie = (TipoCtaCteClie) objLog;
    tipoctacteclie.setOID(db.getInteger(DBTipoCtaCteClie.OID_TIPO_CTA_CLIE));
    tipoctacteclie.setCodigo(db.getString(DBTipoCtaCteClie.CODIGO));
    tipoctacteclie.setDescripcion(db.getString(DBTipoCtaCteClie.DESCRIPCION));
    tipoctacteclie.setActivo(db.getBoolean(DBTipoCtaCteClie.ACTIVO));
  }
}
