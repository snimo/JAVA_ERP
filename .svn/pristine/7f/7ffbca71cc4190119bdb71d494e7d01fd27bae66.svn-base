package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.NodoEstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.UPCNodoEstructura;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstructuraPlanificacion extends Operation { 

  public TraerEstructuraPlanificacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstructuraPlanificacion estructuraplanificacion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estructuraplanificacion = EstructuraPlanificacion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estructuraplanificacion = EstructuraPlanificacion.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstructuraPlanificacion = getDataSetEstructuraPlanificacion();
    IDataSet datasetNodo = getDataSetNodoEstructuraPlanificacion();
    IDataSet datasetUPCsNodo = getDataSetUPCHabilitadaNodo();
    
    if (estructuraplanificacion != null) {
    	
        cargarRegistroEstructuraPlanificacion(datasetEstructuraPlanificacion, 
                         estructuraplanificacion);
        
        Iterator iterNodos = estructuraplanificacion.getNodosEstructura().iterator();
        while (iterNodos.hasNext()) {
        	NodoEstructuraPlanificacion nodo = (NodoEstructuraPlanificacion) iterNodos.next();
        	if (nodo.isActivo().booleanValue()==false) continue;
        	cargarRegistroNodoEstructuraPlanificacion(datasetNodo,nodo);
        	
        	Iterator iterUPCHab = nodo.getUPCHabilitadas().iterator();
        	while (iterUPCHab.hasNext()) {
        		UPCNodoEstructura upcNodoEstructura = (UPCNodoEstructura) iterUPCHab.next();
        		if (upcNodoEstructura.isActivo().booleanValue()==false) continue;
        		cargarRegistroUPCNodo(datasetUPCsNodo,upcNodoEstructura);
        	}
        	
       	
        }
        
        
    }
    
    writeCliente(datasetEstructuraPlanificacion);
    writeCliente(datasetNodo);
    writeCliente(datasetUPCsNodo);
  }

  private IDataSet getDataSetEstructuraPlanificacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstructuraPlanificacion");
    dataset.fieldDef(new Field("oid_estruc_planif", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_grupo_est", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroEstructuraPlanificacion(IDataSet dataset, 
                         			EstructuraPlanificacion estructuraPlanif) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_estruc_planif", estructuraPlanif.getOIDInteger());
    dataset.fieldValue("codigo", estructuraPlanif.getCodigo());
    dataset.fieldValue("descripcion", estructuraPlanif.getDescripcion());
    dataset.fieldValue("activo", estructuraPlanif.isActivo());
    dataset.fieldValue("oid_grupo_est",estructuraPlanif.getGrupoEstructuraPlanif().getOID());
  }
  
  private IDataSet getDataSetNodoEstructuraPlanificacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TNodoEstructuraPlanificacion");
    dataset.fieldDef(new Field("oid_nodo_estruc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_estruc_planif", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_rel", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_rel_padre", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nombre", Field.STRING, 255)); 
    dataset.fieldDef(new Field("ancho", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("alto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("color", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("alineacion", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroNodoEstructuraPlanificacion(IDataSet dataset, 
                         NodoEstructuraPlanificacion nodo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_nodo_estruc", nodo.getOIDInteger());
    dataset.fieldValue("oid_estruc_planif", nodo.getEstructura_planificacion().getOIDInteger());
    dataset.fieldValue("nro_rel", nodo.getNro_relacion());
    dataset.fieldValue("nro_rel_padre", nodo.getNro_relacion_padre());
    dataset.fieldValue("nombre", nodo.getNombre());
    dataset.fieldValue("ancho", nodo.getAncho());
    dataset.fieldValue("alto", nodo.getAlto());
    dataset.fieldValue("color", nodo.getColor());
    dataset.fieldValue("orden", nodo.getOrden());
    dataset.fieldValue("alineacion", nodo.getAlineacion());
    dataset.fieldValue("activo", nodo.isActivo());
  }  
  

  private IDataSet getDataSetUPCHabilitadaNodo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TUPCNodo");
    dataset.fieldDef(new Field("oid_upc_nodo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_nodo_estruc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_upc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_upc", Field.INTEGER, 50));
    dataset.fieldDef(new Field("desc_upc", Field.INTEGER, 255));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private void cargarRegistroUPCNodo(IDataSet dataset, 
      															 UPCNodoEstructura upcNodoEstructura) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_upc_nodo", upcNodoEstructura.getOIDInteger());
  	dataset.fieldValue("orden", upcNodoEstructura.getOrden());
  	dataset.fieldValue("oid_nodo_estruc", upcNodoEstructura.getNodo_estructura().getOIDInteger());
  	dataset.fieldValue("oid_upc", upcNodoEstructura.getUpc().getOIDInteger());
  	dataset.fieldValue("cod_upc", upcNodoEstructura.getUpc().getCodigo());
  	dataset.fieldValue("desc_upc", upcNodoEstructura.getUpc().getDescripcion());
  	dataset.fieldValue("activo", upcNodoEstructura.isActivo());
}
  
  
  
}
