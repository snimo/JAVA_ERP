package com.srn.erp.ventas.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.ventas.bm.DevolucionVtasCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposDevClientes extends Operation {

  public TraerTiposDevClientes() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataTipo();
    int oid = 0;
    Hashtable tipos = DevolucionVtasCab.getTiposDevoluciones();
    Iterator iterKeys = tipos.keySet().iterator();
    while (iterKeys.hasNext()) {
      String codigo = (String) iterKeys.next();
      String descripcion = (String) tipos.get(codigo);
      cargarRegistroTipo(ds,new Integer(++oid),codigo,descripcion,new Boolean(true));
    }
    writeCliente(ds);
  }

  private IDataSet getDataTipo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoDevOper");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipo(IDataSet dataset,
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
