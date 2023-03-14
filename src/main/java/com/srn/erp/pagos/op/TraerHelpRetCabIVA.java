package com.srn.erp.pagos.op;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.pagos.bm.RetCabIVA;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpRetCabIVA extends Operation {

  public TraerHelpRetCabIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    String tableName = mapaDatos.getString("tableName");
    IDataSet dataset = getDataSetRetCabIVA(tableName);
    List retenciones = RetCabIVA.getAllRetIVACab(getSesion());
    Iterator iterRetIVACab = retenciones.iterator();
    while (iterRetIVACab.hasNext()) {
      RetCabIVA retCabIVA = (RetCabIVA) iterRetIVACab.next();
      cargarRegistroRetCabIVA(dataset,
                              retCabIVA.getOIDInteger(),
                              retCabIVA.getCatretiva().getDescripcion(),
                              retCabIVA.getConcimpu().getDescripcion(),
                              retCabIVA.getFecvigdesde(),
                              retCabIVA.isActivo());
    }

    writeCliente(dataset);

  }

  private IDataSet getDataSetRetCabIVA(String tableName) {
    IDataSet dataset = new TDataSet();
    dataset.create(tableName);
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("categoria", Field.STRING, 50));
    dataset.fieldDef(new Field("impuesto", Field.STRING, 50));
    dataset.fieldDef(new Field("fecha", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroRetCabIVA(IDataSet dataset,
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
