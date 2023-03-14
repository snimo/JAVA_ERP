package com.srn.erp.costos.op;

import java.util.Iterator;

import com.srn.erp.costos.bm.FormaCalcCosto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFormaCalcCosto extends Operation { 

  public TraerFormaCalcCosto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	IDataSet ds = this.getDataSetFormaCalcCosto();  
	  
	Iterator iterFormaCalcCosto = 
		FormaCalcCosto.getFormasCalcCostos().keySet().iterator();
	while (iterFormaCalcCosto.hasNext()) {
		String formaCalcCosto = (String) iterFormaCalcCosto.next();
		String descripcion = (String) FormaCalcCosto.getFormasCalcCostos().get(formaCalcCosto);
		cargarRegistroFormaCalcCosto(ds, formaCalcCosto, descripcion);
	}
	
	writeCliente(ds);
	  
  }

  private IDataSet getDataSetFormaCalcCosto() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFormaCalcCosto");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistroFormaCalcCosto(
		  IDataSet dataset, 
          String codigo,
          String descripcion) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
  
    
}
