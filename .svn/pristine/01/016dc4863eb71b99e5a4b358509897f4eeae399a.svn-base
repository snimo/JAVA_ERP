package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePreciosProdGralLP extends Operation { 
	
  Integer oid = null;

  public SavePreciosProdGralLP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TInput"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
     
    while (!dataset.EOF()) { 
    	
    	  ValorClasifEntProdGen valorClasifEntProdGral = 
    		  ValorClasifEntProdGen.findByOid(dataset.getInteger("oid_prod_gral"), this.getSesion());

    	  oid = valorClasifEntProdGral.getOIDInteger();
    	  
    	  IDataSet dsProd = dataset.getDataSet("TProductosLP");
    	  dsProd.first();
    	  while (!dsProd.EOF()) {
    		  
    		  	// Procesar registro por registro
    		  	ListaPrecios lp = ListaPrecios.findByOid(dsProd.getInteger("oid_lp"), this.getSesion());  
    		  
      			// Actualizacion de la lista de precios
      			PrecioPorEstrucLP lpDet =
      			lp.getPrecioPorClasifArt(valorClasifEntProdGral);
      		
      			if (lpDet == null)
      				lpDet = (PrecioPorEstrucLP) PrecioPorEstrucLP.getNew(PrecioPorEstrucLP.NICKNAME, this.getSesion());
      			lpDet.setLista_precios(lp);
      			lpDet.setValor_clasif_art2(valorClasifEntProdGral);
      			lpDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsProd.getInteger("oid_um_pv"), this.getSesion()));
      			lpDet.setCantidad(dsProd.getDouble("cant_pv"));
      			lpDet.setMoneda(Moneda.findByOidProxy(dsProd.getInteger("oid_moneda_pv"), this.getSesion()));
      			if (lp.isIncluyeIVA())
      				lpDet.setPrecio(dsProd.getDouble("nuevo_precio_vta_con_iva"));
      			else
      				lpDet.setPrecio(dsProd.getDouble("nuevo_precio_vta"));
      			lpDet.setActivo(new Boolean(true));
      			lpDet.setFecUltAct(Fecha.getFechaActual());
      		
      			this.addTransaccion(lpDet);
      			
      			// Esta rentabilidad minima esperada debe fijarse en el ABM de Productos
      			
        		// Actualizacion de Rentabilidad esperada
        		ConfProdGralPorLP confProdPorLP = ConfProdGralPorLP.getConfProdPorLP(valorClasifEntProdGral, lp, this.getSesion());
        		if (confProdPorLP == null)
        			confProdPorLP = (ConfProdGralPorLP ) ConfProdGralPorLP .getNew(ConfProdGralPorLP .NICKNAME, this.getSesion());
        		confProdPorLP.setLista_precios(lp);
        		confProdPorLP.setClasificador(valorClasifEntProdGral.getClasificador_entidad());
        		confProdPorLP.setValor_clasif_ent(valorClasifEntProdGral);
        		confProdPorLP.setPorc_rent_sug(dsProd.getMoney("nuevo_porc_rent"));
        		
        		this.addTransaccion(confProdPorLP);
      			
    		  
    		  
    		  
    		  dsProd.next();
    	  }
    	  
    	  dataset.next();
    	  
    }
    
    if (oid!=null)
    	setRefreshObjNeg(oid);
      
  }
  
}
