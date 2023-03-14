package com.srn.erp.pagos.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetIVA;
import com.srn.erp.pagos.bm.RetCabIVA;
import com.srn.erp.pagos.bm.RetCabIVADet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTablaRetIVA extends Operation {

  public TraerTablaRetIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    RetCabIVA retcabiva = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       retcabiva = RetCabIVA.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       retcabiva = RetCabIVA.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetRetCabIVA = getDataSetRetCabIVA();
    IDataSet datasetRetCabIVADet = getDataSetRetCabIVADet();

    if (retcabiva != null) {

        cargarRegistroRetCabIVA(datasetRetCabIVA,
                         retcabiva.getOIDInteger(),
                         retcabiva.getCatretiva(),
                         retcabiva.getConcimpu(),
                         retcabiva.getMontonoimpo(),
                         retcabiva.getMontoretmin(),
                         retcabiva.getFecvigdesde(),
                         retcabiva.isActivo());

        Iterator iterDetalles = retcabiva.getDetallesRetIVA().iterator();
        while (iterDetalles.hasNext()) {
          RetCabIVADet retCabIVADet = (RetCabIVADet) iterDetalles.next();
          cargarRegistroRetCabIVADet(datasetRetCabIVADet,
                                     retCabIVADet.getOIDInteger(),
                                     retcabiva,
                                     retCabIVADet.getMontodesde(),
                                     retCabIVADet.getMontohasta(),
                                     retCabIVADet.getPorc(),
                                     retCabIVADet.getMontofijo());
        }


    }

    writeCliente(datasetRetCabIVA);
    writeCliente(datasetRetCabIVADet);
  }

  private IDataSet getDataSetRetCabIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRetCabIVA");
    dataset.fieldDef(new Field("oid_ret_cab_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_no_impo", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_ret_min", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("fec_vig_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroRetCabIVA(IDataSet dataset,
                         Integer oid_ret_cab_iva,
                         CatRetIVA oid_cat_ret_iva,
                         ConceptoImpuesto oid_conc_impu,
                         Money monto_no_impo,
                         Money monto_ret_min,
                         Date fec_vig_desde,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_ret_cab_iva", oid_ret_cab_iva);
    dataset.fieldValue("oid_cat_ret_iva", oid_cat_ret_iva.getOID());
    dataset.fieldValue("oid_conc_impu", oid_conc_impu.getOID());
    dataset.fieldValue("monto_no_impo", monto_no_impo);
    dataset.fieldValue("monto_ret_min", monto_ret_min);
    dataset.fieldValue("fec_vig_desde", Fecha.getddmmyyyy(fec_vig_desde));
    dataset.fieldValue("activo", activo);
  }

  private IDataSet getDataSetRetCabIVADet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRetCabIVADet");
    dataset.fieldDef(new Field("oid_ret_det_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ret_cab_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_desde", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_hasta", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_fijo", Field.CURRENCY, 0));
    return dataset;
  }


  private void cargarRegistroRetCabIVADet(IDataSet dataset,
                         Integer oid_ret_det_iva,
                         RetCabIVA retCabIVA,
                         Money montoDesde,
                         Money montoHasta,
                         Money porc,
                         Money montoFijo) {
    dataset.append();
    dataset.fieldValue("oid_ret_det_iva", oid_ret_det_iva);
    dataset.fieldValue("oid_ret_cab_iva", retCabIVA.getOID());
    dataset.fieldValue("monto_desde", montoDesde.doubleValue());
    dataset.fieldValue("monto_hasta", montoHasta.doubleValue());
    dataset.fieldValue("porc", porc.doubleValue());
    dataset.fieldValue("monto_fijo", montoFijo.doubleValue());
  }


}
