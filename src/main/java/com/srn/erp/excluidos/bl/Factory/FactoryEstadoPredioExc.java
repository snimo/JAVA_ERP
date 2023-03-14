package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.EstadoPredioExc;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBEstadoPredioExc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoPredioExc extends FactoryObjetoLogico { 

  public FactoryEstadoPredioExc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoPredioExc estadopredioexc = (EstadoPredioExc) objLog;
    estadopredioexc.setOID(db.getInteger(DBEstadoPredioExc.OID_ESTADO_PREDIO));
    estadopredioexc.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBEstadoPredioExc.OID_ESTADO),getSesion()));
    estadopredioexc.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBEstadoPredioExc.OID_PREDIO),getSesion()));
    estadopredioexc.setProponer_nro(db.getBoolean(DBEstadoPredioExc.PROPONER_NRO));
    estadopredioexc.setUlt_nro_propu(db.getInteger(DBEstadoPredioExc.ULT_NRO_PROPU));
    estadopredioexc.setNro_acta_obli(db.getBoolean(DBEstadoPredioExc.NRO_ACTA_OBLI));
    estadopredioexc.setPermite_modif_nro(db.getBoolean(DBEstadoPredioExc.PERMITE_MODIF_NRO));
    estadopredioexc.setActivo(db.getBoolean(DBEstadoPredioExc.ACTIVO));
    estadopredioexc.setConserva_nro(db.getBoolean(DBEstadoPredioExc.CONSERVA_NRO));
  }
}
