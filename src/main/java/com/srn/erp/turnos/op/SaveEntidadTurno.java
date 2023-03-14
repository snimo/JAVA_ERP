package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEntidadTurno extends Operation { 

  public SaveEntidadTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEntidadTurno"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EntidadTurno entidadturno = EntidadTurno.findByOid(dataset.getInteger("oid_entidad_turno"),getSesion());
        entidadturno.setOID(dataset.getInteger("oid_entidad_turno"));
        entidadturno.setCodigo(dataset.getString("codigo"));
        entidadturno.setDescripcion(dataset.getString("descripcion"));
        entidadturno.setGrupo_entidad(TurnoGrupoEntidad.findByOidProxy(dataset.getInteger("oid_grupo_entidad"),this.getSesion()));
        entidadturno.setActivo(dataset.getBoolean("activo"));
        addTransaccion(entidadturno);
        dataset.next();
    }
  }
  
}
