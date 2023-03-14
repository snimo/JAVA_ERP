package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpComproProv extends Operation {

  public TraerHelpComproProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {  	
    IDataSet dsComproProv = getDataSetComproProv();
    traerComproProv(dsComproProv,mapaDatos);
    writeCliente(dsComproProv);
  }

  private void traerComproProv(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

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

    List listaComproProv =
        ComproProveedor.getHelpComproProv(nroExtDesde,nroExtHasta,proveedor,fecDesde,fecHasta,getSesion());
    Iterator iterComproProv = listaComproProv.iterator();
    while (iterComproProv.hasNext()) {
      ComproProveedor comproProveedor = (ComproProveedor) iterComproProv.next();
      cargarRegistroComproProv(dataSet,comproProveedor);
    }

  }

  private IDataSet getDataSetComproProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpComproProv");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
    dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroComproProv(IDataSet dataset,
                                        ComproProveedor comproProv)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", comproProv.getOID());
    dataset.fieldValue("oid_cco", comproProv.getOID());
    dataset.fieldValue("comprobante", comproProv.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(comproProv.getEmision()));
    if (comproProv.getProveedor()!=null) {
      dataset.fieldValue("oid_proveedor", comproProv.getProveedor().getOID());
      dataset.fieldValue("cod_proveedor", comproProv.getProveedor().getCodigo());
      dataset.fieldValue("rs_proveedor", comproProv.getProveedor().getRazonsocial());
    } else {
      dataset.fieldValue("oid_proveedor", 0);
      dataset.fieldValue("cod_proveedor", "");
      dataset.fieldValue("rs_proveedor", "");
    }
    dataset.fieldValue("activo", comproProv.isActivo());
    dataset.fieldValue("total", comproProv.getTotMonedaOri());
    dataset.fieldValue("moneda", comproProv.getMoneda().getCodigo());
    
  }

}
