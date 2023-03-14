package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerModosImpresionTal extends Operation {

  public TraerModosImpresionTal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int oid = 0;
    IDataSet dataset = getDataSetTipo();
    HashTableDatos modosImpresion = Talonario.getModosImpresion();
    Iterator iterModosImpresion = modosImpresion.keySet().iterator();
    while (iterModosImpresion.hasNext()) {
      String codigo = (String) iterModosImpresion.next();
      cargarRegistroTipo(dataset,new Integer(++oid),
      		                           codigo,
      		                           modosImpresion.getString(codigo),
      		                           new Boolean(true));
    }
    writeCliente(dataset);
  }

  private IDataSet getDataSetTipo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TModosImpresionTal");
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
