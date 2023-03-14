package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRtoIntPendRecep extends Operation { 

  public TraerRtoIntPendRecep() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  java.util.Date fecDesde = null;
	  java.util.Date fecHasta = null;
	  Deposito deposito = null;
	  Producto producto = null;
	  Integer nroRtoDesde = null;
	  Integer nroRtoHasta = null;
	  
	  if (mapaDatos.containsKey("fec_desde")) 
		  fecDesde = mapaDatos.getDate("fec_desde");
	  if (mapaDatos.containsKey("fec_hasta")) 
		  fecHasta = mapaDatos.getDate("fec_hasta");	  
	  if (mapaDatos.containsKey("oid_deposito")) 
		  deposito = Deposito.findByOidProxy(mapaDatos.getInteger("oid_deposito"),this.getSesion());
	  if (mapaDatos.containsKey("oid_producto")) 
		  producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),this.getSesion());
	  if (mapaDatos.containsKey("nro_rto_desde")) 
		  nroRtoDesde = mapaDatos.getInteger("nro_rto_desde");
	  if (mapaDatos.containsKey("nro_rto_hasta")) 
		  nroRtoHasta = mapaDatos.getInteger("nro_rto_hasta");
	  
	  Iterator iterRtoIntPendRecep = 
		  RemitoDet.getDetallesPendRecep(null, deposito, producto, fecDesde, fecHasta, nroRtoDesde, nroRtoHasta, this.getSesion()).iterator();
	  
	  IDataSet ds = this.getDSRtoIntPendRecep();
	  while (iterRtoIntPendRecep.hasNext()) {
		  RemitoDet remitoDet = (RemitoDet) iterRtoIntPendRecep.next();
		  cargarRegistro(ds, remitoDet);
	  }
	  writeCliente(ds);
	  
	  
	  
  }

  private IDataSet getDSRtoIntPendRecep() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRtoIntPendRecep");
    dataset.fieldDef(new Field("oid_rto_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rto_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("obs_remito", Field.MEMO, 0));
    dataset.fieldDef(new Field("entregar_en", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("obs_producto", Field.MEMO, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cod_um", Field.STRING, 20));
    dataset.fieldDef(new Field("cant_recep", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_pend_recep", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                              RemitoDet remitoDet) throws BaseException {
  	
      dataset.append();
      dataset.fieldValue("oid_rto_det", remitoDet.getOIDInteger());
      dataset.fieldValue("oid_rto_cab", remitoDet.getRemito_cab().getOIDInteger());
      dataset.fieldValue("comprobante", remitoDet.getRemito_cab().getCodigo());
      dataset.fieldValue("fec_emision", remitoDet.getRemito_cab().getEmision());
      dataset.fieldValue("obs_remito", remitoDet.getRemito_cab().getComentario());
      dataset.fieldValue("entregar_en", remitoDet.getRemito_cab().getDepo_destino().getDescripcion());
      dataset.fieldValue("oid_producto", remitoDet.getProducto().getOIDInteger());
      dataset.fieldValue("cod_producto", remitoDet.getProducto().getCodigo());
      dataset.fieldValue("desc_producto", remitoDet.getProducto().getDescripcion());
      dataset.fieldValue("obs_producto", remitoDet.getComentario());
      dataset.fieldValue("cantidad", remitoDet.getCant_desp());
      dataset.fieldValue("cod_um", remitoDet.getUnidad_desp().getCodigo());
      dataset.fieldValue("cant_recep", remitoDet.getCantRecep());
      dataset.fieldValue("cant_pend_recep", remitoDet.getCantPendRecep());
    
  }  
  
}
