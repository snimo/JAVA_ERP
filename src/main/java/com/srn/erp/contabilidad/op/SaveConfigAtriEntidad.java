package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadFijo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.contabilidad.bm.GrupoHabilitadoEntidad;
import com.srn.erp.general.bm.Entidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfigAtriEntidad extends Operation { 

  public SaveConfigAtriEntidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAgregarAtriEnt"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) {
      	
      	Entidad entidad = Entidad.findByOid(dataset.getInteger("oid_entidad"),getSesion());
      	
      	procesarGrupoEntFijo(entidad,dataset);
      	procesarGrupoEntVar(entidad,dataset);
         	
      	dataset.next();
    }
  }
  
  private void procesarGrupoEntFijo(Entidad entidad,IDataSet dataset) throws BaseException {
  	IDataSet dsGrupoAtriEntFijo = dataset.getDataSet("TGrupoAtributoEntidadFijo");
  	dsGrupoAtriEntFijo.first();
  	while (!dsGrupoAtriEntFijo.EOF()) {
  		GrupoAtributoEntidadFijo grupoAtriEntFijo =
  			GrupoAtributoEntidadFijo.findByOid(dsGrupoAtriEntFijo.getInteger("oid_grupo_atri_fij"),getSesion());
  		grupoAtriEntFijo.setNickname(entidad.getNombre_nickname());
  		grupoAtriEntFijo.setNombre(dsGrupoAtriEntFijo.getString("nombre"));
  		grupoAtriEntFijo.setOrden(dsGrupoAtriEntFijo.getInteger("orden"));
  		grupoAtriEntFijo.setGrupo_atributo(GrupoDeAtributos.findByOidProxy(dsGrupoAtriEntFijo.getInteger("oid_grupos_atri"),getSesion()));
  		grupoAtriEntFijo.setActivo(dsGrupoAtriEntFijo.getBoolean("activo"));
  		addTransaccion(grupoAtriEntFijo);
  		dsGrupoAtriEntFijo.next();
  	}
  }
  
  private void procesarGrupoEntVar(Entidad entidad,IDataSet dataset) throws BaseException {
  	IDataSet dsGrupoAtriEntVar = dataset.getDataSet("TGrupoAtributoEntidadVar");
  	dsGrupoAtriEntVar.first();
  	while (!dsGrupoAtriEntVar.EOF()) {
  		GrupoAtributoEntidadVar grupoAtriEntVar =
  			GrupoAtributoEntidadVar.findByOid(dsGrupoAtriEntVar.getInteger("oid_grupo_atri_var"),getSesion());
  		grupoAtriEntVar.setNickname(entidad.getNombre_nickname());
  		grupoAtriEntVar.setNombre(dsGrupoAtriEntVar.getString("nombre"));
  		grupoAtriEntVar.setActivo(dsGrupoAtriEntVar.getBoolean("activo"));
  		if (!grupoAtriEntVar.isActivo().booleanValue())
  			grupoAtriEntVar.delete();
  		
  		IDataSet dsGruposHabEnt = dsGrupoAtriEntVar.getDataSet("TGrupoHabilitadoEntidad");
  		dsGruposHabEnt.first();
  		while (!dsGruposHabEnt.EOF()) {
  			GrupoHabilitadoEntidad grupoHabEnt =
  				GrupoHabilitadoEntidad.findByOid(dsGruposHabEnt.getInteger("oid_grupos_hab_ent"),getSesion());
  			grupoHabEnt.setGrupo_atributo_entidad_var(grupoAtriEntVar);
  			grupoHabEnt.setGrupo_atributo(GrupoDeAtributos.findByOidProxy(dsGruposHabEnt.getInteger("oid_grupos_atri"),getSesion()));
  			grupoHabEnt.setActivo(dsGruposHabEnt.getBoolean("activo"));
  			if (!grupoHabEnt.isActivo().booleanValue())
  				grupoHabEnt.delete();
  			grupoAtriEntVar.addGrupoHabilitadoEntidad(grupoHabEnt);
  			dsGruposHabEnt.next();
  		}
  		
  		addTransaccion(grupoAtriEntVar);
  		dsGrupoAtriEntVar.next();
  	}
  	
  }
  
  
}
