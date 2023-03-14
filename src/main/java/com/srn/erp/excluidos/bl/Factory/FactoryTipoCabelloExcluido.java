package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.TipoCabelloExcluido;
import com.srn.erp.excluidos.da.DBTipoCabelloExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoCabelloExcluido extends FactoryObjetoLogico { 

  public FactoryTipoCabelloExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoCabelloExcluido tipocabelloexcluido = (TipoCabelloExcluido) objLog;
    tipocabelloexcluido.setOID(db.getInteger(DBTipoCabelloExcluido.OID_TIPO_CABELLO));
    tipocabelloexcluido.setCodigo(db.getString(DBTipoCabelloExcluido.CODIGO));
    tipocabelloexcluido.setDescripcion(db.getString(DBTipoCabelloExcluido.DESCRIPCION));
    tipocabelloexcluido.setActivo(db.getBoolean(DBTipoCabelloExcluido.ACTIVO));

  }
}
