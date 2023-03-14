package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.SubsistemasContables;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSubsistemasContables extends Operation {

  public TraerSubsistemasContables() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int oid = 0;
    IDataSet dsSubSistCont = getDataSetSubSistContables();
    SubsistemasContables subsistemas = new SubsistemasContables();
    Iterator iterSubsistemas =
        subsistemas.getSubsistemas().keySet().iterator();
    while (iterSubsistemas.hasNext()) {
      String codigo = (String) iterSubsistemas.next();
      String descripcion = (String) subsistemas.getSubsistemas().get(codigo);
      cargarSubsistemaContable(dsSubSistCont,new Integer(++oid),codigo,descripcion);
    }
    writeCliente(dsSubSistCont);
  }

  private IDataSet getDataSetSubSistContables() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSubsistemasContables");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("subsistema", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING,100));
    return dataset;
  }

  private void cargarSubsistemaContable(IDataSet dataset,
                         Integer oid,
                         String subsistema,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("subsistema", subsistema);
    dataset.fieldValue("descripcion", descripcion);
  }

}
