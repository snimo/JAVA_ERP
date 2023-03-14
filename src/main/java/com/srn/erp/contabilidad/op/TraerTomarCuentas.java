package com.srn.erp.contabilidad.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ValoresAtriCriterioImpu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTomarCuentas extends Operation {

  public TraerTomarCuentas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	int oid = 0;
	IDataSet dataset = getDataSetTomarCuentas();  
	Hashtable tomarCuentas = ValoresAtriCriterioImpu.getTomarCuentas();
	Iterator iterTomarCuentas = tomarCuentas.keySet().iterator();
	while (iterTomarCuentas.hasNext()) {
		String codigo = (String) iterTomarCuentas.next();
		String descripcion = (String) tomarCuentas.get(codigo);
		cargarRegistroTomarCuenta(dataset,new Integer(++oid),codigo,descripcion);
	}
    writeCliente(dataset);
  }

  private IDataSet getDataSetTomarCuentas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTomarCuentas");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroTomarCuenta(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
