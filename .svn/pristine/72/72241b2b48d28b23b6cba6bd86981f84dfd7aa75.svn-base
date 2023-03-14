package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.ClasificacionOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveClasificacionOportunidad extends Operation { 

  public SaveClasificacionOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TClasifOpor"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ClasificacionOportunidad clasifOpor = ClasificacionOportunidad.findByOid(dataset.getInteger("oid_clasif_opor"),getSesion());
        clasifOpor.setCodigo(dataset.getString("codigo"));
        clasifOpor.setDescripcion(dataset.getString("descripcion"));
        clasifOpor.setActivo(dataset.getBoolean("activo"));
        clasifOpor.setOID(dataset.getInteger("oid_clasif_opor"));
        addTransaccion(clasifOpor);
        dataset.next();
    }
  }
  
}
