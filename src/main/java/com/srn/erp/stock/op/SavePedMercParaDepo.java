package com.srn.erp.stock.op;

import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PedMercDep;
import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SolicitarAPedMerc;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePedMercParaDepo extends Operation { 

  PedMercDep pedidoMercaderia = null;
	
  public SavePedMercParaDepo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPedidoDepositoCab"); 
    procesarRequisicion(dataset); 
  } 

  private void procesarRequisicion(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        pedidoMercaderia = PedMercDep.findByOid(dataset.getInteger("oid_ped_depo"),getSesion());
        pedidoMercaderia.setActivo(dataset.getBoolean("activo"));
        if ((!pedidoMercaderia.isNew()) &&
            !pedidoMercaderia.isActivo()) {
        	pedidoMercaderia.delete();
        	this.addTransaccion(pedidoMercaderia);
        	return;
        }
                
        // Set datos del comrobante
        pedidoMercaderia.setContabiliza(false);
        pedidoMercaderia.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        pedidoMercaderia.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        pedidoMercaderia.setLetra(dataset.getString("letra"));
        pedidoMercaderia.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        pedidoMercaderia.setNroext(dataset.getInteger("nro_ext"));
        pedidoMercaderia.setEmision(dataset.getDate("fec_emision"));
        pedidoMercaderia.setComentario(dataset.getString("comentario"));
        pedidoMercaderia.setUsuario(Usuario.findByOidProxy(dataset.getInteger("oid_usuario"),getSesion()));
        pedidoMercaderia.setDeposito_entrega(Deposito.findByOidProxy(dataset.getInteger("oid_deposito"),getSesion()));
        pedidoMercaderia.setSolicitar_a(SolicitarAPedMerc.findByOidProxy(dataset.getInteger("oid_solicitar_a"),getSesion()));
        
        
        IDataSet dsPedMercDet = dataset.getDataSet("TPedidoDepositoDet");
        dsPedMercDet.first();
        while (!dsPedMercDet.EOF()) {
        	PedMercDepoDet pedMercDepoDet = PedMercDepoDet.findByOid(dsPedMercDet.getInteger("oid_ped_depo_det"),getSesion());
        	pedMercDepoDet.setPedido_mercaderia(pedidoMercaderia);
        	pedMercDepoDet.setProducto(Producto.findByOidProxy(dsPedMercDet.getInteger("oid_producto"),getSesion()));
        	pedMercDepoDet.setObservacion(dsPedMercDet.getString("desc_adic_sku"));
        	pedMercDepoDet.setCantidad(dsPedMercDet.getDouble("cant_solicitada"));
        	pedMercDepoDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsPedMercDet.getInteger("oid_um_req"),getSesion()));
        	pedMercDepoDet.setFec_necesidad(dsPedMercDet.getDate("fec_requerida"));
        	pedMercDepoDet.setPedido(PedidoCab.findByOidProxy(dsPedMercDet.getInteger("oid_cco_ref"),getSesion()));
        	pedMercDepoDet.setPedido_det(PedidoDet.findByOidProxy(dsPedMercDet.getInteger("oid_cco_ref_det"),getSesion()));
        	pedMercDepoDet.setActivo(!dsPedMercDet.getBoolean("anulada"));
        	
        	pedidoMercaderia.addDetalle(pedMercDepoDet);
        	
        	dsPedMercDet.next();
        	
        }
        
        
        addTransaccion(pedidoMercaderia);
        dataset.next();
    }
  }
  
  protected void afterSave() throws BaseException {
	  if (pedidoMercaderia!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
        		pedidoMercaderia.getOIDInteger(),
        		pedidoMercaderia.getDescripcion());
        
        writeCliente(infoCompro.getDataSetInfoCompro());
	  }

  }  
  
}
