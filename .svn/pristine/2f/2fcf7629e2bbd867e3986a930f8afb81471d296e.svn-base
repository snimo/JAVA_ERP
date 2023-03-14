package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoPeriodo extends Operation { 

  public SaveTipoPeriodo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoPeriodo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoPeriodo tipoperiodo = TipoPeriodo.findByOid(dataset.getInteger("oid_tipo_peri"),getSesion());
        tipoperiodo.setOID(dataset.getInteger("oid_tipo_peri"));
        tipoperiodo.setCodigo(dataset.getString("codigo"));
        tipoperiodo.setDescripcion(dataset.getString("descripcion"));
        tipoperiodo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipoperiodo);
        dataset.next();
    }
  }
  
}
