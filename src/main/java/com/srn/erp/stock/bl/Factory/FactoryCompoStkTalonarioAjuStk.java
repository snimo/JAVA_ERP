package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.CompoStkTalonarioAjuStk;
import com.srn.erp.stock.bm.OperHabiTalonarioAjuStk;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.da.DBCompoStkTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoStkTalonarioAjuStk extends FactoryObjetoLogico {

  public FactoryCompoStkTalonarioAjuStk() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoStkTalonarioAjuStk compostktalonarioajustk = (CompoStkTalonarioAjuStk) objLog;
    compostktalonarioajustk.setOID(db.getInteger(DBCompoStkTalonarioAjuStk.OID_COMPO_STK_AJU));
    compostktalonarioajustk.setOper_habi_tal_ajustk(OperHabiTalonarioAjuStk.findByOidProxy(db.getInteger(DBCompoStkTalonarioAjuStk.OID_OPER_AJU_STK),getSesion()));
    compostktalonarioajustk.setTipo_conf_mov_tal(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBCompoStkTalonarioAjuStk.OID_TIPO_CONF_MOV),getSesion()));
    compostktalonarioajustk.setUsar_por_defecto(db.getBoolean(DBCompoStkTalonarioAjuStk.USAR_POR_DEFECTO));

  }
}
