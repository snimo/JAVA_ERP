package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerRecluEstadoProceso extends Operation { 

  public TraerRecluEstadoProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluEstadoProceso recluestadoproceso = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluestadoproceso = RecluEstadoProceso.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluestadoproceso = RecluEstadoProceso.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluEstadoProceso = getDataSetRecluEstadoProceso();
    if (recluestadoproceso != null) { 
        cargarRegistroRecluEstadoProceso(datasetRecluEstadoProceso, 
                         recluestadoproceso.getOIDInteger(),
                         recluestadoproceso.getCodigo(),
                         recluestadoproceso.getDescripcion(),
                         recluestadoproceso.isIniciar_prox_proc(),
                         recluestadoproceso.isActivo(),
                         recluestadoproceso.isFecPlanifOblig()
                         );
    }
    writeCliente(datasetRecluEstadoProceso);
  }

  private IDataSet getDataSetRecluEstadoProceso() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluEstadoProceso");
    dataset.fieldDef(new Field("oid_est_proc_sel", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("iniciar_prox_proc", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("fec_planif_oblig", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroRecluEstadoProceso(IDataSet dataset, 
                         Integer oid_est_proc_sel,
                         String codigo,
                         String descripcion,
                         Boolean iniciar_prox_proc,
                         Boolean activo,
                         Boolean fecPlanifOblig) {
    dataset.append(); 
    dataset.fieldValue("oid_est_proc_sel", oid_est_proc_sel);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("iniciar_prox_proc", iniciar_prox_proc);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("fec_planif_oblig", fecPlanifOblig);
    
  }
}
