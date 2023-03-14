package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.ImagenesExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBImagenesExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryImagenesExcluido extends FactoryObjetoLogico { 

  public FactoryImagenesExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ImagenesExcluido imagenesexcluido = (ImagenesExcluido) objLog;
    imagenesexcluido.setOID(db.getInteger(DBImagenesExcluido.OID_IMAGEN));
    imagenesexcluido.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBImagenesExcluido.OID_INDIVIDUO),getSesion()));
    imagenesexcluido.setFecha(db.getDate(DBImagenesExcluido.FECHA));
    imagenesexcluido.setComentario(db.getString(DBImagenesExcluido.COMENTARIO));
    imagenesexcluido.setOrden(db.getInteger(DBImagenesExcluido.ORDEN));
    imagenesexcluido.setActivo(db.getBoolean(DBImagenesExcluido.ACTIVO));
    imagenesexcluido.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBImagenesExcluido.OID_PREDIO), this.getSesion()));
    

  }
}
