package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.PermisoInternoEstado;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.cip.da.DBPermisoInternoEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPermisoInternoEstado extends FactoryObjetoLogico { 

  public FactoryPermisoInternoEstado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PermisoInternoEstado permisointernoestado = (PermisoInternoEstado) objLog;
    permisointernoestado.setOID(db.getInteger(DBPermisoInternoEstado.OID_PERM_INT_EST));
    permisointernoestado.setRegla_permiso(ReglasPermisosInt.findByOidProxy(db.getInteger(DBPermisoInternoEstado.OID_REGLA_PERMISO),getSesion()));
    permisointernoestado.setEstado_cip(EstadoCIP.findByOidProxy(db.getInteger(DBPermisoInternoEstado.OID_ESTADO_CIP),getSesion()));
    permisointernoestado.setActivo(db.getBoolean(DBPermisoInternoEstado.ACTIVO));

  }
}
