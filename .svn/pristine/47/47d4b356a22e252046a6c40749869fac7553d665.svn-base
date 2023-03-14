package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ConfigTalonarioAjuStk;
import com.srn.erp.stock.bm.OperHabiTalonarioAjuStk;
import com.srn.erp.stock.da.DBOperHabiTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryOperHabiTalonarioAjuStk extends FactoryObjetoLogico {

  public FactoryOperHabiTalonarioAjuStk() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OperHabiTalonarioAjuStk operhabitalonarioajustk = (OperHabiTalonarioAjuStk) objLog;
    operhabitalonarioajustk.setOID(db.getInteger(DBOperHabiTalonarioAjuStk.OID_OPER_AJU_STK));
    operhabitalonarioajustk.setConf_tal_aju_stk(ConfigTalonarioAjuStk.findByOidProxy(db.getInteger(DBOperHabiTalonarioAjuStk.OID_CONF_TAL_STK),getSesion()));
    operhabitalonarioajustk.setTipo_aju_stk(db.getString(DBOperHabiTalonarioAjuStk.TIPO_AJU_STK));
    operhabitalonarioajustk.setUsar_por_defecto(db.getBoolean(DBOperHabiTalonarioAjuStk.USAR_POR_DEFECTO));

  }
}
