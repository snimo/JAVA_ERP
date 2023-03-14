package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.Ejercicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpAsientosCierreEjer extends Operation {

  public TraerHelpAsientosCierreEjer() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = this.getDataSetCierreEjercicio();
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
    
    List listaAsientosDeCierre =
        ComproCierreEjercicio.getComprobantesCierreEjercicio(ejercicio,this.getSesion());
    Iterator iterAsientosCierre = listaAsientosDeCierre.iterator();
    while (iterAsientosCierre.hasNext()) {
      ComproCierreEjercicio comproCierreEjercicio = (ComproCierreEjercicio) iterAsientosCierre.next();
      cargarRegistroCierreEjercicio(dataSet,comproCierreEjercicio);
    }

  }

  private IDataSet getDataSetCierreEjercicio() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpAsientosCierre");
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
    dataset.fieldDef(new Field("cierre_de", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroCierreEjercicio(IDataSet dataset,
		  									 ComproCierreEjercicio comproCierreEjercicio) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", comproCierreEjercicio.getOIDInteger());
    dataset.fieldValue("oid_cco", comproCierreEjercicio.getOIDInteger());
    dataset.fieldValue("nro_ext", comproCierreEjercicio.getNroExt());
    dataset.fieldValue("fec_emision", comproCierreEjercicio.getEmision());
    dataset.fieldValue("fec_imputacion", comproCierreEjercicio.getImputac());
    dataset.fieldValue("activo", comproCierreEjercicio.isActivo());
    dataset.fieldValue("comprobante", comproCierreEjercicio.getCodigo());
    dataset.fieldValue("oid_ejercicio", comproCierreEjercicio.getEjercicio().getOIDInteger());
    dataset.fieldValue("cod_ejercicio", comproCierreEjercicio.getEjercicio().getNroejer());
    dataset.fieldValue("desc_ejercicio", comproCierreEjercicio.getEjercicio().getDescripcion());
    dataset.fieldValue("cierre_de", ComproCierreEjercicio.getDescTipoCierre(comproCierreEjercicio.getCierreDe()));
  }

}
