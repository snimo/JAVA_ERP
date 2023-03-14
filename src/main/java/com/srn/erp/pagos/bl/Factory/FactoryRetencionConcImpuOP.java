package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.RetencionConcImpuOP;
import com.srn.erp.pagos.da.DBRetencionConcImpuOP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetencionConcImpuOP extends FactoryObjetoLogico {

  public FactoryRetencionConcImpuOP() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetencionConcImpuOP retencionconcimpuop = (RetencionConcImpuOP) objLog;
    retencionconcimpuop.setOID(db.getInteger(DBRetencionConcImpuOP.OID_OP_RET_CIMP));
    retencionconcimpuop.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBRetencionConcImpuOP.OID_CCO),getSesion()));
    retencionconcimpuop.setConcimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRetencionConcImpuOP.OID_CONC_IMPU),getSesion()));
    retencionconcimpuop.setImpomonpago(db.getMoney(DBRetencionConcImpuOP.IMPO_MON_PAGO));
    retencionconcimpuop.setImpomonlocal(db.getMoney(DBRetencionConcImpuOP.IMPO_MON_LOC));
  }
}
