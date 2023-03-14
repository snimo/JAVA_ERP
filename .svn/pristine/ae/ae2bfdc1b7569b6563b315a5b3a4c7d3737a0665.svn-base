package com.srn.erp.bienUso.op;

import java.util.Iterator;

import com.srn.erp.bienUso.bm.MovimientoBienUso;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposMovAmortizaciones extends Operation { 

  public TraerTiposMovAmortizaciones() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	IDataSet dsMovTiposAmort = getDataSetTiposMovAmortizaciones();
    traerMovTiposAmort(dsMovTiposAmort);
    writeCliente(dsMovTiposAmort); 
  } 
  
  private void traerMovTiposAmort(IDataSet dsTiposAmort) throws BaseException {
	  int oid = 0;
	  Iterator iterTiposMov = MovimientoBienUso.getTiposMovimientos().keySet().iterator();
	  while (iterTiposMov.hasNext()) {
		  ++oid;
		  String codigo = (String) iterTiposMov.next();
		  String descripcion = (String)MovimientoBienUso.getTiposMovimientos().get(codigo);
		  cargarTiposMovAmort(dsTiposAmort,new Integer(oid),codigo,descripcion);
	  }
  }
  
  private IDataSet getDataSetTiposMovAmortizaciones() { 
	IDataSet dataset = new TDataSet(); 
	dataset.create("TMovimientosBU");
	dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
	dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
	dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
	return dataset;
  }  
  
  private void cargarTiposMovAmort(IDataSet dataset,
		  						Integer oid,
		  						String codigo,
		  						String descripcion) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid", oid);
	    dataset.fieldValue("codigo", codigo);
	    dataset.fieldValue("descripcion", descripcion);	    
  }  
  
}
