package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.MotDifPagoExc;
import com.srn.erp.excluidos.da.DBMotDifPagoExc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotDifPagoExc extends FactoryObjetoLogico { 

  public FactoryMotDifPagoExc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotDifPagoExc motivodiferenciapagoexcluido = (MotDifPagoExc) objLog;
    motivodiferenciapagoexcluido.setOID(db.getInteger(DBMotDifPagoExc.OID_MOT_DIF_IMP));
    motivodiferenciapagoexcluido.setCodigo(db.getString(DBMotDifPagoExc.CODIGO));
    motivodiferenciapagoexcluido.setDescripcion(db.getString(DBMotDifPagoExc.DESCRIPCION));
    motivodiferenciapagoexcluido.setActivo(db.getBoolean(DBMotDifPagoExc.ACTIVO));

  }
}
