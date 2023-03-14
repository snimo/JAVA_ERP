package com.srn.erp.general.op;

import com.srn.erp.general.bm.Idioma;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIdioma extends Operation {

  public TraerIdioma() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Idioma idioma = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       idioma = Idioma.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       idioma = Idioma.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetIdioma = getDataSetIdioma();
    if (idioma != null) {
        cargarRegistroIdioma(datasetIdioma,
                         idioma.getOIDInteger(),
                         idioma.getCodigo(),
                         idioma.getDescripcion(),
                         idioma.isActivo());
    }
    writeCliente(datasetIdioma);
  }

  private IDataSet getDataSetIdioma() {
    IDataSet dataset = new TDataSet();
    dataset.create("TIdioma");
    dataset.fieldDef(new Field("oid_idioma", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroIdioma(IDataSet dataset,
                         Integer oid_idioma,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_idioma", oid_idioma);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
