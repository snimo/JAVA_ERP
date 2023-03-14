package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.GradoCompetencia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompetencia extends Operation { 

  public TraerCompetencia() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Competencia competencia = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       competencia = Competencia.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       competencia = Competencia.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCompetencia = getDataSetCompetencia();
    IDataSet datasetGrado = getDataSetGradoCompetencia();
    
    if (competencia != null) { 
    	
        cargarRegistroCompetencia(datasetCompetencia, competencia);
        Iterator iterGradosCompetencias = competencia.getGrados().iterator();
        while (iterGradosCompetencias.hasNext()) {
        	GradoCompetencia gradoCompetencia = (GradoCompetencia) iterGradosCompetencias.next();
        	cargarRegistroGradoCompetencia(datasetGrado, gradoCompetencia);
        }
        
    }
    
    writeCliente(datasetCompetencia);
    writeCliente(datasetGrado);
    
  }

  private IDataSet getDataSetCompetencia() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompetencia");
    dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("titulo", Field.STRING, 100)); 
    dataset.fieldDef(new Field("definicion", Field.STRING, 4000)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("desc_abrev", Field.STRING, 20));
    return dataset;
  }

  private void cargarRegistroCompetencia(IDataSet dataset, Competencia competencia) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_competencia", competencia.getOIDInteger());
    dataset.fieldValue("codigo", competencia.getCodigo());
    dataset.fieldValue("titulo", competencia.getTitulo());
    dataset.fieldValue("definicion", competencia.getDefinicion());
    dataset.fieldValue("activo", competencia.isActivo());
    dataset.fieldValue("desc_abrev", competencia.getDescAbrev());
  }
  
  private IDataSet getDataSetGradoCompetencia() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TGradoCompetencia");
	    dataset.fieldDef(new Field("oid_grado_compe", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("nro_grado", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("desc_grados", Field.STRING, 4000)); 
	    dataset.fieldDef(new Field("peso_tentativo", Field.CURRENCY, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }

  private void cargarRegistroGradoCompetencia(IDataSet dataset, GradoCompetencia gradoCompetencia) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_grado_compe", gradoCompetencia.getOIDInteger());
	  dataset.fieldValue("oid_competencia", gradoCompetencia.getCompetencia().getOIDInteger());
	  dataset.fieldValue("nro_grado", gradoCompetencia.getNro_grado());
	  dataset.fieldValue("desc_grados", gradoCompetencia.getDesc_grados());
	  dataset.fieldValue("peso_tentativo", gradoCompetencia.getPeso_tentativo());
	  dataset.fieldValue("activo", gradoCompetencia.isActivo());
  }

  
}
