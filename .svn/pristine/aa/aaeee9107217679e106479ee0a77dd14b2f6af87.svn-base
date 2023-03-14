package com.srn.erp.pagos.op;

import com.srn.erp.compras.bm.Proveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFormaPagoDefaultProv extends Operation {

  public TraerFormaPagoDefaultProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataSetFormaPago = getDataSetFormaPago();
    Integer oidProveedor = mapaDatos.getInteger("oid_proveedor");
    Proveedor proveedor = Proveedor.findByOid(oidProveedor,getSesion());
    if (proveedor.getFormaPago()!=null) {
      cargarRegistroFormaPago(
         dataSetFormaPago,
         proveedor.getFormaPago().getOIDInteger(),
         proveedor.getFormaPago().getCodigo(),
         proveedor.getFormaPago().getDescripcion());
    }

    writeCliente(dataSetFormaPago);
  }

  private IDataSet getDataSetFormaPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFormaPagoDefaultProv");
    dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroFormaPago(IDataSet dataset,
                                       Integer oid_forma_pago,
                                       String codigo,
                                       String descripcion) {
    dataset.append();
    dataset.fieldValue("oid_forma_pago", oid_forma_pago);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }


}
