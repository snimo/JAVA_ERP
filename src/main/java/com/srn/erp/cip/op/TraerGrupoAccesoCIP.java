package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.GrupoAccesoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoAccesoCIP extends Operation { 

  public TraerGrupoAccesoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoAccesoCIP grupoaccesocip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupoaccesocip = GrupoAccesoCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupoaccesocip = GrupoAccesoCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoAccesoCIP = getDataSetGrupoAccesoCIP();
    if (grupoaccesocip != null) { 
        cargarRegistroGrupoAccesoCIP(datasetGrupoAccesoCIP, grupoaccesocip);
    }
    writeCliente(datasetGrupoAccesoCIP);
  }

  private IDataSet getDataSetGrupoAccesoCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoAccesoCIP");
    dataset.fieldDef(new Field("oid_grupo_acceso", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_perm_semanal", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_perm_semanal", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_perm_semanal", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroGrupoAccesoCIP(
		  				 IDataSet dataset,
		  				 GrupoAccesoCIP grupo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_acceso", grupo.getOIDInteger());
    dataset.fieldValue("codigo", grupo.getCodigo());
    dataset.fieldValue("descripcion", grupo.getDescripcion());
    dataset.fieldValue("activo", grupo.isActivo());
    if (grupo.getPermiso_semanal()!=null) {
    	dataset.fieldValue("oid_perm_semanal", grupo.getPermiso_semanal().getOIDInteger());
    	dataset.fieldValue("cod_perm_semanal", grupo.getPermiso_semanal().getCodigo());
    	dataset.fieldValue("desc_perm_semanal", grupo.getPermiso_semanal().getDescripcion());
    } else {
    	dataset.fieldValue("oid_perm_semanal", "");
    	dataset.fieldValue("cod_perm_semanal", "");
    	dataset.fieldValue("desc_perm_semanal", "");    	
    }
  }
}
