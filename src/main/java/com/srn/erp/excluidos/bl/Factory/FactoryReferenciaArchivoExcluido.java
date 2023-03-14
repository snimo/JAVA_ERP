package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.ReferenciaArchivoExcluido;
import com.srn.erp.excluidos.da.DBReferenciaArchivoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryReferenciaArchivoExcluido extends FactoryObjetoLogico { 

  public FactoryReferenciaArchivoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReferenciaArchivoExcluido referenciaarchivoexcluido = (ReferenciaArchivoExcluido) objLog;
    referenciaarchivoexcluido.setOID(db.getInteger(DBReferenciaArchivoExcluido.OID_REF_ARCHIVO));
    referenciaarchivoexcluido.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBReferenciaArchivoExcluido.OID_INDIVIDUO),getSesion()));
    referenciaarchivoexcluido.setFecha(db.getDate(DBReferenciaArchivoExcluido.FECHA));
    referenciaarchivoexcluido.setTitulo(db.getString(DBReferenciaArchivoExcluido.TITULO));
    referenciaarchivoexcluido.setActivo(db.getBoolean(DBReferenciaArchivoExcluido.ACTIVO));

  }
}
