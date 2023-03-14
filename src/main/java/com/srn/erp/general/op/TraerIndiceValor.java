package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.IndiceValor;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIndiceValor extends Operation {

  public TraerIndiceValor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer oidPeriodoAnualMensual = mapaDatos.getInteger("oid_peri_inc_cab");
    PeriodoInc periodoInc = PeriodoInc.findByOid(oidPeriodoAnualMensual,getSesion());

    IDataSet dataSetPeriodos = getDataSetPeriMensual();
    IDataSet dataSetValIndi = getDataSetIndiceValor();

    Iterator iterPeriodosIncDet = periodoInc.getPeriodosIncDet().iterator();
    while (iterPeriodosIncDet.hasNext()) {
      PeriodoIncDet periodoIncDet = (PeriodoIncDet) iterPeriodosIncDet.next();
      cargarRegistroPeriodo(dataSetPeriodos,
                            periodoIncDet.getPeriodo().getOIDInteger(),
                            periodoIncDet.getPeriodo().getCodigo(),
                            periodoIncDet.isActivo()
                            );

      Iterator iterIndice = Indice.getAllIndices(getSesion()).iterator();
      while (iterIndice.hasNext()) {
        Indice indice = (Indice) iterIndice.next();
        IndiceValor indiceValor = IndiceValor.getIndiceValor(indice,periodoIncDet.getPeriodo(),getSesion());
        Integer oidIndiceValor = new Integer(-1);
        Double valor = new Double(0);

        if (indiceValor!=null) {
          oidIndiceValor = indiceValor.getOIDInteger();
          valor = indiceValor.getValor();
        }

        cargarRegistroIndiceValor(dataSetValIndi,
                                  oidIndiceValor,
                                  indice.getOIDInteger(),
                                  periodoIncDet.getPeriodo().getOIDInteger(),
                                  valor,
                                  indice.getDescripcion(),
                                  new Boolean(true));

      }
    }

    writeCliente(dataSetPeriodos);
    writeCliente(dataSetValIndi);

  }

  private IDataSet getDataSetIndiceValor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValIndice");
    dataset.fieldDef(new Field("oid_indice_val", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_indice", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_indice", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("indice", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetPeriMensual() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPeriodos");
    dataset.fieldDef(new Field("oid_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroIndiceValor(IDataSet dataset,
                         Integer oid_indice_val,
                         Integer oid_indice,
                         Integer oid_peri,
                         Double indice,
                         String descIndice,
                         Boolean activo) {

    dataset.append();
    dataset.fieldValue("oid_indice_val", oid_indice_val);
    dataset.fieldValue("oid_indice", oid_indice);
    dataset.fieldValue("desc_indice", descIndice);
    dataset.fieldValue("oid_peri", oid_peri);
    dataset.fieldValue("indice", indice);
    dataset.fieldValue("activo", activo);
  }

  private void cargarRegistroPeriodo(IDataSet dataset,
                         Integer oid_peri,
                         String codigo,
                         Boolean activo) {

    dataset.append();
    dataset.fieldValue("oid_peri", oid_peri);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("activo", activo);
  }


}
