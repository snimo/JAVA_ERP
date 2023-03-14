package com.srn.erp.costos.op;

import com.srn.erp.costos.bm.CentroImputacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCentroImputacion extends Operation { 

  public SaveCentroImputacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCentroImputacion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CentroImputacion centroImputacion = CentroImputacion.findByOid(dataset.getInteger("oid_centro_imputac"),getSesion());
        centroImputacion.setOID(dataset.getInteger("oid_centro_imputac"));
        centroImputacion.setCodigo(dataset.getString("codigo"));
        centroImputacion.setDescripcion(dataset.getString("descripcion"));
        centroImputacion.setActivo(dataset.getBoolean("activo"));
        
        grabarValoresClasif(centroImputacion,dataset);
        
        addTransaccion(centroImputacion);
        dataset.next();
    }
  }
  
  private void grabarValoresClasif(CentroImputacion centroImputacion,IDataSet dsSujeto) throws BaseException {
	    IDataSet dsValClasif = dsSujeto.getDataSet("TValoresClasificadores");
	    dsValClasif.first();
	    while (!dsValClasif.EOF()) {
	    	centroImputacion.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
	                                     dsValClasif.getInteger("oid_val_clasif_ent"));
	      dsValClasif.next();
	    }
  }
  
}
