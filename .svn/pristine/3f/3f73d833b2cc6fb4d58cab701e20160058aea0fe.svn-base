package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ConfGenMasProd;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerClasifGenProd extends Operation { 

  public TraerClasifGenProd() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	IDataSet dsClasif = this.getDSGenProdClasif();
  	Iterator iterClasifProd = 
  		Producto.getClasificadoresEntidad(this.getSesion()).iterator();
  	while (iterClasifProd.hasNext()) {
  		ClasificadorEntidad clasificador = (ClasificadorEntidad) iterClasifProd.next();
  		cargarGenProdClasif(dsClasif,clasificador);
  	}
  	
  	writeCliente(dsClasif);
  }

  private IDataSet getDSGenProdClasif() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGenProdClasif");
    dataset.fieldDef(new Field("oid_clasif_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_clasif_prod", Field.STRING, 100));
    dataset.fieldDef(new Field("incluir_codigo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden_incluir_codigo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("incluir_descripcion", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden_incluir_descripcion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("prefijo_codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("sufijo_codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("prefijo_descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("sufijo_descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("incluir_codigo_barra", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden_codigo_barra", Field.INTEGER, 0));
    dataset.fieldDef(new Field("prefijo_codigo_barra", Field.STRING, 50));
    dataset.fieldDef(new Field("sufijo_codigo_barra", Field.STRING, 50));
    dataset.fieldDef(new Field("incluir_sinonimo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden_sinonimo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("prefijo_sinonimo", Field.STRING, 50));
    dataset.fieldDef(new Field("sufijo_sinonimo", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nickname", Field.STRING, 50));
    return dataset;
  }

  private void cargarGenProdClasif(IDataSet dataset, 
                                   ClasificadorEntidad clasificador) throws BaseException {
  	
  	ConfGenMasProd confGen = 
  		ConfGenMasProd.getConfGenMasProd(clasificador,this.getSesion());
  	
  	if (confGen!=null) {
      dataset.append();
      dataset.fieldValue("oid_clasif_prod", clasificador.getOIDInteger());
      dataset.fieldValue("desc_clasif_prod", clasificador.getDescripcion());
      dataset.fieldValue("incluir_codigo", confGen.isIncluir_codigo());
      dataset.fieldValue("orden_incluir_codigo", confGen.getOrden_codigo());
      dataset.fieldValue("incluir_descripcion", confGen.isIncluir_desc());
      dataset.fieldValue("orden_incluir_descripcion", confGen.getOrden_desc());
      dataset.fieldValue("prefijo_codigo", confGen.getPre_codigo());
      dataset.fieldValue("sufijo_codigo", confGen.getSuf_codigo());
      dataset.fieldValue("prefijo_descripcion", confGen.getPre_desc());
      dataset.fieldValue("sufijo_descripcion", confGen.getSuf_desc());
      dataset.fieldValue("incluir_codigo_barra", confGen.isIncluir_barra());
      dataset.fieldValue("orden_codigo_barra", confGen.getOrden_barra());
      dataset.fieldValue("prefijo_codigo_barra", confGen.getPre_barra());
      dataset.fieldValue("sufijo_codigo_barra", confGen.getSuf_barra());
      dataset.fieldValue("incluir_sinonimo",confGen.isIncluir_sino());
      dataset.fieldValue("orden_sinonimo", confGen.getOrden_sino());
      dataset.fieldValue("prefijo_sinonimo", confGen.getPre_sino());
      dataset.fieldValue("sufijo_sinonimo", confGen.getSuf_sino());
      dataset.fieldValue("nro_clasif", clasificador.getNroClasif());
      dataset.fieldValue("nickname", clasificador.getNickname());
      
  	} else {
      dataset.append();
      dataset.fieldValue("oid_clasif_prod", clasificador.getOIDInteger());
      dataset.fieldValue("desc_clasif_prod", clasificador.getDescripcion());
      dataset.fieldValue("incluir_codigo", new Boolean(false));
      dataset.fieldValue("orden_incluir_codigo", 0);
      dataset.fieldValue("incluir_descripcion", new Boolean(false));
      dataset.fieldValue("orden_incluir_descripcion", 0);
      dataset.fieldValue("prefijo_codigo", "");
      dataset.fieldValue("sufijo_codigo", "");
      dataset.fieldValue("prefijo_descripcion", "");
      dataset.fieldValue("sufijo_descripcion", "");
      dataset.fieldValue("incluir_codigo_barra", new Boolean(false));
      dataset.fieldValue("orden_codigo_barra", new Integer(0));
      dataset.fieldValue("prefijo_codigo_barra", "");
      dataset.fieldValue("sufijo_codigo_barra", "");
      dataset.fieldValue("incluir_sinonimo",new Boolean(false));
      dataset.fieldValue("orden_sinonimo", new Integer(0));
      dataset.fieldValue("prefijo_sinonimo", "");
      dataset.fieldValue("sufijo_sinonimo", "");
      dataset.fieldValue("nro_clasif", clasificador.getNroClasif());
      dataset.fieldValue("nickname", clasificador.getNickname());
  	}
    
  }  
  
}
