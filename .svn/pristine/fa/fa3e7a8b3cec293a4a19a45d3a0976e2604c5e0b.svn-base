package com.srn.erp.impuestos.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.impuestos.bm.CategoriaGanancia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InicioCategoriaGanancias extends Operation {

  public InicioCategoriaGanancias() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetCompoCategoriaGan = getDataSetCompoCategoriaGan();
    Hashtable listaCompo = CategoriaGanancia.getListaComportamientos();
    Iterator iterCompo = listaCompo.keySet().iterator();
    while (iterCompo.hasNext()) {
      String codigoCompo = (String) iterCompo.next();
      cargarRegistroCategoriaGan(datasetCompoCategoriaGan,
                                 codigoCompo,
                                 (String)listaCompo.get(codigoCompo));
    }
    writeCliente(datasetCompoCategoriaGan);
  }

  private IDataSet getDataSetCompoCategoriaGan() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoCatGan");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroCategoriaGan(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
