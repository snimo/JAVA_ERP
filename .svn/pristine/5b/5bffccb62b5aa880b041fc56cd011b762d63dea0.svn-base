package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.GrupoRepositorioReal;
import com.srn.erp.presupuesto.bm.RepositorioReal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerArbolRepositorioReal extends Operation { 

  public TraerArbolRepositorioReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet datasetArbolRepositorio = this.getDataSetArbolRepositorioReal();
    
    Iterator iterGrupos = GrupoRepositorioReal.getGruposRepositorio(this.getSesion()).iterator();
    while (iterGrupos.hasNext()) {
    	GrupoRepositorioReal grupoRepo = (GrupoRepositorioReal) iterGrupos.next();
    	if (grupoRepo.isActivo().booleanValue())
    		cargarRepositoriosGrupo(datasetArbolRepositorio,grupoRepo);
    }
    
    writeCliente(datasetArbolRepositorio);
    
  }
  
  private void cargarRepositoriosGrupo(IDataSet ds,GrupoRepositorioReal grupoRepoReal) throws BaseException {
  	
  	Integer oidRelacionGrupo = new Integer(grupoRepoReal.getOIDInteger().intValue()*-1);
  	Integer sinPadre = new Integer(0);
  	Integer nroImagenGrupo = new Integer(0);
  	Integer nroImagenCompo = new Integer(1);
  	
  	cargarRegArbolRepositorio(ds,
  														oidRelacionGrupo,
  														sinPadre,
  														grupoRepoReal.getDescripcion(),
  														nroImagenGrupo,
  														null);
  	
  	Iterator iterRepoReal = grupoRepoReal.getListaRepositoriosReales().iterator();
  	while (iterRepoReal.hasNext()) {
  		RepositorioReal repoReal = (RepositorioReal) iterRepoReal.next();
  		if (repoReal.isActivo().booleanValue()) {
  				cargarRegArbolRepositorio(ds,
  																	repoReal.getOIDInteger(),
  																	oidRelacionGrupo,
  																	repoReal.getDescripcion(),
  																	nroImagenCompo,
  																	repoReal);
  		}  		
  	}
  }
  
  private IDataSet getDataSetArbolRepositorioReal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TArbolRepositorio");
    dataset.fieldDef(new Field("oid_relacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_relacion_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_icono", Field.INTEGER, 100));
    dataset.fieldDef(new Field("oid_repositorio", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegArbolRepositorio(IDataSet dataset, 
                         								 Integer oidRelacion,
                         								 Integer oidRelacionPadre,
                         								 String descripcion,
                         								 Integer nroIcono,
                         								 RepositorioReal repositorio) {
    dataset.append(); 
    dataset.fieldValue("oid_relacion", oidRelacion);
    dataset.fieldValue("oid_relacion_padre", oidRelacionPadre);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("nro_icono", nroIcono);
    if (repositorio!=null)
    	dataset.fieldValue("oid_repositorio",repositorio.getOIDInteger());
    else
    	dataset.fieldValue("oid_repositorio",new Integer(0));
  }
}
