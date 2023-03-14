package com.srn.erp.presupuesto.op;


import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.GrupoEstructuraPlanif;
import com.srn.erp.presupuesto.bm.NodoEstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.UPC;
import com.srn.erp.presupuesto.bm.UPCNodoEstructura;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEstructuraPlanificacion extends Operation { 

  public SaveEstructuraPlanificacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEstructuraPlanificacion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EstructuraPlanificacion estructuraplanificacion = EstructuraPlanificacion.findByOid(dataset.getInteger("oid_estruc_planif"),getSesion());
        estructuraplanificacion.setOID(dataset.getInteger("oid_estruc_planif"));
        estructuraplanificacion.setCodigo(dataset.getString("codigo"));
        estructuraplanificacion.setDescripcion(dataset.getString("descripcion"));
        estructuraplanificacion.setActivo(dataset.getBoolean("activo"));
        estructuraplanificacion.setGrupoEstructuraPlanif(GrupoEstructuraPlanif.findByOidProxy(dataset.getInteger("oid_grupo_est"),this.getSesion()));
        
        IDataSet dsNodos = dataset.getDataSet("TNodoEstructuraPlanificacion");
        dsNodos.first();
        while (!dsNodos.EOF()) {
          NodoEstructuraPlanificacion nodo = NodoEstructuraPlanificacion.findByOid(dsNodos.getInteger("oid_nodo_estruc"),getSesion());
          nodo.setOID(dsNodos.getInteger("oid_nodo_estruc"));
          nodo.setEstructura_planificacion(EstructuraPlanificacion.findByOidProxy(dsNodos.getInteger("oid_estruc_planif"),this.getSesion()));
          nodo.setNro_relacion(dsNodos.getInteger("nro_rel"));
          nodo.setNro_relacion_padre(dsNodos.getInteger("nro_rel_padre"));
          nodo.setNombre(dsNodos.getString("nombre"));
          nodo.setAncho(dsNodos.getInteger("ancho"));
          nodo.setAlto(dsNodos.getInteger("alto"));
          nodo.setColor(dsNodos.getInteger("color"));
          nodo.setOrden(dsNodos.getInteger("orden"));
          nodo.setAlineacion(dsNodos.getString("alineacion"));
          nodo.setActivo(dsNodos.getBoolean("activo"));
          if (nodo.isActivo().booleanValue()==false)
          	nodo.anular();
          
          //
          IDataSet dsUPCNodo = dsNodos.getDataSet("TUPCNodo");
          dsUPCNodo.first();
          while (!dsUPCNodo.EOF()) {
          	UPCNodoEstructura upcNodo = UPCNodoEstructura.findByOid(dsUPCNodo.getInteger("oid_upc_nodo"),this.getSesion());
          	upcNodo.setOrden(dsUPCNodo.getInteger("orden"));
          	upcNodo.setNodo_estructura(nodo);
          	upcNodo.setUpc(UPC.findByOidProxy(dsUPCNodo.getInteger("oid_upc"),this.getSesion()));
          	upcNodo.setActivo(dsUPCNodo.getBoolean("activo"));
          	nodo.addUPCHabilitada(upcNodo);
          	dsUPCNodo.next();
          }
          
          
          estructuraplanificacion.addNodoEstructura(nodo);
        	dsNodos.next();
        }
        
        
        
        addTransaccion(estructuraplanificacion);
        dataset.next();
    }
  }
  
}
