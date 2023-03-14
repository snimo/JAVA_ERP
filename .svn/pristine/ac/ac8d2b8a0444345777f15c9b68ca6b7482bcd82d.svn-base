package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.PagoAcumRetGan;
import com.srn.erp.pagos.bm.PeriRetGan;
import com.srn.erp.pagos.da.DBPagoAcumRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPagoAcumRetGan extends FactoryObjetoLogico {

  public FactoryPagoAcumRetGan() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PagoAcumRetGan pagoacumretgan = (PagoAcumRetGan) objLog;
    pagoacumretgan.setOID(db.getInteger(DBPagoAcumRetGan.OID_PAGO_ACUM));
    pagoacumretgan.setSujetoimpositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBPagoAcumRetGan.OID_SUJ_IMP),getSesion()));
    pagoacumretgan.setPeriretgan(PeriRetGan.findByOidProxy(db.getInteger(DBPagoAcumRetGan.OID_PERI_RET_GAN),getSesion()));
    pagoacumretgan.setConcimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPagoAcumRetGan.OID_CONC_IMPU),getSesion()));
    pagoacumretgan.setPagoacum(db.getMoney(DBPagoAcumRetGan.IMPO_PAGO_ACUM));
    pagoacumretgan.setPagoretenido(db.getMoney(DBPagoAcumRetGan.IMPO_PAGO_RET));
    pagoacumretgan.setActivo(db.getBoolean(DBPagoAcumRetGan.ACTIVO));
  }
}
