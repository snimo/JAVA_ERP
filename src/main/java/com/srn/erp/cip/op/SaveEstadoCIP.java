package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;

import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoCIP extends Operation { 

  public SaveEstadoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstadoCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
        EstadoCIP estadocip = EstadoCIP.findByOid(dataset.getInteger("oid_estado"),getSesion());
        estadocip.setOID(dataset.getInteger("oid_estado"));
        estadocip.setCodigo(dataset.getString("codigo"));
        estadocip.setDescripcion(dataset.getString("descripcion"));
        estadocip.setTipo_ingreso(dataset.getString("tipo_ingreso"));
        estadocip.setTipo_egreso(dataset.getString("tipo_egreso"));
        estadocip.setActivo(dataset.getBoolean("activo"));
        estadocip.setLeyendaIngDenegado(dataset.getString("ley_ing_denegado"));
        estadocip.setLeyendaEgrDenegado(dataset.getString("ley_egr_denegado"));
        estadocip.setActivarAntiPassBack(dataset.getBoolean("act_anti_pass_back"));
        estadocip.setEsSusceptibleCacheo(dataset.getBoolean("es_suscep_cacheo"));
        estadocip.setMinEntAntEntrada(dataset.getInteger("min_ent_ant_ent"));
        estadocip.setMinEntDesEntrada(dataset.getInteger("min_ent_des_ent"));
        
        
        IDataSet dsEquiv = dataset.getDataSet("TEquivalenciaEstadoCIP");
        dsEquiv.first();
        while (!dsEquiv.EOF()) {
        	EquivalenciaEstadoCIP equivEstCIP =
        		EquivalenciaEstadoCIP.findByOid(dsEquiv.getInteger("oid_equiv_estado"), this.getSesion());
        	equivEstCIP.setEstado(estadocip);
        	equivEstCIP.setCodigo_externo(dsEquiv.getString("codigo_externo"));
        	equivEstCIP.setActivo(dsEquiv.getBoolean("activo"));
        	if (!equivEstCIP.isActivo())
        		equivEstCIP.delete();
        	estadocip.addEquivalencia(equivEstCIP);
        	
        	dsEquiv.next();
        }
        
        
        // Procesar los registros de los Motivos
        IDataSet dsMotivos = dataset.getDataSet("TMotAccesosIntermedios");
        dsMotivos.first();
        while (!dsMotivos.EOF()) {
        	MotivoEntIntermedias motivo   = MotivoEntIntermedias.findByOidProxy(dsMotivos.getInteger("oid_motivo"), this.getSesion());
        	if (dsMotivos.getBoolean("habilitado")) {
        		MotEntInterEst motEntInterEst = MotEntInterEst.getMotEntInterEstado(motivo, estadocip, this.getSesion());
        		if (motEntInterEst==null) {
        			MotEntInterEst motEntInterEstNew = (MotEntInterEst) MotEntInterEst.getNew(MotEntInterEst.NICKNAME, this.getSesion());
        			motEntInterEstNew.setEstado(estadocip);
        			motEntInterEstNew.setMotivo(motivo);
        			motEntInterEstNew.setActivo(true);
        			estadocip.addMotivoEntInterEstado(motEntInterEstNew);
        		}
        			
        	} else {
        		// Deshabilitado
        		MotEntInterEst motEntInterEst = MotEntInterEst.getMotEntInterEstado(motivo, estadocip, this.getSesion());
        		if (motEntInterEst!=null) {
        			motEntInterEst.delete();
        			estadocip.addMotivoEntInterEstado(motEntInterEst);
        		}
        		
        	}
        	
        	dsMotivos.next();
        }
        
        // Procesar los Categorias de Accesos
        IDataSet dsCategAccesos = dataset.getDataSet("TCatAccesoEstado");
        dsCategAccesos.first();
        while (!dsCategAccesos.EOF()) {
        	CategAccesoCIP categoria = CategAccesoCIP.findByOidProxy(dsCategAccesos.getInteger("oid_categ_acceso"), this.getSesion());
        	if (dsCategAccesos.getBoolean("activo")) {
        		CategAccesoEstado categAccesoEstado = CategAccesoEstado.getCategAccesoEstado(estadocip, categoria, this.getSesion()); 
        		if (categAccesoEstado==null) {
        			CategAccesoEstado categAccesoEstadoNew = (CategAccesoEstado) CategAccesoEstado.getNew(CategAccesoEstado.NICKNAME, this.getSesion());
        			categAccesoEstadoNew.setEstado(estadocip);
        			categAccesoEstadoNew.setCategoria(categoria);
        			categAccesoEstadoNew.setActivo(true);
        			estadocip.addCategoriaAcceso(categAccesoEstadoNew);
        		}
        			
        	} else {
        		CategAccesoEstado categAccesoEstado = CategAccesoEstado.getCategAccesoEstado(estadocip, categoria, this.getSesion());
        		if (categAccesoEstado!=null) {
        			categAccesoEstado.delete();
        			estadocip.addCategoriaAcceso(categAccesoEstado);
        		}
        		
        	}
        	
        	dsCategAccesos.next();
        }
        
        
        
        addTransaccion(estadocip);
        dataset.next();
    }
  }
  
}
