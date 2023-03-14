package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SolicitarAPedMerc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPedDepoPendEnvio extends Operation { 

  public TraerPedDepoPendEnvio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  java.util.Date fecDesde = null;
	  java.util.Date fecHasta = null;
	  java.util.Date fecReqDesde = null;
	  java.util.Date fecReqHasta = null;	  
	  Deposito deposito = null;
	  Producto producto = null;
	  SolicitarAPedMerc solicitarA = null;
	  Integer nroPedDesde = null;
	  Integer nroPedHasta = null;
	  
	  if (mapaDatos.containsKey("fec_desde")) 
		  fecDesde = mapaDatos.getDate("fec_desde");
	  if (mapaDatos.containsKey("fec_hasta")) 
		  fecHasta = mapaDatos.getDate("fec_hasta");
	  if (mapaDatos.containsKey("fec_req_desde")) 
		  fecReqDesde = mapaDatos.getDate("fec_req_desde");
	  if (mapaDatos.containsKey("fec_req_hasta")) 
		  fecReqHasta = mapaDatos.getDate("fec_req_hasta");
	  
	  if (mapaDatos.containsKey("oid_deposito")) 
		  deposito = Deposito.findByOidProxy(mapaDatos.getInteger("oid_deposito"),this.getSesion());
	  if (mapaDatos.containsKey("oid_producto")) 
		  producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),this.getSesion());
	  if (mapaDatos.containsKey("oid_solicitado_a")) 
		  solicitarA = SolicitarAPedMerc.findByOidProxy(mapaDatos.getInteger("oid_solicitado_a"),this.getSesion());
	  if (mapaDatos.containsKey("nro_ped_desde")) 
		  nroPedDesde = mapaDatos.getInteger("nro_ped_desde");
	  if (mapaDatos.containsKey("nro_ped_hasta")) 
		  nroPedHasta = mapaDatos.getInteger("nro_ped_hasta");
	  
	  Iterator iterPedPendDeEnvio = 
		  PedMercDepoDet.getDetallesPendientesDeEnvio(
				  nroPedDesde, 
				  nroPedHasta, 
				  fecDesde, 
				  fecHasta, 
				  fecReqDesde, 
				  fecReqHasta, 
				  null , 
				  deposito, 
				  solicitarA, 
				  producto, this.getSesion()).iterator();
	  
	  IDataSet ds = this.getDSPedDepoPendEnvio();
	  while (iterPedPendDeEnvio.hasNext()) {
		  PedMercDepoDet pedMercDepoDet = (PedMercDepoDet) iterPedPendDeEnvio.next();
		  cargarRegistro(ds, pedMercDepoDet);
	  }
	  writeCliente(ds);
	  
	  
	  
  }

  private IDataSet getDSPedDepoPendEnvio() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPedDepoPendEnvio");
    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("emitida_por", Field.STRING, 100));
    dataset.fieldDef(new Field("solicitada_a", Field.STRING, 100));
    dataset.fieldDef(new Field("entregar_en", Field.STRING, 100));
    dataset.fieldDef(new Field("obs_pedido", Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("obs_producto", Field.MEMO, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cod_um", Field.STRING, 20));
    dataset.fieldDef(new Field("fec_requerido", Field.DATE, 0));
    dataset.fieldDef(new Field("cant_enviada", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_pend_envio", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                              PedMercDepoDet pedMercDet) throws BaseException {
  	
      dataset.append();
      dataset.fieldValue("oid_ped_det", pedMercDet.getOIDInteger());
      dataset.fieldValue("oid_cco_ped", pedMercDet.getPedido_mercaderia().getOIDInteger());
      dataset.fieldValue("comprobante", pedMercDet.getPedido_mercaderia().getCodigo());
      dataset.fieldValue("fec_emision", pedMercDet.getPedido_mercaderia().getEmision());
      dataset.fieldValue("emitida_por", pedMercDet.getPedido_mercaderia().getUsuario().getApellidoyNombre());
      dataset.fieldValue("solicitada_a", pedMercDet.getPedido_mercaderia().getSolicitar_a().getDescripcion());
      dataset.fieldValue("entregar_en", pedMercDet.getPedido_mercaderia().getDeposito_entrega().getDescripcion());
      dataset.fieldValue("obs_pedido", pedMercDet.getPedido_mercaderia().getComentario());
      dataset.fieldValue("oid_producto", pedMercDet.getProducto().getOIDInteger());
      dataset.fieldValue("cod_producto", pedMercDet.getProducto().getCodigo());
      dataset.fieldValue("desc_producto", pedMercDet.getProducto().getDescripcion());
      dataset.fieldValue("obs_producto", pedMercDet.getObservacion());
      dataset.fieldValue("cantidad", pedMercDet.getCantidad());
      dataset.fieldValue("cod_um", pedMercDet.getUnidad_medida().getCodigo());
      dataset.fieldValue("fec_requerido", pedMercDet.getFec_necesidad());
      dataset.fieldValue("cant_enviada", pedMercDet.getCantEnviada());
      dataset.fieldValue("cant_pend_envio", pedMercDet.getCantPendEnvio());
    
  }  
  
}
