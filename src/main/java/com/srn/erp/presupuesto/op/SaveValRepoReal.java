package com.srn.erp.presupuesto.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.bm.ValorCompoReal;
import com.srn.erp.presupuesto.bm.ValorRealRepositorio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveValRepoReal extends Operation { 

  public SaveValRepoReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRepositorioReal");
    dataset.first();
    while (!dataset.EOF()) {
    	IDataSet dsValores = dataset.getDataSet("TValoresRepositorioReal");
    	RepositorioReal repoReal = RepositorioReal.findByOid(dataset.getInteger("oid_repo_real"),this.getSesion()); 
    	procesarRegistros(dsValores,repoReal);
    	dataset.next();
    }
  } 

  private void procesarRegistros(IDataSet dataset,RepositorioReal repoReal) throws BaseException {
  	
    dataset.first(); 
    while (!dataset.EOF()) {
    	ValorRealRepositorio valorRealRepo = 
    		ValorRealRepositorio.findByOid(dataset.getInteger("nro_rel"),this.getSesion());
    	
    	asignarValores(dataset,repoReal,valorRealRepo);
    	
    	this.addTransaccion(valorRealRepo);
      dataset.next();
    }
  }
  
  private void asignarValores(IDataSet dataset,
  														RepositorioReal repoReal,
  														ValorRealRepositorio valorRealRepo) throws BaseException {

  	valorRealRepo.setActivo(dataset.getBoolean("activo"));
  	valorRealRepo.setRepositorio_real(repoReal);
  	
  	Iterator iterDefinicionesRepoReal =  repoReal.getDefinicionesRepoReal().iterator();
  	while (iterDefinicionesRepoReal.hasNext()) {
  		  		
  		DefinicionRepositorioReal defRepoReal = 
  			(DefinicionRepositorioReal) iterDefinicionesRepoReal.next();
  		
  		if (defRepoReal.isComponente()) {
  			
  			String campoOidValCompoReal   =  "oid_val_compo_real_"+defRepoReal.getOIDInteger();
  			Integer OidValCompoReal       =  dataset.getInteger(campoOidValCompoReal);
  			ValorCompoReal valorCompoReal =  ValorCompoReal.findByOidProxy(OidValCompoReal,this.getSesion());
  			valorRealRepo.setValorCompoReal(valorCompoReal,
  					                            defRepoReal.getCompo_presupuestario().getNro_interno_compo().intValue());
  			
  		} 
  		else 
  			if (defRepoReal.isTipoPeriodo()) {
  				
  				String campoFecha = "fecha_"+defRepoReal.getOIDInteger();
  				Date fecha = dataset.getDate(campoFecha);
  				valorRealRepo.setValorFecha(fecha,defRepoReal.getTipo_periodo().getNroInterno().intValue());
  				
  			}
    		else 
    			if (defRepoReal.isMetrica()) {
    				
    				String campoMetrica = "metrica_"+defRepoReal.getOIDInteger();
    				Double metrica = dataset.getDouble(campoMetrica);
    				valorRealRepo.setValorMetrica(metrica,defRepoReal.getMetrica().getNroInterno().intValue());
    				
    			}  			  		  	
  		
  	}
  	
		if (valorRealRepo.isActivo().booleanValue()==false)
			valorRealRepo.delete();

  }
  
}
