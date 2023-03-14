package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluOperacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluOperHabAltaBusq extends Operation { 

  public TraerRecluOperHabAltaBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds = this.getDataSetOperaciones();
	Iterator iterRecluOperaciones = RecluOperacion.getOperacionesParaAccesoTotalDelUsuario(this.getSesion()).iterator();
	while (iterRecluOperaciones.hasNext()) {
		RecluOperacion recluOperacion = (RecluOperacion) iterRecluOperaciones.next();
		cargarRegistro(ds, recluOperacion);
	}
	writeCliente(ds);
	
  } 

      
  private IDataSet getDataSetOperaciones() { 
    	    IDataSet dataset = new TDataSet(); 
    	    dataset.create("TRecluOperacion");
    	    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    	    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    	    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, RecluOperacion recluOperacion) throws BaseException {
    	    dataset.append(); 
    	    dataset.fieldValue("oid", recluOperacion.getOIDInteger());
    	    dataset.fieldValue("codigo", recluOperacion.getOIDInteger());
    	    dataset.fieldValue("descripcion", recluOperacion.getDescripcion());
  }      
  
  
}
