package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTurnoExcluido extends Operation { 

  public SaveTurnoExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTurnoExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TurnoExcluido turnoexcluido = TurnoExcluido.findByOid(dataset.getInteger("oid_turno"),getSesion());
        turnoexcluido.setOID(dataset.getInteger("oid_turno"));
        turnoexcluido.setCodigo(dataset.getString("codigo"));
        turnoexcluido.setDescripcion(dataset.getString("descripcion"));
        turnoexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(turnoexcluido);
        dataset.next();
    }
  }
  
}
