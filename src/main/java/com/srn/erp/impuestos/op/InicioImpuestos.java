package com.srn.erp.impuestos.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.impuestos.bm.Impuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InicioImpuestos extends Operation {

  public InicioImpuestos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetCompoImpu = getDataSetCompoImpuesto();
    Hashtable listaCompo = Impuesto.getListaComportamiento();
    Iterator iterCompoImpu = listaCompo.keySet().iterator();
    while (iterCompoImpu.hasNext()) {
      String codigoCompo = (String) iterCompoImpu.next();
      String descCompo = (String)listaCompo.get(codigoCompo);
      cargarCompoImpuesto(datasetCompoImpu,codigoCompo,descCompo);
    }
    writeCliente(datasetCompoImpu);
  }

  private IDataSet getDataSetCompoImpuesto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoImpu");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarCompoImpuesto(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }




}
