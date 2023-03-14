package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.ArchAdjExc;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBArchAdjExc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryArchAdjExc extends FactoryObjetoLogico { 

  public FactoryArchAdjExc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ArchAdjExc archadjexc = (ArchAdjExc) objLog;
    archadjexc.setOID(db.getInteger(DBArchAdjExc.OID_ARCH_ADJ));
    archadjexc.setFecha(db.getDate(DBArchAdjExc.FECHA));
    archadjexc.setNombre(db.getString(DBArchAdjExc.NOMBRE));
    archadjexc.setTitulo(db.getString(DBArchAdjExc.TITULO));
    archadjexc.setActivo(db.getBoolean(DBArchAdjExc.ACTIVO));
    archadjexc.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBArchAdjExc.OID_INDIVIDUO), this.getSesion()));
    archadjexc.setOrden(db.getInteger(DBArchAdjExc.ORDEN));
    archadjexc.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBArchAdjExc.OID_PREDIO), this.getSesion()));
  }
}
