package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluGeneroReq extends Operation { 

  public TraerRecluGeneroReq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet dsGenero = this.getDataSetGenero();
	  
	Iterator iterGeneros = 
			RecluBusqueda.getSexoPostulantes().keySet().iterator();
	while (iterGeneros.hasNext()) {
		String codigo = (String) iterGeneros.next();
		String descripcion = (String) RecluBusqueda.getSexoPostulantes().get(codigo); 
		cargarRegistro(dsGenero, codigo , descripcion);
	}
	  
    writeCliente(dsGenero);
  }

  private IDataSet getDataSetGenero() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGeneroRequerido");
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         	  String codigo,
                         	  String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
  
}
