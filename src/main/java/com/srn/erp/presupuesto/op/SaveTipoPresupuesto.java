package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.TipoPresupuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoPresupuesto extends Operation { 

  public SaveTipoPresupuesto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoPresupuesto"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoPresupuesto tipopresupuesto = TipoPresupuesto.findByOid(dataset.getInteger("oid_tipo_presu"),getSesion());
        tipopresupuesto.setOID(dataset.getInteger("oid_tipo_presu"));
        tipopresupuesto.setCodigo(dataset.getString("codigo"));
        tipopresupuesto.setDescripcion(dataset.getString("descripcion"));
        tipopresupuesto.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipopresupuesto);
        dataset.next();
    }
  }
  
}
