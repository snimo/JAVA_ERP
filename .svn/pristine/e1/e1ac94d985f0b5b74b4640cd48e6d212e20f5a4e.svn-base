package com.srn.erp.bienUso.op;

import com.srn.erp.bienUso.bm.GrupoBien;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.VidaUtilGrupo;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoBien extends Operation { 

  public SaveGrupoBien() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoBien"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoBien grupobien = GrupoBien.findByOid(dataset.getInteger("oid_grupo_bien_uso"),getSesion());
        grupobien.setOID(dataset.getInteger("oid_grupo_bien_uso"));
        grupobien.setCodigo(dataset.getString("codigo"));
        grupobien.setDescripcion(dataset.getString("descripcion"));
        grupobien.setAmortiza(dataset.getBoolean("amortiza"));
        grupobien.setAi_vo(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_vo"),getSesion()));
        grupobien.setAi_aa(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_aa"),getSesion()));
        grupobien.setAi_rvo(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_rvo"),getSesion()));
        grupobien.setAi_raa(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_raa"),getSesion()));
        grupobien.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsVidaUtilGrupo = dataset.getDataSet("TVidaUtilGrupo");
        dsVidaUtilGrupo.first();
        while (!dsVidaUtilGrupo.EOF()) {
        	VidaUtilGrupo vidaUtilGrupo = VidaUtilGrupo.findByOid(dsVidaUtilGrupo.getInteger("oid_vida_util_g"),getSesion());
        	vidaUtilGrupo.setGrupo_bien(grupobien);
        	vidaUtilGrupo.setSistema_valuacion(SistemaValuacion.findByOidProxy(dsVidaUtilGrupo.getInteger("oid_sist_val"),getSesion()));
        	vidaUtilGrupo.setVida_util(dsVidaUtilGrupo.getInteger("vida_util"));
        	vidaUtilGrupo.setActivo(dsVidaUtilGrupo.getBoolean("activo"));
        	dsVidaUtilGrupo.next();
        	grupobien.addVidaUtilGrupo(vidaUtilGrupo);
        }
        
        addTransaccion(grupobien);
        dataset.next();
    }
  }
  
}
