package com.srn.erp.ventas.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.ventas.bm.EstadoSituacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoEstadoSituacion extends Operation {

  public TraerCompoEstadoSituacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = getDataSetComportamientos();
    Hashtable comportamientos = EstadoSituacion.getComportamientos();
    Iterator iterCompo = comportamientos.keySet().iterator();
    while (iterCompo.hasNext()) {
      String codigo =
          (String) iterCompo.next();
      cargarComportamientos(ds,codigo,(String)comportamientos.get(codigo));
    }
    writeCliente(ds);
  }

  private IDataSet getDataSetComportamientos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoEstadosSituacion");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarComportamientos(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
