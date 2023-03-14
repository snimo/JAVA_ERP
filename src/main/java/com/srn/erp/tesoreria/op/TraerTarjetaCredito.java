package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.TarjetaCredito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTarjetaCredito extends Operation {

  public TraerTarjetaCredito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TarjetaCredito tarjetacredito = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tarjetacredito = TarjetaCredito.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tarjetacredito = TarjetaCredito.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTarjetaCredito = getDataSetTarjetaCredito();
    if (tarjetacredito != null) {
        cargarRegistroTarjetaCredito(datasetTarjetaCredito,
                         tarjetacredito.getOIDInteger(),
                         tarjetacredito.getCodigo(),
                         tarjetacredito.getDescripcion(),
                         tarjetacredito.isActivo());
    }
    writeCliente(datasetTarjetaCredito);
  }

  private IDataSet getDataSetTarjetaCredito() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTarjetaCredito");
    dataset.fieldDef(new Field("oid_tar_credito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTarjetaCredito(IDataSet dataset,
                         Integer oid_tar_credito,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tar_credito", oid_tar_credito);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
