package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeControlCalidadDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerItemsCCADevolver extends Operation {

  public TraerItemsCCADevolver() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsItemsADevolver = getDataSetItemsADevolver();
    HashTableDatos listaOidsDetInfCC = getListaOidsInfCCDet(mapaDatos);
    Iterator iterOidsInfCC = InformeControlCalidadDet.getDetallesInfCCByListaOids(listaOidsDetInfCC,getSesion()).iterator();
    while (iterOidsInfCC.hasNext()) {
    	InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterOidsInfCC.next();
    	if (infCCDet.getCantPendDevEnUS().doubleValue()==0) continue;
    	cargarRegistroItemDevolucion(dsItemsADevolver,infCCDet);
    }
    
    writeCliente(dsItemsADevolver);
  }

  private IDataSet getDataSetItemsADevolver() {
    IDataSet dataset = new TDataSet();
    dataset.create("TItemsADevolver");
    dataset.fieldDef(new Field("oid_inf_cc_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("cant_pend_dev_us", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um_stock", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroItemDevolucion(IDataSet dataset,
                         InformeControlCalidadDet infCCDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_inf_cc_det", infCCDet.getOIDInteger());
    dataset.fieldValue("oid_producto", infCCDet.getInforme_recepcion_det().getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", infCCDet.getInforme_recepcion_det().getProducto().getCodigo());
    dataset.fieldValue("desc_producto",infCCDet.getInforme_recepcion_det().getProducto().getDescripcion());
    dataset.fieldValue("cant_pend_dev_us", infCCDet.getCantPendDevEnUS());
    dataset.fieldValue("oid_um_stock", infCCDet.getInforme_recepcion_det().getUnidadMedidaStock().getOIDInteger());
  }
  
  private HashTableDatos getListaOidsInfCCDet(MapDatos mapaDatos) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	IDataSet ds = mapaDatos.getDataSet("TItemsDetCC");
  	ds.first();
  	while (!ds.EOF()) {
  		Integer oidInfDetCC = ds.getInteger("oid_inf_cc_det");
  		condiciones.put(oidInfDetCC,oidInfDetCC);
  		ds.next();
  	}
  	return condiciones; 
  }

}
