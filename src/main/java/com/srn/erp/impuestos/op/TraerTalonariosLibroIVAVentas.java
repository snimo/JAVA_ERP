package com.srn.erp.impuestos.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTalonariosLibroIVAVentas extends Operation {

  public TraerTalonariosLibroIVAVentas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet dsTalonarios = this.getDataSetTalonarios();
	  Iterator iterTalonarios = 
		  Talonario.getTalonariosByLibroIVAVentas(this.getSesion()).iterator();
	  while (iterTalonarios.hasNext()) {
		  Talonario talonario = (Talonario) iterTalonarios.next();
		  cargarRegistro(dsTalonarios, talonario);
	  }
	  writeCliente(dsTalonarios);
  }

  private IDataSet getDataSetTalonarios() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTalonariosLibroIVAVtas");
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		  					  Talonario talonario) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
    dataset.fieldValue("descripcion", talonario.getDescripcion());
  }
  
}
