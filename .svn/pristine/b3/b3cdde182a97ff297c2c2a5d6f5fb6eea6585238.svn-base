package com.srn.erp.pagos.op;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.pagos.bm.RetCabIB;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpRetCabIB extends Operation {

  public TraerHelpRetCabIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    String tableName = mapaDatos.getString("tableName");
    IDataSet dataset = getDataSetRetCabIB(tableName);
    List retenciones = RetCabIB.getAllRetIBCab(getSesion());
    Iterator iterRetIBCab = retenciones.iterator();
    while (iterRetIBCab.hasNext()) {
      RetCabIB retCabIB = (RetCabIB) iterRetIBCab.next();
      cargarRegistroRetCabIB(dataset,
                              retCabIB.getOIDInteger(),
                              retCabIB.getCatretIB().getDescripcion(),
                              retCabIB.getConcimpu().getDescripcion(),
                              retCabIB.getFecvigdesde(),
                              retCabIB.isActivo());
    }

    writeCliente(dataset);

  }

  private IDataSet getDataSetRetCabIB(String tableName) {
    IDataSet dataset = new TDataSet();
    dataset.create(tableName);
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("categoria", Field.STRING, 50));
    dataset.fieldDef(new Field("impuesto", Field.STRING, 50));
    dataset.fieldDef(new Field("fecha", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroRetCabIB(IDataSet dataset,
                         Integer oid,
                         String categoria,
                         String impuesto,
                         Date fecha ,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("categoria", categoria);
    dataset.fieldValue("impuesto", impuesto);
    dataset.fieldValue("fecha", Fecha.getddmmyyyy(fecha));
    dataset.fieldValue("activo", activo);

  }


}
