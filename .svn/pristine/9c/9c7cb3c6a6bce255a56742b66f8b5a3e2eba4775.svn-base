package com.srn.erp.produccion.op;

import java.util.Iterator;

import com.srn.erp.produccion.bm.OperAlterFab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TiposComporAltFab extends Operation { 

  public TiposComporAltFab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet dsTipoCompAltFab = this.getDataTipoCompoAltFab();
	  Iterator iterTiposOperAltFab = 
		  OperAlterFab.getTiposOperAlterFab().keySet().iterator();
	  while (iterTiposOperAltFab.hasNext()) {
		  String codigo = (String) iterTiposOperAltFab.next();
		  String descripcion = (String) OperAlterFab.getTiposOperAlterFab().get(codigo);
		  cargarRegistroTipoCompoAltFab(dsTipoCompAltFab, codigo, descripcion);
	  }
	  writeCliente(dsTipoCompAltFab);
  }

  private IDataSet getDataTipoCompoAltFab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoCompoAltFab");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistroTipoCompoAltFab(
		  IDataSet dataset, 
          String codigo,
          String descripcion) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
  
}
