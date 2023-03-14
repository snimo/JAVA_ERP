package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluProceso;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluConcProceso extends Operation { 

  public TraerRecluConcProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidProceso = mapaDatos.getInteger("oid_proceso");
	RecluProceso recluProceso = RecluProceso.findByOid(oidProceso, this.getSesion());
	
	IDataSet dsConceptos = this.getDataSetConceptoProceso();
	
	Iterator iterConceptos = recluProceso.getConceptos().iterator();
	while (iterConceptos.hasNext()) {
		RecluConceptoProceso proceso = (RecluConceptoProceso) iterConceptos.next();
		cargarRegistroConceptoProceso(dsConceptos, proceso);
	}
	
	writeCliente(dsConceptos);
	
  } 

      
  private IDataSet getDataSetConceptoProceso() { 
    	    IDataSet dataset = new TDataSet(); 
    	    dataset.create("TConceProceso");
    	    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    	    return dataset;
  }

  private void cargarRegistroConceptoProceso(IDataSet dataset, RecluConceptoProceso recluConceptoProceso) throws BaseException {
    	    dataset.append(); 
    	    dataset.fieldValue("oid", recluConceptoProceso.getOIDInteger());
    	    dataset.fieldValue("descripcion", recluConceptoProceso.getDescripcion());
  }      
  
  
}
