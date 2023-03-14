package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.EstadoCivil;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoCivil extends Operation {

  public TraerEstadoCivil() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    EstadoCivil estadocivil = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       estadocivil = EstadoCivil.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       estadocivil = EstadoCivil.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetEstadoCivil = getDataSetEstadoCivil();
    if (estadocivil != null) {
        cargarRegistroEstadoCivil(datasetEstadoCivil,
                         estadocivil.getOIDInteger(),
                         estadocivil.getCodigo(),
                         estadocivil.getDescripcion(),
                         estadocivil.isActivo());
    }
    writeCliente(datasetEstadoCivil);
  }

  private IDataSet getDataSetEstadoCivil() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstadoCivil");
    dataset.fieldDef(new Field("oid_estado_civil", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroEstadoCivil(IDataSet dataset,
                         Integer oid_estado_civil,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_estado_civil", oid_estado_civil);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
