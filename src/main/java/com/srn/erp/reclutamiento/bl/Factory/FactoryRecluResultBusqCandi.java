package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluResultBusqCandi;
import com.srn.erp.reclutamiento.da.DBRecluResultBusqCandi;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluResultBusqCandi extends FactoryObjetoLogico { 

  public FactoryRecluResultBusqCandi() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluResultBusqCandi recluresultbusqcandidatos = (RecluResultBusqCandi) objLog;
    recluresultbusqcandidatos.setOID(db.getInteger(DBRecluResultBusqCandi.OID_RESULT_BUSQ));
    recluresultbusqcandidatos.setNro_lote(db.getInteger(DBRecluResultBusqCandi.NRO_LOTE));
    recluresultbusqcandidatos.setOid_obj_neg(db.getInteger(DBRecluResultBusqCandi.OID_OBJ_NEG));
    recluresultbusqcandidatos.setFec_alta(db.getDate(DBRecluResultBusqCandi.FEC_ALTA));
    recluresultbusqcandidatos.setActivo(db.getBoolean(DBRecluResultBusqCandi.ACTIVO));
    recluresultbusqcandidatos.setNro_Orden(db.getInteger(DBRecluResultBusqCandi.NRO_ORDEN));
  }
}
