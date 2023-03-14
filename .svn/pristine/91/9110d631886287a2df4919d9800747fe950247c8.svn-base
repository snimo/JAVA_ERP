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

public class TraerConfGenMasProd extends Operation { 

	int oid = 0;
	
  public TraerConfGenMasProd() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet datasetConfGenMasProd = getDataSetConfGenMasProd();
  	
  	Iterator iterClasif = 
  		Producto.getClasificadoresEntidad(this.getSesion()).iterator();
  	while (iterClasif.hasNext()) {
  		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasif.next();
  		ConfGenMasProd confgenmasprod = 
  			ConfGenMasProd.getConfGenMasProd(clasifEnt,this.getSesion());
      if (confgenmasprod != null)  
        cargarRegistroConfGenMasProd(datasetConfGenMasProd, 
                         confgenmasprod.getOIDInteger(),
                         confgenmasprod.getClasificador(),
                         confgenmasprod.isIncluir_codigo(),
                         confgenmasprod.getOrden_codigo(),
                         confgenmasprod.getPre_codigo(),
                         confgenmasprod.getSuf_codigo(),
                         confgenmasprod.isIncluir_desc(),
                         confgenmasprod.getOrden_desc(),
                         confgenmasprod.getPre_desc(),
                         confgenmasprod.getSuf_desc(),
                         confgenmasprod.isIncluir_sino(),
                         confgenmasprod.getOrden_sino(),
                         confgenmasprod.getPre_sino(),
                         confgenmasprod.getSuf_sino(),
                         confgenmasprod.isIncluir_barra(),
                         confgenmasprod.getOrden_barra(),
                         confgenmasprod.getPre_barra(),
                         confgenmasprod.getSuf_barra());
        else
          cargarRegistroConfGenMasProd(datasetConfGenMasProd, 
              new Integer(--oid),
              clasifEnt,
              new Boolean(false),
              new Integer(0),
              new String(""),
              new String(""),
              new Boolean(false),
              new Integer(0),
              "",
              "",
              new Boolean(false),
              new Integer(0),
              "",
              "",
              new Boolean(false),
              new Integer(0),
              "",
              "");
  		
  	}
  	
  	writeCliente(datasetConfGenMasProd);
  	
  }

  private IDataSet getDataSetConfGenMasProd() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConfGenMasProd");
    dataset.fieldDef(new Field("oid_gen_masiva", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));
    dataset.fieldDef(new Field("incluir_codigo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden_codigo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("pre_codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("suf_codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("incluir_desc", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden_desc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("pre_desc", Field.STRING, 50)); 
    dataset.fieldDef(new Field("suf_desc", Field.STRING, 50)); 
    dataset.fieldDef(new Field("incluir_sino", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden_sino", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("pre_sino", Field.STRING, 50)); 
    dataset.fieldDef(new Field("suf_sino", Field.STRING, 50)); 
    dataset.fieldDef(new Field("incluir_barra", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden_barra", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("pre_barra", Field.STRING, 50)); 
    dataset.fieldDef(new Field("suf_barra", Field.STRING, 50)); 
    return dataset;
  }

  private void cargarRegistroConfGenMasProd(IDataSet dataset, 
                         Integer oid_gen_masiva,
                         ClasificadorEntidad clasificador,
                         Boolean incluir_codigo,
                         Integer orden_codigo,
                         String pre_codigo,
                         String suf_codigo,
                         Boolean incluir_desc,
                         Integer orden_desc,
                         String pre_desc,
                         String suf_desc,
                         Boolean incluir_sino,
                         Integer orden_sino,
                         String pre_sino,
                         String suf_sino,
                         Boolean incluir_barra,
                         Integer orden_barra,
                         String pre_barra,
                         String suf_barra) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_gen_masiva", oid_gen_masiva);
    dataset.fieldValue("oid_clasificador", clasificador.getOIDInteger());
    dataset.fieldValue("desc_clasificador", clasificador.getDescripcion());
    dataset.fieldValue("incluir_codigo", incluir_codigo);
    dataset.fieldValue("orden_codigo", orden_codigo);
    dataset.fieldValue("pre_codigo", pre_codigo);
    dataset.fieldValue("suf_codigo", suf_codigo);
    dataset.fieldValue("incluir_desc", incluir_desc);
    dataset.fieldValue("orden_desc", orden_desc);
    dataset.fieldValue("pre_desc", pre_desc);
    dataset.fieldValue("suf_desc", suf_desc);
    dataset.fieldValue("incluir_sino", incluir_sino);
    dataset.fieldValue("orden_sino", orden_sino);
    dataset.fieldValue("pre_sino", pre_sino);
    dataset.fieldValue("suf_sino", suf_sino);
    dataset.fieldValue("incluir_barra", incluir_barra);
    dataset.fieldValue("orden_barra", orden_barra);
    dataset.fieldValue("pre_barra", pre_barra);
    dataset.fieldValue("suf_barra", suf_barra);
  }
}
