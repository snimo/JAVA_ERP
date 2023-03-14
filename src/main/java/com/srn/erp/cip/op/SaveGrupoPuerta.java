package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;

import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoPuerta extends Operation { 

  public SaveGrupoPuerta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoPuerta"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoPuerta grupopuerta = GrupoPuerta.findByOid(dataset.getInteger("oid_grupo_puerta"),getSesion());
        grupopuerta.setOID(dataset.getInteger("oid_grupo_puerta"));
        grupopuerta.setCodigo(dataset.getString("codigo"));
        grupopuerta.setDescripcion(dataset.getString("descripcion"));
        grupopuerta.setActivo(dataset.getBoolean("activo"));
        grupopuerta.setIsParaCacheo(dataset.getBoolean("es_para_cacheo"));
        grupopuerta.setHabParaIngVisita(dataset.getBoolean("hab_para_ing_vis"));
        
        IDataSet dsGrupoPuertasDet = dataset.getDataSet("TGrupoPuertaDet");
        dsGrupoPuertasDet.first();
        while (!dsGrupoPuertasDet.EOF()) {
        	GrupoPuertaDet grupoPuertaDet =
        		GrupoPuertaDet.findByOid(dsGrupoPuertasDet.getInteger("oid_grupo_det"), this.getSesion());
        	grupoPuertaDet.setGrupo_puertas(grupopuerta);
        	grupoPuertaDet.setPuerta(Puerta.findByOidProxy(dsGrupoPuertasDet.getInteger("oid_puerta"), this.getSesion()));
        	grupoPuertaDet.setActivo(dsGrupoPuertasDet.getBoolean("activo"));
        	if (!grupoPuertaDet.isActivo())
        		grupoPuertaDet.delete();
        		
        	grupopuerta.addGrupoPuertasDet(grupoPuertaDet);
        	
        	dsGrupoPuertasDet.next();
        }
        
        IDataSet dsPerfilesGrupoPuertas = dataset.getDataSet("TPerfilGrupoPuerta");
        dsPerfilesGrupoPuertas.first();
        while (!dsPerfilesGrupoPuertas.EOF()) {
        	PerfilGrupoPuerta perfilGrupoPuerta =
        		PerfilGrupoPuerta.findByOid(dsPerfilesGrupoPuertas.getInteger("oid_per_gru_pue"), this.getSesion());
        	perfilGrupoPuerta.setGrupo_puerta(grupopuerta);
        	perfilGrupoPuerta.setHab_ing(dsPerfilesGrupoPuertas.getBoolean("hab_ing"));
        	perfilGrupoPuerta.setHab_egr(dsPerfilesGrupoPuertas.getBoolean("hab_egr"));
        	perfilGrupoPuerta.setHab_ambos(dsPerfilesGrupoPuertas.getBoolean("hab_ambos"));
        	perfilGrupoPuerta.setDen_ing(dsPerfilesGrupoPuertas.getBoolean("den_ing"));
        	perfilGrupoPuerta.setDen_egr(dsPerfilesGrupoPuertas.getBoolean("den_egr"));
        	perfilGrupoPuerta.setDen_ambos(dsPerfilesGrupoPuertas.getBoolean("den_ambos"));
        	perfilGrupoPuerta.setActivo(dsPerfilesGrupoPuertas.getBoolean("activo"));
        	perfilGrupoPuerta.setPerfil_funcional(PerfilFuncional.findByOidProxy(dsPerfilesGrupoPuertas.getInteger("oid_perfil_func"), this.getSesion()));
        		
        	grupopuerta.addPerfilGrupoPuerta(perfilGrupoPuerta);
        	
        	dsPerfilesGrupoPuertas.next();
        }        
        
        
        
        
        addTransaccion(grupopuerta);
        dataset.next();
    }
  }
  
}
