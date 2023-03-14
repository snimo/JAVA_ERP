package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.da.DBMotivoEntIntermedias;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoEntIntermedias extends FactoryObjetoLogico { 

  public FactoryMotivoEntIntermedias() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoEntIntermedias motivoentintermedias = (MotivoEntIntermedias) objLog;
    motivoentintermedias.setOID(db.getInteger(DBMotivoEntIntermedias.OID_MOTIVO));
    motivoentintermedias.setCodigo(db.getString(DBMotivoEntIntermedias.CODIGO));
    motivoentintermedias.setDescripcion(db.getString(DBMotivoEntIntermedias.DESCRIPCION));
    motivoentintermedias.setActivo(db.getBoolean(DBMotivoEntIntermedias.ACTIVO));

  }
}
