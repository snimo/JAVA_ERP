package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluProcTipoFormu;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluTipoFormuProceso extends Operation { 

  public TraerRecluTipoFormuProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluTipoFormuProceso reclutipoformuproceso = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclutipoformuproceso = RecluTipoFormuProceso.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclutipoformuproceso = RecluTipoFormuProceso.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluTipoFormuProceso = getDataSetRecluTipoFormuProceso();
    IDataSet datasetProcesos = this.getDataSetRecluProcesos();
    
    if (reclutipoformuproceso != null) { 
    	
        cargarRegistroRecluTipoFormuProceso(datasetRecluTipoFormuProceso, 
                         reclutipoformuproceso.getOIDInteger(),
                         reclutipoformuproceso.getCodigo(),
                         reclutipoformuproceso.getDescripcion(),
                         reclutipoformuproceso.isActivo());
        
        Iterator iterProcesos = reclutipoformuproceso.getProcesos().iterator();
        while (iterProcesos.hasNext()) {
        	RecluProcTipoFormu recluProcTipoFormu = (RecluProcTipoFormu) iterProcesos.next();
        	cargarRegistroProceso(datasetProcesos,recluProcTipoFormu);
        }
        
        
        
    }
    
    writeCliente(datasetRecluTipoFormuProceso);
    writeCliente(datasetProcesos);
    
  }

  private IDataSet getDataSetRecluTipoFormuProceso() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluTipoFormuProceso");
    dataset.fieldDef(new Field("oid_tipo_formu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private IDataSet getDataSetRecluProcesos() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluProcTipoFormu");
	    dataset.fieldDef(new Field("oid_proc_tipo_formu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_tipo_formu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
	  }  

  private void cargarRegistroRecluTipoFormuProceso(IDataSet dataset, 
                         Integer oid_tipo_formu,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_formu", oid_tipo_formu);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
  
  private void cargarRegistroProceso(IDataSet dataset, 
          RecluProcTipoFormu proceso) throws BaseException {
dataset.append(); 
dataset.fieldValue("oid_proc_tipo_formu", proceso.getOIDInteger());
dataset.fieldValue("oid_tipo_formu", proceso.getTipo_formulario().getOIDInteger());
dataset.fieldValue("oid_proceso", proceso.getProceso().getOIDInteger());
dataset.fieldValue("activo", proceso.isActivo());
}  
  
  
}
