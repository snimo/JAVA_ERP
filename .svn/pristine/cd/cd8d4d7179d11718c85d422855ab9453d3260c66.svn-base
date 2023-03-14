package com.srn.erp.general.op;

import com.srn.erp.general.bm.FactorConversion;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFactorConversion extends Operation {

  public TraerFactorConversion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    FactorConversion factorconversion = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       factorconversion = FactorConversion.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       factorconversion = FactorConversion.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetFactorConversion = getDataSetFactorConversion();
    if (factorconversion != null) {
        cargarRegistroFactorConversion(datasetFactorConversion,
                         factorconversion.getOIDInteger(),
                         factorconversion.getUni_med_ori(),
                         factorconversion.getUni_med_dest(),
                         factorconversion.getFactor(),
                         factorconversion.isActivo());
    }
    writeCliente(datasetFactorConversion);
  }

  private IDataSet getDataSetFactorConversion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFactorConversion");
    dataset.fieldDef(new Field("oid_fact_conv", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_ori", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_dest", Field.INTEGER, 0));
    dataset.fieldDef(new Field("factor", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroFactorConversion(IDataSet dataset,
                         Integer oid_fact_conv,
                         UnidadMedida um_ori,
                         UnidadMedida um_dest,
                         Double factor,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_fact_conv", oid_fact_conv);
    dataset.fieldValue("oid_um_ori", um_ori.getOIDInteger());
    dataset.fieldValue("oid_um_dest", um_dest.getOIDInteger());
    dataset.fieldValue("factor", factor);
    dataset.fieldValue("activo", activo);
  }
}
