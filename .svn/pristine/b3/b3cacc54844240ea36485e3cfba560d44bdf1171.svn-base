package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadosExcluidosUltNroActa;
import com.srn.erp.excluidos.da.DBEstadosExcluidosUltNroActa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadosExcluidosUltNroActa extends FactoryObjetoLogico { 

  public FactoryEstadosExcluidosUltNroActa() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadosExcluidosUltNroActa estadosexcluidosultnroacta = (EstadosExcluidosUltNroActa) objLog;
    estadosexcluidosultnroacta.setOID(db.getInteger(DBEstadosExcluidosUltNroActa.OID_ESTADO));
    estadosexcluidosultnroacta.setDescripcion(db.getString(DBEstadosExcluidosUltNroActa.DESCRIPCION));
    estadosexcluidosultnroacta.setUlt_nro(db.getInteger(DBEstadosExcluidosUltNroActa.ULT_NRO));

  }
}
