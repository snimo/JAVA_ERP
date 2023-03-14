package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.TipoProducto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCompoProducto extends Operation {

  public TraerTipoCompoProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetCompoTipoProducto = getDataSetTipoCompoProducto();
    cargarRegistroCompoTipoProducto(datasetCompoTipoProducto,TipoProducto.COD_MP,TipoProducto.DESC_MP);
    cargarRegistroCompoTipoProducto(datasetCompoTipoProducto,TipoProducto.COD_PT,TipoProducto.DESC_PT);
    cargarRegistroCompoTipoProducto(datasetCompoTipoProducto,TipoProducto.COD_SE,TipoProducto.DESC_SE);
    cargarRegistroCompoTipoProducto(datasetCompoTipoProducto,TipoProducto.COD_SV,TipoProducto.DESC_SV);
    writeCliente(datasetCompoTipoProducto);
  }

  private IDataSet getDataSetTipoCompoProducto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoCompoProducto");
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroCompoTipoProducto(IDataSet dataset,
                                               String codigo,
                                               String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }

}
