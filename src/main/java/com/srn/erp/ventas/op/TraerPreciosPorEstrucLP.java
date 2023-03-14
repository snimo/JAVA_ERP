package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioPorEstrucLP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPreciosPorEstrucLP extends Operation {
	
  private ClasificadorEntidad clasifTitLP  = null;	

  public TraerPreciosPorEstrucLP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
    ListaPrecios listaPrecios = null;
    clasifTitLP = ClasificadorEntidad.getClasifTitulosLPProdGral(this.getSesion());
    
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       listaPrecios = ListaPrecios.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       listaPrecios = ListaPrecios.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetListaPrecios = this.getDataSetLP();
    IDataSet datasetPrecioPorEstrucLP = getDataSetPrecioPorEstrucLP();
    
    cargarRegistroListaPrecio(datasetListaPrecios,listaPrecios);
    
    Iterator iterPrecioEstrucClasifArt = listaPrecios.getPreciosClasifArtPorLP(null).iterator();
    while (iterPrecioEstrucClasifArt.hasNext()) {
    	PrecioPorEstrucLP precioPorEstrucLP = (PrecioPorEstrucLP) iterPrecioEstrucClasifArt.next();
    	cargarRegistroPrecioPorEstrucLP(datasetPrecioPorEstrucLP,precioPorEstrucLP);
    }
    
    int secu=0;
    Iterator iterValClasifEnt = 
    	listaPrecios.getValoresClasifProdGralNotInLP().iterator();
    while (iterValClasifEnt.hasNext()) {
    	
    	ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasifEnt.next();
    	
    	PrecioPorEstrucLP newPrecioEstrucLP = (PrecioPorEstrucLP) PrecioPorEstrucLP.getNew(PrecioPorEstrucLP.NICKNAME,this.getSesion());
    	newPrecioEstrucLP.setActivo(new Boolean(true));
    	newPrecioEstrucLP.setCantidad(new Double(1));
    	newPrecioEstrucLP.setLista_precios(listaPrecios);
    	newPrecioEstrucLP.setMoneda(Moneda.getMonedaCursoLegal(this.getSesion()));
    	newPrecioEstrucLP.setPrecio(new Double(0));
    	newPrecioEstrucLP.setUnidad_medida(ListaPrecios.getUMDefault(this.getSesion()));
    	//newPrecioEstrucLP.setValor_clasif_art1(defEstrucLPDet.getValor_clasif_art_1());
    	newPrecioEstrucLP.setValor_clasif_art2(valClasifEnt);
    	--secu;
    	newPrecioEstrucLP.setOID(new Integer(secu));
    	
    	cargarRegistroPrecioPorEstrucLP(datasetPrecioPorEstrucLP,newPrecioEstrucLP);
    	
    	
    }
    
    
    
    
    writeCliente(datasetListaPrecios);
    writeCliente(datasetPrecioPorEstrucLP);
  }

  private IDataSet getDataSetLP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TListaPrecios");
    dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("fec_vig_desde", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vig_hasta", Field.DATE, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nota", Field.STRING, 255));
    return dataset;
  }
  
  
  private IDataSet getDataSetPrecioPorEstrucLP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPrecioPorEstrucLP");
    dataset.fieldDef(new Field("oid_precio_est", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("precio", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("oid_clasif_art_1", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_clasif_art_1", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_clasif_art_2", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_clasif_art_2", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif_art_2", Field.STRING, 100));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroPrecioPorEstrucLP(IDataSet dataset, 
  									           PrecioPorEstrucLP precioPorEstrucLP)  throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_precio_est", precioPorEstrucLP.getOIDInteger());
    dataset.fieldValue("oid_precio_cab", precioPorEstrucLP.getLista_precios().getOID());
    dataset.fieldValue("oid_um", precioPorEstrucLP.getUnidad_medida().getOIDInteger());
    dataset.fieldValue("cantidad", precioPorEstrucLP.getCantidad());
    dataset.fieldValue("oid_moneda", precioPorEstrucLP.getMoneda().getOIDInteger());
    dataset.fieldValue("precio", precioPorEstrucLP.getPrecio());
    
    
    Integer oidValClasifArt1 = new Integer(0);
    String descValClasifArt1 = "";
    
    ExtensionProdGen extProdGen = ExtensionProdGen.getExtensionProdGral(precioPorEstrucLP.getValor_clasif_art2(), this.getSesion());
    if (extProdGen!=null) {
    	IValorClasificadorEntidad valClasif = extProdGen.getValorClasifEnt(clasifTitLP);
    	if (valClasif!=null) {
    	    oidValClasifArt1 = valClasif.getOID();
    	    descValClasifArt1 = valClasif.getDescripcion();
    	}
    }
    
    dataset.fieldValue("oid_clasif_art_1", oidValClasifArt1);
    dataset.fieldValue("desc_clasif_art_1", descValClasifArt1);
    dataset.fieldValue("oid_clasif_art_2", precioPorEstrucLP.getValor_clasif_art2().getOIDInteger());
    dataset.fieldValue("cod_clasif_art_2", precioPorEstrucLP.getValor_clasif_art2().getCodigo());
    dataset.fieldValue("desc_clasif_art_2", precioPorEstrucLP.getValor_clasif_art2().getDescripcion());
    /*DefEstrucLPDet defEstrucLPDet = 
    	ListaPrecios.getDefEstrucCabLPDefault(this.getSesion()).getDefEstrucLPDet(
    			precioPorEstrucLP.getValor_clasif_art1(),
    			precioPorEstrucLP.getValor_clasif_art2(),this.getSesion());*/
    
    dataset.fieldValue("orden", new Integer(0));
    dataset.fieldValue("activo", precioPorEstrucLP.isActivo());
  }
  
  private void cargarRegistroListaPrecio(IDataSet dataset, 
			 ListaPrecios listaPrecios)  throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_lp", listaPrecios.getOIDInteger()); 
  	dataset.fieldValue("codigo", listaPrecios.getCodigo());
  	dataset.fieldValue("descripcion", listaPrecios.getDescripcion());
  	dataset.fieldValue("fec_vig_desde", listaPrecios.getFec_vig_desde());
  	dataset.fieldValue("fec_vig_hasta", listaPrecios.getFec_vig_hasta());
  	dataset.fieldValue("activo", listaPrecios.isActivo());
  	if (listaPrecios.isIncluyeIVA())
  		dataset.fieldValue("nota", "El precio a ingresar DEBE INCLUIR EL IVA");
  	else
  		dataset.fieldValue("nota", "El precio a ingresar **NO** DEBE INCLUIR EL IVA");
  }
  
  
}
