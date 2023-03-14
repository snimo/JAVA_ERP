package com.srn.erp.general.op;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDiaSemana extends Operation {

  public TraerDiaSemana() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	java.util.Date fecha = mapaDatos.getDate("fecha");
	String dia = Fecha.getNombreDiaSemana(fecha);
	
	IDataSet ds = this.getDataSet();
	cargarRegistro(ds, dia);
	writeCliente(ds);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDiaSemana");
    dataset.fieldDef(new Field("dia", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         String diaSemana) throws BaseException {
    dataset.append();
    dataset.fieldValue("dia", diaSemana);
  }
}
