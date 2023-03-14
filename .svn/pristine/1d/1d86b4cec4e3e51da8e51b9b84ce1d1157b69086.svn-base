package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PermisoInternoSector;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.cip.da.DBPermisoInternoSector;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPermisoInternoSector extends FactoryObjetoLogico { 

  public FactoryPermisoInternoSector() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PermisoInternoSector permisointernosector = (PermisoInternoSector) objLog;
    permisointernosector.setOID(db.getInteger(DBPermisoInternoSector.OID_PERM_INT_SEC));
    permisointernosector.setRegla_permiso(ReglasPermisosInt.findByOidProxy(db.getInteger(DBPermisoInternoSector.OID_REGLA_PERMISO),getSesion()));
    permisointernosector.setVal_clasif_sector(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBPermisoInternoSector.OID_VAL_CLASIF_SEC),getSesion()));
    permisointernosector.setActivo(db.getBoolean(DBPermisoInternoSector.ACTIVO));

  }
}
