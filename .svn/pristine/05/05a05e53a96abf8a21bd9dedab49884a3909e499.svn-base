package com.srn.erp.general.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.general.bm.TiposNumeracionComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposNumeracionTC extends Operation {

  public TraerTiposNumeracionTC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet datasetTipoNumeracionTC = getDataSetCompoTC();

    TiposNumeracionComprobante tiposNumeracionComprobante =
        new TiposNumeracionComprobante();
    Hashtable hsListaTiposNumeracion =
        tiposNumeracionComprobante.getListaTiposNumeracion();

    Iterator iterListaTipos = hsListaTiposNumeracion.keySet().iterator();
    while (iterListaTipos.hasNext()) {
      String tipo_numeracion = (String)iterListaTipos.next();
      String descripcion = (String)hsListaTiposNumeracion.get(tipo_numeracion);
      cargarTipoNumeracionTC(datasetTipoNumeracionTC,tipo_numeracion,descripcion);
    }

    writeCliente(datasetTipoNumeracionTC);
  }

  private IDataSet getDataSetCompoTC() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposNumeracionTC");
    dataset.fieldDef(new Field("tipo_numeracion", Field.STRING, 5));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarTipoNumeracionTC(IDataSet dataset,
                         String tipo_numeracion,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("tipo_numeracion", tipo_numeracion);
    dataset.fieldValue("descripcion", descripcion);
  }
}
