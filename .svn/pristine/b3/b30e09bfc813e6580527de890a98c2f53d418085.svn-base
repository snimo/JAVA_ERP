package com.srn.erp.crm.op;

import java.util.Iterator;

import com.srn.erp.crm.bm.EstadoCampania;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComporEstCamp extends Operation { 

  public TraerComporEstCamp() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	int oid = 0;
	IDataSet datasetCompoEstCampania = getDataSetEstCampania();
    Iterator iterCompoEst = EstadoCampania.getTiposEstados().keySet().iterator();
    while (iterCompoEst.hasNext()) {
    	String codigo = (String) iterCompoEst.next();
    	String descripcion = (String) EstadoCampania.getTiposEstados().get(codigo);
    	++oid;
    	cargarRegistroTipoCampania(datasetCompoEstCampania,
    			                   new Integer(oid),
    			                   codigo,
    			                   descripcion);
    }
    
    writeCliente(datasetCompoEstCampania);
  }

  private IDataSet getDataSetEstCampania() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoEstadosCampania");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    return dataset;
  }

  private void cargarRegistroTipoCampania(IDataSet dataset,
		                 Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
