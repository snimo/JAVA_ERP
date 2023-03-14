package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.RelacionExcluido;
import com.srn.erp.excluidos.da.DBRelacionExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRelacionExcluido extends FactoryObjetoLogico { 

  public FactoryRelacionExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RelacionExcluido relacionexcluido = (RelacionExcluido) objLog;
    relacionexcluido.setOID(db.getInteger(DBRelacionExcluido.OID_REL_INDI));
    relacionexcluido.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBRelacionExcluido.OID_INDIVIDUO),getSesion()));
    relacionexcluido.setIndividuo_rel(IndividuoExcluido.findByOidProxy(db.getInteger(DBRelacionExcluido.OID_IND_RELACIONADO),getSesion()));
    relacionexcluido.setSecu(db.getInteger(DBRelacionExcluido.SECU));
    relacionexcluido.setComentario(db.getString(DBRelacionExcluido.COMENTARIO));
    relacionexcluido.setActivo(db.getBoolean(DBRelacionExcluido.ACTIVO));
    relacionexcluido.setPredio(PredioExcluido.findByOidProxy(db.getInteger("oid_predio"), this.getSesion()));

  }
}
