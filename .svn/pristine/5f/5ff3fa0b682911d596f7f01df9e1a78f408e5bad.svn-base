package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpValoresCompoPresu extends Operation { 

  public TraerHelpValoresCompoPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet datasetValorCompoPresu = getDataSetValorCompoPresu();
    
    CompoPresupuestario compoPresu = 
    	CompoPresupuestario.findByOid(mapaDatos.getInteger("oid_compo_presu"),this.getSesion());
    
    Iterator iterCompoPresu = ValorCompoPresu.getValoresCompoPresu(compoPresu,this.getSesion()).iterator();
    while (iterCompoPresu.hasNext()) {
    	ValorCompoPresu valCompoPresu = (ValorCompoPresu) iterCompoPresu.next();
    	if (!valCompoPresu.isActivo().booleanValue()) continue;
    	cargarRegistroValorCompoPresu(datasetValorCompoPresu,valCompoPresu);
    }
    
    writeCliente(datasetValorCompoPresu);
  }

  private IDataSet getDataSetValorCompoPresu() {
  	
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresCompoPresu");
    dataset.fieldDef(new Field("oid_val_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("nro_relacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_relacion_padre", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    
    
    return dataset;
  }

  private void cargarRegistroValorCompoPresu(IDataSet dataset, 
                         ValorCompoPresu valorCompoPresu) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_val_compo", valorCompoPresu.getOIDInteger());
    dataset.fieldValue("oid_compo_presu", valorCompoPresu.getCompoPresupuestario().getOIDInteger());
    dataset.fieldValue("codigo", valorCompoPresu.getCodigo());
    dataset.fieldValue("descripcion", valorCompoPresu.getDescripcion());
    dataset.fieldValue("nro_relacion", valorCompoPresu.getNro_rel());
    dataset.fieldValue("nro_relacion_padre", valorCompoPresu.getNro_rel_padre());
    dataset.fieldValue("activo", valorCompoPresu.isActivo());
    
    
  }
}
