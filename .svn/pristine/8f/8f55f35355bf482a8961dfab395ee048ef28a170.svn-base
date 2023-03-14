package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CertificadoRetIBDet;
import com.srn.erp.pagos.da.DBCertificadoRetIBDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCertificadoRetIBDet extends FactoryObjetoLogico {

  public FactoryCertificadoRetIBDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CertificadoRetIBDet certificadoretibdet = (CertificadoRetIBDet) objLog;
    certificadoretibdet.setOID(db.getInteger(DBCertificadoRetIBDet.OID_CCO_CERT_DET));
    certificadoretibdet.setCertificado(ComproCab.findByOidProxyCompro(db.getInteger(DBCertificadoRetIBDet.OID_CCO_CERT),getSesion()));
    certificadoretibdet.setMontonoimponible(db.getMoney(DBCertificadoRetIBDet.MONTO_NO_IMPO));
    certificadoretibdet.setMontogravado(db.getMoney(DBCertificadoRetIBDet.MONTO_GRAVADO));
    certificadoretibdet.setPagoneto(db.getMoney(DBCertificadoRetIBDet.PAGO_NETO));
    certificadoretibdet.setPorcret(db.getMoney(DBCertificadoRetIBDet.PORC_RET));
    certificadoretibdet.setMontoretmin(db.getMoney(DBCertificadoRetIBDet.MONTO_RET_MIN));
    certificadoretibdet.setBasepararetener(db.getMoney(DBCertificadoRetIBDet.BASE_PARA_RETENER));
    certificadoretibdet.setPagoacum(db.getMoney(DBCertificadoRetIBDet.PAGO_ACUM));
    certificadoretibdet.setRetacum(db.getMoney(DBCertificadoRetIBDet.RET_ACUM));
    certificadoretibdet.setImpuestoretenido(db.getMoney(DBCertificadoRetIBDet.IMPUESTO_RETENIDO));
    certificadoretibdet.setConceptoimpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCertificadoRetIBDet.OID_CONC_IMPU),getSesion()));
    certificadoretibdet.setComproproveedor(ComproProveedorBase.findByOidProxy(db.getInteger(DBCertificadoRetIBDet.OID_CCO_PROV),getSesion()));
    certificadoretibdet.setMontofijo(db.getMoney(DBCertificadoRetIBDet.MONTO_FIJO));

  }
}
