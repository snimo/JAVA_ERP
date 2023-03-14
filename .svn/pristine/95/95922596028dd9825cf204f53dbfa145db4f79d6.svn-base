package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.MotivoRechazoCC;
import com.srn.erp.compras.da.DBMotivoRechazoCC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoRechazoCC extends FactoryObjetoLogico { 

  public FactoryMotivoRechazoCC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoRechazoCC motivorechazocc = (MotivoRechazoCC) objLog;
    motivorechazocc.setOID(db.getInteger(DBMotivoRechazoCC.OID_MOT_REC_CC));
    motivorechazocc.setCodigo(db.getString(DBMotivoRechazoCC.CODIGO));
    motivorechazocc.setDescripcion(db.getString(DBMotivoRechazoCC.DESCRIPCION));
    motivorechazocc.setActivo(db.getBoolean(DBMotivoRechazoCC.ACTIVO));
  }
}
