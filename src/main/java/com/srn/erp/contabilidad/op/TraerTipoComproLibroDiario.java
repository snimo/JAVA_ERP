package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Ejercicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoComproLibroDiario extends Operation {

  public TraerTipoComproLibroDiario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = this.getDataSet();
    Iterator tiposCompro = 
    	Ejercicio.getLibroDiarioTipoCompro().keySet().iterator();
    while (tiposCompro.hasNext()) {
    	String codigo = (String) tiposCompro.next();
    	String descripcion = (String) Ejercicio.getLibroDiarioTipoCompro().get(codigo);
    	cargarRegistro(ds, codigo, descripcion);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TLibroDiarioTiposCompro");
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
