package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CertificacionProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCertificacionProveedor extends Operation {

  public SaveCertificacionProveedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCertificacionProveedor");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CertificacionProveedor certificacionproveedor = CertificacionProveedor.findByOid(dataset.getInteger("oid_cert_prov"),getSesion());
        certificacionproveedor.setOID(dataset.getInteger("oid_cert_prov"));
        certificacionproveedor.setCodigo(dataset.getString("codigo"));
        certificacionproveedor.setDescripcion(dataset.getString("descripcion"));
        certificacionproveedor.setActivo(dataset.getBoolean("activo"));
        addTransaccion(certificacionproveedor);
        dataset.next();
    }
  }

}
