package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoPuertaDet;
import com.srn.erp.cip.bm.PerfilGrupoPuerta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoPuerta extends Operation { 

  public TraerGrupoPuerta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoPuerta grupopuerta = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupopuerta = GrupoPuerta.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupopuerta = GrupoPuerta.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoPuerta = getDataSetGrupoPuerta();
    IDataSet datasetGrupoPuertaDet = getDataSetGrupoPuertaDet();
    IDataSet datasetPerfilGrupoPuertas = getDataSetPerfilesGruposPuertas();
    
    if (grupopuerta != null) { 
    	
        cargarRegistroGrupoPuerta(datasetGrupoPuerta,grupopuerta);
        
        Iterator iterGrupoPuertasDet = 
        	grupopuerta.getGrupoPuertasDet().iterator();
        while (iterGrupoPuertasDet.hasNext()) {
        	GrupoPuertaDet grupoPuertaDet  = (GrupoPuertaDet) iterGrupoPuertasDet.next();
        	if (!grupoPuertaDet.isActivo()) continue;
        	cargarRegistroGrupoPuertaDet(datasetGrupoPuertaDet,grupopuerta,grupoPuertaDet);
        }
        
        Iterator iterPerfilGrupoPuertas = 
        	grupopuerta.getPerfiles().iterator();
        while (iterPerfilGrupoPuertas.hasNext()) {
        	PerfilGrupoPuerta perfilGrupoPuerta = (PerfilGrupoPuerta) iterPerfilGrupoPuertas.next();
        	if (!perfilGrupoPuerta.isActivo()) continue;
        	cargarPerfilGrupoPuertas(datasetPerfilGrupoPuertas,perfilGrupoPuerta);
        }
        
        
        
    }
    
    writeCliente(datasetGrupoPuerta);
    writeCliente(datasetGrupoPuertaDet);
    writeCliente(datasetPerfilGrupoPuertas);
    
  }

  private IDataSet getDataSetGrupoPuerta() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoPuerta");
    dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("es_para_cacheo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("hab_para_ing_vis", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroGrupoPuerta(IDataSet dataset, 
                         GrupoPuerta grupo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_puerta", grupo.getOIDInteger());
    dataset.fieldValue("codigo", grupo.getCodigo());
    dataset.fieldValue("descripcion", grupo.getDescripcion());
    dataset.fieldValue("activo", grupo.isActivo());
    dataset.fieldValue("es_para_cacheo", grupo.isParaCacheo());
    dataset.fieldValue("hab_para_ing_vis", grupo.isHabParaIngVisita());
  }
  
  private IDataSet getDataSetGrupoPuertaDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TGrupoPuertaDet");
	    dataset.fieldDef(new Field("oid_grupo_det", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cod_puerta", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_puerta", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }

  private void cargarRegistroGrupoPuertaDet(IDataSet dataset, 
	                         GrupoPuerta grupoPuerta,
	                         GrupoPuertaDet grupoPuertaDet) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_grupo_det", grupoPuertaDet.getOIDInteger());
	    dataset.fieldValue("oid_grupo_puerta", grupoPuerta.getOIDInteger());
	    dataset.fieldValue("oid_puerta", grupoPuertaDet.getPuerta().getOIDInteger());
	    dataset.fieldValue("cod_puerta", grupoPuertaDet.getPuerta().getCodigo());
	    dataset.fieldValue("desc_puerta", grupoPuertaDet.getPuerta().getDescripcion());
	    dataset.fieldValue("activo", grupoPuertaDet.isActivo());
  }
  
  private IDataSet getDataSetPerfilesGruposPuertas() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPerfilGrupoPuerta");
	    dataset.fieldDef(new Field("oid_per_gru_pue", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("hab_ing", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("hab_egr", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("hab_ambos", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("den_ing", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("den_egr", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("den_ambos", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_perfil_func", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_perfil_func", Field.STRING, 100));
	    dataset.fieldDef(new Field("cod_perfil_func", Field.STRING, 50));
	    return dataset;
  }
  
  private void cargarPerfilGrupoPuertas(IDataSet dsPerfilGrupoPue , PerfilGrupoPuerta perfilGrupoPuerta) throws BaseException {
	  
	  dsPerfilGrupoPue.append();
	  dsPerfilGrupoPue.fieldValue("oid_per_gru_pue", perfilGrupoPuerta.getOIDInteger());
	  dsPerfilGrupoPue.fieldValue("oid_grupo_puerta", perfilGrupoPuerta.getGrupo_puerta().getOIDInteger());
	  dsPerfilGrupoPue.fieldValue("hab_ing", perfilGrupoPuerta.isHab_ing());
	  dsPerfilGrupoPue.fieldValue("hab_egr", perfilGrupoPuerta.isHab_egr());
	  dsPerfilGrupoPue.fieldValue("hab_ambos", perfilGrupoPuerta.isHab_ambos());
	  dsPerfilGrupoPue.fieldValue("den_ing", perfilGrupoPuerta.isDen_ing());
	  dsPerfilGrupoPue.fieldValue("den_egr", perfilGrupoPuerta.isDen_egr());
	  dsPerfilGrupoPue.fieldValue("den_ambos", perfilGrupoPuerta.isDen_ambos());
	  dsPerfilGrupoPue.fieldValue("activo", perfilGrupoPuerta.isActivo());
	  dsPerfilGrupoPue.fieldValue("oid_perfil_func", perfilGrupoPuerta.getPerfil_funcional().getOIDInteger());
	  dsPerfilGrupoPue.fieldValue("desc_perfil_func", perfilGrupoPuerta.getPerfil_funcional().getDescripcion());
	  dsPerfilGrupoPue.fieldValue("cod_perfil_func", perfilGrupoPuerta.getPerfil_funcional().getCodigo());
	  
  }
  
  
  
  
  
  
}
