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

public class TraerHelpValoresCompoReal extends Operation { 

  public TraerHelpValoresCompoReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet datasetValorCompoReal = getDataSetValorCompoReal();
    
    CompoPresupuestario compoPresu = 
    	CompoPresupuestario.findByOid(mapaDatos.getInteger("oid_compo_presu"),this.getSesion());
    
    String codigo = null;
    if (mapaDatos.containsKey("codigo"))
    	codigo = (String) mapaDatos.getString("codigo");
    
    String descripcion = null;
    if (mapaDatos.containsKey("descripcion"))
    	codigo = (String) mapaDatos.getString("descripcion");
    
    
    Iterator iterValorCompoReal = 
    	 ValorCompoReal.getValoresRealesByCompoPresuCodDesc(compoPresu,
    			                                                codigo,
    			                                                descripcion,
    			                                                this.getSesion()).iterator();
    while (iterValorCompoReal.hasNext()) {
    	ValorCompoReal valCompoReal = (ValorCompoReal) iterValorCompoReal.next();
    	if (!valCompoReal.isActivo().booleanValue()) continue;
    	cargarRegistroValorCompoReal(datasetValorCompoReal,valCompoReal);
    }
    
    writeCliente(datasetValorCompoReal);
  }

  private IDataSet getDataSetValorCompoReal() {
  	
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresCompoReal");
    dataset.fieldDef(new Field("oid_val_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("nro_relacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_relacion_padre", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    
    
    return dataset;
  }

  private void cargarRegistroValorCompoReal(IDataSet dataset, 
                         										ValorCompoReal valorCompoReal) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_val_compo", valorCompoReal.getOIDInteger());
    dataset.fieldValue("oid_compo_presu", valorCompoReal.getCompo_presu().getOIDInteger());
    dataset.fieldValue("codigo", valorCompoReal.getCodigo());
    dataset.fieldValue("descripcion", valorCompoReal.getDescripcion());
    dataset.fieldValue("nro_relacion", valorCompoReal.getOIDInteger());
    dataset.fieldValue("nro_relacion_padre", new Integer(0));
    dataset.fieldValue("activo", valorCompoReal.isActivo());
    
    
  }
}
