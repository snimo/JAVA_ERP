package com.srn.erp.general.op;

import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConversionUM extends Operation {

  public TraerConversionUM() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer oidUMOri = mapaDatos.getInteger("oid_um_ori");
    Integer oidUMDest = mapaDatos.getInteger("oid_um_dest");
    UnidadMedida umOri = UnidadMedida.findByOid(oidUMOri,getSesion());
    UnidadMedida umDest = UnidadMedida.findByOid(oidUMDest,getSesion());

    Double cantidad = mapaDatos.getDouble("cantidad");
    IDataSet dsConversion = getDataConvUM();
    cargarRegistroConvUM(dsConversion,
                         umOri,
                         umDest,
                         null,
                         cantidad
                         );

    writeCliente(dsConversion);
  }

  private IDataSet getDataConvUM() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConvUM");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_ori", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_dest", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fact_conv", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_convertida", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistroConvUM(IDataSet dataset,
                                    UnidadMedida unidadMedidaOri,
                                    UnidadMedida unidadMedidaDest,
                                    Double factConv,
                                    Double cantConvertida) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", 1);
    dataset.fieldValue("oid_um_ori", unidadMedidaOri.getOID());
    dataset.fieldValue("oid_um_dest", unidadMedidaDest.getOID());
    dataset.fieldValue("fact_conv", factConv);
    dataset.fieldValue("cant_convertida", cantConvertida);
  }

}
