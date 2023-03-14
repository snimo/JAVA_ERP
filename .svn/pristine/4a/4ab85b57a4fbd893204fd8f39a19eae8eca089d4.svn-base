package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.TipoAcuerdo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAcuerdos extends Operation {

  public TraerTiposAcuerdos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsTiposAcuerdos = getDataSetTiposAcuerdos();
    traerTiposAcuerdos(dsTiposAcuerdos);
    writeCliente(dsTiposAcuerdos);
  }

  private void traerTiposAcuerdos(IDataSet dataSet) throws BaseException {
	  int oid = 0;
	  Iterator iterCodigos = TipoAcuerdo.getTiposAcuerdos().keySet().iterator();
	  while (iterCodigos.hasNext()) {
		  String codigo = (String) iterCodigos.next();
		  String descripcion = (String) TipoAcuerdo.getTiposAcuerdos().get(codigo);
		  cargarRegistroTiposAcuerdos(dataSet,new Integer(++oid),codigo,descripcion);
	  }
  }

  private IDataSet getDataSetTiposAcuerdos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposAcu");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroTiposAcuerdos(IDataSet dataset,
                                           Integer oid,
                                           String codigo,
                                           String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }

}
