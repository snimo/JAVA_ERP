package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.PerfExcluidoPerfFunc;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.SeguEmpresaPredioDet;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.bm.SeguridadEmpresaPredio;
import com.srn.erp.general.bm.Empresa;

import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSeguridadEmpresaPredio extends Operation { 

  public SaveSeguridadEmpresaPredio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPerfil"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) {
    	  
    	PerfilFuncional perfilFuncional = PerfilFuncional.findByOid(dataset.getInteger("oid_perfil"), this.getSesion());
    	
    	setRefreshObjNeg(perfilFuncional.getOIDInteger());
    	
    	IDataSet dsPerfFuncPerfExc = dataset.getDataSet("TPerfFuncPerfExcluido");
    	dsPerfFuncPerfExc.first();
    	while (!dsPerfFuncPerfExc.EOF()) {
    		PerfExcluidoPerfFunc perfExcluidoPerfFunc =
    				PerfExcluidoPerfFunc.findByOid(dsPerfFuncPerfExc.getInteger("OID_EXC_PERF_FUNC"), this.getSesion());
    		perfExcluidoPerfFunc.setPerfilfuncional(perfilFuncional);
    		perfExcluidoPerfFunc.setSeguridadperfil(SeguPerfilExcluido.findByOidProxy(dsPerfFuncPerfExc.getInteger("OID_SEGU_PERFIL"), this.getSesion()));
    		perfExcluidoPerfFunc.setActivo(dsPerfFuncPerfExc.getBoolean("ACTIVO"));
    		this.addTransaccion(perfExcluidoPerfFunc);
    		dsPerfFuncPerfExc.next();
    	}
    	
    	IDataSet dsSeguEmprePredio = dataset.getDataSet("TSeguridadEmpresaPredio");
    	dsSeguEmprePredio.first();
    	while (!dsSeguEmprePredio.EOF()) {
    		
    		SeguridadEmpresaPredio seguridadEmpresaPredio =
    			SeguridadEmpresaPredio.findByOid(dsSeguEmprePredio.getInteger("oid_seg_emp_predio"), this.getSesion());
    		seguridadEmpresaPredio.setPerfil(perfilFuncional);
    		seguridadEmpresaPredio.setEmpresa(Empresa.findByOidProxy(dsSeguEmprePredio.getInteger("oid_empresa"), this.getSesion()));
    		seguridadEmpresaPredio.setActivo(dsSeguEmprePredio.getBoolean("activo"));
    		
    		addTransaccion(seguridadEmpresaPredio);
    		
    		IDataSet dsSeguridadEmpresaPredioDet = dsSeguEmprePredio.getDataSet("TSeguEmpresaPredioDet");
    		dsSeguridadEmpresaPredioDet.first();
    		while (!dsSeguridadEmpresaPredioDet.EOF()) {
    			
    			SeguEmpresaPredioDet seguEmpresaPredioDet = SeguEmpresaPredioDet.findByOid(dsSeguridadEmpresaPredioDet.getInteger("oid_seg_emp_pre_d"), this.getSesion());
    			seguEmpresaPredioDet.setSegu_empresa_predio(seguridadEmpresaPredio);
    			seguEmpresaPredioDet.setPredio(PredioExcluido.findByOidProxy(dsSeguridadEmpresaPredioDet.getInteger("oid_predio_visualiz"), this.getSesion()));
    			seguEmpresaPredioDet.setPerfil_act(PerfilFuncional.findByOidProxy(dsSeguridadEmpresaPredioDet.getInteger("oid_perfil_act"), this.getSesion()));
    			seguEmpresaPredioDet.setVis_dif_importes(dsSeguridadEmpresaPredioDet.getBoolean("vis_dif_importes"));
    			seguEmpresaPredioDet.setVis_vehiculos(dsSeguridadEmpresaPredioDet.getBoolean("vis_vehiculos"));
    			seguEmpresaPredioDet.setVis_obs_generales(dsSeguridadEmpresaPredioDet.getBoolean("vis_obs_generales"));
    			seguEmpresaPredioDet.setVis_novedades(dsSeguridadEmpresaPredioDet.getBoolean("vis_novedades"));
    			seguEmpresaPredioDet.setVis_arch_adjuntos(dsSeguridadEmpresaPredioDet.getBoolean("vis_arch_adjuntos"));
    			seguEmpresaPredioDet.setVis_pers_rel(dsSeguridadEmpresaPredioDet.getBoolean("vis_pers_rel"));
    			seguEmpresaPredioDet.setPermitir_alta(dsSeguridadEmpresaPredioDet.getBoolean("permitir_alta"));
    			seguEmpresaPredioDet.setVer_nros_de_actas(dsSeguridadEmpresaPredioDet.getBoolean("ver_nros_de_actas"));
    			seguEmpresaPredioDet.setActivo(dsSeguridadEmpresaPredioDet.getBoolean("activo"));
    			
    			seguridadEmpresaPredio.addSeguEmpresaPredioDet(seguEmpresaPredioDet);
    			
    			dsSeguridadEmpresaPredioDet.next();
    		}
    		
    		dsSeguEmprePredio.next();
    		
    	}
        dataset.next();
    }
      
       
  }
  
}
