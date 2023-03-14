package com.srn.erp.general.op;

import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDefinicionAtributoEntidad extends Operation { 

  public SaveDefinicionAtributoEntidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEntidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
    	IDataSet dsDefAtriEnt = dataset.getDataSet("TDefinicionAtributoEntidad");
    	dsDefAtriEnt.first();
    	while (!dsDefAtriEnt.EOF()) {
    		DefinicionAtributoEntidad definicionatributoentidad = DefinicionAtributoEntidad.findByOid(dsDefAtriEnt.getInteger("oid_atri_ent"),getSesion());
            definicionatributoentidad.setOID(dsDefAtriEnt.getInteger("oid_atri_ent"));
            definicionatributoentidad.setEntidad(dsDefAtriEnt.getString("entidad"));
            definicionatributoentidad.setNombre_logico(dsDefAtriEnt.getString("nombre_logico"));
            definicionatributoentidad.setSignature(dsDefAtriEnt.getString("signature"));
            definicionatributoentidad.setActivo(dsDefAtriEnt.getBoolean("activo"));
            definicionatributoentidad.setNombreNickName(dsDefAtriEnt.getString("nickname"));
            addTransaccion(definicionatributoentidad);
    		dsDefAtriEnt.next();
    	}
        dataset.next();
    }
  }
  
}
