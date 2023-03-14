package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveAgrupadorPlano extends Operation { 

  public SaveAgrupadorPlano() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAgrupadorPlano"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AgrupadorPlano agrupadorplano = AgrupadorPlano.findByOid(dataset.getInteger("oid_agrup_plano"),getSesion());
        agrupadorplano.setOID(dataset.getInteger("oid_agrup_plano"));
        agrupadorplano.setCodigo(dataset.getString("codigo"));
        agrupadorplano.setDescripcion(dataset.getString("descripcion"));
        agrupadorplano.setOrden(dataset.getInteger("orden"));
        agrupadorplano.setActivo(dataset.getBoolean("activo"));
        addTransaccion(agrupadorplano);
        dataset.next();
    }
  }
  
}
