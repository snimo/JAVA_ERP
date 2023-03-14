package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.GrupoAccesoCIP;
import com.srn.erp.cip.bm.PermisoSemanalCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoAccesoCIP extends Operation { 

  public SaveGrupoAccesoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoAccesoCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoAccesoCIP grupoaccesocip = GrupoAccesoCIP.findByOid(dataset.getInteger("oid_grupo_acceso"),getSesion());
        grupoaccesocip.setOID(dataset.getInteger("oid_grupo_acceso"));
        grupoaccesocip.setCodigo(dataset.getString("codigo"));
        grupoaccesocip.setDescripcion(dataset.getString("descripcion"));
        grupoaccesocip.setActivo(dataset.getBoolean("activo"));
        grupoaccesocip.setPermiso_semanal(PermisoSemanalCIP.findByOidProxy(dataset.getInteger("oid_perm_semanal"),getSesion()));
        addTransaccion(grupoaccesocip);
        dataset.next();
    }
  }
  
}
