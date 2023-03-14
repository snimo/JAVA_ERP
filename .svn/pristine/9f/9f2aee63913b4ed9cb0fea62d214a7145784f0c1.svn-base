package com.srn.erp.tesoreria.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoValorByFormaPago extends Operation {

  public TraerTipoValorByFormaPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    FormaPago formaPago =
        FormaPago.findByOid(mapaDatos.getInteger("oid_forma_pago"),getSesion());

    IDataSet datasetTipoValor = getDataSetTipoValor();
    List tiposValores =
        TipoValor.getTiposValorByFormaPago(formaPago,getSesion());
    Iterator iterTiposValores = tiposValores.iterator();
    while (iterTiposValores.hasNext()) {
      TipoValor tipovalor = (TipoValor) iterTiposValores.next();
      cargarRegistroTipoValor(datasetTipoValor,
                       tipovalor.getOIDInteger(),
                       tipovalor.getCodigo(),
                       tipovalor.getDescripcion(),
                       tipovalor.getCompo(),
                       tipovalor.getMoneda(),
                       tipovalor.isActivo());

    }

    writeCliente(datasetTipoValor);

  }

  private IDataSet getDataSetTipoValor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoValorFormaPago");
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_moneda", Field.STRING, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoValor(IDataSet dataset,
                         Integer oid_tipo_valor,
                         String codigo,
                         String descripcion,
                         String compo,
                         Moneda moneda,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tipo_valor", oid_tipo_valor);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("oid_moneda", moneda.getOID());
    dataset.fieldValue("activo", activo);
  }
}
