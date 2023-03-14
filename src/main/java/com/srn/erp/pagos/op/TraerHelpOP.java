package com.srn.erp.pagos.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpOP extends Operation {

  public TraerHelpOP() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {  	
    IDataSet dsOP = getDataSetOP();
    traerOP(dsOP,mapaDatos);
    writeCliente(dsOP);
  }

  private void traerOP(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Proveedor proveedor = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("oid_proveedor"))
      proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());

    List listaOP =
        ComproOrdenPagoCab.getHelpOP(nroExtDesde,nroExtHasta,proveedor,fecDesde,fecHasta,getSesion());
    Iterator iterComproOP = listaOP.iterator();
    while (iterComproOP.hasNext()) {
    	ComproOrdenPagoCab op = (ComproOrdenPagoCab) iterComproOP.next();
    	cargarRegistroOP(dataSet,op);
    }

  }

  private IDataSet getDataSetOP() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpOP");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
    return dataset;
  }

  private void cargarRegistroOP(IDataSet dataset,
                                ComproOrdenPagoCab op)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", op.getOID());
    dataset.fieldValue("oid_cco", op.getOID());
    dataset.fieldValue("comprobante", op.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(op.getEmision()));
    if (op.getProveedor()!=null) {
      dataset.fieldValue("oid_proveedor", op.getProveedor().getOID());
      dataset.fieldValue("cod_proveedor", op.getProveedor().getCodigo());
      dataset.fieldValue("rs_proveedor", op.getProveedor().getRazonsocial());
    } else {
      dataset.fieldValue("oid_proveedor", 0);
      dataset.fieldValue("cod_proveedor", "");
      dataset.fieldValue("rs_proveedor", "");
    }
    dataset.fieldValue("activo", op.isActivo());
  }

}
