package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveAgrupadorTarjConci extends Operation { 

  public SaveAgrupadorTarjConci() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAgrupadorTarjetas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AgrupadorTarjConci agrupadortarjconci = AgrupadorTarjConci.findByOid(dataset.getInteger("oid_agrup_tar"),getSesion());
        agrupadortarjconci.setOID(dataset.getInteger("oid_agrup_tar"));
        agrupadortarjconci.setCodigo(dataset.getString("codigo"));
        agrupadortarjconci.setDescripcion(dataset.getString("descripcion"));
        agrupadortarjconci.setActivo(dataset.getBoolean("activo"));
        addTransaccion(agrupadortarjconci);
        dataset.next();
    }
  }
  
}
