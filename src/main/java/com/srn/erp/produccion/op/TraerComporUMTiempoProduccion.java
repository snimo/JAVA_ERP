package com.srn.erp.produccion.op;

import java.util.Iterator;

import com.srn.erp.produccion.bm.UMTiempoProduccion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComporUMTiempoProduccion extends Operation { 

  public TraerComporUMTiempoProduccion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

	Iterator iterTiemposProd = 
		UMTiempoProduccion.getUMTiemposProduccion().keySet().iterator();
	IDataSet ds = this.getDataSetComporUMProduccion();
	while (iterTiemposProd.hasNext()) {
		String codigo = (String) iterTiemposProd.next();
		String descripcion = (String) UMTiempoProduccion.getUMTiemposProduccion().get(codigo);
		cargarRegistro(ds, codigo, descripcion);
	}
	writeCliente(ds);
	
    
  }

  private IDataSet getDataSetComporUMProduccion() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TComporUMProd");
	    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
	    return dataset;
  }
  
  private void cargarRegistro(IDataSet dataset, 
          					  String codigo,
          					  String descripcion) throws BaseException  {
	  dataset.append();
	  dataset.fieldValue("codigo", codigo);
	  dataset.fieldValue("descripcion", descripcion);

  }
  
  
}
