package com.srn.erp.costos.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCostosProdGral extends Operation {
	
  

  public SaveCostosProdGral() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	 
    IDataSet dataset = mapaDatos.getDataSet("TFormacionPrecios");
    procesarRegistros(dataset);
    
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
    	  
    	IDataSet dsProdLP = dataset.getDataSet("TProductosLP");
    	dsProdLP.first();
    	while (!dsProdLP.EOF()) {
    		
    		// Obtener el Valor del clasificador
    		ValorClasifEntProdGen producto = (ValorClasifEntProdGen) ValorClasifEntProdGen.findByOid(dsProdLP.getInteger("oid_producto"), this.getSesion());
    		
    		
    		if ((dsProdLP.getMoney("costo")!=null) &&  (dsProdLP.getMoney("costo").doubleValue()!=0)) {
    			java.util.Date fechaCosto = dsProdLP.getDate("fec_ult_costo");
    			if (fechaCosto == null)
    				fechaCosto = Fecha.getFechaActual();
    			CostoProductoGral costoProducto = producto.getCostoProductoAFecha(fechaCosto);
    			if (costoProducto == null)
    				costoProducto = (CostoProductoGral) CostoProductoGral.getNew(CostoProductoGral.NICKNAME, this.getSesion());
    			costoProducto.setClasificador(producto.getClasificador_entidad());
    			costoProducto.setVal_clasif_ent(producto);
    			costoProducto.setFec_ult_costo(fechaCosto);
    			costoProducto.setMoneda(Moneda.findByOidProxy(dsProdLP.getInteger("oid_moneda_costo"), this.getSesion()));
    			costoProducto.setCantidad(dsProdLP.getMoney("cant_costo"));
    			costoProducto.setUm(UnidadMedida.findByOidProxy(dsProdLP.getInteger("oid_um_costo"), this.getSesion()));
    			costoProducto.setCosto(dsProdLP.getMoney("costo"));
    			costoProducto.setActivo(dsProdLP.getBoolean("activo"));
    			if (!costoProducto.isActivo())
    				costoProducto.delete();
    			this.addTransaccion(costoProducto);
    		}
    		
    		
    		dsProdLP.next();	
    	}
    	  
        dataset.next();
    }
  }
  

}
