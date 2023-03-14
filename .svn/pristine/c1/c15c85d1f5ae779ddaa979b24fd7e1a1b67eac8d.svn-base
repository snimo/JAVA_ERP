package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTurnoGrupoEntidad extends Operation { 

  public SaveTurnoGrupoEntidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTurnoGrupoEntidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TurnoGrupoEntidad turnogrupoentidad = TurnoGrupoEntidad.findByOid(dataset.getInteger("oid_grupo_entidad"),getSesion());
        turnogrupoentidad.setOID(dataset.getInteger("oid_grupo_entidad"));
        turnogrupoentidad.setCod_grupo(dataset.getString("cod_grupo"));
        turnogrupoentidad.setDesc_grupo(dataset.getString("desc_grupo"));
        turnogrupoentidad.setComportamiento(dataset.getString("comportamiento"));
        turnogrupoentidad.setActivo(dataset.getBoolean("activo"));
        addTransaccion(turnogrupoentidad);
        dataset.next();
    }
  }
  
}
