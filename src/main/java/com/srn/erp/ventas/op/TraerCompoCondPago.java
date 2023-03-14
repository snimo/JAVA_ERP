package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.CondicionPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoCondPago extends Operation {

  public TraerCompoCondPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataSetCompo();
    int oid = 0;
    Iterator iterCodigos =
        CondicionPago.getComportamientos().keySet().iterator();
    while (iterCodigos.hasNext()) {
      String codigo = (String) iterCodigos.next();
      String descripcion = (String) CondicionPago.getComportamientos().get(codigo);
      cargarCompo(ds,new Integer(++oid),codigo,descripcion);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSetCompo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoCondPago");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarCompo(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
