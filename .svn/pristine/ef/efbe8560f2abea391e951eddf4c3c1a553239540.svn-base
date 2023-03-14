package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.FactorConversion;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFactoresDeConversion extends Operation {

  private int oid = 0;

  public TraerFactoresDeConversion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dsFactConv = getDataSetFactorConversion();

    UnidadMedida umOri =
        UnidadMedida.findByOidProxy(mapaDatos.getInteger("oid_um"),getSesion());

    Iterator iterUM = UnidadMedida.getAllUnidadesDeMedida(getSesion()).iterator();
    while (iterUM.hasNext()) {
      UnidadMedida umDest = (UnidadMedida) iterUM.next();
      if (umDest.getOID() == umOri.getOID()) continue;
      FactorConversion factConv = FactorConversion.getFactConv(umOri,umDest,getSesion());
      Integer oidFactConv = new Integer(0);
      Double factConversion = new Double(0);
      if (factConv!=null) {
        oidFactConv = factConv.getOIDInteger();
        factConversion =  factConv.getFactor();
      }

      cargarRegistroFactorConversion(dsFactConv,oidFactConv,umOri,umDest,factConversion,new Boolean(true));
    }

    writeCliente(dsFactConv);
  }

  private IDataSet getDataSetFactorConversion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFactorConversion");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_fact_conv", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_ori", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_dest", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_um_dest", Field.STRING , 50));
    dataset.fieldDef(new Field("factor", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroFactorConversion(IDataSet dataset,
                         Integer oid_fact_conv,
                         UnidadMedida um_ori,
                         UnidadMedida um_dest,
                         Double factor,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", ++oid);
    dataset.fieldValue("oid_fact_conv", oid_fact_conv);
    dataset.fieldValue("oid_um_ori", um_ori.getOIDInteger());
    dataset.fieldValue("oid_um_dest", um_dest.getOIDInteger());
    dataset.fieldValue("desc_um_dest",um_dest.getDescripcion());
    dataset.fieldValue("factor", factor);
    dataset.fieldValue("activo", activo);
  }
}
