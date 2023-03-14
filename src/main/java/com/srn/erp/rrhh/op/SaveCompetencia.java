package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveCompetencia extends Operation { 

  public SaveCompetencia() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCompetencia"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Competencia competencia = Competencia.findByOid(dataset.getInteger("oid_competencia"),getSesion());
        competencia.setOID(dataset.getInteger("oid_competencia"));
        competencia.setCodigo(dataset.getString("codigo"));
        competencia.setTitulo(dataset.getString("titulo"));
        competencia.setDefinicion(dataset.getString("definicion"));
        competencia.setDescAbrev(dataset.getString("desc_abrev"));
        competencia.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsGradoCompetencia = dataset.getDataSet("TGradoCompetencia");
        dsGradoCompetencia.first();
        while (!dsGradoCompetencia.EOF()) {
        	GradoCompetencia gradoCompetencia = GradoCompetencia.findByOid(dsGradoCompetencia.getInteger("oid_grado_compe"), this.getSesion());
        	gradoCompetencia.setCompetencia(competencia);
        	gradoCompetencia.setNro_grado(dsGradoCompetencia.getInteger("nro_grado"));
        	gradoCompetencia.setDesc_grados(dsGradoCompetencia.getString("desc_grados"));
        	if (dsGradoCompetencia.getMoney("peso_tentativo")!=null)
        		gradoCompetencia.setPeso_tentativo(dsGradoCompetencia.getMoney("peso_tentativo").doubleValue(2));
        	else
        		gradoCompetencia.setPeso_tentativo(new Double(0));
        	gradoCompetencia.setActivo(dsGradoCompetencia.getBoolean("activo"));
        	competencia.addGradoCompetencia(gradoCompetencia);
        	dsGradoCompetencia.next();
        }
        
        addTransaccion(competencia);
        dataset.next();
    }
  }
  
}
