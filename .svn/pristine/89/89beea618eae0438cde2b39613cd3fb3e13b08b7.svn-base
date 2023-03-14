package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpComproAjuStk extends Operation {

  public TraerHelpComproAjuStk() {
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
    String comportamiento = null;

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
    if (mapaDatos.containsKey("comportamiento"))
        comportamiento = mapaDatos.getString("comportamiento");

    List listaComproAjuStk =
        ComproAjusteStk.getComproAjuStk(nroExtDesde,nroExtHasta,fecDesde,fecHasta,producto,comportamiento,getSesion());
    Iterator iterComproAjuStk = listaComproAjuStk.iterator();
    while (iterComproAjuStk.hasNext()) {
      ComproAjusteStk comproAjuStk = (ComproAjusteStk) iterComproAjuStk.next();
      cargarRegistro(dataSet,comproAjuStk);
    }

  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpComproAjuStk");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("operacion", Field.STRING, 100));
    dataset.fieldDef(new Field("motivo", Field.STRING, 100));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                             ComproAjusteStk comproAjuStk)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", comproAjuStk.getOID());
    dataset.fieldValue("oid_cco", comproAjuStk.getOID());
    dataset.fieldValue("comprobante", comproAjuStk.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(comproAjuStk.getEmision()));
    dataset.fieldValue("nro_ext", comproAjuStk.getNroExt());
    dataset.fieldValue("activo", comproAjuStk.isActivo());
    dataset.fieldValue("operacion", comproAjuStk.getDescOperacion());
    if (comproAjuStk.getTipo_conf_mov()!=null)
    	dataset.fieldValue("motivo", comproAjuStk.getTipo_conf_mov().getDescripcion());
    else
    	dataset.fieldValue("motivo", "");
    dataset.fieldValue("comentario", comproAjuStk.getComentario());
    
    
  }

}
