package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
import com.srn.erp.ventas.bm.OperHabiTalonarioFactClie;
import com.srn.erp.ventas.da.DBCompoStkTalonarioFactClie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoStkTalonarioFactClie extends FactoryObjetoLogico {

  public FactoryCompoStkTalonarioFactClie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoStkTalonarioFactClie compostktalonariofactclie = (CompoStkTalonarioFactClie) objLog;
    compostktalonariofactclie.setOID(db.getInteger(DBCompoStkTalonarioFactClie.OID_COMPO_STK_FACT));
    compostktalonariofactclie.setOper_tal_fact_clie(OperHabiTalonarioFactClie.findByOidProxy(db.getInteger(DBCompoStkTalonarioFactClie.OID_OPER_TAL_FACT),getSesion()));
    compostktalonariofactclie.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBCompoStkTalonarioFactClie.OID_TIPO_CONF_MOV),getSesion()));
    compostktalonariofactclie.setUsar_por_defecto(db.getBoolean(DBCompoStkTalonarioFactClie.USAR_POR_DEFECTO));
  }
}
