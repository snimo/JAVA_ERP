package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerItemPedido extends Operation {

  public TraerItemPedido() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	String tipo = mapaDatos.getString("tipo");
	IDataSet dsItemPedido = getDSItemPedido();
	
	if (tipo.equals("VAL_OIDPEDIDO_ITEM"))
		validarNroPedidoNroItem(dsItemPedido,mapaDatos);
	  

    writeCliente(dsItemPedido);
  }
  
  private void validarNroPedidoNroItem(IDataSet ds,MapDatos mapaDatos) throws BaseException {
	  
	  // Validar el Nro. de Pedido y el item
	  
	  if (!mapaDatos.containsKey("oid_cco_ped"))
		  throw new ExceptionValidation(null,"Debe ingresar el Nro. de Pedido");
	  
	  if (!mapaDatos.containsKey("nro_item"))
		  throw new ExceptionValidation(null,"Debe ingresar el Nro. de Item del Pedido");
	  	  
	  if (mapaDatos.getInteger("oid_cco_ped").intValue()<=0)
		  throw new ExceptionValidation(null,"Debe ingresar el pedido");
	  
	  if (mapaDatos.getInteger("nro_item").intValue()<=0)
		  throw new ExceptionValidation(null,"Debe ingresar el Nro. de Item");
	  
	  PedidoCab pedido = PedidoCab.findByOid(mapaDatos.getInteger("oid_cco_ped"), this.getSesion());
	  PedidoDet pedidoDet = pedido.getPedidoDet(mapaDatos.getInteger("nro_item"));
	  
	  if (pedidoDet!=null)
		  cargarRegistro(ds,pedidoDet);
	  
  }

  private IDataSet getDSItemPedido() {
    IDataSet dataset = new TDataSet();
    dataset.create("TItemPedido");
    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("desc_adic", Field.MEMO, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("entregado", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("pend_ent", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 5000));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		  					  PedidoDet pedidoDet) throws BaseException {
    dataset.append();    
    dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
    dataset.fieldValue("oid_cco_ped", pedidoDet.getPedido().getOIDInteger());
    dataset.fieldValue("nro_item", pedidoDet.getNroRenglon());
    dataset.fieldValue("nro_ext_ped", pedidoDet.getPedido().getNroExt());
    dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
    dataset.fieldValue("desc_adic", pedidoDet.getComentario());
    dataset.fieldValue("cantidad", pedidoDet.getCant_um_ori());
    dataset.fieldValue("entregado", pedidoDet.getCant_um_ori_desp());
    dataset.fieldValue("pend_ent", pedidoDet.getCantPendDespUniOri());
    dataset.fieldValue("anulado", pedidoDet.isAnulado().booleanValue());
    dataset.fieldValue("descripcion", pedidoDet.getDescripcion());
  }
}
