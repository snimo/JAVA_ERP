package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.DispMovilExc;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.LogSincroExcluido;
import com.srn.erp.excluidos.da.DBLogSincroExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLogSincroExcluido extends FactoryObjetoLogico { 

  public FactoryLogSincroExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LogSincroExcluido logsincroexcluido = (LogSincroExcluido) objLog;
    logsincroexcluido.setOID(db.getInteger(DBLogSincroExcluido.OID_LOG_SINCRO));
    logsincroexcluido.setDisp_movil(DispMovilExc.findByOidProxy(db.getInteger(DBLogSincroExcluido.OID_DISP_MOVIL),getSesion()));
    logsincroexcluido.setFecha(db.getDate(DBLogSincroExcluido.FECHA));
    logsincroexcluido.setHora(db.getString(DBLogSincroExcluido.HORA));
    logsincroexcluido.setGrupo_imp_exc(GrupoImportacionExcluido.findByOidProxy(db.getInteger(DBLogSincroExcluido.OID_GRUPO_IMP_EXC),getSesion()));
    logsincroexcluido.setNro_lote(db.getInteger(DBLogSincroExcluido.NRO_LOTE));
    logsincroexcluido.setActivo(db.getBoolean(DBLogSincroExcluido.ACTIVO));

  }
}
