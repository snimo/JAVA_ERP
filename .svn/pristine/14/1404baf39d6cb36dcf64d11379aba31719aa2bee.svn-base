package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.pagos.bm.CatRetIVA;
import com.srn.erp.pagos.bm.CertificadoRetIVACab;
import com.srn.erp.pagos.bm.PeriRetIVA;
import com.srn.erp.pagos.da.DBCertificadoRetIVACab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCertificadoRetIVACab extends FactoryObjetoLogico {

  public FactoryCertificadoRetIVACab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CertificadoRetIVACab certificadoretivacab = (CertificadoRetIVACab) objLog;
    certificadoretivacab.setOID(db.getInteger(DBCertificadoRetIVACab.OID_CCO));
    certificadoretivacab.setOrdenpago(ComproCab.findByOidProxyCompro(db.getInteger(DBCertificadoRetIVACab.OID_CCO_OP),getSesion()));
    certificadoretivacab.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBCertificadoRetIVACab.OID_PROVEEDOR),getSesion()));
    certificadoretivacab.setPeriretiva(PeriRetIVA.findByOidProxy(db.getInteger(DBCertificadoRetIVACab.OID_PERI_RET_IVA),getSesion()));
    certificadoretivacab.setCatretiva(CatRetIVA.findByOidProxy(db.getInteger(DBCertificadoRetIVACab.OID_CAT_RET_IVA),getSesion()));
    certificadoretivacab.setPorclib(db.getMoney(DBCertificadoRetIVACab.PORC_LIB));
    certificadoretivacab.setDecreto(db.getString(DBCertificadoRetIVACab.DECRETO));
  }
}
