package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.bm.CertificadoRetIBCab;
import com.srn.erp.pagos.bm.PeriRetIB;
import com.srn.erp.pagos.da.DBCertificadoRetIBCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCertificadoRetIBCab extends FactoryObjetoLogico {

  public FactoryCertificadoRetIBCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CertificadoRetIBCab certificadoretibcab = (CertificadoRetIBCab) objLog;
    certificadoretibcab.setOID(db.getInteger(DBCertificadoRetIBCab.OID_CCO));
    certificadoretibcab.setOrdenpago(ComproCab.findByOidProxyCompro(db.getInteger(DBCertificadoRetIBCab.OID_CCO_OP),getSesion()));
    certificadoretibcab.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBCertificadoRetIBCab.OID_PROVEEDOR),getSesion()));
    certificadoretibcab.setPeriretib(PeriRetIB.findByOidProxy(db.getInteger(DBCertificadoRetIBCab.OID_PERI_RET_IB),getSesion()));
    certificadoretibcab.setCatretib(CatRetIB.findByOidProxy(db.getInteger(DBCertificadoRetIBCab.OID_CAT_RET_IB),getSesion()));
    certificadoretibcab.setPorclib(db.getMoney(DBCertificadoRetIBCab.PORC_LIB));
    certificadoretibcab.setDecreto(db.getString(DBCertificadoRetIBCab.DECRETO));
  }
}
