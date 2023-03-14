package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TiposAlimListaBlanca;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAlimLB extends Operation { 

  public TraerTiposAlimLB() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = this.getDataSetTiposAlim();
	  Iterator iterTiposAlim = 
		  TiposAlimListaBlanca.getTiposAlimentacion().keySet().iterator();
	  while (iterTiposAlim.hasNext()) {
		  String codigo = (String) iterTiposAlim.next();
		  String descripcion = TiposAlimListaBlanca.getTiposAlimentacion().getString(codigo);
		  cargarRegistro(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
  }

  private IDataSet getDataSetTiposAlim() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposAlimentacion");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    return dataset;
  }

  private void cargarRegistro(
		  IDataSet dataset,
		  String codigo,
		  String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);

  }
}
