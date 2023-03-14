package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.TipoValorFormaPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFormaPago extends Operation {

  public TraerFormaPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    FormaPago formapago = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       formapago = FormaPago.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       formapago = FormaPago.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetFormaPago = getDataSetFormaPago();
    IDataSet datasetFormaPagoTV = getDataSetFormaPagoTV();
    if (formapago != null) {
        cargarRegistroFormaPago(datasetFormaPago,
                         formapago.getOIDInteger(),
                         formapago.getCodigo(),
                         formapago.getDescripcion(),
                         formapago.isActivo());

        Iterator iterTiposValor = formapago.getTiposValores().iterator();
        while (iterTiposValor.hasNext()) {
          TipoValorFormaPago tipoValorFormaPago =
              (TipoValorFormaPago) iterTiposValor.next();
          cargarRegistroFormaPagoTV(datasetFormaPagoTV,
                                    tipoValorFormaPago.getOIDInteger(),
                                    formapago.getOIDInteger(),
                                    tipoValorFormaPago.getTipovalor().getOIDInteger(),
                                    tipoValorFormaPago.getTipovalor().getCodigo(),
                                    tipoValorFormaPago.getTipovalor().getDescripcion(),
                                    tipoValorFormaPago.getTipovalor().isActivo());
        }

    }
    writeCliente(datasetFormaPago);
    writeCliente(datasetFormaPagoTV);
  }

  private IDataSet getDataSetFormaPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFormaPago");
    dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetFormaPagoTV() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoValorFormaPago");
    dataset.fieldDef(new Field("oid_forma_pago_tv", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroFormaPago(IDataSet dataset,
                                       Integer oid_forma_pago,
                                       String codigo,
                                       String descripcion,
                                       Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_forma_pago", oid_forma_pago);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
    

  private void cargarRegistroFormaPagoTV(IDataSet dataset,
                                       Integer oid_forma_pago_tv,
                                       Integer oid_forma_pago,
                                       Integer oid_tipo_valor,
                                       String cod_tipo_valor,
                                       String desc_tipo_valor,
                                       Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_forma_pago_tv", oid_forma_pago_tv);
    dataset.fieldValue("oid_forma_pago",oid_forma_pago);
    dataset.fieldValue("oid_tipo_valor",oid_tipo_valor);
    dataset.fieldValue("cod_tipo_valor",cod_tipo_valor);
    dataset.fieldValue("desc_tipo_valor",desc_tipo_valor);
    dataset.fieldValue("activo", activo);
  }


}
