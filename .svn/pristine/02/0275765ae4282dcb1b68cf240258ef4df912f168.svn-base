package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveConcPagoSeclo extends Operation { 

  public SaveConcPagoSeclo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TConcPagoSeclo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ConcPagoSeclo concpagoseclo = ConcPagoSeclo.findByOid(dataset.getInteger("oid_conc_pago_seclo"),getSesion());
        concpagoseclo.setOID(dataset.getInteger("oid_conc_pago_seclo"));
        concpagoseclo.setDescripcion(dataset.getString("descripcion"));
        concpagoseclo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(concpagoseclo);
        dataset.next();
    }
  }
  
}
