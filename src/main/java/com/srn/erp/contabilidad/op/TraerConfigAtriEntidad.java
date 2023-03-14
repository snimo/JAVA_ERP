package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadFijo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoHabilitadoEntidad;
import com.srn.erp.general.bm.Entidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfigAtriEntidad extends Operation { 

  public TraerConfigAtriEntidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	
  	Integer oidEntidad = mapaDatos.getInteger("oid");
  	Entidad entidad = Entidad.findByOid(oidEntidad,getSesion());
  	
    String nickNameEntidad = entidad.getNombre_nickname();

    IDataSet datasetEntidad = getDataSetEntidad();
    IDataSet datasetGrupoAtributoEntidadFijo = getDataSetGrupoAtributoEntidadFijo();
    IDataSet datasetGrupoAtributoEntidadVar  = getDataSetGrupoAtributoEntidadVar();
    IDataSet datasetGrupoAtributoHabEnt = getDataSetGrupoHabilitadoEntidad();

    // Cabecera
    cargarDataSetEntidad(datasetEntidad,entidad);
    
    // Obtener informacion Fijos
    Iterator iterGrupoAtriEntFijo = 
    	GrupoAtributoEntidadFijo.getGruposAtriFijosByNickName(nickNameEntidad,this.getSesion()).iterator();
    while (iterGrupoAtriEntFijo.hasNext()) {
    	GrupoAtributoEntidadFijo grupoatributoentidadfijo = 
    		(GrupoAtributoEntidadFijo) iterGrupoAtriEntFijo.next();
      cargarRegistroGrupoAtributoEntidadFijo(datasetGrupoAtributoEntidadFijo, 
          grupoatributoentidadfijo);
    }
    
    // Obtener informacion variable
    Iterator iterGruposAtriEntVar = 
    	GrupoAtributoEntidadVar.getGruposAtriEntVar(nickNameEntidad,this.getSesion()).iterator();
    while (iterGruposAtriEntVar.hasNext()) {
    	GrupoAtributoEntidadVar grupoatributoentidadvar = 
    		(GrupoAtributoEntidadVar) iterGruposAtriEntVar.next();
      cargarRegistroGrupoAtributoEntidadVar(datasetGrupoAtributoEntidadVar, 
      		grupoatributoentidadvar);
      enviarGruposHabEntVar(datasetGrupoAtributoHabEnt,grupoatributoentidadvar);    	
    }     
    
    writeCliente(datasetEntidad);
    writeCliente(datasetGrupoAtributoEntidadFijo);
    writeCliente(datasetGrupoAtributoEntidadVar);
    writeCliente(datasetGrupoAtributoHabEnt);
  }
  
  private void enviarGruposHabEntVar(IDataSet dsGruposHab,
  		                               GrupoAtributoEntidadVar grupoatributoentidadVar) throws BaseException {
  	Iterator iterGruposHab = grupoatributoentidadVar.getGruposAtributosHabilitados().iterator();
  	while (iterGruposHab.hasNext()) {
  		GrupoHabilitadoEntidad grupoHabilitadoEntidad = 
  			(GrupoHabilitadoEntidad) iterGruposHab.next();
  		cargarRegistroGrupoHabilitadoEntidad(dsGruposHab,grupoHabilitadoEntidad);
  	}
  	
  }
  
  private IDataSet getDataSetEntidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAgregarAtriEnt");
    dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("nickname", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private void cargarDataSetEntidad(IDataSet dataset, 
			Entidad entidad) throws BaseException {
  dataset.append(); 
  dataset.fieldValue("oid_entidad", entidad.getOIDInteger());
  dataset.fieldValue("descripcion", entidad.getDescripcion());
  dataset.fieldValue("nickname", entidad.getNombre_nickname());
  dataset.fieldValue("activo", entidad.isActivo());
}
  

  private IDataSet getDataSetGrupoAtributoEntidadFijo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoAtributoEntidadFijo");
    dataset.fieldDef(new Field("oid_grupo_atri_fij", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nickname", Field.STRING, 50)); 
    dataset.fieldDef(new Field("nombre", Field.STRING, 50)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupos_atri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_grupos_atri", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupos_atri", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoAtributoEntidadFijo(IDataSet dataset, 
  			GrupoAtributoEntidadFijo grupoAtriEntFijo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_atri_fij", grupoAtriEntFijo.getOIDInteger());
    dataset.fieldValue("nickname", grupoAtriEntFijo.getNickname());
    dataset.fieldValue("nombre", grupoAtriEntFijo.getNombre());
    dataset.fieldValue("orden", grupoAtriEntFijo.getOrden());
    dataset.fieldValue("oid_grupos_atri", grupoAtriEntFijo.getGrupo_atributo().getOIDInteger());
    dataset.fieldValue("cod_grupos_atri", grupoAtriEntFijo.getGrupo_atributo().getCodigo());
    dataset.fieldValue("desc_grupos_atri", grupoAtriEntFijo.getGrupo_atributo().getDescripcion());
    dataset.fieldValue("activo", grupoAtriEntFijo.isActivo());
  }
  
  private IDataSet getDataSetGrupoAtributoEntidadVar() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoAtributoEntidadVar");
    dataset.fieldDef(new Field("oid_grupo_atri_var", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nickname", Field.STRING, 50)); 
    dataset.fieldDef(new Field("nombre", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoAtributoEntidadVar(IDataSet dataset, 
  											 GrupoAtributoEntidadVar grupoAtriEntVar) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_atri_var", grupoAtriEntVar.getOIDInteger());
    dataset.fieldValue("nickname", grupoAtriEntVar.getNickname());
    dataset.fieldValue("nombre", grupoAtriEntVar.getNombre());
    dataset.fieldValue("activo", grupoAtriEntVar.isActivo());
  }
  
  private IDataSet getDataSetGrupoHabilitadoEntidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoHabilitadoEntidad");
    dataset.fieldDef(new Field("oid_grupos_hab_ent", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_atri_var", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_grupos_atri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_grupos_atri", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupos_atri", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoHabilitadoEntidad(IDataSet dataset, 
                         GrupoHabilitadoEntidad grupoHabilitadoEntidad) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupos_hab_ent", grupoHabilitadoEntidad.getOIDInteger());
    dataset.fieldValue("oid_grupo_atri_var", grupoHabilitadoEntidad.getGrupo_atributo_entidad_var().getOIDInteger());
    dataset.fieldValue("oid_grupos_atri", grupoHabilitadoEntidad.getGrupo_atributo().getOIDInteger());
    dataset.fieldValue("cod_grupos_atri", grupoHabilitadoEntidad.getGrupo_atributo().getCodigo());
    dataset.fieldValue("desc_grupos_atri", grupoHabilitadoEntidad.getGrupo_atributo().getDescripcion());
    dataset.fieldValue("activo", grupoHabilitadoEntidad.isActivo());
  }  
  
}
