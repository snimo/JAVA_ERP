package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Rubro;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRubro extends Operation {

  public TraerRubro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Rubro rubro = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       rubro = Rubro.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       rubro = Rubro.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetRubro = getDataSetRubro();
    if (rubro != null) {
        cargarRegistroRubro(datasetRubro,
                         rubro.getOIDInteger(),
                         rubro.getCodigo(),
                         rubro.getDescripcion(),
                         rubro.isActivo());
    }
    writeCliente(datasetRubro);
  }

  private IDataSet getDataSetRubro() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRubro");
    dataset.fieldDef(new Field("oid_rubro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroRubro(IDataSet dataset,
                         Integer oid_rubro,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_rubro", oid_rubro);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
