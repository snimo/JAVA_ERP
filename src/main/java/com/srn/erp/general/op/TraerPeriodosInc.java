package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPeriodosInc extends Operation {

  public TraerPeriodosInc() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    PeriodoInc periodoinc = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       periodoinc = PeriodoInc.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       periodoinc = PeriodoInc.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetPeriodoInc = getDataSetPeriodoInc();
    IDataSet datasetPeriodoIncDet = getDataSetPeriodoIncDet();

    if (periodoinc != null) {
        cargarRegistroPeriodoInc(datasetPeriodoInc,
                         periodoinc.getOIDInteger(),
                         periodoinc.getPeriodo().getOIDInteger(),
                         periodoinc.getPeriodo().getCodigo(),
                         periodoinc.getTipo(),
                         periodoinc.getCodigo(),
                         periodoinc.isActivo());

        Iterator iterPeriIncDet = periodoinc.getPeriodosIncDet().iterator();
        while (iterPeriIncDet.hasNext()) {
          PeriodoIncDet periodoIncDet = (PeriodoIncDet) iterPeriIncDet.next();
          cargarRegistroPeriodoIncDet(
                datasetPeriodoIncDet,
                periodoIncDet.getOIDInteger(),
                periodoIncDet.getPeriinc().getOIDInteger(),
                periodoIncDet.getSecu(),
                periodoIncDet.getPeriodo().getOIDInteger(),
                periodoIncDet.getPeriodo().getCodigo(),
                periodoIncDet.isActivo());
        }


    }

    writeCliente(datasetPeriodoInc);
    writeCliente(datasetPeriodoIncDet);
  }

  private IDataSet getDataSetPeriodoInc() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPeriodoInc");
    dataset.fieldDef(new Field("oid_peri_inc_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_peri", Field.STRING, 15));
    dataset.fieldDef(new Field("tipo", Field.STRING, 15));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroPeriodoInc(IDataSet dataset,
                         Integer oid_peri_inc_cab,
                         Integer oidPeriodo,
                         String codigoPeri,
                         String tipo,
                         String codigo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_peri_inc_cab", oid_peri_inc_cab);
    dataset.fieldValue("oid_peri", oidPeriodo);
    dataset.fieldValue("codigo_peri", codigoPeri);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("activo", activo);
  }

  private IDataSet getDataSetPeriodoIncDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPeriodoIncDet");
    dataset.fieldDef(new Field("oid_peri_inc_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_peri_inc_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_peri", Field.STRING, 15));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroPeriodoIncDet(IDataSet dataset,
                         Integer oid_peri_inc_det,
                         Integer oid_peri_inc_cab,
                         Integer secu,
                         Integer oidPeri,
                         String codigoPeri,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_peri_inc_det", oid_peri_inc_det);
    dataset.fieldValue("oid_peri_inc_cab",oid_peri_inc_cab);
    dataset.fieldValue("secu",secu);
    dataset.fieldValue("oid_peri",oidPeri);
    dataset.fieldValue("codigo_peri",codigoPeri);
    dataset.fieldValue("activo",activo);
  }


}
