package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpReferenciaCompro extends Operation {

  Integer nroExtDesde = null;
  Integer nroExtHasta = null;
  java.util.Date fecDesde = null; 
  java.util.Date fecHasta = null;
  String tipoCompro = null;
  Integer oidSujeto = null;
  Integer oidProveedor = null;
  Integer oidProducto = null;
	
  public TraerHelpReferenciaCompro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  	  
	if (mapaDatos.containsKey("nro_ext_desde"))  
		nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
	
	if (mapaDatos.containsKey("nro_ext_hasta"))  
		nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
	
	if (mapaDatos.containsKey("fec_desde"))  
		fecDesde = mapaDatos.getDate("fec_desde");	
	
	if (mapaDatos.containsKey("fec_hasta"))  
		fecHasta = mapaDatos.getDate("fec_hasta");
	
	if (mapaDatos.containsKey("oid_sujeto"))  
		oidSujeto = mapaDatos.getInteger("oid_sujeto");
	
	if (mapaDatos.containsKey("oid_proveedor"))  
		oidProveedor = mapaDatos.getInteger("oid_proveedor");	
	
	if (mapaDatos.containsKey("oid_producto"))  
		oidProducto = mapaDatos.getInteger("oid_producto");	
	
	if (mapaDatos.containsKey("tipo_comprobante"))  
		tipoCompro = mapaDatos.getString("tipo_comprobante");	
	
	if ((tipoCompro!=null) && (tipoCompro.equals(PedidoCab.NICKNAME)))
		traerPedidos();
	else
		if ((tipoCompro!=null) && (tipoCompro.equals(RequisicionCab.NICKNAME)))
			traerRequisiciones();
	
			
  }
  
  
  private void traerRequisiciones() throws BaseException {

	  IDataSet ds = this.getDataSetRequisiciones();
	  
	  Proveedor proveedor = null;
	  Producto producto = null;
	  
	  if (oidProveedor!=null)
		  proveedor = Proveedor.findByOid(oidProveedor, this.getSesion());
	  
	  if (oidProducto!=null)
		  producto = Producto.findByOid(oidProducto, this.getSesion());	  
	  
	  Iterator iterReqDet = 
		  RequisicionDet.getAllDetalles(proveedor, nroExtDesde, nroExtHasta, fecDesde, fecHasta, null, null, producto, this.getSesion()).iterator();
	  while (iterReqDet.hasNext()) {
		  RequisicionDet requiDet = (RequisicionDet) iterReqDet.next();
		  cargarRegistroReqDet(ds, requiDet);
	  }
	  writeCliente(ds);
	  
	  
  }
  
  private void traerPedidos() throws BaseException {
	  IDataSet ds = this.getDataSetTipoCompro();
	  
	  Sujeto sujeto = null;
	  Producto producto = null;
	  
	  if (oidSujeto!=null)
		  sujeto = Sujeto.findByOid(oidSujeto, this.getSesion());
	  
	  if (oidProducto!=null)
		  producto = Producto.findByOid(oidProducto, this.getSesion());	  
	  
	  Iterator iterPedDet = 
		  PedidoDet.getAllDetalles(sujeto, nroExtDesde, nroExtHasta, fecDesde, fecHasta, null, null, producto, this.getSesion()).iterator();
	  while (iterPedDet.hasNext()) {
		  PedidoDet pedidoDet = (PedidoDet) iterPedDet.next();
		  cargarRegistroPedDet(ds, pedidoDet);
	  }
	  writeCliente(ds);
  }
  

  private IDataSet getDataSetTipoCompro() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDetallesCompro");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("entregado", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("pend_ent", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sujeto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("rs_sujeto",Field.STRING, 100));
    return dataset;
  }
  
  private IDataSet getDataSetRequisiciones() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TDetallesCompro");
	    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
	    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
	    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("entregado", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("pend_ent", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
	    dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_proveedor",Field.STRING, 50));
	    dataset.fieldDef(new Field("rs_proveedor",Field.STRING, 100));
	    return dataset;
	  }
  

  private void cargarRegistroPedDet(IDataSet dataset,
                         PedidoDet pedidoDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", pedidoDet.getPedido().getOIDInteger());
    dataset.fieldValue("oid_cco", pedidoDet.getPedido().getOIDInteger());
    dataset.fieldValue("oid_cco_det", pedidoDet.getOIDInteger());
    dataset.fieldValue("comprobante", pedidoDet.getPedido().getCodigo());
    dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
    dataset.fieldValue("cantidad", pedidoDet.getCant_um_ori());
    dataset.fieldValue("entregado", pedidoDet.getCant_um_ori_desp());
    dataset.fieldValue("pend_ent", pedidoDet.getCantPendDespUniOri());
    dataset.fieldValue("fecha", pedidoDet.getFechaEntrega());
    dataset.fieldValue("nro_item", pedidoDet.getNroRenglon());
    dataset.fieldValue("oid_sujeto", pedidoDet.getPedido().getSujeto().getOIDInteger());
    dataset.fieldValue("rs_sujeto", pedidoDet.getPedido().getSujeto().getRazon_social());
  }
  
  private void cargarRegistroReqDet(IDataSet dataset,
          RequisicionDet requiDet) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid", requiDet.getRequisicion().getOIDInteger());
	  dataset.fieldValue("oid_cco", requiDet.getRequisicion().getOIDInteger());
	  dataset.fieldValue("oid_cco_det", requiDet.getOIDInteger());
	  dataset.fieldValue("comprobante", requiDet.getRequisicion().getCodigo());
	  dataset.fieldValue("oid_producto", requiDet.getProducto().getOIDInteger());
	  dataset.fieldValue("cod_producto", requiDet.getProducto().getCodigo());
	  dataset.fieldValue("desc_producto", requiDet.getProducto().getDescripcion());
	  dataset.fieldValue("cantidad", requiDet.getCant_solicitada());
	  dataset.fieldValue("entregado", requiDet.getCan_comprada());
	  dataset.fieldValue("pend_ent", requiDet.getcantPendCompra());
	  dataset.fieldValue("fecha", requiDet.getFec_requerida());
	  dataset.fieldValue("nro_item", requiDet.getRenglon());
	  if (requiDet.getProveedor()!=null) {
		  dataset.fieldValue("oid_proveedor", requiDet.getProveedor().getOIDInteger());
		  dataset.fieldValue("cod_proveedor", requiDet.getProveedor().getCodigo());
		  dataset.fieldValue("rs_proveedor", requiDet.getProveedor().getRazonsocial());
	  } else {
		  dataset.fieldValue("oid_proveedor", "");
		  dataset.fieldValue("cod_proveedor", "");
		  dataset.fieldValue("rs_proveedor", "");
	  }
	  
  }  
}
