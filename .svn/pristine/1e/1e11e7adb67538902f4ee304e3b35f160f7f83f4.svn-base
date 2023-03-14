package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerEntidadTurno extends Operation { 

  public TraerEntidadTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EntidadTurno entidadturno = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       entidadturno = EntidadTurno.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       entidadturno = EntidadTurno.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEntidadTurno = getDataSetEntidadTurno();
    if (entidadturno != null) { 
        cargarRegistroEntidadTurno(datasetEntidadTurno, 
                         entidadturno.getOIDInteger(),
                         entidadturno.getCodigo(),
                         entidadturno.getDescripcion(),
                         entidadturno.getGrupo_entidad(),
                         entidadturno.isActivo());
    }
    writeCliente(datasetEntidadTurno);
  }

  private IDataSet getDataSetEntidadTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEntidadTurno");
    dataset.fieldDef(new Field("oid_entidad_turno", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_grupo_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_grupo_entidad", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_entidad", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEntidadTurno(IDataSet dataset, 
                         Integer oid_entidad_turno,
                         String codigo,
                         String descripcion,
                         TurnoGrupoEntidad grupoEntidad,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_entidad_turno", oid_entidad_turno);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_grupo_entidad", grupoEntidad.getOIDInteger());
    dataset.fieldValue("cod_grupo_entidad", grupoEntidad.getCodigo());
    dataset.fieldValue("desc_grupo_entidad", grupoEntidad.getDescripcion());
    dataset.fieldValue("activo", activo);
  }
}
