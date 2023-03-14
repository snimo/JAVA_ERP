package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ComproProvDetCtaImpu;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.da.DBComproProvDetCtaImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProvDetCtaImpu extends FactoryObjetoLogico {

  public FactoryComproProvDetCtaImpu() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProvDetCtaImpu comproprovdetctaimpu = (ComproProvDetCtaImpu) objLog;
    comproprovdetctaimpu.setOID(db.getInteger(DBComproProvDetCtaImpu.OID_CCO_DET_CTA));
    comproprovdetctaimpu.setCuentaimputable(CuentaImputable.findByOidProxy(db.getInteger(DBComproProvDetCtaImpu.OID_AI),getSesion()));
    comproprovdetctaimpu.setImporte(db.getDouble(DBComproProvDetCtaImpu.IMPO_MONEDA_ORI));
    comproprovdetctaimpu.setComproprovdet(ComproProveedorDet.findByOidProxy(db.getInteger(DBComproProvDetCtaImpu.OID_CCO_PROV_DET),getSesion()));
    comproprovdetctaimpu.setActivo(db.getBoolean(DBComproProvDetCtaImpu.ACTIVO));
    comproprovdetctaimpu.setComentario(db.getString(DBComproProvDetCtaImpu.COMENTARIO));
  }
}
