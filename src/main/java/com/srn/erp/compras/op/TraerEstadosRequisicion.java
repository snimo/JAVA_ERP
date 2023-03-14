package com.srn.erp.compras.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.compras.bm.RequisicionDetAutorizacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadosRequisicion extends Operation { 

  public TraerEstadosRequisicion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {    
    IDataSet datasetEstadoRequisicion = getDataSetEstadosRequisicion();
    int nro = 0;
    Hashtable estados = RequisicionDetAutorizacion.getEstados();
    Iterator iterCodigos = estados.keySet().iterator();
    while (iterCodigos.hasNext()) {
    	++nro;
    	Integer codigo = (Integer) iterCodigos.next();
    	String descripcion = (String) estados.get(codigo);
    	cargarEstadoRequisicion(datasetEstadoRequisicion,
    			                new Integer(nro),
    			                codigo,
    			                descripcion);
    }
    writeCliente(datasetEstadoRequisicion);
  }
  
  private IDataSet getDataSetEstadosRequisicion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadosRequisicion");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarEstadoRequisicion(IDataSet dataset,
		  							   Integer oid,
		  							   Integer codigo,
		  							   String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);    
  }  
  
  
}
