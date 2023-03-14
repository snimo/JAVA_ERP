package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.ConfigTalonarioAjuStk;
import com.srn.erp.stock.da.DBConfigTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfigTalonarioAjuStk extends FactoryObjetoLogico {

  public FactoryConfigTalonarioAjuStk() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfigTalonarioAjuStk configtalonarioajustk = (ConfigTalonarioAjuStk) objLog;
    configtalonarioajustk.setOID(db.getInteger(DBConfigTalonarioAjuStk.OID_CONF_TAL_STK));
    configtalonarioajustk.setTalonario(Talonario.findByOidProxy(db.getInteger(DBConfigTalonarioAjuStk.OID_TALONARIO),getSesion()));
    configtalonarioajustk.setActivo(db.getBoolean(DBConfigTalonarioAjuStk.ACTIVO));
  }
}
