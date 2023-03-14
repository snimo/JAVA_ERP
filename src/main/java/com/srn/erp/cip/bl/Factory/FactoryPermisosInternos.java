package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PermisosInternos;
import com.srn.erp.cip.da.DBPermisosInternos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPermisosInternos extends FactoryObjetoLogico { 

  public FactoryPermisosInternos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PermisosInternos permisosinternos = (PermisosInternos) objLog;
    permisosinternos.setOID(db.getInteger(DBPermisosInternos.OID_PERMISO_INT));
    permisosinternos.setCodigo(db.getString(DBPermisosInternos.CODIGO));
    permisosinternos.setDescripcion(db.getString(DBPermisosInternos.DESCRIPCION));
    permisosinternos.setActivo(db.getBoolean(DBPermisosInternos.ACTIVO));
    permisosinternos.setPrioridad(db.getInteger(DBPermisosInternos.PRIORIDAD));

  }
}
