package com.srn.erp.ventas.op;

import java.util.Iterator;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposDevoluciones extends Operation {

  public TraerTiposDevoluciones() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = this.getDataTiposDevoluciones();	  
	Iterator iterTipos =   
		TiposDevolucion.getTiposDevolucion().keySet().iterator();
	while (iterTipos.hasNext()) {
		String codigo = (String) iterTipos.next();
		String descripcion = (String) TiposDevolucion.getTiposDevolucion().get(codigo);
		cargarRegistro(ds, codigo , descripcion);
	}
	writeCliente(ds);
	  
  }

  private IDataSet getDataTiposDevoluciones() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoDevolucion");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
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
