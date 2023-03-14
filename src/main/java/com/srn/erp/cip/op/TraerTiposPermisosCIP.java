package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TipoPermisoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposPermisosCIP extends Operation { 

  public TraerTiposPermisosCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet dsTiposPermisos = this.getDataSetTiposPermisos();
	
	
	Iterator iterTiposPermisos = 
		TipoPermisoCIP.getTipoPermisos().keySet().iterator();
	while (iterTiposPermisos.hasNext()) {
		String 		codigo = (String) iterTiposPermisos.next();
		String descripcion = (String)TipoPermisoCIP.getTipoPermisos().getString(codigo);
		cargarRegistroTipoPermiso(dsTiposPermisos, codigo, descripcion);
	}

    writeCliente(dsTiposPermisos);
    
  }

  private IDataSet getDataSetTiposPermisos() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TTiposPermisos");
	    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
	    return dataset;
  }

  private void cargarRegistroTipoPermiso(
		  			IDataSet dataset,
		  			String codigo,
		  			String descripcion) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("codigo", codigo);
	    dataset.fieldValue("descripcion", descripcion);
  }
  
  
  
}
