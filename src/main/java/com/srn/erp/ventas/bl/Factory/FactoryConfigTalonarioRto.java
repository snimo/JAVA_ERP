package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.bm.ConfigTalonarioRto;
import com.srn.erp.ventas.da.DBConfigTalonarioRto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfigTalonarioRto extends FactoryObjetoLogico {

  public FactoryConfigTalonarioRto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfigTalonarioRto configtalonariorto = (ConfigTalonarioRto) objLog;
    configtalonariorto.setOID(db.getInteger(DBConfigTalonarioRto.OID_CONF_TAL_RTO));
    configtalonariorto.setTalonario(Talonario.findByOidProxy(db.getInteger(DBConfigTalonarioRto.OID_TALONARIO),getSesion()));
    configtalonariorto.setActivo(db.getBoolean(DBConfigTalonarioRto.ACTIVO));
  }
}
