package com.srn.erp.pagos.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.bm.RetCabIB;
import com.srn.erp.pagos.bm.RetCabIBDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTablaRetIB extends Operation {

  public TraerTablaRetIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {


    RetCabIB retcabib = null;
    if (mapaDatos.containsKey("oid")) {
      Integer oid = mapaDatos.getInteger("oid");
      retcabib = RetCabIB.findByOid(oid, getSesion());
    }
    else {
      String codigo = mapaDatos.getString("codigo");
      retcabib = RetCabIB.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetRetCabIB = getDataSetRetCabIB();
    IDataSet datasetRetCabIBDet = getDataSetRetCabIBDet();

    if (retcabib != null) {
      cargarRegistroRetCabIB(datasetRetCabIB,
                             retcabib.getOIDInteger(),
                             retcabib.getCatretIB(),
                             retcabib.getConcimpu(),
                             retcabib.getMontonoimpo(),
                             retcabib.getMontoretmin(),
                             retcabib.getFecvigdesde(),
                             retcabib.isActivo());

      Iterator iterDetalles = retcabib.getDetallesRetIB().iterator();
      while (iterDetalles.hasNext()) {
        RetCabIBDet retCabIBDet = (RetCabIBDet) iterDetalles.next();
        cargarRegistroRetCabIBDet(datasetRetCabIBDet,
                                  retCabIBDet.getOIDInteger(),
                                  retcabib,
                                  retCabIBDet.getMontodesde(),
                                  retCabIBDet.getMontohasta(),
                                  retCabIBDet.getPorc(),
                                  retCabIBDet.getMontofijo());

      }
      writeCliente(datasetRetCabIB);
      writeCliente(datasetRetCabIBDet);
    }
  }

  private IDataSet getDataSetRetCabIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRetCabIB");
    dataset.fieldDef(new Field("oid_ret_cab_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_no_impo", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_ret_min", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("fec_vig_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroRetCabIB(IDataSet dataset,
                         Integer oid_ret_cab_ib,
                         CatRetIB oid_cat_ret_ib,
                         ConceptoImpuesto oid_conc_impu,
                         Money monto_no_impo,
                         Money monto_ret_min,
                         Date fec_vig_desde,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_ret_cab_ib", oid_ret_cab_ib);
    dataset.fieldValue("oid_cat_ret_ib", oid_cat_ret_ib.getOID());
    dataset.fieldValue("oid_conc_impu", oid_conc_impu.getOID());
    dataset.fieldValue("monto_no_impo", monto_no_impo);
    dataset.fieldValue("monto_ret_min", monto_ret_min);
    dataset.fieldValue("fec_vig_desde", Fecha.getddmmyyyy(fec_vig_desde));
    dataset.fieldValue("activo", activo);
  }

  private IDataSet getDataSetRetCabIBDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRetCabIBDet");
    dataset.fieldDef(new Field("oid_ret_det_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ret_cab_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_desde", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_hasta", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_fijo", Field.CURRENCY, 0));
    return dataset;
  }


  private void cargarRegistroRetCabIBDet(IDataSet dataset,
                         Integer oid_ret_det_ib,
                         RetCabIB retCabIB,
                         Money montoDesde,
                         Money montoHasta,
                         Money porc,
                         Money montoFijo) {
    dataset.append();
    dataset.fieldValue("oid_ret_det_ib", oid_ret_det_ib);
    dataset.fieldValue("oid_ret_cab_ib", retCabIB.getOID());
    dataset.fieldValue("monto_desde", montoDesde.doubleValue());
    dataset.fieldValue("monto_hasta", montoHasta.doubleValue());
    dataset.fieldValue("porc", porc.doubleValue());
    dataset.fieldValue("monto_fijo", montoFijo.doubleValue());
  }



}
