package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.ConsSalEstStkPorAgrupDepo;
import com.srn.erp.stock.bm.EstadoStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsSaldoStkEstPorAgrupDepo extends Operation { 

  public TraerConsSaldoStkEstPorAgrupDepo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
  	
  	IDataSet ds = this.getDataSetConsSalEstStkPorAgrupDepo();
  	HashTableDatos condiciones = new HashTableDatos();
  	
  	
  	AgrupadorDeposito agrupadorDeposito = 
  		AgrupadorDeposito.findByOidProxy(mapaDatos.getInteger("oid_agrupador_deposito"),this.getSesion());
  	
  	if (agrupadorDeposito == null)
  		throw new ExceptionValidation(null,"Debe ingresar el depósito");
  	
  	String codigo = null;
  	if (mapaDatos.containsKey("codigo")) {
  		codigo = mapaDatos.getString("codigo");
  		condiciones.put("codigo",codigo);
  	}
  		
  	String descripcion = null;
  	if (mapaDatos.containsKey("descripcion")) {
  		descripcion = mapaDatos.getString("descripcion");
  		condiciones.put("descripcion",descripcion);
  	}
  	
  	if (mapaDatos.containsKey("nc_int")) 
  		condiciones.put("nc_int","");
  	
  	if (mapaDatos.containsKey("nd_int")) 
  		condiciones.put("nd_int","");
  	// Parametro Estado Stock Libre
  	
  	
  	Iterator iterConsSaldoStk = 
  		ConsSalEstStkPorAgrupDepo.getConsSalEstadoStkPorAgrupDepo(agrupadorDeposito,
  				                                                      EstadoStock.getEstadoStockLibre(this.getSesion()),
  				                                                      condiciones,
  				                                                      this.getSesion()).iterator();
  	while (iterConsSaldoStk.hasNext()) {
  		ConsSalEstStkPorAgrupDepo consSaldoEst = (ConsSalEstStkPorAgrupDepo) iterConsSaldoStk.next();
  		cargarRegistro(ds,consSaldoEst);
  	}
  	
    
    writeCliente(ds);
  }

  private IDataSet getDataSetConsSalEstStkPorAgrupDepo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConsSalEstStkPorAgrupDepo");
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50)); 
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100)); 
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
  														ConsSalEstStkPorAgrupDepo consSaldoStkEstPorAgrupDepo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_producto", consSaldoStkEstPorAgrupDepo.getOid_producto());
    dataset.fieldValue("cod_producto", consSaldoStkEstPorAgrupDepo.getCod_producto());
    dataset.fieldValue("desc_producto", consSaldoStkEstPorAgrupDepo.getDesc_producto());
    dataset.fieldValue("cantidad", consSaldoStkEstPorAgrupDepo.getCantidad());
    dataset.fieldValue("oid_um", consSaldoStkEstPorAgrupDepo.getOid_um());
    dataset.fieldValue("cod_um", consSaldoStkEstPorAgrupDepo.getCod_um());
    dataset.fieldValue("oid_estado_stock", consSaldoStkEstPorAgrupDepo.getOid_estado_stock());
  }  
  
}
