package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.GrupoBien;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.VidaUtilGrupo;
import com.srn.erp.bienUso.da.DBVidaUtilGrupo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVidaUtilGrupo extends FactoryObjetoLogico { 

  public FactoryVidaUtilGrupo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    VidaUtilGrupo vidautilgrupo = (VidaUtilGrupo) objLog;
    vidautilgrupo.setOID(db.getInteger(DBVidaUtilGrupo.OID_VIDA_UTIL_G));
    vidautilgrupo.setGrupo_bien(GrupoBien.findByOidProxy(db.getInteger(DBVidaUtilGrupo.OID_GRUPO_BIEN_USO),getSesion()));
    vidautilgrupo.setSistema_valuacion(SistemaValuacion.findByOidProxy(db.getInteger(DBVidaUtilGrupo.OID_SIST_VAL),getSesion()));
    vidautilgrupo.setVida_util(db.getInteger(DBVidaUtilGrupo.VIDA_UTIL));
    vidautilgrupo.setActivo(db.getBoolean(DBVidaUtilGrupo.ACTIVO));

  }
}
