package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OrdenDeCompraCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadosAutorizOC extends Operation {

  public TraerEstadosAutorizOC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	int oid = 0;
    IDataSet datasetEstados = getDataSetEstadosAutorizOC();
    HashTableDatos estados = OrdenDeCompraCab.getEstadosAutorizacion();
    Iterator iterEstados = estados.keySet().iterator();
    while (iterEstados.hasNext()) {
    	Integer codigo = (Integer) iterEstados.next();
    	String descripcion = (String) estados.get(codigo);
    	cargarRegistroEstadosAutorizOC(datasetEstados,new Integer(++oid),codigo.toString(),descripcion);
    }
    writeCliente(datasetEstados);
  }

  private IDataSet getDataSetEstadosAutorizOC() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstadosAutorizOC");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistroEstadosAutorizOC(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }


}
