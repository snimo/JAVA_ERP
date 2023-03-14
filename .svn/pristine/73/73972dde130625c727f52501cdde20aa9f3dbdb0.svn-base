package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.EstadoPredioExc;
import com.srn.erp.excluidos.bm.PredioExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstadoExcluido extends Operation { 

  public SaveEstadoExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstadoExcluido"); 
    procesarRegistros(dataset); 
    
    
    
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstadoExcluido estadoexcluido = EstadoExcluido.findByOid(dataset.getInteger("oid_estado"),getSesion());
        estadoexcluido.setOID(dataset.getInteger("oid_estado"));
        estadoexcluido.setCodigo(dataset.getString("codigo"));
        estadoexcluido.setDescripcion(dataset.getString("descripcion"));
        estadoexcluido.setPeso(dataset.getInteger("peso"));
        estadoexcluido.setColor(dataset.getString("color"));
        estadoexcluido.setActivo(dataset.getBoolean("activo"));
        estadoexcluido.setProponerNro(dataset.getBoolean("proponer_nro"));
        estadoexcluido.setUltNroPropuesto(dataset.getInteger("ult_nro_propu"));
        estadoexcluido.setNroActaObligatorio(dataset.getBoolean("nro_acta_obli"));
        estadoexcluido.setPermiteModifNro(dataset.getBoolean("permite_modif_nro"));
        estadoexcluido.setConservaNro(dataset.getBoolean("conserva_nro"));
        estadoexcluido.setPublicarEnFiltro(dataset.getBoolean("publicar_en_filtro"));
        estadoexcluido.setRestriccionAcceso(dataset.getBoolean("restriccion_acceso"));
        
        IDataSet dsEstPredio = dataset.getDataSet("TEstadoPredioExc");
        dsEstPredio.first();
        while (!dsEstPredio.EOF()) {
        	
        	EstadoPredioExc estadoPredioExc = EstadoPredioExc.findByOid(dsEstPredio.getInteger("oid_estado_predio"), this.getSesion());
        	estadoPredioExc.setEstado(estadoexcluido);
        	estadoPredioExc.setPredio(PredioExcluido.findByOidProxy(dsEstPredio.getInteger("oid_predio"), this.getSesion()));
        	estadoPredioExc.setProponer_nro(dsEstPredio.getBoolean("proponer_nro"));
        	estadoPredioExc.setUlt_nro_propu(dsEstPredio.getInteger("ult_nro_propu"));
        	estadoPredioExc.setNro_acta_obli(dsEstPredio.getBoolean("nro_acta_obli"));
        	estadoPredioExc.setPermite_modif_nro(dsEstPredio.getBoolean("permite_modif_nro"));
        	estadoPredioExc.setConserva_nro(dsEstPredio.getBoolean("conserva_nro"));
        	estadoPredioExc.setActivo(dsEstPredio.getBoolean("activo"));
        	
        	estadoexcluido.addEstadoPredio(estadoPredioExc);
        	
        	dsEstPredio.next();
        }
        
        
        
        
        addTransaccion(estadoexcluido);
        dataset.next();
    }
  }
  
}
