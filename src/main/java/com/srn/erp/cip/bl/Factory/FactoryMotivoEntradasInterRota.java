package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntradasInterRota;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.da.DBMotivoEntradasInterRota;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoEntradasInterRota extends FactoryObjetoLogico { 

  public FactoryMotivoEntradasInterRota() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoEntradasInterRota motivoentradasinterrota = (MotivoEntradasInterRota) objLog;
    motivoentradasinterrota.setOID(db.getInteger(DBMotivoEntradasInterRota.OID_MOT_ROTA));
    motivoentradasinterrota.setRota(Rota.findByOidProxy(db.getInteger(DBMotivoEntradasInterRota.OID_ROTA),getSesion()));
    motivoentradasinterrota.setMotivo(MotivoEntIntermedias.findByOidProxy(db.getInteger(DBMotivoEntradasInterRota.OID_MOTIVO),getSesion()));
    motivoentradasinterrota.setHorario_desde(db.getString(DBMotivoEntradasInterRota.HORARIO_DESDE));
    motivoentradasinterrota.setHorario_hasta(db.getString(DBMotivoEntradasInterRota.HORARIO_HASTA));
    motivoentradasinterrota.setActivo(db.getBoolean(DBMotivoEntradasInterRota.ACTIVO));
    motivoentradasinterrota.setAsignacion(db.getString(DBMotivoEntradasInterRota.ASIGNACION));

  }
}
