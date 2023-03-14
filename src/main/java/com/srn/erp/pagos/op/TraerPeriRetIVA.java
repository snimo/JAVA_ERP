package com.srn.erp.pagos.op;

import java.util.Date;

import com.srn.erp.pagos.bm.PeriRetIVA;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPeriRetIVA extends Operation {

  public TraerPeriRetIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    PeriRetIVA periretiva = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       periretiva = PeriRetIVA.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       periretiva = PeriRetIVA.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetPeriRetIVA = getDataSetPeriRetIVA();
    if (periretiva != null) {
        cargarRegistroPeriRetIVA(datasetPeriRetIVA,
                         periretiva.getOIDInteger(),
                         periretiva.getFecdesde(),
                         periretiva.getFechasta(),
                         periretiva.getDescripcion(),
                         periretiva.getCodinterno(),
                         periretiva.isActivo());
    }
    writeCliente(datasetPeriRetIVA);
  }

  private IDataSet getDataSetPeriRetIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPeriRetIVA");
    dataset.fieldDef(new Field("oid_peri_ret_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("codigo_interno", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroPeriRetIVA(IDataSet dataset,
                         Integer oid_peri_ret_iva,
                         Date fec_desde,
                         Date fec_hasta,
                         String descripcion,
                         String codigo_interno,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_peri_ret_iva", oid_peri_ret_iva);
    dataset.fieldValue("fec_desde", Fecha.getddmmyyyy(fec_desde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fec_hasta));
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("codigo_interno", codigo_interno);
    dataset.fieldValue("activo", activo);
  }
}
