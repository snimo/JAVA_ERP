package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePreciosPorEstrucLP extends Operation { 

  public SavePreciosPorEstrucLP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsListaPrecios = mapaDatos.getDataSet("TListaPrecios");
  	dsListaPrecios.first();
  	while (!dsListaPrecios.EOF()) {
  		procesarRegistros(dsListaPrecios.getDataSet("TPrecioPorEstrucLP"));
  		dsListaPrecios.next();
  	}
  	
  	
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) {
      	
      	
      	ListaPrecios listaPrecio = 
      		ListaPrecios.findByOidProxy(dataset.getInteger("oid_precio_cab"),this.getSesion());
      	
      	ValorClasificadorEntidad valClasifEnt2	= 
      		ValorClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_art_2"),this.getSesion());
      	
      	PrecioPorEstrucLP precioporestruclp =
      		PrecioPorEstrucLP.getPrecioEstrucLPBYClasificadores(listaPrecio,valClasifEnt2,this.getSesion());
      	
      	if (precioporestruclp == null)
      		precioporestruclp = 
      			(PrecioPorEstrucLP) PrecioPorEstrucLP.getNew(PrecioPorEstrucLP.NICKNAME,this.getSesion()); 
      	
        precioporestruclp.setOID(dataset.getInteger("oid_precio_est"));
        precioporestruclp.setLista_precios(ListaPrecios.findByOidProxy(dataset.getInteger("oid_precio_cab"),this.getSesion()));
        precioporestruclp.setUnidad_medida(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um"),this.getSesion()));
        precioporestruclp.setCantidad(dataset.getDouble("cantidad"));
        precioporestruclp.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),this.getSesion()));
        precioporestruclp.setPrecio(dataset.getDouble("precio"));
        //precioporestruclp.setValor_clasif_art1(ValorClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_art_1"),this.getSesion()));
        precioporestruclp.setValor_clasif_art2(ValorClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_art_2"),this.getSesion()));
        precioporestruclp.setActivo(dataset.getBoolean("activo"));
        
        addTransaccion(precioporestruclp);
        dataset.next();
    }
  }
  
}
