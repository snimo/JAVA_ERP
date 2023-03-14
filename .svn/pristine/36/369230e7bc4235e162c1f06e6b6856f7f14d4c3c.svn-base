package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CertificadoRetGanCab;
import com.srn.erp.pagos.bm.CertificadoRetGanDet;
import com.srn.erp.pagos.da.DBCertificadoRetGanDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCertificadoRetGanDet extends FactoryObjetoLogico {

  public FactoryCertificadoRetGanDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CertificadoRetGanDet certificadoretgandet = (CertificadoRetGanDet) objLog;
    certificadoretgandet.setOID(db.getInteger(DBCertificadoRetGanDet.OID_CCO_CERT_DET));
    certificadoretgandet.setConceptoimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCertificadoRetGanDet.OID_CONC_IMPU),getSesion()));
    certificadoretgandet.setMontonoimponible(db.getMoney(DBCertificadoRetGanDet.MONTO_NO_IMPO));
    certificadoretgandet.setCertificado(CertificadoRetGanCab.findByOidProxy(db.getInteger(DBCertificadoRetGanDet.OID_CCO_CERT),getSesion()));
    certificadoretgandet.setMontogravado(db.getMoney(DBCertificadoRetGanDet.MONTO_GRAVADO));
    certificadoretgandet.setPagoneto(db.getMoney(DBCertificadoRetGanDet.PAGO_NETO));
    certificadoretgandet.setPorcentaje(db.getMoney(DBCertificadoRetGanDet.PORC_RET));
    certificadoretgandet.setMontoretminima(db.getMoney(DBCertificadoRetGanDet.MONTO_RET_MIN));
    certificadoretgandet.setBasepararetener(db.getMoney(DBCertificadoRetGanDet.BASE_PARA_RETENER));
    certificadoretgandet.setPagoacum(db.getMoney(DBCertificadoRetGanDet.PAGO_ACUM));
    certificadoretgandet.setRetacum(db.getMoney(DBCertificadoRetGanDet.RET_ACUM));
    certificadoretgandet.setImpuestoretenido(db.getMoney(DBCertificadoRetGanDet.IMPUESTO_RETENIDO));
    certificadoretgandet.setMontofijo(db.getMoney(DBCertificadoRetGanDet.MONTO_FIJO));
  }
}
