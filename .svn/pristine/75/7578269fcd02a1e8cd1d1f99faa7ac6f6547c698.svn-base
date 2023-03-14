package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.TipoArchivoExportacionReportes;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposArchExpReporte extends Operation {

  public TraerTiposArchExpReporte() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int oid = 0;
    IDataSet dataset = getDataSetTipo();
    HashTableDatos lista = TipoArchivoExportacionReportes.getTipos();
    Iterator iterLista = lista.keySet().iterator();
    while (iterLista.hasNext()) {
      String codigo      = (String) iterLista.next();
      String descripcion = (String) lista.get(codigo);
      cargarRegistroTipo(dataset,new Integer(++oid),codigo,descripcion);
    }
    writeCliente(dataset);
  }

  private IDataSet getDataSetTipo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposArchivos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroTipo(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
