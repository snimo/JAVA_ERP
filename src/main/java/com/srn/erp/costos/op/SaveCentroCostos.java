package com.srn.erp.costos.op;

import com.srn.erp.costos.bm.CentroCostos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCentroCostos extends Operation { 

  public SaveCentroCostos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCentroCostos"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CentroCostos centrocostos = CentroCostos.findByOid(dataset.getInteger("oid_centro"),getSesion());
        centrocostos.setOID(dataset.getInteger("oid_centro"));
        centrocostos.setCodigo(dataset.getString("codigo"));
        centrocostos.setDescripcion(dataset.getString("descripcion"));
        centrocostos.setActivo(dataset.getBoolean("activo"));
        
        grabarValoresClasif(centrocostos,dataset);
        
        addTransaccion(centrocostos);
        dataset.next();
    }
  }
  
  private void grabarValoresClasif(CentroCostos centroCostos,IDataSet dsSujeto) throws BaseException {
	    IDataSet dsValClasif = dsSujeto.getDataSet("TValoresClasificadores");
	    dsValClasif.first();
	    while (!dsValClasif.EOF()) {
	      centroCostos.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
	                                     dsValClasif.getInteger("oid_val_clasif_ent"));
	      dsValClasif.next();
	    }
  }
  
}
