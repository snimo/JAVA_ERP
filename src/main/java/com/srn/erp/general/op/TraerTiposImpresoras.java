package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.TipoImpresora;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposImpresoras extends Operation {

  public TraerTiposImpresoras() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataSet();
    int oid = 0;
    Iterator iterTipos = TipoImpresora.getTipos().iterator();
    while (iterTipos.hasNext()) {
      String codigo = (String) iterTipos.next();
      cargarDataSet(ds,new Integer(++oid),codigo,codigo);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoImpresora");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarDataSet(IDataSet dataset,
                             Integer oid,
                             String codigo,
                             String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
