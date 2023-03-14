package com.srn.erp.bienUso.op;

import java.util.Iterator;

import com.srn.erp.bienUso.bm.SistemaValuacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAmortizaciones extends Operation { 

  public TraerTiposAmortizaciones() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	IDataSet dsTiposAmort = getDataSetTiposAmortizaciones();
    traerTiposAmort(dsTiposAmort);
    writeCliente(dsTiposAmort); 
  } 
  
  private void traerTiposAmort(IDataSet dsTiposAmort) throws BaseException {
	  int oid = 0;
	  Iterator iterCod = SistemaValuacion.getTiposAmortizaciones().keySet().iterator();
	  while (iterCod.hasNext()) {
		  ++oid;
		  String codigo = (String) iterCod.next();
		  String descripcion = (String) SistemaValuacion.getTiposAmortizaciones().get(codigo);
		  cargarTiposAmort(dsTiposAmort,new Integer(oid),codigo,descripcion);
	  }
  }
  
  private IDataSet getDataSetTiposAmortizaciones() { 
	IDataSet dataset = new TDataSet(); 
	dataset.create("TTiposAmort");
	dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
	dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
	dataset.fieldDef(new Field("descripcion", Field.STRING, 30)); 
	return dataset;
  }  
  
  private void cargarTiposAmort(IDataSet dataset,
		  						Integer oid,
		  						String codigo,
		  						String descripcion) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid", oid);
	    dataset.fieldValue("codigo", codigo);
	    dataset.fieldValue("descripcion", descripcion);	    
  }  
  
}
