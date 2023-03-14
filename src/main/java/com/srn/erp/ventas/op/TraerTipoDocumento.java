package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoDocumento extends Operation {

  public TraerTipoDocumento() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoDocumento tipodocumento = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipodocumento = TipoDocumento.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipodocumento = TipoDocumento.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoDocumento = getDataSetTipoDocumento();
    if (tipodocumento != null) {
        cargarRegistroTipoDocumento(datasetTipoDocumento,
                         tipodocumento.getOIDInteger(),
                         tipodocumento.getCodigo(),
                         tipodocumento.getDescripcion(),
                         tipodocumento.isActivo(),
                         tipodocumento.getComportamieno(),
                         tipodocumento.getCodigoFE());
    }
    writeCliente(datasetTipoDocumento);
  }

  private IDataSet getDataSetTipoDocumento() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoDocumento");
    dataset.fieldDef(new Field("oid_tipo_documento", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_fe", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroTipoDocumento(IDataSet dataset,
                         Integer oid_tipo_documento,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         String comportamiento,
                         Integer codigoFE) {
    dataset.append();
    dataset.fieldValue("oid_tipo_documento", oid_tipo_documento);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("comportamiento", comportamiento);
    dataset.fieldValue("codigo_fe", codigoFE);
  }
}
