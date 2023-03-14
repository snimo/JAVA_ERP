package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoReservaTurno extends Operation { 

  public SaveMotivoReservaTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoReservaTurno"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoReservaTurno motivoreservaturno = MotivoReservaTurno.findByOid(dataset.getInteger("oid_motivo"),getSesion());
        motivoreservaturno.setOID(dataset.getInteger("oid_motivo"));
        motivoreservaturno.setCodigo(dataset.getString("codigo"));
        motivoreservaturno.setDescripcion(dataset.getString("descripcion"));
        motivoreservaturno.setActivo(dataset.getBoolean("activo"));
        addTransaccion(motivoreservaturno);
        dataset.next();
    }
  }
  
}
