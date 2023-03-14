package com.srn.erp.tesoreria.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Caja;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoAperCierreCaja extends Operation {

  public TraerCompoAperCierreCaja() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Hashtable tipos = Caja.getTiposAperCierreCaja();

    IDataSet dsCompoCajas = getDataSetCaja();
    Iterator iterCompoCajas = tipos.keySet().iterator();
    while (iterCompoCajas.hasNext()) {
      String codigo = (String) iterCompoCajas.next();
      String descripcion = (String) tipos.get(codigo);
      cargarRegistroCompoCaja(dsCompoCajas,codigo,descripcion);
    }

    writeCliente(dsCompoCajas);

  }

  private IDataSet getDataSetCaja() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoAperCierreCaja");
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroCompoCaja(IDataSet dataset,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
