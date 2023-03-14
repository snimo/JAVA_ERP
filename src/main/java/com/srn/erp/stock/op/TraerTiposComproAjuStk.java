package com.srn.erp.stock.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.stock.bm.ComproAjusteStk;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposComproAjuStk extends Operation {

  public TraerTiposComproAjuStk() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataAjusteStk();
    int oid = 0;
    Hashtable tipos = ComproAjusteStk.getAllTipos();
    Iterator iterKeys = tipos.keySet().iterator();
    while (iterKeys.hasNext()) {
      String codigo = (String) iterKeys.next();
      String descripcion = (String) tipos.get(codigo);
      cargarRegistroTipoRto(ds,new Integer(++oid),codigo,descripcion,new Boolean(true));
    }
    writeCliente(ds);
  }

  private IDataSet getDataAjusteStk() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoAjusteStock");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoRto(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
