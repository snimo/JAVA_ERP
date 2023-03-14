package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoReal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresCompoReales extends Operation { 

  public TraerValoresCompoReales() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

  	
  	CompoPresupuestario compoPresu = 
  		CompoPresupuestario.findByOid(mapaDatos.getInteger("oid_compo_presu"),this.getSesion());
  	
  	IDataSet dsValCompoReal = this.getDataSetValorCompoReal();
  	
  	Iterator iterValReales = 
  		ValorCompoReal.getValoresRealesByCompoPresu(compoPresu,this.getSesion()).iterator();
  	while (iterValReales.hasNext()) {
  		ValorCompoReal valorCompoReal = 
  			(ValorCompoReal) iterValReales.next();
  		cargarRegistroValorCompoReal(dsValCompoReal,valorCompoReal);
  			
  	}
  	
  	writeCliente(dsValCompoReal);
  	
  }

  private IDataSet getDataSetValorCompoReal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValorCompoReal");
    dataset.fieldDef(new Field("oid_valor_real", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_valor_compo_presu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_valor_compo_presu", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_valor_compo_presu", Field.STRING, 255));
    return dataset;
  }

  private void cargarRegistroValorCompoReal(IDataSet dataset, 
                         ValorCompoReal valorCompoReal) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_valor_real", valorCompoReal.getOIDInteger());
    dataset.fieldValue("codigo", valorCompoReal.getCodigo());
    dataset.fieldValue("descripcion", valorCompoReal.getDescripcion());
    dataset.fieldValue("oid_compo_presu", valorCompoReal.getCompo_presu().getOIDInteger());
    dataset.fieldValue("activo", valorCompoReal.isActivo());
    if (valorCompoReal.getValorCompoPresu()!=null) {
      dataset.fieldValue("oid_valor_compo_presu", valorCompoReal.getValorCompoPresu().getOIDInteger());
      dataset.fieldValue("cod_valor_compo_presu", valorCompoReal.getValorCompoPresu().getCodigo());
      dataset.fieldValue("desc_valor_compo_presu", valorCompoReal.getValorCompoPresu().getDescripcion());
    } else {
      dataset.fieldValue("oid_valor_compo_presu", 0);
      dataset.fieldValue("cod_valor_compo_presu", "");
      dataset.fieldValue("desc_valor_compo_presu", "");
    }
    
    
  }
}
