package com.srn.erp.ventas.op;

import java.util.Date;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.CostoProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ConfProdPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFormacionPrecioProd extends Operation {
	
  

  public SaveFormacionPrecioProd() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	 
	  
    IDataSet dataset = mapaDatos.getDataSet("TFormacionPrecios");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
    	  
    	ListaPrecios lp = ListaPrecios.findByOid(dataset.getInteger("oid_lp"), this.getSesion());
    	
    	IDataSet dsProdLP = dataset.getDataSet("TProductosLP");
    	dsProdLP.first();
    	while (!dsProdLP.EOF()) {
    		
    		// Actualizacion del Costo
    		
    		Producto producto = Producto.findByOid(dsProdLP.getInteger("oid_producto"), this.getSesion());
    		
    		
    		if ((dsProdLP.getMoney("costo")!=null) &&  (dsProdLP.getMoney("costo").doubleValue()!=0)) {
    			java.util.Date fechaCosto = dsProdLP.getDate("fec_ult_costo");
    			if (fechaCosto == null)
    				fechaCosto = Fecha.getFechaActual();
    			CostoProducto costoProducto = producto.getCostoProductoAFecha(fechaCosto);
    			if (costoProducto == null)
    				costoProducto = (CostoProducto) CostoProducto.getNew(CostoProducto.NICKNAME, this.getSesion());
    			costoProducto.setProducto(producto);
    			costoProducto.setFec_ult_costo(fechaCosto);
    			costoProducto.setMoneda(Moneda.findByOidProxy(dsProdLP.getInteger("oid_moneda_costo"), this.getSesion()));
    			costoProducto.setCantidad(dsProdLP.getDouble("cant_costo"));
    			costoProducto.setUnidad_medida(UnidadMedida.findByOidProxy(dsProdLP.getInteger("oid_um_costo"), this.getSesion()));
    			costoProducto.setCosto(dsProdLP.getMoney("costo"));
    			costoProducto.setActivo(new Boolean(true));
    			this.addTransaccion(costoProducto);
    		}
    		
    		
    		
    		// Actualizacion del Precio de Venta
    		ListaPreciosDet lpDet =
    			lp.getListaPreciosDet(producto);
    		
    		if (lpDet == null)
    			lpDet = (ListaPreciosDet) ListaPrecios.getNew(ListaPreciosDet.NICKNAME, this.getSesion());
    		lpDet.setLista_precio(lp);
    		lpDet.setProducto(producto);
    		lpDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsProdLP.getInteger("oid_um_pv"), this.getSesion()));
    		lpDet.setCantidad(dsProdLP.getDouble("cant_pv"));
    		lpDet.setMoneda(Moneda.findByOidProxy(dsProdLP.getInteger("oid_moneda_pv"), this.getSesion()));
    		lpDet.setPrecio(dsProdLP.getMoney("nuevo_precio_vta"));
    		lpDet.setActivo(new Boolean(true));
    		lpDet.setFecUltAct(Fecha.getFechaActual());
    		
    		this.addTransaccion(lpDet);
    		
    		
    		// Actualizacion de Rentabilidad esperada
    		ConfProdPorLP confProdPorLP = ConfProdPorLP.getConfProdLP(producto, lp, this.getSesion());
    		if (confProdPorLP == null)
    			confProdPorLP = (ConfProdPorLP) ConfProdPorLP.getNew(ConfProdPorLP.NICKNAME, this.getSesion());
    		confProdPorLP.setLista_precios(lp);
    		confProdPorLP.setProducto(producto);
    		confProdPorLP.setPorc_rent_sug(dsProdLP.getDouble("nuevo_porc_rent"));
    		
    		this.addTransaccion(confProdPorLP);
    		
    		dsProdLP.next();	
    	}
    	  
        dataset.next();
    }
  }
  

}
