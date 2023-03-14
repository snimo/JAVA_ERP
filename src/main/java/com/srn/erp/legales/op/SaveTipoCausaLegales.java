package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoCausaLegales extends Operation { 

  public SaveTipoCausaLegales() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoCausaLegales"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoCausaLegales tipocausalegales = TipoCausaLegales.findByOid(dataset.getInteger("oid_tipo_causa"),getSesion());
        tipocausalegales.setOID(dataset.getInteger("oid_tipo_causa"));
        tipocausalegales.setDescripcion(dataset.getString("descripcion"));
        tipocausalegales.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tipocausalegales);
        dataset.next();
    }
  }
  
}
