package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.FactorConversion;
import com.srn.erp.general.da.DBFactorConversion;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFactorConversion extends FactoryObjetoLogico {

  public FactoryFactorConversion() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FactorConversion factorconversion = (FactorConversion) objLog;
    factorconversion.setOID(db.getInteger(DBFactorConversion.OID_FACT_CONV));
    factorconversion.setUni_med_ori(UnidadMedida.findByOidProxy(db.getInteger(DBFactorConversion.OID_UM_ORI),getSesion()));
    factorconversion.setUni_med_dest(UnidadMedida.findByOidProxy(db.getInteger(DBFactorConversion.OID_UM_DEST),getSesion()));
    factorconversion.setFactor(db.getDouble(DBFactorConversion.FACTOR));
    factorconversion.setActivo(db.getBoolean(DBFactorConversion.ACTIVO));

  }
}
