package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRelacionSujetoTurno extends Operation { 

  public SaveRelacionSujetoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRelacionSujetoTurno"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RelacionSujetoTurno relacionsujetoturno = RelacionSujetoTurno.findByOid(dataset.getInteger("oid_relacion"),getSesion());
        relacionsujetoturno.setOID(dataset.getInteger("oid_relacion"));
        relacionsujetoturno.setCodigo(dataset.getString("codigo"));
        relacionsujetoturno.setDescripcion(dataset.getString("descripcion"));
        relacionsujetoturno.setComportamiento(dataset.getString("comportamiento"));
        relacionsujetoturno.setActivo(dataset.getBoolean("activo"));
        relacionsujetoturno.setNoPermitirTurno(dataset.getBoolean("no_permitir_turno"));
        addTransaccion(relacionsujetoturno);
        dataset.next();
    }
  }
  
}
