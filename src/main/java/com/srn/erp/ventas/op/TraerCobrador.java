package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Cobrador;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCobrador extends Operation {

  public TraerCobrador() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Cobrador cobrador = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       cobrador = Cobrador.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       cobrador = Cobrador.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCobrador = getDataSetCobrador();
    if (cobrador != null) {
        cargarRegistroCobrador(datasetCobrador,
                         cobrador.getOIDInteger(),
                         cobrador.getCodigo(),
                         cobrador.getApellido(),
                         cobrador.getNombre(),
                         cobrador.isActivo());
    }
    writeCliente(datasetCobrador);
  }

  private IDataSet getDataSetCobrador() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCobrador");
    dataset.fieldDef(new Field("oid_cobrador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("apellido", Field.STRING, 20));
    dataset.fieldDef(new Field("nombre", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCobrador(IDataSet dataset,
                         Integer oid_cobrador,
                         String codigo,
                         String apellido,
                         String nombre,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cobrador", oid_cobrador);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("apellido", apellido);
    dataset.fieldValue("nombre", nombre);
    dataset.fieldValue("activo", activo);
  }
}
