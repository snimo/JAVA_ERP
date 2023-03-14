package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.PerfilGrupoPuerta;
import com.srn.erp.cip.da.DBPerfilGrupoPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class FactoryPerfilGrupoPuerta extends FactoryObjetoLogico { 

  public FactoryPerfilGrupoPuerta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PerfilGrupoPuerta perfilgrupopuerta = (PerfilGrupoPuerta) objLog;
    perfilgrupopuerta.setOID(db.getInteger(DBPerfilGrupoPuerta.OID_PER_GRU_PUE));
    perfilgrupopuerta.setGrupo_puerta(GrupoPuerta.findByOidProxy(db.getInteger(DBPerfilGrupoPuerta.OID_GRUPO_PUERTA),getSesion()));
    perfilgrupopuerta.setPerfil_funcional(PerfilFuncional.findByOidProxy(db.getInteger(DBPerfilGrupoPuerta.OID_PERFIL_FUNC),getSesion()));
    perfilgrupopuerta.setHab_ing(db.getBoolean(DBPerfilGrupoPuerta.HAB_ING));
    perfilgrupopuerta.setHab_egr(db.getBoolean(DBPerfilGrupoPuerta.HAB_EGR));
    perfilgrupopuerta.setHab_ambos(db.getBoolean(DBPerfilGrupoPuerta.HAB_AMBOS));
    perfilgrupopuerta.setDen_ing(db.getBoolean(DBPerfilGrupoPuerta.DEN_ING));
    perfilgrupopuerta.setDen_egr(db.getBoolean(DBPerfilGrupoPuerta.DEN_EGR));
    perfilgrupopuerta.setDen_ambos(db.getBoolean(DBPerfilGrupoPuerta.DEN_AMBOS));
    perfilgrupopuerta.setActivo(db.getBoolean(DBPerfilGrupoPuerta.ACTIVO));

  }
}
