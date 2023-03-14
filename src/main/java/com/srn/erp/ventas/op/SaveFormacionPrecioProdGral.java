package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdGralPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFormacionPrecioProdGral extends Operation {
	
  
	ListaPrecios lp = null;

public SaveFormacionPrecioProdGral() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	 
    IDataSet dataset = mapaDatos.getDataSet("TFormacionPrecios");
    procesarRegistros(dataset);
    
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
    	  
    	lp = ListaPrecios.findByOid(dataset.getInteger("oid_lp"), this.getSesion());
    	setRefreshObjNeg(lp.getOIDInteger());
    	
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
    			costoProducto.setActivo(new Boolean(true));
    			this.addTransaccion(costoProducto);
    		}
    		
    		
    		
    		// Actualizacion de la lista de precios
    		PrecioPorEstrucLP lpDet =
    			lp.getPrecioPorClasifArt(producto);
    		
    		if (lpDet == null)
    			lpDet = (PrecioPorEstrucLP) PrecioPorEstrucLP.getNew(PrecioPorEstrucLP.NICKNAME, this.getSesion());
    		lpDet.setLista_precios(lp);
    		lpDet.setValor_clasif_art2(producto);
    		lpDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsProdLP.getInteger("oid_um_pv"), this.getSesion()));
    		lpDet.setCantidad(dsProdLP.getDouble("cant_pv"));
    		lpDet.setMoneda(Moneda.findByOidProxy(dsProdLP.getInteger("oid_moneda_pv"), this.getSesion()));
    		if (lp.isIncluyeIVA())
    			lpDet.setPrecio(dsProdLP.getDouble("nuevo_precio_vta_con_iva"));
    		else
    			lpDet.setPrecio(dsProdLP.getDouble("nuevo_precio_vta"));
    		lpDet.setActivo(new Boolean(true));
    		lpDet.setFecUltAct(Fecha.getFechaActual());
    		
    		this.addTransaccion(lpDet);
    		
    		
    		// Actualizacion de Rentabilidad esperada
    		ConfProdGralPorLP confProdPorLP = ConfProdGralPorLP.getConfProdPorLP(producto, lp, this.getSesion());
    		if (confProdPorLP == null)
    			confProdPorLP = (ConfProdGralPorLP ) ConfProdGralPorLP .getNew(ConfProdGralPorLP .NICKNAME, this.getSesion());
    		confProdPorLP.setLista_precios(lp);
    		confProdPorLP.setClasificador(producto.getClasificador_entidad());
    		confProdPorLP.setValor_clasif_ent(producto);
    		confProdPorLP.setPorc_rent_sug(dsProdLP.getMoney("nuevo_porc_rent"));
    		
    		this.addTransaccion(confProdPorLP);
    		
    		dsProdLP.next();	
    	}
    	  
        dataset.next();
    }
  }
  
  @Override
	protected void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();
		
		
	}
  
  

}
