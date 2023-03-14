package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.SolicitarAPedMerc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSolicitarAPedMerc extends Operation { 

  public SaveSolicitarAPedMerc() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSolicitarAPedMerc"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SolicitarAPedMerc solicitarapedmerc = SolicitarAPedMerc.findByOid(dataset.getInteger("oid_sol_ped_merc"),getSesion());
        solicitarapedmerc.setOID(dataset.getInteger("oid_sol_ped_merc"));
        solicitarapedmerc.setCodigo(dataset.getString("codigo"));
        solicitarapedmerc.setDescripcion(dataset.getString("descripcion"));
        solicitarapedmerc.setActivo(dataset.getBoolean("activo"));
        addTransaccion(solicitarapedmerc);
        dataset.next();
    }
  }
  
}
