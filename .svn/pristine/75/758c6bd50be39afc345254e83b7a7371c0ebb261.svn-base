package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondicionCompra;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InicializarCondCompra extends Operation {

  public InicializarCondCompra() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetUniCondComp = getDataSetUnidadesCondicionCompra();
    cargarRegistroUnidadesCondicionCompra(datasetUniCondComp,CondicionCompra.CODIGO_UNI_DIAS,CondicionCompra.DESC_UNI_DIAS);
    cargarRegistroUnidadesCondicionCompra(datasetUniCondComp,CondicionCompra.CODIGO_UNI_MESES,CondicionCompra.DESC_UNI_MESES);
    writeCliente(datasetUniCondComp);
  }

  private IDataSet getDataSetUnidadesCondicionCompra() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUnidadesCondicionCompra");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroUnidadesCondicionCompra(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
