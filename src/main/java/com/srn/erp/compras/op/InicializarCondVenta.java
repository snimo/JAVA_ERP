package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondicionVenta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InicializarCondVenta extends Operation {

  public InicializarCondVenta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetUniCondComp = getDataSetUnidadesCondicionVenta();
    cargarRegistroUnidadesCondicionVenta(datasetUniCondComp,CondicionVenta.CODIGO_UNI_DIAS,CondicionVenta.DESC_UNI_DIAS);
    cargarRegistroUnidadesCondicionVenta(datasetUniCondComp,CondicionVenta.CODIGO_UNI_MESES,CondicionVenta.DESC_UNI_MESES);
    writeCliente(datasetUniCondComp);
  }

  private IDataSet getDataSetUnidadesCondicionVenta() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUnidadesCondicionVenta");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroUnidadesCondicionVenta(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
