package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpProveedores extends Operation {

  public TraerHelpProveedores() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet datasetProveedor = getDataSetProveedor();
    traerProveedores(datasetProveedor,mapaDatos);
    writeCliente(datasetProveedor);
  }

  private void traerProveedores(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    HashTableDatos condiciones = new HashTableDatos();

    if (mapaDatos.containsKey("codigo"))
      condiciones.put("codigo",mapaDatos.getString("codigo"));

    if (mapaDatos.containsKey("razon_social"))
      condiciones.put("razon_social",mapaDatos.getString("razon_social"));

    if (mapaDatos.containsKey("cuit"))
      condiciones.put("cuit",mapaDatos.getString("cuit"));

    Iterator iterProveedores =
        Proveedor.getHelpProveedores(condiciones,getSesion()).iterator();
    while (iterProveedores.hasNext()) {
      Proveedor proveedor = (Proveedor) iterProveedores.next();
      cargarRegistroProveedor(dataSet,
                              proveedor.getOIDInteger(),
                              proveedor.getCodigo(),
                              proveedor.getRazonsocial(),
                              proveedor.getSujetoimpositivo(),
                              proveedor.isActivo());
    }

  }

  private IDataSet getDataSetProveedor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProveedores");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 50));
    dataset.fieldDef(new Field("cuit", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroProveedor(IDataSet dataset,
                                       Integer oid,
                                       String codigo,
                                       String descripcion,
                                       SujetoImpositivo sujetoImpositivo,
                                       Boolean activo) throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("razon_social", descripcion);
    if (sujetoImpositivo!=null)
      dataset.fieldValue("cuit",sujetoImpositivo.getCuit());
    else
      dataset.fieldValue("cuit","");
    dataset.fieldValue("activo", activo);
  }

}
