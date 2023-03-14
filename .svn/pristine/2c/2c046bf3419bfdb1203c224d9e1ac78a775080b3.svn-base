package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ImpresoraFiscal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerModosImpresionFiscal extends Operation {

  public TraerModosImpresionFiscal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDSModosImpresion();
	  
	  Iterator iterModos = 
		  ImpresoraFiscal.getModosImpresion().keySet().iterator();
	  while (iterModos.hasNext()) {
		  String codigo = (String)iterModos.next();
		  String descripcion = (String) ImpresoraFiscal.getModosImpresion().get(codigo);
		  cargarRegistroIdioma(ds,codigo,descripcion);
	  }
	  
	  
	  writeCliente(ds);
  }

  private IDataSet getDSModosImpresion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TModosImpresion");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroIdioma(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
