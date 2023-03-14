package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioCalcInt;
import com.srn.erp.legales.da.DBJuicioCalcInt;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class FactoryJuicioCalcInt extends FactoryObjetoLogico { 

  public FactoryJuicioCalcInt() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    JuicioCalcInt juiciocalcint = (JuicioCalcInt) objLog;
    juiciocalcint.setOID(db.getInteger(DBJuicioCalcInt.OID_CALC_INT));
    juiciocalcint.setJuicio(Juicio.findByOidProxy(db.getInteger(DBJuicioCalcInt.OID_JUICIO),getSesion()));
    juiciocalcint.setFec_desde(db.getDate(DBJuicioCalcInt.FEC_DESDE));
    juiciocalcint.setFec_hasta(db.getDate(DBJuicioCalcInt.FEC_HASTA));
    juiciocalcint.setTipo_tasa(db.getString(DBJuicioCalcInt.TIPO_TASA));
    juiciocalcint.setPorc(db.getDouble(DBJuicioCalcInt.PORC));
    juiciocalcint.setInteres(db.getMoney(DBJuicioCalcInt.INTERES));
    juiciocalcint.setActivo(db.getBoolean(DBJuicioCalcInt.ACTIVO));

  }
}
