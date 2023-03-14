package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoDeAtributos extends Operation { 

  public SaveGrupoDeAtributos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoDeAtributos"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoDeAtributos grupodeatributos = GrupoDeAtributos.findByOid(dataset.getInteger("oid_grupos_atri"),getSesion());
        grupodeatributos.setOID(dataset.getInteger("oid_grupos_atri"));
        grupodeatributos.setCodigo(dataset.getString("codigo"));
        grupodeatributos.setDescripcion(dataset.getString("descripcion"));
        grupodeatributos.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsAtriEnGrupo = dataset.getDataSet("TAtributoEnGrupo");
        dsAtriEnGrupo.first();
        while (!dsAtriEnGrupo.EOF()) {
          AtributoEnGrupo atributoengrupo = AtributoEnGrupo.findByOid(dsAtriEnGrupo.getInteger("oid_atri_en_grupo"),getSesion());
          atributoengrupo.setGrupoatri(grupodeatributos);
          atributoengrupo.setAtributo(Atributo.findByOidProxy(dsAtriEnGrupo.getInteger("oid_atributo"),getSesion()));
          atributoengrupo.setSecu(dsAtriEnGrupo.getInteger("secu"));
          atributoengrupo.setFormato(dsAtriEnGrupo.getString("formato"));
          atributoengrupo.setObligatorio(dsAtriEnGrupo.getBoolean("obligatorio"));
          atributoengrupo.setMax_longitud(dsAtriEnGrupo.getInteger("max_longitud"));
          if (dsAtriEnGrupo.getBoolean("activo").booleanValue()==false)
          	atributoengrupo.delete();
          else
            atributoengrupo.setActivo(dsAtriEnGrupo.getBoolean("activo"));
          
          grupodeatributos.addAributoEnGrupo(atributoengrupo);
        	dsAtriEnGrupo.next();
        }
        
        addTransaccion(grupodeatributos);
        dataset.next();
    }
  }
  
}
