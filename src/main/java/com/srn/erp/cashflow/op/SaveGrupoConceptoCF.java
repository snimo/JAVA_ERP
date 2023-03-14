package com.srn.erp.cashflow.op;

import com.srn.erp.cashflow.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoConceptoCF extends Operation { 

  public SaveGrupoConceptoCF() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoConceptoCF"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoConceptoCF grupoconceptocf = GrupoConceptoCF.findByOid(dataset.getInteger("oid_grupo_concepto"),getSesion());
        grupoconceptocf.setOID(dataset.getInteger("oid_grupo_concepto"));
        grupoconceptocf.setCodigo(dataset.getString("codigo"));
        grupoconceptocf.setDescripcion(dataset.getString("descripcion"));
        grupoconceptocf.setActivo(dataset.getBoolean("activo"));
        grupoconceptocf.setOrden(dataset.getInteger("orden"));
        grupoconceptocf.setComporGrupo(dataset.getString("compor_grupo"));
        addTransaccion(grupoconceptocf);
        dataset.next();
    }
  }
  
}
