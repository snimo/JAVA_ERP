package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluProcTipoFormu;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluTipoFormuProceso extends Operation { 

  public SaveRecluTipoFormuProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluTipoFormuProceso"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
        RecluTipoFormuProceso reclutipoformuproceso = RecluTipoFormuProceso.findByOid(dataset.getInteger("oid_tipo_formu"),getSesion());
        reclutipoformuproceso.setOID(dataset.getInteger("oid_tipo_formu"));
        reclutipoformuproceso.setCodigo(dataset.getString("codigo"));
        reclutipoformuproceso.setDescripcion(dataset.getString("descripcion"));
        reclutipoformuproceso.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsProcesos = dataset.getDataSet("TRecluProcTipoFormu");
        dsProcesos.first();
        while (!dsProcesos.EOF()) {
        	RecluProcTipoFormu recluProcTipoFormu = RecluProcTipoFormu.findByOid(dsProcesos.getInteger("oid_proc_tipo_formu"), this.getSesion());
        	recluProcTipoFormu.setTipo_formulario(reclutipoformuproceso);
        	recluProcTipoFormu.setProceso(RecluProceso.findByOidProxy(dsProcesos.getInteger("oid_proceso"), this.getSesion()));
        	recluProcTipoFormu.setActivo(dsProcesos.getBoolean("activo"));
        	
        	reclutipoformuproceso.addProceso(recluProcTipoFormu);
        	
        	dsProcesos.next();
        }
        
        
        
        
        addTransaccion(reclutipoformuproceso);
        dataset.next();
    }
  }
  
}
