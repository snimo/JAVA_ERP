package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PermisosInternos;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.cip.da.DBReglasPermisosInt;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReglasPermisosInt extends FactoryObjetoLogico { 

  public FactoryReglasPermisosInt() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReglasPermisosInt reglaspermisosint = (ReglasPermisosInt) objLog;
    reglaspermisosint.setOID(db.getInteger(DBReglasPermisosInt.OID_REGLA_PERMISO));
    reglaspermisosint.setPermisosinternos(PermisosInternos.findByOidProxy(db.getInteger(DBReglasPermisosInt.OID_PERMISO_INT),getSesion()));
    reglaspermisosint.setPrioridad(db.getInteger(DBReglasPermisosInt.PRIORIDAD));
    reglaspermisosint.setDescripcion(db.getString(DBReglasPermisosInt.DESCRIPCION));
    reglaspermisosint.setEs_una_vista(db.getBoolean(DBReglasPermisosInt.ES_UNA_VISTA));
    reglaspermisosint.setActivo(db.getBoolean(DBReglasPermisosInt.ACTIVO));

  }
}
