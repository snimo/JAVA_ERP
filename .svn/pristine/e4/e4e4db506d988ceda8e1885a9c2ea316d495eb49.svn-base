package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.bm.ConfigTalonarioDevVtas;
import com.srn.erp.ventas.da.DBConfigTalonarioDevVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfigTalonarioDevVtas extends FactoryObjetoLogico { 

  public FactoryConfigTalonarioDevVtas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfigTalonarioDevVtas configtalonariodevvtas = (ConfigTalonarioDevVtas) objLog;
    configtalonariodevvtas.setOID(db.getInteger(DBConfigTalonarioDevVtas.OID_CONF_TAL_DEV));
    configtalonariodevvtas.setTalonario(Talonario.findByOidProxy(db.getInteger(DBConfigTalonarioDevVtas.OID_TALONARIO),getSesion()));
    configtalonariodevvtas.setActivo(db.getBoolean(DBConfigTalonarioDevVtas.ACTIVO));

  }
}
