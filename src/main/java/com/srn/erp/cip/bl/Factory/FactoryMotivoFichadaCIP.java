package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotivoFichadaCIP;
import com.srn.erp.cip.da.DBMotivoFichadaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoFichadaCIP extends FactoryObjetoLogico { 

  public FactoryMotivoFichadaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoFichadaCIP motivofichadacip = (MotivoFichadaCIP) objLog;
    motivofichadacip.setOID(db.getInteger(DBMotivoFichadaCIP.OID_MOTIVO_FICHADA));
    motivofichadacip.setDescripcion(db.getString(DBMotivoFichadaCIP.DESCRIPCION));
    motivofichadacip.setEntrada(db.getBoolean(DBMotivoFichadaCIP.ENTRADA));
    motivofichadacip.setRequiere_obs_ent(db.getBoolean(DBMotivoFichadaCIP.REQUIERE_OBS_ENT));
    motivofichadacip.setSalida(db.getBoolean(DBMotivoFichadaCIP.SALIDA));
    motivofichadacip.setRequiere_obs_sal(db.getBoolean(DBMotivoFichadaCIP.REQUIERE_OBS_SAL));
    motivofichadacip.setOrden_entrada(db.getInteger(DBMotivoFichadaCIP.ORDEN_ENTRADA));
    motivofichadacip.setOrden_salida(db.getInteger(DBMotivoFichadaCIP.ORDEN_SALIDA));
    motivofichadacip.setActivo(db.getBoolean(DBMotivoFichadaCIP.ACTIVO));

  }
}
