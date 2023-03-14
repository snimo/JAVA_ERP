package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.ComproAperturaEjercicio;
import com.srn.erp.contabilidad.bm.Ejercicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpAsientosApertura extends Operation {

  public TraerHelpAsientosApertura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = this.getDataSetAperturaEjercicio();
    traer(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traer(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Ejercicio ejercicio = null;
    HashTableDatos condiciones = new HashTableDatos();
    
    if (mapaDatos.containsKey("oid_ejercicio")) {
      ejercicio = Ejercicio.findByOidProxy(mapaDatos.getInteger("oid_ejercicio"),getSesion());
      condiciones.put(Ejercicio.NICKNAME,ejercicio);
    }
    
    List listaAsientosDeApertura =
        ComproAperturaEjercicio.getComprobantesAperturaEjercicio(ejercicio,this.getSesion());
    Iterator iterAsientosApertura = listaAsientosDeApertura.iterator();
    while (iterAsientosApertura.hasNext()) {
      ComproAperturaEjercicio comproAperturaEjercicio = (ComproAperturaEjercicio) iterAsientosApertura.next();
      cargarRegistroAperturaEjercicio(dataSet,comproAperturaEjercicio);
    }

  }

  private IDataSet getDataSetAperturaEjercicio() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpAsientosApertura");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_ejercicio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ejercicio", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ejercicio", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroAperturaEjercicio(IDataSet dataset,
		  							   		   ComproAperturaEjercicio comproAperturaEjercicio) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", comproAperturaEjercicio.getOIDInteger());
    dataset.fieldValue("oid_cco", comproAperturaEjercicio.getOIDInteger());
    dataset.fieldValue("nro_ext", comproAperturaEjercicio.getNroExt());
    dataset.fieldValue("fec_emision", comproAperturaEjercicio.getEmision());
    dataset.fieldValue("fec_imputacion", comproAperturaEjercicio.getImputac());
    dataset.fieldValue("activo", comproAperturaEjercicio.isActivo());
    dataset.fieldValue("comprobante", comproAperturaEjercicio.getCodigo());
    dataset.fieldValue("oid_ejercicio", comproAperturaEjercicio.getEjercicio().getOIDInteger());
    dataset.fieldValue("cod_ejercicio", comproAperturaEjercicio.getEjercicio().getNroejer());
    dataset.fieldValue("desc_ejercicio", comproAperturaEjercicio.getEjercicio().getDescripcion());
  }

}
