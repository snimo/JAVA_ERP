package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposMovStock extends Operation {

  public TraerTiposMovStock() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	int secu = 0;  
    IDataSet dsTipoMovStock = getDataSetTiposMovStock();
    HashTableDatos tiposMov = TipoConfMovStkTalonario.getTiposMovimientos();
    Iterator iterTipos = tiposMov.keySet().iterator();
    while (iterTipos.hasNext()) {
    	Integer oid = new Integer(++secu);
    	String codigo = (String) iterTipos.next();
    	String descripcion = (String)tiposMov.get(codigo);
    	cargarRegistroTiposMovStock(dsTipoMovStock,oid,codigo,descripcion);
    }
    writeCliente(dsTipoMovStock);
  }

  private IDataSet getDataSetTiposMovStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposMovStock");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTiposMovStock(IDataSet dataset,
		  								   Integer oid,
		  								   String codigo,
		  								   String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }

  
}
