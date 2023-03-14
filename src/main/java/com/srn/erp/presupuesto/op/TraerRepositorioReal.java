package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.RepositorioReal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRepositorioReal extends Operation { 

  public TraerRepositorioReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
    RepositorioReal repositorioreal = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       repositorioreal = RepositorioReal.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       repositorioreal = RepositorioReal.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRepositorioReal = getDataSetRepositorioReal();
    IDataSet datasetRepositorioRealDet = getDataSetDefinicionRepositorioReal();
    
    if (repositorioreal != null) { 
    	
        cargarRegistroRepositorioReal(datasetRepositorioReal, 
        															repositorioreal);
        
        Iterator iterDefRepoReal = repositorioreal.getDefinicionesRepoReal().iterator();
        while (iterDefRepoReal.hasNext()) {
        	DefinicionRepositorioReal defRepoReal = (DefinicionRepositorioReal) iterDefRepoReal.next();
        	cargarRegistroDefinicionRepositorioReal(datasetRepositorioRealDet,defRepoReal);
        }
        
    }
    
    writeCliente(datasetRepositorioReal);
    writeCliente(datasetRepositorioRealDet);
    
  }

  private IDataSet getDataSetRepositorioReal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRepositorioReal");
    dataset.fieldDef(new Field("oid_repo_real", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_grupo_repo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRepositorioReal(IDataSet dataset, 
                         RepositorioReal repositorioReal) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_repo_real", repositorioReal.getOIDInteger());
    dataset.fieldValue("codigo", repositorioReal.getCodigo());
    dataset.fieldValue("descripcion", repositorioReal.getDescripcion());
    if (repositorioReal.getGrupoRepositorioReal()!=null)
    	dataset.fieldValue("oid_grupo_repo", repositorioReal.getGrupoRepositorioReal().getOID());
    else
    	dataset.fieldValue("oid_grupo_repo", new Integer(0));
    dataset.fieldValue("activo", repositorioReal.isActivo());
  }
  
  private IDataSet getDataSetDefinicionRepositorioReal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRepositorioRealDet");
    dataset.fieldDef(new Field("oid_repo_det", Field.INTEGER, 0));    
    dataset.fieldDef(new Field("oid_elemento", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_elemento", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_elemento", Field.STRING, 100));    
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_repo_real", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("tipo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroDefinicionRepositorioReal(IDataSet dataset, 
                         															 DefinicionRepositorioReal defRepoReal)
  																										 throws BaseException {
  	
    dataset.append(); 
    dataset.fieldValue("oid_repo_det", defRepoReal.getOIDInteger());
    
    if (defRepoReal.isComponente()) {
    	dataset.fieldValue("oid_elemento", defRepoReal.getCompo_presupuestario().getOIDInteger());
    	dataset.fieldValue("cod_elemento", defRepoReal.getCompo_presupuestario().getCodigo());
    	dataset.fieldValue("desc_elemento", defRepoReal.getCompo_presupuestario().getDescripcion());
    } else
      if (defRepoReal.isMetrica()) {
      	dataset.fieldValue("oid_elemento", defRepoReal.getMetrica().getOIDInteger());
      	dataset.fieldValue("cod_elemento", defRepoReal.getMetrica().getCodigo());
      	dataset.fieldValue("desc_elemento", defRepoReal.getMetrica().getDescripcion());
      } else if (defRepoReal.isTipoPeriodo()) {
      					  dataset.fieldValue("oid_elemento", defRepoReal.getTipo_periodo().getOIDInteger());
      					  dataset.fieldValue("cod_elemento", defRepoReal.getTipo_periodo().getCodigo());
      					  dataset.fieldValue("desc_elemento", defRepoReal.getTipo_periodo().getDescripcion());
      					}
    	
    dataset.fieldValue("descripcion", defRepoReal.getDescripcion());
    dataset.fieldValue("oid_repo_real", defRepoReal.getRepositorio_real().getOIDInteger());
    dataset.fieldValue("orden", defRepoReal.getOrden());
    dataset.fieldValue("tipo", defRepoReal.getTipo());
    dataset.fieldValue("activo", defRepoReal.isActivo());
    dataset.fieldValue("obligatorio", new Boolean(defRepoReal.isObligatorio()));
  }  
  
}
