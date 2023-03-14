package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.bm.ConfigTalonarioFactClie;
import com.srn.erp.ventas.da.DBConfigTalonarioFactClie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfigTalonarioFactClie extends FactoryObjetoLogico {

  public FactoryConfigTalonarioFactClie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfigTalonarioFactClie configtalonariofactclie = (ConfigTalonarioFactClie) objLog;
    configtalonariofactclie.setOID(db.getInteger(DBConfigTalonarioFactClie.OID_CONF_TAL_FACT));
    configtalonariofactclie.setTalonario(Talonario.findByOidProxy(db.getInteger(DBConfigTalonarioFactClie.OID_TALONARIO),getSesion()));
    configtalonariofactclie.setActivo(db.getBoolean(DBConfigTalonarioFactClie.ACTIVO));
  }
}
