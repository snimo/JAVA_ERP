package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.HabilitadorCategAcc;
import com.srn.erp.cip.da.DBHabilitadorCategAcc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class FactoryHabilitadorCategAcc extends FactoryObjetoLogico { 

  public FactoryHabilitadorCategAcc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    HabilitadorCategAcc habilitadorcategacc = (HabilitadorCategAcc) objLog;
    habilitadorcategacc.setOID(db.getInteger(DBHabilitadorCategAcc.OID_HAB_CATEG_USU));
    habilitadorcategacc.setPerfil_funcional(PerfilFuncional.findByOidProxy(db.getInteger(DBHabilitadorCategAcc.OID_PERFIL_FUNC),getSesion()));
    habilitadorcategacc.setCategoria_acceso(CategAccesoCIP.findByOidProxy(db.getInteger(DBHabilitadorCategAcc.OID_CATEG_ACCESO),getSesion()));
    habilitadorcategacc.setActivo(db.getBoolean(DBHabilitadorCategAcc.ACTIVO));

  }
}
