package com.srn.erp.stock.op;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.InventarioCab;
import com.srn.erp.stock.bm.InventarioDet;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveInventario extends Operation {

	  private InventarioCab inventarioCab = null;
	  private ComproCab informarCompro = null;

	  public SaveInventario() {
	  }

	  public void execute(MapDatos mapaDatos) throws BaseException {
	    IDataSet dataset = mapaDatos.getDataSet("TTomaInventario");
	    procesarRegistros(dataset);
	  }

	  private void procesarRegistros(IDataSet dataset) throws BaseException {
	    dataset.first();
	      while (!dataset.EOF()) {
	        inventarioCab = InventarioCab.findByOid(dataset.getInteger("oid_inventario"),getSesion());
	        
	        if (dataset.getBoolean("activo").booleanValue()==false)	
	        	if (inventarioCab.isActivo().booleanValue()) {
	        		inventarioCab.delete();
	        		this.addTransaccion(inventarioCab);
	        		dataset.next();
	        		continue;
	        	}
	        
	        
	        inventarioCab.setContabiliza(false);
	        
	        Talonario talonario = InventarioCab.getTalonarioInventario(this.getSesion());
	        
	        inventarioCab.setTipoCompro(talonario.getTipo_comprobante());
	        inventarioCab.setLetra(talonario.getLetra());
	        inventarioCab.setLugarEmision(talonario.getLugar_emision());
	        inventarioCab.setNroext(new Integer(0));
	        inventarioCab.setEmision(dataset.getDate("fec_emision"));
	        inventarioCab.setComentario(dataset.getString("observacion"));
	        inventarioCab.setTalonario(talonario);
	        inventarioCab.setActivo(new Boolean(true));
	        inventarioCab.setDeposito(Deposito.findByOidProxy(dataset.getInteger("oid_deposito"),getSesion()));
	        inventarioCab.setFec_inventario(dataset.getDate("fecha_inventario"));
	        inventarioCab.setActuStock(true);
	        
	        // Detalles 
	        IDataSet dsDet = dataset.getDataSet("TDetInventario");
	        dsDet.first();
	        while (!dsDet.EOF()) {
	        	
	          if (dsDet.getDouble("diferencia").doubleValue() == 0) {
	        	  dsDet.next();
	        	  continue;
	          }
	          
	          InventarioDet inventarioDet =
	        	  InventarioDet.findByOid(dsDet.getInteger("oid_det_inventario"),getSesion());
	          inventarioDet.setInventario_cab(inventarioCab);
	          inventarioDet.setProducto(Producto.findByOid(dsDet.getInteger("oid_producto"), this.getSesion()));
	          inventarioDet.setFisico(dsDet.getDouble("fisico"));
	          inventarioDet.setConteo(dsDet.getDouble("conteo"));
	          inventarioDet.setSin_stock(dsDet.getBoolean("sin_stock"));
	          inventarioDet.setAju_stock(dsDet.getDouble("diferencia"));
	          inventarioDet.setObservacion(dsDet.getString("observacion"));
	          inventarioCab.addDetalle(inventarioDet);
	          
	          dsDet.next();
	        }
	        addTransaccion(inventarioCab);
	        dataset.next();
	    }
	  }

	  protected void afterSave() throws BaseException {

	  	
	  	if (inventarioCab!=null)
	  	   informarCompro = inventarioCab;
	  	else 
	  		 return;
	  	
	      InformarComprobante infoCompro = 
	      	new InformarComprobante(
	      			informarCompro.getOIDInteger(),
	      			informarCompro.getDescripcion());

	      writeCliente(infoCompro.getDataSetInfoCompro());

	  }


}
