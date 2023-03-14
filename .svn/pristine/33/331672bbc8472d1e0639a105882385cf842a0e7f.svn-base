package com.srn.erp.legales.op;


import com.srn.erp.legales.bm.TipoReclamoLeg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoReclamoLeg extends Operation { 

  public SaveTipoReclamoLeg() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoReclamoLeg"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoReclamoLeg tiporeclamoleg = TipoReclamoLeg.findByOid(dataset.getInteger("oid_tipo_reclamo"),getSesion());
        tiporeclamoleg.setOID(dataset.getInteger("oid_tipo_reclamo"));
        tiporeclamoleg.setDescripcion(dataset.getString("descripcion"));
        tiporeclamoleg.setActivo(dataset.getBoolean("activo"));
        addTransaccion(tiporeclamoleg);
        dataset.next();
    }
  }
  
}
