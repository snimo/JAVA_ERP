package com.srn.erp.pagos.op;

import java.util.Date;

import com.srn.erp.pagos.bm.PeriRetGan;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPeriRetGan extends Operation {

  public TraerPeriRetGan() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    PeriRetGan periretgan = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       periretgan = PeriRetGan.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       periretgan = PeriRetGan.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetPeriRetGan = getDataSetPeriRetGan();
    if (periretgan != null) {
        cargarRegistroPeriRetGan(datasetPeriRetGan,
                         periretgan.getOIDInteger(),
                         periretgan.getFecdesde(),
                         periretgan.getFechasta(),
                         periretgan.getDescripcion(),
                         periretgan.getCodinterno(),
                         periretgan.isActivo());
    }
    writeCliente(datasetPeriRetGan);
  }

  private IDataSet getDataSetPeriRetGan() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPeriRetGan");
    dataset.fieldDef(new Field("oid_peri_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("codigo_interno", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroPeriRetGan(IDataSet dataset,
                         Integer oid_peri_ret_gan,
                         Date fec_desde,
                         Date fec_hasta,
                         String descripcion,
                         String codigo_interno,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_peri_ret_gan", oid_peri_ret_gan);
    dataset.fieldValue("fec_desde", Fecha.getddmmyyyy(fec_desde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fec_hasta));
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("codigo_interno", codigo_interno);
    dataset.fieldValue("activo", activo);
  }
}
