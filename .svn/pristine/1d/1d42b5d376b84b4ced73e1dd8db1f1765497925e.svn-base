package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluWarnEstBusqCandi;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluEstCandidatoBusq extends Operation { 

  public SaveRecluEstCandidatoBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluEstCandidatoBusq"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluEstCandidatoBusq recluestcandidatobusq = RecluEstCandidatoBusq.findByOid(dataset.getInteger("oid_est_cand_busq"),getSesion());
        recluestcandidatobusq.setOID(dataset.getInteger("oid_est_cand_busq"));
        recluestcandidatobusq.setCodigo(dataset.getString("codigo"));
        recluestcandidatobusq.setDescripcion(dataset.getString("descripcion"));
        recluestcandidatobusq.setActivo(dataset.getBoolean("activo"));
        recluestcandidatobusq.setColor(dataset.getInteger("color"));
        recluestcandidatobusq.setPuedeCerrarBusqueda(dataset.getBoolean("puede_cerrar_busq"));
        recluestcandidatobusq.setEstadoPostulante(RecluEstadoPostulante.findByOidProxy(dataset.getInteger("oid_estado_postu"), this.getSesion()));
        recluestcandidatobusq.setSugerirCierre(dataset.getBoolean("sugerir_cierre"));
        recluestcandidatobusq.setAlCierreEstado(RecluEstCandidatoBusq.findByOidProxy(dataset.getInteger("al_cierre_est_busq"), this.getSesion()));
        
        IDataSet dsWarn = dataset.getDataSet("TRecluWarnEstBusqCandi");
        dsWarn.first();
        while (!dsWarn.EOF()) {
        	RecluWarnEstBusqCandi recluWarnEstBusqCandi = RecluWarnEstBusqCandi.findByOid(dsWarn.getInteger("oid_warn_est_cand"), this.getSesion());
        	recluWarnEstBusqCandi.setEstado_busqueda(recluestcandidatobusq);
        	recluWarnEstBusqCandi.setEstado_proceso(RecluEstadoProceso.findByOidProxy(dsWarn.getInteger("oid_est_proc_sel"), this.getSesion()));
        	recluWarnEstBusqCandi.setActivo(dsWarn.getBoolean("activo"));
        	recluestcandidatobusq.addWarning(recluWarnEstBusqCandi);
        	
        	dsWarn.next();
        }
        
        
        
        addTransaccion(recluestcandidatobusq);
        dataset.next();
    }
  }
  
}
