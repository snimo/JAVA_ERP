package com.srn.erp.pagos.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.pagos.bm.MotivoPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoMotivosPago extends Operation {

  public TraerCompoMotivosPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet datasetCompoMotivoPago = getDataSetMotivoPago();

    Hashtable comportamientos = MotivoPago.getComportamientos();
    Iterator iterCompo = comportamientos.keySet().iterator();
    while (iterCompo.hasNext()) {
      String codigo = (String) iterCompo.next();
      String descripcion = (String) comportamientos.get(codigo);
      cargarRegistroCompoMotivoPago(datasetCompoMotivoPago,codigo,descripcion);
    }

    writeCliente(datasetCompoMotivoPago);
  }

  private IDataSet getDataSetMotivoPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoMotivosPago");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroCompoMotivoPago(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
