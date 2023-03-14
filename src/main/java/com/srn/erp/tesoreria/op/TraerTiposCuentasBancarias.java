package com.srn.erp.tesoreria.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposCuentasBancarias extends Operation {

  public TraerTiposCuentasBancarias() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Hashtable tiposCuentas = CuentaBancaria.getTiposCuentas();

    IDataSet ds = getDataSetCuentaBancaria();
    Iterator iterKeys = tiposCuentas.keySet().iterator();
    while (iterKeys.hasNext()) {
      String codigo = (String) iterKeys.next();
      String descripcion = (String) tiposCuentas.get(codigo);
      cargarRegistroTipoCuentaBancaria(ds,codigo,descripcion);
    }

    writeCliente(ds);

  }

  private IDataSet getDataSetCuentaBancaria() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoCuentaBancaria");
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING,10));
    return dataset;
  }

  private void cargarRegistroTipoCuentaBancaria(IDataSet dataset,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
