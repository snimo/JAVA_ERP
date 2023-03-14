package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ConfigTalonarioRto;
import com.srn.erp.ventas.bm.OperHabiTalonarioRto;
import com.srn.erp.ventas.da.DBOperHabiTalonarioRto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryOperHabiTalonarioRto extends FactoryObjetoLogico {

  public FactoryOperHabiTalonarioRto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OperHabiTalonarioRto operhabitalonariorto = (OperHabiTalonarioRto) objLog;
    operhabitalonariorto.setOID(db.getInteger(DBOperHabiTalonarioRto.OID_OPER_TAL_RTO));
    operhabitalonariorto.setConfig_talonario_rto(ConfigTalonarioRto.findByOidProxy(db.getInteger(DBOperHabiTalonarioRto.OID_CONF_TAL_RTO),getSesion()));
    operhabitalonariorto.setTipo_rto(db.getString(DBOperHabiTalonarioRto.TIPO_RTO));
    operhabitalonariorto.setUsarPorDefecto(db.getBoolean(DBOperHabiTalonarioRto.USAR_POR_DEFECTO));
  }
}
