package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CertificacionProveedor;
import com.srn.erp.compras.da.DBCertificacionProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCertificacionProveedor extends FactoryObjetoLogico {

  public FactoryCertificacionProveedor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CertificacionProveedor certificacionproveedor = (CertificacionProveedor) objLog;
    certificacionproveedor.setOID(db.getInteger(DBCertificacionProveedor.OID_CERT_PROV));
    certificacionproveedor.setCodigo(db.getString(DBCertificacionProveedor.CODIGO));
    certificacionproveedor.setDescripcion(db.getString(DBCertificacionProveedor.DESCRIPCION));
    certificacionproveedor.setActivo(db.getBoolean(DBCertificacionProveedor.ACTIVO));
  }
}
