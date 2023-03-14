package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.ActLogsMens;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerActLogsMens extends Operation { 

  public TraerActLogsMens() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = this.getDataSetLogsMensAct();
	  cargarRegistro(ds, ActLogsMens.isActivado(this.getSesion()));
	  writeCliente(ds);
  }

  private IDataSet getDataSetLogsMensAct() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TLogsMensAct");
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistro(
		  IDataSet dataset, 
          Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("activo", activo);
  }
}
