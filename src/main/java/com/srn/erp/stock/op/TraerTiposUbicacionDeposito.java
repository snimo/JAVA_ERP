package com.srn.erp.stock.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposUbicacionDeposito extends Operation {

  public TraerTiposUbicacionDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int oid = 0;
    IDataSet ds = getDataSetTiposUbicaciones();
    Hashtable tipos = UbicacionDeposito.getTiposUbicaciones();
    Iterator iterTipos =
        tipos.keySet().iterator();
    while (iterTipos.hasNext()) {
      String codigo = (String)iterTipos.next();
      String descripcion = (String)tipos.get(codigo);
      cargarRegistroTipos(ds,new Integer(++oid),codigo,descripcion);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSetTiposUbicaciones() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposUbicaciones");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTipos(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }


}
