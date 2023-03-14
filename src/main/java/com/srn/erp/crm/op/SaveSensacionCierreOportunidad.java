package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.SensacionCierreOportunidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSensacionCierreOportunidad extends Operation { 

  public SaveSensacionCierreOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSensacionCierreOportunidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SensacionCierreOportunidad sensacioncierreoportunidad = SensacionCierreOportunidad.findByOid(dataset.getInteger("oid"),getSesion());
        sensacioncierreoportunidad.setOID(dataset.getInteger("oid"));
        sensacioncierreoportunidad.setCodigo(dataset.getString("codigo"));
        sensacioncierreoportunidad.setDescripcion(dataset.getString("descripcion"));
        sensacioncierreoportunidad.setActivo(dataset.getBoolean("activo"));
        addTransaccion(sensacioncierreoportunidad);
        dataset.next();
    }
  }
  
}
