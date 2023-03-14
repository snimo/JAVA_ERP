package com.srn.erp.general.op;

import com.srn.erp.general.bm.ComproCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerNroInternoCompro extends Operation {

  public TraerNroInternoCompro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsNroInterno = this.getDSNroInterno();
  	cargarRegistro(dsNroInterno,ComproCab.getNewNroInterno(this.getSesion()));
  	writeCliente(dsNroInterno);
  	
  }
  
  private IDataSet getDSNroInterno() {
    IDataSet dataset = new TDataSet();
    dataset.create("TNroInternoCompro");
    dataset.fieldDef(new Field("nro_interno", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
  														int nroInterno) throws BaseException {
    dataset.append();
    dataset.fieldValue("nro_interno", nroInterno);
  }
}
