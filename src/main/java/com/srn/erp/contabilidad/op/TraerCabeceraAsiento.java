package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCabeceraAsiento extends Operation {

  public TraerCabeceraAsiento() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Integer oidCCO = mapaDatos.getInteger(DBComproCab.OID_CCO);
    traerCabeceraAsiento(oidCCO);
  }


  public void traerCabeceraAsiento(Integer oidCCO) throws BaseException {

    IDataSet dataSetCabeceraAsiento = getDataSetCabeceraAsiento();

    ComproConta comproConta = ComproConta.findByOid(oidCCO,getSesion());
    cargarRegistroCabeceraAsiento(dataSetCabeceraAsiento,
                                  comproConta.getOIDInteger(),
                                  comproConta.getComprobante().getCodigo(),
                                  comproConta.getComprobante().getEmision(),
                                  comproConta.getImputac(),
                                  comproConta.getComprobante().getComentario(),
                                  comproConta.isAnulado());

    writeCliente(dataSetCabeceraAsiento);

  }

  private IDataSet getDataSetCabeceraAsiento() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCabeceraAsiento");
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante",Field.STRING, 30));
    dataset.fieldDef(new Field("fec_emision",Field.STRING, 10));
    dataset.fieldDef(new Field("fec_imputacion",Field.STRING, 10));
    dataset.fieldDef(new Field("comentario",Field.STRING, 255));
    dataset.fieldDef(new Field("anulado",Field.BOOLEAN,0));
    return dataset;
  }

  private void cargarRegistroCabeceraAsiento(IDataSet dataset,
                                            Integer oidCCO,
                                            String comprobante,
                                            java.util.Date fecEmision,
                                            java.util.Date fecImputacion,
                                            String comentario,
                                            Boolean anulado) {
    dataset.append();
    dataset.fieldValue("oid_cco", oidCCO);
    dataset.fieldValue("comprobante",comprobante);
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(fecEmision));
    dataset.fieldValue("fec_imputacion", Fecha.getddmmyyyy(fecImputacion));
    dataset.fieldValue("comentario", comentario);
    dataset.fieldValue("anulado", anulado);
  }



}
