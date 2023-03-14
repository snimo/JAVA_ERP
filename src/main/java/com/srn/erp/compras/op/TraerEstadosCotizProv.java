package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.CotizacionProveedorCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadosCotizProv extends Operation { 

  
  public TraerEstadosCotizProv() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = getDataSetEstadosCotizProv();
	  
	  HashTableDatos estadosCotiz = CotizacionProveedorCab.getEstadosCotizacion();
	  Iterator iterEstadosCotizProv = estadosCotiz.keySet().iterator();
	  while (iterEstadosCotizProv.hasNext()) {
		  Integer oidEstado = (Integer) iterEstadosCotizProv.next();
		  String descripcion = (String) estadosCotiz.get(oidEstado);
		  cargarRegistroEstadoCotizProv(ds,oidEstado,descripcion);
	  }
	  
	  writeCliente(ds);
	  
     
    
  }

    private IDataSet getDataSetEstadosCotizProv() { 
	    IDataSet dataset = new TDataSet();
	    
	    dataset.create("TEstadosCotizProv");
	    dataset.fieldDef(new Field("oid_estado_cotiz", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
	    return dataset;
	  }

  
	private void cargarRegistroEstadoCotizProv(IDataSet dataset,
			  				 Integer oidEstadoCotizProv, 	
			  				 String  descripcion) throws BaseException {
		  
	    dataset.append(); 
	    dataset.fieldValue("oid_estado_cotiz", oidEstadoCotizProv);
	    dataset.fieldValue("descripcion", descripcion);
	} 

	  
  
}
