package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.Impuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerImpuesto extends Operation {

  public TraerImpuesto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Impuesto impuesto = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       impuesto = Impuesto.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       impuesto = Impuesto.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetImpuesto = getDataSetImpuesto();

    if (impuesto != null) {
        cargarRegistroImpuesto(datasetImpuesto,
                         impuesto.getOIDInteger(),
                         impuesto.getCodigo(),
                         impuesto.getDescripcion(),
                         impuesto.getCompo(),
                         impuesto.isActivo(),
                         impuesto.isVentas(),
                         impuesto.isCompras()
                         );
    }
    writeCliente(datasetImpuesto);
  }

  private IDataSet getDataSetImpuesto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TImpuesto");
    dataset.fieldDef(new Field("oid_impuesto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ventas", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("compras", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroImpuesto(IDataSet dataset,
                         Integer oid_impuesto,
                         String codigo,
                         String descripcion,
                         String compo,
                         Boolean activo,
                         Boolean ventas,
                         Boolean compras) {
    dataset.append();
    dataset.fieldValue("oid_impuesto", oid_impuesto);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("ventas", ventas);
    dataset.fieldValue("compras", compras);
  }


}
