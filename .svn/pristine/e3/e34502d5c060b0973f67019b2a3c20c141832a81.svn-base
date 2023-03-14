package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluProceso;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluProceso extends Operation { 

  public SaveRecluProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluProceso"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluProceso recluproceso = RecluProceso.findByOid(dataset.getInteger("oid_proceso"),getSesion());
        recluproceso.setOID(dataset.getInteger("oid_proceso"));
        recluproceso.setCodigo(dataset.getString("codigo"));
        recluproceso.setDescripcion(dataset.getString("descripcion"));
        recluproceso.setOrden(dataset.getInteger("orden"));
        recluproceso.setCosto(dataset.getMoney("costo"));
        recluproceso.setActivo(dataset.getBoolean("activo"));
        recluproceso.setAltaSolapaPostulante(dataset.getBoolean("alta_solapa_postu"));
        recluproceso.setVisuSolapaPostulante(dataset.getBoolean("visu_solapa_postu"));
        recluproceso.setVisuConsRecepcion(dataset.getBoolean("visu_cons_recepcion"));
        recluproceso.setAltaEnBusqueda(dataset.getBoolean("alta_en_busqueda"));
        
        IDataSet dsConceptos = dataset.getDataSet("TRecluConceptoProceso");
        dsConceptos.first();
        while (!dsConceptos.EOF()) {
        	RecluConceptoProceso recluConceptoProceso = RecluConceptoProceso.findByOid(dsConceptos.getInteger("oid_conc_proceso"), this.getSesion());
        	recluConceptoProceso.setProceso(recluproceso);
        	recluConceptoProceso.setDescripcion(dsConceptos.getString("descripcion"));
        	if (dsConceptos.getMoney("costo")!=null)
        		recluConceptoProceso.setCosto(dsConceptos.getMoney("costo").doubleValue());
        	else
        		recluConceptoProceso.setCosto(0.0);
        	recluConceptoProceso.setActivo(dsConceptos.getBoolean("activo"));
        	recluConceptoProceso.setAltaEnBusqueda(dsConceptos.getBoolean("alta_en_busqueda"));
        	
        	recluproceso.addConcepto(recluConceptoProceso);
        	
        	dsConceptos.next();
        }
        
        
        
        
        
        addTransaccion(recluproceso);
        dataset.next();
    }
  }
  
}
