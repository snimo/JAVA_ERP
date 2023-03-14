package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluProcDefEnBusq;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluDefProcBusqueda extends Operation { 

  public SaveRecluDefProcBusqueda() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TProcesoDefBusq"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	RecluProcDefEnBusq recluProcDefEnBusq = RecluProcDefEnBusq.findByOid(dataset.getInteger("oid_proc_def_busq"),getSesion());
    	recluProcDefEnBusq.setBusqueda(RecluBusqueda.findByOidProxy(dataset.getInteger("oid_busqueda_act"), this.getSesion()));
    	recluProcDefEnBusq.setOrden(dataset.getInteger("orden"));
    	recluProcDefEnBusq.setProceso(RecluProceso.findByOidProxy(dataset.getInteger("oid_proceso"), this.getSesion()));
    	if (dataset.getDate("fecha_asigno")!=null)
    		recluProcDefEnBusq.setFecha_asigno(dataset.getDate("fecha_asigno"));
    	else
    		recluProcDefEnBusq.setFecha_asigno(Util.getFechaActual(this.getSesion()));
    	recluProcDefEnBusq.setConceptoProceso(RecluConceptoProceso.findByOidProxy(dataset.getInteger("oid_conc_proceso"), this.getSesion()));
    	recluProcDefEnBusq.setActivo(dataset.getBoolean("activo"));
    	recluProcDefEnBusq.setTipoFormulario(RecluTipoFormuProceso.findByOid(dataset.getInteger("oid_tipo_formu"),getSesion()));
        addTransaccion(recluProcDefEnBusq);
        dataset.next();
    }
  }
  
}
