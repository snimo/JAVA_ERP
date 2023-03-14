package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.GrupoImportacionExcMaq;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.da.DBGrupoImportacionExcMaq;
import com.srn.erp.mensajero.bm.Maquina;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoImportacionExcMaq extends FactoryObjetoLogico { 

  public FactoryGrupoImportacionExcMaq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoImportacionExcMaq grupoimportacionexcmaq = (GrupoImportacionExcMaq) objLog;
    grupoimportacionexcmaq.setOID(db.getInteger(DBGrupoImportacionExcMaq.OID_GRUPO_IMP_MAQ));
    grupoimportacionexcmaq.setGrupo_imp_exc(GrupoImportacionExcluido.findByOidProxy(db.getInteger(DBGrupoImportacionExcMaq.OID_GRUPO_IMP_EXC),getSesion()));
    grupoimportacionexcmaq.setMaquina(Maquina.findByOidProxy(db.getInteger(DBGrupoImportacionExcMaq.OID_MAQUINA),getSesion()));
    grupoimportacionexcmaq.setActivo(db.getBoolean(DBGrupoImportacionExcMaq.ACTIVO));

  }
}
