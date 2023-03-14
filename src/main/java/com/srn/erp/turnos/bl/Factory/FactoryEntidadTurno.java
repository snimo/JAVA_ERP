package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.EntidadTurno;
import com.srn.erp.turnos.bm.TurnoGrupoEntidad;
import com.srn.erp.turnos.da.DBEntidadTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEntidadTurno extends FactoryObjetoLogico { 

  public FactoryEntidadTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EntidadTurno entidadturno = (EntidadTurno) objLog;
    entidadturno.setOID(db.getInteger(DBEntidadTurno.OID_ENTIDAD_TURNO));
    entidadturno.setCodigo(db.getString(DBEntidadTurno.CODIGO));
    entidadturno.setDescripcion(db.getString(DBEntidadTurno.DESCRIPCION));
    entidadturno.setGrupo_entidad(TurnoGrupoEntidad.findByOidProxy(db.getInteger(DBEntidadTurno.OID_GRUPO_ENTIDAD),getSesion()));
    entidadturno.setActivo(db.getBoolean(DBEntidadTurno.ACTIVO));

  }
}
