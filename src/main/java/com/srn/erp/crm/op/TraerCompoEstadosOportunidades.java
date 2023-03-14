package com.srn.erp.crm.op;

import java.util.Iterator;

import com.srn.erp.crm.bm.EstadoOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoEstadosOportunidades extends Operation { 

  public TraerCompoEstadosOportunidades() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	int oid = 0;  
	IDataSet ds = getDataSetCompoEstOpor();  
	Iterator iterCompoEstOpor = EstadoOportunidad.getEstadosOportunidades().keySet().iterator();
	while (iterCompoEstOpor.hasNext()) {
		String codigo = (String) iterCompoEstOpor.next();
		String descripcion = (String) EstadoOportunidad.getEstadosOportunidades().get(codigo);
		++oid;
		cargarRegistroCompoEstOpor(ds,new Integer(oid),codigo,descripcion);
	}
	  
    writeCliente(ds);
  }

  private IDataSet getDataSetCompoEstOpor() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoEstOpor");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 20));
    return dataset;
  }

  private void cargarRegistroCompoEstOpor(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
