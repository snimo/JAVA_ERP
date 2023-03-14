package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ConfigTalonarioFactClie;
import com.srn.erp.ventas.bm.OperHabiTalonarioFactClie;
import com.srn.erp.ventas.da.DBOperHabiTalonarioFactClie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryOperHabiTalonarioFactClie extends FactoryObjetoLogico {

  public FactoryOperHabiTalonarioFactClie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OperHabiTalonarioFactClie operhabitalonariofactclie = (OperHabiTalonarioFactClie) objLog;
    operhabitalonariofactclie.setOID(db.getInteger(DBOperHabiTalonarioFactClie.OID_OPER_TAL_FACT));
    operhabitalonariofactclie.setConf_tal_fact_clie(ConfigTalonarioFactClie.findByOidProxy(db.getInteger(DBOperHabiTalonarioFactClie.OID_CONF_TAL_FACT),getSesion()));
    operhabitalonariofactclie.setTipo_facturacion(db.getString(DBOperHabiTalonarioFactClie.TIPO_FACTURACION));
    operhabitalonariofactclie.setUsar_por_defecto(db.getBoolean(DBOperHabiTalonarioFactClie.USAR_POR_DEFECTO));
  }
}
