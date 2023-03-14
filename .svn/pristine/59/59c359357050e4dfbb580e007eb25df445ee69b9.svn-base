package com.srn.erp.tesoreria.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoValorCompo extends Operation {

  public TraerTipoValorCompo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetTipoValorCompo = getDataSetTipoValorCompo();
    Hashtable comportamientos = TipoValor.getComportamientos();
    Iterator iterCodigosCompo = comportamientos.keySet().iterator();
    while (iterCodigosCompo.hasNext()) {
      String codigoCompo = (String) iterCodigosCompo.next();
      String descCompo = (String) comportamientos.get(codigoCompo);
      cargarRegistroTipoValorCompo(datasetTipoValorCompo,
                                   codigoCompo,
                                   descCompo);
    }
    writeCliente(datasetTipoValorCompo);
  }

  private IDataSet getDataSetTipoValorCompo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoValorCompo");
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroTipoValorCompo(IDataSet dataset,
                         String codigo,
                         String descripcion)
 {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
