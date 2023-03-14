package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.RequisicionDetAutorizacion;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRequisicion extends Operation { 

  RequisicionCab requisicioncab = null;
	
  public SaveRequisicion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRequisicionCab"); 
    procesarRequisicion(dataset); 
  } 

  private void procesarRequisicion(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        requisicioncab = RequisicionCab.findByOid(dataset.getInteger("oid_cco_requi"),getSesion());
        requisicioncab.setOID(dataset.getInteger("oid_cco_requi"));
        
        requisicioncab.setActivo(dataset.getBoolean("activo"));
        if (!requisicioncab.isActivo()) {
        	requisicioncab.delete();
        	this.addTransaccion(requisicioncab);
        	return;
        }
                
        
        // Set datos del comrobante
        requisicioncab.setContabiliza(false);
        requisicioncab.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        requisicioncab.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        requisicioncab.setLetra(dataset.getString("letra"));
        requisicioncab.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        requisicioncab.setNroext(dataset.getInteger("nro_ext"));
        requisicioncab.setEmision(dataset.getDate("fec_emision"));
        requisicioncab.setComentario(dataset.getString("comentario"));
        
        
        requisicioncab.setUsuario(Usuario.findByOidProxy(dataset.getInteger("oid_usuario"),getSesion()));
        requisicioncab.setSectorCompra(SectorCompra.findByOidProxy(dataset.getInteger("oid_sector_compra"),getSesion()));
        
        
        IDataSet dsRequisicionDet = dataset.getDataSet("TRequisicionDet");
        dsRequisicionDet.first();
        while (!dsRequisicionDet.EOF()) {
        	RequisicionDet requisicionDet = RequisicionDet.findByOid(dsRequisicionDet.getInteger("oid_req_det"),getSesion());
        	requisicionDet.setRequisicion(requisicioncab);
        	requisicionDet.setProducto(Producto.findByOidProxy(dsRequisicionDet.getInteger("oid_producto"),getSesion()));
        	requisicionDet.setDesc_adic_sku(dsRequisicionDet.getString("desc_adic_sku"));
        	requisicionDet.setRenglon(dsRequisicionDet.getInteger("nro_renglon"));
        	requisicionDet.setCant_solicitada(dsRequisicionDet.getDouble("cant_solicitada"));
        	requisicionDet.setUnidad_medida_req(UnidadMedida.findByOidProxy(dsRequisicionDet.getInteger("oid_um_req"),getSesion()));
        	requisicionDet.setFec_emision(requisicioncab.getEmision());
        	requisicionDet.setFec_requerida(dsRequisicionDet.getDate("fec_requerida"));
        	requisicionDet.setDecision_autoriz(RequisicionDetAutorizacion.PEND_AUTORIZ); // Este valor debe obtener en forma logica dentro de la clase Requisicion Cab
        	requisicionDet.setSolo_cotizar(dsRequisicionDet.getBoolean("solo_cotizar"));
        	requisicionDet.setComentario(dsRequisicionDet.getString("comentario"));
        	requisicionDet.setProveedor(Proveedor.findByOidProxy(dsRequisicionDet.getInteger("oid_proveedor"),getSesion()));
        	requisicionDet.setPend_sol_cotiz(new Boolean(false)); // Tambien hay que procesarlo dentro de la clase
        	
        	requisicionDet.setOidComproRef(dsRequisicionDet.getInteger("oid_cco_ref"));
        	requisicionDet.setOidComproRefDet(dsRequisicionDet.getInteger("oid_cco_ref_det"));
        	requisicionDet.setNickNameTipoComproRef(dsRequisicionDet.getString("nickname_compro_ref"));
        	
        	requisicionDet.marcarSiEstaPendCompra();
        	requisicioncab.addRequisicionDet(requisicionDet);
        	dsRequisicionDet.next();
        	
        }
        
        
        addTransaccion(requisicioncab);
        dataset.next();
    }
  }
  
  protected void afterSave() throws BaseException {
	  if (requisicioncab!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
        requisicioncab.getOIDInteger(),
        requisicioncab.getDescripcion());
        
        writeCliente(infoCompro.getDataSetInfoCompro());
	  }

  }  
  
}
