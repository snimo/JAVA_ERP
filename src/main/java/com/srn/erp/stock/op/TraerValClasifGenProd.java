package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValClasifGenProd extends Operation { 

  public TraerValClasifGenProd() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	IDataSet dsValClasif = this.getDSGenProdValClasif();
  	Iterator iterClasifProd = 
  		Producto.getClasificadoresEntidad(this.getSesion()).iterator();
  	while (iterClasifProd.hasNext()) {
  		ClasificadorEntidad clasificador = (ClasificadorEntidad) iterClasifProd.next();
  		
  		Iterator iterValClasif = clasificador.getValoresClasificador().iterator();
  		while (iterValClasif.hasNext()) {
  			ValorClasificadorEntidad valClasifEnt = 
  				(ValorClasificadorEntidad) iterValClasif.next();
  			cargarGenProdValClasif(dsValClasif,new Boolean(false),clasificador,valClasifEnt);	
  		}
  		
  		
  	}
  	
  	writeCliente(dsValClasif);
  }

  private IDataSet getDSGenProdValClasif() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGenProdValClasif");
    dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_clasif_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_val_clasif", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_val_clasif", Field.STRING, 255));
    dataset.fieldDef(new Field("sug_codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("sug_descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("sug_desc_abrev", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_relacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_relacion_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("sug_cod_barra", Field.STRING, 50));
    dataset.fieldDef(new Field("sug_sinonimo", Field.STRING, 50));
    return dataset;
  }

  private void cargarGenProdValClasif(IDataSet dataset, 
                                      Boolean sel,
                                      ClasificadorEntidad clasif,
                                      ValorClasificadorEntidad valClasifEnt) throws BaseException {
    dataset.append();
    dataset.fieldValue("sel", sel);
    dataset.fieldValue("oid_clasif_prod", clasif.getOIDInteger());
    dataset.fieldValue("oid_val_clasif", valClasifEnt.getOIDInteger());
    dataset.fieldValue("cod_val_clasif", valClasifEnt.getCodigo());
    dataset.fieldValue("desc_val_clasif", valClasifEnt.getDescripcion());
    dataset.fieldValue("sug_codigo", valClasifEnt.getCodigo());
    dataset.fieldValue("sug_descripcion", valClasifEnt.getDescripcion());
    dataset.fieldValue("sug_desc_abrev", valClasifEnt.getDescripcion());
    dataset.fieldValue("oid_relacion", valClasifEnt.getOid_item());
    dataset.fieldValue("oid_relacion_padre", valClasifEnt.getOid_item_padre());
    dataset.fieldValue("sug_cod_barra", "");
    dataset.fieldValue("sug_sinonimo", "");
  }  
  
}
