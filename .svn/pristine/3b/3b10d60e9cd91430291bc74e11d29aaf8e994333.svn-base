package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.EstadoPredioExc;
import com.srn.erp.excluidos.bm.GrupoImportacionExcEst;
import com.srn.erp.excluidos.bm.GrupoImportacionExcMaq;
import com.srn.erp.excluidos.bm.GrupoImportacionExcPeli;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.GrupoImportacionSoloEst;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.mensajero.bm.Maquina;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoImportacionExcluido extends Operation { 

  public SaveGrupoImportacionExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoImportacionExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoImportacionExcluido grupoimportacionexcluido = GrupoImportacionExcluido.findByOid(dataset.getInteger("oid_grupo_imp_exc"),getSesion());
        grupoimportacionexcluido.setOID(dataset.getInteger("oid_grupo_imp_exc"));
        grupoimportacionexcluido.setCodigo(dataset.getString("codigo"));
        grupoimportacionexcluido.setDescripcion(dataset.getString("descripcion"));
        grupoimportacionexcluido.setTipo_individuo(dataset.getString("tipo_individuo"));
        grupoimportacionexcluido.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsGrupoImpExcPeli = dataset.getDataSet("TGrupoImportacionExcPeli");
        dsGrupoImpExcPeli.first();
        while (!dsGrupoImpExcPeli.EOF()) {
        	
        	GrupoImportacionExcPeli grupoImportacionExcPeli = 
        		GrupoImportacionExcPeli.findByOid(dsGrupoImpExcPeli.getInteger("oid_grupo_impo_peli"), this.getSesion());
        	
        	grupoImportacionExcPeli.setGrupo_imp_esc(grupoimportacionexcluido);
        	grupoImportacionExcPeli.setPredio(PredioExcluido.findByOidProxy(dsGrupoImpExcPeli.getInteger("oid_predio"), this.getSesion()));
        	grupoImportacionExcPeli.setPeligrosidad(PeligrosidadExcluido.findByOidProxy(dsGrupoImpExcPeli.getInteger("oid_peligrosidad"), this.getSesion()));
        	grupoImportacionExcPeli.setActivo(dsGrupoImpExcPeli.getBoolean("activo"));
        	
        	grupoimportacionexcluido.addGrupoImpoPeli(grupoImportacionExcPeli);
        	
        	dsGrupoImpExcPeli.next();
        }
        
        IDataSet dsGrupoImpExcEst = dataset.getDataSet("TGrupoImportacionExcEst");
        dsGrupoImpExcEst.first();
        while (!dsGrupoImpExcEst.EOF()) {
        	
        	GrupoImportacionExcEst grupoImportacionExcEst =
        		GrupoImportacionExcEst.findByOid(dsGrupoImpExcEst.getInteger("oid_grupo_impo_est"), this.getSesion());
        	
        	grupoImportacionExcEst.setGrupo_imp_esc(grupoimportacionexcluido);
        	grupoImportacionExcEst.setPredio(PredioExcluido.findByOidProxy(dsGrupoImpExcEst.getInteger("oid_predio"), this.getSesion()));
        	grupoImportacionExcEst.setEstado(EstadoPredioExc.findByOidProxy(dsGrupoImpExcEst.getInteger("oid_estado"), this.getSesion()));
        	grupoImportacionExcEst.setActivo(dsGrupoImpExcEst.getBoolean("activo"));
        	        	   	
        	grupoimportacionexcluido.addGrupoImpoEst(grupoImportacionExcEst);
        	
        	dsGrupoImpExcEst.next();
        }
        
        IDataSet dsGrupoImpExcMaq = dataset.getDataSet("TGrupoImportacionExcMaq");
        dsGrupoImpExcMaq.first();
        while (!dsGrupoImpExcMaq.EOF()) {
        	
        	GrupoImportacionExcMaq grupoImportacionExcMaq =
        		GrupoImportacionExcMaq.findByOid(dsGrupoImpExcMaq.getInteger("oid_grupo_imp_maq"), this.getSesion());
        	
        	grupoImportacionExcMaq.setGrupo_imp_exc(grupoimportacionexcluido);
        	grupoImportacionExcMaq.setMaquina(Maquina.findByOidProxy(dsGrupoImpExcMaq.getInteger("oid_maquina"), this.getSesion()));
        	grupoImportacionExcMaq.setActivo(dsGrupoImpExcMaq.getBoolean("activo"));
        	        	   	
        	grupoimportacionexcluido.addGrupoImpoMaqui(grupoImportacionExcMaq);
        	
        	dsGrupoImpExcMaq.next();
        }        
        
        
        IDataSet dsGrupoImpoSoloEst = dataset.getDataSet("TGrupoImportacionSoloEst");
        dsGrupoImpoSoloEst.first();
        while (!dsGrupoImpoSoloEst.EOF()) {
        	
        	GrupoImportacionSoloEst grupoImportacionSoloEst =
        		GrupoImportacionSoloEst.findByOid(dsGrupoImpoSoloEst.getInteger("oid_grupo_solo_est"), this.getSesion());
        	
        	grupoImportacionSoloEst.setGrupo_imp_exc(grupoimportacionexcluido);
        	grupoImportacionSoloEst.setEstado(EstadoExcluido.findByOidProxy(dsGrupoImpoSoloEst.getInteger("oid_estado"), this.getSesion()));
        	grupoImportacionSoloEst.setActivo(dsGrupoImpoSoloEst.getBoolean("activo"));
        	        	   	
        	grupoimportacionexcluido.addImportacionSoloEstados(grupoImportacionSoloEst);
        	
        	dsGrupoImpoSoloEst.next();
        }        
        
        
        
        
        
        
        addTransaccion(grupoimportacionexcluido);
        dataset.next();
    }
  }
  
}
