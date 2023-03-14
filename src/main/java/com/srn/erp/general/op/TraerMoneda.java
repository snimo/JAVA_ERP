package com.srn.erp.general.op;

import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMoneda extends Operation {

  public TraerMoneda() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Moneda moneda = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       moneda = Moneda.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       moneda = Moneda.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetMoneda = getDataSetMoneda();
    if (moneda != null) {
        cargarRegistroMoneda(datasetMoneda,
                         moneda.getOIDInteger(),
                         moneda.getCodigo(),
                         moneda.getDescripcion(),
                         new Double(moneda.getBase().doubleValue()),
                         moneda.isActivo(),
                         moneda.getSimbolo());
    }
    writeCliente(datasetMoneda);
  }

  private IDataSet getDataSetMoneda() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMoneda");
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 5));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("base", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("simbolo",Field.STRING, 5));
    return dataset;
  }

  private void cargarRegistroMoneda(IDataSet dataset,
                         Integer oid_moneda,
                         String codigo,
                         String descripcion,
                         Double base,
                         Boolean activo,
                         String simbolo) {
    dataset.append();
    dataset.fieldValue("oid_moneda", oid_moneda);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("base", base);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("simbolo", simbolo);
  }
  
}
