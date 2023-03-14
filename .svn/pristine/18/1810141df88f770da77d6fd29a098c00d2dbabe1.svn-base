package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CondicionCompraDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCondicionCompra extends Operation {

  public TraerCondicionCompra() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CondicionCompra condicioncompra = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       condicioncompra = CondicionCompra.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       condicioncompra = CondicionCompra.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCondicionCompra = getDataSetCondicionCompra();
    IDataSet datasetConcicionCompaDet = getDataSetCondicionCompraDet();
    if (condicioncompra != null) {
        cargarRegistroCondicionCompra(datasetCondicionCompra,
                         condicioncompra.getOIDInteger(),
                         condicioncompra.getCodigo(),
                         condicioncompra.getDescripcion(),
                         condicioncompra.isVtofijo(),
                         condicioncompra.isActivo());
       Iterator iterCondCompraDet = condicioncompra.getCondicionesCompraDet().iterator();
       while (iterCondCompraDet.hasNext()) {
         CondicionCompraDet condCompraDet = (CondicionCompraDet) iterCondCompraDet.next();
         cargarRegistroCondicionCompraDet(datasetConcicionCompaDet,
                                          condCompraDet.getOIDInteger(),
                                          condicioncompra.getOIDInteger(),
                                          condCompraDet.getUnidadvenc(),
                                          condCompraDet.getCantidad(),
                                          condCompraDet.getNrocuota(),
                                          condCompraDet.getPorcentaje(),
                                          condCompraDet.isActivo());
       }


    }
    writeCliente(datasetCondicionCompra);
    writeCliente(datasetConcicionCompaDet);
  }

  private IDataSet getDataSetCondicionCompra() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondicionCompra");
    dataset.fieldDef(new Field("oid_cond_compra", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("vto_fijo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetCondicionCompraDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondicionCompraDet");
    dataset.fieldDef(new Field("oid_cond_cp_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_compra", Field.INTEGER, 0));
    dataset.fieldDef(new Field("unidad_cuota_venc", Field.STRING, 5));
    dataset.fieldDef(new Field("cantidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_cuota", Field.INTEGER, 0));
    dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCondicionCompraDet(IDataSet dataset,
                         Integer oidCondCPDet,
                         Integer oidConcComp,
                         String uniCuota,
                         Integer cantidad,
                         Integer nroCuota,
                         Double porc,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cond_cp_det", oidCondCPDet);
    dataset.fieldValue("oid_cond_compra", oidConcComp);
    dataset.fieldValue("unidad_cuota_venc", uniCuota);
    dataset.fieldValue("cantidad", cantidad);
    dataset.fieldValue("nro_cuota", nroCuota);
    dataset.fieldValue("porc", porc);
    dataset.fieldValue("activo", activo);
  }

  private void cargarRegistroCondicionCompra(IDataSet dataset,
                         Integer oid_cond_compra,
                         String codigo,
                         String descripcion,
                         Boolean vto_fijo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_cond_compra", oid_cond_compra);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("vto_fijo", vto_fijo);
    dataset.fieldValue("activo", activo);
  }

}
