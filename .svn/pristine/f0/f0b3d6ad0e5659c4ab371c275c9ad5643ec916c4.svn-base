package com.srn.erp.general.op;

import com.srn.erp.general.bm.Zona;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerZona extends Operation {

  public TraerZona() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Zona zona = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       zona = Zona.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       zona = Zona.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetZona = getDataSetZona();
    if (zona != null) {
        cargarRegistroZona(datasetZona,
                         zona.getOIDInteger(),
                         zona.getCodigo(),
                         zona.getDescripcion(),
                         zona.isActivo());
    }
    writeCliente(datasetZona);
  }

  private IDataSet getDataSetZona() {
    IDataSet dataset = new TDataSet();
    dataset.create("TZona");
    dataset.fieldDef(new Field("oid_zona", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroZona(IDataSet dataset,
                         Integer oid_zona,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_zona", oid_zona);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
