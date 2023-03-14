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

public class TraerConfigFiltroCargaReal extends Operation { 

  public TraerConfigFiltroCargaReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	RepositorioReal repoReal = 
  		RepositorioReal.findByOid(mapaDatos.getInteger("oid_repositorio_real"), getSesion());

  	IDataSet dsTiposPeriodos = this.getDSTiposPeriodos();
  	IDataSet dsCompoPresuParaFiltros = this.getDSCompoHabilitadosFiltro();
  	IDataSet dsFilasParaFiltro = getDSFilasParaFiltroDeCompo();
  	IDataSet dsRepositorioReal = getDSRepositorioReal();
 
  	Iterator iterDefRepoReal = 
  		repoReal.getDefinicionesRepoReal().iterator();
  	while (iterDefRepoReal.hasNext()) {
  		DefinicionRepositorioReal defRepoReal = 
  			(DefinicionRepositorioReal) iterDefRepoReal.next();
  		
  		if (defRepoReal.isTipoPeriodo())
  			cargarTipoPeriodo(dsTiposPeriodos,defRepoReal);
  		else
  			if (defRepoReal.isComponente())
  				cargarCompoPresuParaFiltro(dsCompoPresuParaFiltros,defRepoReal);
  		
  	}
  	
  	cargarFilasParaFiltroCompo(dsFilasParaFiltro);
  	cargarCompoRepresentativoSinFiltro(dsCompoPresuParaFiltros);
  	cargarRepositorioReal(dsRepositorioReal,repoReal);
  	
  	
    writeCliente(dsTiposPeriodos);
    writeCliente(dsCompoPresuParaFiltros);
    writeCliente(dsFilasParaFiltro);
    writeCliente(dsRepositorioReal);
    
  }
  
  private void cargarFilasParaFiltroCompo(IDataSet dataset) {
  	cargarFilaParaFiltroDeCompo(dataset,1,0);
  	cargarFilaParaFiltroDeCompo(dataset,2,0);
  	cargarFilaParaFiltroDeCompo(dataset,3,0);
  	cargarFilaParaFiltroDeCompo(dataset,4,0);
  	cargarFilaParaFiltroDeCompo(dataset,5,0);
  }

  private IDataSet getDSTiposPeriodos() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoPeriodo");
    dataset.fieldDef(new Field("oid_repo_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_peri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }
  
  private IDataSet getDSCompoHabilitadosFiltro() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoHabilitadosFiltro");
    dataset.fieldDef(new Field("oid_repo_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }
  
  private IDataSet getDSFilasParaFiltroDeCompo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFiltroComponentes");
    dataset.fieldDef(new Field("nro_fila", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_repo_det", Field.INTEGER, 0)); 
    return dataset;
  }
  
  private IDataSet getDSRepositorioReal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRepositorioReal");
    dataset.fieldDef(new Field("oid_repo_real", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    return dataset;
  }
  
  
  private void cargarFilaParaFiltroDeCompo(IDataSet dataset,int nroFila,int oidRepoDet) {
    dataset.append(); 
    dataset.fieldValue("nro_fila", new Integer(nroFila));
    dataset.fieldValue("oid_repo_det", new Integer(oidRepoDet));
  }
  

  private void cargarTipoPeriodo(IDataSet dataset, 
                                 DefinicionRepositorioReal defRepoReal) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_repo_det", defRepoReal.getOIDInteger());
    dataset.fieldValue("oid_tipo_peri", defRepoReal.getTipo_periodo().getOIDInteger());
    dataset.fieldValue("descripcion", defRepoReal.getDescripcion());
  }
  
  private void cargarCompoPresuParaFiltro(IDataSet dataset, 
      					DefinicionRepositorioReal defRepoReal) throws BaseException {
  	dataset.append(); 
  	dataset.fieldValue("oid_repo_det", defRepoReal.getOIDInteger());
  	dataset.fieldValue("oid_compo_presu", defRepoReal.getCompo_presupuestario().getOIDInteger());
  	dataset.fieldValue("descripcion", defRepoReal.getDescripcion());
  }
  
  private void cargarCompoRepresentativoSinFiltro(IDataSet dataset) throws BaseException {
  	dataset.append(); 
  	dataset.fieldValue("oid_repo_det", 0);
  	dataset.fieldValue("oid_compo_presu", 0);
  	dataset.fieldValue("descripcion", "Seleccionar Filtro ...");
  	
  }
  
  private void cargarRepositorioReal(IDataSet dataset,RepositorioReal repositorio) throws BaseException {
  	dataset.append(); 
  	dataset.fieldValue("oid_repo_real", repositorio.getOID());
  	dataset.fieldValue("descripcion", repositorio.getDescripcion());
  	dataset.fieldValue("codigo", repositorio.getCodigo());
  }
  
  
  
}
