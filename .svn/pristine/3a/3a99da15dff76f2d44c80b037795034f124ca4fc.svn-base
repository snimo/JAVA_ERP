package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.MotivoFaltaRRHH;
import com.srn.erp.rrhh.da.DBMotivoFaltaRRHH;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoFaltaRRHH extends FactoryObjetoLogico { 

  public FactoryMotivoFaltaRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoFaltaRRHH motivofaltarrhh = (MotivoFaltaRRHH) objLog;
    motivofaltarrhh.setOID(db.getInteger(DBMotivoFaltaRRHH.OID_MOT_FALTA));
    motivofaltarrhh.setCodigo(db.getString(DBMotivoFaltaRRHH.CODIGO));
    motivofaltarrhh.setDescripcion(db.getString(DBMotivoFaltaRRHH.DESCRIPCION));
    motivofaltarrhh.setActivo(db.getBoolean(DBMotivoFaltaRRHH.ACTIVO));

  }
}
