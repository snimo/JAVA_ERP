package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.compras.bm.CondicionVentaDet;

import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCondicionVenta extends Operation {

  public TraerCondicionVenta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CondicionVenta condicionVenta = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       condicionVenta = CondicionVenta.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       condicionVenta = CondicionVenta.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCondicionVenta = getDataSetCondicionVenta();
    IDataSet datasetConcicionVentaDet = getDataSetCondicionVentaDet();
    if (condicionVenta != null) {
        cargarRegistroCondicionVenta(datasetCondicionVenta,
                         condicionVenta.getOIDInteger(),
                         condicionVenta.getCodigo(),
                         condicionVenta.getDescripcion(),
                         condicionVenta.isVtofijo(),
                         condicionVenta.getPorcDto(),
                         condicionVenta.getPorcRecar(),
                         condicionVenta.isActivo());
       Iterator iterCondVentaDet = condicionVenta.getCondicionesVentaDet().iterator();
       while (iterCondVentaDet.hasNext()) {
         CondicionVentaDet condVentaDet = (CondicionVentaDet) iterCondVentaDet.next();
         cargarRegistroCondicionVentaDet(datasetConcicionVentaDet,
                                          condVentaDet.getOIDInteger(),
                                          condVentaDet.getCondicionVenta().getOIDInteger(),
                                          condVentaDet.getUnidadvenc(),
                                          condVentaDet.getCantidad(),
                                          condVentaDet.getNrocuota(),
                                          condVentaDet.getPorcentaje(),
                                          condVentaDet.isActivo());
       }


    }
    writeCliente(datasetCondicionVenta);
    writeCliente(datasetConcicionVentaDet);
  }

  private IDataSet getDataSetCondicionVenta() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondicionVenta");
    dataset.fieldDef(new Field("oid_cond_venta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("vto_fijo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("porc_dto",Field.CURRENCY,0));
    dataset.fieldDef(new Field("porc_recar",Field.CURRENCY,0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetCondicionVentaDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondicionVentaDet");
    dataset.fieldDef(new Field("oid_cond_vta_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_vta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("unidad_cuota_venc", Field.STRING, 5));
    dataset.fieldDef(new Field("cantidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_cuota", Field.INTEGER, 0));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCondicionVentaDet(IDataSet dataset,
                         Integer oidCondVtaDet,
                         Integer oidConcVta,
                         String uniCuota,
                         Integer cantidad,
                         Integer nroCuota,
                         Double porc,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cond_vta_det", oidCondVtaDet);
    dataset.fieldValue("oid_cond_vta", oidConcVta);
    dataset.fieldValue("unidad_cuota_venc", uniCuota);
    dataset.fieldValue("cantidad", cantidad);
    dataset.fieldValue("nro_cuota", nroCuota);
    dataset.fieldValue("porc", porc);
    dataset.fieldValue("activo", activo);
  }

  private void cargarRegistroCondicionVenta(IDataSet dataset,
                         Integer oid_cond_venta,
                         String codigo,
                         String descripcion,
                         Boolean vto_fijo,
                         Porcentaje porcDto,
                         Porcentaje porcRecar,
                         Boolean activo) {
    dataset.append();    dataset.fieldValue("oid_cond_venta", oid_cond_venta);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("vto_fijo", vto_fijo);
    if (porcDto!=null)
      dataset.fieldValue("porc_dto", porcDto);
    else
      dataset.fieldValue("porc_dto", 0);
    if (porcRecar!=null)
      dataset.fieldValue("porc_recar", porcRecar);
    else
      dataset.fieldValue("porc_recar", 0);
    dataset.fieldValue("activo", activo);
  }

}
