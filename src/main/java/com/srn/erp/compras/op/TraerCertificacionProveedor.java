package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CertificacionProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCertificacionProveedor extends Operation {

  public TraerCertificacionProveedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CertificacionProveedor certificacionproveedor = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       certificacionproveedor = CertificacionProveedor.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       certificacionproveedor = CertificacionProveedor.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCertificacionProveedor = getDataSetCertificacionProveedor();
    if (certificacionproveedor != null) {
        cargarRegistroCertificacionProveedor(datasetCertificacionProveedor,
                         certificacionproveedor.getOIDInteger(),
                         certificacionproveedor.getCodigo(),
                         certificacionproveedor.getDescripcion(),
                         certificacionproveedor.isActivo());
    }
    writeCliente(datasetCertificacionProveedor);
  }

  private IDataSet getDataSetCertificacionProveedor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCertificacionProveedor");
    dataset.fieldDef(new Field("oid_cert_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCertificacionProveedor(IDataSet dataset,
                         Integer oid_cert_prov,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cert_prov", oid_cert_prov);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
