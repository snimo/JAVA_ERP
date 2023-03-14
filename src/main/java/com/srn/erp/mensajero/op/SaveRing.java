package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRing extends Operation { 

  public SaveRing() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRing"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Ring ring = Ring.findByOid(dataset.getInteger("oid_ring"),getSesion());
        ring.setOID(dataset.getInteger("oid_ring"));
        ring.setCodigo(dataset.getString("codigo"));
        ring.setDescripcion(dataset.getString("descripcion"));
        ring.setActivo(dataset.getBoolean("activo"));
        addTransaccion(ring);
        dataset.next();
    }
  }
  
}
