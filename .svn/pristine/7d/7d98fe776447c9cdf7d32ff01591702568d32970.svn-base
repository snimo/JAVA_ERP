package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.ConsultaPrecios;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaPrecios extends Operation {

  public TraerConsultaPrecios() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = this.getDataSetConsultaPrecios();
    traerPrecios(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traerPrecios(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

  	
  	HashTableDatos condiciones = new HashTableDatos();

    if (mapaDatos.containsKey("codigo"))
      condiciones.put("codigo",mapaDatos.getString("codigo"));
    
    if (mapaDatos.containsKey("descripcion"))
      condiciones.put("descripcion",mapaDatos.getString("descripcion"));

    if (mapaDatos.containsKey("nc_int"))
      condiciones.put("nc_int","");
    
    if (mapaDatos.containsKey("nd_int"))
      condiciones.put("nd_int","");
    
    if (mapaDatos.containsKey("oid_lista_precios")) { 
    	ListaPrecios listaPrecios = 
    		ListaPrecios.findByOidProxy(mapaDatos.getInteger("oid_lista_precios"),this.getSesion());
    	condiciones.put(ListaPrecios.NICKNAME,listaPrecios);
    } else throw new ExceptionValidation(null,"Debe ingresar la Lista de Precios");
    
    
    Iterator iterConsultaPrecios =
        ConsultaPrecios.getPrecios(condiciones,getSesion()).iterator();
    
    IDataSet ds = this.getDataSetConsultaPrecios();
    while (iterConsultaPrecios.hasNext()) {
      ConsultaPrecios consultaPrecio = (ConsultaPrecios) iterConsultaPrecios.next();
      cargarRegistro(dataSet,
      		           consultaPrecio);
    }
    writeCliente(ds);

  }

  private IDataSet getDataSetConsultaPrecios() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConsultaPrecios");
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50)); 
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100)); 
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_um", Field.STRING, 20)); 
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_moneda", Field.STRING, 20)); 
    dataset.fieldDef(new Field("precio", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("precio_unitario", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         			ConsultaPrecios consultaPrecios) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_precio_cab", consultaPrecios.getOid_precio_cab());
    dataset.fieldValue("oid_producto", consultaPrecios.getOid_producto());
    dataset.fieldValue("cod_producto", consultaPrecios.getCod_producto());
    dataset.fieldValue("desc_producto", consultaPrecios.getDesc_producto());
    dataset.fieldValue("cantidad", consultaPrecios.getCantidad());
    dataset.fieldValue("oid_um", consultaPrecios.getOid_um());
    dataset.fieldValue("cod_um", consultaPrecios.getCod_um());
    dataset.fieldValue("oid_moneda", consultaPrecios.getOid_moneda());
    dataset.fieldValue("cod_moneda", consultaPrecios.getCod_moneda());
    dataset.fieldValue("precio", consultaPrecios.getPrecio());
    
    Money precio = null;
    if (consultaPrecios.getCantidad().doubleValue() != 1) {
      CalculadorMoney calc = new CalculadorMoney(new Money(consultaPrecios.getPrecio().doubleValue()));
      calc.dividirPor(new Money(consultaPrecios.getCantidad().doubleValue()));
      precio = calc.getResultMoney();
      dataset.fieldValue("precio_unitario", precio);
    } else {
    	precio = new Money(consultaPrecios.getPrecio().doubleValue());
    	dataset.fieldValue("precio_unitario", precio);
    }    
       
    
    
  }

}
