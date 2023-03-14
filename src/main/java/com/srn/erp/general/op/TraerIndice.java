package com.srn.erp.general.op;

import com.srn.erp.general.bm.Indice;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIndice extends Operation {

  public TraerIndice() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Indice indice = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       indice = Indice.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       indice = Indice.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetIndice = getDataSetIndice();
    if (indice != null) {
        cargarRegistroIndice(datasetIndice,
                         indice.getOIDInteger(),
                         indice.getCodigo(),
                         indice.getDescripcion(),
                         indice.isActivo());
    }
    writeCliente(datasetIndice);
  }

  private IDataSet getDataSetIndice() {
    IDataSet dataset = new TDataSet();
    dataset.create("TIndice");
    dataset.fieldDef(new Field("oid_indice", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroIndice(IDataSet dataset,
                         Integer oid_indice,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_indice", oid_indice);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
