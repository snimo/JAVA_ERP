package com.srn.erp.pagos.op;

import java.util.Date;

import com.srn.erp.pagos.bm.PeriRetIB;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPeriRetIB extends Operation {

  public TraerPeriRetIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    PeriRetIB periretib = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       periretib = PeriRetIB.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       periretib = PeriRetIB.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetPeriRetIB = getDataSetPeriRetIB();
    if (periretib != null) {
        cargarRegistroPeriRetIB(datasetPeriRetIB,
                         periretib.getOIDInteger(),
                         periretib.getFecdesde(),
                         periretib.getFechasta(),
                         periretib.getDescripcion(),
                         periretib.getCodinterno(),
                         periretib.isActivo());
    }
    writeCliente(datasetPeriRetIB);
  }

  private IDataSet getDataSetPeriRetIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPeriRetIB");
    dataset.fieldDef(new Field("oid_peri_ret_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_desde", Field.STRING,10));
    dataset.fieldDef(new Field("fec_hasta", Field.STRING,10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("codigo_interno", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroPeriRetIB(IDataSet dataset,
                         Integer oid_peri_ret_ib,
                         Date fec_desde,
                         Date fec_hasta,
                         String descripcion,
                         String codigo_interno,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_peri_ret_ib", oid_peri_ret_ib);
    dataset.fieldValue("fec_desde",Fecha.getddmmyyyy(fec_desde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fec_hasta));
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("codigo_interno", codigo_interno);
    dataset.fieldValue("activo", activo);
  }
}
