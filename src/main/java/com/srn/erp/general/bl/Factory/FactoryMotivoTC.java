package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBMotivoTC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoTC extends FactoryObjetoLogico { 

  public FactoryMotivoTC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoTC motivotc = (MotivoTC) objLog;
    motivotc.setOID(db.getInteger(DBMotivoTC.OID_MOTIVO_TC));
    motivotc.setMotivo_comprobante(MotivoComprobante.findByOidProxy(db.getInteger(DBMotivoTC.OID_MOTIVO_COMPRO),getSesion()));
    motivotc.setTipo_comprobate(TipoComprobante.findByOidProxy(db.getInteger(DBMotivoTC.OID_TC),getSesion()));
    motivotc.setActivo(db.getBoolean(DBMotivoTC.ACTIVO));

  }
}
