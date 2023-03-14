package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoMaquina extends Operation { 

  public SaveGrupoMaquina() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoMaquina"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
        GrupoMaquina grupomaquina = GrupoMaquina.findByOid(dataset.getInteger("oid_grupo_maq"),getSesion());
        grupomaquina.setNombre(dataset.getString("nombre"));
        grupomaquina.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsGrupoDet = dataset.getDataSet("TGrupoMaquinaDet");
        dsGrupoDet.first();
        while (!dsGrupoDet.EOF()) {
        	GrupoMaquinaDet grupoMaqDet =
        		GrupoMaquinaDet.findByOid(dsGrupoDet.getInteger("oid_grupo_maq_det"),this.getSesion());
        	grupoMaqDet.setGrupo_maquina(grupomaquina);
        	grupoMaqDet.setMaquina(Maquina.findByOidProxy(dsGrupoDet.getInteger("oid_maquina"), this.getSesion()));
        	grupoMaqDet.setActivo(dsGrupoDet.getBoolean("activo"));
        	if (!grupoMaqDet.isActivo())
        		grupoMaqDet.delete();
        		
        	grupomaquina.addMaquinaDet(grupoMaqDet);
        	
        	dsGrupoDet.next();
        }
        
        addTransaccion(grupomaquina);
        dataset.next();
    }
  }
  
}
