package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUnidadMedida extends Operation {

  public TraerUnidadMedida() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    UnidadMedida unidadmedida = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       unidadmedida = UnidadMedida.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       unidadmedida = UnidadMedida.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetUnidadMedida = getDataSetUnidadMedida();
    if (unidadmedida != null) {
        cargarRegistroUnidadMedida(datasetUnidadMedida,
                         unidadmedida.getOIDInteger(),
                         unidadmedida.getCodigo(),
                         unidadmedida.getDescripcion(),
                         unidadmedida.isActivo(),
                         unidadmedida.getLabelImpresion()
                         );
    }
    writeCliente(datasetUnidadMedida);
  }

  private IDataSet getDataSetUnidadMedida() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUnidadMedida");
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("etiqueta_impresion", Field.STRING, 20));
    return dataset;
  }

  private void cargarRegistroUnidadMedida(IDataSet dataset,
                         Integer oid_um,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         String etiquetaImpresion) {
    dataset.append();
    dataset.fieldValue("oid_um", oid_um);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("etiqueta_impresion", etiquetaImpresion);
  }
}
