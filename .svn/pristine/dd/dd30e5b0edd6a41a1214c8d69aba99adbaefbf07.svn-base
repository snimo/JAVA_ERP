package com.srn.erp.impuestos.op;

import java.util.Iterator;

import com.srn.erp.impuestos.bm.ColumnaLibroIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerColumnasLibroIVA extends Operation {

  public TraerColumnasLibroIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet datasetColumnaLibroIVA = getDataSetColumnaLibroIVA();  
	Iterator iterColLibroIVA = ColumnaLibroIVA.getColLibroIVA(getSesion()).iterator();
	while (iterColLibroIVA.hasNext()) {
		ColumnaLibroIVA colLibroIVA = (ColumnaLibroIVA) iterColLibroIVA.next();
		cargarRegistroColumnaLibroIVA(datasetColumnaLibroIVA,colLibroIVA);
	}
    writeCliente(datasetColumnaLibroIVA);
    
  }

  private IDataSet getDataSetColumnaLibroIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TColumnaLibroIVA");
    dataset.fieldDef(new Field("oid_col_libro_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("columna", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_iva_vtas", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_iva_cpras", Field.BOOLEAN, 0));    
    return dataset;
  }

  private void cargarRegistroColumnaLibroIVA(IDataSet dataset,
                         ColumnaLibroIVA colLibroIva)  throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_col_libro_iva", colLibroIva.getOIDInteger());
    dataset.fieldValue("codigo", colLibroIva.getCodigo());
    dataset.fieldValue("descripcion", colLibroIva.getDescripcion());
    dataset.fieldValue("columna", colLibroIva.getColumna());
    dataset.fieldValue("activo", colLibroIva.isActivo());
    dataset.fieldValue("usar_iva_vtas", colLibroIva.isUsarIVAVentas());
    dataset.fieldValue("usar_iva_cpras", colLibroIva.isUsarIVACompras());    
    
  }
}
