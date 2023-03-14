package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.AtributoEnGrupo;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.contabilidad.da.DBAtributoEnGrupo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAtributoEnGrupo extends FactoryObjetoLogico { 

  public FactoryAtributoEnGrupo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AtributoEnGrupo atributoengrupo = (AtributoEnGrupo) objLog;
    atributoengrupo.setOID(db.getInteger(DBAtributoEnGrupo.OID_ATRI_EN_GRUPO));
    atributoengrupo.setGrupoatri(GrupoDeAtributos.findByOidProxy(db.getInteger(DBAtributoEnGrupo.OID_GRUPOS_ATRI),getSesion()));
    atributoengrupo.setAtributo(Atributo.findByOidProxy(db.getInteger(DBAtributoEnGrupo.OID_ATRIBUTO),getSesion()));
    atributoengrupo.setSecu(db.getInteger(DBAtributoEnGrupo.SECU));
    atributoengrupo.setFormato(db.getString(DBAtributoEnGrupo.FORMATO));
    atributoengrupo.setObligatorio(db.getBoolean(DBAtributoEnGrupo.OBLIGATORIO));
    atributoengrupo.setMax_longitud(db.getInteger(DBAtributoEnGrupo.MAX_LONGITUD));
    atributoengrupo.setActivo(db.getBoolean(DBAtributoEnGrupo.ACTIVO));

  }
}
