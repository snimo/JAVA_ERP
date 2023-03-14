package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConcFactRendFF extends Operation {

  public TraerConcFactRendFF() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {  	
    IDataSet ds = this.getDataSetConcFactProv();
    traerConceptos(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traerConceptos(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {
	  Iterator iterConcFactProvRFF = 
		  ConcFactProv.getConceptosFactProvRendFondoFijo(this.getSesion()).iterator();
	  while (iterConcFactProvRFF.hasNext()) {
		  ConcFactProv concFactProvRFF = (ConcFactProv) iterConcFactProvRFF.next();
		  cargarRegistroConcFactProv(dataSet, concFactProvRFF);
	  }
  }

  private IDataSet getDataSetConcFactProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConcFactProv");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroConcFactProv(IDataSet dataset,
                                          ConcFactProv concFactProv)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", concFactProv.getOID());
    dataset.fieldValue("codigo", concFactProv.getCodigo());
    dataset.fieldValue("descripcion", concFactProv.getDescripcion());
    
  }

}
