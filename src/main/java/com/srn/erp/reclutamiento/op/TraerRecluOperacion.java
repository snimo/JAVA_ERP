package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPermisosOper;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluOperacion extends Operation { 

  public TraerRecluOperacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluOperacion recluoperacion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluoperacion = RecluOperacion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluoperacion = RecluOperacion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluOperacion = getDataSetRecluOperacion();
    IDataSet datasetRecluPermisos = getDataSetRecluPermisos();
    
    if (recluoperacion != null) {
        cargarRegistroRecluOperacion(datasetRecluOperacion,recluoperacion);
        Iterator iterPermisos = recluoperacion.getPermisosOperacion().iterator();
        while (iterPermisos.hasNext()) {
        	RecluPermisosOper permiso = (RecluPermisosOper) iterPermisos.next();
        	cargarRegistroPermiso(datasetRecluPermisos, permiso);
        }
    }
    
    writeCliente(datasetRecluOperacion);
    writeCliente(datasetRecluPermisos);
    
  }

  private IDataSet getDataSetRecluOperacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluOperacion");
    dataset.fieldDef(new Field("oid_operacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  
  private IDataSet getDataSetRecluPermisos() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluPermisosOper");
	    dataset.fieldDef(new Field("oid_oper_hab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_operacion", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_perf_func", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("tipo_oper", Field.STRING, 20));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
	  }  

  private void cargarRegistroRecluOperacion(IDataSet dataset, RecluOperacion recluOperacion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_operacion", recluOperacion.getOIDInteger());
    dataset.fieldValue("codigo", recluOperacion.getCodigo());
    dataset.fieldValue("descripcion", recluOperacion.getDescripcion());
    dataset.fieldValue("activo", recluOperacion.isActivo());
  }
  
  private void cargarRegistroPermiso(IDataSet dataset, RecluPermisosOper permiso) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_oper_hab", permiso.getOIDInteger());
	    dataset.fieldValue("oid_operacion", permiso.getOperacion().getOIDInteger());
	    dataset.fieldValue("oid_perf_func", permiso.getPerfil_funcional().getOIDInteger());
	    dataset.fieldValue("tipo_oper", permiso.getTipo_oper());
	    dataset.fieldValue("activo", permiso.isActivo());
	  }  
  
}
