package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRecluEstadoProceso extends Operation { 

  public SaveRecluEstadoProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluEstadoProceso"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluEstadoProceso recluestadoproceso = RecluEstadoProceso.findByOid(dataset.getInteger("oid_est_proc_sel"),getSesion());
        recluestadoproceso.setOID(dataset.getInteger("oid_est_proc_sel"));
        recluestadoproceso.setCodigo(dataset.getString("codigo"));
        recluestadoproceso.setDescripcion(dataset.getString("descripcion"));
        recluestadoproceso.setIniciar_prox_proc(dataset.getBoolean("iniciar_prox_proc"));
        recluestadoproceso.setActivo(dataset.getBoolean("activo"));
        recluestadoproceso.setFecPlanifOblig(dataset.getBoolean("fec_planif_oblig"));
        addTransaccion(recluestadoproceso);
        dataset.next();
    }
  }
  
}
