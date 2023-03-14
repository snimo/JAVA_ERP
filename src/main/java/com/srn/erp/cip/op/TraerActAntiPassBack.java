package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.ActLAntiPassBack;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerActAntiPassBack extends Operation { 

  public TraerActAntiPassBack() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = this.getDataSetLogsMensAct();
	  cargarRegistro(ds, ActLAntiPassBack.isActivado(this.getSesion()));
	  writeCliente(ds);
  }

  private IDataSet getDataSetLogsMensAct() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TActAntiPassBack");
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
