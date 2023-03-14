package com.srn.erp.stock.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.stock.bm.Deposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComportamientosDeposito extends Operation {

  public TraerComportamientosDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int oid = 0;
    IDataSet ds = getDataSetComportamientos();
    Hashtable hashCompo = Deposito.getComportamienos();
    Iterator iterCompo = Deposito.getComportamienos().keySet().iterator();
    while (iterCompo.hasNext()) {
      String codigo = (String) iterCompo.next();
      String descripcion = (String) hashCompo.get(codigo);
      cargarRegistroCompo(ds,new Integer(++oid),codigo,descripcion);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSetComportamientos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientosDeposito");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroCompo(IDataSet dataset,
                                   Integer oid,
                                   String codigo,
                                   String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }


}
