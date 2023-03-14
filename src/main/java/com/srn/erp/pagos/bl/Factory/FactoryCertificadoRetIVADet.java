package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CertificadoRetIVADet;
import com.srn.erp.pagos.da.DBCertificadoRetIVADet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCertificadoRetIVADet extends FactoryObjetoLogico {

  public FactoryCertificadoRetIVADet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CertificadoRetIVADet certificadoretivadet = (CertificadoRetIVADet) objLog;
    certificadoretivadet.setOID(db.getInteger(DBCertificadoRetIVADet.OID_CCO_CERT_DET));
    certificadoretivadet.setCertificado(ComproCab.findByOidProxyCompro(db.getInteger(DBCertificadoRetIVADet.OID_CCO_CERT),getSesion()));
    certificadoretivadet.setMontonoimponible(db.getMoney(DBCertificadoRetIVADet.MONTO_NO_IMPO));
    certificadoretivadet.setMontogravado(db.getMoney(DBCertificadoRetIVADet.MONTO_GRAVADO));
    certificadoretivadet.setPagoneto(db.getMoney(DBCertificadoRetIVADet.PAGO_NETO));
    certificadoretivadet.setPorcret(db.getMoney(DBCertificadoRetIVADet.PORC_RET));
    certificadoretivadet.setMontoretmin(db.getMoney(DBCertificadoRetIVADet.MONTO_RET_MIN));
    certificadoretivadet.setBasepararetener(db.getMoney(DBCertificadoRetIVADet.BASE_PARA_RETENER));
    certificadoretivadet.setPagoacum(db.getMoney(DBCertificadoRetIVADet.PAGO_ACUM));
    certificadoretivadet.setRetacum(db.getMoney(DBCertificadoRetIVADet.RET_ACUM));
    certificadoretivadet.setImpuestoretenido(db.getMoney(DBCertificadoRetIVADet.IMPUESTO_RETENIDO));
    certificadoretivadet.setConceptoimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCertificadoRetIVADet.OID_CONC_IMPU),getSesion()));
    certificadoretivadet.setComproproveedorBase(ComproProveedorBase.findByOidProxy(db.getInteger(DBCertificadoRetIVADet.OID_CCO_PROV),getSesion()));
    certificadoretivadet.setMontofijo(db.getMoney(DBCertificadoRetIVADet.MONTO_FIJO));
  }
}
