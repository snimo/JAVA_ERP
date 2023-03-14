package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.EstructuraTipoCiclo;
import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.bm.GrupoUPCTipoCiclo;
import com.srn.erp.presupuesto.bm.TipoCiclo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCiclo extends Operation { 

  public TraerTipoCiclo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    	
  	
  	if (mapaDatos.containsKey("es_nuevo"))
  		enviarNuevoTipoCiclo(mapaDatos);
  	else
  		enviarTipoCicloExistente(mapaDatos);
  	
    
  }
  
  private void enviarTipoCicloExistente(MapDatos mapaDatos) throws BaseException {
  	
    IDataSet datasetTipoCiclo = this.getDataSetTipoCiclo();
    IDataSet datasetEstrucTipoCiclo = this.getDataSetEstructuraTipoCiclo();
    IDataSet datasetGrupoUPCTipoCiclo = this.getDataSetGrupoUPCTipoCiclo();
    
    TipoCiclo tipoCiclo = TipoCiclo.findByOid(mapaDatos.getInteger("oid"),this.getSesion());
    cargarRegistroTipoCiclo(datasetTipoCiclo,tipoCiclo);
    
    int newOid = 0;
    
    Iterator iterEstrucPlanif = EstructuraPlanificacion.getAllEstructuras(this.getSesion()).iterator();
    while (iterEstrucPlanif.hasNext()) {
    	EstructuraPlanificacion estrucPlanif = (EstructuraPlanificacion) iterEstrucPlanif.next();
    	
    	EstructuraTipoCiclo estrucTipoCiclo =
    		tipoCiclo.getEstructuraTipoCiclo(estrucPlanif);
    	if ((estrucTipoCiclo !=null) && (estrucTipoCiclo.isActivo().booleanValue()==true)) 
    		cargarRegistroEstructuraTipoCiclo(datasetEstrucTipoCiclo,estrucTipoCiclo);
    	else {
    		if (estrucTipoCiclo==null) {
    			estrucTipoCiclo = (EstructuraTipoCiclo) EstructuraTipoCiclo.getNew(EstructuraTipoCiclo.NICKNAME,this.getSesion());
    			--newOid;
    			estrucTipoCiclo.setOID(new Integer(newOid));
    		}
        estrucTipoCiclo.setTipo_ciclo(tipoCiclo);
        estrucTipoCiclo.setEstructura_planificacion(estrucPlanif);
        estrucTipoCiclo.setActivo(new Boolean(false));
      	cargarRegistroEstructuraTipoCiclo(datasetEstrucTipoCiclo,estrucTipoCiclo);
    	}
    }
    
    Iterator iterGrupoUPC = GrupoTipoUPC.getAllGruposTipoUPC(this.getSesion()).iterator();
    while (iterGrupoUPC.hasNext()) {
    	GrupoTipoUPC grupoTipoUPC = (GrupoTipoUPC) iterGrupoUPC.next();
    	
    	GrupoUPCTipoCiclo grupoUPCTipoCiclo =
    		tipoCiclo.getGrupoUPCTipoCiclo(grupoTipoUPC);
    	if ((grupoUPCTipoCiclo !=null) && (grupoUPCTipoCiclo.isActivo().booleanValue()==true)) 
    		cargarRegistroGrupoUPCTipoCiclo(datasetGrupoUPCTipoCiclo,grupoUPCTipoCiclo);
    	else {
    		if (grupoUPCTipoCiclo==null) {
    			grupoUPCTipoCiclo = (GrupoUPCTipoCiclo) GrupoUPCTipoCiclo.getNew(GrupoUPCTipoCiclo.NICKNAME,this.getSesion());
    			--newOid;
    			grupoUPCTipoCiclo.setOID(new Integer(newOid));
    		}
    		grupoUPCTipoCiclo.setTipo_ciclo(tipoCiclo);
    		grupoUPCTipoCiclo.setGrupo_tipo_upc(grupoTipoUPC);
    		grupoUPCTipoCiclo.setActivo(new Boolean(false));
      	this.cargarRegistroGrupoUPCTipoCiclo(datasetGrupoUPCTipoCiclo,grupoUPCTipoCiclo);
    	}
    }
    
    writeCliente(datasetTipoCiclo);
    writeCliente(datasetEstrucTipoCiclo);
    writeCliente(datasetGrupoUPCTipoCiclo);
  	
  }
  
  private void enviarNuevoTipoCiclo(MapDatos mapaDatos) throws BaseException {
  	
  	int newOid = 0;
  	
    IDataSet datasetEstrucTipoCiclo = this.getDataSetEstructuraTipoCiclo();
    IDataSet datasetGrupoUPCTipoCiclo = this.getDataSetGrupoUPCTipoCiclo();
    
    //Simular Nuevo Tipo de ciclo
    TipoCiclo tipoCiclo = (TipoCiclo)TipoCiclo.getNew(TipoCiclo.NICKNAME,this.getSesion());
    tipoCiclo.setOID(mapaDatos.getInteger("oid_tipo_ciclo"));
    
    Iterator iterEstrucPlanif = EstructuraPlanificacion.getAllEstructuras(this.getSesion()).iterator();
    while (iterEstrucPlanif.hasNext()) {
    	EstructuraPlanificacion estrucPlanif = (EstructuraPlanificacion) iterEstrucPlanif.next();
    	
    	EstructuraTipoCiclo estrucTipoCiclo = 
    		(EstructuraTipoCiclo) EstructuraTipoCiclo.getNew(EstructuraTipoCiclo.NICKNAME,this.getSesion());
    	--newOid;
    	estrucTipoCiclo.setOID(new Integer(newOid));
    	estrucTipoCiclo.setTipo_ciclo(tipoCiclo);
    	estrucTipoCiclo.setEstructura_planificacion(estrucPlanif);
    	estrucTipoCiclo.setActivo(new Boolean(false));
    	
    	cargarRegistroEstructuraTipoCiclo(datasetEstrucTipoCiclo,estrucTipoCiclo);
    	
    }
    
    Iterator iterGruposTipoUPC = GrupoTipoUPC.getAllGruposTipoUPC(this.getSesion()).iterator();
    while (iterGruposTipoUPC.hasNext()) {
    	GrupoTipoUPC grupoTipoUPC = (GrupoTipoUPC) iterGruposTipoUPC.next();
    	
    	GrupoUPCTipoCiclo grupoUPCTipoCiclo = 
    		(GrupoUPCTipoCiclo) GrupoUPCTipoCiclo.getNew(GrupoUPCTipoCiclo.NICKNAME,this.getSesion());
    	--newOid;
    	grupoUPCTipoCiclo.setOID(new Integer(newOid));
    	grupoUPCTipoCiclo.setTipo_ciclo(tipoCiclo);
    	grupoUPCTipoCiclo.setGrupo_tipo_upc(grupoTipoUPC);
    	grupoUPCTipoCiclo.setActivo(new Boolean(true));
    	
    	cargarRegistroGrupoUPCTipoCiclo(datasetGrupoUPCTipoCiclo,grupoUPCTipoCiclo);
    	
    }
    
    writeCliente(datasetEstrucTipoCiclo);
    writeCliente(datasetGrupoUPCTipoCiclo);
  	
  }
  
  
  private IDataSet getDataSetTipoCiclo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoCiclo");
    dataset.fieldDef(new Field("oid_tipo_ciclo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_val_escenario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoCiclo(IDataSet dataset, 
                                       TipoCiclo tipoCiclo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tipo_ciclo", tipoCiclo.getOIDInteger());
    dataset.fieldValue("codigo", tipoCiclo.getCodigo());
    dataset.fieldValue("descripcion", tipoCiclo.getDescripcion());
    if (tipoCiclo.getValor_escenario()!=null)
    	dataset.fieldValue("oid_val_escenario", tipoCiclo.getValor_escenario().getOIDInteger());
    else
    	dataset.fieldValue("oid_val_escenario", new Integer(0));
    dataset.fieldValue("activo", tipoCiclo.isActivo());
  }
  
  private IDataSet getDataSetEstructuraTipoCiclo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstructuraTipoCiclo");
    dataset.fieldDef(new Field("oid_estruc_tipo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_tipo_ciclo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_estruc_planif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_estructura", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private void cargarRegistroEstructuraTipoCiclo(IDataSet dataset, 
      																					 EstructuraTipoCiclo estructura) throws BaseException {
  	dataset.append(); 
  	dataset.fieldValue("oid_estruc_tipo", estructura.getOIDInteger());
  	dataset.fieldValue("oid_tipo_ciclo", estructura.getTipo_ciclo().getOIDInteger());
  	dataset.fieldValue("oid_estruc_planif", estructura.getEstructura_planificacion().getOIDInteger());
  	dataset.fieldValue("desc_estructura", estructura.getEstructura_planificacion().getDescripcion());
  	dataset.fieldValue("activo", estructura.isActivo());
  }
  
  private IDataSet getDataSetGrupoUPCTipoCiclo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoUPCTipoCiclo");
    dataset.fieldDef(new Field("oid_grupo_upc_tipo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_tipo_ciclo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_tipo_upc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_grupo_tipo_upc", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoUPCTipoCiclo(IDataSet dataset, 
                         GrupoUPCTipoCiclo grupoUPCTipoCiclo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_upc_tipo", grupoUPCTipoCiclo.getOIDInteger());
    dataset.fieldValue("oid_tipo_ciclo", grupoUPCTipoCiclo.getTipo_ciclo().getOIDInteger());
    dataset.fieldValue("oid_grupo_tipo_upc", grupoUPCTipoCiclo.getGrupo_tipo_upc().getOIDInteger());
    dataset.fieldValue("desc_grupo_tipo_upc",grupoUPCTipoCiclo.getGrupo_tipo_upc().getDescripcion());
    dataset.fieldValue("activo", grupoUPCTipoCiclo.isActivo());
  }  
  
  
}
