package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluProceso;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluProceso extends Operation { 

  public TraerRecluProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    RecluProceso recluproceso = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluproceso = RecluProceso.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluproceso = RecluProceso.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluProceso = getDataSetRecluProceso();
    IDataSet datasetRecluConcepto = getDataSetRecluConceptoProceso();
    
    if (recluproceso != null) { 
    	
        cargarRegistroRecluProceso(datasetRecluProceso, 
                         recluproceso.getOIDInteger(),
                         recluproceso.getCodigo(),
                         recluproceso.getDescripcion(),
                         recluproceso.getOrden(),
                         recluproceso.getCosto(),
                         recluproceso.isActivo(),
                         recluproceso.isAltaSolapaPostulante(),
                         recluproceso.isVisuSolapaPostulante(),
                         recluproceso.isVisuConsRecepcion(),
                         recluproceso.isAltaEnBusqueda()
                         );
                         
                         
        
        Iterator iterConceptos = recluproceso.getConceptos().iterator();
        while (iterConceptos.hasNext()) {
        	RecluConceptoProceso recluConceptoProceso = (RecluConceptoProceso) iterConceptos.next();
        	cargarRegistroRecluConceptoProceso(datasetRecluConcepto, recluConceptoProceso);	
        }
        
        
    }
    
    writeCliente(datasetRecluProceso);
    writeCliente(datasetRecluConcepto);
    
  }

  private IDataSet getDataSetRecluProceso() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluProceso");
    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("costo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("alta_solapa_postu", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("visu_solapa_postu", Field.BOOLEAN, 0));    
    dataset.fieldDef(new Field("visu_cons_recepcion", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("alta_en_busqueda", Field.BOOLEAN, 0));
    return dataset;
    
  }

  private void cargarRegistroRecluProceso(IDataSet dataset, 
                         Integer oid_proceso,
                         String codigo,
                         String descripcion,
                         Integer orden,
                         Money costo,
                         Boolean activo,
                         Boolean isAltaSolapaPostu,
                         Boolean isVisuSolapaPostu,
                         Boolean isVisuConsRecepcion,
                         Boolean isAltaEnBusqueda
                         ) {
    dataset.append(); 
    dataset.fieldValue("oid_proceso", oid_proceso);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("costo", costo);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("alta_solapa_postu", isAltaSolapaPostu);
    dataset.fieldValue("visu_solapa_postu", isVisuSolapaPostu);
    dataset.fieldValue("visu_cons_recepcion" , isVisuConsRecepcion);
    dataset.fieldValue("alta_en_busqueda" , isAltaEnBusqueda);
  }
  
  
  private IDataSet getDataSetRecluConceptoProceso() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluConceptoProceso");
	    dataset.fieldDef(new Field("oid_conc_proceso", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
	    dataset.fieldDef(new Field("costo", Field.CURRENCY, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("alta_en_busqueda", Field.BOOLEAN, 0));
	    return dataset;
  }

  private void cargarRegistroRecluConceptoProceso(IDataSet dataset, 
	                         					  RecluConceptoProceso recluConceptoProceso) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_conc_proceso", recluConceptoProceso.getOIDInteger());
	    dataset.fieldValue("oid_proceso", recluConceptoProceso.getProceso().getOIDInteger());
	    dataset.fieldValue("descripcion", recluConceptoProceso.getDescripcion());
	    dataset.fieldValue("costo", recluConceptoProceso.getCosto());
	    dataset.fieldValue("activo", recluConceptoProceso.isActivo());
	    dataset.fieldValue("alta_en_busqueda", recluConceptoProceso.isAltaEnBusqueda());
  }  
  
}
