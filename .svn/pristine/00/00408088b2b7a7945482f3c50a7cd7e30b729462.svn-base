package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluProcDefEnBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluProcDefBusq extends Operation { 

  public TraerRecluProcDefBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidBusqueda = mapaDatos.getInteger("oid_busqueda");
	RecluBusqueda recluBusqueda = RecluBusqueda.findByOid(oidBusqueda, this.getSesion());
	
	IDataSet dsDefProc = this.getDataSetProcesoDefBusq();
	
	Iterator iterDefProcesos =  recluBusqueda.getDefinicionProcesos().iterator();
	while (iterDefProcesos.hasNext()) {
		RecluProcDefEnBusq recluProcDefEnBusq = (RecluProcDefEnBusq) iterDefProcesos.next();
		cargarRegistroProcesoDefBusq(dsDefProc, recluProcDefEnBusq);
	}
	
	writeCliente(dsDefProc);
	
	  
  }

  private IDataSet getDataSetProcesoDefBusq() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TProcesoDefBusq");
    dataset.fieldDef(new Field("oid_proc_def_busq", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha_asigno", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_conc_proceso", Field.INTEGER, 0));
    dataset.fieldDef(new Field("examen", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_tipo_formu", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroProcesoDefBusq(IDataSet dataset, 
		  									RecluProcDefEnBusq recluProcDefEnBusq) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_proc_def_busq", recluProcDefEnBusq.getOIDInteger());
    dataset.fieldValue("oid_busqueda_act", recluProcDefEnBusq.getBusqueda().getOIDInteger());
    dataset.fieldValue("orden", recluProcDefEnBusq.getOrden());
    if (recluProcDefEnBusq.getProceso()!=null)
    	dataset.fieldValue("oid_proceso", recluProcDefEnBusq.getProceso().getOIDInteger());
    else
    	dataset.fieldValue("oid_proceso", "");
    dataset.fieldValue("fecha_asigno", recluProcDefEnBusq.getFecha_asigno());
    if (recluProcDefEnBusq.getConceptoProceso()!=null) {
    	dataset.fieldValue("oid_conc_proceso", recluProcDefEnBusq.getConceptoProceso().getOIDInteger());
    	dataset.fieldValue("examen", recluProcDefEnBusq.getConceptoProceso().getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_conc_proceso", "");
    	dataset.fieldValue("examen", "");
    }
    
    dataset.fieldValue("activo", recluProcDefEnBusq.isActivo());
    if (recluProcDefEnBusq.getTipoFormulario()!=null)
    	dataset.fieldValue("oid_tipo_formu", recluProcDefEnBusq.getTipoFormulario().getOIDInteger());
    else
    	dataset.fieldValue("oid_tipo_formu", "");
    
  }
}
