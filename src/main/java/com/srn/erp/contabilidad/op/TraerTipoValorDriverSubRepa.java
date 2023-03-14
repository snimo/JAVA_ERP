package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.DriverSubreparto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoValorDriverSubRepa extends Operation {

  public TraerTipoValorDriverSubRepa() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	IDataSet ds = getDataSetTiposValores();  
	  
	Iterator iterTiposValores = 
		DriverSubreparto.getTiposValores().keySet().iterator();
	while (iterTiposValores.hasNext()) {
		String codigo = (String) iterTiposValores.next();
		String descripcion = (String) DriverSubreparto.getTiposValores().get(codigo);
		cargarRegistroTipoValor(ds, codigo, descripcion);
	}
	
	writeCliente(ds);
	  
  }

  private IDataSet getDataSetTiposValores() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoValor");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTipoValor(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }



}
