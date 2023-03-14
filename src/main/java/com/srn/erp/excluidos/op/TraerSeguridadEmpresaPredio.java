package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.PerfExcluidoPerfFunc;
import com.srn.erp.excluidos.bm.SeguEmpresaPredioDet;
import com.srn.erp.excluidos.bm.SeguridadEmpresaPredio;

import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSeguridadEmpresaPredio extends Operation { 

  public TraerSeguridadEmpresaPredio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
    PerfilFuncional perfilFuncional = null;
    
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       perfilFuncional = PerfilFuncional.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       perfilFuncional = PerfilFuncional.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPerfiles 				= getDataSetPerfiles();
    IDataSet datasetSeguridadEmpresaPredio 	= getDataSetSeguridadEmpresaPredio();
    IDataSet datasetSeguridadEmpresaPredioDet = getDataSetSeguEmpresaPredioDet();
    IDataSet datasetPerfFuncPerfExc = getDataSetPerfFuncPerfExc();
    
    if ( perfilFuncional != null) {
    
    	cargarPerfil(datasetPerfiles, perfilFuncional);
    	
    	Iterator iterPerfFuncPerfExc =
    			PerfExcluidoPerfFunc.getPerfExcluidosPerfFuncional(perfilFuncional, this.getSesion()).iterator();
    	while (iterPerfFuncPerfExc.hasNext()) {
    		PerfExcluidoPerfFunc perfExcluidoPerfFunc = (PerfExcluidoPerfFunc) iterPerfFuncPerfExc.next();
    		cargarRegistroPerfFuncPerfExc(datasetPerfFuncPerfExc, perfExcluidoPerfFunc);	
    	}
    	
    	
    	Iterator iterSegEmpPredio = 
    		SeguridadEmpresaPredio.getSeguridadEmpresaPredio(perfilFuncional, this.getSesion()).iterator();
    	while (iterSegEmpPredio.hasNext()) {
    		
    		SeguridadEmpresaPredio segEmpPredio = (SeguridadEmpresaPredio) iterSegEmpPredio.next();
    		cargarRegistroSeguridadEmpresaPredio(datasetSeguridadEmpresaPredio, segEmpPredio);
    		
    		Iterator iterSeguEmpresaPredioDet = segEmpPredio.getSeguEmpresaPredioDet().iterator();
    		while (iterSeguEmpresaPredioDet.hasNext()) {
    			
    			SeguEmpresaPredioDet seguEmpresaPredioDet = (SeguEmpresaPredioDet) iterSeguEmpresaPredioDet.next();
    			cargarRegistroSeguEmpresaPredioDet(datasetSeguridadEmpresaPredioDet, seguEmpresaPredioDet);
    			
    		}
    	}
    		
    }
    
    writeCliente(datasetPerfiles);
    writeCliente(datasetSeguridadEmpresaPredio);
    writeCliente(datasetSeguridadEmpresaPredioDet);
    writeCliente(datasetPerfFuncPerfExc);
    
    
  }
  
  private IDataSet getDataSetPerfiles() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPerfil");
	    dataset.fieldDef(new Field("oid_perfil", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }  

  private IDataSet getDataSetSeguridadEmpresaPredio() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSeguridadEmpresaPredio");
    dataset.fieldDef(new Field("oid_seg_emp_predio", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_perfil", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private void cargarRegistroPerfFuncPerfExc(IDataSet dataset, 
			PerfExcluidoPerfFunc perfExcluidoPerfFunc) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("OID_EXC_PERF_FUNC", perfExcluidoPerfFunc.getOIDInteger());
	  dataset.fieldValue("OID_PERF_FUNC", perfExcluidoPerfFunc.getPerfilfuncional().getOIDInteger());
	  dataset.fieldValue("OID_SEGU_PERFIL", perfExcluidoPerfFunc.getSeguridadperfil().getOIDInteger());
	  dataset.fieldValue("ACTIVO", perfExcluidoPerfFunc.isActivo());
  }  

  private void cargarRegistroSeguridadEmpresaPredio(IDataSet dataset, 
		  											SeguridadEmpresaPredio segEmpPre) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_seg_emp_predio", segEmpPre.getOIDInteger());
    dataset.fieldValue("oid_perfil", segEmpPre.getPerfil().getOIDInteger());
    dataset.fieldValue("oid_empresa", segEmpPre.getEmpresa().getOIDInteger());
    dataset.fieldValue("activo", segEmpPre.isActivo());
  }
  
  private void cargarPerfil(
		  	IDataSet dataset, 
			PerfilFuncional perfilFuncional) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_perfil", perfilFuncional.getOIDInteger());
	  dataset.fieldValue("codigo", perfilFuncional.getCodigo());
	  dataset.fieldValue("descripcion", perfilFuncional.getDescripcion());
	  dataset.fieldValue("activo", perfilFuncional.isActivo());
  }
  
  private IDataSet getDataSetSeguEmpresaPredioDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TSeguEmpresaPredioDet");
	    dataset.fieldDef(new Field("oid_seg_emp_pre_d", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_seg_emp_predio", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_predio_visualiz", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_perfil_act", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("vis_dif_importes", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("vis_vehiculos", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("vis_obs_generales", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("vis_novedades", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("vis_arch_adjuntos", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("vis_pers_rel", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("permitir_alta", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("ver_nros_de_actas", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }
  
  private IDataSet getDataSetPerfFuncPerfExc() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPerfFuncPerfExcluido");
	    dataset.fieldDef(new Field("OID_EXC_PERF_FUNC", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("OID_PERF_FUNC", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("OID_SEGU_PERFIL", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("ACTIVO", Field.INTEGER, 0));
	    return dataset;
  }  
  
  
  

  private void cargarRegistroSeguEmpresaPredioDet(IDataSet dataset, 
	                         SeguEmpresaPredioDet seguEmpresaPredioDet) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_seg_emp_pre_d", seguEmpresaPredioDet.getOIDInteger());
	    dataset.fieldValue("oid_seg_emp_predio", seguEmpresaPredioDet.getSegu_empresa_predio().getOIDInteger());
	    dataset.fieldValue("oid_predio_visualiz", seguEmpresaPredioDet.getPredio().getOIDInteger());
	    dataset.fieldValue("oid_perfil_act", seguEmpresaPredioDet.getPerfil_act().getOIDInteger());
	    dataset.fieldValue("vis_dif_importes", seguEmpresaPredioDet.isVis_dif_importes());
	    dataset.fieldValue("vis_vehiculos", seguEmpresaPredioDet.isVis_vehiculos());
	    dataset.fieldValue("vis_obs_generales", seguEmpresaPredioDet.isVis_obs_generales());
	    dataset.fieldValue("vis_novedades", seguEmpresaPredioDet.isVis_novedades());
	    dataset.fieldValue("vis_arch_adjuntos", seguEmpresaPredioDet.isVis_arch_adjuntos());
	    dataset.fieldValue("vis_pers_rel", seguEmpresaPredioDet.isVis_pers_rel());
	    dataset.fieldValue("permitir_alta", seguEmpresaPredioDet.isPermitir_alta());
	    dataset.fieldValue("ver_nros_de_actas", seguEmpresaPredioDet.isVer_nros_de_actas());
	    dataset.fieldValue("activo", seguEmpresaPredioDet.isActivo());
  }
  
    
  
  
}
