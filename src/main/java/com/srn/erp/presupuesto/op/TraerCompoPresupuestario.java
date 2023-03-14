package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.AtriCompoPresu;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoPresupuestario extends Operation { 

  public TraerCompoPresupuestario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
    CompoPresupuestario compopresupuestario = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       compopresupuestario = CompoPresupuestario.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       compopresupuestario = CompoPresupuestario.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCompoPresupuestario = getDataSetCompoPresupuestario();
    IDataSet datasetAtriCompoPresu = getDataSetAtriCompoPresu();
    
    if (compopresupuestario != null) { 
        cargarRegistroCompoPresupuestario(datasetCompoPresupuestario,compopresupuestario);
        Iterator iterDefAtri = compopresupuestario.getDefAtributos().iterator();
        while (iterDefAtri.hasNext()) {
        	AtriCompoPresu atriCompoPresu = (AtriCompoPresu) iterDefAtri.next();
        	cargarRegistroAtriCompoPresu(datasetAtriCompoPresu,atriCompoPresu);
        }
        
       
    }
    writeCliente(datasetCompoPresupuestario);
    writeCliente(datasetAtriCompoPresu);
  }

  private IDataSet getDataSetCompoPresupuestario() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoPresupuestario");
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("tipo", Field.STRING, 10)); 
    dataset.fieldDef(new Field("nro_interno_compo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_compo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_grupo_compo", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_grupo_compo", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCompoPresupuestario(IDataSet dataset, 
                         CompoPresupuestario compoPresupuestario) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_compo_presu", compoPresupuestario.getOIDInteger());
    dataset.fieldValue("codigo", compoPresupuestario.getCodigo());
    dataset.fieldValue("descripcion", compoPresupuestario.getDescripcion());
    dataset.fieldValue("tipo", compoPresupuestario.getTipo());
    dataset.fieldValue("nro_interno_compo", compoPresupuestario.getNro_interno_compo());
    dataset.fieldValue("oid_grupo_compo", compoPresupuestario.getGrupo_compo().getOIDInteger());
    dataset.fieldValue("cod_grupo_compo", compoPresupuestario.getGrupo_compo().getCodigo());
    dataset.fieldValue("desc_grupo_compo", compoPresupuestario.getGrupo_compo().getDescripcion());
    dataset.fieldValue("activo", compoPresupuestario.isActivo());
  }
  
  private IDataSet getDataSetAtriCompoPresu() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAtriCompoPresu");
    dataset.fieldDef(new Field("oid_atri_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("tipo_atributo", Field.STRING, 10)); 
    dataset.fieldDef(new Field("nombre_logico", Field.STRING, 50)); 
    dataset.fieldDef(new Field("nro_orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_compo_atri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_compo_atri", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_compo_atri", Field.STRING, 100));
    dataset.fieldDef(new Field("obligatorio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_interno_atri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("formato", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroAtriCompoPresu(IDataSet dataset, 
                         AtriCompoPresu atriCompoPresu) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_atri_presu", atriCompoPresu.getOIDInteger());
    dataset.fieldValue("oid_compo_presu", atriCompoPresu.getCompo_presu().getOIDInteger());
    dataset.fieldValue("tipo_atributo", atriCompoPresu.getTipo_atributo());
    dataset.fieldValue("nombre_logico", atriCompoPresu.getNombre_logico());
    dataset.fieldValue("nro_orden", atriCompoPresu.getNro_orden());
    if (atriCompoPresu.getCompo_presu_atri()!=null) {
    	dataset.fieldValue("oid_compo_atri", atriCompoPresu.getCompo_presu_atri().getOIDInteger());
    	dataset.fieldValue("cod_compo_atri", atriCompoPresu.getCompo_presu_atri().getCodigo());
    	dataset.fieldValue("desc_compo_atri", atriCompoPresu.getCompo_presu_atri().getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_compo_atri", 0);
    	dataset.fieldValue("cod_compo_atri", "");
    	dataset.fieldValue("desc_compo_atri", "");
    }
    dataset.fieldValue("obligatorio", atriCompoPresu.isObligatorio());
    dataset.fieldValue("nro_interno_atri", atriCompoPresu.getNroInternoAtri());
    dataset.fieldValue("formato", atriCompoPresu.getFormato());
    dataset.fieldValue("activo", atriCompoPresu.isActivo());
  }
  
}
