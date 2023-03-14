package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluWarnEstBusqCandi;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluEstCandidatoBusq extends Operation { 

  public TraerRecluEstCandidatoBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluEstCandidatoBusq recluestcandidatobusq = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluestcandidatobusq = RecluEstCandidatoBusq.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluestcandidatobusq = RecluEstCandidatoBusq.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluEstCandidatoBusq = getDataSetRecluEstCandidatoBusq();
    IDataSet datasetWarn = this.getDataSetWarning();
    
    if (recluestcandidatobusq != null) { 
    	
        cargarRegistroRecluEstCandidatoBusq(datasetRecluEstCandidatoBusq, 
                         recluestcandidatobusq.getOIDInteger(),
                         recluestcandidatobusq.getCodigo(),
                         recluestcandidatobusq.getDescripcion(),
                         recluestcandidatobusq.isActivo(),
                         recluestcandidatobusq.getColor(),
                         recluestcandidatobusq.isPuedeCerrarBusqueda(),
                         recluestcandidatobusq.getEstadoPostulante(),
                         recluestcandidatobusq.isSugerirCierre(),
                         recluestcandidatobusq.getAlCierreEstado()
                         
                         );
        
        Iterator iterWarn =
        		recluestcandidatobusq.getWarning().iterator();
        while (iterWarn.hasNext()) {
        	RecluWarnEstBusqCandi warn = (RecluWarnEstBusqCandi) iterWarn.next();
        	cargarDataSetWarn(datasetWarn, warn);
        	
        }
        
    }
    
    writeCliente(datasetRecluEstCandidatoBusq);
    writeCliente(datasetWarn);
    
  }

  private IDataSet getDataSetRecluEstCandidatoBusq() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluEstCandidatoBusq");
    dataset.fieldDef(new Field("oid_est_cand_busq", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("color", Field.INTEGER, 0));
    dataset.fieldDef(new Field("puede_cerrar_busq", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_estado_postu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("sugerir_cierre", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("al_cierre_est_busq", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataSetWarning() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluWarnEstBusqCandi");
	    dataset.fieldDef(new Field("oid_warn_est_cand", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_est_cand_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_est_proc_sel", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.INTEGER, 0));
	    return dataset;
	  }  
  
  private void cargarDataSetWarn(IDataSet ds , RecluWarnEstBusqCandi warning) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_warn_est_cand", warning.getOIDInteger());
	  ds.fieldValue("oid_est_cand_busq", warning.getEstado_busqueda().getOIDInteger());
	  ds.fieldValue("oid_est_proc_sel", warning.getEstado_proceso().getOIDInteger());
	  ds.fieldValue("activo" , warning.isActivo());
  }

  private void cargarRegistroRecluEstCandidatoBusq(IDataSet dataset, 
                         Integer oid_est_cand_busq,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Integer color,
                         Boolean puedeCerrarBusq,
                         RecluEstadoPostulante estadoPostulante,
                         Boolean sugerirCierre,
                         RecluEstCandidatoBusq alCierre) {
    dataset.append(); 
    dataset.fieldValue("oid_est_cand_busq", oid_est_cand_busq);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("color", color);
    dataset.fieldValue("puede_cerrar_busq" , puedeCerrarBusq);
    if (estadoPostulante!=null)
    	dataset.fieldValue("oid_estado_postu" , estadoPostulante.getOIDInteger());
    else
    	dataset.fieldValue("oid_estado_postu" , "");
    dataset.fieldValue("sugerir_cierre" , sugerirCierre);
    if (alCierre!=null)
    	dataset.fieldValue("al_cierre_est_busq", alCierre.getOIDInteger());
    else
    	dataset.fieldValue("al_cierre_est_busq", "");
    
  }
}
