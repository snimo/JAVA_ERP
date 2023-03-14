package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PermisoInternoLegajo;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.cip.da.DBPermisoInternoLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPermisoInternoLegajo extends FactoryObjetoLogico { 

  public FactoryPermisoInternoLegajo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PermisoInternoLegajo permisointernolegajo = (PermisoInternoLegajo) objLog;
    permisointernolegajo.setOID(db.getInteger(DBPermisoInternoLegajo.OID_PERM_INT_LEG));
    permisointernolegajo.setRegla_permiso(ReglasPermisosInt.findByOidProxy(db.getInteger(DBPermisoInternoLegajo.OID_REGLA_PERMISO),getSesion()));
    permisointernolegajo.setLegajo(Legajo.findByOidProxy(db.getInteger(DBPermisoInternoLegajo.OID_LEGAJO),getSesion()));
    permisointernolegajo.setActivo(db.getBoolean(DBPermisoInternoLegajo.ACTIVO));

  }
}
