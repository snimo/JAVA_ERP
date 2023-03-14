package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoCajas extends Operation { 

  public SaveGrupoCajas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoCajas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoCajas grupocajas = GrupoCajas.findByOid(dataset.getInteger("oid_grupo_caja"),getSesion());
        grupocajas.setOID(dataset.getInteger("oid_grupo_caja"));
        grupocajas.setCodigo(dataset.getString("codigo"));
        grupocajas.setDescripcion(dataset.getString("descripcion"));
        grupocajas.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsGruposCajasDet = dataset.getDataSet("TGrupoCajasDet");
        dsGruposCajasDet.first();
        while (!dsGruposCajasDet.EOF()) {
        	GrupoCajasDet grupoCajasDet =
        		GrupoCajasDet.findByOid(dsGruposCajasDet.getInteger("oid_grupo_caja_det"), this.getSesion());
        	grupoCajasDet.setGrupo_caja(grupocajas);
        	grupoCajasDet.setCaja(Caja.findByOidProxy(dsGruposCajasDet.getInteger("oid_caja"), this.getSesion()));
        	grupoCajasDet.setOrden(dsGruposCajasDet.getInteger("orden"));
        	grupoCajasDet.setActivo(dsGruposCajasDet.getBoolean("activo"));
        	grupocajas.addGrupoCajasDet(grupoCajasDet);
        	
        	dsGruposCajasDet.next();
        }
                
        addTransaccion(grupocajas);
        dataset.next();
    }
  }
  
}
