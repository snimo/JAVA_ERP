package com.srn.erp.cashflow.op;


import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.ProgFechasCF;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveProgFechasCF extends Operation { 

  public SaveProgFechasCF() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TProgFechasCF"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ProgFechasCF progfechascf = ProgFechasCF.findByOid(dataset.getInteger("oid_prog_cf"),getSesion());
        progfechascf.setOID(dataset.getInteger("oid_prog_cf"));
        progfechascf.setCodigo(dataset.getString("codigo"));
        progfechascf.setDescripcion(dataset.getString("descripcion"));
        progfechascf.setFec_desde(dataset.getDate("fec_desde"));
        progfechascf.setFec_hasta(dataset.getDate("fec_hasta"));
        progfechascf.setActivo(dataset.getBoolean("activo"));
        progfechascf.setEscenario(EscenarioCashFlow.findByOidProxy(dataset.getInteger("oid_escenario"), this.getSesion()));
        addTransaccion(progfechascf);
        dataset.next();
    }
  }
  
}
