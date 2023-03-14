package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTurnoGrupoEntidad extends Operation { 

  public TraerTurnoGrupoEntidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TurnoGrupoEntidad turnogrupoentidad = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       turnogrupoentidad = TurnoGrupoEntidad.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       turnogrupoentidad = TurnoGrupoEntidad.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTurnoGrupoEntidad = getDataSetTurnoGrupoEntidad();
    if (turnogrupoentidad != null) { 
        cargarRegistroTurnoGrupoEntidad(datasetTurnoGrupoEntidad, 
                         turnogrupoentidad.getOIDInteger(),
                         turnogrupoentidad.getCod_grupo(),
                         turnogrupoentidad.getDesc_grupo(),
                         turnogrupoentidad.getComportamiento(),
                         turnogrupoentidad.isActivo());
    }
    writeCliente(datasetTurnoGrupoEntidad);
  }

  private IDataSet getDataSetTurnoGrupoEntidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTurnoGrupoEntidad");
    dataset.fieldDef(new Field("oid_grupo_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_grupo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("desc_grupo", Field.STRING, 100)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTurnoGrupoEntidad(IDataSet dataset, 
                         Integer oid_grupo_entidad,
                         String cod_grupo,
                         String desc_grupo,
                         String comportamiento,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_entidad", oid_grupo_entidad);
    dataset.fieldValue("cod_grupo", cod_grupo);
    dataset.fieldValue("desc_grupo", desc_grupo);
    dataset.fieldValue("comportamiento", comportamiento);
    dataset.fieldValue("activo", activo);
  }
  
}
