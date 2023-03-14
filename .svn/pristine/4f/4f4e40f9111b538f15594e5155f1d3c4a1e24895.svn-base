package com.srn.erp.presupuesto.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.bm.ValorCompoReal;
import com.srn.erp.presupuesto.bm.ValorRealRepositorio;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValRepoReal extends Operation { 

  public TraerValRepoReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
  	
  	RepositorioReal repoReal = 
  		RepositorioReal.findByOidProxy(mapaDatos.getInteger("oid_repo_real"),this.getSesion());
  	
  	IDataSet dsTipoPeriodo   = mapaDatos.getDataSet("TTipoPeriodo");
  	IDataSet dsFiltrosCompo  = mapaDatos.getDataSet("TFiltroComponentes");
  	IDataSet dsValCompoReal1 = mapaDatos.getDataSet("TFiltroValReal1");
  	IDataSet dsValCompoReal2 = mapaDatos.getDataSet("TFiltroValReal2");
  	IDataSet dsValCompoReal3 = mapaDatos.getDataSet("TFiltroValReal3");
  	IDataSet dsValCompoReal4 = mapaDatos.getDataSet("TFiltroValReal4");
  	IDataSet dsValCompoReal5 = mapaDatos.getDataSet("TFiltroValReal5");
  	
  	IDataSet ds = getDataSetValRepoReal(repoReal);
  	
  	traerValoresRepositorioReal(ds,
  															repoReal,
  															dsTipoPeriodo,
  															dsFiltrosCompo,
  															dsValCompoReal1,
  															dsValCompoReal2,
  															dsValCompoReal3,
  															dsValCompoReal4,
  															dsValCompoReal5
  															);
  	
  	writeCliente(ds);
  	
  	
  } 
  
  private IDataSet getDataSetValRepoReal(RepositorioReal repoReal) throws BaseException {
  	
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresRepositorioReal");
    
    dataset.fieldDef(new Field("nro_rel", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_rel_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    
  	Iterator iterDefinicionesRepoReal =  repoReal.getDefinicionesRepoReal().iterator();
  	while (iterDefinicionesRepoReal.hasNext()) {
  		
  		DefinicionRepositorioReal defRepoReal = 
  			(DefinicionRepositorioReal) iterDefinicionesRepoReal.next();
  		
  		if (defRepoReal.isComponente()) {
  			String campoOid = "oid_val_compo_real_"+defRepoReal.getOIDInteger();
  			String compoCod = "cod_val_compo_real_"+defRepoReal.getOIDInteger();
  			String compoDes = "desc_val_compo_real_"+defRepoReal.getOIDInteger();
  			dataset.fieldDef(new Field(campoOid, Field.INTEGER, 0));
  			dataset.fieldDef(new Field(compoCod,Field.STRING, 50));
  			dataset.fieldDef(new Field(compoDes,Field.STRING, 255));
  		} 
  		else
    		if (defRepoReal.isTipoPeriodo()) {
    			String campoFecha = "fecha_"+defRepoReal.getOIDInteger();
    			dataset.fieldDef(new Field(campoFecha, Field.DATE, 0));
    		}
    		else if (defRepoReal.isMetrica()) {
    			String campoMetrica = "metrica_"+defRepoReal.getOIDInteger();
    			dataset.fieldDef(new Field(campoMetrica, Field.CURRENCY, 0));
    		}
  		
  	}
    
    return dataset;
  }
  
  private void traerValoresRepositorioReal(IDataSet ds,
  																				 RepositorioReal repoReal,
  																				 IDataSet dsTipoPeriodo,
  																				 IDataSet dsFiltrosCompo,
  																				 IDataSet dsValCompoReal1,
  																				 IDataSet dsValCompoReal2,
  																				 IDataSet dsValCompoReal3,
  																				 IDataSet dsValCompoReal4,
  																				 IDataSet dsValCompoReal5) throws BaseException {
  	
  	Iterator iterValoresRealesRepo = 
  		repoReal.getValoresRealesByFiltrosVarios(dsTipoPeriodo,
  																						 dsFiltrosCompo,
  																						 dsValCompoReal1,
  																						 dsValCompoReal2,
  																						 dsValCompoReal3,
  																						 dsValCompoReal4,
  																						 dsValCompoReal5).iterator();
  	while (iterValoresRealesRepo.hasNext()) {
  		ValorRealRepositorio valorRealRepo = (ValorRealRepositorio) iterValoresRealesRepo.next();
  		cargarRegistroValorRealRepo(ds,valorRealRepo,repoReal);
  	}
  	
  }
  
  private void cargarRegistroValorRealRepo(IDataSet ds,ValorRealRepositorio valorRealRepo,RepositorioReal repoReal) throws BaseException {
  	ds.append();
  	ds.fieldValue("nro_rel", valorRealRepo.getOIDInteger());
  	ds.fieldValue("nro_rel_padre", new Integer(0));
  	ds.fieldValue("activo", new Boolean(true));
  	
  	Iterator iterDefinicionesRepoReal =  repoReal.getDefinicionesRepoReal().iterator();
  	while (iterDefinicionesRepoReal.hasNext()) {
  		
  		DefinicionRepositorioReal defRepoReal = 
  			(DefinicionRepositorioReal) iterDefinicionesRepoReal.next();
  		
  		if (defRepoReal.isComponente()) {
  			ValorCompoReal valCompoReal = valorRealRepo.getValorCompoReal(defRepoReal.getCompo_presupuestario().getNro_interno_compo().intValue());
  			String campoOid = "oid_val_compo_real_"+defRepoReal.getOIDInteger();
  			String campoCod = "cod_val_compo_real_"+defRepoReal.getOIDInteger();
  			String campoDes = "desc_val_compo_real_"+defRepoReal.getOIDInteger();
  			if (valCompoReal!=null) {
  			  ds.fieldValue(campoOid,valCompoReal.getOID());
  			  ds.fieldValue(campoCod,valCompoReal.getCodigo());
  			  ds.fieldValue(campoDes,valCompoReal.getDescripcion());
  			}
  			else {
  			  ds.fieldValue(campoOid,new Integer(0));
  			  ds.fieldValue(campoCod,"");
  			  ds.fieldValue(campoDes,"");
  			}
  		} 
  		else
    		if (defRepoReal.isTipoPeriodo()) {
    			String campoFecha = "fecha_"+defRepoReal.getOIDInteger();
    			Date fecha = valorRealRepo.getFechaTipoPeri(defRepoReal.getTipo_periodo().getNroInterno().intValue());
    			if (fecha!=null)
    				ds.fieldValue(campoFecha, fecha);
    			else
    				ds.fieldValue(campoFecha, Fecha.FECHA_NULA());	
    		}
    		else if (defRepoReal.isMetrica()) {
    			String campoMetrica = "metrica_"+defRepoReal.getOIDInteger();
    			Double valorMetrica = valorRealRepo.getMetrica(defRepoReal.getMetrica().getNroInterno().intValue());
    			if (valorMetrica!=null)
    				ds.fieldValue(campoMetrica, valorMetrica);
    			else
    				ds.fieldValue(campoMetrica, new Double(0));
    		}
  		
  	}
  	
  	
  	
  }

  
}
