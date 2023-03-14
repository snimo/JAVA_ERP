package com.srn.erp.general.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.general.bm.IdentificacionTipoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComportamientosTC extends Operation {

  public TraerComportamientosTC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetCompoTC = getDataSetCompoTC();

    IdentificacionTipoComprobante idenTC = new IdentificacionTipoComprobante();
    Hashtable hsListaCompo = idenTC.getListaComportamientosCompro();

    Iterator iterListaCompo = hsListaCompo.keySet().iterator();
    while (iterListaCompo.hasNext()) {
      String identificacion = (String)iterListaCompo.next();
      String descripcion = (String)hsListaCompo.get(identificacion);
      cargarComportamientoTC(datasetCompoTC,identificacion,descripcion);
    }

    writeCliente(datasetCompoTC);
  }

  private IDataSet getDataSetCompoTC() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoTC");
    dataset.fieldDef(new Field("identificacion", Field.STRING, 5));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarComportamientoTC(IDataSet dataset,
                         String identificacion,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("identificacion", identificacion);
    dataset.fieldValue("descripcion", descripcion);
  }
}
