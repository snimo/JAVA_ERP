package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.TurnoGrupoEntidad;
import com.srn.erp.turnos.da.DBTurnoGrupoEntidad;

public class FactoryTurnoGrupoEntidad extends FactoryObjetoLogico { 

  public FactoryTurnoGrupoEntidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TurnoGrupoEntidad turnogrupoentidad = (TurnoGrupoEntidad) objLog;
    turnogrupoentidad.setOID(db.getInteger(DBTurnoGrupoEntidad.OID_GRUPO_ENTIDAD));
    turnogrupoentidad.setCod_grupo(db.getString(DBTurnoGrupoEntidad.COD_GRUPO));
    turnogrupoentidad.setDesc_grupo(db.getString(DBTurnoGrupoEntidad.DESC_GRUPO));
    turnogrupoentidad.setComportamiento(db.getString(DBTurnoGrupoEntidad.COMPORTAMIENTO));
    turnogrupoentidad.setActivo(db.getBoolean(DBTurnoGrupoEntidad.ACTIVO));
  }
}
