package com.srn.erp.costos.op;

import com.srn.erp.costos.bm.ProcesoCostoProductos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProcesoCostoProductos extends Operation { 

  public SaveProcesoCostoProductos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TProcesoCostoProductos"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ProcesoCostoProductos procesocostoproductos = ProcesoCostoProductos.findByOid(dataset.getInteger("oid_proceso_costo"),getSesion());
        procesocostoproductos.setOID(dataset.getInteger("oid_proceso_costo"));
        procesocostoproductos.setFecha_costo(dataset.getDate("fec_costo"));
        procesocostoproductos.setFec_desde(dataset.getDate("fec_desde"));
        procesocostoproductos.setFec_hasta(dataset.getDate("fec_hasta"));
        procesocostoproductos.setActivo(dataset.getBoolean("activo"));
        addTransaccion(procesocostoproductos);
        dataset.next();
    }
  }
  
}
