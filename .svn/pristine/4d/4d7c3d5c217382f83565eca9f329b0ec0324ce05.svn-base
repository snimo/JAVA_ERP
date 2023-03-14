package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.ConfColAnexoA;
import com.srn.erp.bienUso.bm.ConfColAnexoAMov;
import com.srn.erp.bienUso.da.DBConfColAnexoAMov;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfColAnexoAMov extends FactoryObjetoLogico { 

  public FactoryConfColAnexoAMov() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfColAnexoAMov confcolanexoamov = (ConfColAnexoAMov) objLog;
    confcolanexoamov.setOID(db.getInteger(DBConfColAnexoAMov.OID_CONF_ANEXO_MOV));
    confcolanexoamov.setConf_col_aneoxo(ConfColAnexoA.findByOidProxy(db.getInteger(DBConfColAnexoAMov.OID_CONF_ANEXO_A),getSesion()));
    confcolanexoamov.setTipo_mov(db.getString(DBConfColAnexoAMov.TIPO_MOV));
    confcolanexoamov.setActivo(db.getBoolean(DBConfColAnexoAMov.ACTIVO));

  }
}
