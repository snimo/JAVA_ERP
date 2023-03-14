package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.PuntoFichadaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePuntoFichadaCIP extends Operation { 

  public SavePuntoFichadaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPuntoFichadaCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        PuntoFichadaCIP puntofichadacip = PuntoFichadaCIP.findByOid(dataset.getInteger("oid_pto_fichada"),getSesion());
        puntofichadacip.setOID(dataset.getInteger("oid_pto_fichada"));
        puntofichadacip.setCodigo(dataset.getString("codigo"));
        puntofichadacip.setDescripcion(dataset.getString("descripcion"));
        puntofichadacip.setActivo(dataset.getBoolean("activo"));
        puntofichadacip.setAntiPassbackEnt(dataset.getBoolean("antipassback_ent"));
        puntofichadacip.setAntiPassbackSal(dataset.getBoolean("antipassback_sal"));
        
        addTransaccion(puntofichadacip);
        dataset.next();
    }
  }
  
}
