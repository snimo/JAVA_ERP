package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.MotivoDevolucionCliente;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDevolucionesVtas extends Operation {
	
  DevolucionVtasCab devolucion = null;	

  public SaveDevolucionesVtas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    IDataSet dataset = mapaDatos.getDataSet("TDevolucionCab");
    procesarRegistros(dataset,mapaDatos);
  }

  private void procesarRegistros(IDataSet dataset,MapDatos mapaDatos) throws BaseException {

	  dataset.first();
      while (!dataset.EOF()) {
    	devolucion = DevolucionVtasCab.findByOid(dataset.getInteger("oid_devolucion_cab"),getSesion());
    	
    	
    	// Analizar si se trata de una Anulacion
		if ((devolucion.isNew()==false) && 
				(devolucion.isActivo().booleanValue()) && 
				(dataset.getBoolean("activo").booleanValue()==false)) {
			devolucion.delete();
			this.addTransaccion(devolucion);
			return;
		}    	
    	
    	// Datos principales de la cabecera
    	Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
    	if (talonario==null)
    		throw new ExceptionValidation(null,"Debe seleccionar un talonario");
    	devolucion.setTalonario(talonario);
    	devolucion.setContabiliza(true);
    	devolucion.setEmision(dataset.getDate("fecha"));
    	devolucion.setImputac(dataset.getDate("fecha"));
    	devolucion.setTipoCompro(talonario.getTipo_comprobante());
    	devolucion.setLetra(talonario.getLetra());
    	devolucion.setLugarEmision(talonario.getLugar_emision());
    	devolucion.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	devolucion.setComentario(dataset.getString("comentario"));
    	
    	// Datos Particulares
    	devolucion.setSujeto(Sujeto.findByOidProxy(dataset.getInteger("oid_sujeto"),getSesion()));
    	devolucion.setTipoOperacion(dataset.getString("tipo_oper"));
    	devolucion.setTipoDevolucion(dataset.getString("tipo_devolucion"));
    	devolucion.setFacturaCab(FacturaCab.findByOidProxy(dataset.getInteger("oid_cco_fact"),getSesion()));
    	devolucion.setPedidoCab(PedidoCab.findByOidProxy(dataset.getInteger("oid_cco_ped"),getSesion()));
    	devolucion.setRemitoCab(RemitoCab.findByOidProxy(dataset.getInteger("oid_cco_rto"),getSesion()));
    	
    	IDataSet dsDevVtasDet = dataset.getDataSet("TDevolucionDet");
    	dsDevVtasDet.first();
    	while (!dsDevVtasDet.EOF()) {
    		DevolucionVtasDet devVtasDet = (DevolucionVtasDet) 
    			DevolucionVtasDet.getNew(DevolucionVtasDet.NICKNAME, this.getSesion());
    		devVtasDet.setDevolucion_cab(devolucion);
    		devVtasDet.setProducto(Producto.findByOidProxy(dsDevVtasDet.getInteger("oid_producto"), this.getSesion()));
    		devVtasDet.setMotivo_devolucion(MotivoDevolucionCliente.findByOidProxy(dsDevVtasDet.getInteger("oid_motivo_devolucion"), this.getSesion()));
    		devVtasDet.setObservaciones(dsDevVtasDet.getString("observaciones"));
    		devVtasDet.setPend_emitir_nc(dsDevVtasDet.getBoolean("pend_emitir_nc"));
    		devVtasDet.setModif_precio(dsDevVtasDet.getBoolean("modif_precio"));
    		devVtasDet.setCantidad_devuelta(dsDevVtasDet.getDouble("cant_dev_1"));
    		devVtasDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsDevVtasDet.getInteger("oid_um_dev_1"), this.getSesion()));
    		devVtasDet.setPedido_det(PedidoDet.findByOidProxy(dsDevVtasDet.getInteger("oid_ped_det"), this.getSesion()));
    		devVtasDet.setRemito_det(RemitoDet.findByOidProxy(dsDevVtasDet.getInteger("oid_rto_det"), this.getSesion()));
    		devVtasDet.setFactura_det(FacturaDet.findByOidProxy(dsDevVtasDet.getInteger("oid_fact_det"), this.getSesion()));
    		devVtasDet.setActivo(dsDevVtasDet.getBoolean("activo"));
    		
    		devolucion.addDetalleDev(devVtasDet);
    		    		
    		dsDevVtasDet.next();
    	}
    	
    	
    	
    	addTransaccion(devolucion);
        dataset.next();
    }
  }
  
  protected void afterSave() throws BaseException {

  	  if (devolucion!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
          devolucion.getOIDInteger(),
          devolucion.getDescripcion());

        writeCliente(infoCompro.getDataSetInfoCompro());
  	  }

  }
  
  
    

}
