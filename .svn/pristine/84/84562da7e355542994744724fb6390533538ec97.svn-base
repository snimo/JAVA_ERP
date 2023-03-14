package com.srn.erp.general.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComportamientosTipoDocu extends Operation {

  public TraerComportamientosTipoDocu() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int oid = 0;
    IDataSet dataset = getDataSetTipo();
    List lista = TipoDocumento.getComportamientos();
    Iterator iterComportamientos = lista.iterator();
    while (iterComportamientos.hasNext()) {
      String codigo = (String) iterComportamientos.next();
      cargarRegistro(dataset, 
      		           new Integer(++oid),
      		           codigo,
      		           codigo,
      		           new Boolean(true));
    }
    writeCliente(dataset);
  }

  private IDataSet getDataSetTipo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComporTipoDoc");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
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
