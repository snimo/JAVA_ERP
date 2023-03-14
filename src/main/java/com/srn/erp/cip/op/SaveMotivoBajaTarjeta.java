package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoBajaTarjeta extends Operation { 

  public SaveMotivoBajaTarjeta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoBajaTarjeta"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoBajaTarjeta motivobajatarjeta = MotivoBajaTarjeta.findByOid(dataset.getInteger("oid_mot_baj_tar"),getSesion());
        motivobajatarjeta.setOID(dataset.getInteger("oid_mot_baj_tar"));
        motivobajatarjeta.setCodigo(dataset.getString("codigo"));
        motivobajatarjeta.setDescripcion(dataset.getString("descripcion"));
        motivobajatarjeta.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivobajatarjeta);
        dataset.next();
    }
  }
  
}
