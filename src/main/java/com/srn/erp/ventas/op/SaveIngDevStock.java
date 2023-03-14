package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.IngStockDevVtasDet;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveIngDevStock extends Operation {
	
	IngresoDevolucionStockCab ingresoStockDevolucion = null;	

	public SaveIngDevStock() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
	  
		IDataSet dataset = mapaDatos.getDataSet("TDevolucionCab");
		procesarRegistros(dataset,mapaDatos);
	}

	private void procesarRegistros(IDataSet dataset,MapDatos mapaDatos) throws BaseException {

	  dataset.first();
      while (!dataset.EOF()) {
    	  
    	ingresoStockDevolucion = IngresoDevolucionStockCab.findByOid(dataset.getInteger("oid_devolucion_cab"),getSesion());
    	
    	// Analizar si se trata de una Anulacion
		if ((ingresoStockDevolucion.isNew()==false) && 
				(ingresoStockDevolucion.isActivo().booleanValue()) && 
				(dataset.getBoolean("activo").booleanValue()==false)) {
			ingresoStockDevolucion.delete();
			this.addTransaccion(ingresoStockDevolucion);
			return;
		}    	
    	
    	// Datos principales de la cabecera
    	Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
    	if (talonario==null)
    		throw new ExceptionValidation(null,"Debe seleccionar un talonario");
    	ingresoStockDevolucion.setTalonario(talonario);
    	ingresoStockDevolucion.setContabiliza(false);
    	ingresoStockDevolucion.setEmision(dataset.getDate("fecha"));
    	ingresoStockDevolucion.setImputac(dataset.getDate("fecha"));
    	ingresoStockDevolucion.setTipoCompro(talonario.getTipo_comprobante());
    	ingresoStockDevolucion.setLetra(talonario.getLetra());
    	ingresoStockDevolucion.setLugarEmision(talonario.getLugar_emision());
    	ingresoStockDevolucion.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	ingresoStockDevolucion.setComentario(dataset.getString("comentario"));
    	ingresoStockDevolucion.setActuStock(true);
    	
    	// Datos Particulares
    	Talonario talonarioOrigen = Talonario.findByOidProxy(dataset.getInteger("oid_talonario_origen"),getSesion());
    	ingresoStockDevolucion.setTalonarioOrigen(talonarioOrigen);
    	
    	IDataSet dsDevVtasDet = dataset.getDataSet("TDevolucionDet");
    	dsDevVtasDet.first();
    	while (!dsDevVtasDet.EOF()) {
    		IngStockDevVtasDet ingDevVtasDet = (IngStockDevVtasDet) 
    			IngStockDevVtasDet.getNew(IngStockDevVtasDet.NICKNAME, this.getSesion());
    		ingDevVtasDet.setIngresodevolucionstockcab(ingresoStockDevolucion);
    		DevolucionVtasDet devVtasDet = DevolucionVtasDet.findByOidProxy(dsDevVtasDet.getInteger("oid_dev_det_ori"), this.getSesion());
    		ingDevVtasDet.setDevolucion_det(devVtasDet);
    		
    		TipoConfMovStkTalonario tipoConfMovStok =
    			TipoConfMovStkTalonario.findByOidProxy(dsDevVtasDet.getInteger("oid_mov_stock"), this.getSesion());
    		if (tipoConfMovStok==null) continue;
    		ingDevVtasDet.setMovimiento_stock(tipoConfMovStok);
    		ingDevVtasDet.setCantidad(dsDevVtasDet.getDouble("cantidad"));
    		ingDevVtasDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsDevVtasDet.getInteger("oid_um"), this.getSesion()));
    		
    		
    		ingresoStockDevolucion.addDetalleDev(ingDevVtasDet);
    		    		
    		dsDevVtasDet.next();
    	}
    	
    	addTransaccion(ingresoStockDevolucion);
        dataset.next();
    }
      
  }
  
  protected void afterSave() throws BaseException {

  	  if (ingresoStockDevolucion!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
        		ingresoStockDevolucion.getOIDInteger(),
        		ingresoStockDevolucion.getDescripcion());

        writeCliente(infoCompro.getDataSetInfoCompro());
  	  }

  }
  
  
    

}
