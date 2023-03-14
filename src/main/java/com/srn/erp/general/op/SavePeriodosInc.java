package com.srn.erp.general.op;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePeriodosInc extends Operation {

  public SavePeriodosInc() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPeriodoInc");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {

        PeriodoInc periodoinc = PeriodoInc.findByOid(dataset.getInteger("oid_peri_inc_cab"),getSesion());
        periodoinc.setOID(dataset.getInteger("oid_peri_inc_cab"));
        periodoinc.setPeriodo(Periodo.findByOidProxy(dataset.getInteger("oid_peri"),getSesion()));
        periodoinc.setTipo(dataset.getString("tipo"));
        periodoinc.setCodigo(dataset.getString("codigo"));
        periodoinc.setActivo(dataset.getBoolean("activo"));

        IDataSet datasetPeriodosIncDet = dataset.getDataSet("TPeriodoIncDet");
        datasetPeriodosIncDet.first();
        while (!datasetPeriodosIncDet.EOF()) {
          PeriodoIncDet periodoIncDet =
              PeriodoIncDet.findByOid(datasetPeriodosIncDet.getInteger("oid_peri_inc_det"),getSesion());
          periodoIncDet.setPeriinc(periodoinc);
          periodoIncDet.setSecu(datasetPeriodosIncDet.getInteger("secu"));
          periodoIncDet.setPeriodo(Periodo.findByOidProxy(datasetPeriodosIncDet.getInteger("oid_peri"),getSesion()));
          periodoIncDet.setActivo(datasetPeriodosIncDet.getBoolean("activo"));
          periodoinc.addPeriodoIncDet(periodoIncDet);
          datasetPeriodosIncDet.next();
        }

        addTransaccion(periodoinc);
        dataset.next();
    }
  }

}
