package com.srn.erp.impuestos.op;

import java.util.Iterator;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TrearColImpreCompro extends Operation {

  public TrearColImpreCompro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSet();
	  Iterator iterColImpreCompro =  
		 ConceptoImpuesto.getColumnasImpreCompro().keySet().iterator();
	  while (iterColImpreCompro.hasNext()) {
		  String codigo = (String) iterColImpreCompro.next();
		  String descripcion = (String)ConceptoImpuesto.getColumnasImpreCompro().get(codigo);
		  cargar(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TColImpreCompro");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }


  private void cargar(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }


}
