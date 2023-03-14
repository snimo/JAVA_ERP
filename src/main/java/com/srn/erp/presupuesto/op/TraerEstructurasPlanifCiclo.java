package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CicloPresupuestal;
import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.EstructuraTipoCiclo;
import com.srn.erp.presupuesto.bm.NodoEstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.UPC;
import com.srn.erp.presupuesto.bm.UPCNodoEstructura;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstructurasPlanifCiclo extends Operation { 

	int oidNodoUPC = 0;
	
  public TraerEstructurasPlanifCiclo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

  	IDataSet dsCiclo = this.getDataSetCiclo();
  	IDataSet dsEstrucPlanif = this.getDataSetEstructuraPlanificacion();
  	IDataSet dsNodosEstruc = this.getDataSetNodoEstructuraPlanificacion();
  	
  	CicloPresupuestal ciclo = 
  		CicloPresupuestal.findByOid(mapaDatos.getInteger("oid_ciclo_presu"),this.getSesion());
  	
  	cargarCiclo(dsCiclo,ciclo);
  	Iterator iterEtrucTipoCiclo = 
  		ciclo.getTipo_ciclo().getEstructurasTipoCiclo().iterator();
  	while (iterEtrucTipoCiclo.hasNext()) {
  		EstructuraTipoCiclo estructuraTipoCiclo = (EstructuraTipoCiclo) iterEtrucTipoCiclo.next();
  		enviarEstrucPlanif(dsEstrucPlanif,estructuraTipoCiclo.getEstructura_planificacion());
  		
  		EstructuraPlanificacion estrucPlanif = estructuraTipoCiclo.getEstructura_planificacion();
  		Iterator iterNodosEstrucPlanif = estrucPlanif.getNodosEstructura().iterator();
  		while (iterNodosEstrucPlanif.hasNext()) {
  			NodoEstructuraPlanificacion nodoEstrucPlanif = 
  				(NodoEstructuraPlanificacion) iterNodosEstrucPlanif.next();
  			cargarRegistroNodoEstructuraPlanificacion(dsNodosEstruc,nodoEstrucPlanif);
  			
  			Iterator iterUPCHabilitadas =  nodoEstrucPlanif.getUPCHabilitadas().iterator();
  			while (iterUPCHabilitadas.hasNext()) {
  				UPCNodoEstructura upcNodoEstructura = (UPCNodoEstructura) iterUPCHabilitadas.next();
  				UPC upc = upcNodoEstructura.getUpc();
  				if (ciclo.mostrarUPC(upc)) 
  					cargarRegistroNodoUPC(dsNodosEstruc,estrucPlanif,upc,nodoEstrucPlanif.getNro_relacion());
  			}
  		}
  	}
  	
  	writeCliente(dsCiclo);
  	writeCliente(dsEstrucPlanif);
  	writeCliente(dsNodosEstruc);
  	
  }
  
  private void enviarEstrucPlanif(IDataSet ds,EstructuraPlanificacion estrucPlanif) throws BaseException {
    ds.append(); 
    ds.fieldValue("oid_estruc_planif", estrucPlanif.getOIDInteger());
    ds.fieldValue("codigo", estrucPlanif.getCodigo());
    ds.fieldValue("descripcion", "    "+estrucPlanif.getDescripcion());
    ds.fieldValue("activo", estrucPlanif.isActivo());
    ds.fieldValue("oid_grupo_est",estrucPlanif.getGrupoEstructuraPlanif().getOID());
    ds.fieldValue("desc_grupo_est",estrucPlanif.getGrupoEstructuraPlanif().getDescripcion());
  }
  
  private IDataSet getDataSetEstructuraPlanificacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstructuraPlanificacion");
    dataset.fieldDef(new Field("oid_estruc_planif", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_grupo_est", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_grupo_est", Field.STRING, 100));
    return dataset;
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
  
  private IDataSet getDataSetCiclo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCiclo");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    return dataset;
  }
  
  private void cargarCiclo(IDataSet ds,CicloPresupuestal ciclo) throws BaseException {
    ds.append(); 
    ds.fieldValue("oid", ciclo.getOIDInteger());
    ds.fieldValue("codigo", ciclo.getCodigo());
    ds.fieldValue("descripcion", ciclo.getDescripcion());
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
  
  private void cargarRegistroNodoUPC(IDataSet dataset,
  																	 EstructuraPlanificacion estrucPlanif,
			 															 UPC upc,
			 															 Integer oidNroRelacionPadre) throws BaseException {
  	Integer oid = new Integer(--oidNodoUPC);
  	dataset.append(); 
  	dataset.fieldValue("oid_nodo_estruc", oid);
  	dataset.fieldValue("oid_estruc_planif", estrucPlanif.getOID());
  	dataset.fieldValue("nro_rel", new Integer(--oidNodoUPC));
  	dataset.fieldValue("nro_rel_padre", oidNroRelacionPadre);
  	dataset.fieldValue("nombre", upc.getDescripcion());
  	dataset.fieldValue("ancho", new Integer(0));
  	dataset.fieldValue("alto", new Integer(0));
  	dataset.fieldValue("color", new Integer(0));
  	dataset.fieldValue("orden", new Integer(0));
  	dataset.fieldValue("alineacion", "");
  	dataset.fieldValue("activo", upc.isActivo());
}  
  

    
}
