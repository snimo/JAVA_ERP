package com.srn.erp.ventas.op;

import framework.applicarionServer.bm.Varios.Numerador;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProxNroImpFis extends Operation {

  public TraerProxNroImpFis() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer nro = Numerador.getSiguienteNro("NroImpFiscal", getSesion());
  	
    IDataSet ds = this.getDataSet();
    cargarRegistro(ds,nro);
    writeCliente(ds);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProxNroImpFiscal");
    dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         Integer nro) {
    dataset.append();
    dataset.fieldValue("nro", nro);
  }
}
