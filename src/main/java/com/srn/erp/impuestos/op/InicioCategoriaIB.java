package com.srn.erp.impuestos.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.impuestos.bm.CategoriaIB;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InicioCategoriaIB extends Operation {

  public InicioCategoriaIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetCompoCategoriaIB = getDataSetCompoCategoriaIB();
    Hashtable listaCompo = CategoriaIB.getListaComportamientos();
    Iterator iterCompo = listaCompo.keySet().iterator();
    while (iterCompo.hasNext()) {
      String codigoCompo = (String) iterCompo.next();
      cargarRegistroCategoriaIB(datasetCompoCategoriaIB,
                                 codigoCompo,
                                 (String)listaCompo.get(codigoCompo));
    }
    writeCliente(datasetCompoCategoriaIB);
  }

  private IDataSet getDataSetCompoCategoriaIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoCatIB");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroCategoriaIB(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
