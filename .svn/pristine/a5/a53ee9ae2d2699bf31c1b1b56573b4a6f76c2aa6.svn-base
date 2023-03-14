package com.srn.erp.cashflow.op;


import java.util.Iterator;

import com.srn.erp.cashflow.bm.GrupoConceptoCF;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComporGrupoConcCF extends Operation { 

  public TraerComporGrupoConcCF() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	IDataSet ds = this.getDataComporGrupo();
	Iterator iterCompo = 
		GrupoConceptoCF.getComportamientos().keySet().iterator();
	while (iterCompo.hasNext()) {
		String codigo = (String) iterCompo.next();
		String descripcion = (String) GrupoConceptoCF.getComportamientos().get(codigo);
		cargarRegistroComporGrupoConcCF(ds, codigo, descripcion);
		
	}
	
	writeCliente(ds);
	  
  }

  private IDataSet getDataComporGrupo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TComporGrupo");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistroComporGrupoConcCF(IDataSet dataset, 
                         String codigo,
                         String descripcion) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
