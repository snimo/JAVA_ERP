package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PermisoInternoEmpresa;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.cip.da.DBPermisoInternoEmpresa;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPermisoInternoEmpresa extends FactoryObjetoLogico { 

  public FactoryPermisoInternoEmpresa() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PermisoInternoEmpresa permisointernoempresa = (PermisoInternoEmpresa) objLog;
    permisointernoempresa.setOID(db.getInteger(DBPermisoInternoEmpresa.OID_PERM_INT_EMP));
    permisointernoempresa.setRegla_permiso(ReglasPermisosInt.findByOidProxy(db.getInteger(DBPermisoInternoEmpresa.OID_REGLA_PERMISO),getSesion()));
    permisointernoempresa.setVal_clasif_empresa(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBPermisoInternoEmpresa.OID_VAL_CLASIF_EMP),getSesion()));
    permisointernoempresa.setActivo(db.getBoolean(DBPermisoInternoEmpresa.ACTIVO));

  }
}
