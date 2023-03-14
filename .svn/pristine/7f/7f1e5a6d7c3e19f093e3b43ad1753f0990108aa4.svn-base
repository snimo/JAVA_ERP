package com.srn.erp.pagos.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.RetCabGan;
import com.srn.erp.pagos.bm.RetCabGanDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTablaRetGan extends Operation {

  public TraerTablaRetGan() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    RetCabGan retcabgan = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       retcabgan = RetCabGan.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       retcabgan = RetCabGan.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetRetCabGan = getDataSetRetCabGan();
    IDataSet datasetRetCabGanDet = getDataSetRetCabGanDet();

    if (retcabgan != null) {
        cargarRegistroRetCabGan(datasetRetCabGan,
                         retcabgan.getOIDInteger(),
                         retcabgan.getCatretgan(),
                         retcabgan.getConcimpu(),
                         retcabgan.getMontonoimpo(),
                         retcabgan.getMontoretmin(),
                         retcabgan.getFecvigdesde(),
                         retcabgan.isActivo());

        Iterator iterDetalles = retcabgan.getDetallesRetGan().iterator();
        while (iterDetalles.hasNext()) {
         RetCabGanDet retCabGanDet = (RetCabGanDet) iterDetalles.next();
         cargarRegistroRetCabGanDet(datasetRetCabGanDet,
                                    retCabGanDet.getOIDInteger(),
                                    retcabgan,
                                    retCabGanDet.getMontodesde(),
                                    retCabGanDet.getMontohasta(),
                                    retCabGanDet.getPorc(),
                                    retCabGanDet.getMontofijo());
 }

    }
    writeCliente(datasetRetCabGan);
    writeCliente(datasetRetCabGanDet);
  }

  private IDataSet getDataSetRetCabGan() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRetCabGan");
    dataset.fieldDef(new Field("oid_ret_cab_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_no_impo", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_ret_min", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("fec_vig_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroRetCabGan(IDataSet dataset,
                         Integer oid_ret_cab_gan,
                         CatRetGan oid_cat_ret_gan,
                         ConceptoImpuesto oid_conc_impu,
                         Money monto_no_impo,
                         Money monto_ret_min,
                         Date fec_vig_desde,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_ret_cab_gan", oid_ret_cab_gan);
    dataset.fieldValue("oid_cat_ret_gan", oid_cat_ret_gan.getOID());
    dataset.fieldValue("oid_conc_impu", oid_conc_impu.getOID());
    dataset.fieldValue("monto_no_impo", monto_no_impo);
    dataset.fieldValue("monto_ret_min", monto_ret_min);
    dataset.fieldValue("fec_vig_desde", Fecha.getddmmyyyy(fec_vig_desde));
    dataset.fieldValue("activo", activo);
  }

  private IDataSet getDataSetRetCabGanDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRetCabGanDet");
    dataset.fieldDef(new Field("oid_ret_det_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ret_cab_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_desde", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_hasta", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_fijo", Field.CURRENCY, 0));
    return dataset;
  }


  private void cargarRegistroRetCabGanDet(IDataSet dataset,
                         Integer oid_ret_det_gan,
                         RetCabGan retCabGan,
                         Money montoDesde,
                         Money montoHasta,
                         Money porc,
                         Money montoFijo) {
    dataset.append();
    dataset.fieldValue("oid_ret_det_gan", oid_ret_det_gan);
    dataset.fieldValue("oid_ret_cab_gan", retCabGan.getOID());
    dataset.fieldValue("monto_desde", montoDesde.doubleValue());
    dataset.fieldValue("monto_hasta", montoHasta.doubleValue());
    dataset.fieldValue("porc", porc.doubleValue());
    dataset.fieldValue("monto_fijo", montoFijo.doubleValue());
  }


}
