package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPermisosOper;
import com.srn.erp.reclutamiento.da.DBRecluPermisosOper;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluPermisosOper extends FactoryObjetoLogico { 

  public FactoryRecluPermisosOper() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluPermisosOper reclupermisosoper = (RecluPermisosOper) objLog;
    reclupermisosoper.setOID(db.getInteger(DBRecluPermisosOper.OID_OPER_HAB));
    reclupermisosoper.setOperacion(RecluOperacion.findByOidProxy(db.getInteger(DBRecluPermisosOper.OID_OPERACION),getSesion()));
    reclupermisosoper.setPerfil_funcional(PerfilFuncional.findByOidProxy(db.getInteger(DBRecluPermisosOper.OID_PEF_FUNC),getSesion()));
    reclupermisosoper.setTipo_oper(db.getString(DBRecluPermisosOper.TIPO_OPER));
    reclupermisosoper.setActivo(db.getBoolean(DBRecluPermisosOper.ACTIVO));

  }
}
