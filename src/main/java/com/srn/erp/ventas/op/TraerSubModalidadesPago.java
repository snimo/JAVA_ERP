package com.srn.erp.ventas.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.ventas.bm.SubModalidadPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSubModalidadesPago extends Operation {

  private int oid = 0;

  public TraerSubModalidadesPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Hashtable modalidades = SubModalidadPago.getModalidades();
    IDataSet datasetModalidad = getDataSetModalidad();
    Iterator iterModalidades = modalidades.keySet().iterator();
    while (iterModalidades.hasNext()) {
      String codigo = (String) iterModalidades.next();
      String descripcion = (String) modalidades.get(codigo);
      cargarRegistroModalidad(datasetModalidad,codigo,descripcion,new Boolean(true));
    }
    writeCliente(datasetModalidad);
  }

  private IDataSet getDataSetModalidad() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSubModalidadesPago");
    dataset.fieldDef(new Field("oid_sub_modalidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroModalidad(IDataSet dataset,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_sub_modalidad",++oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
