package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PermisoInternoPuesto;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.cip.da.DBPermisoInternoPuesto;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPermisoInternoPuesto extends FactoryObjetoLogico { 

  public FactoryPermisoInternoPuesto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PermisoInternoPuesto permisointernopuesto = (PermisoInternoPuesto) objLog;
    permisointernopuesto.setOID(db.getInteger(DBPermisoInternoPuesto.OID_PERM_INT_PUE));
    permisointernopuesto.setRegla_permiso(ReglasPermisosInt.findByOidProxy(db.getInteger(DBPermisoInternoPuesto.OID_REGLA_PERMISO),getSesion()));
    permisointernopuesto.setVal_clasif_puesto(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBPermisoInternoPuesto.OID_VAL_CLASIF_PUE),getSesion()));
    permisointernopuesto.setActivo(db.getBoolean(DBPermisoInternoPuesto.ACTIVO));

  }
}
