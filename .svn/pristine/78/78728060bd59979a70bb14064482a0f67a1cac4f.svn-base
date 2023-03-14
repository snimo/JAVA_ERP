package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProyecto extends Operation { 

  public SaveProyecto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TProyecto"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Proyecto proyecto = Proyecto.findByOid(dataset.getInteger("oid_proyecto"),getSesion());
        proyecto.setOID(dataset.getInteger("oid_proyecto"));
        proyecto.setCodigo(dataset.getString("codigo"));
        proyecto.setDescripcion(dataset.getString("descripcion"));
        proyecto.setCerrado(dataset.getBoolean("cerrado"));
        proyecto.setSujeto(Sujeto.findByOid(dataset.getInteger("oid_sujeto"),this.getSesion()));
        proyecto.setActivo(dataset.getBoolean("activo"));
        
        grabarValoresClasif(proyecto,dataset);
        
        addTransaccion(proyecto);
        dataset.next();
    }
  }
  
  private void grabarValoresClasif(Proyecto proyecto,IDataSet dsSujeto) throws BaseException {
	    IDataSet dsValClasif = dsSujeto.getDataSet("TValoresClasificadores");
	    dsValClasif.first();
	    while (!dsValClasif.EOF()) {
	      proyecto.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
	                                     dsValClasif.getInteger("oid_val_clasif_ent"));
	      dsValClasif.next();
	    }
}
  
  
}
