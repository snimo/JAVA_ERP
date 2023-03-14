package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.InventarioCab;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpInventario extends Operation {

  public TraerHelpInventario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsCompro = getDataSet();
    traerComproAjuStk(dsCompro,mapaDatos);
    writeCliente(dsCompro);
  }

  private void traerComproAjuStk(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Producto producto = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("oid_producto"))
      producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),getSesion());

    List listaCompro =
        InventarioCab.getInventarioCab(nroExtDesde,nroExtHasta,fecDesde,fecHasta,producto,getSesion());
    Iterator iterCompro = listaCompro.iterator();
    while (iterCompro.hasNext()) {
      InventarioCab inventarioCab = (InventarioCab) iterCompro.next();
      cargarRegistro(dataSet,inventarioCab);
    }

  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpInventario");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("fec_inventario", Field.DATE, 0));
    dataset.fieldDef(new Field("deposito", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              InventarioCab inventarioCab)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", inventarioCab.getOID());
    dataset.fieldValue("oid_cco", inventarioCab.getOID());
    dataset.fieldValue("comprobante", inventarioCab.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(inventarioCab.getEmision()));
    dataset.fieldValue("nro_ext", inventarioCab.getNroExt());
    dataset.fieldValue("activo", inventarioCab.isActivo());
    dataset.fieldValue("comentario", inventarioCab.getComentario());
    dataset.fieldValue("fec_inventario", inventarioCab.getFec_inventario());
    dataset.fieldValue("deposito", inventarioCab.getDeposito().getDescripcion());
    
  }

}
