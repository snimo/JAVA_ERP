package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpProductos extends Operation {

  public TraerHelpProductos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetProductos = getDataSetProducto();
    traerProductos(datasetProductos,mapaDatos);
    writeCliente(datasetProductos);
  }

  private void traerProductos(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    HashTableDatos condiciones = new HashTableDatos();

    if (mapaDatos.containsKey("codigo"))
      condiciones.put("codigo",mapaDatos.getString("codigo"));

    if (mapaDatos.containsKey("descripcion"))
      condiciones.put("descripcion",mapaDatos.getString("descripcion"));

    if (mapaDatos.containsKey("vendible"))
      condiciones.put("vendible","vendible");

    if (mapaDatos.containsKey("stockeable"))
      condiciones.put("stockeable","stockeable");
    
    if (mapaDatos.containsKey("producible"))
        condiciones.put("producible","producible");    
    
    if (mapaDatos.containsKey("comprable"))
        condiciones.put("comprable","comprable");
    
    if (mapaDatos.containsKey("nd_int"))
      condiciones.put("nd_int","nd_int");    
    
    if (mapaDatos.containsKey("nc_int"))
      condiciones.put("nc_int","nc_int");    

    Iterator iterProductos =
        Producto.getHelpProductos(condiciones,getSesion()).iterator();
    while (iterProductos.hasNext()) {
      Producto producto = (Producto) iterProductos.next();
      cargarRegistroProducto(dataSet,
                             producto.getOIDInteger(),
                             producto.getCodigo(),
                             producto.getDescripcion(),
                             producto.isActivo());
    }

  }

  private IDataSet getDataSetProducto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProductos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 80));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroProducto(IDataSet dataset,
                                       Integer oid,
                                       String codigo,
                                       String descripcion,
                                       Boolean activo) throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo",activo);
  }

}
